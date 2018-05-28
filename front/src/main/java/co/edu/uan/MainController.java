package co.edu.uan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import co.edu.uan.dto.AlojamientoDTO;
import co.edu.uan.dto.ReservaDTO;
import co.edu.uan.dto.UsuarioDTO;
import co.edu.uan.reserva.impl.Reservacion;
import co.edu.uan.usuario.impl.UsuarioImpl;
import co.uan.edu.alojamiento.impl.Alojamiento;

@Controller
public class MainController {
	
	private String fechaInicio;
	private String fechaFin;
	private String idAlojamiento;
	private String idUsuario;	
	private Boolean session = false;
	private Boolean sessionMessage = false;
	private Boolean searchMessage = false;
		
	@RequestMapping("/registro")
	public ModelAndView register() {
		
		return new ModelAndView("register");
		
	}
	
	@RequestMapping("/iniciar-sesion")
	public ModelAndView iniciar() {

		return new ModelAndView("iniciarsesion", "mensaje", this.sessionMessage);
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest requ) {
		
		UsuarioImpl impl = new UsuarioImpl();
		this.idUsuario = impl.login(new UsuarioDTO(requ.getParameter("username"), requ.getParameter("password")));
		
		if (!this.idUsuario.isEmpty()) {
			this.session = true;
			this.sessionMessage = false;
			return new ModelAndView("redirect:/alojamientos");
		}
		
		this.sessionMessage = true;
		
		return new ModelAndView("redirect:/iniciar-sesion");
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest requ) {
		
		this.session = false;
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping("/registrar-usuario")
	public ModelAndView registrarUsuario(HttpServletRequest requ) {
	
		UsuarioImpl impl = new UsuarioImpl();
		impl.registrar(new UsuarioDTO(requ.getParameter("fullname"), requ.getParameter("username"), requ.getParameter("password")));
		
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping("/alojamientos")
	public ModelAndView alojamientos() {
		
		if (this.session) {
			this.searchMessage = false;
			Alojamiento listAlojamientos = new Alojamiento();
			ArrayList<AlojamientoDTO> alojamientos = listAlojamientos.getAllAlojamientos();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("value", false);
			modelAndView.addObject("list", alojamientos);
			modelAndView.setViewName("alojamientos");
			return modelAndView;
		}
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar() {
		
		if (this.session) {
			return new ModelAndView("buscar", "mensaje", this.searchMessage);
		}
		
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/buscar-alojamientos")
	public ModelAndView buscarAlojamientos(HttpServletRequest requ) {
		
		if (this.session) {
			try {
				this.searchMessage = false;
				this.fechaInicio = requ.getParameter("fechaInicial");
				this.fechaFin = requ.getParameter("fechaFinal");
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dateInicial = formatter.parse(this.fechaInicio);
				Date dateFinal = formatter.parse(this.fechaFin);
				
				if (dateFinal.before(dateInicial)) {
					this.searchMessage = true;
					return new ModelAndView("redirect:/alojamientos/buscar");
				}
				
				Alojamiento listAlojamientos = new Alojamiento();
				ArrayList<AlojamientoDTO> alojamientos = listAlojamientos.listAlojamientosByParameters(fechaInicio, fechaFin);
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("list", alojamientos);
				modelAndView.setViewName("alojamientos");
				modelAndView.addObject("value", true);
				return modelAndView;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getAlojamiento(@PathVariable("id") String id) {
		
		if (this.session) {
			Alojamiento alojamiento = new Alojamiento();
			co.edu.uan.dto.Alojamiento alojamientoDTO = alojamiento.getAlojamiento(id);
			return new ModelAndView("alojamiento", "alojamiento", alojamientoDTO);
		}
		
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/{id}/reservacion")
	public ModelAndView reservarAlojamiento(@PathVariable("id") String id) {
		
		if (this.session) {
			
			if (this.fechaInicio != null && this.fechaFin != null) {
				Alojamiento alojamiento = new Alojamiento();
				co.edu.uan.dto.Alojamiento alojamientoDTO = alojamiento.getAlojamiento(id);
				this.idAlojamiento = id;
				int valor = alojamientoDTO.getPrecio();
				return new ModelAndView("reservation", "valor", valor);
			}
			
			return new ModelAndView("redirect:/alojamientos/buscar");
					
		}
		
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/guardar")
	public ModelAndView guardarReservacion(HttpServletRequest requ) {
		
		if (this.session) {			
			Reservacion reservacion = new Reservacion();
			reservacion.saveReservacion(new ReservaDTO(Integer.parseInt(idAlojamiento), Integer.parseInt(idUsuario), requ.getParameter("nombre"), 
					requ.getParameter("identificacion"), requ.getParameter("direccion"), requ.getParameter("telefono"), 
					requ.getParameter("celular"), requ.getParameter("numTarjeta"), requ.getParameter("fechaExp"), 
					requ.getParameter("numTarjeta"), Integer.parseInt(requ.getParameter("valor")), this.fechaInicio, this.fechaFin));
						
			return new ModelAndView("redirect:/alojamientos");
		}
		
		return new ModelAndView("403");
		
	}
	
	@RequestMapping("/mis-reservaciones")
	public ModelAndView misReservaciones() {
		
		if (this.session) {	
			UsuarioImpl impl = new UsuarioImpl();
			ArrayList<ReservaDTO> reservas = impl.reservaciones(idUsuario);
			return new ModelAndView("misreservaciones", "reservas", reservas);
		}
		
		return new ModelAndView("403");	
		
	}

}
