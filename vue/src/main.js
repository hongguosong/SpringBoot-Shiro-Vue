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
import '@/navigationGuard' // 权限
import { service as api } from './utils/api'
import { hasPermission } from './utils/hasPermission'
import animated from 'animate.css'
import moment from 'moment/moment'

import BaiduMap from 'vue-baidu-map'
Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: '9LTvKXR8ywtiqm3qLYh9d6kpFuO7LIYS'
})

Vue.use(ElementUI, { locale })
Vue.use(animated)

// Vue.filter('moment', function (value, formatString) {
//   formatString = formatString || 'YYYY-MM-DD HH:mm:ss'
//   return moment(value).format(formatString)
// })
Vue.prototype.moment = function (value, formatString) {
  formatString = formatString || 'YYYY-MM-DD HH:mm:ss'
  return moment(value).format(formatString)
}

Vue.prototype.api = api
Vue.prototype.$echarts = echarts
Vue.prototype.$serverURL = 'http://localhost:8080/'
websocket.serverURL = Vue.prototype.$serverURL
Vue.prototype.websocket = websocket
Vue.prototype.$ELEMENT = { size: 'mini' }
// 全局的常量
Vue.prototype.hasPerm = hasPermission
// 生产环境时自动设置为 false 以阻止 vue 在启动时生成生产提示。
Vue.config.productionTip = (process.env.NODE_ENV !== 'production')

// eslint-disable-next-line
String.prototype.strFormat = function () {
  var args = arguments
  return this.replace(/\{(\d+)\}/g, function (m, i) {
    return args[i]
  })
}

// eslint-disable-next-line
Date.prototype.format = function (fmt) {
  var o = {
    'M+': this.getMonth() + 1,
    'd+': this.getDate(),
    'h+': this.getHours(),
    'm+': this.getMinutes(),
    's+': this.getSeconds(),
    'q+': Math.floor((this.getMonth() + 3) / 3),
    'S': this.getMilliseconds()
  }
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length))
    for (var k in o) {
      if (new RegExp('(' + k + ')').test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
      }
    }
  }
  return fmt
}

// 引入mockjs
require('./mock.js')

new Vue({ //eslint-disable-line
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
