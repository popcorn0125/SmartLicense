<template>
  <div id="splash_screen">
    <h1 class="splash_logo">Smart License</h1>
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
      }, 10); // 10 > 1초 // 100 > 10초
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
.splash_logo{
  color: aliceblue;
  font-size: 1.5em;
}
</style>