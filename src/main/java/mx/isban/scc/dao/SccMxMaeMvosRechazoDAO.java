package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeMvosRechazo;


/**
 * Implementacion de las consultas para leer la lista de motivos de rechazo
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
@Repository
public class SccMxMaeMvosRechazoDAO extends AbstractDAO<SccMxMaeMvosRechazo> implements ISccMxMaeMvosRechazoDAO {

	/**
	 * Método para buscar todos los motivos de rechazo
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return Query<SccMxMaeMvosRechazo> query
	 */
	@Override
	protected Class<SccMxMaeMvosRechazo> getType() {
		return SccMxMaeMvosRechazo.class;
	}
	
	/**
	 * Método para buscar todos los motivos de rechazo.
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return lista todos los motivos de rechazo.
	 */
	@Override
	public List<SccMxMaeMvosRechazo> buscaTodos() {
		String sql = " from SccMxMaeMvosRechazo ";
		@SuppressWarnings("unchecked")
		Query<SccMxMaeMvosRechazo> query = super.getSession().createQuery(sql);
		
		return query.list();
		}

}
