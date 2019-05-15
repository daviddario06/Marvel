package controllador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
;

public class Prueba {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conexion = null;
		PreparedStatement miStatement = null;
		ResultSet rs = null;
		try {
			
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Marvel", "postgres", "postgres");
		
			String sql = "SELECT * FROM PELICULAS WHERE \"ID\" = ?";
			
			miStatement = conexion.prepareStatement(sql);

			miStatement.setInt(1, 1);
			rs = miStatement.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getString("NOMBRE"));
			}

			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			miStatement.close();
			conexion.close();
		}
	}

}