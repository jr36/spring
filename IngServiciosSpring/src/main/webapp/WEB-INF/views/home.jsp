<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring 1.4</title>
</head>
<body>
<h1>Practica 1.4 de Spring</h1>
<h2>Autenticacion</h2>
<form action="Servlet1" method=post>
Nombre: <input type=text name=user>
<br>
Contraseña: <input type=password name= pass>	
<br>
<input type=submit value=Continuar>
</form>

</body>
</html>
