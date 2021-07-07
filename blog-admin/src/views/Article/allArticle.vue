<template>
<div>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      label="标题"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.title }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="分类"
      width="180">
      <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.type }}</el-tag>
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

</div>
</template>

<script>
export default {
  name: "allArticle",
  data() {
    return {
      tableData: [{
        title: '测试文章标题',
        type: '王小虎 王小虎',
        date: '2016-05-02',

      }, {
        title: '测试文章标题',
        type: '王小虎 王小虎',
        date: '2016-05-02',

      }, {
        title: '测试文章标题',
        type: '王小虎 王小虎',
        date: '2016-05-02',

      }, {
        title: '测试文章标题',
        type: '王小虎 王小虎',
        date: '2016-05-02',

      }]
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  }
}
</script>

<style scoped>

</style>
