<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
 response.setHeader("Content-Disposition","attachment;filename=member.xls");
    response.setHeader("Content-Description", "JSP Generated Data");
%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href = /resources/css/jquery-ui.css type="text/css">



<script type="text/javascript">
	
	$(document).ready(function(){
	 	var msg = '${msg}';
		
		if(msg == 'SUCCESS'){
			alert('글쓰기 성공');
			
		}else if(msg == 'FAILED'){
			alert('글쓰기 실패');
		}
		
		$('#logoutBtn').click(function(){
			location.href ="/logout";
		})
		
		
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

		
		$('#write_btn').click(function(){
			
			location.href="write";
			
		})
		
		
		$('#search_btn').click(function(){
			
			var frm = $('#frm_search');
			frm.attr("action","singList");
			frm.attr("method","POST");
			frm.submit();
			
		})
		
		
		$('select[id=sign_box]').change(function(){
			
			var optionSelected = $(this).find("option:selected");
		    var valueSelected  = optionSelected.val();
		    var textSelected   = optionSelected.text();
			
			$('form[id=frm_sign] input[name=sign_box]').attr("value",textSelected) ;
			$('#frm_sign').attr("action","singList");
			$('#frm_sign').attr("method","POST");
			$('#frm_sign').submit();
		})
		
		
		 $( "#dialog" ).dialog({
		      autoOpen: false,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "blind",
		        duration: 1000
		      }
		    });
		 
		    $( "#sign_btn" ).on( "click", function() {
		      $( "#dialog" ).dialog( "open" );
		    });
		    
		 $('#sign_select').change(function(){
			 
			 
			 var optionSelected = $(this).find("option:selected");
			 var valueSelected  = optionSelected.val();
			 var textSelected   = optionSelected.text();
			
			 if(textSelected != '선택'){
					 
				 var rank_txt = $('#r_'+textSelected).val();
				 var deputy_txt = $('#d_'+textSelected).val();
				 var deputy_seq = $('#s_'+textSelected).val();
				 
				 $('#rank_txt').val(rank_txt);
				 $('#deputy_txt').val(deputy_txt);
				 $('#deputy_seq').val(deputy_seq);
			
			 }
			 
			 
		 })
		 
		 
		 
		 $('#btn_deputy').click(function(){
			
			 var deputydata = $('#deputy_seq').val();
			 
			$.ajax({
				
				data:deputydata,
				type:"POST",
				url:"/deputy",
				datatype:"text",
				success:function(data){
					
					alert('성공');
					
				},
				error:function(data){
					
					alert('실패');
				}
			
			});
			 
		 })
		
	})
	
	function updateSignBoard(no){
		
		location.href = "write?no="+no;
		
	}
	
	function exceldown(){
		
		
		location.href = "exceldown";
		
	}

</script>

<title>결제 리스트</title>
</head>
<body>

<%-- 	<%
	String id = "";
	id = (String)session.getAttribute("empName");            // request에서 id 파라미터를 가져온다
	%>
	
	<%=id %>님 환영합니다.  --%>
	
	${empName }(${rankName})님 환영합니다 <input type="button" id="logoutBtn" value="로그아웃">
<br>
<div>
	<input type="button" value="글쓰기" id="write_btn" >
	
	<c:if test="${rankSeq == '부장' or rankSeq =='과장' }">
		<input type="button" value="대리결재" id="sign_btn">
	</c:if>
	
	<input type="button" value="엑셀다운로드" onclick="exceldown()">
	
	<img width="10" height="10" src="C:\D\giantStudy\ccprea\ccprea\ccprea\src\main\webapp\resources\image\Hydrangeas.jpg" />
	
	
	
	<div id="dialog" title="대리결재 선택">
  	
  	<table>
  		<tr>
  			<td><label>대리결재자:</label></td>
  			<td>
  				<select id="sign_select">
  					<option value="all">선택</option>
	  			<c:forEach items="${emplist }" var="list" varStatus="status">
	  				<option value="${status.index }">${list.empName }</option>
	  			</c:forEach>
	  			</select>
  			</td>
  		</tr>
  			
  		<tr>
  			<td>
  				<label>직급:</label>
  			</td>
  			<td>
  				<input type="text" id="rank_txt" name="rank_txt" readonly="readonly">
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<label>대리자:</label>
  			</td>
  			<td>
  				<input type="text" id="deputy_txt" name="deputy_txt" readonly="readonly">
  			</td>
  		</tr>
  	</table>
  	
  		<c:forEach items="${emplist }" var="list" varStatus="status">
	  				<input type="hidden" id="r_${list.empName}" value="${list.rankSeq }">
	  				<input type="hidden" id="d_${list.empName}" value="${list.empName }">
	  				<input type="hidden" id="s_${list.empName}" value="${list.seq }">
	  	</c:forEach>
  	
  	
  	<form id="frm_deputy">
  		<input type="hidden" id="deputy_seq" name="deputy_seq" readonly="readonly">
  	</form>
  	
  	<input type="button" id="btn_close"  value="취소">
  	<input type="button" id="btn_deputy" value="승인">
	</div>

</div>
<br>
<form id = frm_sign>
	<input type="hidden" name="sign_box" >
</form>

<div style="margin: auto; ">
<form id="frm_search">
	<select name="search_box"> 
		<option value="all"<c:if test="${search_box == 'all'}"> selected="selected" </c:if> >선택</option>
		<option value="write" <c:if test="${search_box == 'write'}"> selected="selected" </c:if> >작성자</option>
		<option value="subject" <c:if test="${search_box == 'subject'}"> selected="selected" </c:if> >제목</option>
		<option value="singman" <c:if test="${search_box == 'singman'}"> selected="selected" </c:if> >결재자</option>
	</select>
	<input type="text" id="search_text" name="search_text" size="20"  value=${search_text }> 
	<select id="sign_box"> 
		<option value="all" <c:if test="${sign_box == '결재상태'}"> selected="selected" </c:if> >결재상태</option>
		<option value="save" <c:if test="${sign_box == '임시저장'}"> selected="selected" </c:if> >임시저장</option>
		<option value="wait" <c:if test="${sign_box == '결재대기'}"> selected="selected" </c:if> >결재대기</option>
		<option value="going" <c:if test="${sign_box == '결재중'}"> selected="selected" </c:if> >결재중</option>
		<option value="success" <c:if test="${sign_box == '결재완료'}"> selected="selected" </c:if> >결재완료</option>
		<option value="fail" <c:if test="${sign_box == '반려'}"> selected="selected" </c:if> >반려</option>
	</select>
	<br>
	<input type="text" id="sdate" name="sdate" value="${sdate }"> ~
	<input type="text" id="edate" name="edate" value="${edate }">
	<input type="button" id="search_btn" value="검색">
</form>
</div>

<div>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>결재일</td>
				<td>결재자</td>
				<td>결재상태</td>
			</tr>
		</thead>
			<tr>
			<c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                	
                   <tr onclick="updateSignBoard(${row.seq })">
                  
                    	<%-- <td style="text-align:center"><input type="checkbox" id='chk' name='chk' value='${row.seq }'></td> --%>
                    	<td>${row.seq }</td>
                        <td>${row.empNum }</td>
                        <td>${row.signSubject}</td>
                        <td><fmt:formatDate value="${row.regDate }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td><fmt:formatDate value="${row.signDate }" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td>${row.signPerson }</td>
                        <td>${row.signState }</td>
   
                    </tr>
                    
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        	</c:choose>
			</tr>
		<tbody>
		</tbody>
		<tfoot>
		</tfoot>
	</table>

</div>

</body>
</html>