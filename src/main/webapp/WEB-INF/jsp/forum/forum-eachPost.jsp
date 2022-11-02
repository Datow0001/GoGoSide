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

<link href="${contextRoot}/css/forum/forum-eachPost.css" rel="stylesheet">
<title>討論區</title>

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
					<div class="card">
						<table>
							<tr>
								<td class="userImg" rowspan="2">
									<img class="userIcon" src="${contextRoot}/images/forumImages/user_baseball.jpg">
								</td>
								<td class="userName" colspan="5">{使用者暱稱}</td>
							</tr>
							<tr>
								<td class="userAccount" colspan="5">@{使用者帳號}</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7">&nbsp;</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7"><fmt:formatDate
										pattern="yyyy-MM-dd HH:mm:ss EEEE"
										value="${post.postTime}" />
								</td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td class="forumTitle" colspan="7">${post.postArticle}</td>
							</tr>
							<tr>
								<td class="forumImg" colspan="7">
									<img src="${contextRoot}/showImage/${post.postNo}" height="100%">
								</td>
							</tr>
							<tr>
								<td class="forumContent" colspan="7">
									<div>${post.postContent}</div>
								</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7">&nbsp;</td>
							</tr>
						</table>	
						<table>
							<tr>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
								<td class="countsNo">${post.postLikes}</td>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
								<td class="countsNo">${post.postDislikes}</td>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
								<td class="countsNo">${post.postViews}</td>
								<td class="space">&nbsp;</td>
							</tr>
						</table>
					</div>
					<div class="card">
						<table>
							<tr>
								<td>test</td>
							</tr>
						</table>
					</div>
			</article>

		</div>

	</div>
	<br>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	
	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
    <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>