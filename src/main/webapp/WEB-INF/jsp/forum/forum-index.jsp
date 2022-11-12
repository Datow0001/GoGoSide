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
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
<link href="${contextRoot}/css/forum/forum-index.css" rel="stylesheet">
<title>討論區</title>

</head>
<body onload="changeTag();">
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
				<a href="${contextRoot}/forum/orderbyteam?team=紐約洋基">紐約洋基</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=波士頓紅襪">波士頓紅襪</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=巴爾的摩金鶯">巴爾的摩金鶯</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=坦帕灣光芒">坦帕灣光芒</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=多倫多藍鳥">多倫多藍鳥</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=芝加哥白襪">芝加哥白襪</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=克里夫蘭守護者">克里夫蘭守護者</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=底特律老虎">底特律老虎</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=堪薩斯市皇家">堪薩斯市皇家</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=明尼蘇達雙城">明尼蘇達雙城</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=休士頓太空人">休士頓太空人</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=洛杉磯天使">洛杉磯天使</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=奧克蘭運動家">奧克蘭運動家</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=西雅圖水手">西雅圖水手</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=德克薩斯遊騎兵">德克薩斯遊騎兵</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=華盛頓國民">華盛頓國民</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=費城費城人">費城費城人</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=紐約大都會">紐約大都會</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=邁阿密馬林魚">邁阿密馬林魚</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=亞特蘭大勇士">亞特蘭大勇士</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=芝加哥小熊">芝加哥小熊</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=辛辛那提紅人">辛辛那提紅人</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=密爾瓦基釀酒人">密爾瓦基釀酒人</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=匹茲堡海盜">匹茲堡海盜</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=聖路易紅雀">聖路易紅雀</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=亞利桑那響尾蛇">亞利桑那響尾蛇</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=科羅拉多洛磯">科羅拉多洛磯</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=洛杉磯道奇">洛杉磯道奇</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=聖地牙哥教士">聖地牙哥教士</a>
				<br>
				<a href="${contextRoot}/forum/orderbyteam?team=舊金山巨人">舊金山巨人</a>
				<br>
				
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
						<a href="${contextRoot}/forum/ViewEachPost?p=${forumPost.postNo}" style="text-decoration: none">
						
							<table class="tablePost">
								<tr>
									<td class="userImg" rowspan="2">
										<img class="userIcon" src="${contextRoot}/PostUserImage/${forumPost.userId}">
									</td>
									<td class="userName" colspan="2">
										<div class="userName">
											${forumPost.teamName}隊版．${forumPost.userId}
										</div>
									</td>
									<td class="edit" rowspan="2">
<%-- 										<a href="${contextRoot}/forum/edit?p=${forumPost.postNo}">修改</a> --%>
<!-- 										｜ -->
<!-- 										<a onclick="return confirm('確定刪除？')" -->
<%-- 										   href="${contextRoot}/forum/delete?p=${forumPost.postNo}">刪除</a> --%>
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
							<table class="status">
								<tr>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/like-icon.png" height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postLikes}</td>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/comment-icon.png" height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postDislikes}</td>
									<td class="countsIcon"><img src="${contextRoot}/images/forumImages/view-icon.png" height="100%">&nbsp;</td>
									<td class="countsNo">&nbsp;${forumPost.postViews}&nbsp;views</td>
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
	
<%-- 	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
<%--     <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>
    
    <script>
	    function changeTag(){
	        var tagH2 = document.getElementsByTagName("h2");
	        tagH2.outerHTML = "<p>" + tagH2.innerHTML + "</p>";
	    }
    </script>
</body>
</html>