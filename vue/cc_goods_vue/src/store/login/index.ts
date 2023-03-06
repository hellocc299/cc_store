import { Module } from 'vuex'

import { mapMenuToRoutes } from '@/utils/map_routes'
import router from '@/router'

import { IRootState } from '../types'
import { ILoginState } from './types'
import localCache from '@/utils/cache'
import { loginRequest, getStaffMenusRequest } from '@/service/login'
import { IAccount } from '@/service/login/type'

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
    changeMenus(state, menus: any) {
      state.menus = menus
      const routes = mapMenuToRoutes(menus)
      routes.forEach((route) => {
        router.addRoute('Home', route)
      })
    },
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
    async accountLoginAction({ commit, dispatch }, payload: IAccount) {
      const loginResult = await loginRequest(payload)
      const accessToken = loginResult.access_token
      const refreshToken = loginResult.refresh_token
      const userInfo = loginResult.staff_login_info
      commit('changeAccessToken', accessToken)
      commit('changeRefreshToken', refreshToken)
      commit('changeUserInfo', userInfo)
      localCache.setCache("accessToken", accessToken)
      localCache.setCache("refreshToken", refreshToken)
      localCache.setCache("userInfo", userInfo)
      const menus = await getStaffMenusRequest()
      commit('changeMenus', menus)
      localCache.setCache('menus', menus)
      router.push('/home')
      const imgUrl = localCache.getCache('imgUrl')
      if(imgUrl) {
        localCache.deleteCache('imgUrl')
      }
    },
    loadLocalLogin({ commit, dispatch }) {
      const accessToken = localCache.getCache("accessToken")
      if(accessToken) {
        commit('changeAccessToken', accessToken)
        // dispatch('getInitialDataAction', null, { root: true })
      }
      const refreshToken = localCache.getCache("refreshToken")
      if(refreshToken) {
        commit('changeRefreshToken', refreshToken)
      }
      const userInfo = localCache.getCache("userInfo")
      if(userInfo) {
        commit('changeUserInfo', userInfo)
      }
      const menus = localCache.getCache('menus')
      if (menus) {
        commit('changeMenus', menus)
      }
    }
  }
}

export default loginModule
