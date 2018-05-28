package co.edu.uan.usuario;

import java.util.ArrayList;

import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.dto.UsuarioDTO;

public interface IUsuario {
	
	public void registrar(UsuarioDTO usuario);
	
	public String login(UsuarioDTO usuario);
	
	public ArrayList<ReservaDTO> reservaciones(String idUsuario);

}
