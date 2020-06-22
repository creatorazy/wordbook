<template>
	<van-form @submit="onSubmit">
		<van-field v-model="word" name="word" label="单词" placeholder="请输入单词" />
		<van-field v-model="pronunciation" type="text" name="pronunciation" label="音标" placeholder="请输入音标" />
		<van-field v-model="chinese_translation" type="text" name="chinese_translation" label="中文翻译" placeholder="请输入中文翻译" />
		<div style="margin: 16px;">
			<van-button round block type="primary" native-type="submit">
				添加
			</van-button>
		</div>
	</van-form>
</template>

<script>
	export default {
		data() {
			return {
				word: '',
				pronunciation: '',
				chinese_translation: '',
			};
		},
		methods: {
			onSubmit(values) {
				console.log('submit', values);
				if (this.word == '' || this.pronunciation == '' || this.chinese_translation == '') {
					this.$toast("选项不能为空");
					return;
				}
				var params = new URLSearchParams();
				params.append("uid", sessionStorage.getItem("id"));
				params.append("word", values.word);
				params.append("pronunciation", values.pronunciation);
				params.append("chinese_translation", values.chinese_translation);
				this.$axios.post("/api/word/add", params).then(res => {
					this.$toast.clear();
					if (res.data.code == 200) {
						this.$toast.success('添加单词成功');
						this.word = '';
						this.pronunciation = '';
						this.chinese_translation = '';
					} else {
						this.$toast.fail('添加单词失败');
					}
				}).catch(() => {
					this.$toast.clear();
					this.$toast.fail('添加单词失败');
				})
			},
		},
	};
</script>

<style>
</style>
