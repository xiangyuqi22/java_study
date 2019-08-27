<template>
  <div id="app">
    <ul>
    	<li><router-link tag="button" to="/">Home</router-link></li>
    	<li><router-link tag="button" to="/helloworld">HelloWorld</router-link></li>
    </ul>
    <router-view></router-view>
  </div>
</template>


<script>
export default {
  name: 'App',
  components: {

  },
  data(){
    return {
    }
  },
  methods:{
  },

}

</script>

<style >
  h1{
    color: green;
  }
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

<style scoped="">
  ul{
    width: 80%;
  }
  li{
    list-style-type: none;
    padding: 20px;
    font-size: 20px;
  }
</style>
