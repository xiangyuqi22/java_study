<template>
  <div>
    <h1>主页</h1>
    <button @click="goToMenu" class="btn btn-success">Let's to Order</button>
  </div>
</template>


<script>

  export default{



    methods:{
      goToMenu(){
       // console.log( this.$router.history);
       // console.log(this.$route);
       //返回上一个页面
        this.$router.go(-1);

        //跳转到指定页面
        // this.$router.replace("menu")
        //或者使用以下方法
        // this.$router.replace("{name:'menuLink'}")

        //或者使用push
        // this.$router.push("menu");
        //或者
        this.$router.push("{name:'menuLink'}")
      }
    },
    created() {
      fetch("/apis/user2/get_user", {
            method: "get",
            headers: {
              "Content-type": "application/json",
              token: "f4c902c9ae5a2a9d8f84868ad064e706"
            },
            // body: JSON.stringify(data)
          }).then(result => {
            console.log(result);
            return result.text();
          }).then( data => {
            console.log(data);
          }).catch((e) => {
            console.error(e);
          });


          // .then(res => res.json())
          //   .then(data => {
          //     console.log(data);
          //   });
    //   this.$http.get("/apis/stbinter/telecontroller/getTeleconInfoList?access_token=c3d8f7f4-3745-44b5-94c6-8c29b7dafd05")
    //   .then(data => {
    //     console.log(data);
    //   });
    }
  }

</script>

<style>
</style>
