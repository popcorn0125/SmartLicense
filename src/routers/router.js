// router/index.js
import { createWebHistory, createRouter } from "vue-router";
import testComponent from "@/components/testcomponents.vue";
import SplashScreen from "@/components/SplashScreen.vue";
import LoginPage from "@/SignInUp/LoginPage.vue";
import SearchID from "@/SignInUp/SearchID.vue";
import UserSign from "@/SignInUp/userSignPage.vue";
import CategoryChoice from "@/ContentPage/CategoryChoice.vue";
import RankingPage from "@/ContentPage/RankingPage.vue";
import MyPage from "@/ContentPage/MyPage.vue";
import PracticeMode from "@/ContentPage/PracticeMode.vue";
import TestMode from "@/ContentPage/TestMode.vue";
import ChangeInfo from "@/SignInUp/ChangeInfo.vue";
import PracticeResult from "@/ContentPage/PracticeResult.vue";
import TestResult from "@/ContentPage/TestResult.vue";
import testComponent2 from "@/components/testcomponents2.vue";
import testComponent3 from "@/components/testcompo3.vue";
import testComponent4 from "@/components/testcompo4.vue";
import testComponent5 from "@/components/testcompo5.vue";


const routes = [
    {
        path: "/test",
        name: "testComponent",
        component: testComponent,
        meta: { title: 'Smart License', showBackButton: false }
    },
    {
        path: "/test2",
        name: "testComponent2",
        component: testComponent2,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/test3",
        name: "testComponent3",
        component: testComponent3,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/test4",
        name: "testComponent4",
        component: testComponent4,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/test5",
        name: "testComponent5",
        component: testComponent5,
        meta: { title: 'Smart License', showBackButton: true }
    },
    {
        path: "/",
        name: "SplashScreen",
        component: SplashScreen,
        meta: { title: 'Splash Screen', showBackButton: false }
    },
    {
        path: "/SmartLicenseLogin",
        name: "LoginPage",
        component: LoginPage,
        meta: { title: 'Login Page', showBackButton: false }
    },
    {
        path: "/SearchID",
        name: "SearchID",
        component: SearchID,
        meta: { title: 'Search ID', showBackButton: false }
    },
    {
        path: "/UserSign",
        name: "UserSign",
        component: UserSign,
        meta: { title: 'User Sign', showBackButton: false }
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
