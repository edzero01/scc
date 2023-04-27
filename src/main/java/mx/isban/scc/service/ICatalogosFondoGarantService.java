package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.dto.SccMxMaeFondoGarantiaDTO;

/**
 * Interfaz para los servicios de consulta de catalogos de fondo de garantia
 * 
 * @author GlobalHitss 
 * Junio 2019 
 * Sprint 2
 * 
 *
 */
public interface ICatalogosFondoGarantService {
	/**
	 * Obtiene el catalogo de Fondos de Garantia 
	 * Junio 2019 
	 * Sprint 3.2
	 * 
	 * @author GlobalHitss
	 * 
	 * @return List(SccMxMaeFondoGarantiaDTO) lista de Fondos de Garantia
	 */
	List<SccMxMaeFondoGarantiaDTO> buscaFondosGarantia();
	

}
