import Vue from 'vue'
import Router from 'vue-router'
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading
/* layout */
import Layout from '../views/layout/Layout'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/404', component: _import('404'), hidden: true},
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: '首页',
    hidden: true,
    children: [{
      path: 'dashboard', component: _import('dashboard/index')
    }]
  }
]
var alertVue = import('../views/study/alert/Alert.vue')
export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
export const asyncRouterMap = [
  {
    path: '/system',
    component: Layout,
    redirect: '/system/article',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
    children: [
      {
        path: 'article',
        name: '文章',
        component: _import('article/article'),
        meta: {title: '文章', icon: 'example'},
        menu: 'article'
      },
      {
        path: 'cart',
        name: '购物车',
        component: _import('cart/cart'),
        meta: {title: '购物车', icon: 'form'},
        menu: 'cart'
      },
      {
        path: 'alarmHistory',
        name: '历史报警',
        component: _import('business/AlarmHistory'),
        meta: {title: '历史报警', icon: 'form'},
        menu: 'alarmHistory'
      },
      {
        path: 'Car',
        name: '汽车',
        component: _import('business/Car'),
        meta: {title: '汽车', icon: 'form'},
        menu: 'Car'
      },
      {
        path: 'Cost',
        name: '消费',
        component: _import('business/Cost'),
        meta: {title: '消费', icon: 'form'},
        menu: 'Cost'
      },
      {
        path: 'Energy',
        name: '能源',
        component: _import('business/Energy'),
        meta: {title: '能源', icon: 'form'},
        menu: 'Energy'
      },
      {
        path: 'EnergyRevise',
        name: '能源修复',
        component: _import('business/EnergyRevise'),
        meta: {title: '能源修复', icon: 'form'},
        menu: 'EnergyRevise'
      },
      {
        path: 'Flow',
        name: '流量',
        component: _import('business/Flow'),
        meta: {title: '流量', icon: 'form'},
        menu: 'Flow'
      },
      {
        path: 'FlowWhite',
        name: '流量(白)',
        component: _import('business/FlowWhite'),
        meta: {title: '流量(白)', icon: 'form'},
        menu: 'FlowWhite'
      },
      {
        path: 'Thermometer',
        name: '温度计',
        component: _import('business/Thermometer'),
        meta: {title: '温度计', icon: 'form'},
        menu: 'Thermometer'
      }
    ]
  },
  {
    path: '/studyVue',
    component: Layout,
    redirect: '',
    name: 'vue学习',
    meta: {title: 'vue学习', icon: 'eye'},
    children: [
      {
        path: 'slot',
        name: '插槽',
        component: _import('study/slot/hr-slot'),
        meta: {title: "插槽", icon: 'form'},
        menu: 'slot'
      },
      {
        path: 'prop',
        name: '属性',
        component: _import('study/prop/my-prop'),
        meta: {title: "属性", icon: 'form'},
        menu: 'prop'
      }
    ]
  },
  {
    path: '/studyElementUI',
    component: Layout,
    redirect: '/studyElementUI/button',
    name: 'element-ui学习',
    meta: {title: 'element-ui学习', icon: 'form'},
    children: [
      {
        path: 'layout',
        name: '布局',
        component: _import('study/Layout'),
        meta: {title: "布局", icon: 'form'},
        menu: 'layout'
      },
      {
        path: 'button',
        name: '按钮',
        component: _import('study/Button'),
        meta: {title: "按钮", icon: 'form'},
        menu: 'button'
      },
      {
        path: 'radio',
        name: '单选框',
        component: _import('study/Radio'),
        meta: {title: "单选框", icon: 'form'},
        menu: 'radio'
      },
      {
        path: 'checkbox',
        name: '复选框',
        component: _import('study/Checkbox'),
        meta: {title: "复选框", icon: 'form'},
        menu: 'checkbox'
      },
      {
        path: 'select',
        name: '选择器',
        component: _import('study/Select'),
        meta: {title: "选择器", icon: 'form'},
        menu: 'select'
      },
      {
        path: 'cascader',
        name: '级联选择器',
        component: _import('study/Cascader'),
        meta: {title: "级联选择器", icon: 'form'},
        menu: 'cascader'
      },
      {
        path: 'time',
        name: '时间选择器',
        component: _import('study/Time'),
        meta: {title: "时间选择器", icon: 'form'},
        menu: 'time'
      },
      {
        path: 'transform',
        name: '穿梭框',
        component: _import('study/Transfer'),
        meta: {title: "穿梭框", icon: 'form'},
        menu: 'transform'
      },
      {
        path: 'form',
        name: '表单',
        component: _import('study/Form'),
        meta: {title: "表单", icon: 'form'},
        menu: 'form'
      },
      {
        path: '/notice',
        component: Layout,
        redirect: 'notice/alert',
        name: '通知',
        meta: {title: '通知', icon: 'example'},
        children: [
          {
            path: 'alert',
            name: '警告',
            component: _import('study/alert/Alert'),
            meta: {title: '警告', icon: 'example'},
            menu: 'alert'
          },
          {
            path: 'message',
            name: '提示',
            component: () => import('../views/study/alert/Message.vue'),
            meta: {title: '提示', icon: 'example'},
            menu: 'message'
          },
          {
            path: 'messageBox',
            name: '消息框',
            component: _import('study/alert/MessageBox'),
            meta: {title: '消息框', icon: 'example'},
            menu: 'messageBox'
          },
          {
            path: 'notification',
            name: '通知框',
            component: _import('study/alert/Notification'),
            meta: {title: '通知框', icon: 'example'},
            menu: 'notification'
          }
        ]
      },
      {
        path: '/data',
        component: Layout,
        redirect: '/data/tag',
        name: '数据',
        meta: {title: '数据', icon: 'eye'},
        children: [
          {
            path: 'tag',
            name: '标签',
            component: _import('study/data/Tag'),
            meta: {title: '标签', icon: 'eye'},
            menu: 'tag'
          },
          {
            path: 'table',
            name: '表格',
            component: _import('study/data/Table'),
            meta: {title: '表格', icon: 'eye'},
            menu: 'table'
          },
          {
            path: 'badge',
            name: '标记',
            component: _import('study/data/Badge'),
            meta: {title: '标记', icon: 'eye'},
            menu: 'badge'
          }
        ]
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user',
    name: '用户权限',
    meta: {title: '用户权限', icon: 'table'},
    children: [
      {
        path: '',
        name: '用户列表',
        component: _import('user/user'),
        meta: {title: '用户列表', icon: 'user'},
        menu: 'user'
      },
      {
        path: 'role',
        name: '权限管理',
        component: _import('user/role'),
        meta: {title: '权限管理', icon: 'password'},
        menu: 'role'
      },
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]
