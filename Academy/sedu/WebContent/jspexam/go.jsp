<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String study = request.getParameter("study");
		System.out.println(study);
		if (study == null) { %>
			out.print("<h2>study 라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>");
		<%} else {
			if (study.equals("javascript")) response.sendRedirect("http://www.w3schools.com/js/default.asp");
			else if (study.equals("dom")) 	response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
			else if (study.equals("ajax"))	response.sendRedirect("http://www.w3schools.com/xml/ajax_intro.asp");
			else if (study.equals("json")) 	response.sendRedirect("http://www.w3schools.com/js/js_json_intro.asp");
			else if (study.equals("jsp")) {%>
			 <jsp:forward page="/first.jsp">
  			 	<jsp:param name="gname" value="unico"/> <!-- forward 방법의 경우에  -->
  			 </jsp:forward>
			<%}					
			else if (study.equals("html")) {
			%>
			 <jsp:forward page="/first.html"/> <!-- forward는 한글을 EUC-KR / sendredirect는 한글을 UTF-8 -->
			<%}
			else{
				out.print("<h2> " + study + "라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>");
				
			}
		}
	%>
</body>
</html>