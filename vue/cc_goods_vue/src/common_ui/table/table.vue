<template>
  <div class="cc-table">
    <div class="header">
      <slot name="header">
        <div class="title">{{ propList['title'] }}</div>
        <div class="handler">
          <slot name="headerHandler"></slot>
        </div>
      </slot>
    </div>
    <el-table
      :data="listData"
      border
      style="width: 100%"
      :max-height="maxHeight"
      @selection-change="handleSelectionChange"
      v-bind="childrenProps"
    >
      <el-table-column
        v-if="showSelectColumn"
        type="selection"
        align="center"
        width="60"
        fixed
      ></el-table-column>
      <el-table-column
        v-if="showIndexColumn"
        type="index"
        label="序号"
        align="center"
        width="80"
        fixed
      ></el-table-column>
      <template v-for="propItem in propList" :key="propItem.prop">
        <el-table-column v-bind="propItem" align="center" show-overflow-tooltip>
          <template #default="scope">
            <slot :name="propItem.slotName" :row="scope.row">
              {{ propItem.prop!.includes('price') ? formatPrice(scope.row[propItem.prop!]) : scope.row[propItem.prop!] }}
            </slot>
          </template>
        </el-table-column>
      </template>
    </el-table>
    <div class="footer" v-if="showFooter">
      <slot name="footer">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="page.currentPage"
          :page-size="page.pageSize"
          :page-sizes="[10, 20, 30]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="listCount"
        >
        </el-pagination>
      </slot>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { defineProps, defineEmits, PropType } from 'vue';
import {ITableItem} from './type'
import { formatPrice } from '@/utils/format'
const props = defineProps({
  title: {
    type: String,
    default: ''
  },
  maxHeight: {
    type: Number,
    default: 250
  },
  listData: {
    type: Array,
    required: true
  },
  listCount: {
    type: Number,
    default: 0
  },
  propList: {
    type: Array as PropType<ITableItem[]>,
    required: true
  },
  showIndexColumn: {
    type: Boolean,
    default: false
  },
  showSelectColumn: {
    type: Boolean,
    default: false
  },
  page: {
    type: Object,
    default: () => ({ currentPage: 0, pageSize: 10 })
  },
  childrenProps: {
    type: Object,
    default: () =>({})
  },
  showFooter: {
    type: Boolean,
    default: true
  }
})

const emits = defineEmits<{
  (e: 'selectionChange', value: any),
  (e: 'update:page', value: any),
}>()

const handleSelectionChange = (value: any) => {
  emits('selectionChange', value)
}

const handleCurrentChange = (currentPage: number) => {
  emits('update:page', { ...props.page, currentPage })
}

const handleSizeChange = (pageSize: number) => {
  emits('update:page', { ...props.page, pageSize })
}
</script>

<style scoped lang="less">
.header {
  display: flex;
  height: 45px;
  padding: 0 5px;
  justify-content: space-between;
  align-items: center;

  .title {
    font-size: 20px;
    font-weight: 700;
  }

  .handler {
    align-items: center;
  }
}

.footer {
  margin-top: 15px;

  .el-pagination {
    text-align: right;
    padding: 0 40px 20px 0;
  }
}

</style>
