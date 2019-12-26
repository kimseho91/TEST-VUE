<template>
<div id="pagewrap">
			<div>
				<div  v-for="header of headers" :key="header.menu">
					<router-link :to ="header.link">{{header.menu}}</router-link>
				</div>				
                    <router-link to ="/login">LogIn</router-link>
			</div>     
</div>
</template>
<script>
export default { 
	data(){
		return {
			headers: [
				{menu : "Join", link: "/cJoin"},
				{menu : "Mypage", link: "/mypage"}
			]
		}
	}
}
</script>
<style scoped>
</style>