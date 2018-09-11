import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    datas: [],
  },
  mutations: {
    // updateDatas(state, datas) {
    //   state.datas = [
    //     {
    //       id: 8,
    //       auther: 'henry',
    //       context: '我就是戰神呂布，不服來辯!',
    //       createTime: '2018-09-07T22:21:09.000+0000',
    //       updateTime: '2018-09-07T03:21:09.000+0000',
    //     },
    //   ];
    // },
  },
  actions: {},
});
