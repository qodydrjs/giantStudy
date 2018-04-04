<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쇼핑몰 로그인 페이지</title>
<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$('#btn_submit').click(function(){
			
			if(false == loginCheck())
				return false;
			
			var frm = $('#frm_member');
			
			frm.attr( "action","/loginc/loginCheck");
			frm.attr("method","post");
			frm.submit();
			
		});
		
	});
	
	
	function loginCheck(){


		var id = document.getElementById("id");
		var password = document.getElementById("password");

		if((id.value.trim()).length == 0){
			
			alert("아이디를 입력하세요");
			id.value="";
			id.focus();
			return false;
		}else if((password.value.trim()).length == 0){
			alert("패스워드를 입력하세요");
			password.value="";
			password.focus();
			return false;
		}
		
	}

</script>
<style type="text/css">
	.container {
  width: 70%;
  height: 70%;
  margin: 40px auto;
}

.outer {
  display: table;
  width: 100%;
  height: 100%;
}
.inner {
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}

.centered {
  position: relative;
  display: inline-block;
 
  width: 50%;
  padding: 1em;
  background: orange;
  color: white;
}

</style>
</head>
<body>

	<form id="frm_member">
		<div class="container">
			<div class="outer">
				<div class="inner">
					<div class="centered">
						<h3>로그인</h3><br>
						<label>아이디 : </label>	<input type="text" name="id" id="id" width="20" placeholder="아이디를 입력하세요" ><br>
						<label>패스워드 : </label><input type="password" name="password" id="password" width="20" placeholder="패스워드를 입력하세요"><br>
						<input type="button" id="btn_submit" value="로그인"> &ensp; 
						<input type="button" id="btn_member" value="회원가입">
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>