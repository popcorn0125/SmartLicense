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

::-webkit-scrollbar { 
	width: 5px; 
}
::-webkit-scrollbar-track { /*없어도됨*/
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.1);
    -webkit-border-radius: 10px;
    border-radius: 10px; 
}
::-webkit-scrollbar-thumb { 
    -webkit-border-radius: 10px;
    border-radius: 10px; 
    background: rgba(0,0,0,0.2); 
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
}
::-webkit-scrollbar-thumb:window-inactive { 
	background: rgba(0,0,0,0.3); 
}
</style>