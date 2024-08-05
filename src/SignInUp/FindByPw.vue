<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <p class="heading">비밀번호 찾기</p>
            <br>
            <div class="input-group">
                <input placeholder="아이디" id="id" type="text" v-model="userID" />
            </div>
            <text id="userid" class="infoMessage">{{ idMsg }}</text>
            <div class="input-group btn_posi">
                <input  placeholder="전화번호" id="phonenumber" type="text" v-model="phonenumber"
                    maxlength="11" />
                <button @click="verifyUser()" type="button">인증번호 전송</button>
            </div>
            <text id="phone" class="infoMessage">{{ phoneMsg }}</text>
            <div class="input-group btn_posi">
                <input  placeholder="인증번호" name="number" id="number" type="text"
                    v-model="enteredCode" maxlength="6" />
                <button @click="verifyCode" type="button">확인</button>
            </div>
            <text id="checknumber" class="infoMessage">{{ pnCheckMsg }}</text>
            <button type="button" @click="findId">비밀번호 찾기</button>
        </form>
    </div>
</template>
<script>
import TopBar from '@/components/TopBar.vue';
import axios from 'axios';
export default {
    name: "FindByPwPage",
    components: {
        TopBar,
    },
    data() {
        return {
            userID: '',
            phonenumber: '',
            enteredCode: '',

            idMsg: '',
            phoneMsg: '',
            pnCheckMsg: '',

            serverVerificationCode: null, // 서버에서 받아온 인증번호 저장
            isCodeVerified: false, // 인증번호 확인 여부

        }
    },
    methods: {
        verifyUser() {
            const vm = this;
            const userInfo = {
                userID: this.userID,
                phonenumber: this.phonenumber
            }

            axios({
                method: 'post',
                header: { 'Content-Type': 'application/json; charset=UTF-8' },
                url: "/api/findByPW",
                data: userInfo,
            })
                .then(function (response) {
                    if(response.data.userExists){
                        vm.serverVerificationCode = response.data.verificationCode;
                        alert("인증 번호는 " + vm.serverVerificationCode + " 입니다.");
                    } else{
                        alert("사용자 정보를 확인할 수 없습니다.");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })
                ;
        },

        verifyCode() {
            if (this.enteredCode == this.serverVerificationCode) {
                this.isCodeVerified = true;
                this.pnCheckMsg = '인증 성공';
                document.getElementById('checknumber').style.color = '#70CA77';
            } else {
                this.isCodeVerified = false;
                this.pnCheckMsg = '인증번호를 다시 입력해주세요.';
                document.getElementById('checknumber').style.color = '#F00';
            }
        },

        findId(){
            if (this.isCodeVerified){
                this.$router.push({ name: 'ResettingPwPage', query: { userID: this.userID} })
            } else{
                alert("인증을 진행하세요")
            }
        }
    }
}
</script>
<style scoped>
.bottom-text>p:nth-child(odd) {
    margin-bottom: 0.5em;
}

.btn_posi {
    display: flex;
}

.btn_posi>input {
    width: 60%;
}

.btn_posi>button {
    width: 50%;
    padding: 0;
    font-size: .7em;
    margin-left: .5em;
}

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

.heading {
    color: #000000;
    font-weight: 500;
    font-size: 1.7em;
    margin-bottom: 5px;
}

.input-group {
    margin-bottom: 20px;
    display: flex;
}

.input-group input {
    background: none;
    border: 1px solid #d1d1d1;
    padding: 15px 23px;
    font-size: 16px;
    border-radius: 8px;
    color: #000000;
    width: 100%;
    /* box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
    rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
    rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px; */
    height: 2em;
}

.input-group input:focus {
    border-color: #0173ed;
    outline: none;
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

.bottom-text {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
    color: #000000;
    font-size: .7em;
    font-weight: 400;
}

.bottom-text a {
    color: #5271ff;
    text-decoration: none;
    transition: color 0.3s ease;

}

.bottom-text>p>strong {
    font-size: 1.5em;
}

.bottom-text p {
    margin-top: 0.5em;
}

.withoutlogin {
    background-color: #353535;
}

.idhref {
    margin-right: .5em;
}

.pwhref {
    margin-left: .5em;
}
</style>