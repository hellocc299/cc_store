<template>
	<view class="user-info common_bg">
		<view class="avatar">
			<image src="https://img.yzcdn.cn/vant/cat.jpeg" class="avatar-img" mode="aspectFill" />
		</view>
		<view class="info">
			<view class="self-info">
				<view class="name">阿白</view>
				<view class="vip-type">青铜会员</view>
			</view>
			<view class="growth">
				<view class="percentage">
					<van-progress 
					color="#EA7246" 
					:percentage="percentage" 
					:show-pivot="false" 
					class="custom-percentage"
					stroke-width="9" />
					<view class="show-percentage">{{ growth }}/{{ allGrowth }}</view>
				</view>
			</view>
			<view class="growth-detail">
				升至Lv2还需 {{ allGrowth - growth }} 成长值>
			</view>
		</view>
	</view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
let growth = ref(59.8)
let allGrowth = ref(1000)
let percentage = (growth.value / allGrowth.value) * 100
percentage = parseFloat(percentage.toFixed(2))
</script>

<style lang="less" scoped>
.user-info {
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 300rpx;
	
	.avatar {
		height: 200rpx;
		width: 200rpx;
		
		.avatar-img {
			max-height: 100%;
			max-width: 100%;
			border-radius: 50%;
		}
	}
	
	.info {
		width: 400rpx;
		
		.vip-type {
			display: inline-block;
			margin-left: 20rpx;
			background-color: #EA7246;
			color: #fff;
			height: 40rpx;
			width: 130rpx;
			line-height: 40rpx;
			border-radius: 10rpx;
			font-size: 26rpx;
			text-align: center;
		}
	}
	
	.growth {
		margin-top: 20rpx;
		
		
		.percentage {
			display: flex;
			justify-content: space-between;
			
			.custom-percentage {
				margin-top: 8rpx;
				width: 68% !important;
			}
			
			.show-percentage {
				font-size: 24rpx;
				color: #979797;
			}
		}
	}
	
	.growth-detail {
		margin-top: 10rpx;
		font-size: 26rpx;
		color: #979797;
	}
}

.avatar, .info, .name, .vip-type, .custom-percentage, .show-percentage {
	display: inline-block;
}
</style>
