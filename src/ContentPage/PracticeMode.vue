<template>
    <TopBar />
    <div class="practive_mode_container">
        <div class="select_test">
            <span>정보처리기사</span><span>2020년 4월 24일</span>
        </div>
        <div class="current_sub">
            <span>1과목</span> : <span>소프트웨어 설계</span>
        </div>
        <div class="current_Q">
            <p>18. UML 다이어그램 중 순차 다이어그램에 대한 설명으로 틀린 것은?</p>
        </div>
        <div class="current_A">
            <div class="answer_option">
                <input type="radio" name="answer" id="answer1">
                <label for="answer1">1. 객체 간의 동적 상호작용을 시간 개념을 중심으로 모델링 하는 것이다.</label>
            </div>
            <div class="answer_option">
                <input type="radio" name="answer" id="answer2">
                <label for="answer2">2. 주로 시스템의 정적 측면을 모델링하기 위해 사용한다.</label>
            </div>
            <div class="answer_option">
                <input type="radio" name="answer" id="answer3">
                <label for="answer3">3. 일반적으로 다이어그램의 수직 방향이 시간의 흐름을 나타낸다.</label>
            </div>
            <div class="answer_option">
                <input type="radio" name="answer" id="answer4">
                <label for="answer4">4. 회귀 메시지(Self-Message), 제어블록(Statement block) 등으로 구성된다.</label>
            </div>
        </div>
        <div class="OX">
            <img src="@/assets/wronganswer.png" style="width: 190px; height: 190px; display: none;">
            <img src="@/assets/collectanswer.png" style="display: none;">
        </div>
        <div class="last_Q">
            <p>마지막 문제입니다.</p>
        </div>
        <div class="btn_collection">
            <button>정답확인</button>
            <button>해설보기</button>
            <button>다음</button>
            <button>제출</button>
        </div>
    </div>

    <BottomBar/>
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: "PracticeMode",
    components: {
        TopBar, BottomBar
    },
    data() {
        return {

        }
    },
    methods: {

    },

    created() {

    },
    mounted() {

    },
}
</script>

<style scoped>
.practive_mode_container{
    top: 7%;
    position: fixed;
    height: calc(100% - 16%);
    /* 전체 높이에서 상단바와 하단바 높이 제외 */
    display: flex;
    flex-direction: column;
    /* justify-content: center; */
    /* 세로 중앙 정렬 (필요에 따라 조정) */
    align-items: center;
    /* 가로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
}

.select_test{
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    font-size: 1.5em;
    font-weight: 500;
}

.current_sub{
    font-size: 1.2em;
}

.current_Q{
    margin: 0.7em;
    padding: 0.3em;
    border: solid 1px #000;
    border-radius: 5px;
    box-sizing: border-box;
}

.current_A{
    display: flex;
    flex-direction: column;
    font-size: 1em;
}

.answer_option > label{
    font-size: 1em;
    margin: 0.5em;
}

#answer1, #answer2, #answer3, #answer4{
    margin: 1.2em;
}
</style>