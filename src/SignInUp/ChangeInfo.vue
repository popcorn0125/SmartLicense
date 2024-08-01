<template>
  <TopBar />
  <div class="login-container">
    <form class="login-form">
      <p class="heading">정보수정</p>
      <div class="include-msg">
        <div class="input-group btn_posi disableinput">
          <input v-model="member.member_id" placeholder="아이디" name="userID" type="text" maxlength="20" disabled />
        </div>
      </div>
      <div class="include-msg">
        <div class="input-group">
          <input v-model="member.member_password" placeholder="비밀번호(8~16글자, 영문, 숫자, 특수문자 모두 포함)" type="password" />
        </div>
        <text id="password" class="infoMessage">{{ pwMsg }}</text>
      </div>
      <div class="include-msg">
        <div class="input-group">
          <input v-model="pwCheck" placeholder="비밀번호 재확인" id="confirm-Password" type="password" />
        </div>
        <text id="passwordCheck" class="infoMessage">{{ pwCheckMsg }}</text>
      </div>
      <div class="include-msg">
        <div class="input-group disableinput">
          <input v-model="member.member_name" placeholder="이름" type="text" maxlength="20" disabled/>
        </div>
      </div>
      <div class="include-msg">
        <div class="input-group btn_posi">
          <input v-model="member.member_nickname" placeholder="닉네임" type="text" />
          <button class="button1" type="button" @click="isDuplicateNickName()">중복확인</button>
        </div>
        <text id="nickname" class="infoMessage">{{ nickNameMsg }}</text>
      </div>
      <div class="include-msg">
        <div class="input-group btn_posi">
          <input @input="phoneNumChange()" v-model="member.member_phone_number" placeholder="전화번호" type="text" />
        </div>
        <text id="phone" class="infoMessage">{{ phoneMsg }}</text>
      </div>
      <div class="include-msg">
        <div class="gender-selection">
          <div class="gender-option">
            <input type="radio" id="male" name="gender" v-model="member.member_gender" value="M" disabled>
            <label for="male">남</label>
          </div>
          <div class="gender-option">
            <input type="radio" id="female" name="gender" v-model="member.member_gender" value="F" disabled>
            <label for="female">여</label>
          </div>
        </div>
      </div>
      <button class="button1" type="button">수정 하기</button>
    </form>
    <div class="DA-wrap">
      <p class="deleteAccount" @click="isShowModal = true">탈퇴 하기</p>
    </div>
  </div>

   <!---------알림 모달 창--------->
  <!-- <div class="modal" v-if="isShowModal">
    <div class="modal-content">
      <p>한번 탈퇴하면 지금까지의 모든 기록과 정보는 삭제됩니다.</p>
      <p>정말로 <strong>&nbsp;탈퇴</strong>하시겠습니까?</p>
      <div class="del-btn-wrap">
        <button class="ok">확인</button>
        <button class="cancel" @click="isShowModal = false">취소</button>
      </div>
    </div>
  </div> -->
  <div class="modal" v-if="isShowModal">
    <div class="card">
      <div class="header">
        <div class="image"><svg aria-hidden="true" stroke="currentColor" stroke-width="1.5" viewBox="0 0 24 24" fill="none">
                    <path d="M12 9v3.75m-9.303 3.376c-.866 1.5.217 3.374 1.948 3.374h14.71c1.73 0 2.813-1.874 1.948-3.374L13.949 3.378c-.866-1.5-3.032-1.5-3.898 0L2.697 16.126zM12 15.75h.007v.008H12v-.008z" stroke-linejoin="round" stroke-linecap="round"></path>
                  </svg></div>
        <div class="content">
          <span class="title">회원 탈퇴</span>
          <p class="message">정말로 회원 탈퇴를 원하십니까? 탈퇴 시 모든 정보가 삭제되며 복구할 수 없습니다.</p>
          <br>
          <hr>
        </div>
        <div class="actions">
          <button class="desactivate" type="button">Desactivate</button>
          <button class="cancel" type="button" @click="isShowModal = false">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  

  <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue';
import axios from 'axios';

export default {
  name: "ChangeInfo",
  components: {
    TopBar, BottomBar,
  },
  data() {
    return {
      member : {
        member_id : sessionStorage.getItem('USER_ID'),
        member_password : '',
        member_name : '',
        member_nickname : '',
        member_gender : '',
        member_phone_number : '',
      },
      isShowModal: false,
      pwCheck : '',

    }
  },
  methods: {
    // 닉네임 중복 확인
    isDuplicateNickName() {

    },

    // 사용자 닉네임, 전화번호 불러오기
    loadUserInfo() {
      const vm = this;
      axios({
        method : 'post',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/api/getUserInfo",
        data: {member_id : vm.member.member_id }
      })
        .then(response => {
          if(response.data != null) {
            vm.member.member_name = response.data.member_name;
            vm.member.member_nickname = response.data.member_nickname;
            vm.member.member_phone_number = response.data.member_phone_number;
            vm.member.member_gender = response.data.member_gender;
          } else {
            console.log('정보를 불러오는데 실패하였습니다.');
          }
        })
        .catch(error => {
          console.log(error);
        })
    }
  },

  created() {

  },
  mounted() {
    this.loadUserInfo();
  },
}
</script>

<style scoped>
.include-msg {
  margin-bottom: 20px;
}

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

input:focus {
  outline: none;
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
  overflow-y:auto;
}

.login-form {
  display: flex;
  flex-direction: column;
}

.heading {
  color: #000000;
  font-weight: 500;
  font-size: 1.7em;
  margin-bottom: 1em;
}

.btn_posi {
  display: flex;
}

.btn_posi>input {
  width: 60%;
}

.btn_posi>.button1 {
  width: 40%;
  padding: 0;
  font-size: .7em;
  margin-left: .5em;

}

.input-group input {
  background: none;
  border: 1px solid #d1d1d1;
  padding: 0.7em 1em;
  font-size: 0.7em;
  border-radius: 8px;
  color: #000000;
  width: 100%;
}

.button1 {
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
  font-size: .8em;
  font-weight: 400;
}

.bottom-text a {
  color: #0173ed;
  text-decoration: none;
  transition: color 0.3s ease;
}

.gender-selection {
  display: flex;
  justify-content: space-evenly;
  background-color: #f0f8ff;
  /* margin-bottom: 20px; */
  padding: 10px;
  border-radius: 10px;
  border: .5px solid #d1d1d1;
}

.gender-option {
  display: flex;
  align-items: center;
  color: #0173ed;
  font-weight: bold;
}

.gender-option input {
  margin-right: 5px;
}

.disableinput {
  background-color: #e7e7e7;
  border-radius: 8px;
}

.DA-wrap {
  position: absolute;
  bottom: 1em;
  width: calc(100% - 5em);
  text-align: right;
}
.deleteAccount{
  text-decoration-line: none;
  font-size: 11px;
  color: #a8a8a8;
  cursor: pointer;
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

/* .modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 15px;
  border: 1px solid #888;
  border-radius: 5px;
  width: 80%;
  max-width: 500px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  height: 30%;
}

.modal-content > p{
  font-size: .7em;
  height: 25%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content > p > strong{
  color: #F00;
}

.del-btn-wrap{
  height: 50%;
  width: 100%;
}
.del-btn-wrap > button{
  margin-top: 2em;
  width: 30%;
  height: 45%;
  padding: 5px;
  border: none;
  border-radius: 8px;
  color: #ffffff;
  font-size: 0.7em;
  box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
    rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
    rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px;

}
.ok{
  text-align: center;
  background-color: #888;
  vertical-align: middle;
  margin-right: 1em;
}
.cancel{
  text-align: center;
  background-color: #000;
  vertical-align: middle;
  margin-left: 1em;
} */
.card {
  overflow: hidden;
  position: relative;
  background-color: #ffffff;
  text-align: left;
  border-radius: 0.5rem;
  max-width: 40%;
  box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
}

.header {
  padding: 1.25rem 1rem 1rem 1rem;
  background-color: #ffffff;
}

.image {
  display: flex;
  margin-left: auto;
  margin-right: auto;
  background-color: #FEE2E2;
  flex-shrink: 0;
  justify-content: center;
  align-items: center;
  width: 3rem;
  height: 3rem;
  border-radius: 9999px;
}

.image svg {
  color: #DC2626;
  width: 1.5rem;
  height: 1.5rem;
}

.content {
  margin-top: 0.75rem;
  text-align: center;
}

.title {
  color: #111827;
  font-size: 1rem;
  font-weight: 600;
  line-height: 1.5rem;
}

.message {
  margin-top: 0.5rem;
  color: #6B7280;
  font-size: 0.875rem;
  line-height: 1.25rem;
}

.actions {
  margin: 0.75rem 1rem;
  background-color: #F9FAFB;
}

.desactivate {
  display: inline-flex;
  padding: 0.5rem 1rem;
  background-color: #DC2626;
  color: #ffffff;
  font-size: 1rem;
  line-height: 1.5rem;
  font-weight: 500;
  justify-content: center;
  width: 100%;
  border-radius: 0.375rem;
  border-width: 1px;
  border-color: transparent;
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

.cancel {
  display: inline-flex;
  margin-top: 0.75rem;
  padding: 0.5rem 1rem;
  background-color: #ffffff;
  color: #374151;
  font-size: 1rem;
  line-height: 1.5rem;
  font-weight: 500;
  justify-content: center;
  width: 100%;
  border-radius: 0.375rem;
  border: 1px solid #D1D5DB;
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

</style>