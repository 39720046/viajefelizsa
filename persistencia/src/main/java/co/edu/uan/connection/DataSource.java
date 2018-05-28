package co.edu.uan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	private final String URL = "jdbc:postgresql://localhost:5432/viajefeliz";
	private final String USUARIO = "postgres";
	private final String PASS = "root";
	private Connection conexion;
	private static DataSource baseDatos;
	
	public static DataSource getInstance() {
		
		if (baseDatos == null) {
			
			baseDatos = new DataSource();
			
		}
		
		return baseDatos;
	}
	
	private DataSource() {
		this.conexion = null;
	}
	
	@SuppressWarnings("finally")
	public Connection conectar() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, PASS);			
			System.out.println("Conexión exitosa a ... " + URL);
			
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		} finally {
			
			return conexion;
			
		}
		
	}

}
