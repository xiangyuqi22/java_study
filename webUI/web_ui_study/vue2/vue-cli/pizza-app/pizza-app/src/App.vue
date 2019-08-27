<template>
  <div id="app">
    <div class="container">
      <app-header></app-header>
    </div>
    <div class="container">
      <router-view></router-view>
    </div>
    <br>

    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-md-12">
          <router-view name="deliveryView"></router-view>
        </div>
        <div class="col-sm-12 col-md-12">
          <router-view name="contactView"></router-view>
        </div>

        <div class="col-sm-12 col-md-12">
          <router-view name="historyView"></router-view>
        </div>
        <div class="col-sm-12 col-md-12">
          <router-view name="orderingView"></router-view>
        </div> 
        <div class="col-sm-12 col-md-12">
          <router-view name="orderingView"></router-view>
        </div>
        <div class="col-sm-12 col-md-12">
          <router-view name="orderingView"></router-view>
        </div>
        <div class="col-sm-12 col-md-12">
          <router-view name="orderingView"></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
export default {
  name: 'app',
  components:{
    appHeader:Header
  }
}
</script>

<style>

</style>
