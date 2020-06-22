<template>
	<van-form @submit="onSubmit">
		<input type="hidden" v-model="word.id" name="id">
		<van-field v-model="word.word" name="word" label="单词" placeholder="请输入单词" />
		<van-field v-model="word.pronunciation" type="text" name="pronunciation" label="音标" placeholder="请输入音标" />
		<van-field v-model="word.chinese_translation" type="text" name="chinese_translation" label="中文翻译" placeholder="请输入中文翻译" />
		<div style="margin: 16px;">
			<van-button round block type="primary" native-type="submit">
				修改
			</van-button>
		</div>
	</van-form>
</template>

<script>
	export default {
		data() {
			return {
				word: JSON.parse(sessionStorage.getItem("word"))
			};
		},
		methods: {
			onSubmit() {
				if (this.word.word == '' || this.word.pronunciation == '' || this.word.chinese_translation == '') {
					this.$toast("选项不能为空");
					return;
				}
				var params = new URLSearchParams();
				console.log(sessionStorage.getItem("word"))
				console.log(this.word);
				params.append("id", this.word.id);
				params.append("uid", this.word.uid);
				params.append("word", this.word.word);
				params.append("pronunciation", this.word.pronunciation);
				params.append("chinese_translation", this.word.chinese_translation);
				this.$axios.post("/api/word/up", params).then(res => {
					this.$toast.clear();
					if (res.data.code == 200) {
						this.$toast.success('修改单词信息成功');
					} else {
						this.$toast.fail('修改单词信息失败');
					}
				}).catch(() => {
					this.$toast.clear();
					this.$toast.fail('修改单词信息失败');
				})
			},
		},
	};
</script>

<style>
</style>
