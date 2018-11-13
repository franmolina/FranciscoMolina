package es.arelance.proyecto.modelo.dao;

import java.util.List;

import es.arelance.proyecto.modelo.Categoria;

/**
 * Dao para la entidad {@link Categoria}
 * 
 * @author Francisco Molina Sanchez
 *
 */
public interface CategoriaDao {
	/**
	 * Obtiene todas las instancias de {@link Categoria} disponibles
	 * 
	 * @return lista de categorias
	 */
	List<Categoria> getAll() throws DaoException;
}
