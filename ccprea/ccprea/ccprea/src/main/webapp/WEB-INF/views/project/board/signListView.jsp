<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href = /resources/css/jquery-ui.css type="text/css">

<script type="text/javascript">
	
	$(document).ready(function(){
	 	var msg = '${msg}';
		
		if(msg == 'SUCCESS'){
			alert('글쓰기 성공');
			
		}else if(msg == 'FAILED'){
			alert('글쓰기 실패');
		}
		
		$('#logoutBtn').click(function(){
			location.href ="/logout";
		})
		
		
		$('#sdate').datepicker({
			dateFormat: "yy-mm-dd",
			changeMonth: true, 
	         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
	         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
	         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		});
		
		$('#edate').datepicker({
			changeMonth: true, 
	         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
	         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
	         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			dateFormat: "yy-mm-dd"
		});

		
		$('#write_btn').click(function(){
			
			location.href="write";
			
		})
		
		
		$('#search_btn').click(function(){
			
			var frm = $('#frm_search')
			frm.attr("action","singList");
			frm.attr("method","POST");
			frm.submit();
			
		})
		
		
		$('select[id=sign_box]').change(function(){
			
			var optionSelected = $(this).find("option:selected");
		    var valueSelected  = optionSelected.val();
		    var textSelected   = optionSelected.text();
			
			$('form[id=frm_sign] input[name=sign_box]').attr("value",textSelected) ;
			$('#frm_sign').attr("action","singList");
			$('#frm_sign').attr("method","POST");
			$('#frm_sign').submit();
		})
	})
	
	function updateSignBoard(no){
		
		location.href = "write?no="+no;
		
	}

</script>

<title>결제 리스트</title>
</head>
<body>

<%-- 	<%
	String id = "";
	id = (String)session.getAttribute("empName");            // request에서 id 파라미터를 가져온다
	%>
	
	<%=id %>님 환영합니다.  --%>
	
	${empName }(${rankName})님 환영합니다 <input type="button" id="logoutBtn" value="로그아웃">
<br>
<div>
	<input type="button" value="글쓰기" id="write_btn" >
	
</div>
<br>
<form id = frm_sign>
	<input type="hidden" name="sign_box" >
</form>

<div style="margin: auto; ">
<form id="frm_search">
	<select name="search_box"> 
		<option value="all"<c:if test="${search_box == 'all'}"> selected="selected" </c:if> >선택</option>
		<option value="write" <c:if test="${search_box == 'write'}"> selected="selected" </c:if> >작성자</option>
		<option value="subject" <c:if test="${search_box == 'subject'}"> selected="selected" </c:if> >제목</option>
		<option value="singman" <c:if test="${search_box == 'singman'}"> selected="selected" </c:if> >결재자</option>
	</select>
	<input type="text" id="search_text" name="search_text" size="20"  value=${search_text }> 
	<select id="sign_box"> 
		<option value="all" <c:if test="${sign_box == '결재상태'}"> selected="selected" </c:if> >결재상태</option>
		<option value="save" <c:if test="${sign_box == '임시저장'}"> selected="selected" </c:if> >임시저장</option>
		<option value="wait" <c:if test="${sign_box == '결재대기'}"> selected="selected" </c:if> >결재대기</option>
		<option value="going" <c:if test="${sign_box == '결재중'}"> selected="selected" </c:if> >결재중</option>
		<option value="success" <c:if test="${sign_box == '결재완료'}"> selected="selected" </c:if> >결재완료</option>
		<option value="fail" <c:if test="${sign_box == '반려'}"> selected="selected" </c:if> >반려</option>
	</select>
	<br>
	<input type="text" id="sdate" name="sdate" value="${sdate }"> ~
	<input type="text" id="edate" name="edate" value="${edate }">
	<input type="button" id="search_btn" value="검색">
</form>
</div>

<div>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>결재일</td>
				<td>결재자</td>
				<td>결재상태</td>
			</tr>
		</thead>
			<tr>
			<c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                	
                   <tr onclick="updateSignBoard(${row.seq })">
                  
                    	<%-- <td style="text-align:center"><input type="checkbox" id='chk' name='chk' value='${row.seq }'></td> --%>
                    	<td>${row.seq }</td>
                        <td>${row.empNum }</td>
                        <td>${row.signSubject}</td>
                        <td><fmt:formatDate value="${row.regDate }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td><fmt:formatDate value="${row.signDate }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td>${row.signPerson }</td>
                        <td>${row.signState }</td>
   
                    </tr>
                    
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        	</c:choose>
			</tr>
		<tbody>
		</tbody>
		<tfoot>
		</tfoot>
	</table>

</div>

</body>
</html>