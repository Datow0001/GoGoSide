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
<title>TeamInfo</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<div>
		<c:forEach items="${list}" var="teamlist">
			<table class="table" style="width: 1000px">
				<thead>
					<tr>
						
						<th scope="col">隊伍名稱</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="team" items="${teamlist}" varStatus="s">
						<tr>
							
							<td><a href="${contextRoot}/Team/showTeamInfo?id=${team.teamId}"><img  src="${contextRoot}/showTeamImage/${team.teamId}" height="20px" width="20px">${team.name}</a></td>
							
						</tr>
					</c:forEach>


				</tbody>
			</table>
			<br>
		</c:forEach>










	</div>

</body>
</html>