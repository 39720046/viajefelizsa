package co.edu.uan.mapper.impl;

import co.edu.uan.dto.Alojamiento;
import co.edu.uan.dto.AlojamientoDTO;
import co.edu.uan.mapper.IMapper;

public class MapperImpl implements IMapper {

	@Override
	public Alojamiento mapperAlojamiento(AlojamientoDTO alojamientoDTO) {
		Alojamiento alojamiento = new Alojamiento();
		alojamiento.setId(alojamientoDTO.getId());
		alojamiento.setNombre(alojamientoDTO.getNombre());
		alojamiento.setTipo(alojamientoDTO.isTipo() ? "Casa" : "Finca");
		alojamiento.setCantidadPersonas(alojamientoDTO.getCantidadPersonas());
		alojamiento.setCantidadHabitaciones(alojamientoDTO.getCantidadHabitaciones());
		alojamiento.setCantidadBanos(alojamientoDTO.getCantidadBanos());
		alojamiento.setCalefaccion(alojamientoDTO.isCalefaccion() ? "Si" : "No");
		alojamiento.setAireAcondicionado(alojamientoDTO.isAireAcondicionado() ? "Si" : "No");
		alojamiento.setMascotas(alojamientoDTO.isMascotas() ? "Si" : "No");
		alojamiento.setCiudad(alojamientoDTO.getCiudad());
		alojamiento.setDireccion(alojamientoDTO.getDireccion());
		alojamiento.setBarrio(alojamientoDTO.getBarrio());
		alojamiento.setDescripcion(alojamientoDTO.getDescripcion());
		alojamiento.setPrecio(alojamientoDTO.getPrecio());
		return alojamiento;
	}

}
