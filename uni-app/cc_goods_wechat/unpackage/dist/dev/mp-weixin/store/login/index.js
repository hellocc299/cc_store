"use strict";
const service_login_index = require("../../service/login/index.js");
const utils_cache = require("../../utils/cache.js");
const loginModule = {
  namespaced: true,
  state() {
    return {
      menus: [],
      accessToken: "",
      refreshToken: "",
      userInfo: []
    };
  },
  getters: {},
  mutations: {
    changeAccessToken(state, accessToken) {
      state.accessToken = accessToken;
    },
    changeRefreshToken(state, refreshToken) {
      state.refreshToken = refreshToken;
    },
    changeUserInfo(state, userInfo) {
      state.userInfo = userInfo;
    }
  },
  actions: {
    async wxLoginAction({ commit, dispatch }, payload) {
      const loginResult = await service_login_index.loginRequest(payload.code, payload.avatarUrl, payload.nickName);
      const accessToken = loginResult.access_token;
      const refreshToken = loginResult.refresh_token;
      const userInfo = loginResult.wx_login_info;
      commit("changeAccessToken", accessToken);
      commit("changeRefreshToken", refreshToken);
      commit("changeUserInfo", userInfo);
      utils_cache.cache.setCache("accessToken", accessToken);
      utils_cache.cache.setCache("refreshToken", refreshToken);
      utils_cache.cache.setCache("userInfo", userInfo);
    },
    loadLocalLogin({ commit, dispatch }) {
      const accessToken = utils_cache.cache.getCache("accessToken");
      if (accessToken) {
        commit("changeAccessToken", accessToken);
      }
      const refreshToken = utils_cache.cache.getCache("refreshToken");
      if (refreshToken) {
        commit("changeRefreshToken", refreshToken);
      }
      const userInfo = utils_cache.cache.getCache("userInfo");
      if (userInfo) {
        commit("changeUserInfo", userInfo);
      }
    }
  }
};
exports.loginModule = loginModule;
