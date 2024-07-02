<template>
    <div id="splash_screen">
        <h1 class="splash_logo">Smart License</h1>
    </div>
</template>
    
<script>
    export default {
      name: 'SplashScreen'
    }
</script>
    
<style scoped>
#splash_screen {
  display: flex;
  width: 100%;
  height: 100vh; /* 화면 전체 높이 */
  background-color: #5271FF;
  text-align: center;
  align-items: center; /* 수직 중앙 정렬 */
  justify-content: center; /* 수평 중앙 정렬 */
}

.splash_logo {
  margin: 0;
  text-align: center;
  color: #ffff76; /* 글자 색상 설정 */
  font-weight: 900;
  font-style:italic;
  font-family: "Inter-BlackItalic", Helvetica;
  text-shadow: 3px 3px 3px #5b5b5b;
}
</style>