export interface IAccount {
  username: string,
  password: string
}

export interface ILoginRequest {
  staff_login_info: any,
  access_token: string,
  refresh_token: string
}

export interface IStaffMenus {
  id: string,
  menuId: number,
  menu: string,
  url: string,
  createTime: any,
  updateTime: any
}