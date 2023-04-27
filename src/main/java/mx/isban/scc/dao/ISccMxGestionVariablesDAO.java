package mx.isban.scc.dao;

import mx.isban.scc.model.SccMxMaeVariables;

/**
 * Interfaz para acceso de datos a SCC_MX_MAE_VARIABLES
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Junio 2019
 *
 */
public interface ISccMxGestionVariablesDAO {
	/**
	 * Metodo abstracto para obtener dto variables
	 * @author Christopher Espina Riveros
	 * @param idVar identificador unico de la variable
	 * Junio 2019
	 * @return SccMxMaeVariables  
	 * Lista dto variables
	 */
	SccMxMaeVariables  buscaVariables (long idVar);

}
