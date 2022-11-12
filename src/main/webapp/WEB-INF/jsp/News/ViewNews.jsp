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
<title>新聞列表</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />


<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png"
	type="">
<title>GoGoSide</title>


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
<style>
.container {
	display: flex;
	justify-content: space-around;
}

.wrapper {
	width: 100%;
}

.main-content {
	min-height: 100%;
	padding-top: 8px;
	padding-bottom: 50px;
}

.footer {
	position: relative;
	bottom: 0;
	width: 100%;
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


				<div class="card mb-3" style="width: 950px; float: top">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${news.picFile}" class="img-fluid rounded-start"
								alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">
									<a
										href='${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}'>${news.newsTitle}</a>
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
			<div>
				<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups">
					<div class="btn-group me-2" role="group" aria-label="First group">
						<c:forEach var="num" begin="1" end="${page.totalPages}">
							<c:choose>
								<c:when test="${page.number+1 != num}">
									<a href="${contextRoot}/News/newsPage?p=${num}"><button
											type="button" class="btn btn-primary">${num}</button></a>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-info">${num}</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>


					</div>

				</div>


				<!-- 			========================================================= -->
				<%-- 				<c:forEach var="num" begin="1" end="${page.totalPages}"> --%>
				<%-- 					<c:choose> --%>
				<%-- 						<c:when test="${page.number+1 != num}"> --%>
				<%-- 							<a href="${contextRoot}/News/newsPage?p=${num}">${num}</a> --%>
				<%-- 						</c:when> --%>
				<%-- 						<c:otherwise>${num}</c:otherwise> --%>
				<%-- 					</c:choose> --%>
				<%-- 				</c:forEach> --%>

				<%-- 				<a href="${contextRoot}/getNews">getTodayNews</a> --%>
				<%-- 				<a href="${contextRoot}/getNBAnews">getTodayNewsNBA</a> --%>
				<%-- 				<a href="${contextRoot}/getHighLight">gethighLight</a> --%>
				<%-- 				<a href="${contextRoot}/News/searchNBA">seeNBA</a> --%>

				<%-- 				<form action="${contextRoot}/News/search" method="get"> --%>
				<!-- 					<textarea name="word" class="form-control"></textarea> -->
				<!-- 					<input type="submit" name="submit" value="送出"> -->
				<%-- 				</form> --%>
				<!-- 			========================================================= -->

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
<!-- jQery -->
<%-- 		<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
<!-- bootstrap js -->
<%-- 		<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>

</html>