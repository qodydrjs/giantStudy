<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">


	function delList(){
		
		$('#frm').attr("action","/listDelete");
		$('#frm').attr("method","post");
		$('#frm').submit();

	}
	
	function listview(){
		
		
		
		location.href="/listAll";
	}
	
	function listUpdate(){
		
		$('#frm').attr("action","/listUpdate");
		$('#frm').attr("method","post");
		$('#frm').submit();

	}

</script>

<title>List</title>
</head>
<body>

		<form id="frm" name="frm">
		
		<input type="hidden" id="no" name="no" value="${list.seq }">
		
		</form> 
		<label for="mem_id">아이디 : </label>
		<input type="text" id='mem_id' name='mem_id' value= '${list.mem_id }' >
		<br>
		<label for="mem_name">이름 : </label>
		<input type="text" id='mem_name' name='mem_name' value='${list.mem_name }'>
		<br>
		<label for="board_subject">제목 : </label>
		<input type="text" id='board_subject' name='board_subject' value='${list.board_subject }'>
		<br>
		<label for="board_content">내용 : </label>
		<textarea rows="5" cols="20" id="board_content" name="board_content">
			${list.board_content }
		</textarea>
		
		<br>
		
		<input type="button" id="list" name="list" value="목록" onclick="listview()">
		<input type="button" id="update" name="update" value="수정" onclick="listUpdate()">
		<input type="button" id="delete" name="delete" value="삭제" onclick="delList()">

</body>
</html>