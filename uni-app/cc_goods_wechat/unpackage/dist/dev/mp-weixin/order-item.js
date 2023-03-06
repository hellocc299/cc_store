"use strict";
const common_vendor = require("./common/vendor.js");
if (!Array) {
  const _component_van_button = common_vendor.resolveComponent("van-button");
  _component_van_button();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "order-item",
  props: {
    orderItem: {
      type: Object,
      require: true
    }
  },
  setup(__props) {
    const props = __props;
    let statu = common_vendor.ref("");
    let deliveryType = common_vendor.ref("");
    switch (props.orderItem.deliveryType) {
      case 0:
        deliveryType.value = "\u81EA\u63D0";
        break;
      case 1:
        deliveryType.value = "\u914D\u9001";
        break;
    }
    switch (props.orderItem.status) {
      case 0:
        statu.value = "\u5DF2\u4E0B\u5355";
        break;
      case 1:
        statu.value = "\u8BA2\u5355\u53D6\u6D88";
        break;
      case 2:
        statu.value = "\u5DF2\u9000\u6B3E";
        break;
      case 3:
        statu.value = "\u5DF2\u5B8C\u6210";
        break;
    }
    const handleTime = (time) => {
      return time.substring(0, 10);
    };
    const deleteClick = (oId) => {
      console.log(`${oId}\u6B63\u5728\u88AB\u5220\u9664`);
    };
    const orderItemClick = (orderCode) => {
      common_vendor.index.navigateTo({
        url: `/pages/order_detail/order_detail?orderCode=${orderCode}`
      });
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.t(common_vendor.unref(deliveryType)),
        b: common_vendor.t(__props.orderItem.orderNum),
        c: common_vendor.t(common_vendor.unref(statu)),
        d: common_vendor.f(__props.orderItem.orderDetail, (item, index, i0) => {
          return {
            a: item,
            b: item.id
          };
        }),
        e: common_vendor.o(($event) => orderItemClick(__props.orderItem.orderCode)),
        f: common_vendor.t(handleTime(__props.orderItem.startTime)),
        g: common_vendor.t(__props.orderItem.allAmount),
        h: common_vendor.t(__props.orderItem.totalPrice),
        i: common_vendor.t(__props.orderItem.delivery),
        j: common_vendor.o(($event) => deleteClick(__props.orderItem.o_id)),
        k: common_vendor.p({
          round: true,
          size: "normal",
          hairline: true
        })
      };
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-d4921d0a"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/components/order-item/order-item.vue"]]);
exports.Component = Component;
