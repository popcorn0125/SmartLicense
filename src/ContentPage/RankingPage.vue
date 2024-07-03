<template>
    <TopBar />
    <div class="rank_container">
        <div>
            <p class="my_rank">나의 순위 : {{ myLanking }}등</p>
        </div>
        <div class="rank_table">
            <div class="ranking-header">
                <span class="ranking-no">순위</span>
                <span class="ranking-nickname">닉네임</span>
                <span class="ranking-score">점수</span>
            </div>
            <div class="ranking-item" v-for="(rank, index) in 10" :key="rank">
                <span class="ranking-no">
                    <!-- 순위가 1, 2, 3등일 때 이미지로 표시 -->
                    <template v-if="index === 0">
                        <img src="@/assets/rank1.png" alt="1등" class="rank-medal">
                    </template>
                    <template v-else-if="index === 1">
                        <img src="@/assets/rank2.png" alt="2등" class="rank-medal">
                    </template>
                    <template v-else-if="index === 2">
                        <img src="@/assets/rank3.png" alt="3등" class="rank-medal">
                    </template>
                    <!-- 나머지 경우 숫자로 표시 -->
                    <template v-else>
                        {{ rank }}
                    </template>
                </span>
                <span class="ranking-nickname">{{topTenUser[index]}}</span>
                <span class="ranking-score">{{topTenScore[index]}}</span>
            </div>
        </div>
    </div>
    <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: 'RankingPage',
    components: {
        TopBar, BottomBar
    },
    data() {
        return {
            myLanking: 1234,
            topTenUser: ['honghong', 'junsiiik','ggedragon', 'popcorn','honghon','bot','DCU'],
            topTenScore: ['189','177','155','144','129','111','64']
        };
    },
    methods: {

    },
}
</script>

<style scoped>
@import "@/css/common.css";

.rank_container {
    top: 7%;
    position: fixed;
    overflow-y: auto;
    /* 컨텐츠가 넘칠 경우 스크롤 */
    height: calc(100% - 16%);
    /* 전체 높이에서 상단바와 하단바 높이 제외 */
    display: flex;
    flex-direction: column;
    justify-content: center;
    /* 세로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
}

.my_rank{
    font-size: 1.5em;
    margin-left: 1em;
}

.rank_table {
    width: 100%;
    max-width: 600px; /* 최대 너비 설정 */
    background-color: #f0f0f0; /* 배경색 설정 */
    border-radius: 8px; /* 모서리 둥글게 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
    margin-top: 1em;
}
.ranking-header {
    display: flex;
    justify-content: space-between;
    padding: 8px 16px;
    font-weight: bold;
    border-bottom: 2px solid #ccc; /* 헤더 밑에 구분선 추가 */
}

.ranking-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 12px 16px;
}

.ranking-no {
    flex: 1; /* 순위 칼럼이 1:1 비율로 차지 */
    text-align: center; /* 가운데 정렬 */
}

.ranking-nickname {
    flex: 3; /* 닉네임 칼럼이 3:1 비율로 차지 */
    padding-left: 16px; /* 왼쪽 여백 추가 */
}

.ranking-score {
    flex: 1; /* 점수 칼럼이 1:1 비율로 차지 */
    text-align: center; /* 가운데 정렬 */
}

.rank-medal{
    width: 30px;
    height: 30px;
    
}
</style>