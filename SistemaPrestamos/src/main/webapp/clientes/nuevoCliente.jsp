<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>


<meta charset="UTF-8">
<title>crea tu nuevo cliente</title>
</head>
<body>

	
	
	
<% String url = "http://localhost:8080/SistemaPrestamos/clientesController"; %>


<div class="container">

</div>

<div class="card" style="width: 18rem;">

	<h5 class="card-title">Nuevo Cliente</h5>


	<form action="<%=url%>" method="POST">
		<input type="hidden" name="op" value="insertar">		
	    <label for="nombres">nombres</label><br>
		<input type="text" id="nombres" name="nombres">
		<br>
		
		 <label for="apellidos">apellidos</label><br>
		<input type="text" id="apellidos" name="apellidos">
		<br>
		
		<label for="dni">dni</label><br>
		<input type="text" id="dni" name="dni">
		<br>
		
		 <label for="fecha_nacimiento">fecha_nacimiento</label><br>
		<input type="text" id="fecha_nacimiento" name="fecha_nacimiento">
		<br>
		
		<label for="direccion">direccion</label><br>
		<input type="text" id="direccion" name="direccion">
		<br>
		
		<button type="submit">Enviar</button>
		<button type="button" onclick="window.location.href='<%=url%>?op=listar'">Cancelar</button>

	</form>

</div>


	

</body>
</html>