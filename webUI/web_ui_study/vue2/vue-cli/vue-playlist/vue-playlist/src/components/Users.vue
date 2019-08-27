<template>
  <div class="users">
    <ul>
    	<li v-for="user in myUsers" v-bind:class="{selectColor:isGreen}" v-on:click="isGreen = !isGreen">
          {{user.name}} -- {{user.username}} -- {{user.email}}
      </li>
    </ul>
    <button v-on:click="deleteUser">删除</button>
  </div>
</template>


<script>
  export default{
    name : "users",
    props:{
      "myUsers":{
        type:Array,
        required:true
      }
    },
    data(){
      return {
        isGreen:false
      }
    },
    methods:{
      deleteUser:function(){
        this.myUsers.pop();
        console.log(this.myUsers);
      }
    }
  }

</script>

<style scoped="">
.users{
  width: 100%;
  max-width: 1200px;
  margin: 40px auto;
  padding: 0px 20px;
  box-sizing: border-box;
}

ul{
  display: flex;
  flex-wrap: wrap;
  list-style-type: none;
  padding: 0;
}

li{
  flex-grow: 1;
  flex-basis: 200px;
  text-align: center;
  padding: 20px;
  border: #008000 solid 1px;
  margin: 10px;
}

.selectColor{
  background: lightseagreen;
  color: white;
}

button{
  text-align: left;
}

</style>
