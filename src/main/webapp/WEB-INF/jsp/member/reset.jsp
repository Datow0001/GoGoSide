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


	<form:form action="${contextRoot}/member/reset" method="POST"
		modelAttribute="member" enctype="multipart/form-data">
		<div id="block" class="w3lvide-content" data-vide-bg="images/freelan"
			data-vide-options="position: 0% 50%">
			<!-- /form -->
			<div class="workinghny-form-grid">
				<div class="main-hotair">
					<div class="content-wthree">
						<h1>輸入新密碼</h1>



						<form:input type="password" class="password input1" path="password"
							placeholder="密碼" autofocus="true"  />
						<form:errors path="password" cssClass="error"></form:errors>


						<form:input type="hidden" path="userId" value="${member.userId}"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="帳號" />
						<form:errors path="userId" cssClass="error"></form:errors>



						<!-- 名字群組 -->


						<form:input type="hidden" path="userName"
							value="${member.userName }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="會員姓名" />

						<form:input type="hidden" path="nickName"
							value="${member.nickName }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="會員暱稱" />
						<form:errors path="nickName" cssClass="error">
						</form:errors>

						<form:input type="hidden" path="personId"
							value="${member.personId }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="身分證字號" />
						<form:errors path="personId" cssClass="error"></form:errors>
						<form:input type="hidden" path="mail" value="${member.mail }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="信箱" />
						<form:errors path="mail" cssClass="error"></form:errors>

						<form:input type="hidden" path="birthday"
							value="${member.birthday }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="生日" />
						<form:errors path="birthday" cssClass="error">
						</form:errors>
						<form:input type="hidden" path="phone" value="${member.phone }"
							class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
							placeholder="電話" />
						<form:errors path="phone" cssClass="error">
						</form:errors>
						<button class="btn" type="submit">送出</button>
					</div>
				</div>

			</div>


			<!-- 版權聲明 -->
			<div class="copyright text-center">
				<p>
					&copy; <span></span> EEIT152GROUP 4th GOGOSIDE
				</p>
			</div>
			<!-- 版權聲明end -->

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