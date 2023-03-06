<template>
	<view class="collect common_bg">
		<image src="@/static/img/gift.png" class="gift" />
		<view class="dept">
			<view class="title">集赠活动</view>
			<view class="content">达到消费要求即可免费领取对应产品</view>
		</view>
		<view class="detail">查看详情</view>
	</view>
</template>

<script>
</script>

<style lang="less" scoped>
	.collect {
		height: 180rpx;
		display: flex;
		align-items: center;
		justify-content: space-around;
		
		
		.gift {
			height: 80rpx;
			width: 80rpx;
		}
		
		.dept {
			width: 54%;
			.title {
				font-size: 40rpx;
				font-weight: 600;
			}
			.content {
				font-size: 26rpx;
				white-space: wrap;
				color: #979797;
			}
		}
		
		.detail {
			background-color: #EA7246;
			color: #fff;
			height: 60rpx;
			width: 130rpx;
			line-height: 60rpx;
			border-radius: 10rpx;
			font-size: 28rpx;
			text-align: center;
		}

	}
</style>