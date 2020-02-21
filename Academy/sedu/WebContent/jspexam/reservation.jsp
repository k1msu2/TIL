<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.format.*"
    import="java.time.*"
    import="java.util.regex.*"
    %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
if (request.getMethod().equals("POST")){ %>
<h1><%=request.getParameter("id")%>님의 예약 내용</h1>
<hr>
<ul>
<li>룸 : <%= request.getParameter("room")%></li>
<%
String result="";
String ReqParam[] = request.getParameterValues("option");
if(ReqParam == null){
	result = "없음";
}else {
	for(int i = 0; i < ReqParam.length ; i++) {
		if(ReqParam[i] !="") result += ReqParam[i]+ ", ";
	}
}
%>
<li>추가 요청 사항 : <%= result.substring(0,result.length()-2)%></li>
<%

/* 
	String optionString =
			options == null? "없음":String.join(", ", options); 
*/
String date = request.getParameter("date");
String pattern = "(\\d{4})-(\\d{2})-(\\d{2})";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(date);
String datestr="";
while(m.find()) {
	datestr = String.format("%s년%s월%s일", m.group(1), m.group(2), m.group(3));
}
%>
<li>예약날짜: <%= datestr %> </li>
</ul>
<a href="/sedu/html/reservation.html">예약 입력 화면으로  </a>
<% } else {%>
<%} %>
</body>
</html>