"use strict";
const utils_cache = require("../../utils/cache.js");
const service_goods_index = require("../../service/goods/index.js");
const classifyModule = {
  namespaced: true,
  state() {
    return {
      classifyList: [],
      count: 0
    };
  },
  getters: {},
  mutations: {
    changeClassifyList(state, classifyList) {
      state.classifyList = classifyList;
    },
    changeClassifyCount(state, count) {
      state.count = count;
    }
  },
  actions: {
    async getClassifyListAction({ commit }) {
      const classifyListResult = await service_goods_index.getClassifyRequest();
      commit("changeClassifyList", classifyListResult.classifyList);
      commit("changeClassifyList", classifyListResult.count);
      utils_cache.cache.setCache("classifyList", classifyListResult.classifyList);
    }
  }
};
exports.classifyModule = classifyModule;
