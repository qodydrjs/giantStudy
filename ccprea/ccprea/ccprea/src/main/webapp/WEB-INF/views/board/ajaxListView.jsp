<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/resources/js/jquery-3.3.1.js"></script>


	<table border="1" bordercolor="black">

    <thead>
        <tr>
        	<th scope="col">선택<br>
        		<input type="checkbox" id='chkall' name='chkall' > 
        	</th>
            <th scope="col">글번호</th>
            <th scope="col">작성자(ID)</th>
            <th scope="col">제목</th>
            <th scope="col">등록일</th>
            <th scope="col">수정일</th>
            <th scope="col">조회수</th>
        </tr>
    </thead>
    <tbody>
    	<form id="fmtDel", name="fmtDel">
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                    	<td style="text-align:center"><input type="checkbox" id='chk' name='chk' value='${row.seq }'></td>
                        <td>${row.seq }</td>
                        <td>${row.mem_name}(${row.mem_id})</td>
                        <td><a href="/list${pageMaker.makeQuery(pageMaker.cri.page) }&no=${row.seq }"> ${row.board_subject } </a></td>
                        <td><fmt:formatDate value="${row.reg_date }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td><fmt:formatDate value="${row.upt_date }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td>${row.view_cnt }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         </form>
    </tbody>
</table>

	<c:if test="${pageMaker.prev == true}">
   <a href="/listAll?page=1" > &lt;&lt; </a>
   <a href="/listAll?page=${pageMaker.startPage -pageMaker.cri.perPageNum }" > &lt; </a>
   </c:if>
   
	<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" varStatus="status">
		<a href="/listAll?page=${status.index}" > ${status.index} </a>
	</c:forEach>
	
	<c:if test="${pageMaker.next == true}">
	     <a href="/listAll?page=${pageMaker.startPage + pageMaker.cri.perPageNum }" > > </a>
   		<a href="/listAll?page=${pageMaker.totalCount }" > >> </a>
   </c:if>

