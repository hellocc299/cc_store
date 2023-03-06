"use strict";
const common_vendor = require("../common/vendor.js");
class Cache {
  setCache(key, value) {
    common_vendor.index.setStorage({
      key,
      data: JSON.stringify(value)
    });
  }
  getCache(key) {
    const value = common_vendor.index.getStorageSync(key);
    if (value) {
      return JSON.parse(value);
    }
  }
  deleteCache(key) {
    common_vendor.index.removeStorage({
      key
    });
  }
  cleanCache() {
    common_vendor.index.clearStorage();
  }
}
const cache = new Cache();
exports.cache = cache;
