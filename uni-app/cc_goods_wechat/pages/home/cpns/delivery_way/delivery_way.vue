<template>
	<view class="delivery-way common_bg">
		<view class="delivery">
			<image src="@/static/img/delivery.png" class="banner-img" />
			<view>配送</view>
		</view>
		<view class="self">
			<image src="@/static/img/self.png" class="banner-img" @click="toMenuClick(1)" />
			<view>自提</view>		
		</view>
	</view>
</template>

<script lang="ts" setup>
import { useStore } from '@/store'
const store = useStore()
const toMenuClick = (type: number) => {
	uni.navigateTo({
	  url: `/pages/menu/menu?type=${type}`
	})
	
}
</script>

<style lang="less" scoped>
	.delivery-way {
		height: 280rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		
		.delivery, .self {
			display: inline-block;
			text-align: center;
			margin: 0 auto;
		}
	}
</style>
