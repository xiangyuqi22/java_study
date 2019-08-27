<template>
  <div class="card text-dark bg-light mb-3">
    <div class="card-header">
      {{title}}
    </div>
    <div class="card-body">
        <div class="card-title">{{title}}</div>
        {{content}}
    </div>

  </div>
</template>
<script>

  export default{
    props:{
      "title":{
          type:String,
          required:true
      },
      "content":{
        type:String,
        required:true
      }
    }
  }

</script>

<style>
</style>
