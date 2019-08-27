<template>

  <div id="blogList">

    <div class="alert alert-primary" role="alert">
     <h2> 博客列表</h2>
    </div>

   <div class="form-group">
       <label for="exampleInputEmail1">搜索</label>
       <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="请输入搜索内容" v-model="search">
     </div>


<!--   <div v-myStyle="styleName">

   </div> -->

   <div class="alert alert-success" role="alert" v-myStyle v-for="(blog,index) in filterBlogs" :key="blog.id">
     <router-link :to="{name:'SingleBlogLink',params:{id:blog.id}}">
      <h4 class="alert-heading">{{index + 1}} : {{blog.title | to-uppercase }}</h4>
     </router-link>
     <p class="content">{{blog.content | to-uppercase | snnipet}}</p>
     <hr>
     <p>作者:{{blog.auther}}     &nbsp;&nbsp; 分类: <span v-for="cate in blog.category" :key="cate">{{cate}}  </span></p>
     <p>更新时间:  {{blog.updateTime | parseTime}}</p>
     <p>
       <button class="btn btn-danger" v-on:click="deleteBlog(blog.id)">删除</button>
       <router-link tag="button" class="btn btn-info" v-bind:to="{name:'addBlogLink',params:{'blogId':blog.id}}">编辑</router-link>
       <button class="btn btn-info" v-on:click="edigBlog(blog.id)">编辑2</button>
     </p>
   </div>
  </div>

</template>

<script>
import utils from '../../static/js/utils.js'
  export default{
    data(){
      return {
        blogs:[],
        styleName:"name",
        search : ""
      }
    },
    methods:{
      deleteBlog(blogId){
        this.axios.delete("/blogs/" + blogId).then(result=>{
          console.log(result);
          if(result.status == 200){
            alert("删除成功");
            this.loadData();
          }
        });
      },
      loadData(){
        this.axios.get("/blogs").then(result => {
          console.log(result);
          this.blogs = result.data;
        })
      },
      edigBlog(blogId){
          // this.$router.push("{name:'addBlogLink',query:{'blogId':blogId}}");
          //链接式跳转
          this.$router.push({path:'/add-blog/'+blogId});
          console.log(utils);
      }
    },
    created() {
      // this.$http.get("http://jsonplaceholder.typicode.com/posts").then(result => {
      //   this.blogs = result.body.slice(0,20);
      // })


      // const query = Bmob.Query('vue-blog');
      // query.get("").then(res => {
      //   this.blogs = res.results;
      //   console.log(res)
      // }).catch(err => {
      //   console.log(err)
      // })
      this.loadData();
    },

    //过滤器可改变value值
    filters:{
      toUppercase(value){
        return value.toUpperCase();
      },
      snnipet(value){
        return value.slice(0,150) + "...";
      },
      // parseTime(value){
      //   return new Date(parseInt(value)).toLocaleString().replace(/:\d{1,2}$/,' ');
      // }
    },
    computed:{
      filterBlogs(){
        return this.blogs.filter(blog => {
          return blog.title.match(this.search) || blog.content.match(this.search) || blog.auther.match(this.search) || blog.category.indexOf(this.search) != -1;
        })
      },
    }
  }

</script>

<style scoped="">

  #blogList{
    width: 80%;
    margin: 10px auto;
  }

  .content{
    font-size: 15px;
  }


</style>
