<template>
  <div id="splash_screen">
    <h1 class="splash_logo">Smart License</h1>
    <p class="explain_text">자격증 문제 풀이 앱은 스마트 라이센스!</p>
    <div class="loading_bar_wrap">
      <div class="loading_bar"></div>
    </div>
    <p class="loading_text">{{ loadingPercentage }}%</p>
  </div>
</template>

<script>
export default {
  name: 'SplashScreen',
  data() {
    return {
      loadingPercentage: 0,
    };
  },

  methods: {
    startLoading() {
      let percentage = 0;
      const interval = setInterval(() => {
        if (percentage < 100) {
          percentage += 1;
          this.loadingPercentage = percentage;
        } else {
          clearInterval(interval);
          this.$router.push({ name: 'LoginPage' });
        }
      }, 30); // 30ms마다 1% 증가 => 3초에 100%
    }
  },

  mounted() {
    this.startLoading();
  }
}
</script>

<style scoped>
@import "@/css/common.css";

#splash_screen {
  display: flex;
  align-items: center;
  text-align: center;
  justify-content: center;
  flex-direction: column;
}

.loading_bar_wrap {
  position: fixed;

  width: 80%;
  /* 로딩 바의 너비 설정 */
  height: 10px;
  /* 로딩 바의 높이 설정 */
  background-color: #ccc;
  /* 로딩 바의 배경색 설정 */
  border-radius: 5px;
  /* 로딩 바의 둥근 모서리 설정 */
  overflow: hidden;
  /* 내용이 넘치지 않도록 설정 */
  bottom: 10%;
}

.loading_bar {
  height: 100%;
  background-color: #ffff76;
  /* 로딩 바의 색상 설정 */
  width: 0;
  /* 초기 너비를 0으로 설정 */
  animation: loading 3s linear forwards;
  /* 3초 동안 로딩 애니메이션 설정 */
}

@keyframes loading {
  0% {
    width: 0;
  }

  100% {
    width: 100%;
  }
}

.loading_text{
  position: fixed;
  bottom: 5%;
  color: #FFF;
  font-weight: 900;
}

.explain_text{
  color: #FFF;
  font-size: 1em;
  margin-top: 1em;
}
</style>