<%@page import="java.util.List"%>
<%@page import="com.project.vo.FileVO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int i=0; 
	String URL = "";
	String fileName="";
%>
	<table border="1">

	<c:forEach items="${list}" var="file" varStatus="status">
		
		<%
		
			List url = (List)request.getAttribute("list");
			FileVO vo  = (FileVO)url.get(i);
			URL = URLEncoder.encode(vo.getLocalfile(),"UTF-8");
			fileName = URLEncoder.encode(vo.getOrigName(),"UTF-8");
			i++;
		%>
		
		<tr>
			<td>${file.origName }</td>
			<td><img height="100px" src="${file.sfile }"/></td>
			<td><a  href="download?path=<%=URL %>&fileName=<%=fileName %>">Download</a></td>
		</tr>
	
	</c:forEach>
	</table>
</body>
</html>