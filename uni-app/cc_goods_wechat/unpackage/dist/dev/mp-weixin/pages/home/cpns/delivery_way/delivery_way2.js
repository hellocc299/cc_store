"use strict";
const delivery_way = require("../../../../delivery_way.js");
require("../../../../common/vendor.js");
require("../../../../common/assets.js");
require("../../../../store/index.js");
require("../../../../store/login/index.js");
require("../../../../service/login/index.js");
require("../../../../service/request/index.js");
require("../../../../utils/cache.js");
require("../../../../store/classify/index.js");
require("../../../../service/goods/index.js");
require("../../../../store/goods/index.js");
wx.createComponent(delivery_way.Component);