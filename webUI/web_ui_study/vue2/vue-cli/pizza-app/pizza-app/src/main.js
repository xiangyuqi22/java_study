import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Resource from 'vue-resource'
import {routes} from "./router/routers.js"

Vue.use(VueRouter)
Vue.use(Resource)


const router = new VueRouter({
  routes, // (缩写) 相当于 routes: routes,
  mode : "history",
   scrollBehavior (to, from, savedPosition) {
     //此方法只有在页面超出屏幕显示区域才有效
     if(to.name == "menuLink"){
      return {selector:".toHere"};
     }
     // return {x:0,y:100};
     if(savedPosition){
       return savedPosition;
     }else{
       return {x:0,y:200};
     }
    }
})

//全局守卫
// router.beforeEach((to, from, next) => {
//   if(to.name == "loginLink" || to.name == "registerLink" || to.path!="/about"){
//     next();
//   }else{
//     alert("您还没有登陆,请先登陆");
//     next({name:"loginLink"})
//   }
// })

//后置钩子
// router.afterEach((to,from ) => {
//   console.log("您正在离开" + from.name + ";去到:" + to.name);
// });

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
