import { IForm } from "@/common_ui/form/type"

export const StaffSearchConfig: IForm = {
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
      field: 'classify',
      type: 'select',
      label: '商品分类',
      placeholder: '请选择商品分类',
      // 从后台去拿-label: classify value: id
      options: [
        { label: '椰椰系列', value: 0 },
        { label: '暴打柠檬系列', value: 1 }
      ]
    },
  ]
}
