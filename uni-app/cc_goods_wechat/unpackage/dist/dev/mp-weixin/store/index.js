"use strict";
const common_vendor = require("../common/vendor.js");
const store_login_index = require("./login/index.js");
const store_classify_index = require("./classify/index.js");
const store_goods_index = require("./goods/index.js");
const store = common_vendor.createStore({
  state() {
    return {};
  },
  mutations: {},
  actions: {},
  modules: {
    login: store_login_index.loginModule,
    classify: store_classify_index.classifyModule,
    goods: store_goods_index.goodsModule
  }
});
function setupStore() {
  store.dispatch("login/loadLocalLogin");
}
function useStore() {
  return common_vendor.useStore();
}
exports.setupStore = setupStore;
exports.store = store;
exports.useStore = useStore;
