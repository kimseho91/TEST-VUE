<template>
<div>
  <div id="host-header">
        <h1 align = "center">업체 회원 가입</h1>
      </div>
        <fieldset>
        <legend>아이디 입력 </legend>
        <span><input v-model="person.userid" type="text" id="hostId" name="hostId" maxlength="20" value=""></span>
        </fieldset>
        <fieldset>
        <legend>패스워드 입력 </legend>
        <input v-model="person.passwd" type="pw" id="userPw" name="hostPw" maxlength="20" autocomplete="off">
        </fieldset>
        <fieldset>
        <legend>이름 입력 </legend>
        <div><label for="hostName">이름</label></div>
        <div><input v-model="person.name" type="text" id="hostName" name="hostName" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>생일 입력 </legend>
        <div><label for="hostBirth">생일</label></div>
        <div><input v-model="person.birthday" type="text" id="birthday" name="birthday" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>성별 입력 </legend>
        <div><label for="hostgender">성별</label></div>
        <div><input v-model="person.gender" type="text" id="gender" name="gender" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>학년 입력 </legend>
        <div><label for="hosthak">학년</label></div>
        <div><input v-model="person.hak" type="text" id="hak" name="hak" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>반 입력 </legend>
        <div><label for="hostban">반</label></div>
        <div><input v-model="person.ban" type="text" id="ban" name="ban" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>점수 입력 </legend>
        <div><label for="hostscore">점수</label></div>
        <div><input v-model="person.score" type="text" id="score" name="score" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>직급 입력 </legend>
        <div><label for="hostrole">직급</label></div>
        <div><input v-model="person.role" type="text" id="role" name="role" maxlength="20" value=""></div>
        <br/>
        </fieldset>
        <div class="btnfield" style="text-align: center">
            <button @click.prevent="join" type="submit" class="btn btn-primary btn-lg btn-block">회원가입</button>
        </div>
</div>
</template>
<script>
import axios from "axios"
export default {
    data() {
        return {
            context : 'http://localhost:8080/',
            person:{
                userid : '',
                passwd : '',
                name : '',
                birthday : '',
                gender : '',
                hak : '',
                ban : '',
                score : '',
                role : ''
            }
        }
    },
    methods : {       
        join() {
            let url = `${this.context}/join`
            let data = this.person
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, data, headers)
            .then(res=>{
                if(res.data.result === "SUCCESS"){
                    alert(`회원가입 성공 !!`)
                    this.$router.push({path:'/login'})
                }else{
                    alert(`회원가입 실패`)
                    this.$router.push({path:'/cjoin'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })
        }
    }
}
</script>
<style scoped>
</style>