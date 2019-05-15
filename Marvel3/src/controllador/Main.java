package controllador;

import java.io.*;

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
		
		String instruccion = request.getParameter("instruccion");
		
		if (instruccion == null)
			instruccion = "mostrarLista";
		
		switch (instruccion) {

		case "mostrarLista": obtenerPeliculas(request,response);
		break;
		
		case "ordenCronologico": obtenerPeliculasPorCronologia(request, response);
			break;
			
		case "ordenEmision":obtenerPeliculasEmision (request,response);
			break;
			
		case "porVer": obtenerPeliculasPorVer (request,response);
			break;
			
		case "vistas": obtenerPeliculasVistas (request,response);	
		
		case "Agregar": agregarPelicula(request, response);
		
		default:  obtenerPeliculas(request,response);
		}
			
		
	}

	private void agregarPelicula(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nombrePeli = request.getParameter("nombre");
		int emision = Integer.parseInt(request.getParameter("emision"));
		int cronologico = Integer.parseInt(request.getParameter("cronologico"));
		String estado = request.getParameter("estado");
		
		misMetodosBaseDeDatos.agregarPelicula(nombrePeli,emision,cronologico,estado);
		
		obtenerPeliculas(request, response);
	}

	private void obtenerPeliculasVistas(HttpServletRequest request, HttpServletResponse response) {
		
	List <Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	List <Pelicula> listaTemp = new ArrayList<Pelicula>();
		
		
		try {								
	
			listaPeliculas = misMetodosBaseDeDatos.obtenerPeliculas();
			listaTemp = misMetodosBaseDeDatos.obtenerVistas(listaPeliculas);		
			request.setAttribute("LISTAPELICULAS", listaTemp);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Algo.jsp");
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	}

	private void obtenerPeliculasPorVer(HttpServletRequest request, HttpServletResponse response) {
	
		List <Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		List <Pelicula> listaTemp = new ArrayList<Pelicula>();
		
		try {								
	
			listaPeliculas = misMetodosBaseDeDatos.obtenerPeliculas();
			listaTemp = misMetodosBaseDeDatos.obtenerPeliculasPorMirar(listaPeliculas);		
			request.setAttribute("LISTAPELICULAS", listaTemp);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Algo.jsp");
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	}

	private void obtenerPeliculasPorCronologia(HttpServletRequest request, HttpServletResponse response) {
		List <Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		
		
		try {								
	
			listaPeliculas = misMetodosBaseDeDatos.obtenerPeliculas();
			listaPeliculas = misMetodosBaseDeDatos.ordenarPorCronologia(listaPeliculas);		
			request.setAttribute("LISTAPELICULAS", listaPeliculas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Algo.jsp");
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void obtenerPeliculasEmision(HttpServletRequest request, HttpServletResponse response) {
		List <Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		
				
				try {								
					
					listaPeliculas = misMetodosBaseDeDatos.obtenerPeliculas();
					listaPeliculas = misMetodosBaseDeDatos.ordenarPorEmision(listaPeliculas);			
					request.setAttribute("LISTAPELICULAS", listaPeliculas);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Algo.jsp");
					dispatcher.forward(request, response);
					
				}catch (Exception e) {
					e.printStackTrace();
		}
		
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
