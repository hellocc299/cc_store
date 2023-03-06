<template>
  <div class="page-modal">
    <el-dialog :model-value="modelValue"
               @update:modelValue="handleValueChange"
               :title="title"
               width="40%"
               center
               destroy-on-close>
      <cc-form v-bind="createModalConfig" v-model="createFormData" ref="createFormRef"></cc-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogShow = false">取 消</el-button>
          <el-button type="primary" @click="handleConfirmClick">
            确 定
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { defineProps, ref, watch, defineEmits, computed } from 'vue'
import CcForm from '@/common_ui/form/form.vue'

const props = defineProps({
  title: {
    type: String,
    required: true
  },
  createModalConfig: {
    type: Object,
    required: true
  },
  createDefaultInfo: {
    type: Object,
    default: () => ({})
  },
  modelValue: {
    type: Boolean
  }
})

const emits = defineEmits(['handleConfirmClick', 'update:modelValue'])
const createFormData = ref<any>({})

const dialogShow = computed({
  get: () => props.modelValue,
  set: val => emits('update:modelValue', val)
})

const handleValueChange = (e: boolean) => {
  emits('update:modelValue', e)
}

// 收集表单中的数据给createFormData
watch(
  () => props.createDefaultInfo,
  (newValue) => {
    for(const item of props.createModalConfig.formItems) {
      createFormData.value[`${item.field}`] = newValue[`${item.field}`]
    }
  }
)

const createFormRef = ref<InstanceType<typeof CcForm>>()

// 处理确定逻辑
const handleConfirmClick = async () => {
  dialogShow.value = false
  if(props.createModalConfig.formRules) {
    await createFormRef.value?.formRef?.validate((valid) => {
      if(valid) {
        emits('handleConfirmClick',  createFormData.value)
      }
      return
    })
  }
  else {
    emits('handleConfirmClick',  createFormData.value)
  }
}
</script>

<style scoped></style>
