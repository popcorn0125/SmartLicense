// router/index.js
import { createWebHistory, createRouter } from "vue-router";

import SplashScreen from "@/components/SplashScreen.vue";

import LoginPage from "@/SignInUp/Login.vue";
import SignUpPage from "@/SignInUp/SignUp.vue";
import FindByIdPage from "@/SignInUp/FindById.vue";
import FindByPwPage from "@/SignInUp/FindByPw.vue";
import ResettingPwPage from "@/SignInUp/ResettingPw.vue";

import CategoryChoice from "@/ContentPage/CategoryChoice.vue";
import RankingPage from "@/ContentPage/RankingPage.vue";
import MyPage from "@/ContentPage/MyPage.vue";
import PracticeMode from "@/ContentPage/PracticeMode.vue";
import TestMode from "@/ContentPage/TestMode.vue";
import ChangeInfo from "@/SignInUp/ChangeInfo.vue";
import PracticeResult from "@/ContentPage/PracticeResult.vue";
import TestResult from "@/ContentPage/TestResult.vue";



const routes = [
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,
        meta: { title: 'Smart License', showBackButton: false }
    },
    {
        path: "/signup",
        name: "SignUpPage",
        component: SignUpPage,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/findbyid",
        name: "FindByIdPage",
        component: FindByIdPage,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/findbypw",
        name: "FindByPwPage",
        component: FindByPwPage,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/resettingpw",
        name: "ResettingPwPage",
        component: ResettingPwPage,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/",
        name: "SplashScreen",
        component: SplashScreen,
        meta: { title: 'Splash Screen', showBackButton: false }
    },
    {
        path: "/CategoryChoice",
        name: "CategoryChoice",
        component: CategoryChoice,
        meta: { title: 'Smart License', showBackButton: false }
    },
    {
        path: "/RankingPage",
        name: "RankingPage",
        component: RankingPage,
        meta: { title: '랭킹', showBackButton: false }
    },
    {
        path: "/MyPage",
        name: "MyPage",
        component: MyPage,
        meta: { title: '내 정보', showBackButton: false }
    },
    {
        path: "/PracticeMode",
        name: "PracticeMode",
        component: PracticeMode,
        meta: { title: '연습모드', showBackButton: false }
    },
    {
        path: "/TestMode",
        name: "TestMode",
        component: TestMode,
        meta: { title: '시험모드', showBackButton: false }
    },
    {
        path: "/ChangeInfo",
        name: "ChangeInfo",
        component: ChangeInfo,
        meta: { title: '내 정보 수정', showBackButton: false }
    },
    {
        path: "/PracticeResult",
        name: "PracticeResult",
        component: PracticeResult,
        meta: { title: '결과', showBackButton: false }
    },
    {
        path: "/TestResult",
        name: "TestResult",
        component: TestResult,
        meta: { title: '결과', showBackButton: false }
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
