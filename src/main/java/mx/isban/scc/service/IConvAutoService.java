package mx.isban.scc.service;

import mx.isban.scc.model.dto.SccMxMaeConvautoDTO;

/**
 * Interfaz para los servicios de consulta de cat_logos
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 * 
 *
 */
public interface IConvAutoService {

	/**
	 * Método para buscar el valor de la tasa de conversion auto
	 * considerando el valor de la LAPA
	 * @param lapa
	 * Valor de LAPA  a buscar
	 * @return double
	 * valor de tasa para conv auto
	 */
	Double buscaConvAutoPorLapa(Long lapa);
	
	/**
	 * Método para buscar el valor de la tasa de conversion auto
	 * considerando el Id de Segmento
	 * @param id
	 * Valor del ID del Segmento indicado en FrontEnd
	 * @return double
	 * valor de tasa para conv auto
	 */
	SccMxMaeConvautoDTO buscaConvAutoPorSegmento(Long id);


}
