package controllador;
import java.sql.*;
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
			String consultaSql = "SELECT *FROM PELICULAS ORDER BY \"ID\"";
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
			
			if (e.getEstado().equals("POR VER")) {
				pelisPorMirar.add(e);
			}
		}
		
		return pelisPorMirar;

	}


	public Pelicula obtenerPelicula(int id) {

		Pelicula pelicula = null;
		Connection conexion = null;
		PreparedStatement miStatement = null;
		ResultSet rs = null;
		
		try {
			conexion = datosConexion.getConnection();
			String sql = "SELECT * FROM PELICULAS WHERE \"ID\" = ?";
			
			miStatement = conexion.prepareStatement(sql);

			miStatement.setInt(1, id);
			rs = miStatement.executeQuery();
			
			while (rs.next()) {
				pelicula = new Pelicula(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
			}
			
			rs.close();
			miStatement.close();
			conexion.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return pelicula;
	}

	public void actualizarEstado(int id, String estado) {
		
		Connection conexion = null;
		PreparedStatement miStatement = null;
		
		try {
			conexion = datosConexion.getConnection();
			String sql = "UPDATE PELICULAS SET \"ESTADO\" = ? WHERE \"ID\" = ?";
			
			miStatement = conexion.prepareStatement(sql);

			miStatement.setString(1, estado);
			miStatement.setInt(2, id);
			miStatement.execute();
			
			
			miStatement.close();
			conexion.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
