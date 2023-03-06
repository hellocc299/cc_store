"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
const store_index = require("../../store/index.js");
const utils_cache = require("../../utils/cache.js");
const utils_format = require("../../utils/format.js");
require("../../store/login/index.js");
require("../../service/login/index.js");
require("../../service/request/index.js");
require("../../store/classify/index.js");
require("../../service/goods/index.js");
require("../../store/goods/index.js");
if (!Array) {
  const _component_van_popup = common_vendor.resolveComponent("van-popup");
  _component_van_popup();
}
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "menu",
  setup(__props) {
    const store = store_index.useStore();
    common_vendor.onLoad(() => {
      store.dispatch("classify/getClassifyListAction");
    });
    const classifyList = utils_cache.cache.getCache("classifyList");
    const current = common_vendor.ref(classifyList[0].classifyId);
    const getContList = (id) => {
      store.dispatch("goods/getGoodsListByIdAction", id);
    };
    getContList(current.value);
    const goodsList = common_vendor.computed$1(() => store.state.goods.goodsList);
    const select = (item) => {
      current.value = item.classifyId;
      getContList(current.value);
    };
    const show = common_vendor.ref(false);
    const showDetail = () => {
      show.value = true;
    };
    return (_ctx, _cache) => {
      return {
        a: common_assets._imports_0$5,
        b: common_vendor.f(common_vendor.unref(classifyList), (item, k0, i0) => {
          return {
            a: item.imgUrl,
            b: common_vendor.t(item.name),
            c: common_vendor.n(item.classifyId == current.value ? "active" : ""),
            d: common_vendor.o(($event) => select(item), item.classifyId),
            e: item.classifyId
          };
        }),
        c: common_vendor.f(common_vendor.unref(goodsList), (item, k0, i0) => {
          return {
            a: item.goodsImg.imgUrl,
            b: common_vendor.t(item.name),
            c: common_vendor.t(item.description),
            d: common_vendor.t(common_vendor.unref(utils_format.formatPrice)(item.price)),
            e: item.goodsId
          };
        }),
        d: common_assets._imports_1$3,
        e: common_assets._imports_2,
        f: common_vendor.o(($event) => showDetail()),
        g: common_vendor.p({
          show: show.value,
          closeable: true,
          closeIcon: "close",
          position: "bottom",
          customStyle: "height: 20%"
        })
      };
    };
  }
});
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-388b40d3"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/menu/menu.vue"]]);
wx.createPage(MiniProgramPage);
