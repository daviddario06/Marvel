package controllador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

public class MetodosBBDD {
	private DataSource datosConexion;

	public MetodosBBDD(DataSource datosConexion) {
		this.datosConexion = datosConexion;
	}
	
	public List<Pelicula> obtenerPeliculas(){
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		Pelicula tempP;
		Connection conexion = null;
		Statement miStatement = null;
		ResultSet rs = null;
		
		try {								
			
			conexion = datosConexion.getConnection();
			miStatement = conexion.createStatement();
			String consultaSql = "SELECT *FROM PELICULAS";
			rs = miStatement.executeQuery(consultaSql);
			
			
			while (rs.next()) {
				
				int iDPelicula = rs.getInt("ID");
				String nombre_peli = rs.getString("NOMBRE");
				int anioEmision = rs.getInt("ANIO_EMISION");
				int anioCronologico = rs.getInt("ANIO_CRONOLOGICO");
				String estado = rs.getString("ESTADO");
				
				tempP = new Pelicula(iDPelicula, nombre_peli,anioEmision,anioCronologico,estado);
				
				peliculas.add(tempP);
				
			}
			rs.close();
			miStatement.close();
			conexion.close();
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return peliculas;
	}

	public List<Pelicula> ordenarPorEmision(List <Pelicula> peliculasEmision){
		
		Collections.sort(peliculasEmision, new Comparator<Pelicula>() {
			public int compare (Pelicula peli1, Pelicula peli2) {
				
				if (peli1.getEmision() > peli2.getEmision())
					return 1;
				else if (peli1.getEmision() < peli2.getEmision())
					return -1;
				else
					return 0;
				
			}
		});
		
		
		return  peliculasEmision;
	}

	public List<Pelicula> ordenarPorCronologia(List <Pelicula> peliculasCronologicamente){
		
		
		Collections.sort(peliculasCronologicamente, new Comparator<Pelicula>() {
			public int compare (Pelicula peli1, Pelicula peli2) {
				
				if (peli1.getCronologico() > peli2.getCronologico())
					return 1;
				else if (peli1.getCronologico() < peli2.getCronologico())
					return -1;
				else
					return 0;
				
			}
		});
		
		return  peliculasCronologicamente;
	}

	public List<Pelicula> obtenerVistas(List<Pelicula> listaPeliculas) {
		
		List <Pelicula> pelisVistas = new ArrayList<Pelicula>();
		
		for (Pelicula e : listaPeliculas) {
			
			if (e.getEstado().equals("VISTO")) {
				pelisVistas.add(e);
			}
		}
		
		return pelisVistas;
	}

	public List<Pelicula> obtenerPeliculasPorMirar(List<Pelicula> listaPeliculas) {
		
		List <Pelicula> pelisPorMirar = new ArrayList<Pelicula>();
		
		for (Pelicula e : listaPeliculas) {
			
			if (e.getEstado().equals("DISPONIBLE")) {
				pelisPorMirar.add(e);
			}
		}
		
		return pelisPorMirar;

	}
}
