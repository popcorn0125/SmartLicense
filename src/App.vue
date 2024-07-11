<template>
  <!--  <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>--> <!-- Vue 프로젝트 생성 시 존재하는 기본 코드 제거 -->

  <router-view /> <!-- router.js 맵핑된 view 적용 코드 추가 -->
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'  <-- Vue 프로젝트 생성 시 존재하는 기본 코드 제거

export default {
  name: 'App'
  /*components: {  <-- Vue 프로젝트 생성 시 존재하는 기본 코드 제거
    HelloWorld
  }*/
}
</script>

<style>
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

html,
body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
}

#app {
  display: flex;
  height: 100vh;
  margin: 0;
  width: 100%;
  background-color: #ffffff;
  box-shadow: rgba(255, 255, 255, 0.17) 0px -23px 25px 0px inset,
    rgb(108 108 108 / 23%) 0px -36px 30px 0px inset,
    rgba(0, 0, 0, 0.1) 0px -79px 40px 0px inset, rgba(0, 0, 0, 0.06) 0px 2px 1px,
    rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px,
    rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;
}



</style>