<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <p class="heading">비밀번호 재설정</p>
            <br>
            <div class="input-group">
                <input placeholder="새로운 비밀번호" v-model="newPw" id="newPw" type="password" @input="validatePassword"/>
                <p>8자리 이상 영문, 대소문자 구분, 특수기호 포함</p>
            </div>
            <div class="input-group">
                <input placeholder="비밀번호 확인" v-model="newPwCheck" id="newPwCheck" type="password" :class="passwordMatchClass" @input="validatePassword" />
            </div>
            <button type="button" @click="resetPassword">비밀번호 재설정</button>
            <div v-show="isShow">
                <p>이전과 동일한 비밀번호입니다. 새로운 비밀번호를 입력하세요.</p>
            </div>
        </form>
    </div>
</template>
<script>
import TopBar from '@/components/TopBar.vue';
import axios from 'axios';
export default {
    name: "ResettingPwPage",
    components: {
        TopBar,
    },
    data() {
        return {
            isShow : false,
            response: false,
            newPw: '',
            newPwCheck: '',
            passwordMatch: false,

            userID: this.$route.query.userID,

        }
    },
    methods: {
        resetPassword() {
            if(this.newPw !== this.newPwCheck){
                alert("비밀번호가 다릅니다")
                return;
            }

            const payload = {
                userID: this.userID,
                newPassword: this.newPw
            };

            axios.post('/api/resetPassword', payload)
                .then(response => {
                    alert(response.data);
                    this.$router.push({ name: 'LoginPage' });
                })
                .catch(error => {
                    console.error(error);
                    alert("비밀번호 재설정에 실패했습니다.");
                });
        },
        validatePassword() {
            this.passwordMatch = this.newPw === this.newPwCheck;
        },
    },

    computed:{
        passwordMatchClass() {
            return {
                'input-match': this.passwordMatch,
                'input-mismatch': !this.passwordMatch
            };
        }
    },
    mounted(){
        if(this.userID === undefined){
            this.$router.push({ name : 'LoginPage'});
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
.input-group > p {
    font-size: .7em;
    color:#353535;
    text-align: left;
    margin-top: .4em;
    margin-left: .5em;
}


.input-group input:focus {
    outline: none;
}

.input-group input.input-match {
    border-color: #28a745; /* 초록색 */
}

.input-group input.input-mismatch {
    border-color: #dc3545; /* 빨간색 */
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

.bottom-text > p > strong {
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