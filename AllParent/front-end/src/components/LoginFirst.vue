<template>
  <v-layout column align-center>
    <v-flex xs12 sm6 md3>
      <v-text-field label="帳號"></v-text-field>
    </v-flex>
    <v-flex xs12 sm6 md3>
      <v-text-field label="密碼"></v-text-field>
    </v-flex>
    <div>
      <v-btn color="info" @click="loginok()">登入</v-btn>
    </div>
  </v-layout>
</template>
<script>
import axios from 'axios';

export default {
  methods: {
    loginok() {
      axios.get('http://localhost:8088/getAllContext', {}).then(({ data }) => {
        if (data) {
          this.$router.push({ name: 'loginOk', params: { data } });
        }
      });
      // this.$router.push({ path: '/login/loginOk' });
    },
  },
};
</script>
