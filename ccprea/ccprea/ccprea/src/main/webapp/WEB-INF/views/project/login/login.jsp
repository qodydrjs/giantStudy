<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		var msg = '${msg}';
		
		if(msg=='Failed'){
			alert("등록되지 않은 사용자입니다.");
		}
		
		$('#loginBtn').click(function(){
			var empNum = $('#empNum');
			var password = $('#password');
			
			
			if( empNum.val().length <= 0){
				
				
				alert(" 아이디를 입력하세요. ");
				empNum.focus();
				return;
			}else if(password.val().length <= 0){
				
				alert(" 비밀번호를 입력하세요. ");
				password.focus();
				return;
			}else if(isNaN(empNum.val())==true){
				alert("숫자만 입력 가능합니다.");
				empNum.focus();
				return;
			}else if(empNum.val().length >= 7){
				alert("아이디는 7자리 이하입니다.");
				empNum.focus();
				return;
			}
			
			var frmOjb = $('form[id=loginfrm]');
			
			frmOjb.attr("action","login");
			frmOjb.attr("method","POST");
			frmOjb.submit();
			
			
		})
		
	})
	


</script>

<title>Insert title here</title>
</head>
<body>

	<form id="loginfrm" name="loginfrm">
	<label for="ID">아이디: </label>
	<input type="text" name="empNum" id="empNum" size="20">
	<br>
	<label for="ID">비밀번호: </label>
	<input type="password" name="password" id="password" size="20">
	<br>
	<input type="button" name="loginBtn" id="loginBtn" value="로그인">
	</form>
</body>
</html>