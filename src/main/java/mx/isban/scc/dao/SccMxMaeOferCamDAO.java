package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeOferCam;
import mx.isban.scc.utilerias.ValidaNull;

/**
 * clase de implementacion de interfaz
 * para encontrar ofertas de campania
 * Global Hitss
 * Mayo 2019
 * Sprint 2
 * @author Hitss
 *
 */
@Repository
public class SccMxMaeOferCamDAO extends AbstractDAO<SccMxMaeOferCam> implements ISccMxMaeOferCamDAO {
	
	/**
	 * Metodo con finalidad de obtener dao abstracto
	 */
	@Override
	protected Class<SccMxMaeOferCam> getType() {
		return SccMxMaeOferCam.class;
	}
	/**
	 * Implementación DAO busca ofertas
	 * de campaña por numero de cliente
	 * Baruch aqui le agregaremos la validacion por perfil seleccionado
	 * @param id
	 * buc de cliente
	 * @return List(SccMxMaeOferCam)
	 */
	@Override
	public List<SccMxMaeOferCam> buscaOferCamByBucClte(long id, long perfil) {
		ValidaNull vn = new ValidaNull();
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeOferCam where idBucClte = ");
		sb.append(id);
		sb.append(" and TRUNC(fchIniProm) <= TRUNC(current_date) and TRUNC(fchFinProm) >= TRUNC(current_date) ");
		sb.append(vn.armaQueryOfertasPromPerfil(perfil));
		sb.append(" order by idOferCamPk desc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeOferCam> query = super.getSession().createQuery(sql);
		return query.list();
	}


	
}


