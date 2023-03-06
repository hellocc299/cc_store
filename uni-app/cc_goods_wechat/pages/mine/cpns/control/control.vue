<template>
	<view class="control common_bg">
		<view class="control-item">
			<view class="title">地址管理</view>
			<view class="handle">></view>
		</view>
		<view class="control-item">
			<view class="title">联系客服</view>
			<view class="handle">></view>
		</view>
		<view class="control-item special">
			<view class="title">版本</view>
			<view class="handle special-font">v3.2.0</view>
		</view>
	</view>
</template>

<script lang="ts" setup>
</script>

<style lang="less" scoped>
.control {
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	height: 340rpx;
	margin-top: 30rpx;
	
	.control-item {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin: 0 30rpx;
		border-bottom: 1px solid #F4F3F3;
		font-size: 30rpx;
		padding-bottom: 30rpx;
		
		.title, .handle {
			display: inline-block;
			padding: 0 20rpx
		}
	}
	
	.special {
		border: none !important;
		padding-bottom: 16rpx;
		
		.special-font {
			color: #979797;
		}
	}
}
</style>
