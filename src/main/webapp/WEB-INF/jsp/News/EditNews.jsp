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
<title>EditNews</title>
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>

	<div class="container">
	<form:form action="${contextRoot}/News/postEditNews" method="post" modelAttribute="News">
	<form:input type="hidden" path="newsNumber" />
	<form:input type="hidden" path="newsDate" />
	<form:input type="hidden" path="newsClickCount" />
	<form:input type="hidden" path="picTitle" />
	<form:input type="hidden" path="picFile" />
	<form:input type="hidden" path="shortIndex" />
	<form:textarea path="newsTitle" class="form-control"/>
	<form:textarea path="newsIndex" class="form-control"/>
	<input type="submit" name="submit" value="送出">
	</form:form>
	</div>





</body>
</html>