<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$('#checkCreate').click(function(){

			$('#wirte').submit();
			
		})	
		
	});
	
</script>
<title>게시글 작성</title>
</head>
<body>

	<Form id="wirte" name="wirte" method="post" action="/listCreate">
		
		<label for="mem_id">작성자:</label>
		<input type="text" id="mem_id" name="mem_id">
		<br>
		<label for="mem_name">ID:</label>
		<input type="text" id="mem_name" name="mem_name">
		<br>
		<label for="board_subject">제목:</label>
		<input type="text" id="board_subject" name="board_subject"> 
		<br>
		<label for="board_content">내용:</label>
		<input type="text" id="board_content" name="board_content"> 
		
	</Form>

	<input type="button" id="checkCreate" name="checkCreate" value="완료">
</body>
</html>