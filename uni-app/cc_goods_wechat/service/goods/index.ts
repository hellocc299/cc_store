import request from '../request'

enum ClassifyAPI {
	getClassify = '/classify/findAllClassifies'
}

export function getClassifyRequest() {
	return request({
		url: ClassifyAPI.getClassify,
		data: null,
		method: 'get'
	})
}

enum GoodsAPI {
	findGoodsById = '/goods/findGoodsByClassifyId?id='
}

export function findGoodsByIdRequest(id: number) {
	return request({
		url: GoodsAPI.findGoodsById + id,
		data: null,
		method: 'post'
	})
}