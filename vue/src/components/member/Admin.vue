<template>
  <table>
    <tr>
      <td>
        <h2>{{person.name}}의 관리자 페이지</h2>
      </td>
    </tr>
    <tr>
      <td>
        <legend><h3>비밀번호 </h3></legend>
      <h5>{{person.passwd}}</h5>
      <button>수정</button><br/><br/>
      </td>
    </tr>
    <tr>
      <td><legend><h3>학생부 관리</h3></legend>
      <h5>{{person.hak}} 학년</h5>
      <h5>{{person.ban}} 반</h5>
      <h5>{{person.score}}점</h5>
      <br/><br/>
      <button @click.prevent="goUpdate">수정</button>
      </td>
    </tr>
  </table>
</template>
<script>
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