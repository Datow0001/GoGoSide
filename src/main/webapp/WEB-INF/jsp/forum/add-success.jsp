<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>討論區</title>
<style>
@font-face {
	src: url(../fonts/jf-openhuninn-1.1.ttf);
	font-family: font1;
}

* {
	margin: 0;
	padding: 0;
}

body {
	width: 100vw;
	overflow-x: hidden;
}

.content {
	width: 95%;
	overflow: auto;
	margin-left: 3%;
	font-family: font1, Verdana, Geneva, Tahoma, sans-serif;
}

.card {
	height: 25vh;
	width: 60vw;
	border: #F5AF4B solid 3px;
	border-radius: 5%;
	margin: 2% 1% 0 1%;
	padding: 1.5vh 1.5vw 1.5vh 1.5vw;
}

.article {
	width: 65%;
	float: left;
}

.asideLeft {
	width: 12%;
	float: left;
	margin-left: 6%;
	margin-top: 1%;
	padding-right: 2%;
	padding-top: 1%;
}

.asideRight {
	width: 8%;
	float: right;
	margin-top: 1%;
	padding-right: 6%;
}

.description {
	font-size: 2vw;
	line-height: 3.5em;
	color: #0A324B;
}

.linkBtn {
	height: 6vh;
	width: 9vw;
	margin-right: 1.5vw;
	font-size: 1.2vw;
	text-align: center;
	vertical-align: center;
	background-color: #F5AF4B;
	border: solid 1px #F5AF4B;
	border-radius: 10%
}

.linkBtn a {
	color: rgb(250, 245, 240);
}

.linkBtn a:hover {
	color: #0A324B;
	text-decoration: none;
}

.postBtn {
	float: right;
	display: inline-block;
	height: 8vh;
	width: 6vw;
	margin-top: 2vh;
	margin-left: 2vw;
	font-size: 1.2vw;
	background-color: #F5AF4B;
	color: rgb(250, 245, 240);
	border: #F5AF4B 1px solid;
	border-radius: 10%;
}

.postBtn a {
	color: rgb(250, 245, 240);
}

.postBtn a:link {
	color: rgb(250, 245, 240);
	text-decoration: none;
}

.eachBtn {
	height: 6vh;
	width: 8vw;
	text-align: center;
	vertical-align: center;
	margin-left: 1.5vw;
	font-size: 2vh;
	background-color: #0A324B;
}

#this {
	height: 10vh;
	background-color: #F5AF4B;
	color: rgb(250, 245, 240);
}

.eachBtn a {
	color: lightgray;
}

.eachBtn a:hover {
	color: #F5AF4B;
	text-decoration: none;
}

</style>
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div>

		<div class="content">
			<aside class="asideLeft">
				<table>
					<tr>
						<td class=eachBtn id="this">當前位置<br>{XXX看板}</td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">所有看板</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">{XXX看板}</a></td>
					</tr>
				</table>
			</aside>

			<aside class="asideRight">
				<div>
					<a href="${contextRoot}/forum/add">
						<button class="postBtn">發表文章</button>
					</a>
				</div>
			</aside>

			<article class="article">
				<div class="description">已成功上傳文章 !</div>
				<span>
					<button class="linkBtn">
						<a href="${contextRoot}/forum/">回討論區首頁</a>
					</button>
				</span>
				<span>
					<button class="linkBtn">
						<a href="">我的文章列表</a>
					</button>
				</span>
	
			</article>

		</div>

	</div>
	<br>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	
	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
    <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>