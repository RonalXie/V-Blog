import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/Index'
import Home from "../views/Home";
import Article from "../views/Article";
import About from "../views/About";

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      redirect:'/home',
      children:[
        {
          path:"/home",
          name:"Home",
          component:Home,
        },
        {
          path:"/article/:id",
          name:"Article",
          component:Article,
        },
        {
          path:"/about",
          name:"About",
          component:About,
        },

      ]
    },



  ],
  scrollBehavior (to, from, savedPosition) {
    return { x: 0, y: 0 } // return的结果, 就是 期望滚动到哪个的位置
  }
})
