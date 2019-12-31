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