"use strict";
const common_assets = require("../../common/assets.js");
const common_vendor = require("../../common/vendor.js");
if (!Math) {
  (DeliveryWay + UserInfo + Collect)();
}
const DeliveryWay = () => "./cpns/delivery_way/delivery_way2.js";
const UserInfo = () => "./cpns/user_info/user_info2.js";
const Collect = () => "./cpns/collect/collect2.js";
const _sfc_main = {
  __name: "home",
  setup(__props) {
    return (_ctx, _cache) => {
      return {
        a: common_assets._imports_0
      };
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/home/home.vue"]]);
wx.createPage(MiniProgramPage);
