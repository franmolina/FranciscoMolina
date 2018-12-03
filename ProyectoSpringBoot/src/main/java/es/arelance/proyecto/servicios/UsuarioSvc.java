package es.arelance.proyecto.servicios;

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
	 *            nombre del {@link Usuario}
	 * @param contrasena
	 *            contraseña del {@link Usuario}
	 * @return {@link Usuario} si existe; null en otro caso
	 * @throws ServiceException
	 */
	Usuario acceder(String nombreUsuario, String contrasena)
			throws ServiceException;

	/**
	 * Busca a un {@link Usuario} por identificador para mostrar su perfil
	 * 
	 * @param idUsuario
	 *            identificador del {@link Usuario}
	 * @return usuario si encontrado; null en otro caso
	 * @throws ServiceException
	 */
	Usuario obtenPorId(Integer id) throws ServiceException;

	/**
	 * Guarda un {@link Usuario} nuevo
	 * @param usuario {@link Usuario} a guardar
	 * @throws ServiceException
	 */
	void guardar(Usuario usuario) throws ServiceException;
}
