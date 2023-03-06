import { IForm } from "@/common_ui/form/type"
import cache from "@/utils/cache"
const classifyOptions = cache.getCache('classifyOptions')

export const GoodsSearchConfig: IForm = {
  labelWidth: '120px',
  colLayout: {
    span: 12
  },
  formItems: [
    {
      field: 'name',
      type: 'input',
      label: '商品名称',
      placeholder: '请输入商品名称'
    },
    {
      field: 'classifyId',
      type: 'select',
      label: '商品分类',
      placeholder: '请选择商品分类',
      options: classifyOptions
    },
  ]
}
