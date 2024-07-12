<template>
  <TopBar />
  <div class="login-container">
    <form class="login-form">
      <p class="heading">로그인</p>
      <br>
      <div class="input-group">
        <input required="" placeholder="아이디" id="username name=" type="text" />
      </div>
      <div class="input-group">
        <input required="" placeholder="비밀번호" name="password" id="password" type="password" />
      </div>
      <button type="submit">로그인</button>
      <div class="bottom-text">
        <p>계정이 없으신가요? <a href="/test2">회원가입</a></p>
        <p><a href="test3" class="idhref">아이디 찾기</a><a href="test4" class="pwhref">비밀번호 찾기</a></p>
      </div>
      <br />
      <hr>
      <br>
      <button class="withoutlogin" type="button" @click="goToCC">로그인 없이 시작</button>
    </form>
  </div>
</template>

<script>
import TopBar from '@/components/TopBar.vue';

export default {
  name: "PracticeMode",
  components: {
    TopBar,
  },
  data() {
    return {

    }
  },
  methods: {
    goToCC() {
      this.$router.push({ name: 'CategoryChoice' });
    }
  },

  created() {

  },
  mounted() {

  },
}
</script>

<style scoped>
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
</style>
