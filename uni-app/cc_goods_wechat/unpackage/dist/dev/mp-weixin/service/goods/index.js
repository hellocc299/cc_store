"use strict";
const service_request_index = require("../request/index.js");
function getClassifyRequest() {
  return service_request_index.request({
    url: "/classify/findAllClassifies",
    data: null,
    method: "get"
  });
}
function findGoodsByIdRequest(id) {
  return service_request_index.request({
    url: "/goods/findGoodsByClassifyId?id=" + id,
    data: null,
    method: "post"
  });
}
exports.findGoodsByIdRequest = findGoodsByIdRequest;
exports.getClassifyRequest = getClassifyRequest;
