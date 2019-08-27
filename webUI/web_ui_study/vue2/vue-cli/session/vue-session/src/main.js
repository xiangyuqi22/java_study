// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Qs from 'qs'
import User from '../static/user.js'

Vue.use(VueAxios, axios)
Vue.prototype.USER = User;


//配置axios

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  // 使用qs对参数进行处理
  config.data = Qs.stringify(config.data)
  return config
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error)
})


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
