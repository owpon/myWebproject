<template>
  <v-layout column align-center>
    <router-view/>
    <router-link v-if="isLogin()" to="/login">logon</router-link>
  </v-layout>
</template>
<script>
export default {
  methods: {
    isLogin() {
      return this.$route.name !== 'logon';
    },
  },
};
</script>
