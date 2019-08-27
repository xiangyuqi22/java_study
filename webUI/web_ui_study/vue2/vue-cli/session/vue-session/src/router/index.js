import Vue from 'vue'
import Router from 'vue-router'
import User from '@/components/User'
import Login from '@/components/Login'

Vue.use(Router)

const router = new Router({
  routes: [{
      path: '/',
      name: 'UserLink',
      component: User
    },
    {
      path: '/login',
      name: 'LoginLink',
      component: Login
    }
  ],
  mode: "history",
});

//全局登陆守卫
router.beforeEach((to, from, next) => {
  console.log(to);
  if (!sessionStorage.getItem("user") && to.name != "LoginLink") {
    alert("请先登陆");
    next({
      name: 'LoginLink'
    });
  } else {
    next();
  }

})

export default router;
