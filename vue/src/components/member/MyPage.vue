<template>
  <table>
    <tr>
      <td>
        <h2>{{person.name}}의 마이페이지</h2>
      </td>
    </tr>
    <tr>
      <td>
        <legend><h3>비밀번호 </h3></legend>
      <h5>{{person.passwd}}</h5>
      <input type="text"  size="20" placeholder="변경할 생일 입력" v-model="person.passwd"  style="float: center; width: 70%;" />
      <button @click.prevent="modify">수정</button><br/><br/>
      </td>
    </tr>
    <tr>
      <td><legend><h3>성적 확인</h3></legend>
      <h5>{{person.hak}} 학년</h5>
      <h5>{{person.ban}} 반</h5>
      <h5>{{person.score}}점</h5>
      <br/><br/>
      </td>
    </tr>
  </table>
</template>
<script>
import axios from "axios" 
import {store} from "../../store"
export default{
	data(){
		return {
      context : 'http://localhost:8080/',
      person : store.state.person,
      authCheck : true
		}
		
	},
  methods  : {
     modify (){
            let url = `${this.context}/modify`
            let data = this.person
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }      
            axios
            .put(url, data, headers)
            .then(res=>{
              this.person = res.data.data
              if(res.data.result ==="SUCCESS"){
                alert(`수정  성공 `);
                this.$router.push({path: '/myPage'})
              }else{
                alert(`수정 실패 `);                
                this.$router.push({path:  '/join'})                 
              }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })             
    },
    goUpdate(){
      this.$router.push({path: '/myPageUpdate'})
    }
  }
}
</script>
<style scoped>
    .back {width: 700px; margin: 0 ;}
    .sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>