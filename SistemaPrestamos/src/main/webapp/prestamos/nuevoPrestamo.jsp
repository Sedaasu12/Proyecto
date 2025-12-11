<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Beans.clientesBeans"%>

<%

List<clientesBeans> listaClientes = (List<clientesBeans>) request.getAttribute("listaClientes");

%>pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>


<meta charset="UTF-8">
<title>crea tu nuevo prestamo</title>
</head>
<body>

	
<% String url = "http://localhost:8080/SistemaPrestamos/prestamosController"; %>


<div class="container">

</div>

<div class="card" style="width: 18rem;">

	<h5 class="card-title">Nuevo Prestamo</h5>


	<form action="<%=url%>" method="POST">
		<input type="hidden" name="op" value="insertar">
	    <label for="Fecha prestamo">Fecha prestamo</label><br>
		<input type="text" id="fecha_prestamo" name="fecha_prestamo">
		<br>
		
		 <label for="Monto">Monto</label><br>
		<input type="text" id="monto" name="monto">
		<br>
		
		 <label for="Interes">Interes</label><br>
		<input type="text" id="interes" name="interes">
		<br>
		
		<label for="Cuotas">Cuotas</label><br>
		<input type="text" id="cuotas" name="cuotas">
		<br>
		
		</label>
            <select class="form-select" name="autor" id="autor" required>
                <option value="">Seleccione un Cliente...</option>
                <%
                if (listaClientes != null && !listaClientes.isEmpty()) {
                    for (clientesBeans cliente : listaClientes) {
                %>
                <option value="<%=cliente.getId_clientes()%>"><%=cliente.getNombres()%></option>
                <%
                    }
                } else {
                %>
                <option value="" disabled>No hay autores disponibles</option>
                <%
                }
                %>
            </select>
            <div class="invalid-feedback">
                Por favor seleccione un autor
            </div>
        </div>
		
		<button type="submit">Enviar</button>
		<button type="button" onclick="window.location.href='<%=url%>?op=listar'">Cancelar</button>

	</form>

</div>


	

</body>
</html>