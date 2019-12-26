import Vue from 'vue'
import Vuex from 'vuex'
/* import axios from 'axios' */

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
		person : {},
		loginstate : false,
		sidebar : 'preSidebar',
		headerMessage : '공통화면'
  }
})