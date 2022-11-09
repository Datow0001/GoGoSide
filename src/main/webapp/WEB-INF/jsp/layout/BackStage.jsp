<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>backstage</title>
</head>
<body>
	<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>


	<a href="${contextRoot}/Team/getTeam">getStanding--取得MLB球隊戰績</a>
	<br>
	<a href="${contextRoot}/Team/updateStanding">updateStanding--更新MLB球隊戰績</a>
	<br>
	<a href="${contextRoot}/Team/getImg">getImg--從靜態資源取得MLB隊徽</a>
	<br>
	<a href="${contextRoot}/Player/GetFielder">GetFielderStat--取得MLB野手數據</a>
	<br>
	<a href="${contextRoot}/Player/GetPitcher">GetPitcherStat--取得MLB投手數據</a>
	<br>
	<a href="${contextRoot}/Team/getNBAteam">GetNBAStat--取得NBA球隊戰績</a>
	<br>
	<a href="${contextRoot}/Team/updateNBAteam">updateNBAStat--更新NBA球隊戰績</a>
	<br>
	<a href="${contextRoot}/NBAPlayer/get">updateNBAPlayerStat--取得NBA球員數據</a>
	<br>
	<a href="${contextRoot}/Team/getNBAsch">updateNBAschdule--取得NBA賽程</a>
	<br>
	-------------------------------------------------------------------------------
	<br>
	<a href="${contextRoot}/getNews">getTodayNews--取得今天的MLB新聞</a>
	<br>
	<a href="${contextRoot}/getNBAnews">getTodayNewsNBA--取得今天的NBA新聞</a>
	<br>
	<a href="${contextRoot}/getHighLight">gethighLight--取得HIGHTLIGHT</a>
	<br>
	<a href="${contextRoot}/News/searchNBA">seeNBA--NBA新聞葉面</a>
	<br>

	<a href="${contextRoot}/Schedule">schedule</a>
	<br>
	<a href="${contextRoot}/getSchedule">GETTTT</a>
	<br>
	<a href="${contextRoot}/NBAgetSchedule">GETTTT</a>
<%-- 	<a href="${pageContext.request.contextPath}/getSchedule1">GETTTsssssT</a> --%>
</body>
</html>