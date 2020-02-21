<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> Query 문자열 추출(GET&amp;POST) </h1>
<hr>
<%
	if(request.getMethod().equals("GET")){
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>당신의 이름은  <%=request.getParameter("name") %> 이군요!!</h2>
<a href="<%= request.getHeader("referer") %>"> 입력 화면으로</a> 
</body>