<template>
	<div id="app">
		<layout>
			<template #header="header">
				<h4>{{header.title}}</h4>
				<component :is="whichCompo ? 'LogOutHeader' : 'LogInHeader' "></component>
			</template>
			<template #sidebar="sidebar">
				<component :is="sidebarCheck"></component>
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
		return this.$store.state.is_auth
		},
		sidebarCheck : function () {
		return this.$store.state.sidebar
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