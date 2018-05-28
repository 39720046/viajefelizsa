package co.edu.uan.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import co.edu.uan.connection.DataSource;
import co.edu.uan.dao.IUsuario;
import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.dto.UsuarioDTO;

public class UsuarioDAOImpl implements IUsuario {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet resulSet = null;
	private String query;

	@Override
	public void registrar(UsuarioDTO usuario) {
		
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "INSERT INTO usuarios (fullname_usuario, username_usuario, password_usuario) VALUES ('"+usuario.getName()+"', '"+usuario.getUsername()+"', '"+usuario.getPassword()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String login(UsuarioDTO usuario) {
				
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM usuarios WHERE username_usuario = '"+usuario.getUsername()+"' AND password_usuario = '"+usuario.getPassword()+"';";
			resulSet = sentencia.executeQuery(query);
			if (resulSet.next()) {
				return resulSet.getString("id_usuario");
			}
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
		
	}

	@Override
	public void asignarRol(UsuarioDTO usuario) {
		
		try {
			String code = null;
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT usu_codigo FROM usuario WHERE usu_login = '"+usuario.getUsername()+"'";
			resulSet = sentencia.executeQuery(query);
			
			while (resulSet.next()) {
				code = resulSet.getString("usu_codigo");
			}
			
			
			query = "INSERT INTO usuario_grupo (usg_usuario, usg_grupo) VALUES ('"+code+"', 2);";
			sentencia.executeUpdate(query);
			sentencia.close();
			resulSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ReservaDTO> getReservasUsuario(String idUsuario) {

		String nombreAlojamiento = null;
		String fechaInicial = null;
		String fechaFinal = null;
		Integer pago = null;
		ArrayList<ReservaDTO> reservas = new ArrayList<>();
		
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM reservaciones WHERE id_usuario_fk = '"+idUsuario+"';";
			resulSet = sentencia.executeQuery(query);
			
			while (resulSet.next()) {
				nombreAlojamiento = resulSet.getString("reservacion_nombre_completo_usuario");
				fechaInicial = resulSet.getString("reservacion_fecha_inicial");
				fechaFinal = resulSet.getString("reservacion_fecha_final");
				pago = resulSet.getInt("reservacion_precio_total");
				reservas.add(new ReservaDTO(nombreAlojamiento, fechaInicial, fechaFinal, pago));
			}

			resulSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservas;
	}

}
