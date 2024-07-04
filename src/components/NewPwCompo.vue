<template>
    <div class="new_pw_compo">
        <p>새로운 비밀번호</p>
        <input type="text" class="new_pw_box">
        <p class="pw_explain">8자리 이상 영문, 대소문자 구분, 특수기호 포함</p>

        <p>비밀번호 확인</p>
        <input type="text" class="pw_check_box">

        <button class="black_long_btn">비밀번호 재설정</button>
    </div>
</template>
<script>

export default {
    name: "NewPwCompo",
    data() {
    return {
      
    };
  },
  methods: {
   
  },
}
</script>
<style scoped>
.new_pw_compo{
    position: fixed;
    width: 100%;
    margin-left: 15%;
    margin-top: 30%;
}

.pw_explain{
    margin-top: 2%;
    font-size: 0.7em;
    margin-bottom: 7%;
}


.new_pw_box, .pw_check_box{
    width: 85%;
}

.black_long_btn{
    width: 85%;
    margin-top: 10%;
}
</style>