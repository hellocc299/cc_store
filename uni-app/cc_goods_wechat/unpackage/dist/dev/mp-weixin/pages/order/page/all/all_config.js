"use strict";
const topbarList = [
  {
    name: "\u5168\u90E8",
    type: 0
  },
  {
    name: "\u81EA\u63D0",
    type: 1
  },
  {
    name: "\u5916\u9001",
    type: 2
  }
];
const classifyList = [
  {
    name: "\u5168\u90E8",
    type: 0
  },
  {
    name: "\u5DF2\u53D6\u6D88",
    type: 1
  },
  {
    name: "\u9000\u6B3E/\u552E\u540E",
    type: 2
  }
];
const orderList = [
  {
    orderDetail: ["/static/test_image/order1_1.jpeg", "/static/test_image/order1_2.jpeg"],
    orderNum: 1,
    orderCode: "202208102324",
    status: 1,
    deliveryType: 0,
    allAmount: 2,
    totalPrice: "51.00",
    startTime: "2022-08-10 15:40"
  },
  {
    orderDetail: ["/static/test_image/order2_1.jpeg", "/static/test_image/order2_2.jpeg"],
    orderNum: 16,
    orderCode: "202206063532",
    deliveryType: 1,
    status: 3,
    allAmount: 4,
    totalPrice: "22.00",
    startTime: "2022-06-07 13:49"
  }
];
exports.classifyList = classifyList;
exports.orderList = orderList;
exports.topbarList = topbarList;
