<template>
  <div>
    <div class="tcontent">
      <div class="top_article">
        <div v-for="item in page.list" class="article_card" @click="goArticle(item)">
          <img :src="item.img" alt="" width="200px" height="200px"/>
          <div style="width: 200px;height: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
            <span>{{ item.title }}</span><br>
            <br>
            <span style="font-size: 10px;color: #909090;"><i class="el-icon-date"></i>{{ item.createDate }}</span>
            <span style="font-size: 12px;color: #909090;float: right"><i class="el-icon-view"></i>{{ item.looknum }}</span>
          </div>
        </div>
      </div>
      <div class="page">
        <el-pagination
          background

          :page-size="page.pageSize"
          :total="page.total"
          :current-page="currentPage"
          layout="prev, pager, next"
          @current-change="getPageArticle"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import {postRequest} from "../utils/api";

export default {
  name: "ShowSearch",
  data(){
    return{

      key:this.$route.params.key,
      page:"",
      currentPage:1,
    }
  },
  methods:{
    async getPageArticle (val){
      let _this=this;
      this.currentPage=val
      // const data={
      //   pageNum:this.currentPage,
      //   pageSize:10,
      //   key:this.tid,
      // }
      let params=new URLSearchParams()
      params.append("pageNum",this.currentPage);
      params.append("pageSize",3);
      params.append("key",this.key);

      postRequest("/search",params).then(function (response) {
        _this.page=response.data
        console.log(response.data)
      })
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
    },
    goArticle(item){
      this.$router.push("/article/"+item.id)
    },
  },
  created() {

    this.getPageArticle(1)
  }
}
</script>

<style>

.tcontent{
  width: 1300px;
  margin: 0 auto;
  margin-top: 30px;


}
.page{

  width: 1000px;
  margin: 0 auto;
  text-align: center;

}

.top_article{

  width: 1110px;
  height: 650px;
  margin: 0 auto;
}

.article_card{
  width: 200px;
  height: 280px;
  float: left;
  margin: 20px 10px 10px 10px;

  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
  cursor: pointer;



}
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>
