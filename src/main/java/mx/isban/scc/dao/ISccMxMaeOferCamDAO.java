package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeOferCam;
/**
 * Interfaz publica con finalidad
 * de realizar consultas de offertas
 * de campania
 * @author Hitss
 *
 */
public interface ISccMxMaeOferCamDAO extends IAbstractDAO<SccMxMaeOferCam> {
	/**
	 * Interfaz DAO busca ofertas de campaña por numero de cliente
	 * @param id
	 * buc de cliente
	 * @param perfil
	 * indica el perfil con el que se loggea el usuario para filtrar las ofertas
	 * por las banderas indicadas (ccs_in, fve, etc)
	 * @return List(SccMxMaeOferCam)
	 */
	List<SccMxMaeOferCam>  buscaOferCamByBucClte(long id, long perfil);
	
	

}
