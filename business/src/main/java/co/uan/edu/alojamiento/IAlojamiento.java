package co.uan.edu.alojamiento;

import java.util.ArrayList;

import co.edu.uan.dto.Alojamiento;
import co.edu.uan.dto.AlojamientoDTO;

public interface IAlojamiento {
	
	public void postularAlojamiento(AlojamientoDTO alojamiento);
	
	public ArrayList<AlojamientoDTO> getAllAlojamientos();
	
	public Alojamiento getAlojamiento(String id);
	
	public ArrayList<AlojamientoDTO> listAlojamientosByParameters(String fechaInicio, String fechaFin);

}
