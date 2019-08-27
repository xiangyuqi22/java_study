<template>
  <div id='addBlog'>
    <div class="alert" v-bind:class="{'alert-primary':!submited,'alert-success':submited}" role="alert">
     <h2 v-if="!submited && !blogId">添加博客</h2>
     <h2 v-else-if="submited &&　!blogId">恭喜您,添加成功</h2>

     <h2 v-if="!submited && blogId">编辑博客</h2>
     <h2 v-else-if="submited &&　blogId">恭喜您,修改成功</h2>

    </div>

    <form v-if="!submited">

      <!-- 标题 -->
      <div class="form-group">
        <label for="exampleInputEmail1">博客标题:</label>
        <input class="form-control" type="text" placeholder="请输入标题" v-model="blog.title">
      </div>


      <!-- 内容  -->
      <div class="form-group">
          <label for="exampleFormControlTextarea1">博客内容</label>
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" v-model="blog.content"></textarea>
      </div>

      <!-- 分类 -->
     <div class="form-check form-check-inline" v-for="cate in categories" :key="cate">
       <input class="form-check-input" type="checkbox" v-bind:id="cate" v-bind:value="cate"   v-model="blog.category">
       <label class="form-check-label" v-bind:for="cate">{{cate}}</label>
     </div>

     <!-- 作者 -->
      <div class="form-group">
          <label for="exampleFormControlSelect1">作者</label>
          <select class="form-control" id="exampleFormControlSelect1" v-model="blog.auther">
            <option v-for="auther in authers" :key="auther">{{auther}}</option>
          </select>
       </div>


      <button type="submit" class="btn btn-primary" v-on:click.prevent="doPost">提交</button>
    </form>

    <hr>

    <div class="card">
      <h5 class="card-header">{{blog.title}}</h5>
      <div class="card-body">
        <h5 class="card-title">
          <span class="mb-3" v-for="(cate,index) in blog.category" :key="cate">
            <span v-if="index != 0"> ----- </span>
            {{cate}}
          </span>

        </h5>
        <p class="card-text" v-if="blog.content != ''">{{blog.content}}</p>
        <a href="#" class="btn btn-primary" v-show="blog.auther != ''">{{blog.auther}}</a>
      </div>


      <button class="btn btn-success">
        编辑
      </button>
    </div>



  </div>
</template>

<script>

  export default{
    data(){
      return {
        blog : {
          title : "",
          content:"",
          category : [],
          auther : "",
          updateTime:Date.parse(new Date())
        },
        categories : [
          '诗',
          '词',
          '散文',
          '赋'
        ],
        authers : [
          '李白',
          '杜甫',
          '白居易',
          '李清照',
          '纳兰性德',
          "诗经"
        ],
        submited : false,
        // blogId:this.$route.params.blogId
        blogId2 :""
      }
    },
    props:{
      "blogId":{
        default:""
      }
    },
    created(){
      console.log(this.blogId);
      if(this.blogId){
        this.axios.get("/blogs/" + this.blogId).then(result => {
          console.log(result);
          this.blog = result.data;
        })
      }

    },
    methods:{
      doPost : function(){
        // const query = Bmob.Query('vue-blog');
        // query.set("auther",this.blog.auther)
        // query.set("title",this.blog.title)
        // query.set("content",this.blog.content)
        // query.set("category",this.blog.category)
        // query.save().then(res => {
        //   console.log("res = " + res)
        //   this.submited = true;
        // }).catch(err => {
        //   console.log(err)
        // })
        this.blog.updateTime = Date.parse(new Date());
        if(this.blogId){
            this.axios.put("/blogs/" + this.blogId,this.blog).then((response) => {
              this.submited = true;
            })
        }else{
          this.axios.post("/blogs",this.blog).then((response) => {
            this.submited = true;
          })
        }

        // return;
//
//         this.$http.post("https://jsonplaceholder.typicode.com/posts",{
//             userId:1,
//             id:1,
//             title:this.blog.title,
//             body:this.blog.content
//         }).then(result => {
//           console.log(result);
//           return result.json();
//         }).then(data => {
//           console.log(data );
//           this.submited = true;
//         });
      },
    },

  }

</script>

<style scoped="">

  #addBlog{
    width: 80%;
    margin: 10px auto;
  }

</style>
