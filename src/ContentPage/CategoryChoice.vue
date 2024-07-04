<template>
    <TopBar />
    <div class="content_container">
        <div class="selectbox_wrap">
            <p>자격을 선택하세요.</p>
            <select>
                <option>기사</option>
                <option>기능사</option>
                <option>산업기사</option>
            </select>
            <p>세부 자격을 선택하세요.</p>
            <select>
                <option>정보처리기사</option>
                <option>정보보안기사</option>
                <option>가스기사</option>
            </select>
            <p>시험 일정을 선택하세요.</p>
            <select>
                <option>2022년4월24일</option>
                <option>2022년3월05일</option>
                <option>2021년8월14일</option>
                <option>2021년5월15일</option>
                <option>2021년3월07일</option>
            </select>
        </div>
        <div class="mode_wrap">
            <button class="practice_mode" :class="{ active: mode === 'practice' }" @click="toggleMode('practice')"
                :disabled="mode === 'practice'">연습모드</button>
            <button class="test_mode" :class="{ active: mode === 'test' }" @click="toggleMode('test')"
                :disabled="mode === 'test'">시험모드</button>
        </div>
        <div class="subject_wrap">
            <div>
                <input type="checkbox" class="sub1"><span>1과목</span>:<span>소프트웨어 설계</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub2"><span>2과목</span>:<span>소프트웨어 개발</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub3"><span>3과목</span>:<span>데이터베이스 구축</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub4"><span>4과목</span>:<span>프로그래밍 언어 활용</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub5"><span>5과목</span>:<span>정보시스템 구축관리</span>(<span>20</span>문항)
            </div>
        </div>
        <button class="go_solve">문제 풀기</button>
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
            mode: null // 초기에는 버튼 둘다 선택 안돼있음
        };
    },
    methods: {
        toggleMode(selectMode) {
            if (this.mode === selectMode) {
                this.mode = null;
            }
            else {
                this.mode = selectMode;
            }
        }
    },
};
</script>

<style scoped>
.content_container {
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
    align-items: center;
    /* 가로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
}

.selectbox_wrap {
    width: 100%;
    height: 30%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.selectbox_wrap>select {
    width: 55%;
    font-size: 1em;
    margin-top: 0.5em;
    margin-bottom: 1em;
}

.selectbox_wrap > p{
    font-weight: bold;
}

.mode_wrap {
    width: 100%;
    height: 15%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.practice_mode,
.test_mode {
    border-radius: 20px;
    background: #DBDBDB;
    color: #000;
    font-size: 1em;
    width: 25%;
    height: 35%;
    margin: 0em 1em;
}

.practice_mode.active,
.test_mode.active {
    background: #5271FF;
    color: #FFF;
}

.subject_btn_wrap {
    width: 100%;
    height: 40%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
}

.sub1,
.sub2,
.sub3,
.sub4,
.sub5 {
    width: 1.5em;
    height: 1.5em;
    margin-bottom: 1em;
    margin-right: 0.5em;
}

.go_solve {
    background-color: #5271FF;
    color: #fff;
    border-radius: 5px;
    width: 40%;
    height: 8%;
    margin-top: 1.5em;
}
</style>