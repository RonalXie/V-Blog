<template>
<div>

  <transition name="el-fade-in-linear">

    <div id="player" class="hidden">


      <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=86 src="//music.163.com/outchain/player?type=2&id=1827600686&auto=1&height=66"></iframe>
      <div class="right_control" @click="change_bar">
         <i :class="bar_class" style="font-size: 40px;margin-top: 25px"></i>
      </div>


    </div>
  </transition>

</div>
</template>

<script>
export default {
  name: "Player",
  data(){

    return{
      bar_class:'el-icon-d-arrow-left',
      hidden:false,

    }
  },
  methods:{
    change_bar(){
      if (this.hidden) {
        this.bar_class = 'el-icon-d-arrow-right';
        this.hidden = false;
        let player=document.querySelector('#player')
        player.setAttribute("class","hidden")
      }
      else{
        this.bar_class = 'el-icon-d-arrow-left';
        let player=document.querySelector('#player')
        player.removeAttribute("class","hidden")
        this.hidden=true;
      }




    }

  }
}
</script>

<style>

#player{

  width: 320px;
  height: 90px;
  background-color: #ffffff;
  position: fixed;
  z-index: 9999;
  top: 400px;

}
.right_control{
  width: 40px;
  height: 100%;
  background-color: #737A7C;
  float: right;
  cursor: pointer;

}
.hidden{
  left: -280px;
}



</style>
