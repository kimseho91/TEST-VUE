<template>
    <div class="login-form">
    <form action="/examples/actions/confirmation.php" method="post">
        <h2 class="text-center">Login</h2>   
        <div class="form-group has-error">
        <input type="text" class="form-control" name="username" placeholder="Username" required="required" v-model="userid">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required" v-model="passwd">
        </div>        
        <div class="form-group">
            <button @click="login" type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>
        </div>
        <p><a href="#">Lost your Password?</a></p>
    </form>
    <p class="text-center small">Don't have an account? <a href="#">Sign up here!</a></p>
</div>
</template>
<script>
import axios from "axios"
export default {
    data() {
        return {
            context : 'http://localhost:8080/',
            result : '',
            userid : '',
            passwd : ''
        }
    },
    methods : {
        login() {
            alert(`${this.userid} ${this.passwd}`)
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
            .post(url, data, headers)
            .then(res=>{
                this.result = res.data
                alert(`로그인성공 ${this.result.userid}`)
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
        }
    }
}
</script>
<style scoped>
body {
    color: #fff;
    background: #3598dc;
}
.form-control {
    min-height: 41px;
    background: #f2f2f2;
    box-shadow: none !important;
    border: transparent;
}
.form-control:focus {
    background: #e2e2e2;
}
.form-control, .btn {        
    border-radius: 2px;
}
.login-form {
    width: 350px;
    margin: 30px auto;
    text-align: center;
}
.login-form h2 {
    margin: 10px 0 25px;
}
.login-form form {
    color: #7a7a7a;
    border-radius: 3px;
    margin-bottom: 15px;
    background: #fff;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form .btn {        
    font-size: 16px;
    font-weight: bold;
    background: #3598dc;
    border: none;
    outline: none !important;
}
.login-form .btn:hover, .login-form .btn:focus {
    background: #2389cd;
}
.login-form a {
    color: #fff;
    text-decoration: underline;
}
.login-form a:hover {
    text-decoration: none;
}
.login-form form a {
    color: #7a7a7a;
    text-decoration: none;
}
.login-form form a:hover {
    text-decoration: underline;
}
</style>