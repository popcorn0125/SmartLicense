<template>
    <TopBar />
    <div class="content_container">
        <div class="selectbox_wrap">
            <p>자격을 선택하세요.</p>
            <div class="select">
                <div class="selected" @click="toggleDropdown('first')">
                    {{ selectedOption1 }}
                    <svg xmlns="http://www.w3.org/2000/svg" class="arrow">
                        <path d="M7 5l5 5 5-5H7z" />
                    </svg>
                </div>
                <ul class="options" v-if="dropdownOpen === 'first'">
                    <li v-for="option in options1" :key="option" @click="selectOption(option, 'first')">{{ option }}
                    </li>
                </ul>
            </div>
            <p>세부 자격을 선택하세요.</p>
            <div class="select">
                <div class="selected" @click="toggleDropdown('second')">
                    {{ selectedOption2 }}
                    <svg xmlns="http://www.w3.org/2000/svg" class="arrow">
                        <path d="M7 5l5 5 5-5H7z" />
                    </svg>
                </div>
                <ul class="options" v-if="dropdownOpen === 'second'">
                    <li v-for="option in options2" :key="option" @click="selectOption(option, 'second')">{{ option }}
                    </li>
                </ul>
            </div>
            <p>시험 일정을 선택하세요.</p>
            <div class="select">
                <div class="selected" @click="toggleDropdown('third')" >
                    {{ selectedOption3 }}
                    <svg xmlns="http://www.w3.org/2000/svg" class="arrow">
                        <path d="M7 5l5 5 5-5H7z" />
                    </svg>
                </div>
                <ul class="options" v-if="dropdownOpen === 'third'">
                    <li v-for="option in options3" :key="option" @click="selectOption(option, 'third')">{{ option }}
                    </li>
                </ul>
            </div>
        </div>
        <div class="mydict" v-show="isShow">
            <div>
                <label>
                    <input type="radio" name="radio">
                    <span>연습 모드</span>
                </label>

                <label>
                    <input type="radio" name="radio">
                    <span>시험 모드</span>
                </label>

            </div>
        </div>
        <div class="subject_wrap" v-show="isShow">
            <div>
                <input type="checkbox" class="sub1"><span>1과목</span>:<span>소프트웨어 설계</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub2"><span>2과목</span>:<span>소프트웨어 개발</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub3"><span>3과목</span>:<span>데이터베이스 구축</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub4"><span>4과목</span>:<span>프로그래밍 언어 활용</span>(<span>20</span>문항)
            </div>
            <div>
                <input type="checkbox" class="sub5"><span>5과목</span>:<span>정보시스템 구축관리</span>(<span>20</span>문항)
            </div>
        </div>
        <button class="go_solve" v-show="isShow">문제 풀기</button>
    </div>
    <BottomBar />
</template>



<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'

export default {
    name: "CategoryChoice",
    components: {
        TopBar, BottomBar
    },
    data() {
        return {
            mode: null,
            dropdownOpen: null,
            selectedOption1: '선택',
            selectedOption2: '선택',
            selectedOption3: '선택',
            options1: ['기사', '기능사', '산업기사'],
            options2: ['정보처리기사', '정보보안기사', '가스기사'],
            options3: ['2022년4월24일', '2022년3월05일', '2021년8월14일', '2021년5월15일', '2021년3월07일'],
            isShow: false,
        };
    },
    methods: {
        toggleMode(selectMode) {
            if (this.mode === selectMode) {
                this.mode = null;
            } else {
                this.mode = selectMode;
            }
        },
        toggleDropdown(dropdown) {
            this.dropdownOpen = this.dropdownOpen === dropdown ? null : dropdown;
        },
        selectOption(option, dropdown) {
            if (dropdown === 'first') {
                this.selectedOption1 = option;
            } else if (dropdown === 'second') {
                this.selectedOption2 = option;
            } else if (dropdown === 'third') {
                this.selectedOption3 = option;
            }
            this.dropdownOpen = null;
        },

    },
    watch: {
        selectedOption3(){
            this.isShow=true;
        }
    }
};
</script>



<style scoped>
.subject_wrap{
    height: 35%;
}
.content_container {
    top: 6%;
    position: fixed;
    overflow-y: auto;
    height: 88%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
}

.selectbox_wrap {
    width: 100%;
    height: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.selectbox_wrap>p {
    font-weight: bold;
}

.select {
    width: 55%;
    margin: 0.5em 0 1em 0;
    position: relative;
    font-size: 1em;
}

.selected {
    padding: 0.5em;
    background-color: #f9f9f9;
    border: 1px solid #d1d1d1;
    color: #000;
    border-radius: 5px;
    cursor: pointer;
    display: flex;
    justify-content: space-between;
    align-items: center;
    text-align: center;

}

.selected .arrow {
    width: 1em;
    height: 1em;
    fill: rgb(0, 0, 0);
}

.options {
    position: absolute;
    top: 100%;
    left: 0;
    right: 0;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-top: 5px;
    max-height: 150px;
    overflow-y: auto;
    z-index: 1000;
}

.options li {
    padding: 0.5em;
    cursor: pointer;
    text-align: center;
    list-style: none;
}

.options li:hover {
    background-color: #f0f0f0;
}

.mode_wrap {
    width: 100%;
    height: 15%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.practice_mode,
.test_mode {
    border-radius: 20px;
    background: #DBDBDB;
    color: #000;
    font-size: 1em;
    width: 25%;
    height: 35%;
    margin: 0em 1em;
}

.practice_mode.active,
.test_mode.active {
    background: #5271FF;
    color: #FFF;
}

.subject_btn_wrap {
    width: 100%;
    height: 40%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
}

.sub1,
.sub2,
.sub3,
.sub4,
.sub5 {
    width: 1.5em;
    height: 1.5em;
    margin-bottom: 1em;
    margin-right: 0.5em;
}

.go_solve {
    background-color: #5271FF;
    color: #fff;
    border-radius: 5px;
    width: 40%;
    height: 7%;
    border: none;
    margin-bottom: 4em;
}

:focus {
    outline: 0;
    border-color: #2260ff;
    box-shadow: 0 0 0 4px #b5c9fc;
}
.mydict{
    height: 10%;
}
.mydict div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    
}

.mydict input[type="radio"] {
    clip: rect(0 0 0 0);
    clip-path: inset(100%);
    height: 1px;
    overflow: hidden;
    position: absolute;
    white-space: nowrap;
    /* width: 1px; */
}

.mydict input[type="radio"]:checked+span {
    box-shadow: 0 0 0 0.0625em #0043ed;
    background-color: #dee7ff;
    z-index: 1;
    color: #0043ed;
}

label span {
    display: block;
    cursor: pointer;
    background-color: #fff;
    padding: 0.375em .75em;
    position: relative;
    margin-left: .0625em;
    box-shadow: 0 0 0 0.0625em #b5bfd9;
    letter-spacing: .05em;
    color: #3e4963;
    text-align: center;
    transition: background-color .5s ease;
}

label:first-child span {
    border-radius: .375em 0 0 .375em;
}

label:last-child span {
    border-radius: 0 .375em .375em 0;
}
</style>
