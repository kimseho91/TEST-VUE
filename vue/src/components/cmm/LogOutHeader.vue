<template>
<div id="pagewrap">
	<router-link to ="/mypage">Mypage</router-link><br />
	<a href="#" @click="logout">LogOut</a>                
</div>
</template>
<script>
import {store} from "../../store"
export default { 
	
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