<template>
<div>

  <el-container>
    <el-header class="homeHeader">


        <div class="title">

          V-Blog
        </div>



    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu router unique-opened>
          <el-submenu :index="index+''" v-for="(item,index) in this.$router.options.routes" :key="index" v-if="!item.hidden">
            <template slot="title"><i class="el-icon-location"></i>{{item.name}}</template>
              <el-menu-item :index="itemxj.path" v-for="(itemxj,indexxj) in item.children" :key="indexxj">{{ itemxj.name }}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</div>
</template>

<script>
export default {
  name: "Home",
  methods:{

    menuClick(index){
      this.$router.push(index)

    }

  }
}
</script>

<style>
.homeHeader{
  background-color: cornflowerblue;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 15px;
  box-sizing: border-box;
}

.homeHeader .title{
  font-size: 30px;
  font-family:"Microsoft YaHei UI";
  color: white;
}

</style>
