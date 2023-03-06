import { Module } from 'vuex'
import { IRootState } from '../type'
import { ILoginState } from './type'
import { loginRequest } from '@/service/login'
import cache from '@/utils/cache'

const loginModule: Module<ILoginState, IRootState> = {
  namespaced: true,
  state() {
    return {
      menus: [],
      accessToken: '',
      refreshToken: '',
      userInfo: []
    }
  },
  getters: {},
  mutations: {
    changeAccessToken(state, accessToken: string) {
      state.accessToken = accessToken
    },
    changeRefreshToken(state, refreshToken: string) {
      state.refreshToken = refreshToken
    },
    changeUserInfo(state, userInfo: any) {
      state.userInfo = userInfo
    }
  },
  actions: {
    async wxLoginAction({ commit, dispatch }, payload) {
      const loginResult = await loginRequest(payload.code, payload.avatarUrl, payload.nickName)
			const accessToken = loginResult.access_token
      const refreshToken = loginResult.refresh_token
      const userInfo = loginResult.wx_login_info
      commit('changeAccessToken', accessToken)
      commit('changeRefreshToken', refreshToken)
      commit('changeUserInfo', userInfo)
      cache.setCache("accessToken", accessToken)
      cache.setCache("refreshToken", refreshToken)
      cache.setCache("userInfo", userInfo)
    },
    loadLocalLogin({ commit, dispatch }) {
      const accessToken = cache.getCache("accessToken")
      if(accessToken) {
        commit('changeAccessToken', accessToken)
      }
      const refreshToken = cache.getCache("refreshToken")
      if(refreshToken) {
        commit('changeRefreshToken', refreshToken)
      }
      const userInfo = cache.getCache("userInfo")
      if(userInfo) {
        commit('changeUserInfo', userInfo)
      }
    }
  }
}

export default loginModule
