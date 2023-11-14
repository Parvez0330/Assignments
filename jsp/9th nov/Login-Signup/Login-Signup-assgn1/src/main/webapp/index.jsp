<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="valid.jsp">
		<label for="uname">Enter your user name</label> <br> <input
			type="text" name="uname" placeholder="Enter your username" /> <br>
		<label for="pass">Enter your password</label> <br> <input
			type="password" name="pass" placeholder="Enter your password" /> <br>
		<br>
		<button type="submit" name="login">submit</button>
	</form>
	<form action="customer.jsp">
		<p>Not registered yet</p>
		<button type="submit" name="register">Register</button>
	</form>

</body>
</html>