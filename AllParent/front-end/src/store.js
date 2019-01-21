import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    cards: [],
  },
  mutations: {
    updateDatas(state, datas) {
      state.cards = datas
      console.log("store的：",state.cards)
    },
  },
  actions: {},
});
