<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link href="${contextRoot}/css/forum/edit-post.css" rel="stylesheet">
<title>討論區</title>

</head>
<body onload="init();">
	<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div class="container">
		<form:input type="hidden" path="postNo"/>
		<form:input type="hidden" path="postTime"/>
		<form:form name="F" action="${contextRoot}/forum/add" method="post"
			enctype="multipart/form-data" modelAttribute="forumPost" value="forumPost.postTime">
			<div class="aside">
				<div>
					<img class="userImg" src="../images/forumImages/user_baseball.jpg">
				</div>
				<div class="userId">userId_123456</div>
				
				<select class=teamSelect name="teamAreas" onChange="FirstConfirm(this.selectedIndex);">
		            <option class=teamOption selected>請選擇聯盟及分區</option>
		            <option class=teamOption>美國聯盟【AL】東區</option>
		            <option class=teamOption>美國聯盟【AL】中區</option>
		            <option class=teamOption>美國聯盟【AL】西區</option>
		            <option class=teamOption>國家聯盟【NL】東區</option>
		            <option class=teamOption>國家聯盟【NL】中區</option>
		            <option class=teamOption>國家聯盟【NL】西區</option>
		        </select>
		        <select class=teamSelect name="teamName" onChange="FinalConfirm(this.selectedIndex)" value="forumPost.teamName"></select>
		        <img class="imgPast" src="${contextRoot}/showImage/${forumPost.postNo}" height="100%" width="100%">
			</div>
			<div class="article">
				<div class="input-group">
					<span class="description">標題：&nbsp; <input type="text"
						name="postArticle" class="form-control" id="inputTitle" value="forumPost.postArticle"/>
					</span>
				</div>

				<div class="input-group">
					<span class="description"> <label for="">更換圖片：&nbsp;</label> <input
						type="file" name="imageFile">
					</span>
				</div>

				<div class="input-group">
					<span class="description">內文：&nbsp; <form:textarea
							path="postContent" class="form-control" id="summernote" value="forumPost.postContent"/>
					</span>
				</div>
			</div>
			<div class="confirm">
				<input class="postBtn" type="submit" name="ConfirmBtn" value="送出" DISABLED>
			</div>
		</form:form>
	</div>
	<br>
	<jsp:include page="../layout/footer.jsp"></jsp:include>

	<script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
	<script>
        var teamArea_list = "";
        var teamName_list = "";
        var teamName = new Array();
        teamName[0] = "";
        teamName[1] = ["請選擇美聯東區球隊", "巴爾的摩金鶯", "波士頓紅襪", "紐約洋基", "坦帕灣光芒", "多倫多藍鳥"];
        teamName[2] = ["請選擇美聯中區球隊", "芝加哥白襪", "克里夫蘭守護者", "底特律老虎", "堪薩斯市皇家", "明尼蘇達雙城"];
        teamName[3] = ["請選擇美聯西區球隊", "休士頓太空人", "洛杉磯天使", "奧克蘭運動家", "西雅圖水手", "德克薩斯遊騎兵"];
        teamName[4] = ["請選擇國聯東區球隊", "亞特蘭大勇士", "邁阿密馬林魚", "紐約大都會", "費城費城人", "華盛頓國民"];
        teamName[5] = ["請選擇國聯中區球隊", "芝加哥小熊", "辛辛那提紅人", "密爾瓦基釀酒人", "匹茲堡海盜", "聖路易紅雀"];
        teamName[6] = ["請選擇國聯西區球隊", "亞利桑那響尾蛇", "科羅拉多洛磯", "洛杉磯道奇", "聖地牙哥教士", "舊金山巨人"];

        function FirstConfirm(IDX) {
            teamName_list.options.length = 0;
            if (IDX > 0) {
                for (i = 0; i < teamName[IDX].length; i++) {
                    teamName_list.options[teamName_list.options.length] = new Option(teamName[IDX][i]);
                }
            } else {
                FinalConfirm(0);
            }
        }
        function FinalConfirm(IDX) {
            if (IDX > 0) {
                document.F.ConfirmBtn.disabled = false;
            } else {
                document.F.ConfirmBtn.disabled = true;
            }
        }
        function init() {
            teamArea_list = document.F.teamArea;
            teamName_list = document.F.teamName;
        }
    </script>
</body>


</html>