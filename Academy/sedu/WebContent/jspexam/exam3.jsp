<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> ǥ���� �±� �׽�Ʈ </h1>
<hr>
<% int num = 10; %>
<ul>
	<li><%= 100 %></li>
	<li><%= num %></li>
	<li><%= ++num %></li>
	<li><%= num*2 %></li>
	<li><%= "������".length() %></li>
	<li><%= num %2 == 0 %></li>
	<li><%= request.getParameter("stname") %></li>
	<li><%= new java.util.Date(session.getCreationTime()) %></li>
	<!-- session ��������°� �⺻. �� ��������� ������ �� �� ����. -->
	<li><%= application.getServerInfo() %> </li>
	<li><%= application.getContextPath() %></li>
	<!-- application -> servlet context ��ü�� �ν���. -->
</ul>
</body>