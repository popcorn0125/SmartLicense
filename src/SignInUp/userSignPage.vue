<template>
    <div id="screen">
        <div class="header">
            <img :src="imagePath" alt="no_image" @click="goBack" />
        </div>
        <div class="body">
            <div class="container">
                <p>아이디</p>
                <div class="input-group">
                    <input type="text" class="id"  placeholder="아이디" v-model="form.id" @blur="checkIdUnique">
                    <button class="id-Btn" @click="checkIdUnique">중복확인</button>
                </div>
                <span v-if="errors.id">{{ errors.id }}</span>
            </div>
            <div class="container space">
                <p>비밀번호</p>
                <div class="input-group">
                    <input type="password" class="pw" placeholder="비밀번호" v-model="form.password">
                </div>
                <text>8자리 이상 영문, 대소문자 구분, 특수기호 포함</text>
                <span v-if="errors.password">{{ errors.password }}</span>
            </div>
            <div class="container space">
                <div class="pwCheck">
                    <p>비밀번호 확인</p>
                    <img :src="pwCheckImage" alt="이" />
                    <text class="pwCheckMsg" v-if="form.password !== form.passwordConfirm">비밀번호가 일치하지 않습니다.</text>
                </div>
                <div class="input-group">
                    <input type="password" class="pw" placeholder="비밀번호 재입력" v-model="form.passwordConfirm">
                </div>
            </div>
            <div class="container space">
                <p>이름</p>
                <div class="input-group">
                    <input type="text" class="pw" placeholder="이름(실명 입력)" v-model="form.name">
                </div>
                <span v-if="errors.name">{{ errors.name }}</span>
            </div>
            <div class="container space">
                <p>닉네임</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="닉네임(10자리)" v-model="form.nickname">
                    <button class="id-Btn" @click="checkNicknameUnique">중복확인</button>
                </div>
                <span v-if="errors.nickname">{{ errors.nickname }}</span>
            </div>
            <div class="container space">
                <text class="gender-text">성별</text>
                <div class="input-group">
                    <button :class="{ 'selected': form.gender === '1', 'not-selected': form.gender !== '1' }"
                        class="gender-Btn" @click="selectGender('1')">남자</button>
                    <button :class="{ 'selected': form.gender === '0', 'not-selected': form.gender !== '0' }"
                        class="gender-Btn woman" @click="selectGender('0')">여자</button>
                </div>
                <span v-if="errors.gender">{{ errors.gender }}</span>
            </div>
            <div class="container space">
                <p>전화번호</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="전화번호" v-model="form.phone">
                    <button class="id-Btn" @click="sendVerificationCode">인증번호 전송</button>
                </div>
                <span v-if="errors.phone">{{ errors.phone }}</span>
            </div>
            <div class="container space">
                <p>인증번호</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="인증번호" v-model="form.verificationCode">
                    <button class="id-Btn" @click="verifyCode">인증번호 확인</button>
                </div>
                <span v-if="errors.verificationCode">{{ errors.verificationCode }}</span>
            </div>
            <div class="container space">
                <button class="black_long_btn" @click="register">회원가입</button>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    name: "UserSign",
    data() {
        return {
            imagePath: require('@/assets/gotoback.png'),
            pwCheckImage: require('@/assets/pwcheck.png'),
            form:{
                id: '',
                password: '',
                passwordConfirm: '',
                name: '',
                nickname: '',
                gender: '',
                phone: '',
                verificationCode: '',
            },
            errors: {}
        }
    },

    methods: {
        goBack() {
            this.$router.go(-1); // 이전 페이지로 이동
        },

        selectGender(gender) {
            this.form.gender = gender;
        },

        async checkIdUnique(){
            //아이디 중복 확인 기능
            try{
                const response = await axios.post('/api/check-id', {id: this.form.id});
                if (!response.data.unique){
                    this.errors.id= '아이디가 중복됩니다.';
                } else{
                    this.errors.id='';
                }
            } catch (error){
                console.error(error);
            }
        },

        async checkNicknameUnique(){
            //닉네임 중복 확인 기능
            try{
                const response =await axios.post('/api/check-nickname', {nickname: this.form.nickname});
                if(!response.data.unique){
                    this.errors.nickname='닉네임이 중복됩니다.';
                } else {
                    this.errors.nickname='';
                }
            } catch (error){
                console.error(error);
            }
        },

        async sendVerificationCode(){
            //인증번호 전송 기능
            try{
                const response = await axios.post('/api/send-code', {phone:this.form.phone});
                if (response.data.success){
                    //인증번호 전송 성공
                } else{
                    this.errors.phone = '인증번호 전송 실패';
                }
            } catch (error){
                console.error(error);
            }
        },

        async verifyCode(){
            //인증번호 확인 기능
            try{
                const response = await axios.post('/api/verify-code', {phone:this.form.phone, code:this.form.verificationCode});
                if (response.data.verified){
                    this.errors.verificationCode='';
                } else{
                    this.errors.verificationCode='인증번호가 틀렸습니다';
                }
            } catch (error){
                console.error(error);
            }
        },

        async register(){
            //회원가입 기능
            this.errors={}; //이전 에러기록 클리어
            if(!this.form.id) this.errors.id ='아이디를 입력하세요.';
            if(!this.form.password) this.errors.password ='비밀번호를 입력하세요.';
            if(this.form.password !== this.form.passwordConfirm) this.errors.passwordConfirm ='비밀번호가 일치하지 않습니다.';
            if(!this.form.name) this.errors.name ='이름를 입력하세요.';
            if(!this.form.nickname) this.errors.nickname ='닉네임를 입력하세요.';
            if(!this.form.gender) this.errors.gender ='성별을 선택하세요.';
            if(!this.form.phone) this.errors.phone ='전화번호를 입력하세요.';
            if(!this.form.verificationCode) this.errors.verificationCode ='인증번호를 입력하세요.';

            if (Object.keys(this.errors).length === 0){
                try{
                    const response = await axios.post('/api/register', this.form);
                    if (response.data.success){
                        //회원가입 성공
                        this.$router.push('/SmartLicenseLogin');
                    } else{
                        //회원가입 실패 처리
                        this.errors = response.data.errors;
                    }
                } catch (error){
                    console.error(error);
                }
            }
        }
    },

    created() {

    },
    mounted() {

    },
}
</script>
<style scoped>
@import "@/css/common.css";

#screen {
    width: 100%;
    height: 130vh;
    /* 화면 전체 높이 */
    background-color: #5271FF;
    /* text-align: center; */
    /* align-items: center; 수직 중앙 정렬 */
    /* justify-content: center; 수평 중앙 정렬 */
}

p {
    color: #FFF;
    font-family: Inter;
    font-size: 1em;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
}

.header {
    display: block;
    width: auto;
    height: 5%;
    justify-content: left;
    align-items: center;
    /* border: 1px solid black; */
    margin: 14px 0 0 11px;
}

.body {
    width: 100%;
    height: calc(100% - 14px - 5%);
    /* border: 1px solid black; */
}

.container {
    display: block;
    width: 80%;
    height: auto;
    margin: 0 auto;
}

.input-group {
    display: flex;
    width: 100%;
    height: 29px;
    margin-top: 5px;
}

.id {
    display: flex;
    width: 100%;
    height: 29px;
    padding: 0 10px;
    border: 1px solid black;
    border-radius: 5px;
    background-color: #fff;
    font-size: 1em;
    color: #333;

}

.id-Btn {
    width: auto;
    height: 29px;
    flex-shrink: 0;
    border-radius: 5px;
    background: #000;
    color: #fff;
    display: flex;
    padding: 0 10px;
    align-items: center;
    font-family: Inter;
    font-size: 1em;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    margin-left: 10px;
}

.space {
    margin-top: 15px;

}

.pw {
    display: flex;
    width: 100%;
    height: 29px;
    padding: 0 10px;
    border: 1px solid black;
    border-radius: 5px;
    background-color: #fff;
    font-size: 1em;
    color: #333;
}

text {
    color: #FFF;
    font-family: Inter;
    font-size: 0.7em;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
}

.pwCheckMsg {
    color: #F00;
    -webkit-text-stroke-width: 1;
    -webkit-text-stroke-color: #000;
    font-family: Inter;
    font-size: 0.7em;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
}

/***** 성별 선택 ****/
.gender-text {
    color: #FFF;
    font-family: Inter;
    font-size: 1em;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
}

.gender-Btn {
    flex-shrink: 0;
    width: 40%;
    height: 34px;
    border-radius: 5px;
    background: #000;
    color: #fff;
    display: flex;
    padding: 0 10px;
    align-items: center;
    font-family: Inter;
    font-size: 0.9em;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    align-items: center;
    justify-content: center;
    /* 가로 방향 가운데 정렬 */
}

.woman {
    margin-left: auto;
}

.selected {
    background-color: grey;
    /* 선택된 버튼의 배경색 */
    color: white;
    /* 선택된 버튼의 글자색 */
}

.not-selected {
    background-color: black;
    /* 선택되지 않은 버튼의 배경색 */
    color: white;
    /* 선택되지 않은 버튼의 글자색 */
}


.black_long_btn {
    width: 100%;
    margin-top: 5%;
}
</style>