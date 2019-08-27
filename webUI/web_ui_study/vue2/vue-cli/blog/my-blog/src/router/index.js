import Vue from 'vue'
import Router from 'vue-router'
import AddBlog from '@/components/AddBlog'
import BlogList from '@/components/BlogList'
import SingleBlog from '@/components/SingleBlog'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: BlogList
    },
    {
      path: '/add-blog/:blogId',
      name: 'addBlogLink',
      component: AddBlog,
      props:true
    },
    {
      path: '/blog-list',
      name: 'BlogListLink',
      component: BlogList
    },
    {
      path: '/single-blog/:id',
      name: 'SingleBlogLink',
      component: SingleBlog
    }
  ],
  mode : "history",
  scrollBehavior (to, from, savedPosition) {
    if(savedPosition){
      return savedPosition;
    }else{
      return {x:0,y:0};
    }
   }
})
