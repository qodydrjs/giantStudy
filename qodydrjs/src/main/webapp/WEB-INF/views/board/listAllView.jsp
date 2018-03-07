<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board</title>
</head>
<body>
	<table border="1">
	
		<th>ㅂㅂㅂ</th>
		<th>ㅂㅂㅂ</th>
		<th>ㅂㅂㅂ</th>
		<th>ㅂㅂㅂ</th>
		<th>ㅂㅂㅂ</th>
		<th>ㅂㅂㅂ</th>
		
		<c:forEach items="${list }" var="row">
		<tr>
			<td>${row.title }</td>
			<td>${row.content }</td>
			<td>${row.writer }</td>
			<td><fmt:formatDate value="${row.regdate }" pattern="yyyy/MM/dd"/> </td>
			<td><fmt:formatDate value="${row.modifydate }" pattern="yyyy/MM/dd"/> </td>
			<td>${row.viewcnt }</td>
		</tr>	
		</c:forEach>
		
	
	</table>
</body>
</html>