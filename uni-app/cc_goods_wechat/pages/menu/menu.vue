<template>
	<view class="menus">
		<!-- 左侧tabs -->
		<view class="tabs">
			<view class="tab alldisplay">
				<view class="img">
					<image src="@/static/img/search.png" />
				</view>
				<view style="margin-top: 14rpx;">搜索</view>
			</view>
			<view class="tab alldisplay" 
						:class="item.classifyId == current ? 'active' :''" 
						@click="select(item)" 
						v-for="(item) in classifyList" 
						:key="item.classifyId" >
				<view class="img">
					<image :src="item.imgUrl" />
				</view>
				<view style="margin-top: 14rpx;">{{ item.name }}</view>
			</view>
		</view>
		<!-- 右侧cont -->
		<scroll-view scroll-y="true" style="height: 100vh;" class="left">
			<view class="conts">
				<view class="cont" v-for="item in goodsList"  :key="item.goodsId">
					<view class="goods-item">
						<view class="goods-img">
							<image :src="item.goodsImg.imgUrl" mode="aspectFill" />
						</view>
						<view class="goods-content">
							<view style="font-size: 34rpx; font-weight: 500;">{{ item.name }}</view>
							<view style="font-size: 30rpx; font-weight: 300; color: #737373;">{{ item.description }}</view>
							<view class="price-car">
								<view style="color: #EA7246;font-size: 30rpx;font-weight: 500;">¥ {{ formatPrice(item.price) }}</view>
								<view class="insert-btn">
									<image src="@/static/img/add.png" />
								</view>
							</view>
						</view>
					</view>
				</view>
			</view>
		</scroll-view>
		<!-- 底部购物车 -->
		<view class="shop-car" @click="showDetail()">
			<view>
				<view class="img">
					<image src="@/static/img/gouwudai.png"/>
				</view>
				<view>共计：¥</view>
			</view>
		</view>
		<van-popup :show="show"
								closeable
								close-icon="close"
								position="bottom"
								custom-style="height: 20%">
		</van-popup>
	</view>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { onLoad } from '@dcloudio/uni-app'
import { useStore } from '@/store'
import cache from '@/utils/cache'
import { formatPrice } from '@/utils/format'

const store = useStore()

onLoad(() => {
	store.dispatch('classify/getClassifyListAction')
})
const classifyList = cache.getCache("classifyList")
const current = ref(classifyList[0].classifyId)

const getContList = (id: number) => {
	store.dispatch('goods/getGoodsListByIdAction', id)
}
getContList(current.value)

const goodsList = computed(() => store.state.goods.goodsList)

const select = (item: any) => {
	current.value = item.classifyId
	getContList(current.value)
}

const show = ref(false)
const showDetail = () => {
	show.value = true
}
</script>

<style lang="less" scoped>
page{
	width: 100%;
}
.tabs{
	width: 28%;
	min-height: 100vh;
	display: flex;
	flex-direction: column;
	background-color: #f2f2f2;
	
	.alldisplay {
		align-items: center;
		text-align: center;
		font-weight: 400;
		color: #4b4b4b;
	}
	
	.img {
		height: 80rpx;
		width: 80rpx;
		margin: 0 auto;
		margin-top: 20rpx;
		
		image {
			max-height: 100%;
			max-width: 100%;
		}
	}

}
.tab{
	width: 100%;
	height: 180rpx;
	border-bottom: #cccccc 1rpx solid;
}
.conts{
	width: 100%;
	min-height: 10vh;
	padding: 26rpx;
	box-sizing: border-box;
	font-size: 20rpx;
	display: flex;
	flex-wrap: wrap;
}
.active{
	background: #fff;
	border-radius: 10rpx;
	border-bottom: none;
	box-shadow: 0 6rpx 6rpx 0 rgba(0, 0, 0, 0.08);
}
.cont{
	width: 100%;
	height: 200rpx;
	margin: 0 20rpx 60rpx 0;
}
.menus{
	display: flex;
}
.goods-item {
	weight: 100%;
	height: 200rpx;
	
	.goods-img {
		display: inline-block;
		
		image {
			height: 200rpx;
			width: 200rpx;
			border-radius: 20rpx;
		}
	}
	
	.goods-content {
		display: inline-block;
		height: 100%;
		margin-left: 20rpx;
		
		.price-car {
			width: 100%;
			display: flex;
			flex: 1;
			margin-top: 80rpx;
			
			.insert-btn {
				height: 50rpx;
				width: 50rpx;
       	margin-left: 150rpx;				
				image {
					max-height: 100%;
					max-width: 100%;
				}
			}
		}
	}
}
.shop-car {
	position: fixed;
	height: 200rpx;
	width: 100%;
	background-color: #ffffff;
	bottom: 0;
	border-top: #cccccc 1rpx solid;
}
</style>