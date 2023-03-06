interface ClassifyItemType {
	name: String,
	type: Number
}

export interface ClassifyListType {
	[index: number]: Array<ClassifyItemType>
}