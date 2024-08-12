<template>
    <TopBar />
    <div class="myPage_container">
        <div class="card">
            <div class="infos">
                <div class="info">
                    <div>
                        <p class="name">
                            {{UserNickName}}
                        </p>
                        <p class="function">
                            {{UserName}}
                        </p>
                    </div>
                    <div class="stats">
                        <p class="flex flex-col">
                            오늘 푼 문제 수
                            <span class="state-value">
                                {{ todaySolvedProblems }}
                            </span>
                        </p>
                        <p class="flex">
                            오늘의 정답률
                            <span class="state-value">
                                {{ correctRate }}%
                            </span>
                        </p>

                    </div>
                </div>
            </div>
            <button class="request" type="button" @click="goToUserCheck">
                정보 수정
            </button>
        </div>
        <!-- <div class="card">
          <p>공지사항</p>
        </div>
        <div class="card">
          <p>알림설정</p>
        </div>
        <div class="card">
          <p>자주 묻는 질문</p>
        </div>
        <div class="card">
          <p>문의 하기</p>
        </div>
        <div class="card">
          <p>앱 버전</p>
        </div> -->
        <div class="logout"><a @click="logout()">로그아웃</a></div>
    </div>
    <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
import axios from 'axios';
export default {
    name: 'MyPage',
    components: {
        TopBar, BottomBar
    },
    data() {
        return {
            UserName: '',
            UserNickName: '',
            todaySolvedProblems: '',
            correctRate : '',
        };
    },
    methods: {
      goToUserCheck(){
        this.$router.push({ name : 'UserCheck'});
      },

      // 회원 정보 불러오기
      loadUserInfo() {
        const vm = this;
        const currentDate = new Date();
        const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`;
          
        const data = {
          member_id : sessionStorage.getItem('USER_ID'), // 사용자 ID or 게스트 ID
          current_date : formattedDate, // 현재 날짜
        }
        axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/api/loadUserInfo",
          data : data,
        })
          .then(response => {
            if(response.data != null ) {
              vm.UserName = response.data.member_name;
              vm.UserNickName = response.data.member_nickname;
              vm.todaySolvedProblems = response.data.total_count;
              if(response.data.correct_count == 0) {
                vm.correctRate = 0.00;
              } else {
                vm.correctRate = ((response.data.correct_count / vm.todaySolvedProblems) * 100).toFixed(2);
              }
              
            } else {
              console.log("정보를 불러오는데 실패하였습니다.");
            }
          })
          .catch(error => {
            console.log(error);
          })
      },

      // 로그아웃
      logout() {
        const vm = this;
        axios({
          method : 'post',
          header: { 'Content-Type': 'application/json; charset=UTF-8' },
          url: "/memberLogin/logout",
          data : {},
        })
          .then(() => {
              sessionStorage.clear();
              vm.$router.push({ name: 'LoginPage' });
            
          })
          .catch(error => {
            console.log(error);
          })
      }
    },

    mounted() {
      if( (sessionStorage.getItem('JSESSIONID') == null && sessionStorage.getItem('USER_ID') == null)){
        this.$router.push({ name: 'LoginPage' });
      } else{
        this.loadUserInfo();
      }
      
    }
}
</script>

<style scoped>
@import "@/css/common.css";

.myPage_container {
    top: 6%;
    position: relative;
    width: 100%;
    height: 88%;
    overflow-y: auto;
    display: flex;
    flex-direction: column;
    text-align: left;
    align-items: center;
    background-color: rgb(224, 224, 224);
}

.card {
  width: 97%;
  border-radius: 5px;
  background-color: #f9f9f9;
  padding: 1rem;
  margin: .4em 0 0 0;
}

.infos {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  grid-gap: 1rem;
  gap: 1rem;
}

.info {
  height: 7rem;
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.name {
  font-size: 1.25rem;
  line-height: 1.75rem;
  font-weight: 500;
  color: rgb(0, 0, 0);
}

.function {
  font-size: 0.75rem;
  line-height: 1rem;
  color: rgb(105, 105, 105);
}

.stats {
  width: 100%;
  border-radius: 0.5rem;
  background-color: rgba(255, 255, 255, 1);
  padding: 0.5rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 0.75rem;
  line-height: 1rem;
  color: rgba(0, 0, 0, 1);
}

.flex {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 4px;
}

.state-value {
  font-weight: 700;
  color: rgb(118, 36, 194);
}

.request {
  margin-top: 1.5rem;
  width: 100%;
  border: 1px solid transparent;
  border-radius: 0.5rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  line-height: 1.5rem;
  transition: all .3s ease;
  background-color: #353535;
  color: #fff;
}

.logout{
  position: absolute;
  bottom: 1.7em;
  font-size: .7em;
}
.logout > a{
  text-decoration: none;
  color: #959595;
}

</style>