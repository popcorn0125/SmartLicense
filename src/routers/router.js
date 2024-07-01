import { createWebHistory, createRouter } from "vue-router";
import testcomponent from "@/components/testcomponents.vue";

const routes = [
    {
        path: "/test",  // TestComponent.vue로 이동할 Path
        name: "testcomponent",  // router name
        component: testcomponent,  // Path로 이동될 Component
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;