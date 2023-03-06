<template>
	<view class="order-detail bgc">
		<view class="header">
			<view class="order-type">
				<view class="order-statu">#{{ orderDetailItem1.orderNum }}号单</view>
				<view class="type">{{ statu }}</view>
				<view class="content">{{ content }}</view>
			</view>
			<image src="@/static/img/order_finish.png" />
		</view>
		<view class="address common_bg">
				<image src="@/static/img/address.png" />
				<view class="address-detail">
					<view class="address-info">{{ orderDetailItem1.address }}</view>
					<view class="linkman">{{ orderDetailItem1.linkman }} 女士   {{ orderDetailItem1.phoneNum }}</view>
			</view>
		</view>
		<view class="order common_bg">
			<template v-for="(item, index) in orderDetailItem1.orderDetail" :key="orderDetailItem1.orderCode">
				<view class="order-info">
					<view class="info">
						<view class="image">
							<image :src="item.image" />
						</view>
						<view class="detail" style="margin-left: 20rpx;">
							<view class="name" style="margin-bottom: 20rpx; font-weight: 500;">{{ item.name }}</view>
							<view style="color: #f75343; font-weight: 600;">¥ {{ item.finalPrice }}</view>
						</view>
					</view>
					<view style="color: #737373;">x{{ item.amount }}</view>
				</view>
				<br style="clear:both;" />
			</template>
			
		</view>
		<view class="price common_bg">
			<van-cell-group :border="0">
			  <van-cell title="获得积分" :border="0">{{ parseFloat(orderDetailItem1.integral).toFixed(0) }}积分</van-cell>
				<van-cell title="商品金额" :border="0">¥ {{ orderDetailItem1.originPrice }}</van-cell>
				<van-cell title="配送费" :border="0">+¥ {{ orderDetailItem1.delivery }}</van-cell>
				<van-cell title="店铺活动" :border="0">-¥ {{ orderDetailItem1.totalDiscount }}</van-cell>
				<van-cell title="实付金额" :border="0">¥ {{ orderDetailItem1.totalPrice }}</van-cell>
			</van-cell-group>
		</view>
		<view class="order-type common_bg">
			<van-cell-group :border="0">
			  <van-cell title="下单门店" :border="0">cc烘焙屋</van-cell>
				<van-cell title="订单类型" :border="0">{{ orderType }}</van-cell>
			</van-cell-group>
		</view>
		<view class="order-time common_bg">
			<van-cell-group :border="0">
			  <van-cell title="订单编号" :border="0">{{ orderDetailItem1.orderCode }}</van-cell>
				<van-cell title="下单时间" :border="0">{{ orderDetailItem1.startTime }}</van-cell>
				<van-cell title="下单时间" :border="0">{{ orderDetailItem1.payTime }}</van-cell>
			</van-cell-group>
		</view>
	</view>
</template>

<script setup lang="ts">
	import { onLoad } from '@dcloudio/uni-app';
	import { orderDetailItem1, orderDetailItem2 } from './order_detail_config'
	onLoad(oId => { 
		// service to get item with oId
		console.log(oId)
	})
	
	let statu = ''
	let content = ''
	switch(orderDetailItem1.status) {
		case 0:
			statu = '订单正在制作'
			content = '订单正在制作，请耐心等待！'
		break;
		case 1:
			statu = '订单已取消'
			content = '订单已经取消，欢迎再次光临！'
		break;
		case 2:
			statu = '订单已完成'
			content = '订单已经完成，欢迎再次光临！'
		break;
		case 3:
			statu = '订单已完成'
			content = '感谢您的购买，欢迎再次光临！'
		break;
	}
	let orderType = ''
	switch(orderDetailItem1.type) {
		case 0:
			orderType = '配送上门'
		break;
		case 1:
			orderType = '到店自提'
		break;
	}
</script>

<style lang="less" scoped>
	.order-detail {
		height: 100vh;
		overflow-y: auto;
		
		.header {
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding: 0 30rpx;
			background-color: #fff;
			height: 200rpx;
			
			.order-type {
				.order-statu, .type {
					display: inline-block;
				}
				
				.type {
					height: 60rpx;
					font-size: 44rpx;
					// top: 16rpx;
					margin-top: 18rpx;
				  margin-left: 14rpx;
					font-weight: 700;
				}
				
				.order-statu {
					background-color: #e53828;
					color: #fff;
					height: 42rpx;
					width: 100rpx;
					line-height: 42rpx;
					border-radius: 30rpx;
					font-size: 28rpx;
					text-align: center;
					margin-bottom: 10rpx;
				}
				
				.content {
					margin-top: 22rpx;
					font-size: 24rpx;
					color: #737373;
				}
			}
			
			image {
				height: 100%;
				width: 180px;
			}
		}
	
		.address {
			height: 250rpx;

			.address-detail {
				display: inline-block;
				margin-left: 20rpx;
				width: 80%;
				word-break: break-all;
				word-wrap: break-word;
				
				.linkman {
					margin-top: 48rpx;
					color: #737373;
					font-weight: 500;
				}
			}		
			
			image {
				margin: 32rpx 0 150rpx 20rpx;
				height: 40rpx;
				width: 40rpx;
			}
		}
	
		.order {
			height: auto;
			padding: 10rpx 0;
			
			.order-info {
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin: 40rpx 30rpx;
				
				.info {
					display:flex;
					align-items:center;
					
					.image {
						display:flex;
						align-items:center;
					}
					
					image {
						width: 150rpx;
						height: 120rpx;
						border-radius: 10%;
					}
				}

				.detail {
					display: inline-block;
				}
			}
		}

		.price {
			height: 320rpx;
		}
	
		.order-type {
			height: 160rpx;
		}
		
		.order-time {
			height: 200rpx;
		}
	}
	/deep/ .van-cell {
		padding: var(--cell-vertical-padding,4px) var(--cell-horizontal-padding,16px) !important;
	}
	
	/deep/ .van-cell__title {
		color: #737373;
		// font-weight: 500;
	}
	
	/deep/ .van-cell__value {
		color: #000;
	}
	
	/deep/ .van-cell-group {
		padding: 20rpx;
	}


</style>
