<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png"
	type="">
<title>Standing</title>


<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css"
	href="${contextRoot}/css/bootstrap.css" />
<!--owl slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
<!-- nice select  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
	integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
	crossorigin="anonymous" />

<!-- Custom styles for this template -->
<link href="${contextRoot}/css/index_style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />

<link href="${contextRoot}/css/team/teamInfo.css" rel="stylesheet">

	<style>
		@font-face {
			src: url(../../fonts/jf-openhuninn-1.1.ttf);
			font-family: font1;
		}
		
		* {
			margin: 0;
			padding: 0;
		}
		
		body {
			width: 100vw;
		}
		
		.content {
			width: 90vw;
			margin-left: 5vw;
			font-family: font1, Verdana, Geneva, Tahoma, sans-serif;
		}
	</style>

</head>

<body>

	<!-- navbar -->
	<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>

	<div>&nbsp;</div>
	<div class="content">
		<table id="table_id" class="display">
			<thead>

			</thead>
			<tbody>

			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		    $('#table_id').DataTable({
		    	"ajax":'http://localhost:8080/my-app/FielderStat1',
		    	"columns":[
		    		{data:'fielderName',title:'球員名稱',},
		    		{data:'fielderPos',title:'守備位置',},
		    		{data:'team',title:'球隊',},
		    		{data:'gamePlayed',title:'總場數',},
		    		{data:'ab',title:'打數',},
		    		{data:'hit',title:'安打',},
		    		{data:'sbh',title:'二壘安打',},
		    		{data:'tbh',title:'三壘安打',},
		    		{data:'hr',title:'全壘打',},
		    		{data:'rbi',title:'打點',},
		    		{data:'bb',title:'保送',},
		    		{data:'so',title:'三振',},
		    		{data:'sb',title:'盜壘',},
		    		{data:'cs',title:'盜壘刺',},
		    		{data:'avg',title:'打擊率',},
		    		{data:'obp',title:'上壘率',},
		    		{data:'slg',title:'長打率',},
		    		{data:'ops',title:'攻擊指數',},
		    	]
		    });
		} );
	</script>

</body>
</html>