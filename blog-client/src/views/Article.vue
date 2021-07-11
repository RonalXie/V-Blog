<template>
  <div>

    <div class="art_content">
      <div class="left-art_content">
        <div class="art">

          <div style="padding: 5px">
            <h2 style="text-align: center">{{this.content.title}}</h2>
            <span style="font-size: 10px;color: #909090;display: inline-block;float: left"><i class="el-icon-date"></i>&nbsp;{{this.content.createDate}}</span>
            <span style="font-size: 10px;color: #909090;display: inline-block;float: right"><i class="el-icon-s-custom"></i>&nbsp;Ronalxie</span>




          </div>
          <el-divider><i class="el-icon-postcard"></i></el-divider>


          <div id="preview">



          </div>

        </div>


            <div class="comment">

              <el-collapse>
                <el-collapse-item>

                  <template slot="title">
                    &nbsp; &nbsp; &nbsp;发表评论 &nbsp;<i class="header-icon el-icon-info"></i>
                  </template>
                  <el-card class="box-card">
                    <div class="text item">
                      <el-form ref="form" :model="form" label-width="80px">
                        <el-form-item label="昵称">
                          <el-input placeholder="输入昵称"  v-model="form.username" style="width: 100%;"></el-input>
                        </el-form-item>
                        <el-form-item label="评论内容">
                          <el-input type="textarea" v-model="form.comment" ></el-input>
                        </el-form-item>
                        <el-form-item>
                          <el-button type="primary" @click="postComment">确定</el-button>
                          <el-button>取消</el-button>
                        </el-form-item>
                      </el-form>
                    </div>
                  </el-card>

                </el-collapse-item>
              </el-collapse>
              <el-card class="box-card" v-for="(item,index) in this.content.commentList" :key="index">
                <div slot="header" class="clearfix">
                  <span><i class="el-icon-s-custom"></i>&nbsp;{{ item.username }}</span>
                  <span style="display: inline-block;float: right; padding: 3px 0;font-size: 10px"><i class="el-icon-date"></i>&nbsp;{{ item.date }}</span>
                </div>
                <div class="text item">
                  {{ item.comment }}
                </div>
              </el-card>

            </div>






      </div>


      <div class="right_art_content">
        <h3 style="color:#909090; text-align: center">推荐文章</h3>
        <div class="hot_art">
          <div class="per_type" v-for="(v,index) in this.tableData" @click="queryOne({'id':v.id})">
            <el-badge :value="index+1" class="item"></el-badge>
             {{ v.title }}

            <br>
            <br>
          </div>


        </div>

        <h3 style="color:#909090; text-align: center">最近发表</h3>
        <div class="recent_art">
          <div class="per_type" v-for="(item,index) in this.recent" @click="queryOne({'id':item.id})">
            <el-badge :value="index+1" class="item"></el-badge>
            {{ item.title }}

            <br>
            <br>
          </div>



        </div>

      </div>


    </div>



  </div>
</template>
<script>
import Vditor from 'vditor'
import 'vditor/dist/index.css'
import {getRequest, postRequest} from "../utils/api";

export default {
  name: "Article",
  data(){

    return{
      recent:'',
      form:{
        username:"",
        comment:"",
        aId:""

      },
      tableData:[],
      contentEditor: '',
      content: {
        id:this.$route.params.id
      },



    }
  },
  methods:{

    postComment(){

      this.form.aId=this.content.id;

      postRequest("/addComment",this.form).then(function (response){
          location.reload()
      })

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
    onSubmit(){


    },
    handleChange(val) {
      console.log(val);
    },

    addCount(){
      let form=new FormData()
      form.append("id",this.content.id)
      postRequest("/addCount",form).then(function (response) {
        console.log(response.data)
      })
    },


    async queryOne(content){

      var _this=this

      postRequest("/queryOne",content).then(function (response){


        _this.content=response.data;
        _this.renderMarkdown(_this.content.content)


      })
    },
    renderMarkdown(md) {
      Vditor.preview(document.getElementById("preview"), md, {
        hljs: { style: "github" },
      });
    },
  },
  mounted() {


    this.queryOne(this.content)
    this.addCount()
    console.log(this.content)
    this.getHot()
    getRequest("/selectRecent").then(response=>(this.recent=response.data))


  },
  created () {




  },
}
</script>

<style>
.art_content{

  width: 1100px;
  height: 1100px;
  margin: 0 auto;
  /*background-color: burlywood;*/
  margin-top: 30px;


}

.left-art_content{
  width: 730px;

  float: left;



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
.art{

  width: 730px;
  /*height: 1000px;*/
  padding: 10px;

}

.right_art_content{
  height: 1000px;
  width: 320px;
  float: right;

}

.art,.hot_art,.recent_art{

  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
  margin-bottom: 10px;

}
.hot_art{
  padding-top: 20px;

}
.recent_art{
  padding-top: 20px;
  width: 320px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;

}
.comment{
  width: 750px;
}
.el-card{
  margin: 10px 0 10px 0;
}

</style>
