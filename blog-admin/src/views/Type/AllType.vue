<template>
<div>
  <div>
    <el-form :inline="true" :model="form" class="demo-form-inline">
      <el-form-item label="分类名字">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加</el-button>
      </el-form-item>
    </el-form>
  </div>

  <el-table
    :data="tableData"
    style="width: 100%"
    border
  >
    <el-table-column
      label="编号"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.tid }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="名称"
      width="180">
      <template slot-scope="scope">


          <el-tag size="medium">{{ scope.row.name }}</el-tag>


      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

</div>
</template>

<script>
import {getRequest,postRequest} from "../../utils/api";
export default {
  name: "AllType",
  data() {
    return {
      input:"",
      form:{
        name:""
      },
      tableData: [],
      editcontent:{
        tid:"",
        name:"",
      }
    }
  },
  methods: {
    handleEdit(index, row) {
      this.$prompt('请输入名称', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.editcontent.tid=row.tid
        this.editcontent.name=value
        postRequest("/updateType",this.editcontent).then(response=>(location.reload()))
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },
    handleDelete(index, row) {
      this.editcontent.tid=row.tid
      postRequest("/addType",this.form).then(response=>(location.reload()));
    },
    onSubmit(){
      postRequest("/addType",this.form).then(response=>(location.reload()));

    }
  },
  mounted() {
    getRequest("/getType").then(response=>(this.tableData=response.data))

  }
}
</script>

<style>

</style>
