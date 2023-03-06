<template>
	<view class="user-info common_bg">
		<view v-if="!accessToken" @click="login()" class="banner">
			<view>登录以获得更好的体验！</view>
			<view class="login">登录</view>
		</view>
		<view v-else class="banner">
			<view class="left">
				<view class="avatar">
					<image :src="userInfo.avatarUrl" mode="aspectFill" class="avatar-img" />
				</view>
				<view class="nickName">{{ userInfo.nickName }}</view>
			</view>
			<view class="growth">
				积分：{{ formatPrice(userInfo.growth) }}
			</view>
		</view>
	</view>
	
</template>

<script setup lang="ts">
import {useStore} from 'vuex'
import {computed} from 'vue'
import { formatPrice } from '@/utils/format'

const store = useStore()

const accessToken = computed(() => store.state.login.accessToken)
const userInfo = computed(() => store.state.login.userInfo)
const avatarUrl = computed(() => store.state.login.userInfo.avatarUrl)
const nickName = computed(() => store.state.login.userInfo.nickName)

const getUserProfile = () => {
	return new Promise((resolve, reject) => {
		uni.getUserProfile({
			desc: '获取你的昵称、头像及地区',
			success: userRes => {
				resolve(userRes);
			},
			fail: userErr => {
				uni.showToast({
					title: '授权失败',
					icon: 'error'
				});
				reject(userErr);
			}
		});
	});
}
const getLoginCode = () => {
	return new Promise((resolve, reject) => {
		uni.login({
			provider: 'weixin',
			success: loginRes => {
				resolve(loginRes);
			}
		});
	});
}
	
const login = () => {
	let userProFile = getUserProfile();
	let loginCode = getLoginCode();
	loginCode
		.then(code => {
			return code;
		})
		.then((logCode: any) => {
			return new Promise((resolve, reject) => {
				userProFile
					.then((res: any) => {		
						const code = logCode.code
						const avatarUrl = res.userInfo.avatarUrl
						const nickName = res.userInfo.nickName
						store.dispatch('login/wxLoginAction', { code, avatarUrl, nickName })
						resolve(res);
					})
					.catch(err => {
						reject(err);
					});
			});
		})
		.catch(err => {
			console.log('userProfile-err', err);
		});
}

</script>

<style lang="less" scoped>
	.user-info {
		height: 120rpx;
		line-height: 120rpx;
		
		.banner {
			display: flex;
			justify-content: space-between;
			text-align: center;
			align-items: center;
			padding: 0 50rpx;
		}
		
		.login {
			background-color: #EA7246;
			color: #fff;
			height: 60rpx;
			width: 130rpx;
			line-height: 60rpx;
			border-radius: 10rpx;
		}
		
	  .left {
			width: 160rpx;
			display: flex;
			justify-content: space-between;
			
			.avatar {
				height: 80rpx;
				width: 80rpx;
				margin-top: 20rpx;
				
				.avatar-img {
					max-height: 100%;
					max-width: 100%;
					border-radius: 50%;
				}
				
				.nickName {
					
				}
			}
		}
		
		.growth {
			height: 100%
		}
	}
</style>