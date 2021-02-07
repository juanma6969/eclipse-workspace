<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hola mundo1</h1>
<a href="MyServlet?var1=2&var2=6">Creami</a>
<form action="MyServlet" method="post">
	<label>INGRESE un numero</label>
	<input TYPE="text" name="numero1">
	<button type="submit">Enviar</button>
	<label>INGRESE un numero</label>
	<input TYPE="text" name="numero2">
	

</form>
</body>
</html>