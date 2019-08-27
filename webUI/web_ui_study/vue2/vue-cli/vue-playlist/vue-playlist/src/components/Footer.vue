<template>
  <footer>
    <div> {{copyright}}   -- {{title}}</div>
  </footer>
</template>

<script>
  export default{
    name : "Footer",
    data(){
      return {
        copyright:"@copyright 2019 xiangning vue"
      }
    },
    props:{
      "title" : {
        type:String,
        required:true
      }
    }
  }
</script>

<style>

  footer{
    padding: 30px;
    background: #000000;
    color: lightseagreen;
  }

</style>
