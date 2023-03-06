<template>
	<view class="all">
		<top-bar-list :topbarList="topbarList"
									@tbItemClick="tbItemClick"
									:tbCurrentIndex="tbCurrentIndex"/>
		<classify :classifyList="classifyList"
							@classfyItemClick="classfyItemClick"
							:classifyIndex="classifyIndex"/>
		<template v-for="(item, index) in orderList" :key="item.o_id">
			<order-item :orderItem="item" />
		</template>
	</view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import TopBarList from '@/components/top_bar_list/top_bar_list.vue'
import Classify from '@/components/classify/classify.vue'
import OrderItem from '@/components/order-item/order-item.vue'
import { topbarList, classifyList, orderList } from './all_config'

const tbCurrentIndex = ref(0)
const classifyIndex = ref(0)

const tbItemClick = (item: any, index: number) => {
	tbCurrentIndex.value = index
}

const classfyItemClick = (item: any, index: number) => {
	classifyIndex.value = index
}
</script>

<style scoped lang="less">
.all {

}
</style>
