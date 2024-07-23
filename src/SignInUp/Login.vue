<template>
  <TopBar />
  <div class="login-container">
    <form class="login-form">
      <p class="heading">로그인</p>
      <br>
      <div class="input-group">
        <input @input="changeId()" v-model="userId" required="" placeholder="아이디" id="username name=" type="text" />
        <text v-show="showIdMsg" id="userID" class="infoMessage">아이디를 입력하세요.</text>
      </div>
      <div class="input-group">
        <input @input="changePw()" v-model="userPw" required="" placeholder="비밀번호" name="password" id="password" type="password" />
        <text v-show="showPwMsg" id="userPW" class="infoMessage">비밀번호를 입력하세요.</text>
      </div>
      <button type="button" @click="login()">로그인</button>
      <div class="bottom-text">
        <p>계정이 없으신가요? <a href="/signup">회원가입</a></p>
        <p><a href="/findbyid" class="idhref">아이디 찾기</a><a href="/findbypw" class="pwhref">비밀번호 찾기</a></p>
      </div>
      <br />
      <hr>
      <br>
      <button class="withoutlogin" type="button" @click="goToCC()">로그인 없이 시작</button>
      <text class="noLoginMessage">로그인 없이 시작하면 문제를 푼 기록과 랭킹을 저장 또는 확인할 수 없습니다.</text>
    </form>
  </div>

  <!---------알림 모달 창--------->
  <div class="modal" v-if="isModalVisivle">
    <div class="modal-content">
      <p>{{ Description }}</p>
      <div class="btn_collection" @click="closeModal()">
        확인
    </div>
    </div>
  </div>
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import axios from 'axios';
export default {
  name: "LoginPage",
  components: {
    TopBar,
  },
  data() {
    return {
      Description : '',
      isModalVisivle : false, // 모달창 열기 여부
      showIdMsg : false, // 아이디를 입력하세요 메세지  (true : 보임, false : 안보임)
      showPwMsg : false, // 비밀번호를 입력하세요 메세지 (true : 보임, false : 안보임)
      userId : "", // 사용자 ID
      userPw : "", // 사용자 PW

    }
  },
  methods: {
    closeModal() {
      this.isModalVisivle = false;
    },
    // 아이디 입력을 감지 했을 경우
    changeId() {
      this.showIdMsg = false;
    },

    // 비밀번호 입력을 감지 했을 경우
    changePw() {
      this.showPwMsg = false;
    },

    goToCC() {
      const currentDate = new Date();
      const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}_${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;
      sessionStorage.setItem("GUEST", 'Guest_' + formattedDate);
      this.$router.push({ name: 'CategoryChoice' });
    },

    // 로그인
    login() {
      const vm = this;
      if(vm.userId == '' && vm.userPw == '') {
        vm.showIdMsg = true;
        vm.showPwMsg = true;
        return;
      }
      if(vm.userId == '') {
        vm.showIdMsg = true;
        return;
      }
      if(vm.userPw == '') {
        vm.showPwMsg = true;
        return ;
      }
      let dt = {
        userId : vm.userId,
        userPw : vm.userPw
      };
      console.log(dt);
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/memberLogin/verify",
        data: dt,
      })
        .then(function(response){
          if(response.data.result == 0) {
            vm.Description = response.data.message;
            vm.isModalVisivle = true;
          }
          if(response.data.result == 1) {
            vm.$router.push({ name: 'CategoryChoice' });
          }
        })
        .catch(function(){
          vm.Description = '죄송하지만 예기치 않은 오류가 발생했습니다. 나중에 다시 시도해주세요.'
          vm.isModalVisivle = true;
        });
    },

  },

  created() {

  },
  mounted() {
    if( (this.$cookies.get('JSESSIONID') != null && this.$cookies.get('USER_ID') != null)){
      this.$router.push({ name: 'CategoryChoice' });
    }
  },
}
</script>

<style scoped>
.infoMessage {
  display: block;
  color: #F00;
  -webkit-text-stroke-width: 1;
  -webkit-text-stroke-color: #000;
  font-family: Inter;
  font-size: 0.7em;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  text-align: left;
}

.bottom-text>p:nth-child(odd) {
  margin-bottom: 0.5em;
}

.login-container {
  position: relative;
  top: 6%;
  padding: 1em 2.5em 0em 2.5em;
  max-width: 800px;
  width: 100%;
  text-align: center;
  margin: 0 auto;
  height: 88%;
}

.login-form {
  display: flex;
  flex-direction: column;
}

.heading {
  color: #000000;
  font-weight: 500;
  font-size: 1.7em;
  margin-bottom: 5px;
}

.input-group {
  margin-bottom: 20px;

}

.input-group input {
  background: none;
  border: 1px solid #d1d1d1;
  padding: 15px 23px;
  font-size: 16px;
  border-radius: 8px;
  color: #000000;
  width: 100%;
  /* box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
    rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
    rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px; */
  height: 2em;
}

.input-group input:focus {
  border-color: #0173ed;
  outline: none;
}

button {
  padding: 15px;
  border: none;
  border-radius: 8px;
  background-color: #5271ff;
  color: #ffffff;
  font-size: 0.7em;
  font-weight: 500;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
    rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
    rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px;
}

.bottom-text {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  color: #000000;
  font-size: .7em;
  font-weight: 400;
}

.bottom-text a {
  color: #5271ff;
  text-decoration: none;
  transition: color 0.3s ease;

}

.bottom-text p {
  margin-top: 0.5em;
}

.withoutlogin {
  background-color: #353535;
}

.idhref {
  margin-right: .5em;
}

.pwhref {
  margin-left: .5em;
}

.noLoginMessage {
  display: block;
  color: rgb(26, 26, 26);
  -webkit-text-stroke-width: 1;
  -webkit-text-stroke-color: #000;
  font-family: Inter;
  font-size: 0.7em;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  text-align: left;
  margin-top: 1em;
}

/* 모달 스타일 */
.modal {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  z-index: 1000;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  border-radius: 5px;
  width: 80%;
  max-width: 500px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
  display: block;
  text-align: center;
}

.btn_collection {
  display: flex;
  width: 50%;
  border-radius: 5px;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: #353535;
  color: #fff;
  padding: 10px;
  margin: 10px auto;
}
</style>
