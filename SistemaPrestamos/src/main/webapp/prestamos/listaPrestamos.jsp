<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="Beans.prestamosBeans" %>
	
<!DOCTYPE html>
<html>
<head>
<script>

function eliminar(id, nombre){
	if(confirm("Desea eliminar a " + nombre +  "? uwu")){
		location.href="prestamosController?op=eliminar&id_prestamo="+id;
	}
	else{
		text="Cancelado";
	}
}


</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>TITULO</title>
</head>
<body>

<% String url = "http://localhost:8080/SistemaPrestamos/prestamosController"; %>


<div class="container">

<a class="btn btn-primary" href="<%=url%>?op=nuevo">Nuevo Cliente</a>


<table class="table table-striped table-hover" id="tabla" border=1>
		<thead class="table-dark">
			<tr>
				<th>ID Prestamo</th>
				<th>Fecha prestamo</th>
				<th>Monto</th>
				<th>Interes</th>
				<th>Cuotas</th>
				<th>Cliente</th>
				<th>Operacion</th>
			</tr>
		</thead>
		<tbody>
<% 
List<prestamosBeans> listaPrestamos = (List<prestamosBeans>) request.getAttribute("listaPrestamos");
if(listaPrestamos != null){
	for(prestamosBeans prestamos_ : listaPrestamos){
		%>
		<tr>
		<td> <%=prestamos_.getIdPrestamo() %> </td>
		<td> <%=prestamos_.getFechaPrestamo() %> </td>
		<td> <%=prestamos_.getMonto() %> </td>
		<td> <%=prestamos_.getInteres() %> </td>
		<td> <%=prestamos_.getNumeroCuotas()%> </td>
		<td><%= prestamos_.getNombreCliente() %></td>
		

		<td>
			
			<a class="btn btn-warning" type="button" ">Editar</a>

			
			<a class="btn btn-danger" type="button" href="javascript:eliminar('<%=prestamos_.getIdPrestamo() %>', '<%=prestamos_.getNombreCliente() %>')">Eliminar</a>
			
		</td>
		</tr>
		<%	
	}
}
%>


	
			
		</tbody>
	</table>


</div>


</body>
</html>