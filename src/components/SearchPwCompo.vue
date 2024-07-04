<template>
  <div class="search_pw_compo">
    <p>아이디</p>
    <input type="text" class="id_box">

    <p>전화번호</p>
    <input type="text" class="phone_box">
    <button class="check_num_send">인증번호 전송</button>

    <p>인증번호</p>
    <input type="text" class="check_num">
    <button class="check_btn">확인</button>

    <button class="black_long_btn" @click="findPassword">비밀번호 찾기</button>
  </div>
</template>
<script>
export default {
  name: "SearchPwCompo",
  data() {
    return {

    };
  },
  methods: {
    findPassword() {
      this.$emit('passwordFound');
    }
  },
}
</script>
<style scoped>
.search_pw_compo {
  position: fixed;
  width: 100%;
  margin-left: 15%;
  margin-top: 30%;
}

.phone_box, .id_box{
  margin-bottom: 5%;
}

.phone_box,
.id_box,
.check_num {
  width: 50%;
  margin-right: 5%;
}

.check_num_send,
.check_btn {
  background-color: #000;
  color: #fff;
  border-radius: 5px;
  font-size: 0.7em;
  width: 30%;
  height: 35px;
}

.black_long_btn {
    width: 85%;
    margin-top: 10%;
    margin-bottom: 5%;
}
</style>