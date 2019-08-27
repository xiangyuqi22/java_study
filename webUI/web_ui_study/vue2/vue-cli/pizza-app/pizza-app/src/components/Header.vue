<template>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <router-link class="py-2" :to="homeLink">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        </router-link>
        <router-link class="navbar-brand" :to="{name:'homeLink'}">Pizza点餐系统</router-link>

      <ul class="navbar-nav ">
        <li class="nav-item"><router-link :to="{name:'homeLink'}" class="nav-link">主页</router-link></li>
        <li class="nav-item"><router-link :to="{name:'menuLink'}" class="nav-link">菜单</router-link></li>
        <li class="nav-item"><router-link :to="{name:'adminLink',params:{'username':username}}" class="nav-link">管理</router-link></li>
        <li class="nav-item"><router-link :to="aboutLink" class="nav-link">关于我们</router-link></li>
      </ul>

      <ul class="navbar-nav ml-auto">
        <li class="nav-item"><router-link :to="loginLink" class="nav-link">登陆</router-link></li>
        <li class="nav-item"><router-link :to="registerLink" class="nav-link">注册</router-link></li>
        <li class="nav-item"><a @click="goBack" class="nav-link">返回</a></li>
        <li class="nav-item"><router-link to="history" class="nav-link">历史记录</router-link></li>
      </ul>
    </nav>

  </header>
</template>

<script>
  export default {
    data(){
      return {
        homeLink : "/",
        menuLink:"menu",
        adminLink:"admin",
        loginLink:"login",
        aboutLink:"about",
        registerLink:"register",
        username : "xiangning"
      }
    },
    methods:{
      goBack(){
        this.$router.go(-1);
      }
    }
  }

</script>

<style>
</style>
