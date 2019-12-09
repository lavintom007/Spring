<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing of second page</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<center>
<form action="studentprocess" method="post">
<h2>Student Login</h2><br>
<input type="number" name="stid" id="stid"placeholder="PGK-ID"><br><br>
<input type="text" name="password" id="password"placeholder="Password"><br><br>
<input type="submit" id="register" value="Login in">
</form>
<jsp:include page="_footer.jsp"></jsp:include>
</center>
</body>
</html>