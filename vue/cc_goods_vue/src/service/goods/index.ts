import { UploadFile } from "element-plus";
import ccRequest from "../index";
import { IClassifyRequest, IInsertGoodsRequest, IGoodsRequest } from './type'

enum ClassifyAPI {
  InsertLabel = '/classify/insertClassify',
  FindAllClassifies = '/classify/findAllClassifies',
}

export function insertClassifyService(classify: string, imgUrl: string) {
  return ccRequest.post({
    url: ClassifyAPI.InsertLabel + `?classify=${classify}&imgUrl=${imgUrl}`
  })
}

export function findAllClassifiesService() {
  return ccRequest.get<IClassifyRequest>({
    url: ClassifyAPI.FindAllClassifies
  })
}

enum GoodsAPI {
  insertGoods = '/goods/insertGoods',
  findAllGoods = '/goods/findAllGoods',
  findGoodsByCondition = '/goods/findGoodsByPage',
  updateGoods = '/goods/updateGoods',
  deleteGoods = '/goods/deleteGoods?id='
}

enum GoodsImgAPI {
  insertImg = '/goodsImg/insertImg',
  uploadImg = '/goodsImg/uploadImg',
  updateImg = '/goodsImg/updateImg'
}

export function insertImgService(file: any) {
  return ccRequest.post<string>({
    url: GoodsImgAPI.insertImg,
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function insertGoodsService(good: IInsertGoodsRequest) {
  return ccRequest.post({
    url: GoodsAPI.insertGoods,
    data: good
  })
}

export function findGoodsByConditionRequest(name: string, classifyId: number, page: number, size: number) {
  return ccRequest.post<IGoodsRequest>({
    url: GoodsAPI.findGoodsByCondition + `?&classifyId=${classifyId}&page=${page}&size=${size}&name` + (!name ? '=' : `=${name}`)
  })
}

export function uploadImgRequest(file: any) {
  return ccRequest.post<string>({
    url: GoodsImgAPI.uploadImg,
    data: file,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function updateImgRequest(imgId: number, imgUrl: string) {
  return ccRequest.patch({
    url: GoodsImgAPI.updateImg + `?imgId=${imgId}&imgUrl=${imgUrl}`
  })
}

export function updateGoodsRequest(editGoodsVO: any) {
  return ccRequest.patch({
    url: GoodsAPI.updateGoods,
    data: editGoodsVO
  })
}

export function deleteGoodsRequest(id: number) {
  return ccRequest.delete({
    url: GoodsAPI.deleteGoods + id
  })
}
