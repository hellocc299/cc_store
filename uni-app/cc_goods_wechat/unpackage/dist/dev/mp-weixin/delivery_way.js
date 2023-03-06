"use strict";
const common_vendor = require("./common/vendor.js");
const common_assets = require("./common/assets.js");
const store_index = require("./store/index.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "delivery_way",
  setup(__props) {
    store_index.useStore();
    const toMenuClick = (type) => {
      common_vendor.index.navigateTo({
        url: `/pages/menu/menu?type=${type}`
      });
    };
    return (_ctx, _cache) => {
      return {
        a: common_assets._imports_0$1,
        b: common_assets._imports_1,
        c: common_vendor.o(($event) => toMenuClick(1))
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-df2cb635"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/home/cpns/delivery_way/delivery_way.vue"]]);
exports.Component = Component;
