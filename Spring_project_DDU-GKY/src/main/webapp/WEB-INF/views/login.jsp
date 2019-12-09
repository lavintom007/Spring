<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing of first tab</title>
</head>
<body>
<center>
<%@include file="_header.jsp" %>
<h1>Login</h1>
<form action="loginprocess" method="post">
<input type="text" name="email" placeholder="Email" id="email"><br><br>
<input type="text" name="password" placeholder="Password" id="password"><br><br>
<input type="submit" value="Login">
</form>
<%@include file="_footer.jsp" %>
</center>
</body>
</html>