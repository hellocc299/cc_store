export const orderDetailItem1: any = 	{
		orderDetail: [
			{
				name: '海苔木鱼花披萨',
				image: '/static/test_image/order1_1.jpeg',
				amount: 1,
				finalPrice: '26.00',
			},
			{
				name: '奥尔良鸡肉披萨',
				image: '/static/test_image/order1_2.jpeg',
				amount: 1,
				finalPrice: '25.00',
			}
		],
		address: '广东省汕头市潮阳区棉城镇balabalabalabalabalabalabalabalabalabalabalabalabalabalabalabala',
		linkman: 'cc',
		// 0: 女 1: 男
		sex: 0,
		phoneNum: '19100000000',
		orderNum: 1,
		// 0: 配送，1: 自提
		type: 0,
		// 0: 已下单, 1: 订单取消(删掉退款标识)，2:订单制作完成（手动），3: 订单完成（一天后，，删掉退款标识）
		status: 1,
		delivery: '2.00',
		totalDiscount: '1.00',
		integral: '51.00',
		originPrice: '52.00',
		totalPrice: '53.00',
		startTime: '2022-08-10 15:40',
		payTime: '2022-08-10 15:45',
		orderCode: '202208102324'
	}

export const orderDetailItem2: any = {
	orderDetail: [
		{
			name: '乳酸菌冰面包',
			image: '/static/test_image/order2_1.jpeg',
			amount: 2,
			finalPrice: '5.00',
		},
		{
			name: '芒果冰面包',
			image: '/static/test_image/order2_2.jpeg',
			amount: 2,
			finalPrice: '5.00',
		}
	],
	address: '广东省汕头市潮阳区棉城镇balabalabalabalabalabalabalabalabalabalabalabalabalabalabalabala',
	linkman: 'cc',
	// 0: 女 1: 男
	sex: 0,
	status: 3,
	type: 0,
	delivery: '2.00',
	totalDiscount: '1.00',
	integral: '51.00',
	originPrice: '52.00',
	totalPrice: '51.00',
	startTime: '2022-06-07 13:49',
	payTime: '2022-06-07 13:49',
	orderCode: '202206063532'
}