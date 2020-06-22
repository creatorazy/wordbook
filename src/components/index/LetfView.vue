<template>
	<div>
		<div class="imgdiv">
			<van-image round width="5rem" height="5rem" :src="img" />
		</div>
		<div class="user">
			<h4>{{name}}</h4>
		</div>
		<div class="listli">
			<li onMouseDown="this.className='mouseDownColor'" onMouseUp="this.className=''" @click='toUpPassword'>
				<van-icon name="lock" size="1.5rem" /><span>修改密码</span>
			</li>
			<li onMouseDown="this.className='mouseDownColor'" onMouseUp="this.className=''" @click='quit'>
				<van-icon name="close" size="1.5rem" /><span>安全退出</span>
			</li>
		</div>
	</div>
</template>

<script>
	export default {
		data(){
			return{
				name:sessionStorage.getItem("name"),
				img:sessionStorage.getItem("img")
			}
		},
		methods: {
			toUpPassword(){
				this.$router.replace("/upPwd");
			},
			quit() {
				let that = this;
				var params = new URLSearchParams();
				params.append("id",Number(sessionStorage.getItem("id")));
				this.$axios.post("/api/user/logout", params).then(res => {
					if (res.data.code == 200) {
						sessionStorage.removeItem("id");
						sessionStorage.removeItem("name");
						sessionStorage.removeItem("img");
						that.$router.replace('/login');
					} else {
						that.$toast(res.data.msg);
					}
				})
			}
		}
	}
</script>

<style>
	.imgdiv {
		text-align: center;
		margin: 20px 10px 0px 10px;
	}

	.user {
		text-align: center;
	}

	.listli>li {
		list-style-type: none;
		margin: 20px 20px 20px 30px;
	}

	.mouseDownColor {
		color: #42B983;
	}

	.listli i {
		vertical-align: middle;
		margin-right: 10px;
	}
</style>
