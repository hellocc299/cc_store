<template>
	<view class="top-bar-list">
		<template v-for="(item, index) in topbarList" :key="item.type">
			<view class="tb-item" :class="{ 'tb-active': index === tbCurrentIndex }" @click="tbItemClick(item, index)">{{ item.name }}</view>
		</template>
	</view>
</template>

<script setup lang="ts">
import { defineProps, defineEmits, PropType } from 'vue'
import { TopBarListType } from './top_bar_list_type'
const props = defineProps({
	topbarList: {
		type: Array as PropType<TopBarListType[]>,
		default: () => [],
		require: true
	},
	tbCurrentIndex: {
		type: Number,
		default: 0
	}
})

const emits = defineEmits<{
	(e: 'tbItemClick', item: any, index: Number): void
}>()

const tbItemClick = (item: any, index: Number) => {
	emits('tbItemClick', item, index)
}
</script>

<style lang="less" scoped>
	.top-bar-list {
		display: flex;
		justify-content: space-around;
		align-items: center;
		height: 120rpx;
		background-color: #fff;
		box-shadow: 0 6rpx 6rpx 0 rgba(0, 0, 0, 0.08);
		
		.tb-item {
			display: inline-block;
			color: #737373;
		}
		
		.tb-active {
			color: #EA7246;
		}
	}
</style>
