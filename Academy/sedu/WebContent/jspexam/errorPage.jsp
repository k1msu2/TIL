<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %> 
<!-- !!!!!!!! 중요 / true여야지만 exception 변수를 사용가능, 기본 false 일 경우 exception 자동으로 추가 되지 않음
다른 내장객체 변수 들으느 자동으로 추가 되지만.. exception만 예외
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<h2>오류 발생했어욤ㅠㅠ</h2>
<h3>빠른시일내에 복구하겠습니다...</h3>
<img src="error.jpg">
<%	
    String msg = "오류 원인 : " + exception;	
	System.out.println("----------------------------------------");
	System.out.println(msg);
	System.out.println("----------------------------------------");	
	exception.printStackTrace();
%>
</body>
</html>






