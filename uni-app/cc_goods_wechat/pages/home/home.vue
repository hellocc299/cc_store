<template>
	<view class="home bgc">
		<view class="top-swiper">
			<swiper class="swiper-auto">
				<swiper-item>
					<image src="@/static/img/test_bg_swiper.jpg"  class="swiper-img" mode="auto" />
				</swiper-item>
			</swiper>
		</view>
		
		<delivery-way />
		<user-info />
		<collect />
		
	</view>
</template>

<script setup>
import DeliveryWay from './cpns/delivery_way/delivery_way.vue'
import UserInfo from './cpns/user_info/user_info.vue';
import Collect from './cpns/collect/collect.vue'
</script>

<style lang="less">
.home {
	position: relative;
	height: 100vh;
	
	.swiper-auto {
		height: 400rpx;
		
		.swiper-img {
			width: 100%;
			height: 100%;
			position: fixed;
		}
	}

	.banner-img {
		width: 100rpx;
		height: 100rpx;
	}
}

</style>
