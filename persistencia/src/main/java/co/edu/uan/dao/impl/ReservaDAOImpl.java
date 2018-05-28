package co.edu.uan.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import co.edu.uan.connection.DataSource;
import co.edu.uan.dao.IReserva;
import co.edu.uan.dto.ReservaDTO;

public class ReservaDAOImpl implements IReserva {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	private String query;

	@Override
	public void saveReservacion(ReservaDTO dto) {
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			
			query = "INSERT INTO reservaciones (reservacion_nombre_completo_usuario, reservacion_num_identificacion_usuario,"
					+ "reservacion_direccion_usuario, reservacion_telefono_usuario, reservacion_celular_usuario,"
					+ "reservacion_numero_tarjeta_usuario, reservacion_fecha_exp_tarjeta_usuario, reservacion_nombre_tarjeta_usuario,"
					+ "reservacion_precio_total, reservacion_fecha_inicial, reservacion_fecha_final, id_alojamiento_reservado_fk, id_usuario_fk)"
					+ "VALUES ('"+dto.getNombreCompleto()+"', '"+dto.getNumeroIdentificacion()+"', '"+dto.getDireccion()+"',"
					+ "'"+dto.getTelefono()+"', '"+dto.getCelular()+"', '"+dto.getNumeroTarjeta()+"', '"+dto.getFechaExpiracion()+"',"
					+ "'"+dto.getNombreTarjeta()+"', '"+dto.getPago()+"', '"+dto.getFechaInicial()+"', '"+dto.getFechaFinal()+"',"
					+ "'"+dto.getIdAlojamiento()+"', '"+dto.getIdUsuario()+"');";
			
			sentencia.executeUpdate(query);
			sentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
