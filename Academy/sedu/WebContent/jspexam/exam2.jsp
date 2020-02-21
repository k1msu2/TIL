<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%! int member_v = 0; %>
<% 
	int local_v = 0; 
	member_v += 10;
	local_v += 10;
%>
<ul>
	<li> 멤버 변수 : <%= member_v %></li> <!-- 수행하여 표현해라  -->
	<li> 로컬 변수 : <%= local_v %></li>
</ul>

</body>
</html>