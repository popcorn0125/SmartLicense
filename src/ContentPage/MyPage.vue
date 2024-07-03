<template>
    <TopBar />
    <div class="myPage_container">
        <p class="user_info">회원정보</p>
        <div class="user_wrap">
            <div>
                <span class="label">아이디 : </span><span>{{ UserId }}</span>
            </div>
            <div>
                <span class="label">이름 : </span><span>{{ UserName }}</span>
            </div>
            <div>
                <span class="label">닉네임 : </span><span>{{ UserNicName }}</span>
            </div>
        </div>
        <div class="button_wrap">
            <button class="JYblue_btn" @click="goToChangeInfo">정보 수정</button>
            <button class="pink_btn">로그아웃</button>
            <button class="red_btn">탈퇴하기</button>
        </div>
        <div class="table-container">
            <div class="table-header">
                <span class="table-cell">자격명</span>
                <span class="table-cell">시험 일정</span>
                <span class="table-cell">모드</span>
                <span class="table-cell">남은시간</span>
                <span class="table-cell">점수</span>
            </div>
            <div v-for="(item, index) in paginatedItems" :key="index" class="table-row">
                <span class="table-cell">{{ item.qualification }}</span>
                <span class="table-cell">{{ item.examDate }}</span>
                <span class="table-cell">{{ item.mode }}</span>
                <span class="table-cell">{{ item.remainingTime }}</span>
                <span class="table-cell">{{ item.score }}</span>
            </div>
            <div class="pagination">
                <button @click="prevPage" :disabled="currentPage === 1">이전</button>
                <span>{{ currentPage }} / {{ totalPages }}</span>
                <button @click="nextPage" :disabled="currentPage === totalPages">다음</button>
            </div>
        </div>
    </div>
    <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: 'MyPage',
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
                { qualification: '자격1', examDate: '2024-01-01', mode: '모드1', remainingTime: '1시간', score: 90 },
                { qualification: '자격2', examDate: '2024-02-01', mode: '모드2', remainingTime: '2시간', score: 85 },
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

.myPage_container {
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
    text-align: center;
    align-items: center;
    justify-content: center;
    justify-items: center;
}

.user_info {
    font-size: 1.3em;
    font-weight: 900;
}

.user_wrap{
    margin-bottom: 10px;
}
.user_wrap div{
    margin-bottom: 5px;
}
.label{
    font-weight: bold;
}
.button_wrap{
    display: flex;
    margin-bottom: 10px;
    justify-content: center;
    width:100%;
}

.table-container {
    width: 80%;
    background-color: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    font-size: 0.5em;
    border: solid 1px black;    
}

.table-header,
.table-row {
    display: flex;
    justify-content: space-between;
    padding: 10px 0;
}

.table-cell {
    flex: 1;
    text-align: center;
}

.table-header {
    font-weight: bold;
    border-bottom: 2px solid #ddd;
}

.table-row {
    border-bottom: 1px solid #eee;
}

.pagination {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.pagination button {
    padding: 5px 10px;
    margin: 0 5px;
    border: none;
    background-color: #5271FF;
    color: white;
    border-radius: 5px;
    cursor: pointer;
}

.pagination button:disabled {
    background-color: #ccc;
    cursor: not-allowed;
}

.JYblue_btn{
    background-color: #5271FF;
    border-radius: 5px;
    color: #fff;
    font-size: 1.2em;
}
.pink_btn{
    background-color: #ff7b7b;
    border-radius: 5px;
    color: #000;
    font-size: 1.2em;
    margin: 0px 10px;
}
.red_btn{
    background-color: #f00;
    border-radius: 5px;
    color: #fff;
    font-size: 1.2em;
}
</style>