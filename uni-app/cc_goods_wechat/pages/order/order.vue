<template>
	<view class="order bgc">
		<van-tabs :active="active">
		  <van-tab title="我的订单">
				<all />
			</van-tab>
		  <van-tab title="积分订单">内容 2</van-tab>
		  <van-tab title="活动订单">内容 3</van-tab>
		</van-tabs>
	</view>
</template>

<script setup>
import { ref } from 'vue'
import All from './page/all/all.vue'
const active = ref(0);
</script>

<style lang="less" scoped>
.order {
	height: 100vh;
	overflow-y: auto;
}
</style>
