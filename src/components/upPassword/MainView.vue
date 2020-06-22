<template>
	<van-form @submit="onSubmit">
		<van-field v-model="password" type="password" name="password" label="密码" placeholder="请输入密码(5-20)" />
		<van-field v-model="password2" type="password" name="password2" label="确认密码" placeholder="请再次输入密码(5-20)" />
		<div style="margin: 16px;">
			<van-button round block type="primary" native-type="submit">
				修改密码
			</van-button>
		</div>
	</van-form>
</template>

<script>
	export default {
		data() {
			return {
				password: '',
				password2: ''
			};
		},
		methods: {
			onSubmit(values) {
				console.log('submit', values);
				if (this.password == '' || this.password2 == '') {
					this.$toast("选项不能为空");
					return;
				}
				if (this.password.length < 5 || this.password.length > 20) {
					this.$toast("密码长度不符合规范");
					return;
				}
				if (this.password != this.password2) {
					this.$toast("两次密码不一致");
					return;
				}
				var params = new URLSearchParams();
				params.append("id", sessionStorage.getItem("id"));
				params.append("password", values.password);
				this.$axios.post("/api/user/up", params).then(res => {
					this.$toast.clear();
					if (res.data.code == 200) {
						this.$dialog.alert({
								title: '修改结果',
								message: res.data.msg,
								confirmButtonText: '重新登陆'
							})
							.then(() => {
								sessionStorage.removeItem("id");
								sessionStorage.removeItem("name");
								sessionStorage.removeItem("img");
								this.$router.replace("/login")
							});
					} else {
						this.$toast.fail('修改密码失败');
					}
				}).catch(() => {
					this.$toast.clear();
					this.$toast.fail('修改密码失败');
				})
			},
		},
	};
</script>

<style>
</style>
