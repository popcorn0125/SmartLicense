<template>
  <TopBar />
  <div class="practive_mode_container">
    <div class="select_test">
      <span>{{ DetailLicense }}</span><span>{{ TestDate }}</span>    </div>
    <div class="current_sub">
      <p>{{ Subject }}</p>
    </div>
    <div class="current_Q">
      <p>{{ Qnumber }}. {{ Question }}</p>
    </div>
    <div class="current_A">
      <div class="A_wrap">
        <div class="raDio">
          <input type="radio" name="option" id="option1" @click="checkAnswer(1)">
        </div>
        <div class="opTion">
          <label :for="'option1'" :class="{ correct: showCorrectAnswer && correctAnswer === 1 }">{{ Option1 }}</label>
        </div>
      </div>
      <div class="A_wrap">
        <div class="raDio">
          <input type="radio" name="option" id="option2" @click="checkAnswer(2)">
        </div>
        <div class="opTion">
          <label :for="'option2'" :class="{ correct: showCorrectAnswer && correctAnswer === 2 }">{{ Option2 }}</label>
        </div>
      </div>
      <div class="A_wrap">
        <div class="raDio">
          <input type="radio" name="option" id="option3" @click="checkAnswer(3)">
        </div>
        <div class="opTion">
          <label :for="'option3'" :class="{ correct: showCorrectAnswer && correctAnswer === 3 }">{{ Option3 }}</label>
        </div>
      </div>
      <div class="A_wrap">
        <div class="raDio">
          <input type="radio" name="option" id="option4" @click="checkAnswer(4)">
        </div>
        <div class="opTion">
          <label :for="'option4'" :class="{ correct: showCorrectAnswer && correctAnswer === 4 }">{{ Option4 }}</label>
        </div>
      </div>
    </div>
    <div class="OX">
      <img src="@/assets/wronganswer.png" class="wrongimg" :style="{ display: displayWrongAnswer ? 'block' : 'none' }">
      <img src="@/assets/collectanswer.png" class="collectimg" :style="{ display: displayCorrectAnswer ? 'block' : 'none' }">
    </div>
    <div class="last_Q" v-if="Qnumber == 20">
      <p>마지막 문제입니다.</p>
    </div>
    <div class="btn_collection">
      <button v-if="!showCorrectAnswer" @click="verifyAnswer" class="check_btn">정답확인</button>
      <button v-if="showCorrectAnswer && Qnumber < 20" class="explain_btn">해설보기</button>
      <button v-if="showCorrectAnswer && Qnumber < 20" class="next_btn">다음</button>
      <button v-if="showCorrectAnswer && Qnumber == 20" class="explain_btn">해설보기</button>
      <button v-if="showCorrectAnswer && Qnumber == 20" class="submit_btn">제출</button>
    </div>
  </div>

  <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
  name: "PracticeMode",
  components: {
      TopBar, BottomBar
  },
  data() {
      return {
          DetailLicense: "정보처리기사",
          TestDate: "2020년 4월 24일",
          Subject: "1과목 : 소프트웨어 설계",
          Qnumber: "20",
          Question: "UML 다이어그램 중 순차 다이어그램에 대한 설명으로 틀린 것은?",
          Option1: "1. 객제 간의 동적 상호작용을 시간 개념을 중심으로 모델링 하는 것이다.",
          Option2: "2. 주로 시스템의 정적 측면을 모델링하기 위해 사용한다.",
          Option3: "3. 일반적으로 다이어그램의 수직 방향이 시간의 흐름을 나타낸다.",
          Option4: "4. 회귀 메시지(Self-Message), 제어블록(Statement block) 등으로 구성된다.",
          Description: "순차 다이어그램은 행위 다이어그램이므로 동적이고, 순차적인 표현을 위한 다이어그램이다.",
          correctAnswer: 2, // 정답 번호
          selectedOption: null,
          displayWrongAnswer: false,
          displayCorrectAnswer: false,
          showCorrectAnswer: false
      }
  },
  methods: {
      checkAnswer(option) {
        this.selectedOption = option;
        this.showCorrectAnswer = false;
      },

      verifyAnswer() {
            this.showCorrectAnswer = true;
            if (this.selectedOption === this.correctAnswer) {
                this.displayCorrectAnswer = true;
                this.displayWrongAnswer = false;
            } else {
                this.displayCorrectAnswer = false;
                this.displayWrongAnswer = true;
            }
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

.current_Q {
  margin: 0.7em;
  padding: 0.3em;
  border: solid 1px #000;
  border-radius: 5px;
  box-sizing: border-box;
}

.current_A {
  display: flex;
  flex-direction: column;
  z-index: 1;
}

.A_wrap {
  display: flex;
}

.raDio,
.opTion {
  margin: 0.5em;
}

.opTion > label {
  font-size: 1em;
}

.raDio {
  padding-top: 0.3em;
}

.correct {
  color: #2E8B57;
  font-weight: bold;
}

.wrongimg{
  width: 190px; height: 190px;
  position: relative;
  top: -350%;
  left: -200%;
  opacity: 0.5;
  z-index: 0;
}

.collectimg{
  position: relative;
  top: -400%;
  left: -300%;
  opacity: 0.5;
  z-index: 0;
}

.OX{
  width: 10%;
  height: 10%
}

@keyframes blink-effect {
  0%, 100% {
    opacity: 1;
  }
  50% {
    opacity: 0;
  }
}

.last_Q {
  color: red;
  font-weight: bold;
  animation: blink-effect 1s ease-in-out infinite;
}

/* .btn_collection{
  display: flex;
} */
.check_btn, .explain_btn, .next_btn, .submit_btn{
  border-radius: 5px;
  color: #fff;
  background-color: #5271ff;
  margin: .3em;
  width: 40%;
  height: 60%;
  font-size: 1em;
}
</style>
