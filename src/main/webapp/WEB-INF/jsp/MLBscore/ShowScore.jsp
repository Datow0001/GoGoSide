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
<title>ShowScore</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css"> 
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
<script type="text/javascript">
$(document).ready( function () {
    $('#table_id').DataTable({
    	"ajax":'http://localhost:8080/my-app/ShowAllScore',
    	"columns":[
    		{data:'scoreid',title:'編號',},
    		{data:'gameid',title:'比賽場次',},
    		{data:'teamNameA',title:'主場',},
    		{data:'teamNameB',title:'客場',},
    		{data:'hitA',title:'主場安打',},
    		{data:'errA',title:'主場失誤',},
    		{data:'runA',title:'主場得分',},
    		{data:'recordA',title:'主場累積場數',},
    		{data:'hitB',title:'客場安打',},
    		{data:'errB',title:'客場失誤',},
    		{data:'runB',title:'客場得分',},
    		{data:'recordB',title:'客場累積場數',},
    		
    	]
    });
} );

</script>
</body>
</html>