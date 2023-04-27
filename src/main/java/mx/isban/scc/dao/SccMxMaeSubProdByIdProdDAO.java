package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeSubProd;

/**
 * Implementación de las consultas de Subproducto por Id de producto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 * 
 */
@Repository
public class SccMxMaeSubProdByIdProdDAO extends AbstractDAO<SccMxMaeSubProd>
		implements ISccMxMaeSubProdByIdProdDAO {

	/**
	 * Método para buscar subproducto por id de producto 
	 * Mayo 2019
     * Sprint 1
	 * @long id identificador único del producto
	 * @return Query(SccMxMaeSubProd) query
	 */
	@Override
	protected Class<SccMxMaeSubProd> getType() {
		return SccMxMaeSubProd.class;
	}
	
	
	/**
	 * Método para buscar el subproducto por tipo de producto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del tipo de producto
	 * @return Query(SccMxMaeSubProd) lista los objetos subproducto encontrados.
	 */
	@Override
	public List<SccMxMaeSubProd> buscaSubProdPorIdProd(long id, Long idModalidad) {

		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeSubProd Where sccMxMaeProducto.idTipoProd = ");
		sb.append(id);
		sb.append(" and sccMxMaeProducto.sccMxMaeModalidadByIdModalidadFk.idModalidadPk = ");
		sb.append(idModalidad);
		sb.append(" order by sccMxMaeProducto.codProd,codSubProd asc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSubProd> query = super.getSession().createQuery(sql);
		return query.list();
	}

	
	
	/**
	 * Método para buscar el subproducto por tipo de producto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param idTipoProd identificador único del tipo de producto
	 * @return Query(SccMxMaeSubProd) lista los objetos subproducto encontrados.
	 */
	@Override
	public List<SccMxMaeSubProd> buscaSubProdPorIdTipoProd(Long idTipoProd) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeSubProd Where sccMxMaeProducto.idTipoProd = ");
		sb.append(idTipoProd);		
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSubProd> query = super.getSession().createQuery(sql);
		return query.list();
	}
}
