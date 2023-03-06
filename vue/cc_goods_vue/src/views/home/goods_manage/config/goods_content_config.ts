import { ITable } from '@/common_ui/table/type'

export const GoodsContentConfig: ITable = {
  propList: [
    {
      prop: 'name',
      label: '名称',
      minWidth: '100',
      fixed: true
    },
    {
      prop: 'classify',
      label: '分类',
      minWidth: '100'
    },
    {
      prop: 'img',
      label: '图片',
      minWidth: '120',
      slotName: 'img'
    },
    {
      prop: 'isPull',
      label: '上新状态',
      minWidth: '100',
      slotName: 'isPull'
    },
    {
      prop: 'price',
      label: '价格',
      minWidth: '80'
    },
    {
      prop: 'description',
      label: '商品描述',
      minWidth: '200'
    },
    {
      label: '操作',
      minWidth: '100',
      slotName: 'handle'
    }
  ],
  showIndexColumn: true
}
