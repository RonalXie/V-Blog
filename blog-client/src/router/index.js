import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/Index'
import Home from "../views/Home";
import Article from "../views/Article";
import About from "../views/About";
import QueryByType from "../views/QueryByType";
import Message from "../views/Message";
import ShowSearch from "../views/ShowSearch";

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
        {
          path:"/byType/:tid",
          name:"byType",
          component:QueryByType

        },
        {
          path:"/message",
          name:"Message",
          component:Message,

        },
        {
          path:"/showsearch/:key",
          name:"ShowSearch",
          component:ShowSearch,

        }

      ]
    },



  ],
  scrollBehavior (to, from, savedPosition) {
    return { x: 0, y: 0 } // return的结果, 就是 期望滚动到哪个的位置
  }
})
