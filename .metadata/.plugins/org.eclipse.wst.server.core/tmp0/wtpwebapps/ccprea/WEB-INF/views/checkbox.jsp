<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Check Box</title>


<script  src="\resources\js\jquery-3.3.1.js"></script>


<script type="text/javascript">

	$(document).ready(function(){

		
		// id=check 체크시 <p class=checkBoxLabel> text 값 추가 및 삭제
		$('input[id=check]').click(function(){
			var ischecked = $(this).is(':checked');
			var text = $(this).val();
			
			
			if(ischecked){
				
				addCheckvalue(text);
				
			}else{
				$('.checkBoxLabel').text(deleteCheckvalue(text));
			}

				allCheckedBox($("input[id=check]:checked").length);
			
		});
		
		//id=check 전체 선택 및 해제
		$('input[id=allCheck]').click(function(){
			allCheckBoxChecked()		
		});
		
		
		//서브밋 버튼 클릭시 이벤트 발생
		$('#checkSubmit').click(function(){
			
			submitCheck();
			
		});


	});
	
	
	
	//<p> 태그안 text를 삽입
	function addCheckvalue(str){
		
		 $('.checkBoxLabel').append(str + ' ');
		 
   	}
	
	//<p>테그안 text ' ' 로 파싱 후 인자와 비교 후 삭제 
	function deleteCheckvalue(str){
		
		
		var strval = $('.checkBoxLabel').text();
		var checkValuseArr = strval.split(' ');
		var temp = '';
		
		for(var val=0; val < checkValuseArr.length-1; val++){
			
			if (checkValuseArr[val] == str){
				checkValuseArr[val]='';
				
				temp += '';
				
			}else{
				temp += checkValuseArr[val]+' '; 
			}
			
			
		}
		
		return temp;
		
		
	}
	
	//체크박스 전체 선택 및 해제
	function allCheckBoxChecked(){
		
		var ischecked = $('input[id=allCheck]').is(':checked');
		
		if(ischecked){
			
			$("input[id=check]").attr("checked",true);
			
			$('.checkBoxLabel').text( $('form table').text() );

		}else{
			
			$("input[id=check]").attr("checked",false);
			
			$('.checkBoxLabel').text('');
		}
	}
	
	// 체크박스가 9 개 전부 체크되면 전체 체크박스 란 활성화
	function allCheckedBox(num){
		
		var ischecked = num;
		
		if(ischecked == 9){
			
			$("input[id=allCheck]").prop("checked",true);


		}else{
			
			$("input[id=allCheck]").prop("checked",false);
		}
	}
	
	function submitCheck(){
		
		var checknum = $("input[id=check]:checked").length;
		
		if(checknum < 1){
			
			alert("항목을 선탹하세요");
			return;
		}
		
		else if( checknum < 5 || $('#allCheck').prop(':checked')){
			
			alert('성공');
		}else{
			
			alert('실패 4개 이하  또는 9개선택 해야함 ');
			
		
		}
		
		return;
		
	}




	// (div:eq(1) input[name=chk])
	
	

</script>
	

</head>
<body>


	<form id="checkForm">
	
	<input type="checkbox" id ="allCheck" > 전체선택
	<br>
	<br>
	
	<table>
		<tr>
			<td>
				<input type="checkbox" id="check" name="chk1" value="축구" > <label for= "chk1"> 축구 </label> 
			</td>
			<td>
				<input type="checkbox" id="check" name="chk2" value="농구"> <label for= "chk2"> 농구 </label> 
			</td>
			<td>
				<input type="checkbox" id="check" name="chk3" value="야구"> <label for= "chk3"> 야구 </label> 
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="check" value="컬링"> 컬링
			</td>
			<td>
				<input type="checkbox" id="check" value="아이스하키"> 아이스하키
			</td>
			<td>
				<input type="checkbox" id="check" value="보드"> 보드
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="check" value="승마"> 승마
			</td>
			<td>
				<input type="checkbox" id="check" value="투포환"> 투포환
			</td>
			<td>
				<input type="checkbox" id="check" value="양궁"> 양궁 
			</td>
		</tr>
	</table>
	
	<br>
	<br>
	
	<input type="button" value="등록" id="checkSubmit">
	</form>
	
	<p class="checkBoxLabel" ></p>


	

</body>
</html>