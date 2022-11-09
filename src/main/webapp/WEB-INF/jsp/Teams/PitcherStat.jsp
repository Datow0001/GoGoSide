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
	
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
		    $('#table_id').DataTable({
		    	"ajax":'http://localhost:8080/my-app/PitcherStat1',
		    	"columns":[
		    		{data:'pitcherName',title:'球員名稱',},
		    		{data:'pitcherPos',title:'守備位置',},
		    		{data:'team',title:'球隊',},
		    		{data:'win',title:'勝場數',},
		    		{data:'lose',title:'敗場數',},
		    		{data:'era',title:'防禦率',},
		    		{data:'game',title:'出賽數',},
		    		{data:'gameStart',title:'先發數',},
		    		{data:'cg',title:'完投數',},
		    		{data:'sho',title:'完封數',},
		    		{data:'sv',title:'救援成功',},
		    		{data:'svo',title:'救援機會',},
		    		{data:'ip',title:'局數',},
		    		{data:'hit',title:'被安打',},
		    		{data:'run',title:'被得分',},
		    		{data:'er',title:'自責分',},
		    		{data:'hr',title:'被全壘打',},
		    		{data:'hb',title:'觸身球',},
		    		{data:'bb',title:'保送',},
		    		{data:'so',title:'三振數',},
		    		{data:'whip',title:'每局被上壘率',},
		    		{data:'avg',title:'被打擊率',},
		    	]
		    });
		} );
	</script>
</body>
</html>