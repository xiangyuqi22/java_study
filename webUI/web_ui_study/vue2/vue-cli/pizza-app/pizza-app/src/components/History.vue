<template>
  <div>
    <h1>历史记录</h1>
    <p v-for="(hr,index) in historyRecords">
          {{index}}  -- 历史记录获取失败,相关问题以后再弄
    </p>
  </div>
</template>


<script>

  export default{
    methods:{
    },
    data(){
      return{
        historyRecords:this.$route.matched
      }
    },
  }

</script>

<style>
</style>
