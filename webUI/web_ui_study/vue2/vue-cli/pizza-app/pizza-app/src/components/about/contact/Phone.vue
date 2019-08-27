<template>
  <AboutCard v-bind:title="title" v-bind:content="content"></AboutCard>
</template>

<script>
  import AboutCard from "../AboutCard"

  export default{
    data(){
      return {
        title:"联系电话",
        content:"18900009999"
      }
    },
    components:{
      AboutCard
    }
  }
</script>

<style>
</style>
