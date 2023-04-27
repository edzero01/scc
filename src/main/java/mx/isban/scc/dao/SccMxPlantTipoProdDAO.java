package mx.isban.scc.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaePlantTipoProd;

/**
 * Implementación de la interfaz para acceso de datos a SccMxMaePlantTipoProd
 * 
 * @author Gabriel Dolores García
 * 
 *         Global Hitss Julio 2019
 *
 */
@Repository
public class SccMxPlantTipoProdDAO extends AbstractDAO<SccMxMaePlantTipoProd> implements ISccMxPlantTipoProdDAO {

	/**
	 * Sobreescritura de metodo de clase abstracta
	 */
	@Override
	protected Class<SccMxMaePlantTipoProd> getType() {
		return SccMxMaePlantTipoProd.class;
	}
	
	/**
	 * Busca la plantilla por tipo de producto
	 * @param idTipoPlantillaFk el id del tipo de plantilla
	 * @param idTipoProdFk el id del tipo de producto
	 * @return SccMxMaePlantTipoProd con los datos de la plantilla
	 */
	@Override
	public SccMxMaePlantTipoProd buscaPlantilla(long idTipoPlantillaFk, long idPlantilla) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from SccMxMaePlantTipoProd x where x.tipoPlantillaFk.idTipoPlantillaPk = :idTipoPlant ");
		hql.append(" and x.idPlantTipoProdPk = :idTipoProd" );
		@SuppressWarnings("unchecked")
		Query<SccMxMaePlantTipoProd> query = getSession().createQuery(hql.toString());
		query.setParameter("idTipoPlant", idTipoPlantillaFk);
		query.setParameter("idTipoProd", idPlantilla);
		
		return query.uniqueResult();
	}

}
