<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
<meta charset="UTF-8">
<title>NBA賽程</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css"> 
<link href="${contextRoot}/css/team/standing.css" rel="stylesheet">
<style>
.cardEach{
width: 1000px;}
</style>


</head>
<body>
<div class="content">
	
			
		<h3>明日賽程</h3>
		<div class="cardEach">
			<table class="table">
				<thead>
					<tr>
						<th scope="col" class="col1">主隊</th>
						<th scope="col" class="col1">客隊</th>
<!-- 						<th scope="col" class="col1">日期</th> -->
						<th scope="col" class="col1">時間</th>
											
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="team" varStatus="c">
						<tr>
							<td class="col1"><img class="teamImg" src="${team.homeImg}" width="100%" >${team.nhomeTeam}</td>
							<td class="col1"><img class="teamImg" src="${team.awayImg}" width="100%" >${team.nawayTeam}</td>
<%-- 							<td class="col1">${team.gameDate}</td> --%>

							<td class="col1">${team.point}</td>
							
						</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>	  
	










	</div>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript">



</script>
</body>
</html>