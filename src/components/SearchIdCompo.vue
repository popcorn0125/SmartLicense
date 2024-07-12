<template>
    <TopBar />
    <div class="login-container">
        <form class="login-form">
            <p class="heading">로그인</p>
            <br>
            <div class="input-group">
                <input required="" placeholder="아이디" id="username name=" type="text" />
            </div>
            <div class="input-group">
                <input required="" placeholder="비밀번호" name="password" id="password" type="password" />
            </div>
            <button type="submit">로그인</button>
            <div class="bottom-text">
                <p>계정이 없으신가요? <a href="#">회원가입</a></p>
                <p><a href="#" class="idhref">아이디 찾기</a><a href="#" class="pwhref">비밀번호 찾기</a></p>
            </div>
            <br />
            <hr>
            <br>
            <button class="withoutlogin" type="button" @click="goToCC">로그인 없이 시작</button>
        </form>
    </div>
</template>
<script>
import TopBar from '@/components/TopBar.vue';

export default {
    name: "SearchIdCompo",
    components: {
        TopBar,
    },
    data() {
        return {

        }
    },
    methods: {

    }
}
</script>
<style scoped></style>