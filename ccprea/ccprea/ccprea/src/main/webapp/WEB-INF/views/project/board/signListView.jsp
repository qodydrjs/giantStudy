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
	})
	
	function updateSignBoard(seq){
		
		location.href = "write?seq="+seq;
		
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
	
	${empName }님 환영합니다 <input type="button" id="logoutBtn" value="로그아웃">
<br>
<div>
	<input type="button" value="글쓰기" id="write_btn" >
	<input type="button" value="대리결제" id="deri_btn">
</div>
<br>
<div style="margin: auto; ">
	<select id="search_box"> 
		<option value="all">선택</option>
		<option value="write">작성자</option>
		<option value="subject">제목</option>
		<option value="singman">결재자</option>
	</select>
	<input type="text" id="search_text" name="search_text"  size="20"> 
	<select id="sign_box"> 
		<option value="all">결재상태</option>
		<option value="save">임시저장</option>
		<option value="wait">결재대기</option>
		<option value="going">결재중</option>
		<option value="success">결재완료</option>
	</select>
	<br>
	<input type="text" id="sdate" name="sdate" > ~
	<input type="text" id="edate" name="edate" >
	<input type="button" id="search_btn" value="검색">
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