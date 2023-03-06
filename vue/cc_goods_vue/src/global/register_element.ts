import { App } from 'vue'

import {
  ElCard,
  ElForm,
  ElFormItem,
  ElInput,
  ElRadioGroup,
  ElRadio,
  ElCheckbox,
  ElLink,
  ElButton,
  ElContainer,
  ElAside,
  ElMain,
  ElHeader,
  ElMenu,
  ElMenuItem,
  ElIcon,
  ElRow,
  ElCol,
  ElSelect,
  ElOption,
  ElDatePicker,
  ElTable,
  ElTableColumn,
  ElPagination,
  ElDialog,
  ElUpload,
  ElInputNumber,
  ElImage
} from 'element-plus/lib/components'

const components = [
  ElCard,
  ElForm,
  ElFormItem,
  ElInput,
  ElRadioGroup,
  ElRadio,
  ElCheckbox,
  ElLink,
  ElButton,
  ElContainer,
  ElAside,
  ElMain,
  ElHeader,
  ElMenu,
  ElMenuItem,
  ElIcon,
  ElRow,
  ElCol,
  ElSelect,
  ElOption,
  ElDatePicker,
  ElTable,
  ElTableColumn,
  ElPagination,
  ElDialog,
  ElUpload,
  ElInputNumber,
  ElImage
]

export default function(app: App): void {
  for(const cpn of components) {
    app.component(cpn.name, cpn)
  }
}
