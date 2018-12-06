package es.arelance.proyecto.controlador.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.proyecto.modelo.Analisis;
import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;
import es.arelance.proyecto.servicios.AnalisisSvc;
import es.arelance.proyecto.servicios.JuegoSvc;

/**
 * Controlador para buscar y modificar un {@link Juego} del sistema
 * 
 * @author Francisco Molina Sanchez
 * 
 */
@Controller
public class MostrarJuego {

	private static final String ATT_ITEM = "juego";

	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "mostrarJuego";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;
	
	@Autowired
	private AnalisisSvc anSvc;

	/**
	 * Obtiene el {@link Juego} dado su identificador y carga la ficha del juego
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego}
	 * @param model
	 * @return Destino ficha del {@link Juego}
	 */
	@RequestMapping(value = "/mostrarJuego")
	public String execute(@RequestParam int idJuego,@ModelAttribute Analisis analisis, Model model) {
		try {
			Juego juego= svc.buscar(idJuego,true);
			model.addAttribute(ATT_ITEM,juego);
			model.addAttribute("notaMedia", anSvc.notaMedia(idJuego));
			//TODO meter usuario de la sesion
			Usuario u = new Usuario();
			u.setIdUsuario(4);
			model.addAttribute("usuario", u);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
