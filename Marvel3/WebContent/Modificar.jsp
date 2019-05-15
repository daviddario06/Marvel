<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import = "java.util.*, controllador.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Agregar</title>
		<style>
					table {
					  font-family: arial, sans-serif;
					  border-collapse: collapse;
					  width: 100%;
					}
					
					td, th {
					  border: 1px solid #dddddd;
					  text-align: left;
					  padding: 8px;
					}
					
					tr:nth-child(even) {
					  background-color: #dddddd;
					}
		</style>
	</head>
			
	<% Pelicula pelicula = (Pelicula) request.getAttribute("PELICULA");%>
					
	<body>
			<!-- action deberia agregar a la base de datos (una tabla donde se guardan las pelis vistas) -->
			<form action="Main" method="get">
			<table style="width:100%">
				  <tr>
				  	<th>id</th>
				    <th>Nombre</th>
				    <th>Emision</th> 
				    <th>Cronologico</th>
				    <th>Estado</th>
				  </tr>
				 			 
				 <tr>
				 
				    <td><%= pelicula.getId() %></td>
				    <td><%= pelicula.getNombre() %></td>
				    <td><%= pelicula.getEmision() %></td>
				    <td><%= pelicula.getCronologico() %></td>
				    <td><select name = "estado">
				    		<option value = "VISTO">VISTO</option>
				    		<option value = "POR VER">POR VER</option>
				    	</select>
				    </td>
				     	
				 </tr>
				 
			</table>
			<input type="submit" name = instruccion_1 value = "Guardar">
			<input type = hidden value = <%= pelicula.getId() %> name = "idPeli">
			</form>
	</body>
</html>