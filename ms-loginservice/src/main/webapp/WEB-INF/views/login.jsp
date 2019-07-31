<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
Hello from Login Page
</h1>
<form action="/rest/client/callservice" method="post">
Username<input type="text" name="t1" >
Password<input type="password" name="t2" >
<input type="submit" name="t3" value="submit" >

</form>
</body>
</html>