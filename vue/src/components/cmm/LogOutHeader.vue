<template>
<div id="pagewrap">
			<div>
				<div  v-for="header of headers" :key="header.menu">
					<router-link :to ="header.link">{{header.menu}}</router-link>
				</div>				
                    <a href="#" @click="logout">LogOut</a>                  
			</div>     
</div>
</template>
<script>
import {store} from "../../store"
export default { 
	data(){
		return {
			headers: [
				{menu : "Join", link: "/cJoin"},
				{menu : "Mypage", link: "/mypage"}
			]               
		}
     },
  methods: {
    logout (){
              alert('로그아웃 ')
                store.state.loginedCid = ''
                store.state.loginedPwd = ''
                store.state.person = {}
								store.state.loginstate = false
								store.state.sidebar = 'preSidebar'        
                this.$router.push({path:  '/login'})                  
    }  
}
}
</script>
<style scoped>
</style>