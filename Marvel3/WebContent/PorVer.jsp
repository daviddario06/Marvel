<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.*, controllador.*" %>
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
			<form action="Main" method="get">
				
  				<p>
  				<input type="radio" name="instruccion_1" value="todas"> Todas<br>
  				<input type="radio" name="instruccion_1" value="visto"> Vistas<br>
  				<input type="radio" name="instruccion" value="porVer"> PorVer<br>
				</p>
			
				<p>
  				<input type="radio" name="instruccion_2" value="emision"> En Emision<br>
  				<input type="radio" name="instruccion_2" value="cronologica"> Cronologico<br>
  				</p>
				
				<input type="submit" value="Ordenar">
			</form>
			
			
			<br>
	
	</body>
</html>