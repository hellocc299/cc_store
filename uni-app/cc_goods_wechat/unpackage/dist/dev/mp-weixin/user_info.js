"use strict";
const common_vendor = require("./common/vendor.js");
const utils_format = require("./utils/format.js");
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "user_info",
  setup(__props) {
    const store = common_vendor.useStore();
    const accessToken = common_vendor.computed$1(() => store.state.login.accessToken);
    const userInfo = common_vendor.computed$1(() => store.state.login.userInfo);
    common_vendor.computed$1(() => store.state.login.userInfo.avatarUrl);
    common_vendor.computed$1(() => store.state.login.userInfo.nickName);
    const getUserProfile = () => {
      return new Promise((resolve, reject) => {
        common_vendor.index.getUserProfile({
          desc: "\u83B7\u53D6\u4F60\u7684\u6635\u79F0\u3001\u5934\u50CF\u53CA\u5730\u533A",
          success: (userRes) => {
            resolve(userRes);
          },
          fail: (userErr) => {
            common_vendor.index.showToast({
              title: "\u6388\u6743\u5931\u8D25",
              icon: "error"
            });
            reject(userErr);
          }
        });
      });
    };
    const getLoginCode = () => {
      return new Promise((resolve, reject) => {
        common_vendor.index.login({
          provider: "weixin",
          success: (loginRes) => {
            resolve(loginRes);
          }
        });
      });
    };
    const login = () => {
      let userProFile = getUserProfile();
      let loginCode = getLoginCode();
      loginCode.then((code) => {
        return code;
      }).then((logCode) => {
        return new Promise((resolve, reject) => {
          userProFile.then((res) => {
            const code = logCode.code;
            const avatarUrl2 = res.userInfo.avatarUrl;
            const nickName2 = res.userInfo.nickName;
            store.dispatch("login/wxLoginAction", { code, avatarUrl: avatarUrl2, nickName: nickName2 });
            resolve(res);
          }).catch((err) => {
            reject(err);
          });
        });
      }).catch((err) => {
        console.log("userProfile-err", err);
      });
    };
    return (_ctx, _cache) => {
      return common_vendor.e({
        a: !common_vendor.unref(accessToken)
      }, !common_vendor.unref(accessToken) ? {
        b: common_vendor.o(($event) => login())
      } : {
        c: common_vendor.unref(userInfo).avatarUrl,
        d: common_vendor.t(common_vendor.unref(userInfo).nickName),
        e: common_vendor.t(common_vendor.unref(utils_format.formatPrice)(common_vendor.unref(userInfo).growth))
      });
    };
  }
});
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-1b403a52"], ["__file", "/Users/cc/Desktop/cc_goods/uni-app/cc_goods_wechat/pages/home/cpns/user_info/user_info.vue"]]);
exports.Component = Component;
