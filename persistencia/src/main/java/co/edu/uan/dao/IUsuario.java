package co.edu.uan.dao;

import java.util.ArrayList;

import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.dto.UsuarioDTO;

public interface IUsuario {
	
	public void registrar(UsuarioDTO usuario);
	
	public String login(UsuarioDTO usuario);
	
	public void asignarRol(UsuarioDTO usuario);
	
	public ArrayList<ReservaDTO> getReservasUsuario(String idUsuario);
	
}
