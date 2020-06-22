<template>
	<van-swipe-cell class="cell" ref="left">
		<div style="height: 100%;">
			<van-nav-bar title="我的单词本" right-text="添加单词" class="navbar" @click-left="menuClick" @click-right="toAdd" fixed placeholder>
				<template #left>
					<van-icon name="bars" size="18" color="#ffffff" />
				</template>
			</van-nav-bar>
			<main-view></main-view>
		</div>
		<template #left>
			<letf-view style="width: 200px;"></letf-view>
		</template>
	</van-swipe-cell>
</template>
<script>
	import mainView from "../components/index/MainView.vue"
	import letfView from "../components/index/LetfView.vue"
	var methods = {
		toAdd(){
			this.$router.replace("/add")
		},
		menuClick(event) {
			event.stopPropagation();
			if (this.$refs["left"].offset) {
				this.$refs["left"].close();
				return;
			}
			this.$refs["left"].open('left');
		}
	}
	export default {
		components: {
			mainView,letfView
		},
		methods
	}
</script>
<style>
	.cell,
	.cell>div,
	.navbar {
		height: 100%;
	}

	.navbar div {
		background-color: #42B983 !important;
		color: white;
	}

	.navbar>div>div>span {
		color: white;
	}
</style>
