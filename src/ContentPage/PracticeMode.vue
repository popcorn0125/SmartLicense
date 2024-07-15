<template>
  <TopBar />
  <div class="practive_mode_container">
    <div class="popup-container">
      <div class="popup info-popup">
        <div class="info-message">{{ DetailLicense }}</div>
      </div>
      <div class="popup info-popup">
        <div class="info-message">{{ TestDate }}</div>
      </div>
      <div class="popup info-popup">
        <div class="info-message">{{ Subject }}</div>
      </div>
    </div>
    <div class="current_Q">
      <p>{{ Qnumber }}. {{ Question }}</p>
      <img src="@/assets/testimg.png">
    </div>
    <span class="toggle-btn" @click="toggleBottomSheet"></span>
    <div class="radio-input" :class="{ 'is-visible': isBottomSheetVisible }">
      <div class="info">
        <span class="steps" @click="showExplanation">해설보기</span>
        <span class="close-explanation" @click="toggleBottomSheet">&times;</span>
      </div>
      <div class="scrollable">
        <input type="radio" id="value-1" name="value-radio" value="value-1" @click="checkAnswer(1)">
        <label for="value-1">{{ Option1 }}</label>
        <input type="radio" id="value-2" name="value-radio" value="value-2" @click="checkAnswer(2)">
        <label for="value-2">{{ Option2 }}</label>
        <input type="radio" id="value-3" name="value-radio" value="value-3" @click="checkAnswer(3)">
        <label for="value-3">{{ Option3 }}</label>
        <input type="radio" id="value-4" name="value-radio" value="value-4" @click="checkAnswer(4)">
        <label for="value-4">{{ Option4 }}</label>
      </div>
      <!-- <span class="result success" v-if="displayCorrectAnswer">정답입니다.</span>
      <span class="result error" v-if="displayWrongAnswer">오답입니다.</span> -->
      <div class="btn_collection" @click="verifyAnswer" v-if="Qnumber<20">
        다음 문제 >
      </div>
      <div class="btn_collection" @click="verifyAnswer" v-if="Qnumber==20">
        {{ Subject }} 점수 보기
      </div>
    </div>
    <div class="last_Q" v-if="Qnumber == 20">
      <p>마지막 문제입니다.</p>
    </div>

  </div>

  <!---------해설보기 모달 창--------->
  <div class="modal" v-if="isModalVisivle">
    <div class="modal-content">
      <p>{{ Description }}</p>
      <span class="close" @click="closeModal">&times;</span>
    </div>
  </div>
</template>

<script>
import TopBar from '@/components/TopBar.vue';
export default {
  name: "PracticeMode",
  components: {
    TopBar
  },
  data() {
    return {
      DetailLicense: "정보처리기사",
      TestDate: "2020년 4월 24일",
      Subject: "소프트웨어 설계",
      Qnumber: "10",
      Question: "UML 다이어그램 중 순차 다이어그램에 대한 설명으로 틀린 것은?",
      Option1: "1. 객제 간의 동적 상호작용을 시간 개념을 중심으로 모델링 하는 것이다.",
      Option2: "2. 주로 시스템의 정적 측면을 모델링하기 위해 사용한다.",
      Option3: "3. 일반적으로 다이어그램의 수직 방향이 시간의 흐름을 나타낸다.",
      Option4: "4. 회귀 메시지(Self-Message), 제어블록(Statement block) 등으로 구성된다.",
      Description: "순차 다이어그램은 행위 다이어그램이므로 동적이고, 순차적인 표현을 위한 다이어그램이다.",
      correctAnswer: 2, // 정답 번호
      selectedOption: null,
      // displayWrongAnswer: false,
      // displayCorrectAnswer: false,
      showCorrectAnswer: false,
      isModalVisivle: false,
      isBottomSheetVisible: true,
    }
  },
  methods: {
    checkAnswer(option) {
      this.selectedOption = option;
      // this.showCorrectAnswer = false;
      // this.displayWrongAnswer=true;
      // this.displayCorrectAnswer = true;
    },

    // verifyAnswer() {
    //   this.showCorrectAnswer = true;
    //   if (this.selectedOption === this.correctAnswer) {
    //     this.displayCorrectAnswer = true;
    //     this.displayWrongAnswer = false;
    //   } else {
    //     this.displayCorrectAnswer = false;
    //     this.displayWrongAnswer = true;
    //   }
    // },

    showExplanation() {
      this.isModalVisivle = true;
    },
    closeModal() {
      this.isModalVisivle = false;
    },

    toggleBottomSheet() {
      this.isBottomSheetVisible = !this.isBottomSheetVisible;
    },
  },

  created() {

  },
  mounted() {

  },
}
</script>

<style scoped>
.practive_mode_container {
  top: 6%;
  position: fixed;
  height: 94%;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}
.scrollable{
  overflow-y: auto;
  
}
.scrollable::-webkit-scrollbar{
  display: none;
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

.current_Q {
  margin: 0.7em;
  padding: 0.3em;
  box-sizing: border-box;
  height: 95%;
  z-index: 0;
}

.A_wrap {
  display: flex;
}

@keyframes blink-effect {

  0%,
  100% {
    opacity: 1;
  }

  50% {
    opacity: 0;
  }
}

.last_Q {
  position: fixed;
  right: 1em;
  top: .7em;
  color: red;
  font-weight: bold;
  animation: blink-effect 1s ease-in-out infinite;
}

.btn_collection {
  display: flex;
  width: 100%;
  border-radius: 5px;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: #353535;
  color: #fff;
  padding: 10px;
  margin-top: 10px;
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
  display: flex;
  ;
}



/* COMMON STYLES*/
.popup-container {
  display: flex;
  height: 5%;
  align-items: center;
  margin-top: .5em;
}

.popup {
  margin: 0em .5em 0em .5em;
  box-shadow: 4px 4px 10px -10px rgba(0, 0, 0, 1);
  width: auto;
  height: 70%;
  padding: .3em;
  justify-content: left;
  align-items: center;
  display: flex;
  border-radius: 4px;
  font-weight: 300;
  font-size: .7em;
}

/* INFO */

.info-popup {
  background-color: #eff6ff;
  border: solid 1px #1d4ed8;
}

.info-icon path {
  fill: #1d4ed8;
}

.info-message {
  color: #1d4ed8;
}

.radio-input input {
  display: none;
}

.radio-input {
  display: flex;
  flex-direction: column;
  padding: 12px;
  background: #fff;
  color: #000;
  border-radius: 10px;
  box-shadow: 0px 87px 78px -39px rgba(0, 0, 0, 0.4);
  width: 100%;
  position: fixed;
  bottom: -100%;
  transition: bottom .5s ease-in-out;
  height: 53%;
  /* overflow-y: auto; */
  box-shadow: 0px -1px 1px 0px rgba(0, 0, 0, 0.1);

}

.radio-input.is-visible {
  bottom: 0;
}

.info {
  margin-bottom: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.toggle-btn {
  position: relative;
  width: 3em;
  height: 3em;
  margin-right: 2.7em;
  margin-bottom: 1em;
}

.toggle-btn::after {
  position: absolute;
  left: 35px;
  top: 20px;
  content: '';
  width: 1em;
  /* 사이즈 */
  height: 1em;
  /* 사이즈 */
  border-top: 5px solid #000;
  /* 선 두께 */
  border-right: 5px solid #000;
  /* 선 두께 */
  transform: rotate(315deg);
  /* 각도 */
}

.question {
  color: rgb(49, 49, 49);
  font-size: 1rem;
  line-height: 1rem;
  font-weight: 800;
}

.steps {
  background-color: rgb(0, 0, 0);
  padding: 4px;
  color: #fff;
  border-radius: 4px;
  font-size: 12px;
  line-height: 12px;
  font-weight: 600;
}

.radio-input label {
  display: flex;
  background-color: #fff;
  padding: 14px;
  margin: 8px 0 0 0;
  font-size: 13px;
  font-weight: 600;
  border-radius: 10px;
  cursor: pointer;
  border: 1px solid rgba(187, 187, 187, 0.164);
  color: #000;
  transition: .3s ease;
}

.radio-input label:hover {
  background-color: rgba(24, 24, 24, 0.13);
  border: 1px solid #bbb;
}

.result {
  margin-top: 10px;
  font-weight: 600;
  font-size: 12px;
  display: none;
  transition: display .4s ease;
}

.result.success {
  color: green;
}

.result.error {
  color: red;
}

.radio-input input:checked+label {
  border-color: red;
  color: red;
}

.radio-input input[value="value-2"]:checked+label {
  border-color: rgb(22, 245, 22);
  color: rgb(16, 184, 16);
}

.radio-input:has(input[value="value-2"]:checked) .result.success {
  display: flex;
}

.radio-input:has(input:not([value="value-2"]):checked) .result.error {
  display: flex;
}
</style>