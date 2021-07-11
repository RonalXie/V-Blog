<template>
<div>
  <el-table
    :data="page.list"
    style="width: 100%">
    <el-table-column
      label="标题"
      width="240">
      <template slot-scope="scope">

        <span style="margin-left: 10px">{{ scope.row.title }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="分类"
      >
      <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-tag style="margin-right: 5px" size="medium" v-for="(item,index) in scope.row.typeList" :key="index">{{ item.name }}</el-tag>
          </div>
      </template>
    </el-table-column>
    <el-table-column
      label="创建时间"
      width="240">
      <template slot-scope="scope">

        <div slot="reference" class="name-wrapper">
          <i class="el-icon-time"></i>
          <span>{{ scope.row.createDate }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column
      label="访问"
      width="100">
      <template slot-scope="scope">
        <div slot="reference" class="name-wrapper">
          <el-tag size="medium">{{ scope.row.looknum }}</el-tag>
        </div>
      </template>
    </el-table-column>


    <el-table-column
      label="是否置顶"
      width="100">
      <template slot-scope="scope">
        <div slot="reference" class="name-wrapper">
          <el-switch
            v-model="scope.row.istop"
            active-color="#13ce66"
            :change="updateTop(scope.row)"
            inactive-color="#ff4949">
          </el-switch>
        </div>
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
  <br>
  <br>
  <div style="width: 590px;margin: 0 auto;text-align: center">
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="page.pageSize"
      :total="page.total"
      :current-page="currentPage"
      @current-change="getPageArticle"
    >
    </el-pagination>
  </div>

</div>
</template>

<script>
import {postRequest} from "../../utils/api";
export default {
  name: "allArticle",
  data() {
    return {
      page:[],
      currentPage:1,
      tableData: [],
      istop:""
    }
  },
  methods: {
    updateTop(row){
      let form={
        "id":row.id,
        "istop":row.istop,
      }
      postRequest("/updateTop",form).then(response=>(response.data))
    },

    handleEdit(index, row) {
      let id=row.id;
      this.$router.push("/editArticle/"+id);



    },
    handleDelete(index, row) {
      let id=row.id;
      var _this=this;
      postRequest("/deleteArticle",{"id":id}).then(function (response) {
          if (response.data=="200"){

            _this.$message({
              message: '删除成功',
              type: 'success'
            });
            setTimeout(() => location.reload(), 100)


          }
          else{
            _this.$message({
              message: '删除失败',
              type: 'warning'
            });

          }



      })
    },
    async getPageArticle (val){
      let _this=this;
      this.currentPage=val
      const data={
        pageNum:this.currentPage,
        pageSize:8
      }
      postRequest("/getArticle",data).then(function (response) {
        _this.page=response.data
        console.log(response.data)
      })
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
    }

  },
  mounted(){

    this.getPageArticle()
  }
}
</script>

<style>

</style>
