<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		
		$('#list_btn').click(function(){
			
			location.href="singList";		
			
		})
		
		
		$('#sing_btn').click(function(){
			
			$('#h_ban_btn').attr("name","");
			$('#h_save_btn').attr("name","");
			
			var frmObj = $('form[id=sign_frm]');
			
			frmObj.attr("action","write")
			frmObj.attr("method","POST");
			frmObj.submit();
			
		})
		
		$('#save_btn').click(function(){
			
			$('#h_ban_btn').attr("name","");
			$('#h_sing_btn').attr("name","");
			
			var frmObj = $('form[id=sign_frm]');
			
			frmObj.attr("action","write")
			frmObj.attr("method","POST");
			frmObj.submit();
			
		})
	
	})

</script>
<title>결제 작성</title>
</head>
<body>



<input type="button" value="목록" id="list_btn">
<br>

<div>

	<table border="1">
		<tr>
			<th>
				<c:if test="${empty list.empNum }"> ${empName }</c:if>
				<c:if test="${not empty list.empNum }"> ${list.empNum }</c:if>
			</th>
			<th>
				<c:if test="${empty line[0].EMP_NAME }"> 과장 </c:if>
				<c:if test="${not empty line[0].EMP_NAME }"> ${line[0].EMP_NAME }</c:if>
			</th>
			<th>
				<c:if test="${empty line[1].EMP_NAME }"> 부장 </c:if>
				<c:if test="${not empty line[1].EMP_NAME }"> ${line[1].EMP_NAME }</c:if>
			</th>
		</tr>
		
		<tr>
			<th>
				<input type="checkbox">
			</th>
			<th>
				<input type="checkbox">
			</th>
			<th>
				<input type="checkbox">	
			</th>
		</tr>
		
	
	</table>
</div>


<br>

<form id="sign_frm">
<input type="hidden" name="empNum" value="${empNum }">
<input type="hidden" id=h_save_btn name="signState" value="1">
<input type="hidden" id=h_ban_btn name="signState" value="3">
<input type="hidden" id=h_sing_btn name="signState" value="2">


	<label for="seq">번호 :</label>
	<input type="text" id="seq" name="seq" size="20" readonly="readonly" value="${list.seq}"> 
	<br>
	<label for="empName">작성자 :</label>
	<input type="text" id="empName" name="empName" size="20" readonly="readonly" 
	<c:if test="${empty list.empNum }"> value="${empName }"</c:if>
	<c:if test="${not empty list.empNum }"> value="${list.empNum }"</c:if> >
	<br>
	<label for="signSubject">제목 :</label>
	<input type="text" id="signSubject" name="signSubject" size="20" value="${list.signSubject}">
	<br>
	<label for="signContent">내용:</label>
	<textarea rows="10" cols="20" id="signContent" name="signContent">
		${list.signContent }
	</textarea>
<br>
</form>
<input type="button" id="ban_btn" name="ban_btn" value="반려">
<input type="button" id="save_btn" name="save_btn" value="임시저장">
<input type="button" id="sing_btn" name="sing_btn" value="결재">

</body>
</html>