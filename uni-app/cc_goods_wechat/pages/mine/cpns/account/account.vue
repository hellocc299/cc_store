<template>
	<view class="account common_bg">
		<view class="account-item">
			<view class="number">{{ balance }}</view>
			<view class="name">预存余额</view>
		</view>
		<view class="account-item">
			<view class="number">{{ card }}</view>
			<view class="name">卡券</view>
		</view>
		<view class="account-item">
			<view class="number">{{ integral }}</view>
			<view class="name">积分账户</view>
		</view>
	</view>
</template>

<script setup lang="ts">
import { ref } from 'vue'
let balance = ref('0.00')
let card = ref('0')
let integral = ref('53.80')
</script>

<style lang="less" scoped>
.account {
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 150rpx;
	margin-top: 30rpx;
	
	.account-item {
		display: inline-block;
		text-align: center;
		
		.number {
			font-weight: 700;
		}
		
		.name {
			margin-top: 8rpx;
			font-size: 28rpx;
			color: #979797;
		}
	}
}
</style>
