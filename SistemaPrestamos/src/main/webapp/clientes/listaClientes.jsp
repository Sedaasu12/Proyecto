<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="Beans.clientesBeans" %>
	
<!DOCTYPE html>
<html>
<head>
<script>

function eliminar(id, nombre){
	if(confirm("Desea eliminar a " + nombre +  "? uwu")){
		location.href="clientesController?op=eliminar&id_cliente="+id;
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

<% String url = "http://localhost:8080/SistemaPrestamos/clientesController"; %>


<div class="container">

<a class="btn btn-primary" href="<%=url%>?op=nuevo">Nuevo Cliente</a>


<table class="table table-striped table-hover" id="tabla" border=1>
		<thead class="table-dark">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>DNI</th>
				<th>Fecha Nacimiento</th>
				<th>Direccion</th>
				<th>Operacion</th>
			</tr>
		</thead>
		<tbody>
<% 
List<clientesBeans> listaClientes = (List<clientesBeans>) request.getAttribute("listaClientes");
if(listaClientes != null){
	for(clientesBeans clientes_ : listaClientes){
		%>
		<tr>
		<td> <%=clientes_.getId_clientes() %> </td>
		<td> <%=clientes_.getNombres() %> </td>
		<td> <%=clientes_.getApellidos() %> </td>
		<td> <%=clientes_.getDni() %> </td>
		<td> <%=clientes_.getFecha_nacimiento()%> </td>
		<td> <%=clientes_.getDireccion() %> </td>
		<td>
			
			<a class="btn btn-warning" type="button" href="<%=url%>?op=editar&id=<%=clientes_.getId_clientes() %>">Editar</a>

			
			<a class="btn btn-danger" type="button" href="javascript:eliminar('<%=clientes_.getId_clientes() %>', '<%=clientes_.getNombres() %>')">Eliminar</a>
			
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