<template>
  <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>
</template>

<script>
  import AboutCard from './AboutCard'
  export default{
    components:{
      AboutCard
    },
    data(){
      return {
        title:"快递信息",
        content:"顺丰速运,1年后送达"
      }
    }
  }
</script>

<style>
</style>
