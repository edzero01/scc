package mx.isban.scc.dao;

import java.util.Date;

import mx.isban.scc.model.IAbstractEntity;

/**
 * Métodos genéricos para el acceso a datos del sistema
 * 
 * @param <T> Tipo de objeto que parametriza la clase y sobre el cual se harán las consultas
 */
public interface IAbstractDAO<T extends IAbstractEntity> {

	/**
	 * The method delete an element
	 * 
	 * @param element the element to delete
	 */
	void delete(T element);

	/**
	 * Load an element using a given id
	 * 
	 * @param pId the id of the element to load
	 * @return the loaded T
	 */
	T findById(long pId);

	/**
	 * Load an element for update
	 * 
	 * @param pId  the id of the element
	 * @param lock true to lock the record,false otherwise
	 * @return the object for update
	 */
	T findById(long pId, boolean lock);

	/**
	 * Guarda o actualiza el elemento
	 * 
	 * @param pElement el elemento a guardar o actualizar
	 */
	void saveOrUpdate(T pElement);

	/**
	 * The methods get current date in the database server
	 * 
	 * @return the current date on the database server
	 * 
	 */
	Date getDateDB();

}
