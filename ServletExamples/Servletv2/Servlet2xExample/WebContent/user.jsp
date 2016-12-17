<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>User Information</title>

<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>

	<table>
		<tr>
			<th colspan="2">User Information</th>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>${requestScope.user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${requestScope.user.lastName}</td>
		</tr>
		<tr>
			<td>ID:</td>
			<td>${requestScope.user.id}</td>
		</tr>
		<tr>
			<td>Place:</td>
			<td>${requestScope.user.category}</td>
		</tr>
	</table>

	<p>
		Go back to <a href="index.html" class="link">application home</a>.
	</p>
</body>
</html>