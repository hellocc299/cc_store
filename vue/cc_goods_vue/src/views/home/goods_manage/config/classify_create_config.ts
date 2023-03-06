import { IForm } from "@/common_ui/form/type"

export const ClassifyCreateConfig: IForm = {
  formItems: [
    {
      field: 'classify',
      type: 'input',
      label: '分类',
      placeholder: '请输入分类'
    },
    {
      field: 'img',
      type: 'image',
      label: '图片展示',
      placeholder: '请选择图片'
    }
  ],
  colLayout: { span: 24 },
  formRules: {
    classify: [
      {
        required: true,
        message: '分类名称不可为空',
        trigger: 'blur'
      }
    ]
  }
}

