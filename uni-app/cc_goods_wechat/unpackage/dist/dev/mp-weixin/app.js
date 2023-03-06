"use strict";
Object.defineProperties(exports, { __esModule: { value: true }, [Symbol.toStringTag]: { value: "Module" } });
const common_vendor = require("./common/vendor.js");
const store_index = require("./store/index.js");
require("./store/login/index.js");
require("./service/login/index.js");
require("./service/request/index.js");
require("./utils/cache.js");
require("./store/classify/index.js");
require("./service/goods/index.js");
require("./store/goods/index.js");
if (!Math) {
  "./pages/home/home.js";
  "./pages/order/order.js";
  "./pages/mine/mine.js";
  "./pages/home/cpns/delivery_way/delivery_way.js";
  "./pages/home/cpns/user_info/user_info.js";
  "./pages/order/page/integral/integral.js";
  "./pages/order/page/all/all.js";
  "./pages/mine/cpns/user_info/user_info.js";
  "./pages/mine/cpns/account/account.js";
  "./pages/mine/cpns/benefits/benefits.js";
  "./pages/mine/cpns/control/control.js";
  "./components/top_bar_list/top_bar_list.js";
  "./components/classify/classify.js";
  "./pages/order/page/activity/activity.js";
  "./components/order-item/order-item.js";
  "./pages/home/cpns/collect/collect.js";
  "./pages/order_detail/order_detail.js";
  "./pages/menu/menu.js";
}
const _sfc_main = {
  onLaunch: function() {
    console.log("App Launch");
  },
  onShow: function() {
    console.log("App Show");
  },
  onHide: function() {
    console.log("App Hide");
  }
};
const App = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/App.vue"]]);
function createApp() {
  const app = common_vendor.createSSRApp(App);
  app.use(store_index.store);
  store_index.setupStore();
  return {
    app
  };
}
createApp().app.mount("#app");
exports.createApp = createApp;
