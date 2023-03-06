"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
const pages_order_detail_order_detail_config = require("./order_detail_config.js");
if (!Array) {
  const _component_van_cell = common_vendor.resolveComponent("van-cell");
  const _component_van_cell_group = common_vendor.resolveComponent("van-cell-group");
  (_component_van_cell + _component_van_cell_group)();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "order_detail",
  setup(__props) {
    common_vendor.onLoad((oId) => {
      console.log(oId);
    });
    let statu = "";
    let content = "";
    switch (pages_order_detail_order_detail_config.orderDetailItem1.status) {
      case 0:
        statu = "\u8BA2\u5355\u6B63\u5728\u5236\u4F5C";
        content = "\u8BA2\u5355\u6B63\u5728\u5236\u4F5C\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5F85\uFF01";
        break;
      case 1:
        statu = "\u8BA2\u5355\u5DF2\u53D6\u6D88";
        content = "\u8BA2\u5355\u5DF2\u7ECF\u53D6\u6D88\uFF0C\u6B22\u8FCE\u518D\u6B21\u5149\u4E34\uFF01";
        break;
      case 2:
        statu = "\u8BA2\u5355\u5DF2\u5B8C\u6210";
        content = "\u8BA2\u5355\u5DF2\u7ECF\u5B8C\u6210\uFF0C\u6B22\u8FCE\u518D\u6B21\u5149\u4E34\uFF01";
        break;
      case 3:
        statu = "\u8BA2\u5355\u5DF2\u5B8C\u6210";
        content = "\u611F\u8C22\u60A8\u7684\u8D2D\u4E70\uFF0C\u6B22\u8FCE\u518D\u6B21\u5149\u4E34\uFF01";
        break;
    }
    let orderType = "";
    switch (pages_order_detail_order_detail_config.orderDetailItem1.type) {
      case 0:
        orderType = "\u914D\u9001\u4E0A\u95E8";
        break;
      case 1:
        orderType = "\u5230\u5E97\u81EA\u63D0";
        break;
    }
    return (_ctx, _cache) => {
      return {
        a: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).orderNum),
        b: common_vendor.t(common_vendor.unref(statu)),
        c: common_vendor.t(common_vendor.unref(content)),
        d: common_assets._imports_0$4,
        e: common_assets._imports_1$2,
        f: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).address),
        g: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).linkman),
        h: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).phoneNum),
        i: common_vendor.f(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).orderDetail, (item, index, i0) => {
          return {
            a: item.image,
            b: common_vendor.t(item.name),
            c: common_vendor.t(item.finalPrice),
            d: common_vendor.t(item.amount)
          };
        }),
        j: common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).orderCode,
        k: common_vendor.t(parseFloat(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).integral).toFixed(0)),
        l: common_vendor.p({
          title: "\u83B7\u5F97\u79EF\u5206",
          border: 0
        }),
        m: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).originPrice),
        n: common_vendor.p({
          title: "\u5546\u54C1\u91D1\u989D",
          border: 0
        }),
        o: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).delivery),
        p: common_vendor.p({
          title: "\u914D\u9001\u8D39",
          border: 0
        }),
        q: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).totalDiscount),
        r: common_vendor.p({
          title: "\u5E97\u94FA\u6D3B\u52A8",
          border: 0
        }),
        s: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).totalPrice),
        t: common_vendor.p({
          title: "\u5B9E\u4ED8\u91D1\u989D",
          border: 0
        }),
        v: common_vendor.p({
          border: 0
        }),
        w: common_vendor.p({
          title: "\u4E0B\u5355\u95E8\u5E97",
          border: 0
        }),
        x: common_vendor.t(common_vendor.unref(orderType)),
        y: common_vendor.p({
          title: "\u8BA2\u5355\u7C7B\u578B",
          border: 0
        }),
        z: common_vendor.p({
          border: 0
        }),
        A: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).orderCode),
        B: common_vendor.p({
          title: "\u8BA2\u5355\u7F16\u53F7",
          border: 0
        }),
        C: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).startTime),
        D: common_vendor.p({
          title: "\u4E0B\u5355\u65F6\u95F4",
          border: 0
        }),
        E: common_vendor.t(common_vendor.unref(pages_order_detail_order_detail_config.orderDetailItem1).payTime),
        F: common_vendor.p({
          title: "\u4E0B\u5355\u65F6\u95F4",
          border: 0
        }),
        G: common_vendor.p({
          border: 0
        })
      };
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-a1253e17"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/order_detail/order_detail.vue"]]);
wx.createPage(MiniProgramPage);
