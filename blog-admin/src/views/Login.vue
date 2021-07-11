<template>
<div>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="活动名称">
      <el-input v-model="form.username"></el-input>
    </el-form-item>

    <el-form-item label="活动名称">
      <el-input v-model="form.password"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>

</div>
</template>

<script>
import {postRequest} from "../utils/api";
export default {
  name: "Login",
  data(){
    return{
      form:{
        username:"",
        password:""
      },
    }
  },
  methods:{
    onSubmit(){
      var _this=this;
      postRequest("/login",this.form).then(function (response) {
        console.log(response.data.username)
        window.sessionStorage.setItem("user",JSON.stringify(response.data));
        _this.$router.push("/home")



      })
    }

  }
}
</script>

<style>

</style>
