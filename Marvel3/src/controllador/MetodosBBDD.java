package controllador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
