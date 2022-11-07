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
<!-- font awesome style -->
<link href="${contextRoot}/css/font-awesome.min.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="${contextRoot}/css/index_style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/104e2ed605.js"
	crossorigin="anonymous"></script>
<style>
.holder{
position: relative;
	top: 50px;
	left: 25%;
}
</style>

</head>

<body>




	<!-- navbar -->
	<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div class="holder">
		<c:forEach items="${list}" var="teamlist" varStatus="c">
		<c:choose>
			<c:when test="${c.count==1}"><h3>美聯東區</h3></c:when>
			<c:when test="${c.count==2}"><h3>美聯中區</h3></c:when>
			<c:when test="${c.count==3}"><h3>美聯西區</h3></c:when>
			<c:when test="${c.count==4}"><h3>國聯東區</h3></c:when>
			<c:when test="${c.count==5}"><h3>國聯中區</h3></c:when>
			<c:when test="${c.count==6}"><h3>國聯西區</h3></c:when>
		</c:choose>	
			<table class="table" style="width: 1000px">
				<thead>
					<tr>
						<th scope="col" width ="90px">排名</th>
						<th scope="col" width ="150px">隊伍名稱</th>
						<th scope="col">勝場</th>
						<th scope="col">敗場</th>
						<th scope="col">勝率</th>
						<th scope="col">勝差</th>
						<th scope="col">外卡勝差</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="team" items="${teamlist}" varStatus="s">
						<tr>
							<th scope="row">${s.count}</th>
							<td><img  src="${contextRoot}/showTeamImage/${team.teamId}" width="20px" ><a href="${contextRoot}/Team/showTeamInfo?id=${team.teamId}">${team.name}</a></td>
							<td>${team.win}</td>
							<td>${team.lose}</td>
							<td>${team.percent}</td>
							<td>${team.diff}</td>
							<td>${team.wcb}</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
			<br>
		</c:forEach>










	</div>
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