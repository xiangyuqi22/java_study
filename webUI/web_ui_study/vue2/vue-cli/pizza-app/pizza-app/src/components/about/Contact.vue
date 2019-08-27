<template>
  <div>
    <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>

     <router-link tag="button" class="btn btn-success " :to="{name:'persionNameLink'}">姓名</router-link>
     <router-link tag="button" class="btn btn-success " :to="{name:'phoneLink'}">电话</router-link>

    <router-view></router-view>
  </div>

</template>

<script>
  import AboutCard from './AboutCard'
  export default{
    data(){
      return {
        title:"联系我们",
        content:"email:xnaxt@qq.com"
      }
    },
    components:{
      AboutCard
    },

     beforeRouteEnter (to, from, next) {
       // 在渲染该组件的对应路由被 confirm 前调用
       // 不！能！获取组件实例 `this`
       // 因为当守卫执行前，组件实例还没被创建
       console.log("beforeRouteEnter")
       next(vm => {
         vm.content = "xiangning@gdcattsoft.com";
       });
      },
      beforeRouteUpdate (to, from, next) {
        // 在当前路由改变，但是该组件被复用时调用
        // 举例来说，对于一个带有动态参数的路径 /foo/:id，在 /foo/1 和 /foo/2 之间跳转的时候，
        // 由于会渲染同样的 Foo 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
        // 可以访问组件实例 `this`
        console.log("beforeRouteUpdate")
        next();
      },
      beforeRouteLeave (to, from, next) {
        console.log("beforeRouteLeave")
        next();
        // 导航离开该组件的对应路由时调用
        // 可以访问组件实例 `this`
      }
  }

</script>

<style>
</style>
