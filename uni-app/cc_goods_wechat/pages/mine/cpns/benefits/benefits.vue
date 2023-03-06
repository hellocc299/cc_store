<template>
	<view class="benefits common_bg">
		<view class="title">专属权益</view>
		<view class="benefits-content">
			<view class="benefits-item">
				<view class="benefits-img">
					<image src="@/static/img/coin.png" />
				</view>
				<view class="content">会员充值</view>
			</view>
			<view class="benefits-item">
				<view class="img">
					<image src="@/static/img/card.png" />
				</view>
				<view class="content">卡券中心</view>
			</view>
		</view>
	</view>
</template>

<script setup lang="ts">
</script>

<style lang="less" scoped>
.benefits {
	height: 320rpx;
	margin-top: 30rpx;
	
	.title {
		font-weight: 700;
		margin-top: 35rpx;
		margin-left: 35rpx;
	}
	
	.benefits-content {
		display: flex;
		justify-content: space-around;
		align-items: center;
		margin-top: 40rpx;
		
		.benefits-item {
			display: inline-block;
			text-align: center;
			height: 200rpx;
			width: 200rpx;
			
			image {
				height: 80rpx;
				width: 80rpx;
			}
			
			.content {
				margin-top: 10rpx;
			}
		}
	}
}
</style>
