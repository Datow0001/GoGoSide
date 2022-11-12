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


<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png"
	type="">
<title>MLB戰績</title>


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
<!-- font awesome style -->
<link href="${contextRoot}/css/font-awesome.min.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="${contextRoot}/css/index_style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/104e2ed605.js"	crossorigin="anonymous"></script>
	
<link href="${contextRoot}/css/team/standing.css" rel="stylesheet">

</head>

<body>

	<!-- navbar -->
	<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>
	<div class="content">
		<c:forEach items="${list}" var="teamlist" varStatus="c">
			<c:choose>
				<c:when test="${c.count==1}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 美聯東區</div>
				</c:when>
				<c:when test="${c.count==2}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 美聯中區</div>
				</c:when>
				<c:when test="${c.count==3}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 美聯西區</div>
				</c:when>
				<c:when test="${c.count==4}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 國聯東區</div>
				</c:when>
				<c:when test="${c.count==5}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 國聯中區</div>
				</c:when>
				<c:when test="${c.count==6}">
					<div class="title">
					<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
					&nbsp;MLB 戰績 > 國聯西區</div>
				</c:when>
			</c:choose>	
			<div class="cardEach">
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="col1">排名</th>
							<th scope="col" class="col2">隊伍名稱</th>
							<th scope="col" class="col1">勝場</th>
							<th scope="col" class="col1">敗場</th>
							<th scope="col" class="col1">勝率</th>
							<th scope="col" class="col1">勝差</th>
							<th scope="col" class="col1">外卡勝差</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="team" items="${teamlist}" varStatus="s">
							<tr>
								<th scope="row" class="col1">${s.count}</th>
								<td class="col3">
									<img class="teamImg" src="${contextRoot}/showTeamImage/${team.teamId}" width="100%" >
									<a href="${contextRoot}/Team/showTeamInfo?id=${team.teamId}">
									${team.name}</a>
								</td>
								<td class="col1">${team.win}</td>
								<td class="col1">${team.lose}</td>
								<td class="col1">${team.percent}</td>
								<td class="col1">${team.diff}</td>
								<td class="col1">${team.wcb}</td>
							</tr>
						</c:forEach>
	
	
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>
<%-- 	<a href="${contextRoot}/Team/getTeam">getStanding</a> --%>
<%-- 	<a href="${contextRoot}/Team/updateStanding">updateStanding</a> --%>
<%-- 	<a href="${contextRoot}/Team/getImg">getImg</a> --%>

<%-- 	<a href="${contextRoot}/Player/GetFielder">GetFielderStat</a> --%>
<%-- 	<a href="${contextRoot}/Player/GetPitcher">GetPitcherStat</a> --%>


<%-- 	<a href="${contextRoot}/Team/getNBAteam">GetNBAStat</a> --%>
<%-- 	<a href="${contextRoot}/Team/updateNBAteam">updateNBAStat</a> --%>
<%-- 	<a href="${contextRoot}/NBAPlayer/get">updateNBAPlayerStat</a> --%>
</body>


<!-- jQery -->
<%-- <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
<!-- bootstrap js -->
<%-- <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>

</html>