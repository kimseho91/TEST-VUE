<template>
	<div>
		<ul class="menu">
			<li v-for="i of sidebars" :key="i.menu">
				<router-link :to="i.link">{{i.menu}}</router-link>
			</li>
		</ul>
	</div>
</template>
<script>
export default{
	data(){
		return {
			sidebars : [
				{menu:"학생목록",link:"/list"},
				{menu:"학생성적수정",link:"/update"},
				{menu:"학생검색",link:"/search"}
			]
		}
	}
}
</script>
<style scoped></style>