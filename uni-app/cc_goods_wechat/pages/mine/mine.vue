<template>
	<view class="mine bgc">
		<view class="content">
			<user-info />
			<account />
			<benefits />
			<control />
		</view>
	</view>
</template>

<script setup lang="ts">
import UserInfo from './cpns/user_info/user_info.vue'
import Account from './cpns/account/account.vue'
import Benefits from './cpns/benefits/benefits.vue'
import Control from './cpns/control/control.vue'
</script>

<style lang="less" scoped>
.mine {
	height: 100vh;
	position: relative;
	
	.content {
		width: 100%;
		position: absolute;
		top: 20rpx;
	}
}
</style>
