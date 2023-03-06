export interface ITableItem {
  prop?: string,
  label: string,
  minWidth: string,
  slotName?: string,
  fixed?: boolean
}

export interface ITable {
  propList: ITableItem[],
  showIndexColumn?: boolean,
  showSelectColumn?: boolean
}
