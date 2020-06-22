<template>
	<div style="height: 100%;">
		<div class="header">
			<div class="mian">
				<h1>单词本</h1>
				<span>English Word Book</span>
			</div>
		</div>
		<!-- 居中 -->
		<van-row type="flex" justify="center" class="login">
			<van-col span="20">
				<van-form>
					<van-field v-model="username" name="username" label="用户名" placeholder="用户名" left-icon="manager" maxlength="20" />
					<van-field v-model="password" type="password" name="password" label="密码" placeholder="密码" left-icon="lock"
					maxlength="20" />
					<van-field v-model="password2" type="password" name="password" label="确认密码" placeholder="密码" left-icon="lock"
					maxlength="20" />
					<van-field v-model="tel" type="text" name="number" label="电话号码" placeholder="请输入11电话号码" left-icon="lock" maxlength="20" />
				</van-form>
			</van-col>
		</van-row>
		<van-row type="flex" justify="center" class="ft">
			<van-col span="20">
				<div style="margin: 16px;">
					<van-button round block type="info" color="#42B983" @click="onSubmit">
						注册
					</van-button>
				</div>
				<div>
					<span class="mob" @click="toUrl(1)">手机号登陆</span>
					<span class="pwd" @click="toUrl(2)">密码登陆</span>
				</div>
			</van-col>
		</van-row>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				username: '',
				password: '',
				password2: '',
				tel: ''
			};
		},
		methods: {
			toUrl(i){
				if(i==1){
					this.$toast("功能暂未开放")
				}else if(i==2){
					sessionStorage.removeItem("id");
					sessionStorage.removeItem("name");
					sessionStorage.removeItem("img");
					this.$router.replace("/login")
				}
			}
			,
			onSubmit() {
				if (this.username.length < 5 || this.username.length > 20 || this.password.length < 5 || this.password.length > 20) {
					this.$toast('用户名或密码输入长度不符合规范');
					return;
				}
				if (this.password != this.password2) {
					this.$toast('两次密码输入不一致');
					return;
				}
				this.$toast.loading({
					duration: 0, // 持续展示 toast
					forbidClick: true,
					message: '正在注册....',
				});
				var params = new URLSearchParams();
				params.append("name", this.username);
				params.append("password", this.password);
				params.append("tel", this.tel);
				this.$axios.post("/api/user/reg", params).then(res => {
					this.$toast.clear();
					this.$dialog.alert({
							title: '注册结果',
							message: res.data.msg,
							confirmButtonText:'去登陆'
						})
						.then(() => {
							sessionStorage.removeItem("id");
							sessionStorage.removeItem("name");
							sessionStorage.removeItem("img");
							this.$router.replace("/login")
						});
				}).catch(() => {
					this.$toast.clear();
					this.$toast("请检查网络是否连接");
				})
			},
		},
	};
</script>

<style>
	.header {
		width: 100%;
		height: 30%;
		text-align: center;
		background-color: #42B983;
		display: flex;
	}

	.header div {
		width: 50%;
		margin: 0px auto;
		text-align: center;
		align-self: center;
	}

	.header h1 {
		border-radius: 5px;
		margin: 10px 0px;
		background-color: white;
	}

	.header span {
		color: white;
	}

	.login {
		background-color: #f7f8fa;
		height: 50%;
	}

	.login>div {
		padding-top: 10%;
	}

	.ft {
		height: 20%;
		background-color: #f7f8fa;
	}

	.mob {
		float: left;
		color: #1989fa;
		margin-left: 10px;
	}

	.pwd {
		float: right;
		color: #1989fa;
		margin-left: 10px;
	}
</style>
