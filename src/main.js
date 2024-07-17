import { createApp } from 'vue'
import App from './App.vue'
import routers from './routers/router.js'  // router import
import VueCookies from 'vue-cookies'

// createApp(App).mount('#app')  <-- Vue 프로젝트 생성 시 존재하는 기본 코드 제거

// 위 createApp 코드 아래처럼 변경
const app = createApp(App)
app.use(routers)  // router 추가
app.use(VueCookies) // cookie 추가
app.mount('#app')
