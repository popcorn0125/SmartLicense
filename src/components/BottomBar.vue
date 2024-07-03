<template>
    <div class="bottom_bar">
        <img src="@/assets/home.png" alt="home" id="home_icon" @click="goToCategoryChoice">
        <img src="@/assets/ranking.png" alt="home" id="ranking_icon" @click="goToRankingPage">
        <img src="@/assets/mypage.png" alt="home" id="mypage_icon" @click="goToMyPage">
    </div>
</template>
<script>
export default {
    methods: {
        goToCategoryChoice() {
            this.$router.push('/CategoryChoice'); // CategoryChoice 페이지로 이동
        },
        goToRankingPage() {
            this.$router.push('/RankingPage'); // RankingPage 페이지로 이동
        },
        goToMyPage() {
            this.$router.push('/MyPage'); // MyPage 페이지로 이동
        }
    }
}
</script>
<style>
@import "@/css/common.css";
</style>