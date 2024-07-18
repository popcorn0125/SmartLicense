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
        <input class="input" type="search" placeholder="Search" />
    </div>
    <div class="table-container">
        <div v-for="(item, index) in items" :key="index" class="table-row">
            <span class="table-cell">{{ item.qualification }}</span>
            <span class="table-cell">{{ item.examDate }}</span>
            <span class="table-cell">{{ item.mode }}</span>
            <span class="table-cell">{{ item.remainingTime }}</span>
            <span class="table-cell">{{ item.score }}</span>
        </div>
    </div>
    <ul class="wrapper">
        <li class="icon black">
            <span><svg viewBox="0 0 16 16" class="bi bi-chevron-double-left" fill="currentColor" height="16" width="16"
                    xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"
                        fill-rule="evenodd"></path>
                    <path
                        d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"
                        fill-rule="evenodd"></path>
                </svg></span>
        </li>
        <li class="icon black">
            <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-chevron-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0" />
                </svg></span>
        </li>
        <li class="icon black">
            <span>1</span>
        </li>
        <li class="icon black">
            <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-chevron-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708" />
                </svg></span>
        </li>
        <li class="icon black">
            <span><svg viewBox="0 0 16 16" class="bi bi-chevron-double-right" fill="currentColor" height="16" width="16"
                    xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z"
                        fill-rule="evenodd"></path>
                    <path
                        d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z"
                        fill-rule="evenodd"></path>
                </svg></span>
        </li>
    </ul>
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
            UserId: "hong123",
            UserName: "홍길동",
            UserNicName: "honghong",
            currentPage: 1,
            itemsPerPage: 10,
            items: [
                { qualification: '정보처리기사', examDate: '240101', mode: '연습', remainingTime: '07:15', score: 90 },
                { qualification: '워드프로세서고급1급', examDate: '2024-02-01', mode: '시험', remainingTime: '2시간', score: 85 },
                { qualification: '자격3', examDate: '2024-03-01', mode: '모드3', remainingTime: '3시간', score: 95 },
                { qualification: '자격4', examDate: '2024-04-01', mode: '모드4', remainingTime: '4시간', score: 80 },
                { qualification: '자격5', examDate: '2024-05-01', mode: '모드5', remainingTime: '5시간', score: 70 },
                { qualification: '자격6', examDate: '2024-06-01', mode: '모드6', remainingTime: '6시간', score: 75 },
                { qualification: '자격7', examDate: '2024-07-01', mode: '모드7', remainingTime: '7시간', score: 85 },
                { qualification: '자격8', examDate: '2024-08-01', mode: '모드8', remainingTime: '8시간', score: 95 },
                { qualification: '자격9', examDate: '2024-09-01', mode: '모드9', remainingTime: '9시간', score: 90 },
                { qualification: '자격10', examDate: '2024-10-01', mode: '모드10', remainingTime: '10시간', score: 80 },
                { qualification: '자격11', examDate: '2024-01-01', mode: '모드1', remainingTime: '1시간', score: 90 },
                { qualification: '자격12', examDate: '2024-02-01', mode: '모드2', remainingTime: '2시간', score: 85 },
                { qualification: '자격13', examDate: '2024-03-01', mode: '모드3', remainingTime: '3시간', score: 95 },
                { qualification: '자격14', examDate: '2024-04-01', mode: '모드4', remainingTime: '4시간', score: 80 },
                { qualification: '자격15', examDate: '2024-05-01', mode: '모드5', remainingTime: '5시간', score: 70 },
                { qualification: '자격16', examDate: '2024-06-01', mode: '모드6', remainingTime: '6시간', score: 75 },
                { qualification: '자격17', examDate: '2024-07-01', mode: '모드7', remainingTime: '7시간', score: 85 },
                { qualification: '자격18', examDate: '2024-08-01', mode: '모드8', remainingTime: '8시간', score: 95 },
                { qualification: '자격19', examDate: '2024-09-01', mode: '모드9', remainingTime: '9시간', score: 90 },
                { qualification: '자격20', examDate: '2024-10-01', mode: '모드10', remainingTime: '10시간', score: 80 },
                // 필요한 만큼 더 추가
            ]
        };
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

        goToLogin() {
            this.$router.push('/SmartLicenseLogin'); // SmartLicenseLogin 페이지로 이동
        },

        goToChangeInfo() {
            this.$router.push('/ChangeInfo');
        }
    },
    computed: {
        paginatedItems() {
            const start = (this.currentPage - 1) * this.itemsPerPage;
            const end = start + this.itemsPerPage;
            return this.items.slice(start, end);
        },
        totalPages() {
            return Math.ceil(this.items.length / this.itemsPerPage);
        },
    },
}
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
    -ms-overflow-style: none; /* 인터넷 익스플로러 */
  scrollbar-width: none; /* 파이어폭스 */
}

/* ( 크롬, 사파리, 오페라, 엣지 ) 동작 */
.table-container::-webkit-scrollbar {
  display: none;
}

.table-row {
    display: flex;
    justify-content: space-between;
}

.table-cell {
    flex: 1;
    text-align: center;

}

.table-header {
    width: 95%;
    border-radius: 5px;
    background-color: #f9f9f9;
    padding: .5em;
    margin: .4em 0 0 0;
    justify-content: center;
    align-items: center;
    font-size: .8em;
}

.table-row {
    width: 95%;
    border-radius: 5px;
    background-color: #f9f9f9;
    padding: .5em;
    margin: .4em 0 0 0;
    justify-content: center;
    align-items: center;
    font-size: .8em;
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