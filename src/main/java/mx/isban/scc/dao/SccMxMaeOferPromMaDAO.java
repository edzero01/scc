package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeOferPromMa;
import mx.isban.scc.utilerias.ValidaNull;

/**
 * Implementación del DAO para Ofertas Promocionales de Mercado Abierto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
@Repository
public class SccMxMaeOferPromMaDAO extends AbstractDAO<SccMxMaeOferPromMa> implements ISccMxMaeOferPromMaDAO {

	/**
	 * Método getType() por patrón de DTO
	 * @return SccMxMaeOferPromMa.class
	 */
	@Override
	protected Class<SccMxMaeOferPromMa> getType() {
		return SccMxMaeOferPromMa.class;
	}

	/**
	 * Método para buscar ofertas promocionales por sub producto
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del sub producto
	 * @return List(SccMxMaeOferPromMa) Lista con las ofertas promocionales de mercado abierto. 
	 */
	@Override
	public List<SccMxMaeOferPromMa> buscaOferPromBySubProd(long id) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeOferPromMa where sccMxMaeSubProd.idSubProdPk = ");
		sb.append(id);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeOferPromMa> query = super.getSession().createQuery(sql);
		
		return query.list();
		
		
	}
	/**
	 * Implementación busca Ofertas promocionales de mercado abierto por id del cliente
	 * @param id BUC del cliente
	 * @return List(SccMxMaeOferPromMa)
	 */
	@Override
	public List<SccMxMaeOferPromMa> buscaOferPromByBucClte(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeOferPromMa where idBucClte = ");
		sb.append(id);
		sb.append(" and TRUNC(fchIniProm) <= TRUNC(current_date) and TRUNC(fchFinProm) >= TRUNC(current_date) ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeOferPromMa> query = super.getSession().createQuery(sql);
		return query.list();
	}
	/**
	 * Interfaz busca Ofertas promocionales de mercado abierto por id del cliente y idSubProducto
	 * @param id BUC del cliente
	 * @param idSubProducto id del SubProducto
	 * @return List(SccMxMaeOferPromMa)
	 */
	@Override
	public List<SccMxMaeOferPromMa> buscaOferPromByBucClte(long id, String idSubProducto, Long tipoPerfilSeleccionado) {
		StringBuilder sb = new StringBuilder();
		ValidaNull vn = new ValidaNull();
		sb.append(" from SccMxMaeOferPromMa where ");
		if (id == 0) {
			sb.append(" idBucClte is null");
		} else {
			sb.append("( idBucClte = ");
			sb.append(id);
			sb.append(" or idBucClte is null )");
		}
		sb.append(" and idSubProd = :idSubProducto");
		sb.append(" and fchIniProm <= current_date and fchFinProm >= current_date ");
		sb.append(vn.armaQueryOfertasPromPerfil(tipoPerfilSeleccionado));
		sb.append(" order by idBucClte");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeOferPromMa> query = super.getSession().createQuery(sql);
		query.setParameter("idSubProducto", new Long(idSubProducto));
		return query.list();
	}

}
 