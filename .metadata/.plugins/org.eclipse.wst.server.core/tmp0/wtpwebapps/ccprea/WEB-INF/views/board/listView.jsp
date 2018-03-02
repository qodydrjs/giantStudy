<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">


	function delList(){

		$('#del').submit();

	}
	
	function listview(){
		location.href="/listAll";
	}
	
	function listUpdate(){
		location.href="/listUpdate";
	}

</script>

<title>List</title>
</head>
<body>

		<form id="del" name="del" action="/listDelete" method="POST">
		
		<input type="hidden" id="no" name="no" value="${list.seq }">
		
		</form> 
		${list.mem_id }
		<br>
		${list.mem_name }
		<br>
		${list.board_subject }
		<br>
		${list.board_content }
		<br>
		
		<input type="button" id="list" name="list" value="목록" onclick="listview()">
		<input type="button" id="update" name="update" value="수정" onclick="listUpdate()">
		<input type="button" id="delete" name="delete" value="삭제" onclick="delList()">

</body>
</html>