<template>
  <TopBar />
  <div class="changeInfo_container">
    <div class="container">
      <div class="title">
        <p>회원 정보</p>
      </div>
      <div class="wrap">
        <div class="id">
          <p>아이디</p>
          <input type="text" v-model="id" readonly="readonly"/>
        </div>
        <div class="name">
          <p>이름</p>
          <input type="text" v-model="name" readonly="readonly"/>
        </div>
      </div>

      <div class="pw">
        <p>비밀번호</p>
        <div class="input-group">
            <input type="password" placeholder="비밀번호 재설정">
        </div>
        <text>8자리 이상 영문, 대소문자 구분, 특수기호 포함</text>
      </div>
      <div class="pw-check">
        <p>비밀번호 확인</p>
        <div class="input-group">
            <input type="password" placeholder="비밀번호 입력">
        </div>
      </div>
      <div class="phoneNum">
        <p>전화번호</p>
        <div class="input-group">
          <input class="phoneNum-input" type="text" />
          <button class="small-btn">인증번호 전송</button>
        </div>
      </div>
      <div class="phoneNum-check">
        <p>인증번호</p>
        <div class="input-group">
          <input class="phoneNum-input" type="text" />
          <button class="small-btn">인증번호 확인</button>
        </div>
      </div>
      <div class="nickname">
        <p>닉네임</p>
        <div class="input-group">
          <input class="phoneNum-input" type="text" />
          <button class="small-btn">중복확인</button>
        </div>
      </div>

      <div class="gender">
        <p>성별</p>
        <div class="input-group2">
          <button class="gender-btn">남자</button>
          <button class="gender-btn">여자</button>
        </div>
      </div>

      <div class="big-btn">
        <div class="input-group3">
          <button class="back-btn">뒤로가기</button>
          <button class="update-btn">수정하기</button>
        </div>
      </div>
    </div>

  </div>
  <BottomBar />
</template>
<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: "ChangeInfo",
    components: {
        TopBar, BottomBar
    },
    data() {
    return {
      id: 'hello',
      name: '홍길동',
    };
  },
  methods: {
    
  },
}
</script>
<style scoped>
.changeInfo_container {
    top: 7%;
    position: fixed;
    overflow-y: auto;
    /* 컨텐츠가 넘칠 경우 스크롤 */
    height: calc(100% - 16%);
    /* 전체 높이에서 상단바와 하단바 높이 제외 */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    /* 세로 중앙 정렬 (필요에 따라 조정) */
    width: 100%;
    border-radius: 10px;
    padding: 0.6em 0.8em;

}

.container {
  width: 95%;
  height: 100%;
  border: 1px solid black;
  border-radius: 5px;
  padding: 0 30px;
}

/** 제목 : 회원정보 */
.title {
  width: 100%;
  height: 8%;
  text-align: center;
  font-size: 1.5em;
  display: flex;
  align-items: center;
  justify-content: center;
}

input {
  width: 100%;
  border-radius: 5px;
  box-sizing: border-box;
  font-size: 1em;
}
/** 아이디, 이름 */
.wrap {
  width: 100%;
  height: 9%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.id, .name {
  width: 45%;
  display: flex;
  flex-direction: column;
}


.id>p, .name>p {
  font-size: 0.7em;
  color: #000000;
}

.id>input, .name>input {
  width: 100%;
  height: 100%;
  border-radius: 5px;
  background-color: #c7c7c7;
  box-sizing: border-box;
  font-size: 0.9em;
}

/** 비밀번호 */
.pw {
  width: 100%;
  height: 12%;
  display: flex;
  flex-direction: column;
  margin-top: 0.8em;
}
.pw>text {
  font-size: 0.7em;

}

.input-group {
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: space-between;
  align-items: center;
}

/** 전화번호, 인증번호, 닉네임 */
.pw-check, .phoneNum, .phoneNum-check, .nickname{
  width: 100%;
  height: 9%;
  display: flex;
  flex-direction: column;
  margin-top: 0.8em;
}

.phoneNum-input {
  width: 60%;
  height: 60%;
  border-radius: 5px;
  box-sizing: border-box;
}

.small-btn {
  background-color: #000000;
  width: 30%;
  height: 60%;
  border-radius: 5px;
  color: #FFF;
  font-size: 0.7em;
}

/** 성별 */
.gender {
  width: 100%;
  height: 10%;
  display: flex;
  flex-direction: column;
  margin-top: 0.8em;
}

.input-group2{
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: space-between;
  align-items: center;
}

.gender-btn{
  width: 40%;
  height: 70%;
  border-radius: 5px;
  background: #000;
  color: #FFF;
  font-size: 0.7em;
}

/** 수정하기, 뒤로가기 버튼  */
.big-btn {
  width: 100%;
  height: 9%;
  display: flex;
  flex-direction: column;
  margin-top: 0.8em;
}
.input-group3 {
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: space-between;
  align-items: center;
  padding: 0 10px;
}
.back-btn, .update-btn {
  width: 35%;
  height: 80%;
  border-radius: 5px;
  background: #5271FF;
  color: #FFF;
  font-size: 0.9em;
}
</style>