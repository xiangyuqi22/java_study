// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// import VueResource from 'vue-resource'
import Bmob from "hydrogen-js-sdk";
import axios from 'axios'
import VueAxios from 'vue-axios'
import utils from "../static/js/utils"


axios.defaults.baseURL = 'http://localhost:8899';

// import MyFilter from './filters/filter'

// 挂载到全局使用
Vue.prototype.Bmob = Bmob
// 初始化 SDK版本 2.0.0 以下保留之前的初始化方法
// Bmob.initialize("467ef53a1675cd5620b50dc604d493d6", "1fd068232f9a7c52f3e020114eb6e6e4");
Bmob.initialize("8614db0fdc410b77", "567432");


// Vue.use(VueResource)
Vue.use(VueAxios, axios)
Vue.config.productionTip = false

//自定义钩子/指令
Vue.directive('myStyle', {
  bind: function (el, binding, vnode) {
  //   var s = JSON.stringify
  //   el.innerHTML =
  //     'name: '       + s(binding.name) + '<br>' +
  //     'value: '      + s(binding.value) + '<br>' +
  //     'expression: ' + s(binding.expression) + '<br>' +
  //     'argument: '   + s(binding.arg) + '<br>' +
  //     'modifiers: '  + s(binding.modifiers) + '<br>' +
  //     'vnode keys: ' + Object.keys(vnode).join(', ')
    console.log(el.className);
    console.log(binding);
    console.log(vnode);
    // el.style.color = red;
    el.style.color = 'darkGreen';
  }
})

//过滤器
Vue.filter("parseTime" , function(value){
 return utils.parseTime(value);
})


// Vue.filter("to-uppercase",function(value){
//   return value.toUpperCase();
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
