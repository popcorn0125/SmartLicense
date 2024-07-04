<template>
    <div class="search_id_compo">
        <p>전화번호</p>
        <input type="text" class="phone_box">
        <button class="check_num_send">인증번호 전송</button>

        <p>인증번호</p>
        <input type="text" class="check_num">
        <button class="check_btn">확인</button>

        <button class="black_long_btn" @click="verifyId()">아이디 찾기</button>
        <div class="id_is" v-if="showId">
            <p>아이디는 <span>hong123 </span>입니다.</p>
        </div>
    </div>
</template>
<script>

export default {
    name: "SearchIdCompo",
    data(){
        return{
            showId:false,
        }
    },
    methods:{
        verifyId(){
            // 아이디 검증 로직 짜야됨
            this.showId=true;
        }
    }
}
</script>
<style scoped>
.search_id_compo {
    position: fixed;
    width: 100%;
    margin-left: 10%;
    margin-top: 25%;
}

.check_num_send,
.check_btn {
    background-color: #000;
    color: #fff;
    border-radius: 5px;
    font-size: 0.7em;
    width: 30%;
    height: 35px;
}

.phone_box{
    margin-bottom: 5%;
}

.phone_box,
.check_num {
    width: 50%;
    margin-right: 5%;

}

.black_long_btn {
    width: 85%;
    margin-top: 10%;
    margin-bottom: 5%;
}

.id_is{
    margin-left: 15%;
}

.id_is span{
    color: #000;
    font-weight: 900;
}
</style>