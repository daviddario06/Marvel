package controllador;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class controlladorPelicula
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MetodosBBDD misMetodosBaseDeDatos;
	
	@Resource(name = "jdbc/Marvel")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
	
		try {
			misMetodosBaseDeDatos = new MetodosBBDD(miPool);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String instruccion = request.getParameter("instruccion");
		
		
		
		
		obtenerPeliculas(request,response);
		
	}

	private void obtenerPeliculas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List <Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		
		try {								
	
			listaPeliculas = misMetodosBaseDeDatos.obtenerPeliculas();
			request.setAttribute("LISTAPELICULAS", listaPeliculas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Algo.jsp");
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	
}
