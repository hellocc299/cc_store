import App from './App'

// #ifndef VUE3
import Vue from 'vue'
import Store from './store'
Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
		Store,
    ...App
})
app.use(Store)
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import Store from './store'
import { setupStore } from './store'

export function createApp() {
  const app = createSSRApp(App)
	app.use(Store)
	setupStore()
  return {
    app
  }
}
// #endif