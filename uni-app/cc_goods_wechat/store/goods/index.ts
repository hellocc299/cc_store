import { Module } from 'vuex'
import { IRootState } from '../type'
import { IGoodsState } from './type'
import { findGoodsByIdRequest } from '@/service/goods'

const goodsModule: Module<IGoodsState, IRootState> = {
  namespaced: true,
  state() {
    return {
			goodsList: []
    }
  },
  getters: {},
  mutations: {
		changeGoodsList(state, goodsList: any) {
			state.goodsList = goodsList
		}
  },
  actions: {
		async getGoodsListByIdAction({commit}, payload) {
			const goodsList = await findGoodsByIdRequest(payload)
			commit('changeGoodsList', goodsList)
		}
  }  
}

export default goodsModule
