import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuex from 'vuex'
import 'es6-promise/auto'
import {store} from './store'
import VSwitch from 'v-switch-case'

Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.use(VSwitch)

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
  store
}).$mount('#app')
