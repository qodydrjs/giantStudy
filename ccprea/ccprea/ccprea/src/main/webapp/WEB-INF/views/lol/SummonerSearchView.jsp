<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/resources/js/jquery-3.3.1.js"></script>


<script type="text/javascript">

	$(document).ready(function(){
	
		
		$("#btn_search").click(function(){
			
			var str_id = $('#summonerID').val();
			
			//var urls = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+encodeURIComponent(str_id);
			//var urls = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/ccprea?api_key=RGAPI-b13b412b-03dc-4dd3-af28-26b7c342b272";
			
			$.ajax({
				
				 data:{
							 "api_key":"RGAPI-b13b412b-03dc-4dd3-af28-26b7c342b272"
							,"id": str_id
					  }
				,type:"GET"
				,url:"search"
				,datatype:"json"
				,success : function(data, status, xhr){ 
						//console.log(data); 
						
						var text = "";
						
						text += "accountId : "+data.accountId +"<br>";
						
						if(data.profileIconId == "1644"){
							
							text += "profileIconId : <img height='50px' src='http://opgg-static.akamaized.net//images//profile_icons//profileIcon1644.jpg'> <br> "; 
							
						}else{
							text += "profileIconId : "+data.profileIconId +"<br>";
						}
						
						
						text += "revisionDate : "+data.revisionDate +"<br>";
						text += "name : "+data.name +"<br>";
						text += "id : "+data.id +"<br>";
						text += "summonerLevel : "+data.summonerLevel +"<br>";
						
						$('#SearchView').html(text);
						
					}, 
				error: function(jqXHR, textStatus, errorThrown){ 
						//console.log(jqXHR.responseText); 
					}

			});
			
		});
		
	});
	

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	소환사 아이디 : <input type="text" id ="summonerID" >
	<input type="button" id="btn_search" value="검색">

	<div id="SearchView"></div>

</body>
</html>