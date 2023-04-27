package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxPrcGstVariables;

/**
 * Interfaz para acceso de datos a SCC_MX_MAE_VARIABLES
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Junio 2019
 *
 */
public interface ISccMxGestionVariablesGstDAO {
	/**
	 * Metodo abstracto para obtener dto variables
	 * @author Christopher Espina Riveros
	 * @param idSubProd
	 * id de cliente
	 * @return List(SccMxPrcGstVariables)
	 * Lista dto variables
	 */
	List<SccMxPrcGstVariables>  buscaVariables (long idSubProd);

}
