import CCRequest from "./request";
import { BASE_URL, TIME_OUT } from "./request/config";
import localCache from "@/utils/cache"

const ccRequest = new CCRequest({
  baseURL: BASE_URL,
  timeout: TIME_OUT,

  interceptors: {
    requestInterceptor: (config) => {
      // 把token放入头部
      const token = localCache.getCache("accessToken")
      if(token) {
        config.headers!.Authorization = token
      }
      return config
    },
    requestInterceptorCatch: (err) => {
      return err
    },
    responseInterceptor: (res: any) => {
      return res
    },
    responseInterceptorCatch: (err) => {
      return err
    }
  }
})

export default ccRequest
