<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>backstage</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>


	<a href="${contextRoot}/Team/getTeam">getStanding--���oMLB�y�����Z</a>  <br> 
	<a href="${contextRoot}/Team/updateStanding">updateStanding--��sMLB�y�����Z</a> <br> 
	<a href="${contextRoot}/Team/getImg">getImg--�q�R�A�귽���oMLB����</a> <br> 
	<a href="${contextRoot}/Player/GetFielder">GetFielderStat--���oMLB����ƾ�</a> <br> 
	<a href="${contextRoot}/Player/GetPitcher">GetPitcherStat--���oMLB���ƾ�</a> <br> 
	<a href="${contextRoot}/Team/getNBAteam">GetNBAStat--���oNBA�y�����Z</a> <br> 
	<a href="${contextRoot}/Team/updateNBAteam">updateNBAStat--��sNBA�y�����Z</a> <br> 
	<a href="${contextRoot}/NBAPlayer/get">updateNBAPlayerStat--���oNBA�y���ƾ�</a> <br> 
	------------------------------------------------------------------------------- <br> 
	<a href="${contextRoot}/getNews">getTodayNews--���o���Ѫ�MLB�s�D</a> <br> 
	<a href="${contextRoot}/getNBAnews">getTodayNewsNBA--���o���Ѫ�NBA�s�D</a> <br> 
	<a href="${contextRoot}/getHighLight">gethighLight--���oHIGHTLIGHT</a> <br> 
	<a href="${contextRoot}/News/searchNBA">seeNBA--NBA�s�D����</a> <br> 
</body>
</html>