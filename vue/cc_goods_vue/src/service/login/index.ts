import ccRequest from "../index";
import { IAccount, ILoginRequest, IStaffMenus } from "./type";
import { ResponseType } from '../type'

enum LoginAPI {
  GetCode = '/verify/getCode',
  VerifyCode = '/verify/checkCode?code=',
  StaffLogin = '/staffLogin/login',
  GetStaffMenus = '/staffMenus/getMenus'
}

export function getCodeRequest() {
  return ccRequest.get<Blob>({
    url: LoginAPI.GetCode,
    responseType: ResponseType.BLOB
  })
}

export function verifyCodeRequest(code: string): any{
  return ccRequest.post({
    url: LoginAPI.VerifyCode + code,
  })
}

export function loginRequest(account: IAccount) {
  return ccRequest.post<ILoginRequest>({
    url: LoginAPI.StaffLogin,
    data: account
  })
}

export function getStaffMenusRequest() {
  return ccRequest.get<IStaffMenus>({
    url: LoginAPI.GetStaffMenus
  })
}
