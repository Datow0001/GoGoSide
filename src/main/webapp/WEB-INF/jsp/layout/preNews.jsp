<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>

<link rel="shortcut icon" href=" ${contextRoot}/images/gogosideLogo.png"
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

<!-- responsive style -->
<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/104e2ed605.js"
	crossorigin="anonymous"></script>


<!-- Custom styles for this template -->
<link href="${contextRoot}/css/preNews_style.css" rel="stylesheet" />

</head>

<body>
	<div class="con">

		<!-- news -->
		<section class="slider_section ">
			<!-- 文字 -->
			<div class="carousel-inner">


				<div id="customCarousel1" class="carousel slide"
					data-ride="carousel">
					<!-- 選單 -->
					<div class="iii">
						<!-- <ul class="filters_menu">
								<li class="active" data-filter="*">棒球</li>
								<li data-filter=".burger">車隊</li>
								<li data-filter=".pizza">大聯盟</li>
								<li data-filter=".pasta">小聯盟</li>
								<li data-filter=".fries">小棒球</li>
							</ul> -->
						<div>
							<span class="tit">熱門新聞</span>
						</div>
						<!-- 豆豆 -->
						<div class="container">
							<ol class="carousel-indicators">
								<li data-target="#customCarousel1" data-slide-to="0"
									class="active"></li>
								<li data-target="#customCarousel1" data-slide-to="1"></li>
								<li data-target="#customCarousel1" data-slide-to="2"></li>
							</ol>
						</div>
						<!-- part1 -->
						<c:forEach items="${list}" var="news" varStatus="s">
							<c:choose>
							<c:when test="${s.count==1}">
								<div class="carousel-item active">
							</c:when>
							<c:when test="${s.count!=1}">
								<div class="carousel-item">
							</c:when>
							</c:choose>
							<div class="container ">
								<div class="row1">

									<div>
										<div class="detail-box">
											<h3>${news.newsTitle}</h3>
											<div class="corr"
												style="display: inline-flex; margin-bottom: 25px;">
												<div id=" imgdiv">
													<img src="${news.picFile}"
														style="width: 100%; aspect-ratio: 2.5/2; object-fit: cover;"
														alt="...">
												</div>
												<p>${news.shortIndex}</p>
											</div>
											<div class="btn-box">
												<a class="prNewsa"
													href="${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}">點我看更多
												</a>
											</div>

										</div>
									</div>
								</div>
							</div>
					</div>

					</c:forEach>



					
				</div>
			</div>
	</div>

	</section>
	<!-- 新聞 -->
	<div id="aa">
		<div class=".newss" style="width: inherit; list-style-type: none;">
			<span>最新新聞</span> <br> 
			<c:forEach items="${hotlist}" var="hotnews" varStatus="s">
			<a href="${contextRoot}/News/ViewNewsPage?id=${hotnews.newsNumber}">${hotnews.newsTitle}</a>
			<br>
				</c:forEach>
		</div>

	</div>

	</div>

</body>

<!-- jQery -->
<!-- jQery -->
<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
<!-- bootstrap js -->
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</html>