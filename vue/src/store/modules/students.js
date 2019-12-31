//import loginAPI from '@/api/loginAPI'
import Constant from '@/store/modules/mutation_types'
import axios from 'axios'

const state = {
    person: {},
    sidebars : [
                {menu:"게시글 목록",link:"/articles"},
				{menu:"게시글 검색",link:"/articleFindOne"}
            ],
    userid : '',
    passwd : '',
    name : '',
    birthday : ''
}

const getters = {
	getPerson: state => state.person
}

const actions = {
	async login(){
        alert(`${this.$store.state.context}`)
        let url = `${this.$store.state.context}/login`
        let data = {
            userid: this.userid,
            passwd: this.passwd
        }
        let headers = {
            'authorization': 'JWT fefege..',
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        }
        axios
        .post(url, data, headers)
        .then(res=>{
            if(res.data.result === "SUCCESS"){
                this.$store.commit(Constant.PERSON, res.data.person)
                this.$store.commit(Constant.IS_AUTH, true)
                
                alert(`스토어에 저장성공 ${this.$store.state.authCheck}`)
                if(this.$store.state.person.role !== 'student'){
                    this.$store.commit(Constant.SIDEBAR, 'AdminSidebar')
                    this.$store.commit(Constant.HEADER_MESSAGE, '관리자화면')
                    this.$router.push({path: '/admin'})
                }else{
                    this.$store.commit(Constant.SIDEBAR, 'StudentSidebar')
                    this.$store.commit(Constant.HEADER_MESSAGE, '학생화면')
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
        
    },
    async join(){
        let url = `this.$store.state.context}/join`
        let data = {
            userid : this.userid,
            passwd : this.passwd,
            name : this.name,
            birthday : this.birthday
        }
        let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
        }
        axios
        .post(url, data, headers)
        .then(res=>{
            if(res.data.result==="SUCCESS"){
                this.$store.commit(Constant.PERSON, res.data.person)
                this.$router.push({path : '/mypage'})
            }else{
        this.$router.push({path : '/join'})
        }
        })
        .catch(()=>{
            alert(`axios 실패!`)
        })
    },
    async modify (){
        let url = `${this.$store.state.context}}/modify`
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
    async goUpdate(){
      this.$router.push({path: '/myPageUpdate'})
    },
    async logout (){
              alert('로그아웃 ')
                this.$store.state.person = {}
                this.$store.state.isAuth = false
                this.$store.state.sidebar = 'preSidebar'        
                this.$router.push({path:'/login'})                  
    }
}

const mutations = {
    LOGIN (state, person) {
        state.person = person
    },
    LOGOUT (state) {
        state.person = null
    },
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}