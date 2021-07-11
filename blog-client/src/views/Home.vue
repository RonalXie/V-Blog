<template>
<div>
  <div class="content">


      <!--      左边内容-->
        <div class="left-content">
          <div class="left-top">
            <div class="block">
              <br>

              <el-avatar :size="100" :src="this.user.avatar"></el-avatar>

              <h1>{{ this.user.username }}</h1>

              <span>{{this.user.introduction}}</span><br><br>

              <div style="padding: 0 5px 0 5px;text-align: center">
                <span style="display: inline-block;margin-right: 30px">文章 {{ this.articlesum }}</span>
                <span style="display: inline-block;margin-right: 30px">分类 {{this.typesum}}</span>
                <span style="display: inline-block;">访问 {{this.looksum}}</span>
              </div>

            </div>

          </div>
          <h3 style="color:#909090; text-align: center">热门文章</h3>
          <div class="types">
                  <div class="per_type" v-for="(v,index) in tableData" @click="goArticle(v)">
                    <el-badge :value="index+1" class="item"></el-badge>
                    {{v.title}}
                    <br>
                    <br>
                  </div>
          </div>
          <h3 style="color:#909090; text-align: center">标签墙</h3>
          <div class="tags">

            <el-tag style="cursor: pointer" type="warning" v-for="(item,index) in types" :key="index" @click="queryBytype(item.tid)">{{ item.name }}</el-tag>




          </div>

        </div>



      <!--      右边内容-->
        <div class="right_content">
          <Swiper></Swiper>

          <div class="content_card" v-for="(item, index) in page.list" @click="goArticle(item)">
                <div style="line-height:100px;position: absolute;margin-top: 10px">
                  <img style="width: 130px; height: 130px;" :src="item.img" />
                </div>
                <div style="width: 540px;height: 160px;position: absolute;margin-left: 180px;overflow: hidden;text-overflow: ellipsis;　　white-space: nowrap; ">
                  <span style="color: #99a9bf;font-size: 12px"><i class="el-icon-date"></i>&nbsp;{{item.createDate}}&nbsp;&nbsp;

                    <el-tag v-for="(type,index) in item.typeList" type="warning" :key="index" style="margin-left: 10px">{{ type.name }}</el-tag>
                    <span style="display: inline-block;float: right;margin-right: 20px"><i class="el-icon-view"></i>&nbsp;{{item.looknum}}</span>
                  </span>


                  <h3 style="  overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">{{item.title}}</h3>

                  <span>{{item.abs}}</span>


                  <h5 style="color: #909090"><i class="el-icon-s-custom"></i>&nbsp;Ronalxie</h5>
                </div>

          </div>

          <br>
          <br>
<!--分页-->
          <div style="width: 590px;margin: 0 auto;text-align: center">
            <el-pagination
              background
              layout="prev, pager, next"
              :page-size="page.pageSize"
              :total="page.total"
              :current-page="currentPage"
              @current-change="getPageArticle"
            >
            </el-pagination>
          </div>
        </div>



  </div>

</div>
</template>

<script>
import Swiper from "../components/Swiper";
import {getRequest, postRequest} from "../utils/api";
import { Loading } from 'element-ui';
export default {

  name: "Home",
  components:{
    Swiper
  },
  data(){
    return{
      user:{
        username:'',
        introduction:'',
        avatar:''
      },
      looksum:"",
      typesum:"",
      articlesum:"",
      avaterimg:'https://www.xiesiyu.top/upload/2021/04/1000-340286eb49d94ffc98449972f7bb7b84-ea2bc3481be2429f93df0a11424b4632.jpg',
      url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      contentEditor:"",
      value:"",
      tableData: [],
      currentPage:1,
      page:"",
      fullscreenLoading:false,
      types:[],
      top:[]

    }
  },
  methods:{

    queryBytype(tid){

      this.$router.push("/byType/"+tid)

    },

    openMessage() {
      const h = this.$createElement;

      this.$notify({
        title: '欢迎访问',
        message: h('i', { style: 'color: teal'}, '欢迎来到小站，这是一个记录学习的地方'),
        position: 'top-right'
      });
    },

    goArticle(item){
        this.$router.push("/article/"+item.id)
    },

    getHot(){
      var _this=this;
      getRequest("/getRecommend").then(function (response) {
          _this.tableData=response.data
      })
    },

    getTypes(){
      var _this=this;
      getRequest("/getType").then(function (response) {

        _this.types=response.data;

      })

    },
    async getPageArticle (val){
      let _this=this;
      this.currentPage=val
      const data={
        pageNum:this.currentPage,
        pageSize:8
      }
      postRequest("/getArticle",data).then(function (response) {
        _this.page=response.data
        console.log(response.data)
      })
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
    }
  },

  mounted() {
    this.getPageArticle(1)
    this.getTypes()
    this.openMessage()
    this.getHot()
    getRequest("/lookSum").then(response=>(this.looksum=response.data));
    getRequest("/articleSum").then(response=>(this.articlesum=response.data));
    getRequest("/typeSum").then(response=>(this.typesum=response.data));
    postRequest("/getUser",{"id":1}).then(response=>(this.user=response.data));






  },





}
</script>

<style>

.content{
  width: 1100px;

  margin: 0 auto;
  /*background-color: burlywood;*/
  margin-top: 30px;


}




.content_card{

  width: 710px;
  height: 160px;
  padding:10px 20px 10px 20px;
  cursor: pointer;
}

.content_card:hover{
  width: 710px;
  height: 160px;
  padding:10px 20px 10px 20px;
  margin:0px 20px 0px 20px;
  border-radius: 10px;
  background-clip: border-box;

  border: 1px solid #eaeaea;

  margin-bottom: 10px;

}

.left-content{
  width: 320px;
  float: left;


}

.right_content{

  width: 750px;
  float: right;

}

.left-top,.types,.tags,.content_card{

  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
  margin-bottom: 10px;

}


.left-top{
  width: 320px;
  height: 280px;
  text-align: center;

}


.types{
  width: 320px;

  padding-top: 20px;


}

.per_type{


  margin-left: 10px;
  cursor: pointer;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;



}

.per_type:hover{

  color: gold;
  font-weight: bold;
  font-size: 20px;


}

.tags{
  width: 300px;

  text-align: center;
  padding: 10px 10px 10px 10px;

}
.tags .el-tag{
  margin: 5px 5px 10px 5px;


}


.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}


</style>
