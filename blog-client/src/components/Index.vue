<template>
  <div>


    <div class="header"><Header></Header></div>
    <div class="main"><router-view></router-view></div>
    <div class="footer"></div>
<!--    <Audio></Audio>-->
    <Player></Player>
  </div>
</template>

<script>
import Header from "./nav/Header";
import Audio from "./Audio";
import Player from "./Player";
export default {
  name: "Index",
  components:{
    Header,
    Audio,
    Player,
  }
}
</script>

<style>

.header {

}
.main{

}

.footer{


}
body{
  padding: 0;
  margin: 0;
  background-image: url("../assets/blue-snow.png");
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;

}
</style>
