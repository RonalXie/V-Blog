<template>
<div>
  <el-carousel indicator-position="outside" arrow="never">
    <el-carousel-item v-for="(item,index) in this.top" :key="index">
      <div class="top-article">
        <div class="a_img">
          <img :src="item.img" alt="" width="300" height="240">
        </div>

        <div class="a_info">
          <span><i class="el-icon-date"></i>&nbsp;{{item.createDate}}</span>
          <span style="display: inline-block;float: right"><i class="el-icon-view"></i>&nbsp;{{item.looknum}}</span>
          <h1 style="overflow: hidden;text-overflow: ellipsis;　　white-space: nowrap;">{{item.title}}</h1>
          <span style="font-size: 15px;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;">
            {{item.abs}}
          </span><br>
          <el-button type="success" plain @click="goArticle(item)">阅读更多</el-button>
        </div>
      </div>
    </el-carousel-item>
  </el-carousel>


</div>
</template>

<script>
import {getRequest} from "../utils/api";

export default {
  name: "Swiper",
  data(){

    return{

      top:[]

    }
  },
  methods:{
    goArticle(item){
      this.$router.push("/article/"+item.id)
    },

  },
  created() {

    getRequest("/queryTop").then(response=>(this.top=response.data));
  }
}
</script>

<style>

.el-carousel__item{
  background-color: #ffffff;
  font-size: 14px;
  opacity: 0.75;
  margin: 0;

}

.top-article{
  width: 700px;
  margin-top: 30px;

  /*background-color: #32B0DA;*/

}

.el-carousel{
  background-color: #ffffff;
  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
  margin-bottom: 10px;
}

.el-carousel__item:nth-child(2n) {
  background-color: #ffffff;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #ffffff;
}
.a_img{

  width: 300px;
  height: 240px;
  float: left;
  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  margin-left: 20px;
  border: 1px solid #eaeaea;
  box-shadow: 10px 10px 5px #888888;

}


.a_img img{
  border-radius: 10px;


}

.a_info{
  width: 350px;
  height: 240px;

  float: right;

}

</style>
