<template>
    <v-layout column align-center>
        <p>正確跳頁</p>
    </v-layout>
</template>

<script>
export default {
  name: 'LoginOk',
  mounted() {
    console.log(this.$route.params.data);
  },
};
</script>
