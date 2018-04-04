<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>

<style type="text/css">

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}


.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */

</style>


<script type="text/javascript">

	function test(data){
		var id = "txt"+data.id;
		//var div = document.getElementById(id);
		$('#'+id).html(data.title);

	}
	
	function listViewOpen(){
		
		location.href="/boards/boardList";
	}

</script>

<title>나의 장바구니</title>
</head>
<body>

<input class="button button5" type="button" value="상품 목록으로" onclick="listViewOpen()">

<c:set var="tempOrderNum" value="" />
<c:set var="count" value="f" />
	<table class="type09">
		<!-- <tr>
			<th>이미지</th>
			<th>이름</th>
			<th>정보</th>
			<th>금액</th>
			<th>판매자</th>
			<th>주문수량</th>
		<tr> -->
	
		<c:choose>
			<c:when test="${fn:length(list) > 0 }">
				
					<c:forEach items="${list }" var="row" varStatus="status">
					
						<c:if test="${tempOrderNum != row.orderNum }">
						
							<c:choose>
								<c:when test="${count == 'f'}">
									<c:set var="count" value="t" />
								</c:when>
								<c:otherwise>
									<th colspan="6"></th>
								</c:otherwise>
							</c:choose>
						
							<tr>
								<th> 주문번호 : ${row.orderNum }  </th>
								<th colspan="5"><input class="button button3" type="button" value="주문취소"></th>
								<c:set var="tempOrderNum" value="${row.orderNum }" />
							</tr>
							<tr>
								<th>이미지</th>
								<th>이름</th>
								<th>정보</th>
								<th>금액</th>
								<th>판매자</th>
								<th>주문수량</th>
							<tr>
							
							
						
						</c:if>

					
						<!--  ${row.seq } &nbsp;-->
						<tr>
						<td><img height="70px" src="${row.goodsImageUrl }"/></td>
						<td>${row.goodsName } </td>
						<c:choose>
							<c:when test="${fn:length(row.goodsInfo) > 5}">
								<td>
								<div id="txt${status.index }">${fn:substring(row.goodsInfo,0,4) }...<a href="" onclick="test(this);return false;" title="${row.goodsInfo }" id="${status.index }">더보기</a>
								</div>
								</td>
							</c:when>
							<c:otherwise>
								<td>${row.goodsInfo } </td>
							</c:otherwise>
						</c:choose>
						<td>${row.goodsPrice } </td>
						<td>${row.goodsSeller } </td>
						<td>${row.quantity } </td>
						<!-- ${row.empNum } &nbsp;
						${row.goodsSeq } &nbsp;
						
						 -->
						 
						 </tr>
					</c:forEach>
			
			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">장바구니 내역이 없습니다.</td>
				</tr>
			</c:otherwise>
		
		</c:choose>
	
	</table>

</body>
</html>