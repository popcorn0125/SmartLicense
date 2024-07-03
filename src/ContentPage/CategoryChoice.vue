<template>
    <TopBar />
    <div class="content_container">
        <div class="selectbox_wrap">
            <p>자격을 선택하세요.</p>
            <input type="selectbox">
        </div>
        <div class="mode_wrap">

        </div>
        <div clas="subject_btn_wrap">

        </div>
    </div>

    <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: "CategoryChoice",
    components: {
        TopBar, BottomBar
    },
    data() {
        return {

        };
    },
    methods: {

    },
};
</script>

<style scoped>
.content_container {
    top: 7%;
    position: fixed;
    overflow-y: auto;/* 컨텐츠가 넘칠 경우 스크롤 */
    height: calc(100% - 16%);/* 전체 높이에서 상단바와 하단바 높이 제외 */
    display: flex;
    flex-direction: column;
    justify-content: center; /* 세로 중앙 정렬 (필요에 따라 조정) */
    align-items: center; /* 가로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
}
</style>