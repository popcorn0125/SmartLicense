<template>
    <div>
        <p>아이디</p>
        <input type="text">

        <p>전화번호</p>
        <input type="text">
        <button>인증번호 전송</button>

        <p>인증번호</p>
        <input type="text">
        <button>확인</button>

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
    findPassword(){
        this.$emit('passwordFound');
    }
  },
}
</script>
<style></style>