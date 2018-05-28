package co.edu.uan.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import co.edu.uan.connection.DataSource;
import co.edu.uan.dao.IAlojamiento;
import co.edu.uan.dto.AlojamientoDTO;

public class AlojamientoDAOImpl implements IAlojamiento {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet resulSet = null;
	private String query;

	@Override
	public void postularAlojamiento(AlojamientoDTO alojamiento) {
		
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			
			query = "INSERT INTO alojamiento (nombre_alojamiento, tipo_alojamiento, personas_alojamiento, "
					+ "habitaciones_alojamiento, banos_alojamiento, calefaccion_alojamiento, aire_acondicionado_alojamiento, "
					+ "mascotas_alojamiento, ciudad_alojamiento, barrio_alojamiento, descripcion_alojamiento, precio_alojamiento) "
					+ "VALUES ('" + alojamiento.getNombre() + "', '" + alojamiento.isTipo() + "', '"
					+ alojamiento.getCantidadPersonas() + "', " + "'" + alojamiento.getCantidadHabitaciones() + "', '"
					+ alojamiento.getCantidadBanos() + "', '" + alojamiento.isCalefaccion() + "', " + "'"
					+ alojamiento.isAireAcondicionado() + "', '" + alojamiento.isMascotas() + "', '"
					+ alojamiento.getCiudad() + "', '" + alojamiento.getBarrio() + "', " + "'"
					+ alojamiento.getDescripcion() + "', '" + alojamiento.getPrecio() + "');";
			
			sentencia.executeUpdate(query);
			sentencia.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<AlojamientoDTO> getAllAlojamientos() {
		
		ArrayList<AlojamientoDTO> alojamientos = null;
		int id;
		String nombre;
		boolean tipo;
		Integer cantidadPersonas;
		Integer cantidadHabitaciones;
		Integer cantidadBanos;
		boolean calefaccion;
		boolean aireAcondicionado;
		boolean mascotas;
		String ciudad;
		String direccion;
		String barrio;
		String descripcion;
		Integer precio;

		try {
			alojamientos = new ArrayList<>();
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM alojamientos;";
			resulSet = sentencia.executeQuery(query);

			while (resulSet.next()) {
				id = resulSet.getInt("id_alojamiento");
				nombre = resulSet.getString("nombre_alojamiento");
				tipo = resulSet.getBoolean("tipo_alojamiento");
				cantidadPersonas = resulSet.getInt("cantidad_personas_alojamiento");
				cantidadHabitaciones = resulSet.getInt("cantidad_habitaciones_alojamiento");
				cantidadBanos = resulSet.getInt("cantidad_banos_alojamiento");
				calefaccion = resulSet.getBoolean("calefaccion_alojamiento");
				aireAcondicionado = resulSet.getBoolean("aire_acondicionado_alojamiento");
				mascotas = resulSet.getBoolean("mascotas_alojamiento");
				ciudad = resulSet.getString("ciudad_alojamiento");
				direccion = resulSet.getString("direccion_alojamiento");
				barrio = resulSet.getString("barrio_alojamiento");
				descripcion = resulSet.getString("descripcion_alojamiento");
				precio = resulSet.getInt("precio_alojamiento");
				alojamientos.add(new AlojamientoDTO(id, nombre, tipo, cantidadPersonas, cantidadHabitaciones, cantidadBanos,
						calefaccion, aireAcondicionado, mascotas, ciudad, barrio, direccion, descripcion, precio));
			}

			resulSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alojamientos;

	}

	@Override
	public AlojamientoDTO getAlojamientoById(String id) {
		AlojamientoDTO alojamiento = null;
		int id_alojamiento;
		String nombre;
		boolean tipo;
		Integer cantidadPersonas;
		Integer cantidadHabitaciones;
		Integer cantidadBanos;
		boolean calefaccion;
		boolean aireAcondicionado;
		boolean mascotas;
		String ciudad;
		String direccion;
		String barrio;
		String descripcion;
		Integer precio;
		try {
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM alojamientos WHERE id_alojamiento = '" + id + "';";
			resulSet = sentencia.executeQuery(query);

			while (resulSet.next()) {
				id_alojamiento = resulSet.getInt("id_alojamiento");
				nombre = resulSet.getString("nombre_alojamiento");
				tipo = resulSet.getBoolean("tipo_alojamiento");
				cantidadPersonas = resulSet.getInt("cantidad_personas_alojamiento");
				cantidadHabitaciones = resulSet.getInt("cantidad_habitaciones_alojamiento");
				cantidadBanos = resulSet.getInt("cantidad_banos_alojamiento");
				calefaccion = resulSet.getBoolean("calefaccion_alojamiento");
				aireAcondicionado = resulSet.getBoolean("aire_acondicionado_alojamiento");
				mascotas = resulSet.getBoolean("mascotas_alojamiento");
				ciudad = resulSet.getString("ciudad_alojamiento");
				direccion = resulSet.getString("direccion_alojamiento");
				barrio = resulSet.getString("barrio_alojamiento");
				descripcion = resulSet.getString("descripcion_alojamiento");
				precio = resulSet.getInt("precio_alojamiento");
				alojamiento = new AlojamientoDTO(id_alojamiento, nombre, tipo, cantidadPersonas, cantidadHabitaciones, cantidadBanos,
						calefaccion, aireAcondicionado, mascotas, ciudad, direccion, barrio, descripcion, precio);
			}
			resulSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alojamiento;

	}

	@Override
	public ArrayList<AlojamientoDTO> buscarAlojamientos(String fechaInicio, String fechaFin) {
		ArrayList<AlojamientoDTO> alojamientos = null;
		int id;
		String nombre;
		boolean tipo;
		Integer cantidadPersonas;
		Integer cantidadHabitaciones;
		Integer cantidadBanos;
		boolean calefaccion;
		boolean aireAcondicionado;
		boolean mascotas;
		String ciudad;
		String direccion;
		String barrio;
		String descripcion;
		Integer precio;

		try {
			alojamientos = new ArrayList<>();
			query = "";
			conexion = DataSource.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT DISTINCT id_alojamiento, nombre_alojamiento, tipo_alojamiento, cantidad_personas_alojamiento, "
					+ "cantidad_habitaciones_alojamiento, cantidad_banos_alojamiento, calefaccion_alojamiento, aire_acondicionado_alojamiento,"
					+ "mascotas_alojamiento, direccion_alojamiento, ciudad_alojamiento, barrio_alojamiento, descripcion_alojamiento, precio_alojamiento "
					+ "FROM alojamientos INNER JOIN reservaciones ON "
					+ "(alojamientos.id_alojamiento = reservaciones.id_alojamiento_reservado_fk)  WHERE reservacion_fecha_inicial <> '"+fechaInicio+"' "
					+ "AND reservacion_fecha_final <> '"+fechaFin+"';";
			
			resulSet = sentencia.executeQuery(query);

			while (resulSet.next()) {
				id = resulSet.getInt("id_alojamiento");
				nombre = resulSet.getString("nombre_alojamiento");
				tipo = resulSet.getBoolean("tipo_alojamiento");
				cantidadPersonas = resulSet.getInt("cantidad_personas_alojamiento");
				cantidadHabitaciones = resulSet.getInt("cantidad_habitaciones_alojamiento");
				cantidadBanos = resulSet.getInt("cantidad_banos_alojamiento");
				calefaccion = resulSet.getBoolean("calefaccion_alojamiento");
				aireAcondicionado = resulSet.getBoolean("aire_acondicionado_alojamiento");
				mascotas = resulSet.getBoolean("mascotas_alojamiento");
				ciudad = resulSet.getString("ciudad_alojamiento");
				direccion = resulSet.getString("direccion_alojamiento");
				barrio = resulSet.getString("barrio_alojamiento");
				descripcion = resulSet.getString("descripcion_alojamiento");
				precio = resulSet.getInt("precio_alojamiento");
				alojamientos.add(new AlojamientoDTO(id, nombre, tipo, cantidadPersonas, cantidadHabitaciones, cantidadBanos,
						calefaccion, aireAcondicionado, mascotas, ciudad, barrio, direccion, descripcion, precio));
			}

			resulSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alojamientos;

	}

}
