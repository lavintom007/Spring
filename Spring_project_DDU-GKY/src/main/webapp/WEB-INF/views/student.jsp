<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.ddu_gky.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student result page</title>
</head>
<body>

<%@include file="_header.jsp" %>
<center>
<h1>Result</h1>
<%
 		ArrayList<Mark> p = (ArrayList<Mark>) request.getAttribute("mdetails");

%>
<%for(Mark v : p)
{%>
   Student ID : <%=v.getStid() %><br><br>
	Date :<%= v.getDate()%><br><br>
	Viva :<%=v.getViva() %><br><br>
	Completion :<%=v.getCompletion() %><br><br>
	Overall :<%=v.getOverall() %><br><br>
	
	<%} %>
</center>
<%@include file="_footer.jsp" %>
</body>
</html>