"use strict";
const service_request_index = require("../request/index.js");
function loginRequest(code, avatarUrl, nickName) {
  return service_request_index.request({
    url: `/wx/login?code=${code}&avatarUrl=${avatarUrl}&nickName=${nickName}`,
    data: null,
    method: "post"
  });
}
exports.loginRequest = loginRequest;
