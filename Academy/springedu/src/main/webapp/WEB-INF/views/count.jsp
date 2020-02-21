<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP test example</title>
</head>
<body>
<h1>Counting Result</h1>
<hr>
<h2>sessionScope</h2>
<h3>count1 : ${ sessionScope.count1.countNum }</h3>
<h3>count2 : ${ sessionScope.count2.countNum }</h3>
<h2>requestScope</h2>
<h3>count1 : ${ requestScope.count1.countNum }</h3>
<h3>count2 : ${ requestScope.count2.countNum }</h3>
</body>
</html>



