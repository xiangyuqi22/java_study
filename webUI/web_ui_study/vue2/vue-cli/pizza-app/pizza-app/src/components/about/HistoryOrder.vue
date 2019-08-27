<template>
  <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>
</template>

<script>
  import AboutCard from "./AboutCard"

  export default{
    data(){
      return {
        title:"历史订单",
        content:"酱板鸭100只"
      }
    },
    components:{
      AboutCard
    }
  }
</script>

<style>
</style>
