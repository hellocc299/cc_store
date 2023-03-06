interface TopBarItemType {
	name: String,
	type: Number
}

export interface TopBarListType {
	[index: number]: Array<TopBarItemType>
}