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
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
<title>${News.newsTitle}</title>
<style type="text/css">
.news {
	width: 800px;
}

.imgbox {
	text-align: center;
}

.imgbox span {
	font-size: 13px;
}

.date {
	font-size: 10px
}

.form-control {
	height: 100px;
	width: 200px;
	resize: none;
}

.userIcon {
	height: 6vh;
	border: #F5AF4B solid 3px;
	border-radius: 50%;
}

/* -------------------------------------- */
.userName {
	height: 2.5vh;
	width: 30vw;
	font-size: 1.5vh;
	color: gray;
	overflow: hidden;
}

.edit {
	height: 2.5vh;
	width: 10vw;
	font-size: 1.5vh;
	text-align: right;
	padding-right: 1vw;
}

.edit a {
	color: #D73C28;
}

.edit a:hover {
	color: #F5AF4B;
}

.forumTime {
	height: 2.5vh;
	width: 30vw;
	font-weight: 400;
	font-size: 1.5vh;
	color: gray;
	overflow: hidden;
}

.forumContent {
	/* 						 	height: 4vh;  */
	width: 47vw;
	padding-right: 0.5vw;
	font-weight: 400;
	font-size: 1.8vh;
	line-height: 2em;
	color: gray;
	vertical-align: top;
	overflow: hidden;
	white-space: pre-line;
	max-width: 800px;
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
		<div style="float: right">
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
		<div class="news">
			<h2>${News.newsTitle}</h2>
			<p class="date">
				<fmt:formatDate value="${News.newsDate}" pattern="yyyy/MM/dd" />
			</p>

			<div>
				<table class="imgbox">
					<tr>
						<td><img width="700px" class="img1" src="${News.picFile}"></td>
					</tr>

					<tr>
						<td><span> ${News.picTitle}</span></td>
					</tr>
				</table>
			</div>
			<div>${News.newsIndex}

				<p>已被閱讀：${News.newsClickCount}次</p>
			</div>









			<div class="card">
				<div class="card-header">輸入回應</div>
				<div class="card-body">
					<!-- ------------------------- -->
					<c:if test="${empty LoginOK}">
						<a href="<c:url value='/member/loginForm'/>"> 登入 </a>
					</c:if>
					<!-- ---------------- -->
					<c:if test="${!empty LoginOK}">
						<form:form action="${contextRoot}/News/ViewNewsPage" method="post"
							modelAttribute="newsMessage" enctype="multipart/form-data">

							<div class="input-group">
								<form:input path="userId" value="${LoginOK.userId}"
									type="hidden" id="id" class="form-control" />

								<form:textarea path="postIndex" id="index" class="form-control" />
								<form:input type="hidden" value="${News.newsNumber}"
									path="newsNumber" class="form-control" />
							</div>
							<button type="submit" name="submit" id="submit" value="送出">送出</button>
							<span id="err"></span>
						</form:form>
					</c:if>
					<!-- 					--------------------- -->
					<%-- 					<form:form action="${contextRoot}/News/ViewNewsPage" method="post" --%>
					<%-- 						modelAttribute="newsMessage"> --%>

					<!-- 						<div class="input-group"> -->
					<%-- 							<form:textarea path="userId" id="id" class="form-control" /> --%>
					<%-- 							<form:textarea path="postIndex" id="index" class="form-control" /> --%>
					<%-- 							<form:input type="hidden" value="${News.newsNumber}" --%>
					<%-- 								path="newsNumber" class="form-control" /> --%>
					<!-- 						</div> -->
					<!-- 						<button type="submit" name="submit" id="submit" value="送出">送出</button> -->
					<!-- 						<span id="err"></span> -->
					<%-- 					</form:form> --%>
				</div>
			</div>
			<article class="article">
				<c:forEach var="workMessage" items="${page.content}">
					<!-- 				<div class="card"> -->
					<!-- 					<div class="card-header"> -->
					<%-- <span>貼文者：${workMessage.userId} 貼文時間：<fmt:formatDate --%>
					<%-- pattern="yyyy-MM-dd HH:mm:ss" value="${workMessage.postTime}" /></span>
											--%>
					<!-- 					</div> -->
					<%-- <div class="card-body">${workMessage.postIndex}
						</div> --%>
					<!-- 				</div> -->
					<!-- 				<br /> -->

					<div class="card">
						<table class="tablePost">
							<tr>
								<td class="userImg" rowspan="2"><img class="userIcon"
									src="${contextRoot}/PostUserImage/${workMessage.userId}">
								</td>
								<td class="userName" colspan="2">
									<div class="userName">
									<a href="${contextRoot}/viewUserInfo?userId=${workMessage.userId}">${workMessage.userId}</a>
									</div>
								</td>
								<c:if test="${!empty IsAdmin}">
									<td class="edit" rowspan="2"><a
										onclick="return confirm('確定刪除?')"
										href='${contextRoot}/delMessage?delid=${workMessage.postNumber}'>刪除</a>
									</td>
								</c:if>
							</tr>
							<tr>
								<td class="forumTime" colspan="2">
									<div class="forumTime">
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE"
											value="${workMessage.postTime}" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="forumContent" colspan="4">
									<div class="forumContent">${workMessage.postIndex}</div>
								</td>
							</tr>
						</table>

					</div>
				</c:forEach>
			</article>
		</div>
	</div>
	<c:if test="${!empty IsAdmin}">
		<a onclick="return confirm('確定刪除?')"
			href='${contextRoot}/delNews?delid=${News.newsNumber}'><button>del</button></a>
		<a href='${contextRoot}/News/EditNews?id=${News.newsNumber}'><button>edit</button></a>
	</c:if>
	<div style="margin-top:300px">	<jsp:include page="../layout/footer.jsp"></jsp:include></div>

	<script>
		let input = document.querySelector("#id");
		let index = document.querySelector("#index")
		let button = document.querySelector("#submit");
		let err = document.querySelector("#err")
		button.disabled = true;
		input.addEventListener("change", stateHandle);
		index.addEventListener("change", stateHandle);
		function stateHandle() {
			if (input.value === "" || index.value === "") {
				console.log(index.value.length)
				err.innerHTML = "需填文字"
				button.disabled = true;
			} else if (index.value.length > 500) {
				err.innerHTML = "超過500字"
				console.log(index.value.length)
				button.disabled = true;
			} else {
				console.log(index.value.length)
				err.innerHTML = "";
				button.disabled = false;
			}
		}
	</script>
</body>

</html>