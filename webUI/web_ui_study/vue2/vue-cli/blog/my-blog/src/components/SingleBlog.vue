<template>
 <article id="signleBlog" class="container">

  <div class="alert alert-success" role="alert">
    <h4 class="alert-heading">{{blog.title}}</h4>
    <p class="mb-0">{{blog.content}}</p>
    <hr>
    <p>作者:{{blog.auther}}     &nbsp;&nbsp; 分类: <span v-for="cate in blog.category" :key="cate">{{cate}}  </span></p>
    <p>更新时间:{{blog.updateTime | parseTime}}</p>
  </div>

 </article>
</template>

<script>

  export default{
    data(){
      return {
        blog:{},
        id:this.$route.params.id,
      }
    },
    created() {

      // const query = Bmob.Query('vue-blog');
      // query.get(this.id).then(res => {
      //   console.log(res)
      //   this.blog = res;
      // }).catch(err => {
      //   console.log(err)
      // })

      // this.$http.get("http://jsonplaceholder.typicode.com/posts/" + this.id).then(
      //   result => {
      //     console.log(result);
      //     this.blog = result.body;
      //     console.log( this.blog)
      //   }

      this.axios.get("/blogs/" + this.id).then(result => {
        console.log(result);
        this.blog = result.data;
      })



    }

  }

</script>

<style>
</style>
