package co.edu.uan.usuario.impl;

import java.util.ArrayList;

import co.edu.uan.dao.impl.UsuarioDAOImpl;
import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.dto.UsuarioDTO;
import co.edu.uan.encrypt.EncryptAES;

public class UsuarioImpl implements co.edu.uan.usuario.IUsuario {

	public void registrar(UsuarioDTO usuario) {
		
		try {
			UsuarioDAOImpl daoImpl = new UsuarioDAOImpl();
			EncryptAES aes = new EncryptAES();
			usuario.setPassword(aes.encriptar(usuario.getPassword()));
			daoImpl.registrar(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String login(UsuarioDTO usuario) {
		UsuarioDAOImpl daoImpl = new UsuarioDAOImpl();
		try {			
			EncryptAES aes = new EncryptAES();
			usuario.setPassword(aes.encriptar(usuario.getPassword()));			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoImpl.login(usuario);
	}

	@Override
	public ArrayList<ReservaDTO> reservaciones(String idUsuario) {
		UsuarioDAOImpl daoImpl = new UsuarioDAOImpl();
		return daoImpl.getReservasUsuario(idUsuario);
	}

}
