package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.dto.SccMxVariablesCustomDTO;

/**
 * Interfaz para consulta de tablas
 * de variables para su gestion
 * 
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Junio 2019
 *
 */
public interface IGestionVariablesService {
	/**
	 * Metodo para obtener datos de variables
	 * @param idSubProd
	 * producto relacionado
	 * @return List(SccMxVariablesCustomDTO)
	 * lista de objetos de variables
	 */
	List <SccMxVariablesCustomDTO> obtenInfoVariables(long  idSubProd);


}
