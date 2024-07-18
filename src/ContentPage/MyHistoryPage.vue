<template>
    <TopBar />
    <div class="group">
        <svg viewBox="0 0 24 24" aria-hidden="true" class="icon_search">
            <g>
                <path
                    d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z">
                </path>
            </g>
        </svg>
        <input class="input" type="search" placeholder="세부자격을 검색하세요." />
    </div>
    <div class="table-container">
        <div v-for="(item, index) in paginatedItems" :key="index" class="table-row">
            <div class="history_info">
                <div class="license_info">
                    <span>{{ item.examDate }}</span>&nbsp;<span>{{ item.qualification }}</span>
                </div>
                <div class="detail_info">
                    <span>과목 수 <strong>{{ item.subNum }}</strong></span>&nbsp;|&nbsp;<span>문제 수 <strong>{{ item.qNum }}</strong></span>&nbsp;|&nbsp;<strong>{{ item.mode }}</strong>&nbsp;|&nbsp;<span>점수 <strong>{{ item.score }}</strong></span>&nbsp;|&nbsp;<strong>{{ item.passed }}</strong>
                </div>
                <div class="date_info">
                    <span>응시일 2024.07.18</span>
                </div>
            </div>
            <div class="delete_history">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#03020a" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
                </svg>
            </div>
        </div>
    </div>
    <ul class="wrapper">
        <li class="icon black" @click="prevPage">
            <span>
                <svg viewBox="0 0 16 16" class="bi bi-chevron-double-left" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                    <path d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" fill-rule="evenodd"></path>
                    <path d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" fill-rule="evenodd"></path>
                </svg>
            </span>
        </li>
        <li class="icon black" @click="prevPage">
            <span>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0" />
                </svg>
            </span>
        </li>
        <li class="icon black">
            <span>{{ currentPage }}</span>
        </li>
        <li class="icon black" @click="nextPage">
            <span>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708" />
                </svg>
            </span>
        </li>
        <li class="icon black" @click="nextPage">
            <span>
                <svg viewBox="0 0 16 16" class="bi bi-chevron-double-right" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                    <path d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" fill-rule="evenodd"></path>
                    <path d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" fill-rule="evenodd"></path>
                </svg>
            </span>
        </li>
    </ul>
    <BottomBar />
</template>


<script>
import TopBar from '../components/TopBar.vue';
import BottomBar from '../components/BottomBar.vue';

export default {
    name : 'MyHistoryPage',
    components: {
        TopBar,
        BottomBar
    },
    data() {
        return {
            items: [
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '초음파비파괴검사기능사', examDate: '2024년 4월 24일', mode: '시험', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '불합격' },
                { qualification: '담배원료가공기계정비기능사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보통신설비기능사2급', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '아스팔트피니셔운전기능사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보기술산업기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '전산응용토목제도기능사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '귀금속공예다기능기술자', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '제지산업기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '미용장', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '미용장', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                { qualification: '정보처리기사', examDate: '2024년 4월 24일', mode: '연습', remainingTime: '07:15', score: 90, submitDate: '2024.07.18', subNum: 5, qNum: 100, passed: '합격' },
                // 필요한 만큼 더 추가
            ],
            currentPage: 1,
            itemsPerPage: 6
        };
    },
    computed: {
        totalPages() {
            return Math.ceil(this.items.length / this.itemsPerPage);
        },
        paginatedItems() {
            const start = (this.currentPage - 1) * this.itemsPerPage;
            const end = start + this.itemsPerPage;
            return this.items.slice(start, end);
        }
    },
    methods: {
        prevPage() {
            if (this.currentPage > 1) {
                this.currentPage--;
            }
        },
        nextPage() {
            if (this.currentPage < this.totalPages) {
                this.currentPage++;
            }
        },
    }
};
</script>


<style scoped>
@import "@/css/common.css";

.table-container {
    top: 16%;
    position: fixed;
    overflow-y: auto;
    /* 컨텐츠가 넘칠 경우 스크롤 */
    height: 70%;
    /* 전체 높이에서 상단바와 하단바 높이 제외 */
    display: flex;
    flex-direction: column;
    /* 세로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
    background-color: rgb(224, 224, 224);
    /* justify-content: center; */
    align-items: center;
    -ms-overflow-style: none;
    /* 인터넷 익스플로러 */
    scrollbar-width: none;
    /* 파이어폭스 */
}

/* ( 크롬, 사파리, 오페라, 엣지 ) 동작 */
.table-container::-webkit-scrollbar {
    display: none;
}

/* .table-cell {
    flex: 1;
    text-align: center;

} */

.table-row {
    display: flex;
    justify-content: space-between;
    width: 95%;
    border-radius: 5px;
    background-color: #f9f9f9;
    padding: 1em;
    margin: .3em 0 .3em 0;
    justify-content: center;
    align-items: center;
    font-size: .8em;
}

.history_info {
    width: 92%;
    color: #828595;
}

.license_info {
    font-weight: 900;
    font-size: 1em;
    margin-bottom: .4em;
    color: #282f4a;
}

.detail_info {
    font-size: .8em;
    margin-bottom: .3em;
}

.date_info {
    font-size: .7em;
}

.delete_history {
    width: 8%;
}

strong {
    color: #7cdbd2;
}

/* 페이지 네이션 */
.wrapper {
    display: inline-flex;
    list-style: none;
    height: 8%;
    width: 100%;
    top: 86%;
    justify-content: center;
    position: absolute;
    bottom: 0;
    align-items: center;
}

.wrapper .icon {
    position: relative;
    background: #fff;
    border-radius: 50%;
    margin: 10px;
    width: 40px;
    height: 40px;
    font-size: 18px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    box-shadow: 0 10px 10px rgba(0, 0, 0, 0.1);
    cursor: pointer;
    transition: all 0.2s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.wrapper svg {
    fill: green;
}

/* 검색창 디자인 */
.group {
    display: flex;
    line-height: 28px;
    align-items: center;
    position: fixed;
    top: 6%;
    width: 100%;
    padding: 0em 1em;
    max-width: 500px;
    height: 10%;
}

.input {
    width: 100%;
    height: 40px;
    line-height: 28px;
    padding: 0 1rem;
    padding-left: 2.5rem;
    border: 2px solid transparent;
    border-radius: 8px;
    outline: none;
    background-color: #e0e0e0;
    color: #0d0c22;
    transition: 0.3s ease;
}

.input::placeholder {
    color: #9e9ea7;
}

.input:focus {
    outline: none;
    border-color: rgba(0, 48, 73, 0.4);
    background-color: #fff;
    box-shadow: 0 0 0 4px rgb(0 48 73 / 10%);
}

.icon_search {
    position: absolute;
    left: 2rem;
    fill: #9e9ea7;
    width: 1rem;
    height: 1rem;
}
</style>