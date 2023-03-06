<template>
	<view class="order-item common_bg">
		<view class="header">
			{{ deliveryType }}｜#{{ orderItem.orderNum }}号单
		</view>
		<view class="overall addr-statu">
			<view class="addr">门店：CC烘焙屋</view>
			<view class="statu">{{ statu }}</view>
		</view>
		<view class="order-image" @click="orderItemClick(orderItem.orderCode)">
			<!-- 后改超过三个设置显示更多标志 -->
			<template v-for="(item, index) in orderItem.orderDetail" :key="item.id">
				<image :src="item" />
			</template>
		</view>
		<view class="overall time-count">	
			<view class="time">{{ handleTime(orderItem.startTime) }}</view>
			<view class="count">共{{ orderItem.allAmount }}件 实付：¥ {{ orderItem.totalPrice }}</view>
		</view>
		<view class="overall delivery-delete">
			<view class="delivery">获得{{ orderItem.delivery }}积分</view>
			<van-button round size="normal" hairline @click="deleteClick(orderItem.o_id)">删除</van-button>
		</view>
	</view>
</template>

<script lang="ts" setup>
	import { defineProps, defineEmits, PropType, ref } from 'vue'
	import { OrderListType } from './config/order_type'
	const props = defineProps({
		orderItem: {
			type: Object as PropType<OrderListType>,
			require: true
		}
	})
	let statu = ref('');
	let deliveryType = ref('')
	switch(props.orderItem.deliveryType) {
		case 0: 
			deliveryType.value = '自提' 
		break;
		case 1:
			deliveryType.value = '配送'
		break;
		default: ;
	}
	switch(props.orderItem.status) {
		case 0: 
			statu.value = '已下单' 
		break;
		case 1:
			statu.value = '订单取消'
		break;
		case 2:
			statu.value = '已退款'
		break;
		case 3:
			statu.value = '已完成'
		break;
		default: ;
	}
	const handleTime = (time: string) => {
		return time.substring(0, 10)
	}
	const deleteClick = (oId: number) => {
		console.log(`${oId}正在被删除`);
	}
	const orderItemClick = (orderCode: string) => {
		uni.navigateTo({
		  url: `/pages/order_detail/order_detail?orderCode=${orderCode}`
		})
	}
</script>

<style lang="less" scoped>
.order-item {
	height: 450rpx;
	
	.header {
		height: 45rpx;
		width: 200rpx;
		border-top-left-radius: 20rpx;
		border-bottom-right-radius: 20rpx;
		background-image: linear-gradient(to right, #e53828, #f5aa4b);
		font-size: 28rpx;
		text-align: center;
		line-height: 45rpx;
		font-weight: 500;
		color: #fff;
	}
	
	.addr-statu {
		margin: 14rpx auto;
		.addr, .statu {
			display: inline-block;
		}
		.statu {
			color: #EA7246;
		}
	}

	.order-image {
		margin: 14rpx auto;
		width: 86%;
		
		image {
			width: 180rpx;
			height: 150rpx;
			border-radius: 10%;
			margin-right: 20rpx;
		}
	}
	
		
	.time-count {
		margin: 14rpx auto;
		
		.time {
			color: #737373;
			font-size: 26rpx;
		}
		
		.count {
			font-weight: 600;
		}
	}

	.delivery-delete {
		margin: 14rpx auto;
		
		.delivery {
			text-align: center;
			line-height: 70rpx;
		}
		
		.van-button {
			width: 40rpx;
		}
	}
}

.overall {
	display: flex;
	justify-content: space-between;
	width: 86%;
}

</style>
