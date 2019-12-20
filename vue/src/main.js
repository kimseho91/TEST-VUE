import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuex from 'vuex'
import VueElementLoading from 'vue-element-loading'
import 'es6-promise/auto'
import {store} from './store'

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
  VueElementLoading,
  store
}).$mount('#app')
