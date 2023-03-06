<template>
  <div class='cc-form'>
    <div class="form-header">
      <slot name="header"></slot>
    </div>
    <el-form :label-width="labelWidth" :rules="formRules" :model="modelValue" ref="formRef">
      <el-row>
        <template v-for="item in formItems" :key="item.label">
          <el-col v-bind="colLayout">
            <el-form-item :label="item.label"
                          :style="itemLayout"
                          v-if="!item.isHidden"
                          :prop="item.field">
              <template v-if="item.type === 'select'">
                <el-select :placeholder="item.placeholder"
                           v-bind="item.otherOptions"
                           style="width: 100%"
                           :model-value="modelValue[`${item.field}`]"
                           @update:modelValue="handleValueChange($event, item.field)">
                  <el-option v-for="option in item.options"
                             :key="option.value"
                             :label="option.label"
                             :value="option.value"/>
                </el-select>
              </template>
              <template v-else-if="item.type === 'datepicker'">
                <el-date-picker style="width: 100%"
                                v-bind="item.otherOptions"
                                :model-value="modelValue[`${item.field}`]"
                                @update:modelValue="handleValueChange($event, item.field)"/>
              </template>
              <template v-else-if="item.type === 'datetimerange'">
                <el-date-picker style="width: 100%"
                                v-bind="item.otherOptions"
                                :model-value="modelValue[`${item.field}`]"
                                @update:modelValue="handleValueChange($event, item.field)"/>
              </template>
              <template v-else-if="item.type === 'input' || item.type === 'password' || item.type === 'textarea'">
                <el-input :placeholder="item.placeholder"
                          v-bind="item.otherOptions"
                          :maxlength="item.type === 'textarea' ? 25 : 10"
                          :type="item.type === 'textarea' ? 'textarea' : 'input'"
                          :show-password="item.type === 'password'"
                          :model-value="trim(modelValue[`${item.field}`])"
                          @update:modelValue="handleValueChange($event, item.field)"
                          />
              </template>
              <template v-else-if="item.type === 'text'">
                <el-input :placeholder="item.placeholder"
                          :model-value="modelValue[`${item.field}`]"
                          @update:modelValue="handleValueChange($event, item.field)"
                          type="textarea"
                          :rows="item.rows"
                          />
              </template>
              <template v-else-if="item.type === 'image'">
                <el-upload action="#"
                           :limit="1"
                           list-type="picture-card"
                           :file-list="fileList"
                           :auto-upload="false"
                           :on-change="handlePictureChange"
                           :on-remove="handleRemove"
                           :on-preview="handlePictureCardPreview"
                           :on-exceed="handleExceed">
                  <el-icon><Plus /></el-icon>
                </el-upload>
                <el-dialog v-model="dialogVisible">
                  <img w-full :src="dialogImageUrl" alt="Preview Image" />
                </el-dialog>
              </template>
              <template v-else-if="item.type === 'price'">
                <el-input-number :placeholder="item.placeholder"
                                 v-bind="item.otherOptions"
                                 :model-value="modelValue[`${item.field}`]"
                                 @update:modelValue="handleValueChange($event, item.field)"
                                 :precision="2"
                                 :min="0" />
              </template>
            </el-form-item>
          </el-col>
        </template>
      </el-row>
    </el-form>
    <div class="footer">
      <slot name="footer"></slot>
    </div>
  </div>
</template>

<script lang='ts' setup>
import { PropType, defineEmits, defineProps, ref, defineExpose } from 'vue'
import { ElForm } from 'element-plus/lib/components'
import Message from '@/common_ui/message'
import type { UploadProps, UploadRawFile, UploadFile, UploadUserFile } from 'element-plus'
import { IFormItem } from './type'

const formRef = ref<InstanceType<typeof ElForm>>()

defineExpose({ formRef })

const props = defineProps({
  formItems: {
    type: Array as PropType<IFormItem[]>,
    default: () => []
  },
  colLayout: {
    type: Object,
    default: () => ({
      xl: 6,
      lg: 8,
      md: 12,
      sm: 24,
      xs: 24
    })
  },
  labelWidth: {
    type: String,
    default: '100px'
  },
  itemLayout: {
    type: Object,
    default: () => ({ padding: '10px 40px' })
  },
  formRules: {
    type: Object
  },
  modelValue: {
    type: Object,
    required: true
  }
})

const emit = defineEmits(['update:modelValue', 'input'])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)
const uploadShow = ref('inline-flex')
const fileList = ref<UploadUserFile[]>([
  {
    name: '',
    url: props.modelValue['img']
  }
])

if(fileList.value[0].url) {
  uploadShow.value = 'none'
} else {
  fileList.value = []
}

const handlePictureChange: UploadProps['onChange'] = (uploadFile: UploadFile) => {
  uploadShow.value = 'none'
  emit('update:modelValue', {...props.modelValue, ['img']: uploadFile})
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile: UploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}

const handleRemove: UploadProps['onRemove'] = (uploadFile: UploadFile) => {
  uploadShow.value = 'inline-flex'
  emit('update:modelValue', {...props.modelValue, ['img']: undefined})
}

const handleExceed: UploadProps['onExceed'] = () => {
  Message.error('最多只可上传一张图片！')
}

const trim = (value: string) => {
  if(value) return value.replace(/\s*/g,"")
}

const handleValueChange = (value: any, field: string) => {
  emit('update:modelValue', {...props.modelValue, [field]: value})
}
</script>
<style scoped lang='less'>
.cc-form {
  ::v-deep .el-input-number {
    width: 100%;
  }

  ::v-deep .el-upload {
    display: v-bind(uploadShow);
  }
}
</style>
