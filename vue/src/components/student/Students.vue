<template>
	<div>학생 목록 
		<table class="table">
			<tr>
				<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
				<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
			</tr>
			<tr v-for="(j, i) of list" :key="j.id">
				<td>{{i+1}}</td>
				<td>{{j.userid}}</td>
				<td>{{j.passwd}}</td>
				<td>{{j.name}}</td>
				<td>{{j.birthday}}</td>
				<td>{{j.gender}}</td>
				<td>{{j.hak}}</td>
				<td>{{j.ban}}</td>
				<td>{{j.score}}</td>
				<td>{{j.role}}</td>
			</tr>
		</table>
		<div class="btn-cover">
			<button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
				이전
			</button>
			<span class="page-count">{{ pageNum + 1 }} </span>
			<button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
				다음
			</button>
		</div>
	</div>
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return {
			context: 'http://localhost:8080/',
			list: [],
			pageNum: 0,
			pageCount: 5
		}
	},
	created(){
		axios
		.get(`${this.context}/students`)
		.then(res =>{
			this.list = res.data
		})
		.catch(e=>{
			alert('AXIOS FAIL'+e)
		})
	}
}
</script>
<style scoped>
.table {
  width: 100%;
  border-collapse: collapse;
}
.table th {
  font-size: 1.2rem;
}
.table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
.table tr:first-of-type {
  border-top: 2px solid #404040;
}
.table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
  border: 1px solid black;
  margin-right: 10px;
  margin-left: 10px;
}
</style>