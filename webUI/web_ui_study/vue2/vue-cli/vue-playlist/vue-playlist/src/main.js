// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import Resource from 'vue-resource'
import Home from './components/Home.vue'
import HelloWorld from './components/HelloWorld.vue'
//全局引用
// import Users from './components/Users.vue'
// Vue.component("users",Users);
Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(Resource)

const routes = [
      {path:"/",component:Home},
      {path:"/helloworld",component:HelloWorld},
]

const router = new VueRouter({
  routes ,// (缩写) 相当于 routes: routes,
  mode:"history"
})


/* eslint-disable no-new */
var vue = new Vue({
  router,
  el: '#app',
  components: { App },
  template: '<App/>'
})
