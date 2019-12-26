<template>
	<div class="login-form">
    <form>
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input v-model="userid" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input v-model="passwd" type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block" @click.prevent="login">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
</div>
</template>
<script>
import axios from "axios"
import {store} from "../../store"
export default {
	data() {
		return {
            context : 'http://localhost:8080/',
            result : '',
            userid : '',
            passwd : '',
            person : {}
		}
    },
    methods : {
        login(){
                alert(`${this.userid},${this.passwd}`)
          let url = `${this.context}/login`
          let data = {
              userid : this.userid,
              passwd : this.passwd
            }
            let headers = {
              'authorization': 'JWT fefege..',
              'Accept' : 'application/json',
              'Content-Type': 'application/json'
            }
            axios
            .post(url,data,headers)
            .then(res=>{
                if(res.data.result === "SUCCESS"){
                store.state.person = res.data.person
                store.state.loginstate = true
                alert(`스토어에 저장성공 ${store.state.loginstate}`)
                    if(store.state.person.role !== 'student'){
                        store.state.sidebar = 'adminSidebar'
                        this.$router.push({path: '/admin'})
                    }else{
                        store.state.sidebar = 'studentSidebar'
                        this.$router.push({path: '/myPage'})
                    }
                }else{
                    alert(`로그인실패`)
                    this.$router.push({path: '/login'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
        }
    }
}
</script>
<style type="text/css">
.login-form {
    width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #F7F7F7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {
    font-size: 15px;
    font-weight: bold;
}
</style>