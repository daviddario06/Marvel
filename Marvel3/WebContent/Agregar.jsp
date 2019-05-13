<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			
	<body>
			<!-- action deberia agregar a la base de datos (una tabla donde se guardan las pelis vistas) -->
			<form action="http://localhost:8080/Marvel3/Index.jsp" method="get">
			<table style="width:100%">
				  <tr>
				    <th>Nombre</th>
				    <th>Emision</th> 
				    <th>Cronologico</th>
				    <th>Estado</th>
				  </tr>
				 
				  <tr>
					<td>IronMan4(?)</td>
				    <td>Quien sabe</td>
				    <td>??</td>
				    <td><input type="checkbox" name="Pelicula" value="Vista">Vista?</td>
				 </tr>
				 
				 <tr>
					<td>Capitan America(?)</td>
				    <td>Quien sabe</td>
				    <td>??</td>
				    <td><input type="checkbox" name="Pelicula" value="Vista">Vista?</td>   	
				 </tr>
				 
			</table>
			<input type="submit" value="Submit">
			</form>
	</body>
</html>