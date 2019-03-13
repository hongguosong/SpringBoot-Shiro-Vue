import Vue from 'vue'
import 'normalize.css/normalize.css'// A modern alternative to CSS resets
import echarts from 'echarts'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'
import App from './App'
import router from './router'
import store from './store'
import websocket from './utils/websocket'
import '@/icons' // icon
import '@/permission' // 权限
import {default as api} from './utils/api'
import {hasPermission} from "./utils/hasPermission";

import BaiduMap from 'vue-baidu-map'
Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: '9LTvKXR8ywtiqm3qLYh9d6kpFuO7LIYS'
})

Vue.use(ElementUI, {locale})
Vue.prototype.api = api
Vue.prototype.$echarts = echarts
Vue.prototype.websocket = websocket
//全局的常量
Vue.prototype.hasPerm = hasPermission
//生产环境时自动设置为 false 以阻止 vue 在启动时生成生产提示。
Vue.config.productionTip = (process.env.NODE_ENV != 'production')

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {App}
})
