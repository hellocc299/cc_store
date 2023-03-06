export interface IGoodsState {
  goodsList: any,
  goodsShowList: any,
  count: number
}

export interface IGoodsShowState {
  id: number,
  name: string,
  classify: string,
  img: string,
  isPull: number,
  price: number,
  description: string,
  classifyId: number,
  imgId: number
}
