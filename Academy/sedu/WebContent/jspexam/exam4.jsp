<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> Query ���ڿ� ����(GET&amp;POST) </h1>
<hr>
<%
	if(request.getMethod().equals("GET")){
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>����� �̸���  <%=request.getParameter("name") %> �̱���!!</h2>
<a href="<%= request.getHeader("referer") %>"> �Է� ȭ������</a> 
</body>