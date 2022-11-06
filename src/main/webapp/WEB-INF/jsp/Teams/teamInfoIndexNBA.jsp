<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>
<div>
<span>${team.teamName}</span>
<table class="table" style="width: 1000px">

				<thead>
					<tr>
						
						<th scope="col">隊伍名稱</th>
						<th scope="col">勝場</th>
						<th scope="col">敗場</th>
						<th scope="col">勝率</th>
						<th scope="col">勝差</th>
						<th scope="col">每場得分</th>
						<th scope="col">每場失分</th>
						<th scope="col">得失分差</th>
						<th scope="col">主場</th>
						<th scope="col">客場</th>
						<th scope="col">近況</th>
						<th scope="col">近十場</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							
							<td><img  src="${team.teamImageSrc}" height="20px" width="20px">${team.teamName}</td>
							<td>${team.win}</td>
							<td>${team.lose}</td>
							<td>${team.percent}</td>
							<td>${team.gb}</td>
							<td>${team.ppg}</td>
							<td>${team.oppg}</td>
							<td>${team.diff}</td>
							<td>${team.home}</td>
							<td>${team.road}</td>
							<td>${team.strk}</td>
							<td>${team.lastTen}</td>
						</tr>
</tbody>
</table>

<div class="container">
		<table id="table_id" class="display">
			<thead>

			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	

</div>
<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
	    $('#table_id').DataTable({
	    	"ajax":"http://localhost:8080/my-app/NBAPlayerStatInINfo?name=${team.teamName}",
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