import { IForm } from "@/common_ui/form/type"
import cache from "@/utils/cache"
const classifyOptions = cache.getCache('classifyOptions')

export const GoodsCreateConfig: IForm = {
  formItems: [
    {
      field: 'name',
      type: 'input',
      label: '商品名',
      placeholder: '请输入商品名'
    },
    {
      field: 'classifyId',
      type: 'select',
      label: '分类',
      placeholder: '请选择商品分类',
      options: classifyOptions
    },
    {
      field: 'isPull',
      type: 'select',
      label: '上架状态',
      placeholder: '请选择上架状态',
      options: [
        { label: '上新', value: 0 },
        { label: '下架', value: 1 }
      ]
    },
    {
      field: 'price',
      type: 'price',
      label: '价格',
      placeholder: '请输入价格'
    },
    {
      field: 'description',
      type: 'textarea',
      label: '商品描述',
      placeholder: '请输入商品描述'
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
    name: [
      {
        required: true,
        message: '商品名称不可为空',
        trigger: 'blur'
      }
    ],
    classifyId: [
      {
        required: true,
        message: '请选择商品分类',
        trigger: 'blur'
      }
    ],
    isPull: [
      {
        required: true,
        message: '请选择上架状态',
        trigger: 'blur'
      }
    ],
    price: [
      {
        required: true,
        message: '价格不可为空/请填写正确数字',
        trigger: 'blur'
      }
    ],
    description: [
      {
        required: true,
        message: '请输入商品描述',
        trigger: 'blur'
      }
    ]
  }
}

