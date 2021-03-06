package es.arelance.proyecto.controlador.juego.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.proyecto.interceptor.LoginInterceptor;
import es.arelance.proyecto.modelo.JuegoUsuario;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.JuegoUsuarioSvc;

/**
 * Controlador para mostrar las instancias de {@link JuegoUsuario} de un usuario
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Controller
@SessionAttributes({ LoginInterceptor.ATT_USER })
public class ListarJuegoUsuario {

	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "biblioteca/list";
	private static final String ERROR = "error";

	@Autowired
	private JuegoUsuarioSvc svc;

	/**
	 * Muestra las instancias de {@link JuegoUsuario} de un usuario
	 * 
	 * @param model
	 *            Objeto de Spring MVC para el almacenamiento de atributos
	 * @return Página con la lista de {@link JuegoUsuario} del {@link Usuario}
	 */
	@RequestMapping(value = "/juego/usuario/list", method = RequestMethod.GET)
	public String execute(@ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario, Model model) {
		try {
			model.addAttribute(ATT_LISTA, svc.listarPorUsuario(usuario));
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
