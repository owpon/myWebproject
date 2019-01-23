import Vue from 'vue';
import Router from 'vue-router';

import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/context/:index',
      name: 'context',
      component: () => import(/* webpackChunkName: "damn" */'./components/context.vue'),
    },
    {
      path: '/editContext/:index',
      name: 'editContext',
      component: () => import('./components/EditContext.vue'),
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ './views/About.vue'),
    },
    {
      path: '/creataText',
      name: 'createText',
      component: () =>
        import('./components/CreateText.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* "login" */ './views/Login.vue'),
      children: [
        {
          path: '/',
          name: 'logon',
          component: () => import('./components/LoginFirst.vue'),
        },
        {
          path: 'loginOk',
          name: 'loginOk',
          component: () => import('./components/LoginOk.vue'),
        },
      ],
    },
    {
      path: '*',
      name: 'notFound',
      component: () => import('./components/404.vue'),
    },
  ],
});
