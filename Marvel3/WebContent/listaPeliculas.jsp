
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "java.util.*, controllador.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de peliculas de marvel</title>

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

	<%List<Pelicula>peliculasMarvel = (List<Pelicula>) request.getAttribute("LISTAPELICULAS");%>

<body>
<br>

<jsp:include page="Index.jsp"></jsp:include>

<jsp:include page="filtros.jsp"></jsp:include>

<table style="width:100%">
  <tr>
 	<th>Id</th>
    <th>Nombre</th>
    <th>Emision</th> 
    <th>Cronologico</th>
    <th>Estado</th>
    <th> Actualizar estado</th>
  </tr>
  
  <% for (Pelicula e: peliculasMarvel){%>
	<tr>
		<td><%= e.getId() %></td>
	    <td><%= e.getNombre() %></td>
	    <td><%= e.getEmision() %></td>
	    <td><%= e.getCronologico() %></td>
	    <td><%= e.getEstado()%></td>
	    <td> <form action="Main" method = "get">
	    		<input type = "submit" value = "Modificar" name = "instruccion_1">
	    		<input type = hidden value = <%= e.getId() %> name = "idPeli">
	    	</form>
	    
	     </td>	
	</tr>
  <%} %>
  
</table>



</body>
</html>