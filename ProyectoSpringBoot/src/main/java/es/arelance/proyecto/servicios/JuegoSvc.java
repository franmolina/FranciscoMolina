package es.arelance.proyecto.servicios;

import es.arelance.proyecto.modelo.Juego;

/**
 * Interfaz de la capa de servicio para gestionar {@link Juego}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface JuegoSvc {
	/**
	 * Agrega un juego nuevo al sistema
	 * 
	 * @param juego
	 *            {@link Juego} a agregar
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void guardar(Juego juego) throws ServiceException;

	/**
	 * Devuelve todos los juegos existentes en el sistema
	 * 
	 * @return lista de juegos
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Iterable<Juego> listar() throws ServiceException;

	/**
	 * Filtra todas las instancias de {@link Juego} existentes por titulo,
	 * {@link Categoria} y/o {@link Plataforma}
	 * 
	 * @param juego
	 *            Titulo, {@link Categoria} y/o {@link Plataforma} del
	 *            {@link Juego}
	 * @return Lista con los juegos que cumplen el filtro
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Iterable<Juego> filtrar(Juego juego) throws ServiceException;

	/**
	 * Elimina un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            Identificador del {@link Juego}
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void eliminar(Juego juego) throws ServiceException;

	/**
	 * Edita un {@link Juego} del sistema
	 * 
	 * @param juego
	 *            {@link Juego} ya modificado
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	void modificar(Juego juego) throws ServiceException;

	/**
	 * Busca un {@link Juego} dado su identificador y lo devuelve
	 * 
	 * @param idJuego
	 *            Identificador del {@link Juego} a buscar
	 * @param fetch
	 *            Si {@code true} obtiene relaciones de {@link Juego}; Si
	 *            {@code false} no realiza el fetch
	 * @return {@link Juego} si encontrado; null en otro caso
	 * @throws ServiceException
	 *             Error relativo a la capa DAO
	 */
	Juego buscar(Integer idJuego, boolean fetch) throws ServiceException;

}
