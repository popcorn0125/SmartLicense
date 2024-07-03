<template>
    <div id="screen">
        <div class="header">
            <img :src="imagePath" alt="no_image" @click="goBack" />
        </div>
        <div class="body">
            <div class="container">
                <p>아이디</p>
                <div class="input-group">
                    <input type="text" class="id"  placeholder="아이디">
                    <button class="id-Btn">중복확인</button>
                </div>
            </div>
            <div class="container space">
                <p>비밀번호</p>
                <div class="input-group">
                    <input type="password" class="pw" placeholder="비밀번호">
                </div>
                <text>8자리 이상 영문, 대소문자 구분, 특수기호 포함</text>
            </div>
            <div class="container space">
                <div class="pwCheck">
                    <p>비밀번호 확인</p>
                    <img :src="pwCheckImage" alt="이" />
                    <text class="pwCheckMsg">비밀번호가 일치하지 않습니다.</text>
                </div>
                <div class="input-group">
                    <input type="password" class="pw" placeholder="비밀번호 재입력">
                </div>
            </div>
            <div class="container space">
                <p>이름</p>
                <div class="input-group">
                    <input type="text" class="pw" placeholder="이름(실명 입력)">
                </div>
            </div>
            <div class="container space">
                <p>닉네임</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="닉네임(10자리)">
                    <button class="id-Btn">중복확인</button>
                </div>
            </div>
            <div class="container space">
                <text class="gender-text">성별</text>
                <div class="input-group">
                    <button :class="{ 'selected': selectedGender === '남자', 'not-selected': selectedGender !== '남자' }"
                        class="gender-Btn" @click="selectGender('남자')">남자</button>
                    <button :class="{ 'selected': selectedGender === '여자', 'not-selected': selectedGender !== '여자' }"
                        class="gender-Btn woman" @click="selectGender('여자')">여자</button>
                </div>
            </div>
            <div class="container space">
                <p>전화번호</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="전화번호">
                    <button class="id-Btn">인증번호 전송</button>
                </div>
            </div>
            <div class="container space">
                <p>인증번호</p>
                <div class="input-group">
                    <input type="text" class="id" placeholder="인증번호">
                    <button class="id-Btn">인증번호 확인</button>
                </div>
            </div>
            <div class="container space">
                <button class="black_long_btn">회원가입</button>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: "UserSign",
    data() {
        return {
            imagePath: require('@/assets/gotoback.png'),
            pwCheckImage: require('@/assets/pwcheck.png'),
            selectedGender: "" // 성별 선택 여부
        }
    },

    methods: {
        goBack() {
            this.$router.go(-1); // 이전 페이지로 이동
        },

        selectGender(gender) {
            this.selectedGender = gender;
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
    height: 100vh;
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