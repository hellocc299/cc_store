"use strict";
const common_vendor = require("../../common/vendor.js");
const utils_cache = require("../../utils/cache.js");
const BASE_URL = "http://localhost:9000";
function request({ url, data, method }) {
  return new Promise((resolve, reject) => {
    var _a;
    common_vendor.index.request({
      url: BASE_URL + url,
      data,
      method,
      header: {
        Authorization: (_a = utils_cache.cache.getCache("accessToken")) != null ? _a : ""
      },
      success: ({ data: data2 }) => {
        if (data2.code === 200) {
          resolve(data2.data);
        } else {
          common_vendor.index.showToast({
            title: data2.message,
            icon: "none",
            mask: true,
            duration: 3e3
          });
          reject(data2.message);
        }
      },
      fail: (error) => {
        reject(error);
      },
      complete: () => {
        common_vendor.index.hideLoading();
      }
    });
  });
}
exports.request = request;
