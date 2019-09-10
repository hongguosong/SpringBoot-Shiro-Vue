import axios from 'axios'
import { Message } from 'element-ui'
// import { MessageBox } from 'element-ui'
// import { getToken } from '@/utils/auth'
import store from '../store'
// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_URL, // api的base_url
  timeout: 15000 // 请求超时时间2
})
// request拦截器
service.interceptors.request.use(config => {
  return config
}, error => {
  // Do something with request error
  console.error(error) // for debug
  Promise.reject(error)
})
// respone拦截器
service.interceptors.response.use(
  response => {
    const res = response.data
    if (typeof (res) === 'string') {
      return res
    }
    if (res.logType !== undefined) {
      return res
    }
    if (res.type === 'application/octet-stream') {
      return res
    }
    if (res.returnCode === '1000') {
      return res
    }
    if (res.returnCode === '100') {
      return res.returnData
    } else if (res.returnCode === '20011') {
      Message({
        showClose: true,
        message: res.returnMsg,
        type: 'error',
        duration: 500,
        onClose: () => {
          store.dispatch('FedLogOut').then(() => {
            location.reload()// 为了重新实例化vue-router对象 避免bug
          })
        }
      })
      return Promise.reject(new Error('未登录'))
    } else {
      Message({
        message: res.returnMsg,
        type: 'error',
        duration: 3 * 1000
      })
      return Promise.reject(res)
    }
  },
  error => {
    console.error('err' + error)// for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 3 * 1000
    })
    return Promise.reject(error)
  }
)
export { service }
