<template>
  <v-app>
    <v-toolbar color="primary">
      <v-toolbar-title>理膚寶水</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-toolbar-items>
        <v-btn to="/" flat>Home</v-btn>
        <v-btn to="/login" flat>Login</v-btn>
        <v-btn to="/about" flat>About</v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-content>
      <!-- <v-container fluid grid-list-lg> -->
      <router-view/>
      <!-- </v-container> -->
      <v-layout column class="fab-container">
        <v-btn fab color="orange" @click="createText()">
          <v-icon>add</v-icon>
        </v-btn>
      </v-layout>
    </v-content>

    <v-navigation-drawer temporary :right="right" v-model="rightDrawer" fixed app>
      <v-list>
        <v-list-tile @click="right = !right">
          <v-list-tile-action>
            <v-icon>compare_arrows</v-icon>
          </v-list-tile-action>
          <v-list-tile-title>Switch drawer (click me)</v-list-tile-title>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-footer :fixed="fixed" app>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  data() {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      items: [
        {
          icon: "bubble_chart",
          title: "Inspire"
        }
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false
    };
  },
  methods: {
    createText() {
      this.$router.push({ name: "createText" });
    }
  },
  mounted() {
    axios.get("/getAllContext", {}).then(({ data }) => {
      this.$store.commit("updateDatas", data);
    });
  }
};
</script>
