<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
<h1><%=request.getParameter("id")%> 님은 D등급입니다. 꾸준히 노력하세요.</h1>
<h1>${param.id} 님은 D등급입니다. 꾸준히 노력하세요.</h1>
<a href="/mvc/htmlexam/eduForm.html">성적 입력 화면으로  </a><br>
<a href= "<%=request.getHeader("referer") %>">성적 입력 화면으로</a>
</body>
</html>