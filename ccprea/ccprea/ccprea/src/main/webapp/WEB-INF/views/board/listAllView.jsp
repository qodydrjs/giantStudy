<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href = /resources/css/jquery-ui.css type="text/css">
<link rel="stylesheet" href = /resources/css/bootstrap-theme.min.css type="text/css">
<link rel="stylesheet" href = /resources/css/bootstrap.min.css type="text/css">
<script type="text/javascript">

	$(document).ready(function(){

		
		var box = '${combobox}';
		
		if(box != null){
			if(box=="작성자")
				$('select[id=combobox] option[id=op1]').attr("selected",true);
			else if(box=="제목")
				$('select[id=combobox] option[id=op2]').attr("selected",true);
			else if(box=="제목+내용")
				$('select[id=combobox] option[id=op3]').attr("selected",true);
				
		}

		
		var result = '${msg}';
		
		if(result == 'SUCCESS'){
			alert("처리가 완료되었습니다.");
		}else if(result == 'FAILED'){
			alert("처리가 실패되었습니다.");
		}
		
		
		
		$('input[name=chkall]').click(function(){
			
			var chk = $('#chkall').is(':checked');
			
			
			if(chk){
				
				$('input[id=chk]').attr("checked",true);
				
			}else{
				$('input[id=chk]').attr("checked",false);
			}
			
		});
		
		$('#checkDelete').click(function(){
			
			if(!confirm("선택된 리스트를 삭제하시겠습니까?")){
				 return 
			}

			var chklen = $('input[name=chk]:checked').length;
			
			
			
			if(chklen <= 0){
				alert('선택된 리스트가 없습니다. 삭제할 대상을 선택하세요')
				return;
			}else{
				
				$('#fmtDel').attr("action","/listDelete");
				$('#fmtDel').attr("method","POST");
				$('#fmtDel').submit();
				
			}
			
		});
		
			$('#sdate').datepicker({
				dateFormat: "yy-mm-dd",
				changeMonth: true, 
		         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
		         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
			});
			
			$('#edate').datepicker({
				changeMonth: true, 
		         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
		         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				dateFormat: "yy-mm-dd"
			});
			
			$('#serch_btn').click(function(){
				
			/* 	$('#frm_serch').attr("action","/listAll");
				$('#frm_serch').attr("method","GET");
				$('#frm_serch').submit(); */
				
				var datas = $('#frm_serch').serialize();
				
				
				$.ajax({
				
					data:datas,
					type:"post",
					url:"ajaxList",
					datatype:"html",
					success:function(data){
						$('#ajaxList').html(data);
					},
					error:function(){
					}
					
				});
				
				
				
			});
	});

	function createList(){
		
		location.href="/listCreate"
		
	}

</script>

</head>
<body>
	<div class="container">
	<div id ="ajaxList">
	<table class="table table-striped" >
    <thead>
        <tr>
        	<th scope="col">선택<br>
        		<!-- <input type="checkbox" id='chkall' name='chkall' >  -->
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



	
	</div>
	<div class="row">
		<div class="col-md-2" >
			<input type="button" class="btn btn-sm btn-primary" id="createlist" name="createList" value="글쓰기" onclick="createList()">
			<input type="button" class="btn btn-sm btn-danger" id="checkDelete" name="checkDelete" value="삭제" >
		</div>
		<div class="col-md-1">
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
		</div>
		<div class="col-md-10">
			<form id="frm_serch" name="frm_serch" class="form-inline">
			<div class="form-group">
			<select id="combobox" name="combobox" class="form-control input-sm" >
				<option value="" >선택</option>
				<option value="작성자" id="op1">작성자</option>
				<option value="제목" id="op2">제목</option>
				<option value="제목+내용" id="op3">제목+내용</option>
			</select>
			</div>
			<div class="form-group">
			<input type="text" class="form-control input-sm" id="serch_text" name="serch_text" value="${serch_text }" >
			</div>
			<div class="form-group">
			<input type="button" class="btn btn-sm btn-info" id="serch_btn" name="serch_btn" value="검색">
			</div>
			<div class="form-group">
			<input type="text" class="form-control input-sm" id="sdate" name="sdate" value="${sdate }">
			</div>
			<div class="form-group">
			<input type="text" class="form-control input-sm" id="edate" name="edate" value="${edate }">
			</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>