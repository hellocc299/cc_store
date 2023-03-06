<template>
  <div class="">
    <el-dialog :model-value="modelValue"
               @update:modelValue="handleValueChange"
               :title="title"
               width="40%"
               center
               destroy-on-close>
      <cc-form v-bind="editModalConfig" v-model="editFormData"></cc-form>
      <slot></slot>
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
  editModalConfig: {
    type: Object,
    required: true
  },
  editDefaultInfo: {
    type: Object,
    default: () => ({})
  },
  modelValue: {
    type: Boolean
  }
})

const emits = defineEmits(['handleConfirmClick', 'update:modelValue'])
const editFormData = ref<any>({})

const dialogShow = computed({
  get: () => props.modelValue,
  set: val => emits('update:modelValue', val)
})

const handleValueChange = (e: boolean) => {
  emits('update:modelValue', e)
}

// 收集表单中的数据给createFormData
watch(
  () => props.editDefaultInfo,
  (newValue) => {
    for(const item of props.editModalConfig.formItems) {
      editFormData.value[`${item.field}`] = newValue[`${item.field}`]
    }
  }
)

const createFormRef = ref<InstanceType<typeof CcForm>>()

// 处理确定逻辑
const handleConfirmClick = async () => {
  dialogShow.value = false
  if(props.editDefaultInfo.formRules) {
    await createFormRef.value?.formRef?.validate((valid) => {
      if(valid) {
        emits('handleConfirmClick',  editFormData.value)
      }
      return
    })
  }
  else {
    emits('handleConfirmClick',  editFormData.value)
  }
}
</script>

<style scoped lang="ts"></style>
