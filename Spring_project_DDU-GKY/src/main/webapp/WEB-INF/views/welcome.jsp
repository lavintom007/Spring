<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<%@ include file="_header.jsp" %>
<br>
Hello, 
<%=request.getAttribute("firstname")%>
<h3></h3><br>
Now you can add mark to students based on their daily performance!!
<br>
<center>
<form action="uploadprocess" method="post">
<h3>Student Mark</h3>
<br>
Date: <input type="date" name="date" id="date"><br><br>
PGK-<input type="number" name="stid" id="stid"><br><br>
Viva :<select name="viva">
    <option value="5">5</option>
    <option value="4">4</option>
    <option value="3">3</option>
    <option value="2">2</option>
    <option value="1">1</option>
    <option value="0">0</option>
  </select>
 Completion :<select name="completion" id="completion">
    <option value="5">5</option>
    <option value="4">4</option>
    <option value="3">3</option>
    <option value="2">2</option>
    <option value="1">1</option>
    <option value="0">0</option>
  </select>
  Overall :<select name="overall" id="overall">
    <option value="5">5</option>
    <option value="4">4</option>
    <option value="3">3</option>
    <option value="2">2</option>
    <option value="1">1</option>
    <option value="0">0</option>
  </select>
  <br><br>
  <input type="submit" value="upload" name="upload" id="upload">
  </form>
</center><bvr><br>
<%@ include file="_footer.jsp" %>
</body>
</html>