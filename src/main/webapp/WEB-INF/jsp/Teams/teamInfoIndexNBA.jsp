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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
<link href="${contextRoot}/css/team/teamInfoIndex.css" rel="stylesheet">
</head>
<body>
	<div id="navvv">
		<header class="header">
			<jsp:include page="../layout/navbar.jsp"></jsp:include>
		</header>
	</div>
	<div>
		<div class="content">
			<div class="cardLeft">
				<table class="tableLeft">
					<tr>
						<td rowspan="2"><img class="teamImg" src="${team.teamImageSrc}" height="100%" ></td>
						<td><span class="secondTitle">&nbsp;${fullname}</span></td>
					</tr>
					<tr>
						<td><span class="secondTitle">&nbsp;本季戰績</span></td>
					</tr>
				</table>
			</div>
			
			
			<div class="cardRight">
				<table class="teamInfo">

					<thead>
						<tr>
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
			</div>
		</div>


		<div>
			<div class="title"><img class="icon" src="${contextRoot}/images/forumImages/basketball-icon.jpg" width="100%">&nbsp;近期新聞</div>
			<c:forEach var="news" items="${page.content}">
				<div class="card mb-3" id="cardNews">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${news.picFile}" class="img-fluid rounded-start" id="newsImg" height="100%" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">
									<a href='${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}'>${news.newsTitle}</a>
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

		<div class="title"><img class="icon" src="${contextRoot}/images/forumImages/basketball-icon.jpg" width="100%">&nbsp;球員數據</div>
		<div class="cardStat">
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
		$(document)
				.ready(
						function() {
							$('#table_id')
									.DataTable(
											{
												"ajax" : "http://localhost:8080/my-app/NBAPlayerStatInINfo?name=${team.teamName}",
												"columns" : [ {
													data : 'playerName',
													title : '球員名稱',
												}, {
													data : 'pos',
													title : '位置',
												}, {
													data : 'team',
													title : '球隊',
												}, {
													data : 'age',
													title : '年齡',
												}, {
													data : 'game',
													title : '出賽數',
												}, {
													data : 'gameStarted',
													title : '先發數',
												}, {
													data : 'mp',
													title : '上場分鐘數',
												}, {
													data : 'fg',
													title : '出手命中數',
												}, {
													data : 'fga',
													title : '出手數',
												}, {
													data : 'fgperc',
													title : '命中率',
												}, {
													data : 'threefg',
													title : '三分球命中數',
												}, {
													data : 'threefga',
													title : '三分球出手數',
												}, {
													data : 'threefgperc',
													title : '三分球命中率',
												}, {
													data : 'twofg',
													title : '兩分球命中數',
												}, {
													data : 'twofga',
													title : '兩分球出手數',
												}, {
													data : 'twofgperc',
													title : '兩分球命中率',
												}, {
													data : 'efg',
													title : '有效命中率',
												}, {
													data : 'ft',
													title : '罰球命中數',
												}, {
													data : 'fta',
													title : '罰球出手數',
												}, {
													data : 'ftperc',
													title : '罰球命中率',
												}, {
													data : 'orb',
													title : '進攻籃板',
												}, {
													data : 'drb',
													title : '防守籃板',
												}, {
													data : 'trb',
													title : '總籃板',
												}, {
													data : 'ast',
													title : '助攻',
												}, {
													data : 'stl',
													title : '抄截',
												}, {
													data : 'blk',
													title : '火鍋',
												}, {
													data : 'tov',
													title : '失誤',
												}, {
													data : 'pf',
													title : '犯規',
												}, {
													data : 'pts',
													title : '得分',
												}, ]
											});
						});
	</script>
</body>
</html>