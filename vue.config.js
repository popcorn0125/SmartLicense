const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // build 경로 설정
  outputDir: "../todomypet_backend/src/main/resources/static",
  devServer: {
    // 프록시 설정
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/login': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
})
