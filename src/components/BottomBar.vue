<template>
    <div class="bottom_bar">
        <svg @click="goToCategoryChoice()" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 512.001 512.001"
            style="enable-background:new 0 0 512.001 512.001;" xml:space="preserve" width="24" height="24"
            :fill="homesvg">
            <g>
                <path
                    d="M490.134,185.472L338.966,34.304c-45.855-45.737-120.076-45.737-165.931,0L21.867,185.472   C7.819,199.445-0.055,218.457,0,238.272v221.397C0.047,488.568,23.475,511.976,52.374,512h407.253   c28.899-0.023,52.326-23.432,52.373-52.331V238.272C512.056,218.457,504.182,199.445,490.134,185.472z M448,448H341.334v-67.883   c0-44.984-36.467-81.451-81.451-81.451c0,0,0,0,0,0h-7.765c-44.984,0-81.451,36.467-81.451,81.451l0,0V448H64V238.272   c0.007-2.829,1.125-5.541,3.115-7.552L218.283,79.552c20.825-20.831,54.594-20.835,75.425-0.01c0.003,0.003,0.007,0.007,0.01,0.01   L444.886,230.72c1.989,2.011,3.108,4.723,3.115,7.552V448z" />
            </g>
        </svg>
        <svg @click="goToMyHistoryPage()" xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1"
            viewBox="0 0 24 24" width="24" height="24" :fill="ranksvg">
            <path
                d="m21.95,5.551l-3.485-3.485C17.143.743,15.385.015,13.515.015h-4.515C6.727.015,4.737,1.55,4.163,3.747c-.14.534.18,1.081.714,1.221.538.137,1.082-.181,1.22-.715.345-1.317,1.539-2.238,2.903-2.238h4.515c.165,0,.323.032.485.047v4.953c0,1.654,1.346,3,3,3h4.951c.016.162.049.322.049.485v8.515c0,1.654-1.346,3-3,3h-10c-.69,0-1.338-.228-1.875-.657-.43-.343-1.059-.276-1.406.154-.345.432-.276,1.061.155,1.406.882.707,1.992,1.097,3.125,1.097h10c2.757,0,5-2.243,5-5v-8.515c0-1.869-.728-3.627-2.05-4.949Zm-4.95,2.464c-.551,0-1-.448-1-1V2.698c.376.217.735.466,1.05.781l3.485,3.485c.311.311.559.672.776,1.05h-4.312Zm-7,7.985h8c.552,0,1,.447,1,1s-.448,1-1,1h-8c-.552,0-1-.447-1-1s.448-1,1-1Zm-3,2.847v-4.75c.907-.734,1.5-1.842,1.5-3.097,0-2.206-1.794-4-4-4S.5,8.794.5,11c0,1.255.593,2.363,1.5,3.097v4.75c0,.623.791.89,1.169.395l1.331-1.743,1.331,1.743c.378.495,1.169.228,1.169-.395Zm-2.5-9.847c1.103,0,2,.897,2,2s-.897,2-2,2-2-.897-2-2,.897-2,2-2Zm6.5,5c-.552,0-1-.447-1-1s.448-1,1-1h7c.552,0,1,.447,1,1s-.448,1-1,1h-7Z" />
        </svg>
        <svg @click="goToMyPage" xmlns="http://www.w3.org/2000/svg" id="Outline" viewBox="0 0 24 24" width="24"
            height="24" :fill="mysvg">
            <path d="M12,12A6,6,0,1,0,6,6,6.006,6.006,0,0,0,12,12ZM12,2A4,4,0,1,1,8,6,4,4,0,0,1,12,2Z" />
            <path d="M12,14a9.01,9.01,0,0,0-9,9,1,1,0,0,0,2,0,7,7,0,0,1,14,0,1,1,0,0,0,2,0A9.01,9.01,0,0,0,12,14Z" />
        </svg>
    </div>
    <!---------알림 모달 창--------->
    <div class="modal" v-if="isShowModal">
        <div class="modal-content">
            <p>로그인 후 이용 가능한 기능입니다.</p>
            <p>로그인 페이지로 이동할까요?</p>
            <div class="del-btn-wrap">
                <button class="ok" @click="isShowModal = false">취소</button>
                <button class="cancel" @click="goToLogin()">확인</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isShowModal: false,
            homesvg: 'gray',
            ranksvg: 'gray',
            mysvg: 'gray',
        }
    },
    watch: {
        $route() {
            this.updateIconColor();
        }
    },
    mounted() {
        this.updateIconColor();
    },
    methods: {
        updateIconColor() {
            const currentRoute = this.$route.name;
            this.homesvg = currentRoute === 'CategoryChoice' ? 'black' : 'gray';
            this.ranksvg = currentRoute === 'MyHistoryPage' ? 'black' : 'gray';
            this.mysvg = currentRoute === 'MyPage' ? 'black' : 'gray';
        },
        goToCategoryChoice() {
            this.$router.push('/CategoryChoice'); // CategoryChoice 페이지로 이동
        },
        goToMyHistoryPage() {
            if (localStorage.getItem('GUEST') != null) {
                this.isShowModal = true;
            }
            if (sessionStorage.getItem('JSESSIONID') != null && sessionStorage.getItem('USER_ID') != null) {
                this.$router.push({ name: 'MyHistoryPage' }); // MyHistoryPage 페이지로 이동
            }
        },
        goToMyPage() {
            if (localStorage.getItem('GUEST') != null) {
                this.isShowModal = true;
            }
            if (sessionStorage.getItem('JSESSIONID') != null && sessionStorage.getItem('USER_ID') != null) {
                this.$router.push({ name: 'MyPage' }); // MyPage 페이지로 이동
            }
        },

        goToLogin() {
            this.$router.push({ name: 'LoginPage' });// LoginPage 페이지로 이동
        }
    },
}
</script>

<style scoped>
.bottom_bar {
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    height: 6%;
    background: #F9F9F9;
    box-shadow: 0px -1px 1px 0px rgba(0, 0, 0, 0.1);
    position: fixed;
    left: 0;
    bottom: 0;
}

/* 모달 스타일 */
.modal {
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 15px;
    border: 1px solid #888;
    border-radius: 5px;
    width: 80%;
    max-width: 500px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    display: flex;
    flex-direction: column;
    text-align: center;
    justify-content: center;
    height: 30%;
}

.modal-content>p {
    font-size: .7em;
    height: 25%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-content>p>strong {
    color: #F00;
}

.del-btn-wrap {
    height: 50%;
    width: 100%;
}

.del-btn-wrap>button {
    margin-top: 2em;
    width: 30%;
    height: 45%;
    padding: 5px;
    border: none;
    border-radius: 8px;
    color: #ffffff;
    font-size: 0.7em;
    box-shadow: rgba(0, 0, 0, 0.06) 0px 1px 1px,
        rgba(0, 0, 0, 0.09) 0px 1px 1px, rgba(0, 0, 0, 0.09) 0px 1px 2px,
        rgba(0, 0, 0, 0.09) 0px 1px 4px, rgba(0, 0, 0, 0.09) 0px 1px 8px;

}

.ok {
    text-align: center;
    background-color: #888;
    vertical-align: middle;
    margin-right: 1em;
}

.cancel {
    text-align: center;
    background-color: #000;
    vertical-align: middle;
    margin-left: 1em;
}
</style>
