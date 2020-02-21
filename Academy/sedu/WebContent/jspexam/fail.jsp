<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int min = java.time.LocalDateTime.now().getMinute();
int hour = java.time.LocalDateTime.now().getHour();
%>
<h1> <%=hour%>시 <%=min %>분에 당첨 실패..아쉽..아쉽..</h1>
<img src ="http://70.12.115.177:8000/sedu/images/fail.jpg">
<a href="<%=request.getHeader("referer")%>"> 로또 응모</a>
</body>
</html>