import request from "../request"
enum LoginApi {
	LOGIN = '/wx/login'
}

export function loginRequest(code: string, avatarUrl: string, nickName: string) {
	return request({
		url: LoginApi.LOGIN + `?code=${code}&avatarUrl=${avatarUrl}&nickName=${nickName}`,
		data: null,
		method: 'post'
	})
}