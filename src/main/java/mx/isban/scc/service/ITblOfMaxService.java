package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
import mx.isban.scc.model.dto.SccMxTablaOfMaxDTO;

/**
 * Interfaz para la tabla de ofertas maximas
 * @author baruchlw
 *
 */
public interface ITblOfMaxService {
	
	/**
	 * Obtiene la tasa por id de oferta
	 * @param id
	 * Id de la oferta
	 * @return Lista de tasas
	 * retorna la lista de tasas 
	 */
	List<SccMxPrcOferMaxTasa> getTasaporOferta(long id);
	/**
	 * Obtiene la plazo por tasa
	 * @param id
	 * Id de la oferta
	 * @return Lista de plazos
	 * retorna la lista de plazos 
	 */
	List<SccMxPrcOferMaxPlzo> getPlazosporTasa(long id);
	/**
	 * Obtiene la tabla ofertas
	 * @param idTasa
	 * Id de tasa
	 * @param idOfCam
	 * id oferta campania
	 * @return Lista de tasas
	 * retorna la lista de tasas 
	 */
	List<SccMxTablaOfMaxDTO> getTablaOfMax(long idTasa, long idOfCam); 
	
}
