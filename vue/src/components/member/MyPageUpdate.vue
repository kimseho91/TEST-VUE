<template>
  <table>
    <tr>
      <td>
        <legend><h3>비밀번호 변경</h3></legend>
      <input type="text" name="pwd" size="20" placeholder="기존 비밀번호 입력" v-model="person.pwd"  style="float: none; width: 70%;">
      <button>수정</button><br/><br/>
      </td>
    </tr>
    <tr>
      <td><legend><h3>학생부 관리</h3></legend>
      <input type="text" name="pwd" size="20" placeholder="변경할 학년  입력" v-model="person.hak" style="float: none;width: 70%;"> 학년
      <input type="text" name="pwd" size="20" placeholder="변경할 반 입력" v-model="person.ban"  style="float: none;width: 70%;"> 반
      <input type="text" name="pwd" size="20" placeholder="변경할 성적 입력" v-model="person.score"   style="float: none;width: 70%;"> 점
      <br/><br/>
      <button style="height: 20%; width: 70%; float: none;" @click.prevent="modify">수정</button></td>
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