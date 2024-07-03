<template>
  <div id="splash_screen">
    <div class="header">
      <img :src="imagePath" alt="Back" @click="goBack">
    </div>
    <div class="options">
      <p @click="moveTo('id')">아이디 찾기</p>
      <p @click="moveTo('password')">비밀번호 찾기</p>
    </div>
    <div class="line-container">
      <div class="backline"></div>
      <div :class="['slideline', { 'move-password': isPasswordSelected }]"></div>
    </div>
    <SearchIdCompo v-if="currentView === 'id'"/>
    <SearchPwCompo v-if="currentView === 'password'" @passwordFound="showNewPwCompo"/>
    <NewPwCompo v-if="currentView === 'new-password'"/>
  </div>
</template>

<script>
import SearchIdCompo from '@/components/SearchIdCompo.vue';
import SearchPwCompo from '@/components/SearchPwCompo.vue';
import NewPwCompo from '@/components/NewPwCompo.vue';

export default {
  name: "SearchID",
  components: {
    SearchIdCompo, SearchPwCompo, NewPwCompo,
  },
  data() {
    return {
      imagePath: require('@/assets/gotoback.png'),
      isPasswordSelected: false,
      currentView: 'id', // 초기 뷰는 'id'
    };
  },
  methods: {
    goBack(){
      this.$router.go(-1); // 이전 페이지로 이동
    },

    moveTo(selection) {
      this.currentView = selection;
      this.isPasswordSelected = selection === 'password';
    },

    showNewPwCompo(){
      this.currentView = 'new-password';
    }
  },
  created(){
  },
  mounted() {
    if(this.$route.query.currentView === 'id'){
      this.currentView = 'id';
    } else {
      this.currentView = 'password';
      this.isPasswordSelected = true;
    }
  }
};
</script>

<style scoped>
@import "@/css/common.css";

#splash_screen {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-color: #5271FF;
  color: #fff;
}

.header {
  display: block;
  justify-content: left;
  align-items: center;
  width: 100%;
  margin: 14px 0 0 11px;
}

.options {
  display: flex;
  justify-content: center;
  width: 100%;
  margin-bottom: 1em;
}

.options p {
  margin: 0 2em;
  cursor: pointer;
}

.line-container {
  position: relative;
  width: 100%;
  height: 5px;
}

.backline {
  position: absolute;
  width: 100%;
  background-color: #fff;
  height: 5px;
  top: 0;
  left: 0;
}

.slideline {
  position: absolute;
  width: 50%;
  background-color: #002EFF;
  height: 5px;
  top: 0;
  left: 0;
  z-index: 1;
  transition: all 0.5s ease;
}

.move-password {
  transform: translateX(100%);
}
</style>