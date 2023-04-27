package mx.isban.scc.dao;

import mx.isban.scc.model.SccMxMaePlantTipoProd;

/**
 * Interfaz para acceso de datos a SccMxMaePlantTipoProd
 * 
 * @author Gabriel Dolores García
 * 
 *         Global Hitss Julio 2019
 *
 */
public interface ISccMxPlantTipoProdDAO extends IAbstractDAO<SccMxMaePlantTipoProd> {

	/**
	 * Busca la plantilla por tipo de producto
	 * @param idTipoPlantillaFk el id del tipo de plantilla
	 * @param idTipoProdFk el id del tipo de producto
	 * @return SccMxMaePlantTipoProd con los datos de la plantilla
	 */
	SccMxMaePlantTipoProd buscaPlantilla(long idTipoPlantillaFk, long idTipoProdFk);
	
}
