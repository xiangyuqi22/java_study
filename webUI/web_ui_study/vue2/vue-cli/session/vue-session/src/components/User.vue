<template>
  <div class="user container">
  <h1>跨域请求获取用户信息</h1>
  <div v-for="user in users" :key="user.id">
    <h2>{{user.name}}</h2>
    <h3>
     姓名: {{user.name}} ---- 年龄:{{user.age}} ---- 创建时间:{{user.createTime}} ---- 性别:{{user.sex}}
    </h3>
  </div>

  </div>
</template>

<script>
export default {
  name: 'user',
  data () {
    return {
      users : []
    }
  },
  created() {
    this.axios.get("/api/user/list")
      .then( result => {
        console.log(result);
        this.users = result.data.data;
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
