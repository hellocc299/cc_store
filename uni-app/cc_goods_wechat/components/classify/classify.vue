<template>
	<view class="classify">
		<template v-for="(item, index) in classifyList" :key="item.type">
			<view class="classify-item" :class="{ 'classify-active': index === classifyIndex }" @click="classfyItemClick(item, index)">{{ item.name }}</view>
		</template>
	</view>
</template>

<script lang="ts" setup>
import { defineProps, defineEmits, PropType } from 'vue'
import { ClassifyListType } from './classify_list_type'

const props = defineProps({
	classifyList: {
		type: Array as PropType<ClassifyListType[]>,
		default: () => [],
		require: true
	},
	classifyIndex: {
		type: Number,
		default: 0
	}
})

const emits = defineEmits<{
	(e: 'classfyItemClick', item: any, index: Number): void
}>()

const classfyItemClick = (item: any, index: Number) => {
	emits('classfyItemClick', item, index)
}
</script>

<style lang="less" scoped>
	.classify {
		display: flex;
		justify-content: space-around;
		margin-top: 26rpx;
		
		.classify-item {
			height: 80rpx;
			width: 180rpx;
			background-color: #E5E5E5;
			text-align: center;
			line-height: 80rpx;
			color: #737373;
			border-radius: 20rpx;
			font-size: 28rpx;
		}
		
		.classify-active {
			background-color: #fff;
			color: #2B2B2B;
		}
	}
</style>
