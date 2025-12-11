<%@page import="Beans.clientesBeans"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>
	
	
	<h1>EDITAR CLIENTES</h1>
	
<% String url = "http://localhost:8080/SistemaPrestamos/clientesController"; %>


	
	<form action="<%=url%>" method="POST">
		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="id_cliente" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getId_clientes()%>">


	    <label for="nombres">nombres</label><br>
		<input type="text" id="nombres" name="nombres" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getNombres()%>">
		<br>
		
		 <label for="apellidos">apellidos</label><br>
		<input type="text" id="apellidos" name="apellidos" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getApellidos()%>">
		<br>
		
		<label for="dni">dni</label><br>
		<input type="text" id="dni" name="dni" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getDni()%>">
		<br>
		
		<label for="fecha_nacimiento">Fecha de nacimiento</label><br>

		<input type="text" id="fecha_nacimiento" name="fecha_nacimiento" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getFecha_nacimiento()%>">
		<br>
		
		<label for="direccion">direccion</label><br>
		<input type="text" id="direccion" name="direccion" value="<%=((clientesBeans)request.getAttribute("clientes_llamado")).getDireccion()%>">
		<br>
		
		<button type="submit">Enviar</button>
		<button type="button" onclick="window.location.href='<%=url%>?op=listar'">Cancelar</button>

	</form>

</body>
</html>