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

a {
    color: #333;
    text-decoration: none;
}

ol,
ul,
li {
    list-style: none;
}

img,
svg {
    /* width: 100%; */
    vertical-align: middle;
}

table {
    min-width: 100%;
    border-collapse: collapse;
    table-layout: fixed;
}

table th,
table td {
    padding: 8px;
    font-size: 1.3rem;
}

button {
    border: none;
    background-color: transparent;
    font-size: 1.3rem;
    cursor: pointer;
}

label {
    font-size: 1.3rem;
    margin-left: 0px;
}

select,
input[type="text"],
input[type="password"],
input[type="date"],
input[type="number"] {
    min-width: 100px;
    padding: 5px 10px;
    border: 1px solid #aaa;
    border-radius: 5px;
    font-size: 1.3rem;
}

input:focus {
    outline: none;
}

input:disabled {
    background: #aaa;
    border: none;
}

input[type="checkbox"],
input[type="radio"] {
    vertical-align: middle;
}

input[type='date'] {
    max-width: 240px;
    padding: 5px;
}

input[type='date'].date-placeholder::before {
    content: attr(data-placeholder);
    width: 100%;
    color: #ddd;
}

button:first-child,
select:first-child,
input:first-child,
button.only,
select.only,
input.only {
    margin-left: 0;
}

textarea{
    width: 100%;
    height: 100%;
}


/* 스크롤바 디자인 */
::-webkit-scrollbar {
    width: 8px;
    height: 8px;
}

::-webkit-scrollbar-thumb {
    background-color: #ededed;
    border-radius: 10px;
}

::-webkit-scrollbar-track {
    background-color: #fff;
    border-radius: 10px;
}

input[type="checkbox"]{
    width: 2em;
    height: 2em;
    accent-color: #5271ff;
}

</style>