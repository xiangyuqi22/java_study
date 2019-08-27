<template>

  <div id="login" class="container">


    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">用户名</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="请输入用户名" v-model="user.username">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" v-model="user.password">
      </div>
      <button type="submit" class="btn btn-primary" v-on:click.prevent="login()">登录</button>
    </form>

  </div>

</template>

<script>

export default{
  data(){
    return {
      userData : this.USER,
      user : {
        "username" : "",
        "password" : ""
      }
    }
  },

  methods:{
    login(){
      console.log(this.user.username + " == " + this.user.password );

      this.axios.post("/api/login/in",this.user).then(result => {
        if(result.status == 200 && result.data.code == "200"){
          this.userData.isLogin = true;
          this.userData.data = result.data.data;
          sessionStorage.setItem('user', JSON.stringify(result.data.data));
          alert("登录成功");
          this.$router.push("/");
        }else{
          alert("登录失败");
        }

      })
    }
  },
   beforeRouteEnter (to, from, next) {
        console.log("beforeRouteEnter")
      if(sessionStorage.getItem("user") ){
        //如果是已登陆,并且又去登陆界面,那么让它去首页
        next("/");
      }
      next();
    }

}

</script>

<style>
</style>
