package co.edu.uan.reserva.impl;

import co.edu.uan.dao.impl.ReservaDAOImpl;
import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.reserva.IReservacion;

public class Reservacion implements IReservacion {

	@Override
	public void saveReservacion(ReservaDTO reserva) {	
		
		ReservaDAOImpl daoImpl = new ReservaDAOImpl();
		daoImpl.saveReservacion(reserva);
		
	}

}
