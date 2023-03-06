"use strict";
const common_vendor = require("./common/vendor.js");
const pages_order_page_all_all_config = require("./pages/order/page/all/all_config.js");
if (!Math) {
  (TopBarList + Classify + OrderItem)();
}
const TopBarList = () => "./components/top_bar_list/top_bar_list2.js";
const Classify = () => "./components/classify/classify2.js";
const OrderItem = () => "./components/order-item/order-item2.js";
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "all",
  setup(__props) {
    const tbCurrentIndex = common_vendor.ref(0);
    const classifyIndex = common_vendor.ref(0);
    const tbItemClick = (item, index) => {
      tbCurrentIndex.value = index;
    };
    const classfyItemClick = (item, index) => {
      classifyIndex.value = index;
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.o(tbItemClick),
        b: common_vendor.p({
          topbarList: common_vendor.unref(pages_order_page_all_all_config.topbarList),
          tbCurrentIndex: tbCurrentIndex.value
        }),
        c: common_vendor.o(classfyItemClick),
        d: common_vendor.p({
          classifyList: common_vendor.unref(pages_order_page_all_all_config.classifyList),
          classifyIndex: classifyIndex.value
        }),
        e: common_vendor.f(common_vendor.unref(pages_order_page_all_all_config.orderList), (item, index, i0) => {
          return {
            a: "7851f300-2-" + i0,
            b: common_vendor.p({
              orderItem: item
            }),
            c: item.o_id
          };
        })
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-7851f300"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/order/page/all/all.vue"]]);
exports.Component = Component;
