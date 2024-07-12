<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <p class="heading">아이디 찾기</p>
            <br>
            <div class="input-group">
                <input placeholder="이름" id="name=" type="text" />
            </div>
            <div class="input-group btn_posi">
                <input placeholder="전화번호" id="phonenumber" type="text" />
                <button type="button">인증번호 전송</button>
            </div>
            <div class="input-group btn_posi">
                <input placeholder="인증번호" name="password" id="password" type="password" />
                <button type="button">확인</button>
            </div>
            <button type="button" @click="findId">아이디 찾기</button>
            <div class="bottom-text" v-show="isShow">
                <div v-show="success_message">
                    <p><span>아이디는 </span><strong>{{ userId }}</strong><span> 입니다.</span></p>
                    <p><a href="/test" class="idhref">로그인</a><a href="/test4" class="pwhref">비밀번호 찾기</a></p>
                </div>
                <div v-show="fail_message">
                    <p><span>아이디가 존재하지 않습니다.</span></p>
                    <p><a href="#" class="idhref">회원가입</a></p>
                </div>
            </div>
        </form>
    </div>
</template>
<script>
import TopBar from '@/components/TopBar.vue';

export default {
    name: "testComponent3",
    components: {
        TopBar,
    },
    data() {
        return {
            userId : 'asd',
            isShow : false,
            success_message : false,
            fail_message : false,
        }
    },
    methods: {
        findId(){
            this.isShow = true;
            if(this.userId == '') {
                this.fail_message = true;
                this.success_message = false;
            } else {
                this.fail_message = false;
                this.success_message = true;
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