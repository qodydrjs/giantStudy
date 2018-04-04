<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/jquery-3.3.1.js"></script>
<style type="text/css">
	input[type=checkbox] {
  transform: scale(2.5);
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

	

	$(document).ready(function(){
		
		var f = 1;
		var msg = '${msg}';
		
		if(msg =="SUCSSES" && f == 1){
			alert(msg);
			f = 2;
		}
		
		
		$('#btn_logout').click(function(){
			
			location.href="/loginc/logout";
			
		});
		
		$('#btn_Basket').click(function(){
			
			location.href="/boards/myshoppingBasketList";
			
		});
		
		
		$('#btn_insertBasket').click(function(){
			
			var frm_data = $('#frm_shoppingList').serialize();
			
			$.ajax({
				data:frm_data
				,type:"POST"
				,url:"/boards/insertMyShoppingBasket"
				,datatype:"text"
				,success : function(data){
					alert(data);
					golist();
				}
				,error : function(data){
					alert("error!!!!");
				}
	
			});
		});
		
		
	});
	
	
	function golist(){
		
		location.href="/boards/myshoppingBasketList";
		
	}
	
</script>
</head>
<body>

<% 
	String id =request.getSession().getValue("id").toString();
%>


<%=id %> 님 환영합니다.

<input class="button button1" type="button" id="btn_logout" value="logout">&nbsp;&nbsp;
<input class="button button2"  type="button" id="btn_insertBasket" value="장바구니 담기">&nbsp;&nbsp;
<input class="button button3"  type="button" id="btn_Basket" value="장바구니">

<form id="frm_shoppingList">
<table border="1px">
	
	<tr>
		<td>상품선택	</td>
		<td>
			상품이미지
		</td>
		<td>
			상품이름
		</td>
		<td>
			상품정보
		</td>
		<td>
			상품수량
		</td>
		<td>
			상품금액
		</td>
		<td>
			판매자
		</td>
	</tr>

	<c:choose>
		<c:when test="${fn:length(list) >0}">
			<c:forEach items="${list }" var="list">
				<tr>
					
					<td>
						<input   type="checkbox" style="width:50px;height50px" name="seq" id="seq" value="${list.seq }">
					</td>
					<td>
						<img height="80px" src="${list.goodsImageUrl }"/>
					</td>
					<td>
						${list.goodsName }
					</td>
					<td>
						${list.goodsInfo }
					</td>
					<td>
						${list.goodsQuantity }
					</td>
					<td>
						${list.goodsPrice }
					</td>
					<td>
						${list.goodsSeller }
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">
					상품이없습니다.
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
</form>


</body>
</html>