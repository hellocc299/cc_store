import type { AxiosRequestConfig, AxiosResponse } from "axios"

export interface CCRequestInterceptors<T=AxiosResponse> {
  requestInterceptor?: (config: AxiosRequestConfig) => AxiosRequestConfig
  requestInterceptorCatch?: (error: any) => any
  responseInterceptor?: (res: T) => T
  responseInterceptorCatch?: (error: any) => any
}

export interface CCRequestConfig<T = AxiosResponse> extends AxiosRequestConfig{
  interceptors?: CCRequestInterceptors<T>
}
