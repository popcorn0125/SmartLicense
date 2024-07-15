<template>
  <TopBar />
  <div class="login-container">
    <form class="login-form">
      <p class="heading">회원가입</p>
      <div class="input-group btn_posi">
        <input placeholder="아이디" id="username" name="username" type="text" />
        <button type="button">중복확인</button>
      </div>

      <div class="input-group">
        <input placeholder="비밀번호" name="password" id="password" type="password" />
      </div>
      <div class="input-group">
        <input placeholder="비밀번호 재확인" name="password" id="password" type="password" />
      </div>
      <div class="input-group">
        <input placeholder="이름" name="password" id="password" type="password" />
      </div>
      <div class="input-group btn_posi">
        <input placeholder="닉네임" name="password" id="password" type="password" />
        <button type="button">중복확인</button>
      </div>
      <div class="gender-selection">
        <div class="gender-option">
          <input type="radio" id="male" name="gender" v-model="gender" value="남">
          <label for="male">남</label>
        </div>
        <div class="gender-option">
          <input type="radio" id="female" name="gender" v-model="gender" value="여">
          <label for="female">여</label>
        </div>
      </div>
      <div class="input-group btn_posi">
        <input placeholder="전화번호" name="password" id="password" type="password" />
        <button type="button">인증번호 전송</button>
      </div>
      <div class="input-group btn_posi">
        <input placeholder="인증번호" name="password" id="password" type="password" />
        <button type="button">확인</button>
      </div>
      <button type="submit">Sign up</button>
      <div class="bottom-text">
      </div>
    </form>
  </div>

</template>

<script>
import TopBar from '@/components/TopBar.vue';

export default {
  name: "SignUpPage",
  components: {
    TopBar,
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
  margin-bottom: 1em;
}


.input-group {
  margin-bottom: 20px;
  height: 2em;
}

.btn_posi {
  display: flex;
}

.btn_posi>input {
  width: 60%;
}

.btn_posi>button {
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
  margin-bottom: 20px;
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
</style>