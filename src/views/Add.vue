<template>
	<van-swipe-cell class="cell" ref="left">
		<div style="height: 100%;">
			<van-nav-bar title="添加单词信息" class="navbar" @click-left="back" fixed placeholder>
				<template #left>
					<van-icon name="arrow-left" size="18" color="#ffffff" />返回
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
	import mainView from "../components/add/MainView.vue"
	import letfView from "../components/index/LetfView.vue"
	var methods = {
		back() {
			this.$router.replace("/")
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
