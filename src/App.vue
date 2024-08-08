<template>
  <router-view />
</template>

<script>
export default {
  name: 'App'
};
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
  background-color: #F4F5F6;
}
</style>