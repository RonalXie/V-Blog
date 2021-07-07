<template>
  <div>

    <div class="art_content">
      <div class="left-art_content">
        <div style="text-align: center;padding: 5px">
          <h2>这是一个标题</h2>
          <span style="font-size: 10px;color: #909090;display: inline-block;float: left">2021-07-01 周四</span>
          <span style="font-size: 10px;color: #909090;display: inline-block;float: right">Ronalxie</span>




        </div>
        <el-divider><i class="el-icon-mobile-phone"></i></el-divider>


        <div id="preview">



        </div>




      </div>
      <div class="right_art_content">
        <div class="hot_art">热门文章
          <div style="margin-left: 10px" v-for="(v,index) in 10">
            <el-badge :value="1" class="item"></el-badge>
            这是文章标题

          </div>

        </div>
        <div class="recent_art">最近发表</div>

      </div>


    </div>



  </div>
</template>
<script>
// import Vditor from 'vditor'
// import 'vditor/dist/index.css'

export default {
  name: "About",
  data(){

    return{
      contentEditor: '',
      itemDes:"```java \nf123123"
    }
  },
  methods:{

    // renderMarkdown(md) {
    //   Vditor.preview(document.getElementById("preview"), md, {
    //     hljs: { style: "github" },
    //   });
    // },
  },
  //
  // mounted () {
  //   this.renderMarkdown("---\ntitle: public static void main()\n---")
  // },
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
  width: 750px;
  height: 1000px;
  float: left;



}

.right_art_content{
  height: 1000px;
  width: 320px;
  float: right;

}

.left-art_content,.hot_art,.recent_art{

  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
  margin-bottom: 10px;

}
.hot_art{
  height: 500px;
}
.recent_art{
  height: 400px;

}

</style>
