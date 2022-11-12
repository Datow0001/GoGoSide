<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
	<meta charset="UTF-8">
	<title>NBA球隊資訊</title>
	<link href="${contextRoot}/css/team/teamInfo.css" rel="stylesheet">
</head>
<body>
	<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>
	<div class="content">
	<div id="title"><img id="icon" src="${contextRoot}/images/forumImages/basketball-icon.jpg" width="100%">&nbsp;NBA 球隊資訊</div>
		<c:forEach items="${list}" var="teamlist">
			<span class="cardEach">
			<table>
				<thead>
					<tr>	
						<th scope="col" id="th">
						<c:forEach items="${teamlist}" var="team" begin="0" end="0">
						<c:choose>
						<c:when test="${team.teamDiv=='EAST'}">
						東區
						</c:when>
						<c:when test="${team.teamDiv=='WEST'}">
						西區
						</c:when>
						</c:choose>
						</c:forEach></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="team" items="${teamlist}" varStatus="s">
						<tr>
							<td class="teamName">
								<img class="teamImg" src="${team.teamImageSrc}" width="100%">
							</td>
							<td class="teamName">
								<a href="${contextRoot}/Team/showNBATeamInfo?name=${team.teamName}">
								${team.teamName}</a>
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