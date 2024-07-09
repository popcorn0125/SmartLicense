<template>
  <TopBar />
  <div class="practive_mode_container">
    <div class="select_test">
      <span>{{ DetailLicense }}</span><span>{{ TestDate }}</span>
    </div>
    <div class="current_sub">
      <p>남은 시간 : {{ RemainingTime }}</p>
    </div>

    <div class="current_subject">
      <p class="subject_name">1과목 : 소프트웨어 설계(15/20)</p>
      <p class="result">합격</p>
    </div>
    <div class="current_subject">
      <p class="subject_name">2과목 : 소프트웨어 개발(19/20)</p>
      <p class="result">합격</p>
    </div>
    <div class="current_subject">
      <p class="subject_name">3과목 : 데이터베이스 구축(17/20)</p>
      <p class="result">합격</p>
    </div>
    <div class="current_subject">
      <p class="subject_name">4과목 : 프로그래밍 언어 활용(10/20)</p>
      <p class="result">합격</p>
    </div>
    <div class="current_subject">
      <p class="subject_name">5과목 : 정보시스템 구축관리(5/20)</p>
      <p class="result2">불합격</p>
    </div>
    <div class="final_result">
      <p>최종(66/100) : <span>{{ resultMessage }}</span></p>
    </div>
    <div class="description">
      <p>아쉽게도 불합격하였습니다.</p>
    </div>
    <div class="check-btn">
      <button type="button">확인</button>
    </div>

  </div>

  <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
  name: "TestResult",
  components: {
    TopBar, BottomBar
  },
  data() {
    return {
      DetailLicense: "정보처리기사",
      TestDate: "2020년 4월 24일",
      RemainingTime: "05분 07초",
      resultMessage: "불합격"
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
.practive_mode_container {
  top: 7%;
  position: fixed;
  height: calc(100% - 16%);
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

.select_test {
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  font-size: 1.5em;
  font-weight: 500;
}

.current_sub {
  font-size: 1.2em;
}

.current_subject {
  display: flex;
  width: 100%;
  height: 9%;
  align-items: center;
  justify-content: center;
  /* border: 1px solid black; */
}

.subject_name {
  width: 70%;
  height: 100%;
  font-size: 0.8em;
  display: flex;
  align-items: center;
  justify-content: left;
  margin-left: 2.5em;
  /* border: 1px solid black; */
}

.result {
  width: 30%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #04B900;
  font-weight: 700;
}

.result2 {
  width: 30%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #FF0000;
  font-weight: 700;
}

.final_result {
  margin-top: 1em;
  font-size: 1.5em;
  font-weight: 500;
}

.description {
  margin-top: 0.7em;
  font-size: 1.4em;
}

.check-btn {
  width: 35%;
  height: 10%;
  border-radius: 8px;
  background: #5271FF;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 2.5em;
}

.check-btn>button {
  color: #FFF;
}

.final_result>p>span {
  color: #F00;
}
</style>
  