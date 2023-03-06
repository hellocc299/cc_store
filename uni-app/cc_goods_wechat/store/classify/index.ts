import { Module } from 'vuex'
import { IRootState } from '../type'
import { IClassifyState } from './type'
import cache from '@/utils/cache'
import { getClassifyRequest } from '@/service/goods'

const classifyModule: Module<IClassifyState, IRootState> = {
  namespaced: true,
  state() {
    return {
			classifyList: [],
			count: 0
    }
  },
  getters: {},
  mutations: {
		changeClassifyList(state, classifyList: any) {
			state.classifyList = classifyList
		},
		changeClassifyCount(state, count: number) {
			state.count = count
		}
  },
  actions: {
		async getClassifyListAction({commit}) {
			const classifyListResult: any = await getClassifyRequest()
			commit('changeClassifyList', classifyListResult.classifyList)
			commit('changeClassifyList', classifyListResult.count)
			cache.setCache("classifyList", classifyListResult.classifyList)
		}
  }  
}

export default classifyModule