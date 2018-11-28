package es.arelance.proyecto.servicios.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.proyecto.modelo.Juego;
import es.arelance.proyecto.modelo.dao.DaoException;
import es.arelance.proyecto.modelo.dao.JuegoDao;
import es.arelance.proyecto.servicios.JuegoSvc;
import es.arelance.proyecto.servicios.ServiceException;

/**
 * Implementacion de la interfaz del servicio {@link JuegoSvc}
 * 
 * @author Francisco Molina Sanchez
 *
 */
@Transactional
public class JuegoSvcImpl implements JuegoSvc {
	private JuegoDao dao;
	
	public JuegoDao getDao() {
		return dao;
	}

	public void setDao(JuegoDao dao) {
		this.dao = dao;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void anadir(Juego juego) throws ServiceException {
		try {
			dao.add(juego);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Juego> listar() throws ServiceException {
		try {
			return dao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Juego> filtrar(String titulo, String categoria, String plataforma)
			throws ServiceException {
		try {
			return dao.filter(titulo, categoria, plataforma);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void borrarporId(Integer idJuego) throws ServiceException {
		try {
			dao.deleteById(idJuego);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Juego edit(Juego juegoEditado) throws ServiceException {
		try {
			return dao.edit(juegoEditado);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
