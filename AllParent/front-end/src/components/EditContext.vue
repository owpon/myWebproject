<template>
  <v-container fluid grid-list-md>
    <v-text-field label="title" outline v-model="contextData.title"></v-text-field>
    <v-layout row wrap>
      <v-textarea box name="input-7-4" label="Box textarea" v-model="contextData.context"></v-textarea>
    </v-layout>
    <v-btn flat color="orange" @click="save(contextData)">save</v-btn>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      contextData: this.$store.state.cards[this.$route.params.index]
    };
  },
  methods: {
    save(data) {
      console.log(data);
      axios
        .post("http://localhost:8088/editContext", {
          id: data.id,
          title: data.title,
          auther: data.auther,
          context: data.context
        })
        .then(this.$router.push({ name: "home" }));
    }
  }
};
</script>
