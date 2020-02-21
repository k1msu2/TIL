<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 표현식 태그 테스트 </h1>
<hr>
<% int num = 10; %>
<ul>
	<li><%= 100 %></li>
	<li><%= num %></li>
	<li><%= ++num %></li>
	<li><%= num*2 %></li>
	<li><%= "가나다".length() %></li>
	<li><%= num %2 == 0 %></li>
	<li><%= request.getParameter("stname") %></li>
	<li><%= new java.util.Date(session.getCreationTime()) %></li>
	<!-- session 만들어지는게 기본. 안 만들어지게 설정을 할 수 있음. -->
	<li><%= application.getServerInfo() %> </li>
	<li><%= application.getContextPath() %></li>
	<!-- application -> servlet context 객체로 인식함. -->
</ul>
</body>