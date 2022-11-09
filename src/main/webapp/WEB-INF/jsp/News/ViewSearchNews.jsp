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
<title>ViewSearchNews</title>
<style>
 .container{ 
 display: flex; 
 justify-content: space-around;
 } 

</style>

</head>
<body>
	<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>


	<div class="container">
		

		<div class="newsholder" style="margin-right: 50px">
			<h1>新聞列表</h1>
			<c:forEach var="news" items="${page.content}">


				<div class="card mb-3" style="width: 950px;float: top"> 
					<div class="row g-0" >
						<div class="col-md-4">
							<img src="${news.picFile}" class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><a href='${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}'>${news.newsTitle}</a></h5>
								<p class="card-text">${news.shortIndex}</p>
								<p class="card-text">
									<small class="text-muted"><span><fmt:formatDate pattern="yyyy-MM-dd" value="${news.newsDate}" /></span></small>
								</p>
							</div>
						</div>
					</div>
				</div>



			</c:forEach>
			<div>
<%-- 			<c:forEach var="num" begin="1" end="${page.totalPages}"> --%>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${page.number+1 != num}"> --%>
<%-- 						<a href="${contextRoot}/News/search${type}?p=${num}">${num}</a> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise>${num}</c:otherwise> --%>
<%-- 				</c:choose> --%>
<%-- 			</c:forEach> --%>
<!-- 		-------------------------	 -->
<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups">
					<div class="btn-group me-2" role="group" aria-label="First group">
						<c:forEach var="num" begin="1" end="${page.totalPages}">
							<c:choose>
								<c:when test="${page.number+1 != num}">
									<a href="${contextRoot}/News/search${type}?p=${num}"><button
											type="button" class="btn btn-primary">${num}</button></a>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-info">${num}</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>


					</div>

				</div>
<!-- 		----------------- -->
			<form action="${contextRoot}/News/search" method="get">
			<textarea name="word" class="form-control" ></textarea>
			<input type="submit" name="submit" value="送出">
			</form>
			
		</div>
		</div>
		<div class="hnews">
			<h5>熱門新聞</h5>
			<c:forEach var="hotnews" items="${top}">
				<div class="card" style="width: 18rem; margin-top: 10px;">
					<a href='${contextRoot}/News/ViewNewsPage?id=${hotnews.newsNumber}'><img
						class="card-img-top" src="${hotnews.picFile}" alt="Card image cap"></a>

					<div class="card-body">
						<p class="card-text" style="font-size: 12px">
							<a
								href='${contextRoot}/News/ViewNewsPage?id=${hotnews.newsNumber}'>${hotnews.newsTitle}</a>
							<fmt:formatDate value="${hotnews.newsDate}" pattern="yyyy/MM/dd" />
						</p>
					</div>
				</div>
			</c:forEach>



		</div>
		
		
	</div>

	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>