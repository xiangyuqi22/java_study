<template>
  <header>
    <div> {{title}}</div>
   <button @click="changeTitle">change</button>
  </header>
</template>

<script>
  export default {
    name : "Header",
    props:{
      title:{
        type: String,
        required:true
      }
    },
    methods:{
      changeTitle : function(){
        this.$emit("changeFooterTitle","vue是一个好东西,显示在页面底部");
      }
    }
  }
</script>

<style>

header{
  background: lightseagreen;
  padding: 30px;
  font-weight: bold;
  font-size: 20px;
}

</style>
