package es.arelance.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.proyecto.servicios.JuegoSvc;

//Indica que se trata de un controlador
@Controller
public class ListarJuegos {
	
	private static final String ATT_LISTA = "listaJuegos";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "listaJuegos";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private JuegoSvc svc;

	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/listarJuegos", method=RequestMethod.GET)
    public String execute(Model model){//, HttpServletRequest request) {
    	try {
    		//Ya no necesitamos inyectar el servicio como en Servlets
			model.addAttribute(ATT_LISTA, svc.listar());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}