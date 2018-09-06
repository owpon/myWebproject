<template>
  <v-layout column align-center>
    <h1 v-text="greeting"></h1>
    <img src="@/assets/0.gif" alt="Vuetify.js" class="mb-5">
    <v-card>
      <v-container fluid grid-list-lg>
        <v-layout row wrap align-center>
          <v-flex xs12 sm6 v-for="({auther,context,create_time,update_time}) in datas" :key="auther">
            <v-card hover>
              <v-img src="https://cdn.vuetifyjs.com/images/cards/desert.jpg" aspect-ratio="2.75"></v-img>
              <v-card-title primary-title>
                <div>
                  <h3 class="headline mb-0">{{auther}}</h3>
                  <div>{{context}}<br>Southern Highlands of New South Wales, ...</div>
                </div>
              </v-card-title>
              <v-card-actions>
                <v-btn flat color="orange">{{create_time}}</v-btn>
                <v-btn flat color="orange" v-text="update_time"></v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-card>
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
</style>

<script>
export default {
  mounted() {
    this.axios
      .get('http://localhost:8088/getAllContext', {})
      .then(({ data }) => {
        this.datas = data;
        // window.setTimeout(() => {
        //   this.datas = [];
        // }, 3000);
      });
  },
  data() {
    return {
      greeting: 'Not Receive',
      datas: []
    };
  },
  watch: {
    datas(val, oldVal) {
      if (val.length > 0) {
        this.greeting = 'Hello';
      } else {
        this.greeting = 'Damn';
      }
    }
  }
};
</script>

