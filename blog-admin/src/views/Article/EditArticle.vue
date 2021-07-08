<template>

  <div>
    <el-input v-model="form.title" placeholder=文章标题 autocomplete="off"></el-input>
    <br>
    <br>

    <div id="vditor"></div>
    <br>

    <el-button class="el-button--primary" @click="dialog = true">发布</el-button>
    <el-drawer
      title="文章设置"
      :visible.sync="dialog"
      direction="rtl"
      custom-class="demo-drawer"
      ref="drawer"
    >
      <div class="demo-drawer__content">
        <el-form :model="form">
          <el-form-item label="当前分类" :label-width="formLabelWidth">

            <el-tag style="margin-right: 5px" type="warning" v-for="(item,index) in this.form.typeList" :key="index">{{item.name}}</el-tag>
            <el-popover
              placement="bottom"
              title="标题"
              width="200"
              trigger="manual"
              v-model="visible">
              <el-select v-model="form.type" multiple placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.tid"
                  :label="item.name"
                  :value="item.tid">
                </el-option>
              </el-select>
              <el-button slot="reference" @click="visible = !visible">修改</el-button>
            </el-popover>


          </el-form-item>
          <el-form-item label="文章摘要">
            <el-input
              type="textarea"
              v-model="form.abs"
              :autosize="{ minRows: 4, maxRows: 8}"
            >
            </el-input>

          </el-form-item>
          <el-form-item label="上传封面" :label-width="formLabelWidth">
            <el-upload
              action="http://localhost:8888/uploadImg"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :on-success="handleSuccess"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>


          </el-form-item>
          <el-form-item label="外链地址">
            <el-input
              type="textarea"
              v-model="form.img"
              autosize
              :disabled="true">
            </el-input>
          </el-form-item>

        </el-form>
        <div class="demo-drawer__footer">
          <el-button @click="cancelForm">取 消</el-button>
          <el-button type="primary" @click="handlePost" >确定</el-button>
        </div>
      </div>
    </el-drawer>



  </div>
</template>

<script>
import Vditor from "vditor";
import {getRequest, postRequest} from "../../utils/api";

export default {
  name: "EditArticle",
  data(){

    return{
      visible: false,
      table: false,
      dialog: false,
      loading: false,
      imgurl:'',
      type: [],
      form: {
        title: '',
        abs:'',
        img:'',
        content:'',
        typeList: [],
        type:[]
      },
      value1: [],
      value2: [],
      formLabelWidth: '80px',
      timer: null,
      dialogImageUrl: '',
      dialogVisible: false,
      options:[],
      id:this.$route.params.id,
    }
  },
  methods:{

    initType(){
      var _this=this;
      getRequest('/getType').then(function (response) {
        _this.options=response.data;
      })


    },
    handlePost() {
      this.form.content=this.contentEditor.getValue();
      var _this=this;
      console.log(this.form)
      postRequest("/updateArticle",this.form).then(function (response) {
        if (response.data=="200"){

          _this.$message({
            message: '修改成功',
            type: 'success'
          });
          location.reload()
        }
        else{
          _this.$message({
            message: '修改失败',
            type: 'warning'
          });

        }
      })

    },
    cancelForm() {
      this.loading = false;
      this.dialog = false;
      clearTimeout(this.timer);
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleSuccess(response, file, fileList){

      this.form.img=response
    },
    async queryOne(content){

      var _this=this
      var content={"id":this.id}
      postRequest("/queryOne",content).then(function (response){
        _this.form=response.data;
        _this.contentEditor.setValue(_this.form.content)
        let index;
        let type=[]
        let typeList=_this.form.typeList
        for (index in _this.form.typeList) {
           type.push(typeList[index].tid)

        }
        _this.form.type=type;



      })
    },
  },
  created() {
    this.queryOne();
    this.initType();
  },
  mounted() {

    this.contentEditor = new Vditor('vditor', {
      height: 360,
      toolbarConfig: {
        pin: true,
      },
      cache: {
        enable: false,
      },

    });




  }
}
</script>

<style>

</style>
