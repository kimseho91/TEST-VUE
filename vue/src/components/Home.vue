<template>
	<div id="app">
		<layout>
			<template #header="header">
				<span v-for="header of headers" :key="header.menu">
					<router-link :to="header.link">{{header.menu}}</router-link>
				</span>
			</template>
			<template #sidebar="sidebar">
				<ul>
					<li v-for="sidebar of sidebars" :key="sidebar.menu">
					<router-link :to="sidebar.link">{{sidebar.menu}}</router-link>
					</li>
				</ul>
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
export default {
	components : {Layout},
	data(){
		return{
			sidebars:[
				{menu : "글작성", link : "/write"},
				{menu : "글목록", link : "/list"},
				{menu : "글수정", link : "/update"},
				{menu : "글삭제", link : "/remove"},
				{menu : "검색", link : "/search"}
      ],
      headers:[
				{menu : "로그인", link : "/login"},
				{menu : "회원가입", link : "/Join"}
      ]
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