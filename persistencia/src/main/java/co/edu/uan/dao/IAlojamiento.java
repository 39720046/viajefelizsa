package co.edu.uan.dao;

import java.util.ArrayList;
import co.edu.uan.dto.AlojamientoDTO;

public interface IAlojamiento {
	
	public void postularAlojamiento(AlojamientoDTO alojamiento);
	
	public ArrayList<AlojamientoDTO> getAllAlojamientos();
	
	public AlojamientoDTO getAlojamientoById(String id);
	
	public ArrayList<AlojamientoDTO> buscarAlojamientos(String fechaInicio, String fechaFin);

}
