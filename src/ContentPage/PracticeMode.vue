<template>
  <TopBar />
  <div class="practive_mode_container">
    <div class="popup-container">
      <div class="popup info-popup">
        <div class="info-message">{{ selectedOption2 }}</div>
      </div>
      <div class="popup info-popup">
        <div class="info-message">{{ selectedOption3 }}</div>
      </div>
      <div class="popup info-popup">
        <div class="info-message">{{ currentProblem.subject_name }}</div>
      </div>
    </div>
    <div class="current_Q">
      <p>{{ currentProblemIndex + 1 }}. {{ currentProblem.question }}</p>
      <img src="">
    </div>
    <span class="toggle-btn" @click="toggleBottomSheet"></span>
    <div class="radio-input" :class="{ 'is-visible': isBottomSheetVisible }">
  <div class="info">
    <span class="steps" @click="showExplanation">해설보기</span>
    <span class="close-explanation" @click="toggleBottomSheet">&times;</span>
  </div>
  <div class="scrollable">
    <input type="radio" id="value-1" name="value-radio" value="value-1" @change="checkAnswer('value-1')">
    <label :class="{ 'correct': selectedAnswer === 'value-1' && isCorrectAnswer, 'incorrect': selectedAnswer === 'value-1' && !isCorrectAnswer }" for="value-1">
      {{ currentProblem.option1 }}
    </label>

    <input type="radio" id="value-2" name="value-radio" value="value-2" @change="checkAnswer('value-2')">
    <label :class="{ 'correct': selectedAnswer === 'value-2' && isCorrectAnswer, 'incorrect': selectedAnswer === 'value-2' && !isCorrectAnswer }" for="value-2">
      {{ currentProblem.option2 }}
    </label>

    <input type="radio" id="value-3" name="value-radio" value="value-3" @change="checkAnswer('value-3')">
    <label :class="{ 'correct': selectedAnswer === 'value-3' && isCorrectAnswer, 'incorrect': selectedAnswer === 'value-3' && !isCorrectAnswer }" for="value-3">
      {{ currentProblem.option3 }}
    </label>

    <input type="radio" id="value-4" name="value-radio" value="value-4" @change="checkAnswer('value-4')">
    <label :class="{ 'correct': selectedAnswer === 'value-4' && isCorrectAnswer, 'incorrect': selectedAnswer === 'value-4' && !isCorrectAnswer }" for="value-4">
      {{ currentProblem.option4 }}
    </label>
  </div>
  <div class="btn_collection" v-if="currentProblemIndex + 1 < 20" @click="nextQuestion">
    다음 문제 >
  </div>
  <div class="btn_collection" @click="viewResult" v-if="currentProblemIndex + 1 == 20">
    {{ Subject }} 점수 보기
  </div>
</div>
    <div class="last_Q" v-if="currentProblemIndex + 1 == 20">
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
import axios from 'axios';

export default {
  name: "PracticeMode",
  components: {
    TopBar
  },
  data() {
    return {
      problems: [],
      currentProblemIndex: 0,
      currentSubjectIndex: 0,
      selectedOption1: '',
      selectedOption2: '',
      selectedOption3: '',
      mode: '',
      selectedSubjects: [],
      isBottomSheetVisible: true,
      isModalVisible: false,
      currentProblem: [],

      correctAnswer: '', // 정답을 저장
      selectedAnswer: '', // 사용자가 선택한 답변
      isCorrectAnswer: false, // 정답 여부
      isAnswerSelected: false, // 답변이 선택되었는지 여부
    };
  },
  methods: {
    loadProblems() {
      const criteria = {
        detail_license_name: this.selectedOption2,
        exam_date: this.selectedOption3,
        subject_name: this.selectedSubjects[this.currentSubjectIndex]
      };

      axios.post('/mode/practiceModeLoadExam', criteria)
        .then(response => {
          console.log(response.data);
          this.problems = response.data;
          console.log(this.problems[0].question);
          this.currentProblemIndex = 0;
          this.loadCurrentProblem();
        })
        .catch(error => {
          console.error(error);
        });
    },
    loadCurrentProblem() {
      if (this.problems.length > 0) {
        this.currentProblem = this.problems[this.currentProblemIndex];
        this.correctAnswer = this.currentProblem.answer; // 서버에서 가져온 정답
        this.selectedAnswer = ''; // 새 문제를 로드할 때 선택된 답변 초기화
        this.isAnswerSelected = false;
        this.isCorrectAnswer = false;
      }
    },
    nextQuestion() {
      if (this.currentProblemIndex < this.problems.length - 1) {
        this.currentProblemIndex++;
        this.loadCurrentProblem();
      } else {
        this.viewResult();
      }
    },
    viewResult() {
      if (this.currentSubjectIndex < this.selectedSubjects.length - 1) {
        this.currentSubjectIndex++;
        this.loadProblems();
      } else {
        this.$router.push({ name: 'PracticeResult' });
      }
    },
    checkAnswer(option) {
      this.selectedAnswer = option;
      this.isAnswerSelected = true;
      // 정답 비교 로직
      this.isCorrectAnswer = option === this.currentProblem.answer; // 정답과 비교
      this.showExplanation();
    },
    showExplanation() {
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
    toggleBottomSheet() {
      this.isBottomSheetVisible = !this.isBottomSheetVisible;
    }
  },
  mounted() {
    this.selectedOption1 = sessionStorage.getItem('license');
    this.selectedOption2 = sessionStorage.getItem('detail_license');
    this.selectedOption3 = sessionStorage.getItem('exam_date');
    this.mode = sessionStorage.getItem('mode');
    const selectedSubjects = sessionStorage.getItem('selectedSubjects');
    this.selectedSubjects = JSON.parse(selectedSubjects);
    this.currentSubjectIndex = 0;
    this.loadProblems();
  }
};
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
  position: relative;
}

.scrollable {
  overflow-y: auto;

}

.scrollable::-webkit-scrollbar {
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
  position: absolute;
  right: 1em;
  top: -1.9em;
  color: red;
  font-weight: bold;
  animation: blink-effect 1s ease-in-out infinite;
  z-index: 10;
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
  /* height: 53%; */
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

/* 정답 및 오답 스타일 */
.correct {
  border-color: rgb(22, 245, 22);
  color: rgb(16, 184, 16);
}

.incorrect {
  border-color: red;
  color: red;
}

.radio-input input:checked + label.correct {
  border-color: rgb(22, 245, 22);
  color: rgb(16, 184, 16);
}

.radio-input input:checked + label.incorrect {
  border-color: red;
  color: red;
}

/* 라디오 버튼 스타일 */
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
</style>