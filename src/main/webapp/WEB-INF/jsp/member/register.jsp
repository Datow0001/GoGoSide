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
<link href="${contextRoot}/css/register_style.css" rel="stylesheet" />

<script type="text/javascript">
	function setFocusToUserId() {
		document.forms[0].userId.focus();
	}
</script>

<style type="text/css">
.error{
color:red
}
</style>

</head>

<body onLoad="setFocusToUserId()">
		<c:set var="funcName" value="REG" scope="session"></c:set>

	<form:form action="${contextRoot}/addMember" method="POST"
		modelAttribute="newMember" enctype="multipart/form-data"
		Object="member">
		<div class="container">
			<div class="row my-4 my-lg-5">
				<div
					class="col-12 col-md-10 offset-md-1 col-lg-6 offset-lg-3 text-center">
					<h1 class="font-20 semi-font fables-main-text-color mt-4 mb-5">????????????GoGoSide?????????</h1>


					<div class=error>${errorSavaData}<br>
					</div>

					<!-- ???????????? -->
					<div class="form-group">
						<div class="input-icon">
							<span class="fables-iconemail fables-input-icon mt-2 font-13"></span>
							<form:input type="text" path="userId"
								class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
								placeholder="??????" />
							<form:errors path="userId" cssClass="error"></form:errors>
							<span id="userIdError"></span>
						</div>
					</div>

					<!-- ???????????? -->
					<div class="form-row form-group">
						<!-- ???????????? -->
						<div class="col-12 col-md-6 mb-4 mb-md-0">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="text" path="userName"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="????????????" />
								<form:errors path="userName" cssClass="error"></form:errors>
								<span id="userNameError"></span>
								<ul class="hint">
									<li>1.????????????2.??????2?????????3.??????????????????</li>
								</ul>

							</div>
						</div>
						<!-- ???????????? -->
						<div class="col-12 col-md-6">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="text" path="nickName"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="????????????" />
								<form:errors path="nickName" cssClass="error"></form:errors>
								<span id="nickNameError"></span>
							</div>
						</div>
					</div>




					<!-- ????????? -->
					<div class="form-group">
						<div class="input-icon">
							<span class="fables-iconpassword fables-input-icon font-19 mt-1"></span>
							<form:input type="text" path="personId"
								class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
								placeholder="???????????????" />
							<form:errors path="personId" cssClass="error"></form:errors>
							<span id="personIdError"></span>
						</div>
					</div>

					<!-- ???????????? -->
					<div class="form-row form-group">
						<!-- ?????? -->
						<div class="col-12 col-md-6 mb-4 mb-md-0">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="password" path="password"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="??????" />
								<form:errors path="password" cssClass="error"></form:errors>
								<span id="passwordError"></span>
								<ul class="hint">
									<li class="hint">6?????????(?????????????????????????????????)</li>
								</ul>
							</div>
						</div>

						<!-- ?????????????????? -->
						<div class="col-12 col-md-6">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="password" path="passwordAgain"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="??????????????????" />
								<form:errors path="passwordAgain" cssClass="error"></form:errors>
								<span id="passwordAgainError"></span>
							</div>
						</div>
					</div>

					<!-- ?????? -->
					<div class="form-group">
						<div class="input-icon">
							<span class="fables-iconpassword fables-input-icon font-19 mt-1"></span>
							<form:input type="email" path="mail"
								class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
								placeholder="??????" />
							<form:errors path="mail" cssClass="error"></form:errors>
							<span id="mailError"></span>
						</div>
					</div>


					<!-- ?????? -->
					<div class="form-row form-group">
						<!-- ?????? -->
						<div class="col-12 col-md-6 mb-4 mb-md-0">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="date" path="birthday"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="??????" />
								<form:errors path="birthday" cssClass="error"></form:errors>
								<span id="birthdayError"></span>
							</div>
						</div>

						<!-- ?????? -->
						<div class="col-12 col-md-6">
							<div class="input-icon">
								<span
									class="fables-iconuser-register fables-input-icon mt-2 font-13"></span>
								<form:input type="tel" path="phone"
									class="form-control rounded-0 py-3 pl-5 font-13 sign-register-input"
									placeholder="??????" />
								<form:errors path="phone" cssClass="error"></form:errors>
								<span id="phoneError"></span>
							</div>
						</div>
					</div>



					<button type="submit" id="sendData"
						class="btn btn-block rounded-0 white-color fables-main-hover-background-color fables-second-background-color font-16 semi-font py-3">????????????</button>
					<span id="sendDataError"></span>
					
					<div id="errorMsg"></div>
					<a href="#"
						class="fables-forth-text-color font-16 fables-second-hover-color underline mt-3 mb-4 mb-lg-5 d-block">Forgot
						Password ?</a>
					<p class="fables-forth-text-color">
						Already have an account ? <a href="signin.html"
							class="font-16 semi-font fables-second-text-color underline fables-main-hover-color ml-2">Login</a>
					</p>





				</div>
			</div>

		</div>
	</form:form>


	<!-- copyright-->
	<div class="copyright text-center">
		<p>
			&copy; <span></span> EEIT152GROUP 4th GOGOSIDE
		</p>
	</div>
	<!-- //copyright-->





	<script>
		// var hasError = false;
		// window.onload = function () {
		// 	var sendData = document.getElementById("sendData");
		// 	sendData.onclick = function () {
		// 		hasError = false;
		// 		var userIdValue = document.getElementById("userId").value;
		// 		var userNameValue = document.getElementById("userName").value;
		// 		var nickNameValue = document.getElementById("nickName").value;
		// 		var idValue = document.getElementById("id").value;
		// 		var passwordValue = document.getElementById("password").value;
		// 		var passwordAgainValue = document.getElementById("passwordAgain").value;
		// 		var mailValue = document.getElementById("mail").value;
		// 		var birthdayValue = document.getElementById("birthday").value;
		// 		var phoneValue = document.getElementById("phone").value;

		// 		var userIdError = document.getElementById("userIdError");
		// 		var userNameError = document.getElementById("userNameError");
		// 		var nickNameError = document.getElementById("nickNameError");
		// 		var idError = document.getElementById("idError");
		// 		var passwordError = document.getElementById("passwordError");
		// 		var passwordAgainError = document.getElementById("passwordAgainError");
		// 		var mailError = document.getElementById("mailError");
		// 		var birthdayError = document.getElementById("birthdayError");
		// 		var phoneError = document.getElementById("phoneError");

		// 		var errorMsg = document.getElementById("errorMsg");

		// 		if (!userIdValue) {
		// 			setErrorFor(userIdError, "???????????????")
		// 		} else {
		// 			userIdError.innerHTML = " ";
		// 		}
		// 		if (hasError) {
		// 			return false;
		// 		}

		// 		var xhr1 = new XMLHttpRequest();
		// 		xhr1.open("POST", "<c:url value='/addMember' />", true);

		// 		var jsonMember={
		// 			"userId":userIdValue,
		// 			"userName":userNameValue,
		// 			"nickName":nickNameValue,
		// 			"id":idValue,
		// 			"password":passwordValue,
		// 			"mail":mailValue,
		// 			"birthday":birthdayValue,
		// 			"phone":phoneValue
		// 		}

		// 		xhr1.setRequestHeader("Content-Type", "application/json");
		// 		xhr1.send(JSON.stringify(jsonMember));

		// 		xhr1.onreadystatechange = function () {
		// 			if (xhr1.readyState == 4 && xhr1.status == 200 ||xhr1.status==201) {
		// 				result = JSON.parse(xhr1.responseText);
		// 				if (result.success){

		// 				}
		// 			}

		// 		}

		// 	}

		/*=============================userName=============================
									  1.????????????
									 2.??????2?????????
									 3.??????????????????
		==================================================================*/
		//blur???????????????
		document.getElementById("userName").addEventListener("blur", cheakName);
		// ???????????????funtion
		function cheakName() {
			//????????????(string)
			var userNameVel = document.getElementById("userName").value;
			//??????
			var UserNameLen = userNameVel.length;
			// ?????????????????????
			var ch = userNameVel.match(/^[\u4E00-\u9FFF]{1,}$/g);
			var userNameErr = document.getElementById("userNameError");
			if (userNameVel == "") {
				userNameErr.innerHTML = "*??????????????????";
				hasError = true;
			} else if (ch) {
				if (UserNameLen >= 2) {
					userNameErr.innerHTML = " ";
					hasError = false;
				} else {
					userNameErr.innerHTML = "*?????????>=2,???????????????";
					hasError = true;
				}
			} else {
				userNameErr.innerHTML = "*only??????,???????????????";
				hasError = true;
			}
		}

		/*============================password=============================
									 1.????????????
									2.length>=6
							  3.????????????????????????????????????
		==================================================================*/
		// blur???????????????
		document.getElementById("password").addEventListener("blur", cheakPwd);
		// ???????????????funtion
		function cheakPwd() {
			var passwordVal = document.getElementById("password").value;
			var passwordLen = passwordVal.length;
			var pwdErr = document.getElementById("passwordError");
			var ch;
			// length>=6
			if (passwordVal == "") {
				pwdErr.innerHTML = "*??????????????????";
				hasError = true;
			} else if (passwordLen >= 6) {
				if ((passwordVal
						.match(/[@,#,*,%,(,),>,<,?,/,!,~,`,+,-,.,^,&,=,|,:,;,,,$]/g))) {
					pwdErr.innerHTML = "*???????????????????????????";
					hasError = true;
				} else if (ch.match(/[A-Z][0-9]/g) || ch.match(/[0-9][A-Z]/g)) {
					hasError = false;
				} else {
					pwdErr.innerHTML = "*?????????????????????"
					hasError = true;
				}
			} else {
				pwdErr.innerHTML = "*????????????<6,???????????????";
				hasError = true;
			}
		}

		/*============================rePassword=============================
									 1.???Password??????
		====================================================================*/
		// blur???????????????
		document.getElementById("passwordAgain").addEventListener("blur",
				cheakRePwd);
		// ???????????????funtion
		function cheakRePwd() {
			var passwordVal = document.getElementById("password").value;
			var passwordAgainVel = document.getElementById("passwordAgain").value;
			var rePwdErr = document.getElementById("passwordAgainError");
			if (passwordAgainVel == "") {
				rePwdErr.innerHTML = "*??????????????????";
				hasError = true;
			} else if (passwordAgainVel !== passwordVal) {
				rePwdErr.innerHTML = "*?????????????????????";
				hasError = true;
			} else
				rePwdErr.innerHTML = " ";
			hasError = false;
		}
	</script>





</body>



<!-- jQery -->
<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
<!-- //js -->
<script src="${contextRoot}/js/jquery.vide.js"></script>
<!-- bootstrap js -->
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</html>