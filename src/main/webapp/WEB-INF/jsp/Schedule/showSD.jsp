<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
<meta charset="UTF-8">
<title>賽程</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css"> 

</head>
<body>
<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>
<h2 style="text-align: center;">MLB賽程</h2>
<hr>
<div class="container">
<table id="table_id" class="display">
    <thead>
       
    </thead>
    <tbody>
        
    </tbody>
</table>



<!-- <div class="newsholder" style="margin-right: 50px"> -->
<!-- 			<h1>賽程</h1> -->
<%-- 			<c:forEach var="data" items="${res}"> --%>
<!-- 				<div class="card mb-3" style="width: 950px;float: top">  -->
<!-- 					<div class="row g-0" > -->
<!-- 						<div class="col-md-4"> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-8"> -->
<!-- 							<div class="card-body"> -->
<%-- 								<h5 class="card-title"><a href='${contextRoot}/Schedule'></a>${data.gameDate}</h5> --%>
<%-- 								<p class="card-text">${data.homeTeam}${data.awayTeam}</p> --%>
<%-- <%-- 								<p class="card-text">${data.awayTeam}</p> --%> 
<%-- 								<p class="card-text">${data.point}</p> --%>
<%-- 									<small class="text-muted"><span><fmt:formatDate pattern="yyyy-MM-dd" value="" /></span></small> --%>
<!-- 								</p> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 			</c:forEach> --%>


<!-- <div class="card"> -->
<!--   <div class="card-header"> -->
    
<!--   </div> -->
<!--   <div class="card-body"> -->
<%--      <form:form action="${contextRoot}/Schedule" method="post" modelAttribute="data"> --%>
       
<!--        <div class="input-group"> -->
<%--          <form:textarea path="text" class="form-control"/> --%>
<!--        </div> -->
<%--      </form:form> --%>
<!--   </div> -->
<!-- </div> -->
<!-- <br /> -->

</div>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#table_id').DataTable({
    	"ajax":'http://localhost:8080/my-app/Schedule1',
    	"columns":[
    		{data:'id',title:'編號',},
    		{data:'homeTeam',title:'主場',},
    		{data:'awayTeam',title:'客場',},
    		{data:'gameDate',title:'日期',},
    		{data:'point',title:'時間',},
    	
    	]
    });
} );

</script>
</body>
</html>