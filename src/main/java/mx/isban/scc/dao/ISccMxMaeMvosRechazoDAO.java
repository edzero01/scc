package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeMvosRechazo;

/**
 * Interfaz para el Dao que trae los motivos de rechazo
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
public interface ISccMxMaeMvosRechazoDAO extends IAbstractDAO<SccMxMaeMvosRechazo> {
	
	/**
	 * Método abstracto para buscar todos los motivos de rechazo
	 * Mayo 2019
	 * Sprint 1
	 * @author GlobalHitss
	 * @return List(SccMxMaeMvosRechazo) lista todos los motivos de rechazo.
	 */
	List<SccMxMaeMvosRechazo> buscaTodos();

}
