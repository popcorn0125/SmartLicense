<template>
    <TopBar />
        <div>dd</div>
    <BottomBar />
</template>

<script>
import TopBar from '@/components/TopBar.vue';
import BottomBar from '@/components/BottomBar.vue'
export default {
    name: 'MyPage',
    components: {
        TopBar, BottomBar
    },
    data() {
        return {
            
        };
    },
    methods: {

    },
}
</script>

<style scoped>
@import "@/css/common.css";

</style>