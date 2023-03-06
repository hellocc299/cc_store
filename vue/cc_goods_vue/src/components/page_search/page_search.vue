<template>
  <div class="page-search">
    <cc-form v-bind="searchFormConfig" v-model="formData">
      <template #header>
        <h1 class="header">{{ searchTitle }}搜索</h1>
      </template>
      <template #footer>
        <div class="handle-btns">
          <el-button @click="handleResetClick">
            <el-icon><RefreshRight /></el-icon>
            重置
          </el-button>
          <el-button
            type="primary"
            @click="handleQueryClick"
            >
            <el-icon><Search /></el-icon>
            搜索
          </el-button>
        </div>
      </template>
    </cc-form>
  </div>
</template>

<script lang="ts" setup>
import { ref, defineProps, defineEmits } from 'vue'
import CcForm from '@/common_ui/form/form.vue'

const props = defineProps({
  searchFormConfig: {
    type: Object,
    reuqired: true
  },
  searchTitle: {
    type: String
  }
})

const emits = defineEmits<{
  (e: 'resetBtnClick'),
  (e: 'queryBtnClick', value: any)
}>()

const formItems = props.searchFormConfig?.formItems ?? []
const formOriginData: any = {}
for (const item of formItems) {
  formOriginData[item.field] = ''
}
const formData = ref(formOriginData)

const handleResetClick = () => {
  formData.value = formOriginData
}

const handleQueryClick = () => {
  emits('queryBtnClick', formData.value)
}
</script>

<style scoped lang="less">
.page-search {
  .handle-btns {
    text-align: right;
    padding: 0 40px 20px 0;
  }
}
.el-icon {
  margin-right: 5px;
}
</style>
