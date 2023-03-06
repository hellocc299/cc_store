"use strict";
const common_vendor = require("../../common/vendor.js");
if (!Array) {
  const _component_van_tab = common_vendor.resolveComponent("van-tab");
  const _component_van_tabs = common_vendor.resolveComponent("van-tabs");
  (_component_van_tab + _component_van_tabs)();
}
if (!Math) {
  All();
}
const All = () => "./page/all/all2.js";
const _sfc_main = {
  __name: "order",
  setup(__props) {
    const active = common_vendor.ref(0);
    return (_ctx, _cache) => {
      return {
        a: common_vendor.p({
          title: "\u6211\u7684\u8BA2\u5355"
        }),
        b: common_vendor.p({
          title: "\u79EF\u5206\u8BA2\u5355"
        }),
        c: common_vendor.p({
          title: "\u6D3B\u52A8\u8BA2\u5355"
        }),
        d: common_vendor.p({
          active: active.value
        })
      };
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-93207a4f"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/order/order.vue"]]);
wx.createPage(MiniProgramPage);
