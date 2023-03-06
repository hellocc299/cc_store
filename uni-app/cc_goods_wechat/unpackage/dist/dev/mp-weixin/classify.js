"use strict";
const common_vendor = require("./common/vendor.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "classify",
  props: {
    classifyList: {
      type: Array,
      default: () => [],
      require: true
    },
    classifyIndex: {
      type: Number,
      default: 0
    }
  },
  emits: ["classfyItemClick"],
  setup(__props, { emit: emits }) {
    const classfyItemClick = (item, index) => {
      emits("classfyItemClick", item, index);
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.f(__props.classifyList, (item, index, i0) => {
          return {
            a: common_vendor.t(item.name),
            b: index === __props.classifyIndex ? 1 : "",
            c: common_vendor.o(($event) => classfyItemClick(item, index), item.type),
            d: item.type
          };
        })
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-90ad0908"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/components/classify/classify.vue"]]);
exports.Component = Component;
