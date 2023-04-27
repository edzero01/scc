package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;

/**
 * Interfaz para los servicios de consulta de cat_logos
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 * 
 *
 */
public interface ICondFinService {
	/**
	 * Busca id sub producto Mayo 2019 Sprint 1
	 * 
	 * @author GlobalHitss
	 * @param id identificador _nico del sub producto
	 * @return lista de condiciones financieras
	 */
	List<SccMxMaeCondFinanDTO> buscaCondicionPorIdSubProd(Long id);
	
	/**
	 * Para actualizar los factores de confinan cada vez que el usuario
	 * realice un cambio de combobox en tasa, plazo o periodicidad
	 * @param id
	 * id
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * periodo
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	
	List<SccMxMaeCondFinanDTO> buscaCondTPP(Long id, Double idTasa, Long idPlazo, Long idPeriod);
	
	
	/**
	 * Para actualizar los factores de confinan cada vez que el usuario
	 * realice un cambio de combobox en tasa, plazo o periodicidad
	 * @param idSubProdPk
	 * idSubProdPk 
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * periodo
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	List<SccMxMaeCondFinanDTO> buscaCondTPPOfMax(Long idSubProdPk, Double idTasa, Long idPlazo, Long idPeriod);

}
