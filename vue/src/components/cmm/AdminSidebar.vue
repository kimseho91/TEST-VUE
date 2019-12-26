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
                {menu:"학생목록",link:"/students"},
                {menu:"조건별 학생검색",link:"/studentFindSome"},
				{menu:"학생성적수정",link:"/studentEdit"},
				{menu:"ID 학생검색",link:"/studentFindOne"}
			]
		}
	}
}
</script>
<style scoped></style>