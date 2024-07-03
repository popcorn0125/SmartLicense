<template>
  <div id="splash_screen">
    <div class="header">
      <h1 class="splash_logo">Smart License</h1>
    </div>
    <div class="id_pw">
      <input type="text" class="Id" placeholder="ID">
      <input type="password" class="Pw" placeholder="PW">
    </div>
    <div class="search_idpwsu">
      <p @click="movePage('id')">아이디 찾기</p>|
      <p @click="movePage('password')">비밀번호 찾기</p>|
      <p @click="movePage('userSignUp')">회원 가입</p>
    </div>
    <div class="bottom_btn">
      <button class="navy_long_btn">로그인</button>
      <button class="black_long_btn" @click="movePage('noLogin')">로그인 없이 시작하기</button>
    </div>
    <div class="footer">
      <p>로그인 없이 시작하면 문제를 푼 기록과 랭킹을 저장 또는 확인할 수 없습니다.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data() {
        return {
        }
    },

    methods: {
        movePage(page) {
          if (page === 'id') {
            this.$router.push({path : '/searchid', query : { currentView : 'id'}});
          }
          if (page === 'password') {
            this.$router.push({path : '/searchid', query : { currentView : 'password'}});
          }
          if (page === 'userSignUp') {
            this.$router.push({path: '/userSign'});
          }
          if (page === 'noLogin') {
            this.$router.push({path : '/CategoryChoice'});
          }
        },
    },

    created() {

    },
    mounted() {

    },
};
</script>

<style scoped>
@import "@/css/common.css";

#splash_screen {
  display: flex;
  flex-direction: column; /* 세로 방향으로 요소들을 배치 */
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-color: #5271FF;
  color: #fff;
}

.header {
  height: 10%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 10%;
}

.id_pw {
  height: 15%; /* 각 입력 필드가 차지하는 높이를 조정 */
  width: 100%;
  display: flex;
  flex-direction: column; /* 입력 필드들을 세로로 배치 */
  justify-content: space-around; /* 요소들 사이의 간격을 균등하게 분배 */
  align-items: center;
}
.Id .Pw{
  width: 70%;
  margin: 0;  
}
.id_pw > input{
  border: solid 1px #000;
  font-size: 1em;
  width: 80%;
}

.input_row {
  margin-bottom: 10px; /* 입력 필드 간의 간격 설정 */
}

.search_idpwsu {
  height: 5%;
  width: 80%;
  display: flex;
  justify-content: space-around;
  align-items: center;
  font-size: 0.5em;
}
.search_idpwsu p {
  margin: 0 2em; /* 좌우 간격을 5px로 설정 */
}

.bottom_btn {
  height: 20%;
  width: 100%;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
}

.footer {
  height: 10%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  font-size: 0.5em;
}
</style>