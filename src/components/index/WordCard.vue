<template>
	<div class="wordCard">
		<div>
			<div>
				<span>{{item.word}}</span>
				<span>{{item.pronunciation}}</span>
			</div>
			<div>{{item.chinese_translation}}</div>
		</div>
		<van-button type="primary" plain class="upbtn" size="mini" round @click="up">修改</van-button>
		<van-button type="info" plain class="delbtn" size="mini" round @click="del">删除</van-button>
	</div>
</template>

<script>
	export default {
		props: ["item", "index"],
		data() {
			return {

			}
		},
		methods: {
			up(){
				sessionStorage.setItem("word",JSON.stringify(this.item))
				this.$router.replace("/up");
			},
			del() {
				var params = new URLSearchParams();
				params.append("id", this.item.id);
				params.append("uid", this.item.uid);
				var that = this;
				this.$axios.post("/api/word/del", params).then(res => {
					if (res.data.code == 200) {
						that.$parent.$parent.$parent.list.splice(that.index, 1);
					}
					that.$toast(res.data.msg);
				});
			}
		}
	}
</script>

<style>
	.wordCard {
		position: relative;
		background: white;
		width: 90%;
		padding: 10px;
		margin: 10px auto;
		background-color: #f8f8f8;
	}

	.wordCard>div>div {
		margin: 5px auto;
	}

	.wordCard>div>div>span {
		margin-right: 10px;
	}


	.delbtn {
		position: absolute;
		right: 10px;
		top: 55%
	}
	.upbtn {
		position: absolute;
		right: 10px;
		top: 15%
	}
</style>
