package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para gestionar {@link Usuario}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface UsuarioSvc {
	/**
	 * Busca a un {@link Usuario} por nombre y contrasena
	 * 
	 * @param nombreUsuario
	 *            Nombre del {@link Usuario}
	 * @param contrasena
	 *            Contraseña del {@link Usuario}
	 * @return {@link Usuario} si existe; null en otro caso
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Usuario acceder(String nombreUsuario, String contrasena)
			throws ServiceException;

	/**
	 * Busca a un {@link Usuario} por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            Identificador del {@link Usuario}
	 * @param fetch
	 *            Si {@code true} obtiene relaciones de {@link Juego}; Si
	 *            {@code false} no realiza el fetch
	 * @return Usuario si encontrado; null en otro caso
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Usuario obtenPorId(Integer id, boolean fetch) throws ServiceException;

	/**
	 * Guarda un {@link Usuario} nuevo
	 * 
	 * @param Usuario
	 *            {@link Usuario} a guardar
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void guardar(Usuario usuario) throws ServiceException;
}
