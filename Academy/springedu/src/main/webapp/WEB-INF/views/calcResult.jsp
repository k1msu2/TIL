<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연산 요청 결과</h1>
<h2>결과 : ${requestScope.result} </h2><br>
<a href = "${header.referer}">입력화면</a>
</body>
</html>