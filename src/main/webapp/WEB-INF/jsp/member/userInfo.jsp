<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png"
	type="">
<title>GoGoSide</title>
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link
	href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="${contextRoot}/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="${contextRoot}/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="${contextRoot}/css/bootstrap.css">
<!-- Flexslider  -->
<link rel="stylesheet" href="${contextRoot}/css/flexslider.css">
<!-- Flaticons  -->
<link rel="stylesheet"
	href="${contextRoot}/fonts/flaticon/font/flaticon.css">
<!-- Owl Carousel -->
<link rel="stylesheet" href="${contextRoot}/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${contextRoot}/css/owl.theme.default.min.css">
<!-- Theme style  -->
<link rel="stylesheet" href="${contextRoot}/css/userInfo.css">

<!-- Modernizr JS -->
<script src="${contextRoot}/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
							<script src="js/respond.min.js"></script>
							<![endif]-->

</head>

<body>
	<!-- navbar -->
	<div id="navvv">
		<header class="header">
			<jsp:include page="../layout/navbar.jsp"></jsp:include>
		</header>
	</div>



	<div id="colorlib-page">
		<div class="container-wrap">
			<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar"><i></i></a>
			<aside id="colorlib-aside" role="complementary"
				class="border js-fullheight">
				<div class="text-center">
					<!-- 										<div class="author-img" style="background-image: url(images/about.jpg);"></div> -->
					<div class="author-img"
						style="background-image: url(${contextRoot}/PostUserImage/${member.userId});"></div>
					<h1 id="colorlib-logo">
						<a href="index.html">${member.userName}</a>
					</h1>
					<!-- 										<span class="position"><a href="#">UI/UX/Designer</a> in Philippines</span> -->
				</div>
				<nav id="colorlib-main-menu" role="navigation" class="navbar">
					<div id="navbar" class="collapse">
						<ul>
							<li class="active"><a href="#" data-nav-section="home">我追蹤的</a></li>
							<li><a href="#" data-nav-section="about">我的收藏</a></li>
							<li><a href="#" data-nav-section="services">我的文章</a></li>
							<li><a href="#" data-nav-section="contact">個人資訊</a></li>
						</ul>
					</div>
				</nav>


			</aside>

			<article class="article">
				<c:forEach var="forumPost" items="${page.content}">
					<div class="card">
						<a href="${contextRoot}/forum/ViewEachPost?p=${forumPost.postNo}"
							style="text-decoration: none">

							<table class="tablePost">
								<tr>
									<td class="userImg" rowspan="2"><img class="userIcon"
										src="${contextRoot}/PostUserImage/${forumPost.userId}">
									</td>
									<td class="userName" colspan="2">
										<div class="userName">
											${forumPost.teamName}隊版．${forumPost.userId}</div>
									</td>
									<td class="edit" rowspan="2">
										<%-- 										<a href="${contextRoot}/forum/edit?p=${forumPost.postNo}">修改</a> --%>
										<!-- 										｜ --> <!-- 										<a onclick="return confirm('確定刪除？')" -->
										<%-- 										   href="${contextRoot}/forum/delete?p=${forumPost.postNo}">刪除</a> --%>
									</td>
									<td class="forumImg" rowspan="4"><img class="forumIcon"
										src="${contextRoot}/showImage/${forumPost.postNo}"
										height="100%" width="100%"></td>
								</tr>
								<tr>
									<td class="forumTime" colspan="2">
										<div class="forumTime">
											<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE"
												value="${forumPost.postTime}" />
										</div>
									</td>
								</tr>
								<tr>
									<td class="forumTitle" colspan="4">${forumPost.postArticle}</td>
								</tr>
								<tr>
									<td class="forumContent" colspan="4">
										<div class="forumContent">${forumPost.postContent}</div>
									</td>
								</tr>
							</table>
							<table class="status">
								<tr>
									<td class="countsIcon"><img
										src="${contextRoot}/images/forumImages/like-icon.png"
										height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postLikes}</td>
									<td class="countsIcon"><img
										src="${contextRoot}/images/forumImages/comment-icon.png"
										height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postDislikes}</td>
									<td class="countsIcon"><img
										src="${contextRoot}/images/forumImages/view-icon.png"
										height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postViews}&nbsp;views</td>
									<td class="space">&nbsp;</td>
								</tr>
							</table>
						</a>
					</div>
				</c:forEach>

				<div class="pageNo">
					<c:forEach var="p" begin="1" end="${page.totalPages}">
						<c:choose>

							<c:when test="${page.number != p-1}">
								<span><a href="${contextRoot}/viewUserInfo?userId=violet0001&p=${p}">${p}</a></span>
							</c:when>

							<c:otherwise>
								<span id="thisPgNo">${p}</span>
							</c:otherwise>

						</c:choose>
					</c:forEach>
				</div>
			</article>


		</div>


	</div>
	<!-- end:colorlib-main -->

</body>

<!-- jQuery -->
<script src="${contextRoot}/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="${contextRoot}/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${contextRoot}/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="${contextRoot}/js/jquery.waypoints.min.js"></script>
<!-- Flexslider -->
<script src="${contextRoot}/js/jquery.flexslider-min.js"></script>
<!-- Owl carousel -->
<script src="${contextRoot}/js/owl.carousel.min.js"></script>
<!-- Counters -->
<script src="${contextRoot}/js/jquery.countTo.js"></script>


<!-- MAIN JS -->
<script src="${contextRoot}/js/main.js"></script>


</html>