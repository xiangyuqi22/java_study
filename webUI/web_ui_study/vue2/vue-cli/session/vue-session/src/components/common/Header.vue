<template>

  <header class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <router-link :to="{name:'UserLink'}" class="py-2 navbar-brand" >
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
          stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto">
          <circle cx="12" cy="12" r="10"></circle>
          <line x1="14.31" y1="8" x2="20.05" y2="17.94"></line>
          <line x1="9.69" y1="8" x2="21.17" y2="8"></line>
          <line x1="7.38" y1="12" x2="13.12" y2="2.06"></line>
          <line x1="9.69" y1="16" x2="3.95" y2="6.06"></line>
          <line x1="14.31" y1="16" x2="2.83" y2="16"></line>
          <line x1="16.62" y1="12" x2="10.88" y2="21.94"></line>
        </svg>
      </router-link>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <router-link :to="{name:'UserLink'}" class=" nav-link">
                用户中心
                <span v-if="getUserData.data != null">
                   欢迎您:{{getUserData.data.name}}
                </span>
              </router-link>
            </li>

            <li class="nav-item" v-if="getUserData.data == null">
              <router-link :to="{name:'LoginLink'}" class=" nav-link">
                登陆
              </router-link>
            </li>

            <li class="nav-item" v-if="getUserData.data != null">
              <a  class=" nav-link" v-on:click.prevent="logout()" href="#">
                退出
              </a>
            </li>
          </ul>
        </div>
    </nav>
  </header>

</template>

<script>

  export default{
    data(){
      return {
        userData : this.USER
      }
    },
    methods:{
      logout(){

        if(confirm("您确定要退出吗?")){
          this.axios.post("/api/login/out").then(result => {
            sessionStorage.removeItem("user");
            this.userData.isLogin = false;
            this.userData.data = {};
            this.$router.push("{name:'LoginLink'}")
          })
        }
      }
    },
    computed:{
      getUserData(){
        this.USER.data = JSON.parse(sessionStorage.getItem("user"));
        console.log( "this.userData.data.name = " + this.userData.data);
        return this.userData;
      },
    }
  }


</script>

<style>
</style>
