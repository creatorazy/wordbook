<template>
	<van-pull-refresh v-model="refreshing" @refresh="onRefresh" style="height: 90%;overflow: auto;" animation-duration="1000">
		<van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad" style="height: 100%;">
			<word-card v-for="(item,index) in list" :key="index" :item="item" :index="index"></word-card>
		</van-list>
	</van-pull-refresh>
</template>

<script>
	import wordCard from "./WordCard.vue"
	export default {
		components: {
			wordCard
		},
		data() {
			return {
				list: [],
				loading: false,
				finished: false,
				refreshing: false,
				page: 1,
				limit: 100,
			};
		},
		methods: {
			onLoad() {
				setTimeout(() => {
					var that = this;
					var params = new URLSearchParams();
					params.append("id", sessionStorage.getItem("id"));
					params.append("page", this.page);
					params.append("limit", this.limit);
					this.$axios.post("/api/word/query", params).then(res => {
						if (that.refreshing) {
							that.list = [];
							this.refreshing = false;
						}
						if (res.data.code == 200) {
							for (var i = 0; i < res.data.data.words.length; i++) {
								that.list.push(res.data.data.words[i]);
							}
							that.loading = false;
							if (that.list.length >= res.data.data.wordCount) {
								that.finished = true;
								return;
							}
						}
					});
				}, 500);
			},
			onRefresh() {
				// 清空列表数据
				this.finished = false;
				// 重新加载数据
				// 将 loading 设置为 true，表示处于加载状态
				this.loading = true;
				this.onLoad();
			},
		},
	};
</script>
