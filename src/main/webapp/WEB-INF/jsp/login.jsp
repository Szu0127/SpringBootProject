<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Login</h3>
	<form action="/login/page" method="post"></form>
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>PassWord:</td>
			<td><input type="password" name="password">
		</tr>
		<tr>
			<td colspan="2"><input type="checkbox" name="remember-me" />RememberMe</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit" value="login">Login</button></td>
		</tr>
	</table>
	</form>


</body>
</html>