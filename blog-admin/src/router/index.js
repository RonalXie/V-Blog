import Vue from 'vue'
import Router from 'vue-router'
import Home from "../views/Home";
import Article from "../views/Article";
import Type from "../views/Type";
import addArticle from "../views/Article/addArticle";
import allArticle from "../views/Article/allArticle";
import allComment from "../views/Comment/allComment";


Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/login',
      name: 'Login',
      component: Article,
      hidden:true,
    },
    {
      path: '/',
      name: '文章管理',
      component: Home,
      children:[
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
      ]
    },

    {
      path: '/type',
      name: '分类管理',
      component: Home,
      children:[
        {
          path: '/addType',
          name: '添加分类',
          component: addArticle,
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
          path: '/addType',
          name: '音乐',
          component: addArticle,
        },
        {
          path: '/addType',
          name: '轮播图',
          component: addArticle,
        },
      ]
    },


  ]
})
