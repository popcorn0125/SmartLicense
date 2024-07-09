<template>
    <TopBar />
    <div class="practive_mode_container">
      <div class="select_test">
        <span>{{ DetailLicense }}</span><span>{{ TestDate }}</span>
      </div>
      <div class="current_sub">
        <p>{{ Subject }}</p>
      </div>
      <div class="current_info">
        <p>총 문항 갯수 : {{ totalQuestionCount }}</p>
        <p>정답 갯수 : {{ corretCount }}</p>
        <p>오답 갯수 : {{ wrongCount }}</p>
      </div>
      <div class="msg">
        <p id="msgColor">{{ resultMessage }} 기준입니다.</p>
      </div>
      <div class="next-btn">
        <button>{{ buttonName }}</button>
      </div>
    </div>


     
  
    <BottomBar />
  </template>
  
  <script>
  import TopBar from '@/components/TopBar.vue';
  import BottomBar from '@/components/BottomBar.vue'
  export default {
    name: "PracticeResult",
    components: {
      TopBar, BottomBar
    },
    data() {
      return {
        DetailLicense: "정보처리기사",
        TestDate: "2020년 4월 24일",
        Subject: "1과목 : 소프트웨어 설계",
        buttonName: "다음 과목 풀기", // 버튼 이름
        totalQuestionCount : 20, // 총 문항 갯수
        corretCount : 13, // 정답 갯수
        wrongCount : 5, // 오답 갯수
        resultMessage : "합격", // 결과 메세지 ex) 합격 or 불합격

      }
    },
    methods: {
      // 합격 불합격 기준입니다. 글 색상 변경.
      messageColor() {
        let vm = this;
        let p = document.querySelector("#msgColor");
        console.log(p);
        if(vm.corretCount < 8) {
          vm.resultMessage = "과락";
          p.style.color = "red"; // 빨간색
          return ;
        }
        if(vm.corretCount < 12) {
          vm.resultMessage = "불합격";
          p.style.color = "red"; // 빨간색
          return ;
        }
      }
      
    },
  
    created() {
  
    },
    mounted() {
      this.messageColor();
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
  
  .current_info {
    margin-top: 0.5em;
    margin-bottom: 2em;
    font-size: 1.1em;
  }

  .current_info>p {
    margin: 0.5em;
  }

  .msg {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 2em;
  }

  .next-btn {
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .next-btn>button {
    width: 50%;
    height: 25%;
    background: #5271FF;
    color: #FFF;
    border-radius: 5px;
    padding: 0 0.8em;
    font-size: 1.1em;
  }
  
  #msgColor {
    color: rgb(116, 216, 116);
    font-weight: 900;
  }
  </style>
  