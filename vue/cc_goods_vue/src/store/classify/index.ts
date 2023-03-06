import { Module } from "vuex";
import { IRootState } from "../types";
import { IClassifyState } from "./type";
import { findAllClassifiesService, insertClassifyService, uploadImgRequest } from '@/service/goods'

const classifyModule: Module<IClassifyState, IRootState> = {
  namespaced: true,
  state() {
    return {
      classifies: [],
      count: 0
    }
  },
  mutations: {
    changeClassifies(state, classifies: any[]) {
      state.classifies = classifies
    },
    changeCount(state, count: number) {
      state.count = count
    }
  },
  actions: {
    async insertClassifyAction({dispatch}, payload: any) {
      const imgUrl = await uploadImgRequest({ file: payload['img'] })
      payload['img'] = imgUrl
      await insertClassifyService(payload.classify, payload.img)
      dispatch('getAllClassifies')
    },
    async getAllClassifies({commit}) {
      const classifiesResult = await findAllClassifiesService()
      commit('changeClassifies', classifiesResult.classifyList)
      commit('changeCount', classifiesResult.count)
    }
  }
}

export default classifyModule
