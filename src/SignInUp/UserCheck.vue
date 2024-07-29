<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <br>
            <div class="input-group">
                <input placeholder="현재 비밀번호를 입력하세요." type="password" v-model="member.userPw" />
                <text id="passwordCheck" class="infoMessage">{{ pwCheckMsg }}</text>
            </div>
            
            <button type="button" @click="goToChangeInfo">확인</button>
        </form>
    </div>
    <BottomBar />
</template>
<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue';
import axios from 'axios';

export default {
    name: "FindByPwPage",
    components: {
        TopBar, BottomBar
    },
    data() {
        return {
            member : {
                userId : this.$cookies.get('USER_ID'),
                userPw : '',
            },
            pwCheckMsg : '',
            
        }
    },
    methods: {
        goToChangeInfo(){
            const vm = this;
            axios({
                method : 'post',
                header: { 'Content-Type': 'application/json; charset=UTF-8' },
                url: "/memberLogin/userPWCheck",
                data : vm.member,
            })
                .then(response => {
                    if(response.data.result > 0) {
                        this.$router.push({ name : 'ChangeInfo'})
                    } else {
                        vm.pwCheckMsg = response.data.message;
                    }
                })
                .catch(error => {
                    console.log(error);
                })
            
        }
    }
}
</script>
<style scoped>
.login-container {
    position: relative;
    top: 6%;
    padding: 1em 2.5em 0em 2.5em;
    max-width: 800px;
    width: 100%;
    text-align: center;
    margin: 0 auto;
    height: 88%;
}
.login-form {
    display: flex;
    flex-direction: column;
}
.input-group {
    margin-bottom: 20px;

}
.input-group input {
    background: none;
    border: 1px solid #d1d1d1;
    padding: 15px 23px;
    font-size: 16px;
    border-radius: 8px;
    color: #000000;
    width: 100%;
    height: 2em;
}
button {
    padding: 15px;
    border: none;
    border-radius: 8px;
    background-color: #5271ff;
    color: #ffffff;
    font-size: 0.7em;
    font-weight: 500;
    cursor: pointer;
    transition: background-color 0.3s ease;
    box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
        rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
        rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px;
}

.infoMessage {
  display: block;
  color: #F00;
  -webkit-text-stroke-width: 1;
  -webkit-text-stroke-color: #000;
  font-family: Inter;
  font-size: 0.7em;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  text-align: left;
}
</style>