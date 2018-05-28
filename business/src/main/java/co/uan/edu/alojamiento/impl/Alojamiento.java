package co.uan.edu.alojamiento.impl;

import java.util.ArrayList;

import co.edu.uan.dao.impl.AlojamientoDAOImpl;
import co.edu.uan.dto.AlojamientoDTO;
import co.edu.uan.mapper.impl.MapperImpl;
import co.uan.edu.alojamiento.IAlojamiento;

public class Alojamiento implements IAlojamiento {

	public void postularAlojamiento(AlojamientoDTO alojamiento) {
		
		AlojamientoDAOImpl daoImpl = new AlojamientoDAOImpl();
		daoImpl.postularAlojamiento(alojamiento);
		
	}

	public ArrayList<AlojamientoDTO> getAllAlojamientos() {
		
		AlojamientoDAOImpl daoImpl = new AlojamientoDAOImpl();
		return daoImpl.getAllAlojamientos();
		
	}

	@Override
	public co.edu.uan.dto.Alojamiento getAlojamiento(String id) {
		
		AlojamientoDAOImpl daoImpl = new AlojamientoDAOImpl();	
		MapperImpl impl = new MapperImpl();
		co.edu.uan.dto.Alojamiento alojamiento = impl.mapperAlojamiento(daoImpl.getAlojamientoById(id));
		
		return alojamiento; 
		
	}

	@Override
	public ArrayList<AlojamientoDTO> listAlojamientosByParameters(String fechaInicio, String fechaFin) {
		AlojamientoDAOImpl daoImpl = new AlojamientoDAOImpl();	
		return daoImpl.buscarAlojamientos(fechaInicio, fechaFin);
	}

}
