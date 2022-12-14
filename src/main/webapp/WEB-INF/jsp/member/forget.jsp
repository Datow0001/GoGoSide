<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


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
<!-- responsive style -->
<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/104e2ed605.js"
	crossorigin="anonymous"></script>



<!-- Custom styles for this template -->
<link href="${contextRoot}/css/login_style.css" rel="stylesheet" />

</head>

<body>
	<form:form action="${contextRoot}/member/forget" method="POST"
		modelAttribute="member" enctype="multipart/form-data">
		<div id="block" class="w3lvide-content" data-vide-bg="images/freelan"
			data-vide-options="position: 0% 50%">
			<!-- /form -->
			<div class="workinghny-form-grid">
				<div class="main-hotair">
					<div class="content-wthree">
						<h1>??????????????????????????????</h1>



						<form:input type="text" class="text input1" path="userId"
							placeholder="????????????" autofocus="true" />
						<form:errors path="userId" cssClass="error"></form:errors>
						<form:input type="text" class="password input1" path="personId"
							placeholder="???????????????ID" />
						<form:errors path="password" cssClass="error"></form:errors>
						<button class="btn" type="submit">??????</button>
					</div>
				</div>

			</div>


			<!-- ???????????? -->
			<div class="copyright text-center">
				<p>
					&copy; <span></span> EEIT152GROUP 4th GOGOSIDE
				</p>
			</div>
			<!-- ????????????end -->

		</div>
		</div>
	</form:form>






</body>
<!-- jQery -->
<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
<!-- //js -->
<script src="${contextRoot}/js/jquery.vide.js"></script>
<!-- bootstrap js -->
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</html>