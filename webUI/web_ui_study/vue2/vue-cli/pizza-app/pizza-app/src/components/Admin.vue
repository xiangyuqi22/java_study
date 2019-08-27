<template>
  <div>
    <h1>管理中心</h1>
    <h2>用户名:{{username}}</h2>
  </div>
</template>

<script>
export default{
  props : {
    username:{
      type:String
    }
  },
}
</script>

<style>
</style>
