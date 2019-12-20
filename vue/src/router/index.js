import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/member/Login'
import Join from '@/components/member/Join'
import Write from '@/components/board/Write'
import List from '@/components/board/List'
import Remove from '@/components/board/Remove'
import Update from '@/components/board/Update'
import Search from '@/components/board/Search'
Vue.use(Router)
export default new Router({
	mode : 'history',
	routes:[
		{path:'/login', name : 'login', component : Login},
		{path:'/join', name : 'join', component : Join},
		{path:'/write', name : 'write', component : Write},
		{path:'/list', name : 'list', component : List},
		{path:'/remove', name : 'remove', component : Remove},
		{path:'/update', name : 'update', component : Update},
		{path:'/search', name : 'search', component : Search}
	]
})