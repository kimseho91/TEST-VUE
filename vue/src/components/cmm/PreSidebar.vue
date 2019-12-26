<template>
<ul>
  <li v-for="sidebar of sidebars" :key="sidebar.menu">
    <router-link :to="sidebar.link">{{sidebar.menu}}</router-link>
  </li>
</ul>
</template>

<script>
export default {
  data(){
		return{
			sidebars:[
			{menu:"게시글 목록",link:"/articles"},
				{menu:"게시글 검색",link:"/articleFindOne"}
			]
		}
	}
}
</script>

<style scoped></style>