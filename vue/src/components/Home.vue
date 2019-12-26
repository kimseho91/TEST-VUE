<template>
	<div id="app">
		<layout>
			<template #header="header">
				<component :is="whichCompo ? 'LogOutHeader' : 'LogInHeader' "></component>
			</template>
			<template #sidebar="sidebar">
				<div v-switch="sidebarCheck">
					<div v-case="'studentSidebar'">
						<component :is="'student-sidebar'"></component>
					</div>
					<div v-case="'adminSidebar'">
						<component :is="'admin-sidebar'"></component>
					</div>
					<div v-case="'preSidebar'">
						<component :is="'pre-sidebar'"></component>
					</div>
				</div>
			</template>
			<template #section="section">
				<router-view></router-view>
			</template>
			<template #footer="footer">
				<h1>{{footer.title}}</h1>
			</template>
		</layout>
	</div>
</template>

<script>
import Layout from "@/components/cmm/Layout.vue"
import LogInHeader from "@/components/cmm/LogInHeader.vue"
import LogOutHeader from "@/components/cmm/LogOutHeader.vue"
import AdminSidebar from "@/components/cmm/AdminSidebar.vue"
import StudentSidebar from "@/components/cmm/StudentSidebar.vue"
import PreSidebar from "@/components/cmm/PreSidebar.vue"
import {store} from "../store"

export default {
components : {Layout, LogInHeader, LogOutHeader, 
							StudentSidebar, AdminSidebar, PreSidebar},
	data(){
		return{
		}
	},
	methods : {
	},
	computed: {
    whichCompo () {
		return store.state.loginstate
		},
		sidebarCheck : function () {
			return store.state.sidebar
		} 
  }
}
</script>

<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>