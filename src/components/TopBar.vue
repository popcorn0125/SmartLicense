<template>
  <div class="top_bar">
    <div class="back_button" v-if="$route.meta.showBackButton">
      <!-- 뒤로가기 버튼 이미지 -->
      <img src="@/assets/leftcaret.png" alt="Back" @click="goBack" />
    </div>
    <h1 class="splash_logo">{{ $route.meta.title }}</h1>
  </div>
</template>
<script>
export default {
  methods: {
    goBack() {
      this.$router.go(-1); // 뒤로가기
    },
  },
};
</script>
<style>
@import "@/css/common.css";
</style>