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
		
		$('#ban_btn').click(function(){
			
			$('#h_save_btn').attr("name","");
			$('#h_sing_btn').attr("name","");
			
			var frmObj = $('form[id=sign_frm]');
			
			frmObj.attr("action","write")
			frmObj.attr("method","POST");
			frmObj.submit();
			
		})
	
	})
	
	function SignYN(){
		
		alert(10);
		
	}

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
			결재요청:
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
		<!--아래의 체크박스 signlist 를 Foreach 문으로 재 구현 필요 -->
		<tr>
			<th>
				<c:if test="${empty signlist[0].SIGN_YN }"> 
					<input type="checkbox" disabled="disabled"> 
				</c:if>
				<c:if test="${not empty signlist[0].SIGN_YN }"> 
					<c:if test="${signlist[0].SIGN_YN == 'Y' }">
						<input type="checkbox" checked="checked" disabled="disabled"> 
					</c:if>
				</c:if>
			</th>
			<th>
				<c:if test="${empty signlist[1].SIGN_YN }"> 
					<input type="checkbox" disabled="disabled"> 
				</c:if>
				<c:if test="${not empty signlist[1].SIGN_YN }"> 
					<c:if test="${signlist[1].SIGN_YN == 'Y' }">
						<input type="checkbox" checked="checked" disabled="disabled"> 
					</c:if>
				</c:if>
			</th>
			<th>
				<c:if test="${empty signlist[2].SIGN_YN }"> 
					<input type="checkbox" disabled="disabled"> 
				</c:if>
				<c:if test="${not empty signlist[2].SIGN_YN }"> 
					<c:if test="${signlist[2].SIGN_YN == 'Y' }">
						<input type="checkbox" checked="checked" disabled="disabled"> 
					</c:if>
				</c:if>
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
<input type="hidden" id="h_listsyate" name="h_listsyate" value="${list.signState }">


	<table>
		<tr>
			<td><label for="seq">번호 :</label></td>
			<td>
				<c:if test ="${not empty list.seq}" >
				<input type="text" id="seq" name="seq" size="20" readonly="readonly" value="${list.seq}" >
				</c:if>
				<c:if test ="${empty list.seq}" > 
					<input type="text" id="e_seq" name="e_seq" size="20" readonly="readonly" value="결재를 작성하세요" >
					<input type="hidden" id="seq" name="seq" size="20" readonly="readonly" value="0" >
				</c:if> 
			</td>
		
		</tr>
		<tr>
				<td>
					<label for="empName">작성자 :</label>
				</td>
				<td>
				
					<input type="text" id="empName" name="empName" size="20" readonly="readonly" 
					<c:if test="${empty list.empNum }"> value="${empName }"</c:if>
					<c:if test="${not empty list.empNum }"> value="${list.empNum }"</c:if> >
				</td>
		</tr>
		<tr>
			<td><label for="signSubject">제목 :</label></td>
			<td><input type="text" id="signSubject" name="signSubject" size="20" value="${list.signSubject}">
		</td>
		</tr>
		<tr>
			<td><label for="signContent">내용:</label></td>
			<td><textarea rows="10" cols="20" id="signContent" name="signContent">${list.signContent }</textarea></td>
		</tr>
	
	</table>
<br>
</form>
<c:if test ="${not empty list.seq}" >
		<c:if test ="${list.empNum != empName}" >
			<input type="button" id="ban_btn" name="ban_btn" value="반려">
		</c:if>
		<input type="button" id="sing_btn" name="sing_btn" value="결재">
</c:if>
<c:if test ="${empty list.seq}" > 
	<input type="button" id="save_btn" name="save_btn" value="임시저장">
	<input type="button" id="sing_btn" name="sing_btn" value="결재">
</c:if> 



<c:forEach items="${ signlist}" var="list">
	<c:if test ="${list.EMP_NUM  == empNum}">
			<c:if test ="${list.SIGN_YN == 'Y'}"> 
						<script>
						
							$('body input').attr('readonly','readonly');
							$('body textarea').attr('readonly','readonly');
							$('#ban_btn').prop('disabled',true);
							$('#sing_btn').prop('disabled',true);
							$('#save_btn').prop('disabled',true);
							
							
						</script>
			</c:if>
	</c:if>
</c:forEach>

</body>
</html>