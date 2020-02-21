<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px dashed #ddd;
  table-layout:fixed;
}

tr:hover {background-color: #ddd;}


</style>
</head>
<body>
<h1>미팅 스케쥴(JSTL)</h1>
<hr>
<!-- varStatus -->
<c:forEach var="vo" items="${list}" varStatus="status">
	<table>
	<tr>
		<td width=100><c:out value ="${status.index}"/></td>
		<td width=100><c:out value="${vo.name}" /></td>
		<td width=400><c:out value="${vo.title}" /></td>
		<td width=200><c:out value="${vo.meetingDate}" /></td>
		<td>
			<a href="/mvc/meeting3?action=update&seqid=${vo.id}">
			<img src="/mvc/images/update.png" width="20px">
			</a>
		</td>
		<td>
			<a href="/mvc/meeting3?action=delete&seqid=${vo.id}">
			<img src="/mvc/images/delete.png" width="20px">
			</a>
		</td>
	<tr>
	</table>
</c:forEach>

<c:if test="${!empty msg}">
	<h4> ${msg} </h4>
</c:if>
<a href="/mvc/htmlexam/meetingForm3.html">미팅 홈 화면으로 가기</a>

</body>
</html>