<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="errorPage.jsp" %> <%-- errorPage="errorPage.jsp" --%>
    <!-- jsp : errorpage 속성 
    	servlet : error 페이지 포워드나 리다이렉트를 해주어야함
    -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>errorPage 속성 테스트</h2>
<hr>
<%
     String name = request.getParameter("guestName"); 
%>
<h3>당신의 이름은 <%= name %> 이고 이름의 길이는
           <%= name.length() %> 입니다.</h3>
</body>
</html>















