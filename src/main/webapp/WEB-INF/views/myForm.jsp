<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "javax.sql.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "formPage" method = "get">

<!--  <form method = "post" action = "exchange.jsp">-->
<p>Questions:  <input type = "text" name = "questions"></p><br>
<p>Answers: <input type = "text" name = "answers"></p><br>
<p>Comment: <input type = "text" name = "comment"></p><br>
<input type = "submit" value = "Submit">


</form>
</body>
</html>