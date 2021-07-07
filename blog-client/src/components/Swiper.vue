<template>
<div>
  <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in swiper" :key="item.img">
      <img :src="item.img" alt="" width="100%" height="100%">
    </el-carousel-item>
  </el-carousel>


</div>
</template>

<script>
export default {
  name: "Swiper",
  data(){

    return{
      swiper:[
        {img:'https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ'},
        {img:'https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68'},
        {img:'https://i.picsum.photos/id/1005/5760/3840.jpg?hmac=2acSJCOwz9q_dKtDZdSB-OIK1HUcwBeXco_RMMTUgfY'},
        {img:'https://i.picsum.photos/id/1015/6000/4000.jpg?hmac=aHjb0fRa1t14DTIEBcoC12c5rAXOSwnVlaA5ujxPQ0I'},


      ],

    }
  }
}
</script>

<style scoped>

</style>
