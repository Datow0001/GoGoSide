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

<link href="${contextRoot}/css/forum/forum-index.css" rel="stylesheet">
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
				<c:forEach var="forumPost" items="${page.content}">
					<div class="card">
						<a href="${contextRoot}/forum/post?p=${forumPost.postNo}" style="text-decoration: none">
						
							<table class="tablePost">
								<tr>
									<td class="userImg" rowspan="2">
										<img class="userIcon" src="${contextRoot}/images/forumImages/user_baseball.jpg">
									</td>
									<td class="userName" colspan="2">
										<div class="userName">
											${forumPost.teamName}隊版．{使用者暱稱}
										</div>
<%-- 										<form:input type="hidden" value="${forumPost.postNo}" path="postNo" class="form-control" /> --%>
									</td>
									<td class="edit" rowspan="2">
<%-- 										<a href="${contextRoot}/forum/edit?postNo=${forumPost.postNo}">修改</a> --%>
										<a href="">修改</a>
										｜
										<a onclick="return confirm('確定刪除？')"
										   href="${contextRoot}/forum/delete?p=${forumPost.postNo}">刪除</a>
									</td>
									<td class="forumImg" rowspan="4">
										<img class="forumIcon" src="${contextRoot}/showImage/${forumPost.postNo}" height="100%" width="100%">
									</td>
								</tr>
								<tr>
									<td class="forumTime" colspan="2">
										<div class="forumTime">
											<fmt:formatDate	pattern="yyyy-MM-dd HH:mm:ss EEEE"
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
							<table>
								<tr>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
									<td class="countsNo">${forumPost.postLikes}</td>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
									<td class="countsNo">${forumPost.postDislikes}</td>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/ball-icon.png" height="100%"></td>
									<td class="countsNo">${forumPost.postViews}</td>
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
								<span><a href="${contextRoot}/forum/?p=${p}">${p}</a></span>
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
	<br>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	
	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
    <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>