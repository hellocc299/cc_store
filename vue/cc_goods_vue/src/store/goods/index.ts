import { Module } from "vuex";
import { IRootState } from "../types";
import { IGoodsState, IGoodsShowState } from './type'
import { insertImgService, insertGoodsService, findGoodsByConditionRequest } from '@/service/goods'

const GoodsModule: Module<IGoodsState, IRootState> = {
  namespaced: true,
  state() {
    return {
      goodsList: [],
      goodsShowList: [],
      count: 0
    }
  },
  mutations: {
    changeGoodsList(state, goodsList: any) {
      state.goodsList = goodsList
    },
    changeGoodsShowList(state, goodsShowList: any) {
      state.goodsShowList = goodsShowList
    },
    changeGoodsCount(state, count: number) {
      state.count = count
    }
  },
  actions: {
    async insertGoodsAction({dispatch}, payload: any) {
      const imgUrl = await insertImgService({ file: payload['img'].raw })
      payload['img'] = imgUrl
      await insertGoodsService(payload)
      const queryInfo = { name: null, classifyId: 0, page: 0, size: 10 }
      dispatch('findGoodsByCondiction', queryInfo)
    },
    async findGoodsByCondiction({commit}, payload: any) {
      const queryInfo = !payload.queryInfo ? payload : payload.queryInfo
      const queryResult = await findGoodsByConditionRequest(queryInfo.name, queryInfo.classifyId, queryInfo.page, queryInfo.size)
      commit('changeGoodsList', queryResult.content)
      commit('changeGoodsCount', queryResult.totalElements)
      const goodsShowList = queryResult.content.map((value: any) => {
        const goods: IGoodsShowState = {
          id: value.goodsId,
          name: value.name,
          classify: value.classify.name,
          img: value.goodsImg.imgUrl,
          isPull: value.isPull,
          price: value.price,
          description: value.description,
          classifyId: value.classify.classifyId,
          imgId: value.goodsImg.goodsImgId
        }
        return goods
      })

      commit('changeGoodsShowList', goodsShowList)
    }
  }
}

export default GoodsModule
