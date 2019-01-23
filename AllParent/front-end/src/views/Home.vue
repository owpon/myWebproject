<template>
  <v-layout column align-center>
    <h1 v-text="greeting"></h1>
    <img src="@/assets/0.gif" alt="Vuetify.js" class="mb-5">
    <!-- <v-btn flat color="orange" @click="cleanData(datas)">read</v-btn> -->
    <v-flex xs12>
      <v-container grid-list-lg>
        <cards :datas="datas"/>
      </v-container>
    </v-flex>
    <blockquote>&#8220;First, solve the problem. Then, write the code.&#8221;
      <footer>
        <small>
          <em>&mdash;John Johnson</em>
        </small>
      </footer>
    </blockquote>
  </v-layout>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.v-card img {
  width: 100%;
}
</style>

<script>
import axios from "axios";

import Cards from "../components/Cards";

export default {
  components: {
    cards: Cards
  },
  data() {
    return {
      greeting: "Not Receive"
    };
  },
  computed: {
    datas() {
      return this.$store.state.cards;
    }
  },

  watch: {
    datas(val) {
      if (val.length > 0) {
        this.greeting = "Hello";
      } else {
        this.greeting = "Damn";
      }
    }
  },
  methods: {
    cleanData(datas) {
      const def = getSelection();
      def[datas] = this[datas];
      Object.assign(this.datas, def);
    }
  }
};
</script>

