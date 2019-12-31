import * as types from '@/store/modules/mutation_types'
const state = {
	context: 'http://localhost:8080/',
	isAuth: false,
	headerMessage: '공통 화면',
	errorState: ''
}
const getters = {
	getErrorState: state => state.errorState,
    getIsAuth: state => state.isAuth,
    getContext: state => state.context,
    getSidebars: state => state.sidebars,
    getHeaderMessage: state => state.headerMessage
}
const actions = {}
const mutations = {
  [types.ERROR_STATE] (state, errorState) {
    state.errorState = errorState
  },
  [types.IS_AUTH] (state, isAuth) {
    state.isAuth = isAuth
  },
  [types.CONTEXT] (state, context) {
    state.context = context
  },
  [types.SIDEBARS] (state, sidebars) {
    state.sidebars = sidebars
  },
  [types.HEADER_MESSAGE] (state, headingMessage) {
    state.headingMessage = headingMessage
  }
}
export default {
	namespaced : true,
	state,
	getters,
	actions,
	mutations
}