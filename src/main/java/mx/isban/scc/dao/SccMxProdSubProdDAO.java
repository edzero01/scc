package mx.isban.scc.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeSubProd;

/**
 * Implementacion de la intefaz DAO para buscar productos y subproductos
 * 
 * Spring 3
 * 
 * Junio 2019
 * @author Hitss
 *
 */
@Repository
public class SccMxProdSubProdDAO extends AbstractDAO<SccMxMaeSubProd> implements ISccMxProdSubProdDAO {

	/**
	 * Metodo que valida la existencia de los productos
	 * 
	 * @author Hitss
	 * 
	 * @param idProd identificador del producto
	 * @param idSubProd identificador del subprocuto
	 * @return Boolean valor booleano que indica si existen o no los productos buscados 
	 */
	@Override
	public Boolean existeProdSubProd(Long idProd, Long idSubProd) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeSubProd where codSubProd = ");
		sb.append(idSubProd);
		sb.append(" and sccMxMaeProducto.codProd = ");
		sb.append(idProd);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSubProd> query = super.getSession().createQuery(sql);
		
		return !query.list().isEmpty();
	}
	
	
	/**
	 * Metodo que valida la existencia de los productos por periodo
	 * 
	 * @author Hitss
	 * 
	 * @param idProd identiifcador del producto
	 * @param idSubProd identificador del subprocuto
	 * @param idPeriodo identificador del periodo
	 * @return Boolean valor booleano que indica si existen o no los productos buscados 
	 * 
	 */
	@Override
	public Boolean existeProdSubProdPeriodo(Long idProd, Long idSubProd, Long idPeriodo) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeSubProd where codSubProd = ");
		sb.append(idSubProd);
		sb.append(" and sccMxMaeProducto.codProd = ");
		sb.append(idProd);
		sb.append(" and sccMxMaePeriod.idPeriodPk = ");
		sb.append(idPeriodo);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSubProd> query = super.getSession().createQuery(sql);
			
		return !query.list().isEmpty();
	}

	/**
	 * Metodo con finalidad de obtener dao abstracto
	 */
	@Override
	protected Class<SccMxMaeSubProd> getType() {
		return SccMxMaeSubProd.class;
	}

}
