import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/member/Login'
import Join from '@/components/member/Join'
import MyPage from '@/components/member/MyPage'
import Admin from '@/components/member/Admin'
import ArticleAdd from '@/components/board/ArticleAdd'
import ArticleEdit from '@/components/board/ArticleEdit'
import ArticleFindOne from '@/components/board/ArticleFindOne'
import ArticleFindSome from '@/components/board/ArticleFindSome'
import ArticleRemoval from '@/components/board/ArticleRemoval'
import Articles from '@/components/board/Articles'
import StudentAdd from '@/components/student/StudentAdd'
import StudentEdit from '@/components/student/StudentEdit'
import StudentFindOne from '@/components/student/StudentFindOne'
import StudentFindSome from '@/components/student/StudentFindSome'
import StudentRemoval from '@/components/student/StudentRemoval'
import Students from '@/components/student/Students'

Vue.use(Router)
export default new Router({
	mode : 'history',
	routes:[
		{path:'/login', name : 'login', component : Login},
		{path:'/join', name : 'join', component : Join},
		{path:'/myPage', name : 'myPage', component : MyPage},
		{path:'/admin', name : 'admin', component : Admin},
		{path:'/articleAdd', name : 'articleAdd', component : ArticleAdd},
		{path:'/articleEdit', name : 'articleEdit', component : ArticleEdit},
		{path:'/articleFindOne', name : 'articleFindOne', component : ArticleFindOne},
		{path:'/articleFindSome', name : 'articleFindSome', component : ArticleFindSome},
		{path:'/articleRemoval', name : 'articleRemoval', component : ArticleRemoval},
		{path:'/articles', name : 'articles', component : Articles},
		{path:'/studentAdd', name : 'studentAdd', component : StudentAdd},
		{path:'/studentEdit', name : 'studentEdit', component : StudentEdit},
		{path:'/studentFindOne', name : 'studentFindOne', component : StudentFindOne},
		{path:'/studentFindSome', name : 'studentFindSome', component : StudentFindSome},
		{path:'/studentRemoval', name : 'studentRemoval', component : StudentRemoval},
		{path:'/students', name : 'students', component : Students}
		
		
	]
})