<template>
  <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>

</template>

<script>
  import AboutCard from './AboutCard'
  export default{
    data(){
      return {
        title:"点餐文档",
        content:"酱板鸭"
      }
    },
    components:{
      AboutCard
    }
  }

</script>

<style>
</style>
