<template>
  <v-layout column align-center>
    <h1 v-text="greeting"></h1>
    <img src="@/assets/0.gif" alt="Vuetify.js" class="mb-5">
    <v-btn flat color="orange" @click="cleanData(datas)">read</v-btn>
    <v-flex xs12>
      <v-container grid-list-lg>
        <v-layout row wrap align-center>
          <v-flex xs12 md4 v-for="({title,auther,context,createTime,updateTime,id}) in datas" :key="id">
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
                <v-btn flat color="orange" @click="read(id)">read</v-btn>
                <v-btn flat color="orange" @click="editContext()">edit</v-btn>
                <!-- <v-btn flat color="orange" v-text="dateformat(updateTime)"></v-btn> -->
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-flex>
    <blockquote>
      &#8220;First, solve the problem. Then, write the code.&#8221;
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
import axios from 'axios';
import dateformat from '../common/dateformate';

export default {
  mounted() {
    axios.get('/getAllContext', {}).then(({ data }) => {
      // this.$store.commit('updateDatas');
      // console.log(this.$store.state.datas);
      this.datas = data;
      // window.setTimeout(() => {
      //   this.datas = [];
      // }, 3000);
    });
  },
  data() {
    return {
      greeting: 'Not Receive',
      datas: [],
    };
  },

  watch: {
    datas(val) {
      if (val.length > 0) {
        this.greeting = 'Hello';
      } else {
        this.greeting = 'Damn';
      }
    },
  },
  methods: {
    dateformat(date) {
      return dateformat(date);
    },
    read(id) {
      this.$router.push({ name: 'context', params: { id } });
    },
    editContext() {
      this.$router.push({ name: 'editContext' });
    },
    getDefaultData() {
      return {
        dates: [],
      };
    },
    cleanData(datas) {
      const def = getSelection();
      def[datas] = this[datas];
      Object.assign(this.datas, def);
    },
  },
};
</script>

