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
<title>MLB球隊資訊</title>
<link href="${contextRoot}/css/team/teamInfo.css" rel="stylesheet">
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
</head>
<body>
<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>
	<div class="content">
		<div id="title"><img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">&nbsp;MLB 球隊資訊</div>
		<c:forEach items="${list}" var="teamlist">
			<span class="cardEach">
				
					<table>
						<thead>
							<tr>
								<th scope="col" id="th"><c:forEach items="${teamlist}" var="team" begin="0" end="0">
								<c:choose>
								<c:when test="${team.place=='AL East'}">
								美聯東區
								</c:when>
								<c:when test="${team.place=='AL West'}">
								美聯西區
								</c:when>
								<c:when test="${team.place=='AL Central'}">
								美聯中區
								</c:when>
								<c:when test="${team.place=='NL East'}">
								國聯東區
								</c:when>
								<c:when test="${team.place=='NL West'}">
								國聯西區
								</c:when>
								<c:when test="${team.place=='NL Central'}">
								國聯中區
								</c:when>
								</c:choose>
								</c:forEach></th>
							</tr>
						</thead>
	
						<tbody>
							<c:forEach var="team" items="${teamlist}" varStatus="s">
								<tr>
									<td>
										<img class="teamImg" src="${contextRoot}/showTeamImage/${team.teamId}" width="100%">
									</td>
									<td class="teamName">
										<a class="teamName" href="${contextRoot}/Team/showTeamInfo?id=${team.teamId}">${team.name}</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</span>
			
		</c:forEach>
	</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>