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

<!-- <meta http-equiv="content-type" content="application/json; charset='UTF-8'"> -->


<link href="${contextRoot}/css/forum/forum-eachPost.css" rel="stylesheet">
<title>討論區</title>

</head>
<body>
<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>
	<div>
		<div class="content">
			<aside class="asideLeft">
				<table>
					<tr>
						<td class=eachBtn id="this">當前位置<br>> MLB&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td class=eachBtn><a href="">NBA</a></td>
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
									<img class="userIcon" src="${contextRoot}/PostUserImage/${ForumPost.userId}">
								</td>
<!-- 								<td class="userName" colspan="5">{使用者暱稱}</td> -->
			
								<td rowspan="2" style="text-align:right">
								<c:if test="${LoginOK.userId==ForumPost.userId}">
									<button class="editBtn"><a href="${contextRoot}/forum/edit?p=${ForumPost.postNo}">修改</a></button>
									<button class="editBtn"><a onclick="return confirm('確定刪除此篇貼文？')"
 										   href="${contextRoot}/forum/delete?p=${ForumPost.postNo}">刪除</a></button>
 								</c:if>
								</td>
							</tr>
							<tr>
								<td class="userAccount" colspan="5">@${ForumPost.userId}</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7">&nbsp;</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7"><fmt:formatDate
										pattern="yyyy-MM-dd HH:mm:ss EEEE"
										value="${ForumPost.postTime}" />
								</td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td class="forumTitle" colspan="7">${ForumPost.postArticle}</td>
							</tr>
							<tr>
								<td class="forumImg" colspan="7">
									<img src="${contextRoot}/showImage/${ForumPost.postNo}" height="100%">
								</td>
							</tr>
							<tr>
								<td class="forumContent" colspan="7">
									<div>${ForumPost.postContent}</div>
								</td>
							</tr>
							<tr>
								<td class="forumTime" colspan="7">&nbsp;</td>
							</tr>
						</table>	
						<table>
							<tr>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/like-icon.png" height="100%">&nbsp;</td>
								<td class="countsNo">${ForumPost.postLikes}</td>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/comment-icon.png" height="100%">&nbsp;</td>
								<td class="countsNo">${ForumPost.postDislikes}</td>
								<td class="countsIcon"><img src="${contextRoot}/images/forumImages/view-icon.png" height="100%">&nbsp;</td>
								<td class="countsNo">${ForumPost.postViews}&nbsp;views</td>
								<td class="space">&nbsp;</td>
							</tr>
						</table>
					</div>
					
					<div class="card">
						<form:form action="${contextRoot}/forum/ViewEachPost" method="post"
										modelAttribute="forumComment">
						<table>
							<tr>
								<c:if test="${empty LoginOK}">
								<span>請先登入以回覆文章</span>
								</c:if>
								<c:if test="${!empty LoginOK}">
								<td>
									<form:input type="hidden" value="${LoginOK.userId}" path="userId"
												class="form-control" />
									<form:input type="hidden" value="${ForumPost.postNo}" path="postNo"
												class="form-control" />
									<form:textarea path="cmmtContent" id="myComment" placeholder=" 請輸入回應……"
												class="form-control" />
								</td>
								<td>
									<button type="submit" name="submit" id="cmmtSubmitBtn" value="回覆">回覆</button>
									<span id="errMsg"></span>
								</td>
								</c:if>
							</tr>
						</table>
						</form:form>
						
					</div>
					<div id="cmmtList"></div>
					
					<c:forEach var="forumComment" items="${page.content}">			
						<div class="card">
							<table>
								<tr>
									<td class="showCmmtInfo">${forumComment.userId}&nbsp;&nbsp;·&nbsp;&nbsp;
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumComment.cmmtTime}"/>
									</td>
<%-- 									<td>${forumComment.userId}<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumComment.cmmtTime}"/></td> --%>
									<td><a onclick="return confirm('確定刪除？')"
 										   href="${contextRoot}/forum/cmmtDelete?delid=${forumComment.cmmtNo}">刪除</a></td>
								</tr>
								<tr><td colspan="3" class="showCmmtContent">${forumComment.cmmtContent}</td></tr>
							</table>
						</div>
					</c:forEach>
			</article>
		</div>

	<br>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	
<%-- 	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
<%--     <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>
    
</body>
</html>