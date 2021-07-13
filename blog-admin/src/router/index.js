import Vue from 'vue'
import Router from 'vue-router'
import Home from "../views/Home";
import addArticle from "../views/Article/addArticle";
import allArticle from "../views/Article/allArticle";
import allComment from "../views/Comment/allComment";
import EditArticle from "../views/Article/EditArticle";
import AllType from "../views/Type/AllType";
import Login from "../views/Login";
import User from "../views/Others/User";
import Index from "../views/Index"


Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden:true,
    },
    {
      path: '/home',
      name: '文章管理',
      component: Home,
      redirect:'/index',
      children:[
        {
          path: '/index',
          name: '首页',
          component: Index,
          hidden: true

        },

        {
          path: '/allArticle',
          name: '全部文章',
          component: allArticle,
        },
        {
          path: '/addArticle',
          name: '写文章',
          component: addArticle,
        },
        {
          path: '/editArticle/:id',
          name: '编辑',
          component: EditArticle,
          hidden:true,

        },
      ]
    },

    {
      path: '/type',
      name: '分类管理',
      component: Home,
      children:[
        {
          path: '/AllType',
          name: '全部分类',
          component: AllType,
        },
      ]
    },

    {
      path: '/comment',
      name: '评论管理',
      component: Home,
      children:[
        {
          path: '/allComment',
          name: '全部评论',
          component: allComment,
        },
      ]
    },

    {
      path: '/type',
      name: '其他设置',
      component: Home,
      children:[
        {
          path: '/user',
          name: '个人信息',
          component: User,
        }

      ]
    },


  ]
})
