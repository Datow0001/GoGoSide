<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge" />
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
			<meta name="keywords" content="" />
			<meta name="description" content="" />
			<meta name="author" content="" />


			<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
			<title>GoGoSide</title>


			<!-- bootstrap core css -->
			<link rel="stylesheet" type="text/css" href="${contextRoot}/css/bootstrap.css" />
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
			<script src="https://kit.fontawesome.com/104e2ed605.js" crossorigin="anonymous"></script>


		</head>

		<body>


			<div class="wrapper">

				<div id="navvv">
					<header class="header">
						<jsp:include page="layout/navbar.jsp"></jsp:include>
					</header>
				</div>



				<div class="main-content">

					<div id="test002">
						<jsp:include page="${contextPath}/preNews"></jsp:include>
					</div>
					<div id="zz">
						<jsp:include page="${contextPath}/highlight"></jsp:include>
					</div>
					<!-- news -->
					<div id="preNBA">
						<jsp:include page="${contextPath}/preNBAsc"></jsp:include>
					</div>

				</div>




				<footer class="footer">
					<!-- footer -->
					<jsp:include page="layout/footer.jsp"></jsp:include>
				</footer>
			</div>



		</body>
		<!-- jQery -->
		<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
		<!-- bootstrap js -->
		<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

		</html>