<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchPage</title>
</head>
<body>
<h1>Search Flight by their details</h1>
<form  action="search">  
<table align = "center" bgcolor ="lightblue" width = 50%>
	<tr>
		<th>Source</th>
		<td><input type = text name ="src"></td>
	</tr>
	<tr>
		<th>Destination</th>
		<td><input type = text name="dest"></td>
	</tr>
	<tr>
		<td><input type = submit value = Search></td>
		<td><input type = reset value = Cancel></td>
	</tr>
	</table>
</form>

</body>
</html>