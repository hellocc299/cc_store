class Cache {
	setCache(key: string, value: any) {
		uni.setStorage({
			key: key,
			data: JSON.stringify(value)
		})
	}
	getCache(key: string) {
		const value = uni.getStorageSync(key)
		if(value) {
		  return JSON.parse(value)
		}
	}
	deleteCache(key: string) {
	  uni.removeStorage({
	  	key: key
	  })
	}

	cleanCache() {
	  uni.clearStorage()
	}
}

export default new Cache()