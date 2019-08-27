<template>
  <div id="app">
    <app-header></app-header>
    <router-view/>
  </div>
</template>

<script>
  
  var name = "myname";
  import Header from './components/common/Header'
export default {
  name: 'App',
  components:{
    "app-header":Header
  }
}
</script>

<style>
</style>
