"use strict";
const common_vendor = require("./common/vendor.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "account",
  setup(__props) {
    let balance = common_vendor.ref("0.00");
    let card = common_vendor.ref("0");
    let integral = common_vendor.ref("53.80");
    return (_ctx, _cache) => {
      return {
        a: common_vendor.t(common_vendor.unref(balance)),
        b: common_vendor.t(common_vendor.unref(card)),
        c: common_vendor.t(common_vendor.unref(integral))
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-70e5d9d4"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/mine/cpns/account/account.vue"]]);
exports.Component = Component;
