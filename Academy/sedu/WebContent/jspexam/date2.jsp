<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제</title>
</head>
<body>
<%
	LocalDate ld2 = LocalDate.now();	
%>
<%= ld2.getYear() %>년  
<%= ld2.getMonthValue() %>월
<%= ld2.getDayOfMonth() %>일
</body>
</html>


