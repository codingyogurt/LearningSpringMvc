<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login to BASIC APP</title>
</head>
<body>

<form action="/bukasan" method="post">

Login to view Welcome! <br>
${indexMessage} <br>
Username:
<input type="text" name="txtUsername"/> <br>
Password:
<input type="password" name="txtPassword"/> <br>
<input type="submit" value="Submit"/>

</form>

</body>
</html>