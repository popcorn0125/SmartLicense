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
}



</style>