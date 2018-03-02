<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	$(document).ready(function(){

		
		var result = '${msg}';
		
		if(result == 'SUCCESS'){
			alert("처리가 완료되었습니다.");
		}else if(result == 'FAILED'){
			alert("처리가 실패되었습니다.");
		}
		
		
	});
	

	function createList(){
		
		location.href="/listCreate"
		
	}

</script>

</head>
<body>


	<table border="1" bordercolor="black">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자(ID)</th>
            <th scope="col">제목</th>
            <th scope="col">등록일</th>
            <th scope="col">수정일</th>
            <th scope="col">조회수</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                        <td>${row.seq }</td>
                        <td>${row.mem_name}(${row.mem_id})</td>
                        <td><a href="/list?no=${row.seq }"> ${row.board_subject } </a></td>
                        <td><fmt:formatDate value="${row.reg_date }" pattern="yyyy-MM-dd"/> </td>
                        <td><fmt:formatDate value="${row.upt_date }" pattern="yyyy-MM-dd"/> </td>
                        <td>${row.view_cnt }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         
    </tbody>
</table>


	<input type="button" id="createlist" name="createList" value="글쓰기" onclick="createList()">

</body>
</html>