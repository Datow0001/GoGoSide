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

	<!-- news -->
	<section class="slider_section ">

		<!-- 文字 -->
		<div class="carousel-inner">
			<!-- 選單 -->

			<div id="customCarousel1" class="carousel slide" data-ride="carousel">

				<div class="tit">
					<span>熱門新聞</span>
					<ul class="filters_menu">
						<li class="active" data-filter="*">棒球</li>
						<li data-filter=".burger">車隊</li>
						<li data-filter=".pizza">大聯盟</li>
						<li data-filter=".pasta">小聯盟</li>

					</ul>



				</div>
				<!-- part1 -->
				<div class="carousel-item active">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
									<h3>${news.newsTitle}</h3>
									<p>${news.shortIndex}</p>
									<div class="btn-box">
										<a href="${contextRoot}/News/ViewNewsPage?id=${news.newsNumber}" class="btn1"> 點我看更多 </a>
									</div>
								</div>
							</div>
							<div class="col-sm-7 col-xl-6">
								<div class="slp">
									<img src="${news.picFile}" width="500px" alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- part2 -->
				<div class="carousel-item ">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">


									<h3>${news2.newsTitle}</h3>
									<p>${news2.shortIndex}</p>
									<div class="btn-box">
										<a href="${contextRoot}/News/ViewNewsPage?id=${news2.newsNumber}" class="btn1"> 點我看更多 </a>
									</div>
								</div>
							</div>
							<div class="col-sm-7 col-xl-6">
								<div class="slp">
									<img src="${news2.picFile}" width="500px" class="d-block w-100"
										alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- part3 -->
				<div class="carousel-item">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">

									<h3>${news3.newsTitle}</h3>
									<p>${news3.shortIndex}</p>
									<div class="btn-box">
										<a href="${contextRoot}/News/ViewNewsPage?id=${news3.newsNumber}" class="btn1"> 點我看更多 </a>
									</div>
								</div>
							</div>
							<div class="col-sm-7 col-xl-6">
								<div class="slp">
									<img src="${news3.picFile}" width="500px" class="d-block w-100"
										alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>

<!-- 豆豆 -->
		<div class="container">
			<ol class="carousel-indicators">
				<li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
				<li data-target="#customCarousel1" data-slide-to="1"></li>
				<li data-target="#customCarousel1" data-slide-to="2"></li>
			</ol>
		</div>
			</div>
		</div>
		


	</section>
</body>

<!-- jQery -->
<!-- jQery -->
<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
<!-- bootstrap js -->
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</html>