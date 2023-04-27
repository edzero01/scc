package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxPrcOferMaxTasa;

/**
 * Implementacion de DAO para obtener las tasas
 * para la tabla de ofertas máximas de campaña
 * 
 * Global Hitss
 * Mayo 2019
 * 
 * @author baruchlw
 *
 */
@Repository
public class SccMxPrcOfMaxTasaDAO extends AbstractDAO<SccMxPrcOferMaxTasa> implements ISccMxPrcOfMaxTasaDAO {

	/**
	 * constructor vacío
	 */
	public SccMxPrcOfMaxTasaDAO() {
		super();
	}
	

	/**
	 * metodo protegido que devuelve el tipo de objeto a usar para el dao
	 * 
	 * @return SccMxPrcOferMaxTasa.class
	 */
	@Override
	protected Class<SccMxPrcOferMaxTasa> getType() {
		return SccMxPrcOferMaxTasa.class;
	}
	
 	/**
	 * Obtiene las tasas por id de la oferta
	 * retorna la lista de tasas
	 * 
	 * @param idOferta id oferta
	 * @return List(SccMxTablaOfMaxDTO) Lista de tasas
	 */
	@Override
	public List<SccMxPrcOferMaxTasa> buscaTasas(long idOferta) {
		String hql = " from SccMxPrcOferMaxTasa tasa where idOferPreCamFk = :idOferta ";
		@SuppressWarnings("unchecked")
		Query<SccMxPrcOferMaxTasa> query = super.getSession().createQuery(hql);
		return query.getResultList();
		
	}

	



}
