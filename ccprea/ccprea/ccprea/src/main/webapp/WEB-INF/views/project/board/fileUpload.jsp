<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>

<script src="/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
	
	$(function(){
	
		$("#add").click(function(){

			var file1 = $("#addfile1").html().length;
			var file2 = $("#addfile2").html().length;

			if(file1 == 0)
			$("#addfile1").html('파일2 : <input type="file" name="file1"><br>');
			else if(file2 == 0)
			$("#addfile2").html('파일3 : <input type="file" name="file2"><br>');
			
		});
		
		
	});
	

</script>

</head>
<body>
	<form id="frm" name="frm" enctype="multipart/form-data" action="uploadOk" method ="post">
	파일1 : <input type="file" name="file"><br>
	<div id="addfile1"></div>
	<div id="addfile2"></div>
	<input type="button" id="add" value="추가"> 최대 3개까지<br>
	<input type="submit">
	</form>
	
</body>
</html>