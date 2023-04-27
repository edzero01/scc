package mx.isban.scc.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.isban.scc.model.pb53.PrestamoNominaRequest;
import mx.isban.scc.model.pb53.PrestamoNominaResponse;

/**
 * Interfaz para el consumo del servicio pb53
 * @author Edgar Daniel Garcia Serrano
 *
 * NTT DATA
 * Noviembre 2022
 * 
 */
public interface IPrestamoNominaService {
	
	public PrestamoNominaResponse createPrestamoNomina(long idProducto, long idSubproducto, PrestamoNominaRequest request) throws JsonProcessingException;

}
