<template>
  <v-container fluid grid-list-md>
    <v-text-field label="title" placeholder v-model="title" outline>{{title}}</v-text-field>
    <v-textarea outline name="input-7-4" label="context" value v-model="context">{{context}}</v-textarea>
    <v-btn flat color="orange" @click="save(title,context)">save</v-btn>
  </v-container>
</template>

<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  data() {
    return {
      title: "",
      context: ""
    };
  },
  methods: {
    ...mapMutations({ addData: "updateDatas" }),
    save(inputTitle, inputText) {
      console.log(inputTitle, inputText);
      axios
        .post("http://localhost:8088/createContext", {
          title: inputTitle,
          auther: "ziv",
          context: inputText
        })
        .then(res => {
          var datas = this.$store.state.cards;
          datas.push(res.data);
          this.addData(datas);
          // this.addData(res.data);
          console.log(datas);
        })
        .then(this.$router.push({ name: "home" }));
    }
  }
};
</script>