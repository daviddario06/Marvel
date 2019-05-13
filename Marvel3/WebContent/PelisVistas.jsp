<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ya vistas</title>
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
	
		<table style="width:100%">
		  <tr>
		    <th>Nombre</th>
		    <th>Emision</th> 
		    <th>Cronologico</th>
		    <th>Estado</th>
		  </tr>
		  
		  <tr>
			<td>IronMan(?)</td>
		    <td>Quien sabe</td>
		    <td>??</td>
		    <td>Obvio que vista</td>
		    	
		 </tr>
		</table>
		<br>
		<form action="http://localhost:8080/Marvel3/Agregar.jsp">
		<input type="submit" value="Agregar">
		</form>
	</body>
</html>