<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


				<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

				<!DOCTYPE html>
				<html>

				<head>
					<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
					<title>GoGoSide</title>
					<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
					<link rel="shortcut icon" href="favicon.ico">

					<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
					<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700" rel="stylesheet">

					<!-- Animate.css -->
					<link rel="stylesheet" href="${contextRoot}/css/animate.css">
					<!-- Icomoon Icon Fonts-->
					<link rel="stylesheet" href="${contextRoot}/css/icomoon.css">
					<!-- Bootstrap  -->
					<link rel="stylesheet" href="${contextRoot}/css/bootstrap.css">
					<!-- Flexslider  -->
					<link rel="stylesheet" href="${contextRoot}/css/flexslider.css">
					<!-- Flaticons  -->
					<link rel="stylesheet" href="${contextRoot}/fonts/flaticon/font/flaticon.css">
					<!-- Owl Carousel -->
					<link rel="stylesheet" href="${contextRoot}/css/owl.carousel.min.css">
					<link rel="stylesheet" href="${contextRoot}/css/owl.theme.default.min.css">
					<!-- Theme style  -->
					<link rel="stylesheet" href="${contextRoot}/css/memberCenter.css">

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

					<form:form action="${contextRoot}/personForm" method="POST" modelAttribute="member"
						enctype="multipart/form-data" Object="">

						<div id="colorlib-page">
							<div class="container-wrap">
								<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle" data-toggle="collapse"
									data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
								<aside id="colorlib-aside" role="complementary" class="border js-fullheight">
									<div class="text-center">
<!-- 										<div class="author-img" style="background-image: url(images/about.jpg);"></div> -->
										<div class="author-img" style="background-image: url(${contextRoot}/showUserImage);"></div>
										<h1 id="colorlib-logo"><a href="index.html">${member.userName }</a></h1>
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

								<div id="colorlib-main">

									<section class="colorlib-contact" data-section="contact">
										<div class="colorlib-narrow-content">
											<p>會員資料</p>
											<!-- 會員帳號  -->
											<div class="form-group">
												<div class="input-icon">
													<span
														class="fables-iconemail fables-input-icon mt-2 font-13"></span>

													<form:input type="text" path="userId" value="${member.userId }"
														class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
														placeholder="帳號" />
													<form:errors path="userId" cssClass="error"></form:errors>
													<span id="userIdError"></span>
												</div>
											</div>

											<!-- 名字群組 -->
											<div class="form-row form-group">
												<!-- 會員姓名 -->
												<div class="col-12 col-md-6 mb-4 mb-md-0">
													<div class="input-icon">
														<span
															class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
														<form:input type="text" path="userName" value="${member.userName }"
															class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
															placeholder="會員姓名" />
														<form:errors path="userName" cssClass="error">
														</form:errors>
														<span id="userNameError"></span>
													</div>
												</div>
												<!-- 會員暱稱 -->
												<div class="col-12 col-md-6">
													<div class="input-icon">
														<span
															class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
														<form:input type="text" path="nickName" value="${member.nickName }"
															class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
															placeholder="會員暱稱" />
														<form:errors path="nickName" cssClass="error">
														</form:errors>
														<span id="nickNameError"></span>
													</div>
												</div>
											</div>
											<form:input type="hidden" path="roles" value="${member.roles}" />
											<!-- 身分證 -->
											<div class="form-group">
												<div class="input-icon">
													<span
														class="fables-iconpassword fables-input-icon font-19 mt-1"></span>
													<form:input type="text" path="personId" value="${member.personId }"
														class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
														placeholder="身分證字號" />
													<form:errors path="personId" cssClass="error"></form:errors>
													<span id="personIdError"></span>
												</div>
											</div>
											<!-- 密碼 -->
											<div class="form-group">
												<div class="input-icon">
													<span
														class="fables-iconpassword fables-input-icon font-19 mt-1"></span>
													<form:input type="password" path="password" value="${member.password }"
														class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
														placeholder="密碼" />
													<form:errors path="password" cssClass="error">
													</form:errors>
													<span id="passwordError"></span>
												</div>
											</div>
											<!-- 信箱 -->
											<div class="form-group">
												<div class="input-icon">
													<span
														class="fables-iconpassword fables-input-icon font-19 mt-1"></span>
													<form:input type="email" path="mail" value="${member.mail }"
														class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
														placeholder="信箱" />
													<form:errors path="mail" cssClass="error"></form:errors>
													<span id="mailError"></span>
												</div>
											</div>
											<!-- 群組 -->
											<div class="form-row form-group">
												<!-- 生日 -->
												<div class="col-12 col-md-6 mb-4 mb-md-0">
													<div class="input-icon">
														<span
															class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
														<form:input type="date" path="birthday" value="${member.birthday }"
															class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
															placeholder="生日" />
														<form:errors path="birthday" cssClass="error">
														</form:errors>
														<span id="birthdayError"></span>
													</div>
												</div>

												<!-- 電話 -->
												<div class="col-12 col-md-6">
													<div class="input-icon">
														<span
															class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
														<form:input type="tel" path="phone" value="${member.phone }"
															class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
															placeholder="電話" />
														<form:errors path="phone" cssClass="error">
														</form:errors>
														<span id="phoneError"></span>
													</div>
												</div>
											</div>
<!-- 											--頭貼-- -->
											<span class="description"> <label for="">圖片：&nbsp;</label> <input
													type="file" name="profilo"/>
											</span>


											<button type="submit" id="edit"
												class="btn btn-block rounded-0 white-color fables-main-hover-background-color fables-second-background-color font-16 semi-font py-3">修改資料</button>

											<a href="${contextRoot}/">
												<button type="submit" id="edit"
													class="btn btn-block rounded-0 white-color fables-main-hover-background-color fables-second-background-color font-16 semi-font py-3">取消</button>
											</a>

											<div id="errorMsg"></div>



										</div>
									</section>
								</div>

							</div>


						</div><!-- end:colorlib-main -->
					</form:form>
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