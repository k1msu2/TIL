<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� �±�</h1>
	<hr>
	<%!int multiply(int n1, int n2) {
		return n1 * n2;
	}%>
	<%
		int result = 0;
		if (request.getMethod().equals("GET")) {
	%>
	<h3>���� 2���� �Է��ϼ���.</h3>
	<form method="post" action="/sedu/jspexam/exam5.jsp">
	���� 1
	<input type="number" name="su1">
	<br> ���� 2
	<input type="number" name="su2">
	<br>
	<input type="submit">
	</form>
	<%
		} else {
			int su1 = Integer.parseInt(request.getParameter("su1"));
			int su2 = Integer.parseInt(request.getParameter("su2"));
			result = multiply(su1, su2);
	%>
	<h2> ������ : <%=result%></h2>
	<a href="<%=request.getHeader("referer")%>"> �Է� ȭ������</a>
	
	<%
		}
	%>
</body>