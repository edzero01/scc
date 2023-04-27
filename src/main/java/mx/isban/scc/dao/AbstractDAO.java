package mx.isban.scc.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.IAbstractEntity;

/**
 * Métodos genéricos para el acceso a datos Implementa la interfaz Iabstractdao
 * Se parametriza con un objeto que implemente la interfaz IAbstractEntity
 * 
 * @param <T> Tipo de objeto que parametriza la clase y sobre el cual se harán
 *        las consultas y/o actualizaciones a la base de datos
 */
@Repository
public abstract class AbstractDAO<T extends IAbstractEntity> implements IAbstractDAO<T> {

	/**
	 * Entity manager para acceder a la base
	 */
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Constructor de la clase abstract dao
	 * 
	 */
	public AbstractDAO() {
	}

	/**
	 * Obtener la sesión con hibernate haciendo uso del entitymanager
	 * 
	 * @return la sesión con hibernate
	 */
	protected Session getSession() {

		return entityManager.unwrap(Session.class);
	}

	/**
	 * Para obtener el tipo de objeto que está implementando el dao y poder usar criterias
	 * 
	 * @return el tipo de la clase que parametriza el dao
	 */
	protected abstract Class<T> getType();

	/**
	 * Ëste método elimina un elemento de la base de datos de la tabla que representa el objeto parametrizado
	 * 
	 * @param element the element que se va a eliminar
	 */
	@Override
	public void delete(T element) {
		if (element == null) {
			throw new IllegalArgumentException("Imposible eliminar un elemento nulo");
		}
		getSession().delete(element);
	}



	/**
	 * Busca el elemento por llave del tipo parametrizado por T
	 * 
	 * @param pId 
	 * El id del elemento a buscar del tipo T
	 * @return El elemento cargado de tipo T
	 */
	@Override
	public T findById(long pId) {
		return findById(pId, false);
	}

	/**
	 * Carga un elemento por id para actualizarlo por id en caso que la variable lock sea true
	 * 
	 * @param pId  
	 * El id del elemento a buscar
	 * @param lock 
	 * true para bloquear el registro, falso de otra forma
	 * @return el objeto para actualzar
	 */
	@Override
	public T findById(long pId, boolean lock) {

		Class<T> type = getType();
		LockMode lockMode = null;
		if (lock) {
			lockMode = LockMode.PESSIMISTIC_WRITE;
		}

		T result = null;

		if (lockMode != null) {
			T object = getSession().get(type, pId, new LockOptions(lockMode));
			if (object != null) {
				getSession().refresh(object);
			}

			result = object;
		} else {
			result = getSession().get(type, pId);
		}

		if (result == null) {
			// if lock allow to return null
			if (lock) {
				return null;
			}

			throw new ObjectNotFoundException("No se encontró el objeto del tipo " + type);
		}
		return result;

	}

	/**
	 * Guarda o actualiza el elemento parametrizado por la clase de tipo T en la
	 * base de datos, validandolo con el id del objeto
	 * 
	 * @param pElement 
	 * El elemento a guardar o actualizar
	 */
	
	@Override
	public void saveOrUpdate(T pElement) {
		if (pElement == null) {
			throw new IllegalArgumentException("No es posible guardar un elemento nulo");
		}
		getSession().saveOrUpdate(pElement);
		getSession().flush();
	}

	/**
	 * ëste método obtiene la fecha del sistema configurada en la base de datos 
	 * 
	 * @return La fecha actual en la base de datos
	 * 
	 */
	@Override
	public Date getDateDB() {
		String queryString = "SELECT sysdate from dual";
		Date date = new Date();
		@SuppressWarnings("unchecked")
		NativeQuery<Object> query = getSession().getSessionFactory().getCurrentSession().createNativeQuery(queryString);
		List<Object> resultQuery = query.list();

		if (!resultQuery.isEmpty()) {
			for (Object o : resultQuery) {
				date = (Timestamp) o;
			}
		}
		return date;
	}


}
