<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	
	<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png"	type="">
	<title>果果賽後台管理</title>
	
	<link rel="stylesheet" type="text/css" href="${contextRoot}/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
						   integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
						   crossorigin="anonymous" />
						   
	<link href="${contextRoot}/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
	<link href="${contextRoot}/css/navbar_style.css" rel="stylesheet" />
	<link href="${contextRoot}/css/backend.css" rel="stylesheet">
	
	<script src="https://kit.fontawesome.com/104e2ed605.js" crossorigin="anonymous"></script>
	<script src="${contextRoot}/js/jquery-3.6.1.min.js" type="text/javascript"></script> 
	<script src="${contextRoot}/js/bootstrap.bundle.min.js" type="text/javascript"></script> 
</head>

<body>
	<div id="navvv">
			
	<header class="header">
		<nav class="navbar navbar-expand-lg custom_nav-container ">
			<a class="navbar-brand" href="${contextRoot}/"> <?xml version="1.0" encoding="utf-8"?>
				<svg version="1.1" id="" xmlns="http://www.w3.org/2000/svg"
					xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
					viewBox="0 0 880 767" xml:space="preserve">
                <path
						d="M54.47,416.2l-12.4-33.99L239.25,42.05h287.82l51.04,89.79l-61.5,69.7h-0.01c-1.98-0.35-4.02-0.54-6.1-0.54
              	c-19.02,0-34.5,15.48-34.5,34.5c0,19.02,15.48,34.5,34.5,34.5s34.5-15.48,34.5-34.5c0-1.78-0.14-3.52-0.4-5.23l54.42-61.66
              	l21.32,37.51l-65.18,76.35c-1.84-0.31-3.73-0.47-5.66-0.47c-19.02,0-34.5,15.48-34.5,34.5c0,19.02,15.48,34.5,34.5,34.5
              	s34.5-15.48,34.5-34.5c0-1.93-0.16-3.82-0.47-5.66l57.83-67.74l25.08,44.12l-61.6,69.94c-1.1-0.11-2.21-0.16-3.34-0.16
              	c-19.02,0-34.5,15.48-34.5,34.5c0,19.02,15.48,34.5,34.5,34.5s34.5-15.48,34.5-34.5c0-2.79-0.33-5.5-0.97-8.09L687.35,324
              	l33.58,59.07c-4.4,7.7-8.8,15.39-13.19,23.08c-26.47,46.31-53.73,93.99-81,140.92c-0.74-0.05-1.49-0.07-2.24-0.07
              	c-19.02,0-34.5,15.48-34.5,34.5c0,19.02,15.48,34.5,34.5,34.5s34.5-15.48,34.5-34.5c0-2.94-0.37-5.8-1.07-8.52
              	c28.49-48.93,56.94-98.71,84.53-146.98c6.28-10.98,12.56-21.97,18.85-32.96c3.51-6.14,3.52-13.67,0.03-19.82L556.09,12.17
              	c-3.56-6.25-10.2-10.12-17.39-10.12H227.73c-7.13,0-13.73,3.8-17.3,9.97L2.77,370.24c-2.97,5.13-3.51,11.32-1.48,16.89l15.6,42.78
              	c3.79,10.38,15.27,15.72,25.64,11.94C52.91,438.06,58.25,426.58,54.47,416.2z" />
                <path
						d="M665.75,693.91l-30.73,33.11h-394.3L93.8,473.53l46.04-77.83c8.6,0.27,17.22,0.52,25.83,0.77
              	c23.19,0.69,46.94,1.39,70.6,2.35c6.12,9.71,16.93,16.18,29.23,16.18c19.02,0,34.5-15.48,34.5-34.5c0-19.02-15.48-34.5-34.5-34.5
              	c-10.84,0-20.53,5.03-26.86,12.88c-24.11-0.98-48.24-1.69-71.79-2.39c-1.25-0.04-2.5-0.07-3.75-0.11l14.16-23.94h107.11
              	c6.25,8.8,16.53,14.56,28.13,14.56c19.02,0,34.5-15.48,34.5-34.5c0-19.02-15.48-34.5-34.5-34.5c-11.55,0-21.79,5.7-28.05,14.44
              	h-83.53l18.4-31.12h104.96c6.25,8.87,16.57,14.68,28.22,14.68c19.02,0,34.5-15.48,34.5-34.5c0-19.02-15.48-34.5-34.5-34.5
              	c-11.49,0-21.69,5.65-27.96,14.32h-81.55l53.45-90.37h176.3c6.28,8.52,16.39,14.05,27.76,14.05c19.02,0,34.5-15.48,34.5-34.5
              	c0-19.02-15.48-34.5-34.5-34.5c-11.77,0-22.18,5.93-28.41,14.95H285.03c-7.07,0-13.61,3.73-17.21,9.81L53.41,463.25
              	c-3.68,6.22-3.71,13.95-0.08,20.21l158.56,273.59c3.58,6.17,10.17,9.97,17.3,9.97h414.55c5.57,0,10.88-2.32,14.66-6.4l36.67-39.5
              	c7.51-8.1,7.04-20.75-1.05-28.27C685.92,685.34,673.26,685.81,665.75,693.91z" />
                <circle cx="432.5" cy="316.5" r="34.5" />
                <circle cx="377.5" cy="406" r="34.5" />
                <circle cx="491.5" cy="406" r="34.5" />
                <path
						d="M877.16,373.38L665.93,10.03c-3.59-6.16-10.17-9.95-17.3-9.95h-39.42c-11.04,0-20,8.95-20,20
              	c0,11.05,8.96,20,20,20h27.92L836.72,383.4L691.19,632.2h-97.2l-37.43-80.12c5.25-6.05,8.44-13.95,8.44-22.58
              	c0-19.02-15.48-34.5-34.5-34.5S496,510.48,496,529.5c0,14.08,8.49,26.23,20.61,31.58l33.23,71.12h-36.8
              	c-7.54-16.46-15.14-33.24-22.53-49.57c-4.8-10.61-9.69-21.41-14.6-32.2v-0.01c4.45-5.81,7.09-13.06,7.09-20.92
              	c0-19.02-15.48-34.5-34.5-34.5S414,510.48,414,529.5c0,15.09,9.74,27.95,23.27,32.62c5.65,12.37,11.28,24.82,16.8,37.01
              	c4.93,10.89,9.96,21.99,15,33.07h-33.5L390.61,548c3.41-5.35,5.39-11.7,5.39-18.5c0-19.02-15.48-34.5-34.5-34.5
              	S327,510.48,327,529.5c0,16.18,11.21,29.81,26.27,33.5l36.95,69.2h-93.06L187.28,450.25c-5.71-9.45-18-12.49-27.45-6.78
              	c-9.46,5.71-12.5,18-6.79,27.46l115.72,191.61c3.62,6,10.11,9.66,17.12,9.66h416.78c7.1,0,13.67-3.77,17.26-9.9l157.21-268.77
              	C880.77,387.31,880.78,379.61,877.16,373.38z" />
              </svg>
              <span>GoGoSide 後台管理</span>
			</a>

			<button style="background-color: #D73C28;" class="navbar-toggler"
				type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNavDropdown">

				<!-- option  -->
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">取得爬蟲</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">管理會員</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">審核檢舉</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">管理文章</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">管理新聞</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">管理賽程</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/">回前台</a>
					</li>
				</ul>
				<c:if test="${!empty IsAdmin}">
					<a href="${contextRoot}/Back"> <span>後台</span>
					</a>
				</c:if>
				<!-- user -->
				<div class="user_option">

					<c:if test="${empty LoginOK}">
						<a href="<c:url value='/member/loginForm'/>"> 登入 </a>
					</c:if>
					<c:if test="${!empty LoginOK}">
						<a href="${contextRoot}/logout">登出</a>
					</c:if>
					<a href="${contextRoot}/personForm" class="user_link"><i class="fa-solid fa-user"></i> </a>

					<nav class="navbar navbar-light">
						<form class="form-inline" action="${contextRoot}/News/search" method="get">
							<div style="align-items: center;" class="input-group">
								<span
									style="width: 30px; display: flex; justify-content: center;"
									class="search_border input-group-text">
									<button class="btn my-2 my-sm-0 nav_search-btn " type="submit" name="submit">
										<i class="fa-solid fa-magnifying-glass"></i>
									</button>
								</span> <input type="text" class=" search_font search_border"
									placeholder="搜尋" aria-label="search"
									name="word"
									aria-describedby="basic-addon1">
							</div>
						</form>
					</nav>
				</div>
			</div>
		</nav>
	</header>
	</div>
	<div class="content">
		
		<div class="cardEach">
			<div class="title">
				<img id="icon" src="${contextRoot}/images/forumImages/baseball-icon.jpg" width="100%">
			&nbsp;MLB 相關數據</div>
			<div class="link"><a href="${contextRoot}/Team/getImg">>&nbsp;取得球隊隊徽【getImg】&nbsp;→&nbsp;從靜態資源</a></div>
			<div class="link"><a href="${contextRoot}/Team/getTeam">>&nbsp;取得球隊戰績【getStanding】</a></div>
			<div class="link"><a href="${contextRoot}/Team/updateStanding">>&nbsp;更新球隊戰績【updateStanding】</a></div>
			<div class="link"><a href="${contextRoot}/Player/GetFielder">>&nbsp;取得野手數據【getFielderStat】</a></div>
			<div class="link"><a href="${contextRoot}/Player/GetPitcher">>&nbsp;取得投手數據【getPitcherStat】</a></div>
			<div class="link"><a href="${contextRoot}/getNews">>&nbsp;取得今日新聞【getTodayNews】</a></div>
			<div class="link"><a href="${pageContext.request.contextPath}/getSchedule">&nbsp;取得MLB賽程</a></div>
		</div>
		<div class="cardEach">
			<div class="title">
				<img id="icon" src="${contextRoot}/images/forumImages/basketball-icon.jpg" width="100%">
			&nbsp;NBA 相關數據</div>
			<div class="link"><a href="${contextRoot}/Team/getNBAteam">>&nbsp;取得球隊戰績【getNbaStat】</a></div>
			<div class="link"><a href="${contextRoot}/Team/updateNBAteam">>&nbsp;更新球隊戰績【updateNBAStat】</a></div>
			<div class="link"><a href="${contextRoot}/NBAPlayer/get">>&nbsp;取得球員數據【updateNBAPlayerStat】</a></div>
<%-- 			<div class="link"><a href="${contextRoot}/Team/getNBAsch">>&nbsp;取得賽程【updateNBAschdule】</a></div> --%>
			<div class="link"><a href="${contextRoot}/getNBAnews">>&nbsp;取得今日新聞【getTodayNewsNba】</a></div>
			<div class="link"><a href="${contextRoot}/News/searchNBA">>&nbsp;查看新聞頁面【seeNBA】</a></div>
			<div class="link"><a href="${pageContext.request.contextPath}/NBAgetSchedule">&nbsp;取得NBA賽程</a></div>
		</div>
		<div class="cardEach">
			<div class="title">
				<img id="icon" src="${contextRoot}/images/forumImages/comment-icon.png" width="100%">
			&nbsp;其他數據</div>
			<div class="link"><a href="${contextRoot}/getHighLight">>&nbsp;取得 HighLight【gethighLight】</a></div>
			<div class="link"><a href="${contextRoot}/Schedule">schedule</a>
			<div class="link"><a href="${contextRoot}/viewUserInfo?userId=datow0001">>&nbsp;TTTTTTTTTTTest</a></div></div>
		</div>
	</div>
</body>



</html>