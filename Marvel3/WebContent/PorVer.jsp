<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Por ver</title>
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
			<br>
			<form action="">
			<select>
			  <option value="Cronologico">Cronologico</option>
			  <option value="Emision">Emision</option>
			</select>
				<input type="submit" value="Ordenar">
			</form>
			
			<br>
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
			    <td>Y no vista</td>
			    	
			 </tr>
			</table>
	</body>
</html>