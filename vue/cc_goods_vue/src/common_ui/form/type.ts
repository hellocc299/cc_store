import { FormRules } from 'element-plus'

type IFormType = 'input' | 'password' | 'select' | 'datepicker' | 'text' | 'datetimerange' | 'image' | 'price' | 'textarea'
export interface IFormItem {
  field: string
  type: IFormType
  label: string
  rules?: any[]
  placeholder?: any
  options?: any
  otherOptions?: any
  isHidden?: boolean,
  rows?: string,
}

export interface IForm {
  formItems: IFormItem[]
  colLayout?: any
  labelWidth?: string
  itemStyle?: any,
  formRules?: FormRules
}
