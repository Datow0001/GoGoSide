<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NBA賽程</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css"> 
<link rel="stylesheet" href="jqueryui/style.css">


</head>
<body>
<div id="navvv">
					<header class="header">
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
					</header>
				</div>

<div class="container">
<table id="table_id" class="display">
    <thead>
       
    </thead>
    <tbody>
        
    </tbody>
</table>

</div>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript">

$(document).ready( function () {
    $('#table_id').DataTable({
    	"ajax":'http://localhost:8080/my-app/NBASchedule1',
    	"columns":[
    		{data:'nid',title:'編號',},
    		{data:'nhomeTeam',title:'主場',},
    		{data:'nawayTeam',title:'客場',},
    		{data:'gameDate',title:'日期',},
    		{data:'point',title:'比數',},
    	
    	]
    });
} );

</script>
</body>
</html>