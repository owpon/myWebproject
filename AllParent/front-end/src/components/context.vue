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
  data(){
    return{
      contextData:this.$store.state.cards[this.$route.params.index]
    }
  },
  // computed:{
  //   contextData(){
  //     const contextData = this.$store.state.cards.find((ele)=>{
  //      return ele.id === this.$route.params.id
  //     });
  //     return contextData
  //   },
  // },
  methods: {
    dateformat(date) {
      return dateformat(date);
    },
  },
};
</script>

