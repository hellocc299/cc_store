import cache from '@/utils/cache';

const BASE_URL = 'http://localhost:9000';
function request<T>({ url, data, method }) {
  return new Promise((resolve, reject) => {
    uni.request({
      url: BASE_URL + url,
      data,
      method,
      header: {
        Authorization: cache.getCache("accessToken") ?? ''
      },
      success: ({ data }) => {
        if (data.code === 200) {
          resolve(data.data);
        } else {
          uni.showToast({
            title: data.message,
            icon: 'none',
            mask: true,
            duration: 3000
          });
          reject(data.message);
        }
      },
      fail: (error) => {
        reject(error);
      },
      complete: () => {
        // 关闭加载
        uni.hideLoading();
      }
    });
  });
}

export default request;