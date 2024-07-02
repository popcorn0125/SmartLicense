import { createWebHistory, createRouter } from "vue-router";
import testcomponent from "@/components/testcomponents.vue";
import SplashScreen from "@/components/SplashScreen.vue";
import LoginPage from "@/SignInUp/LoginPage.vue";
import SearchID from "@/SignInUp/SearchID.vue"

const routes = [
    {
        path: "/test",  // TestComponent.vue로 이동할 Path
        name: "testcomponent",  // router name
        component: testcomponent,  // Path로 이동될 Component
    },
    {
        path: "/",
        name: "SplashScreen",
        component: SplashScreen,
    },
    {
        path: "/SmartLicenseLogin",
        name: "LoginPage",
        component: LoginPage,
    },
    {
        path: "/SearchID",
        name: "SearchID",
        component: SearchID,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;