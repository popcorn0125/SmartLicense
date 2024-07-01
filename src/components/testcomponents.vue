<template>
  <div>
    <h2>Test Component</h2>
    Test Page
  </div>
  <button @click="testclick">asdf</button>
</template>

<script>
import axios from 'axios';
export default {
  name: "TestComponent",
  data() {
    return {

    }
  },
  methods: {
    testclick() {
      axios({
        method: 'get',
        header: { 'Content-Type': 'application/json; charset=UTF-8' },
        url: "/api/test",
        
      })
        .then(function () {
          alert("응답 성공")
        })
        .catch(function () {
          alert("응답 실패");
        });
    },


  },

  created() {

  },
  mounted() {

  },
}
</script>

<style scoped></style>