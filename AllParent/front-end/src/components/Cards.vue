<template>
  <v-layout row wrap align-center>
    <v-flex
      xs12
      md4
      v-for="({title,auther,context,createTime,updateTime,id},index) in datas"
      :key="id"
    >
      <!-- <v-card @click.native="clickHandler(id)" hover> -->
      <v-card hover>
        <!-- <img src="@/assets/404.gif" alt="Vuetify.js" class="mb-4"> -->
        <v-card-title primary-title class="layout justify-center">
          <div>
            <div class="headline text-xs-center">{{title}}</div>
          </div>
        </v-card-title>
        <v-card-text>
          <div>{{context}}</div>
        </v-card-text>
        <v-card-actions>
          <!-- <v-btn flat color="orange">{{dateformat(createTime)}}</v-btn> -->
          <v-btn flat color="orange" @click="read(index)">read</v-btn>
          <v-btn flat color="orange" @click="editContext(index)">edit</v-btn>
          <v-btn flat color="orange" @click="deleteContext(id,datas,index)">delete</v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
import dateformat from "../common/dateformate";
import axios from "axios";
import { mapMutations } from "vuex";

export default {
  name: "cards",
  props: ["datas"],
  computed: {},
  methods: {
    ...mapMutations({ updateDatas: "updateDatas" }),
    dateformat(date) {
      return dateformat(date);
    },
    read(index) {
      this.$router.push({ name: "context", params: { index } });
    },
    editContext(index) {
      this.$router.push({ name: "editContext", params: { index } });
    },
    deleteContext(index, datas, order) {
      axios
        .delete("http://localhost:8088/delete/" + index, {
          id: index
        })
        .then(response => {
         
          datas.splice(order, 1);
           this.updateDatas(datas);
        })
        .then(error => {
          console.log(error);
        });
    },

    getDefaultData() {
      return {
        datas: []
      };
    }
  }
};
</script>

