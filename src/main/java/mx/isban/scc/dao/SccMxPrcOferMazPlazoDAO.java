package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
/**
 * Clase para implementar interfaz
 * publica para realizar las 
 * busquedas de promociones
 * ofertas maximas y plazos
 * 
 * buscaOfertasMaximasPlazo
 * buscaTasas
 * 
 * Global Hitss
 * Mayo 2019
 * Srpint 2
 * 
 * @author Hitss
 *
 */
@Repository
public class SccMxPrcOferMazPlazoDAO extends AbstractDAO<SccMxPrcOferMaxPlzo> implements ISccMxPrcOferMazPlazoDAO {


	/**
	 * metodo para dao abstracto
	 */
	@Override
	protected Class<SccMxPrcOferMaxPlzo> getType() {
		return SccMxPrcOferMaxPlzo.class;
	}

	/**
	 * Metodo de busqueda de ofertas maximas por plazo
	 * @param id
	 * id de plazo
	 * @return SccMxPrcOferMaxPlzo
	 * SccMxPrcOferMaxPlzo
	 * @author Hitss
	 */
	@Override
	public List<SccMxPrcOferMaxPlzo> buscaOfertasMaximasPlazo(Long id) {
		StringBuilder sb = new StringBuilder();
		String param2 = "BASE";
		sb.append(" from SccMxPrcOferMaxPlzo where sccMxMaeOferCam.idOferCamPk = "); 
		sb.append(id);
		sb.append(" and sccMxPrcOferMaxTasa.codTasa = ");
		sb.append("'");
		sb.append(param2);
		sb.append("'");
		sb .append(" order by canPlzo asc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxPrcOferMaxPlzo> query = super.getSession().createQuery(sql);
		return query.list();
	}

	/**
	 * Metodo de busqueda de tasas
	 * @param id
	 * id de plazo
	 * @return SccMxPrcOferMaxTasa
	 * SccMxPrcOferMaxTasa
	 * @author Hitss
	 */
	@Override
	public List<SccMxPrcOferMaxTasa> buscaTasas(Long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxPrcOferMaxTasa where sccMxMaeOferCam.idOferCamPk = ");
		sb.append(id);
		sb.append(" order by porTasa asc");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxPrcOferMaxTasa> query = super.getSession().createQuery(sql);
		return query.list();
	}
	
	
	/**
	 * Metodo de busqueda de ofertas maximas por plazo
	 * @param idCampania Id de campaña
	 * @param idTasa Id de tasa
	 * @return List(SccMxPrcOferMaxPlzo)
	 * @author Hitss
	 */
	@Override
	public List<SccMxPrcOferMaxPlzo> buscaOfertasMaximasPlazoTasa(Long idCampania, Long idTasa) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxPrcOferMaxPlzo where sccMxMaeOferCam.idOferCamPk = "); 
		sb.append(idCampania);
		sb.append(" and sccMxPrcOferMaxTasa.idOferMaxTasaPk = ");
		sb.append(idTasa);
		sb.append(" order by canPlzo asc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxPrcOferMaxPlzo> query = super.getSession().createQuery(sql);
		return query.list();
	}
	
}
