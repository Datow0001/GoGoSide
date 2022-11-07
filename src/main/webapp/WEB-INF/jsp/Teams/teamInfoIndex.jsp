<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<style>
.nameAndStanding {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
}

.standing {
	position: relative;
	top: 50px;
}

.container {
	position: relative;
	top: 50px;
	right: 10px;
}
.newsholder{
	position: relative;
	top: 50px;
	left: 450px;
}
</style>
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>

	<div>
		<div class="nameAndStanding">
		<div><img src="${contextRoot}/showTeamImage/${team.teamId}" height="150px"></div>
			
			<div class="standing">
				<span style="font-size: 30px">${fullname}</span>
				<table class="table" style="width: 1000px">

					<thead>
						<tr>

							<!-- 								<th scope="col">隊伍名稱</th> -->
							<th scope="col">勝場</th>
							<th scope="col">敗場</th>
							<th scope="col">勝率</th>
							<th scope="col">勝差</th>
							<th scope="col">外卡勝差</th>
						</tr>
					</thead>
					<tbody>
						<tr>

							<%-- 								<td><img src="${contextRoot}/showTeamImage/${team.teamId}" --%>
							<%-- 									height="20px" width="20px">${team.name}</td> --%>
							<td>${team.win}</td>
							<td>${team.lose}</td>
							<td>${team.percent}</td>
							<td>${team.diff}</td>
							<td>${team.wcb}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 			------------------------------ -->
		<div class="newsholder" style="margin-right: 50px">
			<h2>近期新聞</h2>
			<c:forEach var="news" items="${page.content}">


				<div class="card mb-3" style="width: 950px; float: top">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${news.picFile}" class="img-fluid rounded-start"
								alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">
									<a
										href='${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}'>${news.newsTitle}</a>
								</h5>
								<p class="card-text">${news.shortIndex}</p>
								<p class="card-text">
									<small class="text-muted"><span><fmt:formatDate
												pattern="yyyy-MM-dd" value="${news.newsDate}" /></span></small>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- ------------------------			 -->
		<div class="container">
			<h2>球員數據</h2>
			<hr>
			<h3>野手</h3>
			<hr>
			<table id="Ftable_id" class="display">
				<thead>

				</thead>
				<tbody>

				</tbody>
			</table>

		</div>

		<div class="container">
			<h3>投手</h3>
			<hr>
			<table id="Ptable_id" class="display">
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
    $('#Ftable_id').DataTable({
    	"ajax":"http://localhost:8080/my-app/Team/teamFInfo?num="+${team.teamId},
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
$(document).ready( function () {
    $('#Ptable_id').DataTable({
    	"ajax":"http://localhost:8080/my-app/Team/teamPInfo?num="+${team.teamId},
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