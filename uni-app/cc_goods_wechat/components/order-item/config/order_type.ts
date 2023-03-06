export interface OrderDetailType {
	name: string,
	image: string,
	amount: number,
	finalPrice: number
}

export interface OrderDetailItemType {
	orderDetail: OrderDetailType[],
	address: string
	name: string,
	sex: number,
	phoneNum: string,
	orderNum: number,
	orderCode: string
	type: number,
	status: number,
	delivery: number,
	totalDiscount: number,
	integral: number,
	originPrice: number,
	totalPrice: number,
	startTime: string,
	payTime: string
}

export interface OrderListType {
	orderDetailImage: String[],
	orderNum: number,
	orderCode: string,
	status: number,
	deliveryType: number,
	allAmount: number,
	totalPrice: number,
	startTime: string
}