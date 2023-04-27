package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeOferPromCam;
import mx.isban.scc.utilerias.ValidaNull;

/**
 * Clase publica para implementar interfaz
 * ofertas promocionales de 
 * campania
 * Global Hitss
 * Mayo 2019
 * Sprint 2
 * @author Hitss
 *
 */
@Repository
public class SccMxMaeOferPromCamDAO extends AbstractDAO<SccMxMaeOferPromCam> implements ISccMxMaeOferPromCamDAO {

	/**
	 * metodo dao abstracto para devolver la propia clase
	 */
	@Override
	protected Class<SccMxMaeOferPromCam> getType() {
		return SccMxMaeOferPromCam.class;
	}
	/**
	 * Implementación DAO busca ofertas promcionales de campaña por id del cleinte
	 * @param id
	 * buc de cliente
	 * @return List(SccMxMaeOferPromCam)
	 */  
	@Override
	public List<SccMxMaeOferPromCam> buscaOferPromCamByBucClte(long id, String idSubProducto, Long tipoPerfilSeleccionado) {
		ValidaNull vn = new ValidaNull();
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeOferPromCam where ");
		sb.append("( idBucClte = ");
		sb.append(id);
		sb.append(" or idBucClte is null )");
		sb.append(" and idSubProd = :idSubProducto");
		sb.append(" and TRUNC(fchIniProm) <= TRUNC(current_date) and TRUNC(fchFinProm) >= TRUNC(current_date) ");
		sb.append(vn.armaQueryOfertasPromPerfil(tipoPerfilSeleccionado));
		sb.append(" order by idOferPreCamPk desc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeOferPromCam> query = super.getSession().createQuery(sql);
		query.setParameter("idSubProducto", new Long(idSubProducto));
		return query.list();
	}

}
