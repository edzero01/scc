package mx.isban.scc.service;

import mx.isban.scc.model.dto.SccMxMaeCatalogosDTO;

/**
 * Interfaz para los servicios de consulta de cat_logos
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 * 
 *
 */
public interface ICatalogosSimService {

	/**
	 * Busca todos los tipos de producto, los segmentos y los motivos de rechazo
	 * Mayo 2019 Sprint 1
	 * 
	 * @param modalidad recibe la modalidad a usar para el filtrado de tipos de
	 *                  productos
	 * @author GlobalHitss
	 * @return SccMxMaeCatalogosDTO objeto con las listas de productos, segmentos y
	 *         motivos de rechazo
	 */
	SccMxMaeCatalogosDTO findAllCatalogos(Integer... modalidad);

}
