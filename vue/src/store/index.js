import Vue from 'vue'
import Vuex from 'vuex'
import common from '@/store/modules/common'
import students from '@/store/modules/students'
import article from '@/store/modules/article'
import admin from '@/store/modules/admin'
/* import axios from 'axios' */

Vue.use(Vuex)

export const store = new Vuex.Store({
  modules : {
		common,
		admin,
		students,
		article
	},
	strcit : true

})