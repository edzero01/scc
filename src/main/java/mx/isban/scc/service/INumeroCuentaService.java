package mx.isban.scc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import mx.isban.scc.model.lza0.NumCuentaResponse;

/**
 * Interfaz para la obtención de los números de cuenta
 * @author Edgar Daniel Garcia Serrano
 *
 * NTT DATA
 * Noviembre 2022
 * 
 */
public interface INumeroCuentaService {
	
	/**
	 * Metodo abstracto para obtener los numeros
	 * de cuenta asociados a un cliente
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * 
	 */
	public NumCuentaResponse obtenerNumerosCuenta(String idCuenta, String ownerInd, String activeInd, String subseqRec, String cursorValue) throws JsonMappingException, JsonProcessingException;

}
