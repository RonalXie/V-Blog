<template>
<div>


  <el-table
    :data="commentList"
    style="width: 100%">
    <el-table-column
      label="昵称"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.username }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="时间"
      width="180">
      <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.date }}</el-tag>
          </div>
      </template>
    </el-table-column>

    <el-table-column
      label="评论文章"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.comment }}</span>
      </template>
    </el-table-column>

    <el-table-column
      label="评论文章"
      width="300">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.article.title }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
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
import {getRequest, postRequest} from "../../utils/api";
export default {
  name: "allComment",
  data(){

    return{
      commentList:[]

    }
  },
  methods:{
    handleDelete(index, row) {
      postRequest("/deleteComment",{"cid":row.cid}).then(response=>(response.data),location.reload())
    }

  },
  mounted() {
    getRequest("/getComment").then(response=>(this.commentList=response.data))

  }
}
</script>

<style>

</style>
