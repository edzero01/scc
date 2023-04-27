package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxPrcOferMaxTasa;

/**
 * Interfaz para obtener las tasas para la tabla
 * de ofertas maximas
 * @author baruchlw
 *
 */
public interface ISccMxPrcOfMaxTasaDAO extends IAbstractDAO<SccMxPrcOferMaxTasa> {

	/**
	 * Método buscatasas
	 * @param idOferta
	 * Recibe de parametro el id de la oferta
	 * @return Lista de tasas
	 * Esta lista se despliega en el combobox de front end
	 */
	List<SccMxPrcOferMaxTasa> buscaTasas(long idOferta);

}
