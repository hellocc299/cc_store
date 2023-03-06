"use strict";
const common_vendor = require("./common/vendor.js");
if (!Array) {
  const _component_van_progress = common_vendor.resolveComponent("van-progress");
  _component_van_progress();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "user_info",
  setup(__props) {
    let growth = common_vendor.ref(59.8);
    let allGrowth = common_vendor.ref(1e3);
    let percentage = growth.value / allGrowth.value * 100;
    percentage = parseFloat(percentage.toFixed(2));
    return (_ctx, _cache) => {
      return {
        a: common_vendor.p({
          color: "#EA7246",
          percentage: common_vendor.unref(percentage),
          showPivot: false,
          strokeWidth: "9"
        }),
        b: common_vendor.t(common_vendor.unref(growth)),
        c: common_vendor.t(common_vendor.unref(allGrowth)),
        d: common_vendor.t(common_vendor.unref(allGrowth) - common_vendor.unref(growth))
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-54cc5443"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/mine/cpns/user_info/user_info.vue"]]);
exports.Component = Component;
