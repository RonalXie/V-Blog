<template>
<div>
    <div class="header">
      <el-menu router :default-active="activeIndex" class="el-menu-demo" mode="horizontal" background-color="#E9F3FA"  @select="handleSelect">
        <el-menu-item style="float: right;"><el-avatar :size="30" src="https://www.xiesiyu.top/upload/2021/04/1000-340286eb49d94ffc98449972f7bb7b84-ea2bc3481be2429f93df0a11424b4632.jpg"></el-avatar></el-menu-item>
        <el-menu-item index="/home"><span  class="span_font"><i class="el-icon-menu"></i>首页</span></el-menu-item>
        <el-menu-item index="/article"><span  class="span_font">消息中心</span></el-menu-item>
        <el-menu-item index="/about"><span  class="span_font">About</span></el-menu-item>
        <el-menu-item style="float: right;">

          <el-input
            placeholder="请输入内容"
            prefix-icon="el-icon-search"
            v-model="form.id"
            size="small"

          >
          </el-input>

        </el-menu-item>
      </el-menu>
    </div>

</div>
</template>

<script>
import {postRequest} from "../../utils/api";

export default {
  name: "Header",
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      form: {
        id:'1'

      }
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },

    getuser() {
      postRequest("http://localhost:8888/user", this.form).then(function (response) {

          console.log(response.data)
        },
      )
    },

  }

}
</script>

<style>
.span_font{

  font-size: 15px;
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.header{
  /*width: 100%;*/
  height: 50px;



}
.el-menu{
  height: 50px;
  padding-left: 200px;
  padding-right: 200px;








}


.el-menu--horizontal>.el-menu-item{
  height: 50px;
  line-height: 50px;

}


</style>
