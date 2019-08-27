<template>
  <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>
</template>

<script>
  import AboutCard from "../AboutCard"

  export default{
    data(){
      return {
        title:"姓名",
        content:"古木项羽齐"
      }
    },
    components:{
      AboutCard
    }
  }
</script>

<style>
</style>
