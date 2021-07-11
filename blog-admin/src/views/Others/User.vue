<template>
<div>
  <div class="content">
    <div class="user_card">
      <div class="user_avatar">
        <img style="border-radius: 50%;" :src="user.avatar" alt="" width="100px" height="100px"/>


      </div>
      <div class="user_info">

        <el-form ref="form" :model="user" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="user.username"></el-input>
          </el-form-item>

          <el-form-item label="个性签名">
            <el-input type="textarea" v-model="user.introduction"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">保存</el-button>
            <el-button>修改密码</el-button>
          </el-form-item>
        </el-form>



      </div>
    </div>
    <div class="music">


    </div>

<!--    <div class="swiper">-->


<!--    </div>-->

  </div>

</div>
</template>

<script>
export default {
  name: "User",
  data(){
    return{
      user:"",

    }
  },

  created() {
    this.user=JSON.parse(window.sessionStorage.getItem("user")),
    console.log(this.user)
  }
}
</script>

<style>

.content{

  width: 1100px;

  background-color: wheat;
  margin: 0 auto;

}
.user_avatar{
  float: left;


}

.user_info{
  width: 400px;


  float: right;
  text-align: center;

}
.user_card,.music{
  width: 500px;
  height: 200px;
  float: left;
  margin-left: 20px;
  padding: 10px 10px 10px 10px;
  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;
}

.swiper{
  width: 1080px;
  height: 800px;
  padding: 10px 10px 10px 10px;
  border-radius: 10px;
  background-clip: border-box;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 20px #cac6c6;






}

</style>
