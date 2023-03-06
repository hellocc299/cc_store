export interface IClassifyRequest {
  classifyList: any,
  count: number
}

export interface IInsertGoodsRequest {
  name: string,
  isPull: number,
  originalPrice: number,
  finalPrice: number,
  description: string,
  classifyId: number,
  img: string
}

export interface IGoodsRequest {
  content: any,
  totalElements: number
}
