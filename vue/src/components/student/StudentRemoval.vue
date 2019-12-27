<template> 
<div class="login-form">
    <form>
        <h2 class="text-center">학번 검색</h2>
        <div class="form-group">
            <input v-model="searchWord" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block" @click.prevent="remove">전송</button>
        </div>
    </form>
</div> 
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return {
			context: 'http://localhost:8080/',
			list: []
		}
	},
	remove(){
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
.table{border : 1px solid black}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black}
.table tr td{border : 1px solid black}
</style>