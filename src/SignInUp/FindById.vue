<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <p class="heading">아이디 찾기</p>
            <br>
            <div class="input-group">
                <input @input="nameChange()" placeholder="이름" id="name" type="text" v-model="userName" maxlength="20" />
            </div>
            <text id="name2" class="infoMessage">{{ nameMsg }}</text>
            <div class="input-group btn_posi">
                <input @input="phoneNumChange()" placeholder="전화번호" id="phonenumber" type="text" v-model="phonenumber"
                    maxlength="11" />
                <button type="button" @click="verifyUser">인증번호 전송</button>
            </div>
            <text id="phone" class="infoMessage">{{ phoneMsg }}</text>
            <div class="input-group btn_posi">
                <input @input="checknumberChange()" placeholder="인증번호" id="number" type="text" v-model="enteredCode"
                    maxlength="6" />
                <button type="button" @click="verifyCode">확인</button>
            </div>
            <text id="checknumber" class="infoMessage">{{ pnCheckMsg }}</text>
            <button type="button" class="checkBTN" @click="findId">아이디 찾기</button>
            <div class="bottom-text" v-show="isShow">
                <div v-show="success_message">
                    <p><span>아이디는 </span><strong>{{ userID }}</strong><span> 입니다.</span></p>
                    <p><a href="/login" class="idhref">로그인</a><a href="/findbypw" class="pwhref">비밀번호 찾기</a></p>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import axios from 'axios';

export default {
    name: "FindByIdPage",
    components: {
        TopBar,
    },
    data() {
        return {
            userName: '',
            phonenumber: '',
            enteredCode: '',

            isShow: false,
            success_message: false,
            serverVerificationCode: null,  // 서버에서 받아온 인증번호 저장
            isCodeVerified: false,  // 인증번호 확인 여부
            userID: '',

            nameMsg: '', // 이름 메세지
            phoneMsg: '', // 전화번호 메세지
            pnCheckMsg: '', // 인증번호 확인 메세지
        }
    },
    methods: {
        // 이름 입력 감지
        nameChange() {
            const textTag = document.getElementById('name2');
            if (this.validateName(this.userName) === false) {
                textTag.style.color = "#F00";
                this.nameMsg = '실명을 입력하세요.';
            } else {
                this.nameMsg = '';
            }
        },
        // 이름 유효성 검사( 한글만 입력 가능)
        validateName(name) {
            return /^[가-힣]{2,20}$/.test(name);
        },

        // 전화번호 입력 감지
        phoneNumChange() {
            if (this.validatePhoneNumber(this.phonenumber) === false) {
                document.getElementById('phone').style.color = '#F00';
                this.phoneMsg = '입력예시 : 01012345678';
            } else {
                this.phoneMsg = '';
            }
        },
        // 전화번호 유효성 검사( 숫자 11자리)
        validatePhoneNumber(phoneNumber) {
            return /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/.test(phoneNumber);
        },

        //인증번호 입력 감지
        checknumberChange() {
            const textTag = document.getElementById('checknumber');
            if (this.validateEnteredCode(this.enteredCode) === false) {
                textTag.style.color = '#F00';
                this.pnCheckMsg = '인증번호를 다시 입력해주세요.';
            } else {
                this.pnCheckMsg = '';
            }
        },
        // 인증번호 유효성 검사( 숫자 6자리)
        validateEnteredCode(enteredCode) {
            return /^[0-9]{6}$/.test(enteredCode);
        },

        async verifyUser() {
            const userInfo = {
                userName: this.userName,
                phonenumber: this.phonenumber
            };

            try {
                const response = await axios.post('/api/findByID', userInfo);
                console.log("asdfasdf:", response.data)
                this.serverVerificationCode = response.data.verificationCode;
                this.userID = response.data.userID;
                alert("인증 번호는 " + this.serverVerificationCode + " 입니다.");
            } catch (error) {
                console.error(error);
                alert("사용자 정보를 확인할 수 없습니다.");
            }
        },

        verifyCode() {
            const textTag = document.getElementById('checknumber');
            if (this.enteredCode == this.serverVerificationCode) {
                this.isCodeVerified = true;
                textTag.style.color = '#70CA77';
                this.pnCheckMsg = '인증 성공';
            } else {
                this.isCodeVerified = false;
                this.pnCheckMsg = '인증번호를 다시 입력해주세요.';
            }
        },

        async findId() {
            if (!this.isCodeVerified) {
                alert("먼저 인증번호를 확인해 주세요.");
                return;
            }
            this.isShow = true;
            this.success_message = true;
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
    margin-top: 20px;
    display: flex;
}

.input-group input {
    background: none;
    border: 1px solid #d1d1d1;
    padding: 15px 15px;
    font-size: 16px;
    border-radius: 8px;
    color: #000000;
    width: 100%;
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

.infoMessage {
    font-size: 0.7em;
    font-weight: 400;
    text-align: left;
}

.checkBTN {
    margin-top: 20px;
}
</style>