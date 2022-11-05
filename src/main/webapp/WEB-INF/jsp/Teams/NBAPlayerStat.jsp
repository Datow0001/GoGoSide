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
<title>Stat</title>


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

<style>
</style>

</head>

<body>




	<!-- navbar -->
	<jsp:include page="../layout/navbar.jsp"></jsp:include>


	<div class="container">
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
    	"ajax":'http://localhost:8080/my-app/NBAPlayerStat1',
    	"columns":[
    		{data:'playerName',title:'球員名稱',},
    		{data:'pos',title:'位置',},
    		{data:'team',title:'球隊',},
    		{data:'age',title:'年齡',},
    		{data:'game',title:'出賽數',},
    		{data:'gameStarted',title:'先發數',},
    		{data:'mp',title:'上場分鐘數',},
    		{data:'fg',title:'出手命中數',},
    		{data:'fga',title:'出手數',},
    		{data:'fgperc',title:'命中率',},
    		{data:'threefg',title:'三分球命中數',},
    		{data:'threefga',title:'三分球出手數',},
    		{data:'threefgperc',title:'三分球命中率',},
    		{data:'twofg',title:'兩分球命中數',},
    		{data:'twofga',title:'兩分球出手數',},
    		{data:'twofgperc',title:'兩分球命中率',},
    		{data:'efg',title:'有效命中率',},
    		{data:'ft',title:'罰球命中數',},
    		{data:'fta',title:'罰球出手數',},
    		{data:'ftperc',title:'罰球命中率',},
    		{data:'orb',title:'進攻籃板',},
    		{data:'drb',title:'防守籃板',},
    		{data:'trb',title:'總籃板',},
    		{data:'ast',title:'助攻',},
    		{data:'stl',title:'抄截',},
    		{data:'blk',title:'火鍋',},
    		{data:'tov',title:'失誤',},
    		{data:'pf',title:'犯規',},
    		{data:'pts',title:'得分',},
    	]
    });
} );

</script>

</body>
</html>