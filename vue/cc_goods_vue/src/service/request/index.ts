import axios from 'axios'
import type { AxiosInstance } from 'axios'
import type { CCRequestInterceptors, CCRequestConfig } from './type'
import { ElMessage } from 'element-plus/lib/components'

enum ErrorCode {
  verifyCode = '验证码错误！'
}

class CCRequest {
  instance: AxiosInstance
  interceptors?: CCRequestInterceptors

  constructor(config: CCRequestConfig) {
    this.instance = axios.create(config)
    this.interceptors = config.interceptors

    // 1. config的interceptor
    this.instance.interceptors.request.use(
      this.interceptors?.requestInterceptor,
      this.interceptors?.requestInterceptorCatch
    )

    this.instance.interceptors.response.use(
      this.interceptors?.responseInterceptor,
      this.interceptors?.responseInterceptorCatch
    )

    // 2. 所有实例的
    this.instance.interceptors.request.use(
      (config) => {
        return config
      },
      (err) => {
        ElMessage({
          message: '未知错误',
          type: 'warning'
        })
        return err
      }
    )

    this.instance.interceptors.response.use(
      (res) => {
        const data = res.data
        if(data.code === 200 && data.message !== null) {
          ElMessage({
            message: res.data.message,
            type: 'success'
          })
        }
        if(res.data.code !== 200 && res.data.message !== undefined) {
          ElMessage({
            message: res.data.message,
            type: 'error'
          })
        }
        return data
      },
      (err) => {
        ElMessage({
          message: err.message
        })
        return err
      }
    )
  }

  // 单个请求
  request<T>(config: CCRequestConfig<T>): Promise<T> {
    return new Promise((resolve, reject) => {
      if(config.interceptors?.requestInterceptor) {
        config = config.interceptors.requestInterceptor(config)
      }

      this.instance.request<any, T>(config).then((res: any) => {
        if(config.interceptors?.responseInterceptor) {
          res = config.interceptors.responseInterceptor(res)
        }
        if(res.data !== null && res.code === 200) {
          resolve(res.data)
        }
        resolve(res)
      }).catch((err) => {
        if(config.interceptors?.responseInterceptorCatch) {
          err = config.interceptors.responseInterceptorCatch(err)
        }
        reject(err)
      })
    })
  }

  get<T>(config: CCRequestConfig<T>): Promise<T> {
    return this.request({...config, method: 'GET'})
  }
  post<T>(config: CCRequestConfig<T>): Promise<T> {
    return this.request({...config, method: 'POST'})
  }
  delete<T>(config: CCRequestConfig<T>): Promise<T> {
    return this.request({...config, method: 'DELETE'})
  }
  patch<T>(config: CCRequestConfig<T>): Promise<T> {
    return this.request({...config, method: 'PATCH'})
  }
}

export default CCRequest
