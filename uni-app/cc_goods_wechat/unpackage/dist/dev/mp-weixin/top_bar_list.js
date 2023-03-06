"use strict";
const common_vendor = require("./common/vendor.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "top_bar_list",
  props: {
    topbarList: {
      type: Array,
      default: () => [],
      require: true
    },
    tbCurrentIndex: {
      type: Number,
      default: 0
    }
  },
  emits: ["tbItemClick"],
  setup(__props, { emit: emits }) {
    const tbItemClick = (item, index) => {
      emits("tbItemClick", item, index);
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.f(__props.topbarList, (item, index, i0) => {
          return {
            a: common_vendor.t(item.name),
            b: index === __props.tbCurrentIndex ? 1 : "",
            c: common_vendor.o(($event) => tbItemClick(item, index), item.type),
            d: item.type
          };
        })
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-99b8597a"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/components/top_bar_list/top_bar_list.vue"]]);
exports.Component = Component;
