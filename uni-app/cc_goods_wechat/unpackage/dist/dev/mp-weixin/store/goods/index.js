"use strict";
const service_goods_index = require("../../service/goods/index.js");
const goodsModule = {
  namespaced: true,
  state() {
    return {
      goodsList: []
    };
  },
  getters: {},
  mutations: {
    changeGoodsList(state, goodsList) {
      state.goodsList = goodsList;
    }
  },
  actions: {
    async getGoodsListByIdAction({ commit }, payload) {
      const goodsList = await service_goods_index.findGoodsByIdRequest(payload);
      commit("changeGoodsList", goodsList);
    }
  }
};
exports.goodsModule = goodsModule;
