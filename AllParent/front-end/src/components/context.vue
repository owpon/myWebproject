<template>
  <v-container grid-list-lg>
    <v-layout row justify-center>

      <v-card>
        <v-card-title>
          <span class="headline">{{contextData.title}}</span>
        </v-card-title>
        <v-card-text>{{contextData.context}}</v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-layout>
  </v-container>
</template>


<script>
import axios from 'axios';
import dateformat from '../common/dateformate';

export default {
  mounted() {
    axios.get(`/context/${this.$route.params.id}`).then(({ data }) => {
      this.contextData = data;
      //   console.log(data);
    });
  },
  data() {
    return {
      contextData: {},
    };
  },
  methods: {
    dateformat(date) {
      return dateformat(date);
    },
  },
};
</script>

