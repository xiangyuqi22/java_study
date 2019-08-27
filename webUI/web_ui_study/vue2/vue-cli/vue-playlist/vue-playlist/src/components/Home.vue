<template>
  <div id="home">
    <app-header v-bind:title="titleHeader" v-on:changeFooterTitle="updateTitle($event)">

    </app-header>
    <users v-bind:myUsers="users"></users>

    <hr>

    <users v-bind:myUsers="users"></users>
    <app-footer v-bind:title="titleFooter"></app-footer>
  </div>
</template>


<script>
  //局部引用
import Users from "./Users.vue"
import Header from "./Header.vue"
import Footer from "./Footer.vue"
export default {
  name: 'home',
  components: {
    "users":Users,
    "app-header":Header,
    "app-footer": Footer,
  },
  data(){
    return {
      users : [],
      titleHeader : "这是头部的title内容",
      titleFooter : "这是底部的title内容"
    }
  },
  methods:{
    updateTitle : function(title){
      this.titleFooter = title;
      this.titleHeader = title;
    }
  },
  created() {
    this.$http.get("http://jsonplaceholder.typicode.com/users").then((data) => {
      console.log(data);
      this.users = data.data;
    })
  }
  // beforeCreate() {
  //   alert("beforeCreate 组件实例化之前执行的函数");
  // },
  // created:function(){
  //   alert("created  组件实例化完毕,但是还没有挂载,虚拟dom编译还没有执行,页面没有显示")
  // },
  // beforeMount:function(){
  //   alert("beforeMount 组件挂载前,页面没有展示,但是虚拟dom已经配置");
  // },
  // mounted:function(){
  //   alert("mounted 组件挂载后,虚拟dom已经配置完成,执行当前方法后,页面展示出来")
  // },
  // beforeUpdate:function(){
  //   alert("beforeUpdate 组件更新前执行")
  // },
  // updated:function(){
  //   alert("updated 组件更新之后,执行当前方法后,页面展示更新后的界面")
  // },
  // beforeDestroy:function(){
  //   alert("beforeDestroy 组件销毁前执行当前方法")
  // },
  // destroyed:function(){
  //   alert("destroyed 组件销毁后执行当前方法")
  // }
}

</script>

<style scoped="">
  h1{
    color: green;
  }
</style>
