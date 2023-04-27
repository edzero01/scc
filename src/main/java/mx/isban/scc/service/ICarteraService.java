package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.dto.SccMxMaeAppCarteraDTO;

/**
 * Interfaz para la consulta de los creditos asociados a un cliente
 * @author Hitss
 * 
 * Julio 2019
 * Sprint 3
 */
public interface ICarteraService {
	
	/**
	 * Declaración de consulta para los creditos relacionados a un cliente por producto 
	 * Sprint 3
	 * @param idCliente identiifcador unico del cliente
	 * @return List(SccMxMaeAppCarteraDTO) lista con los créditos obtenidos
	 */
	
	List<SccMxMaeAppCarteraDTO> buscaCreditosCarteraPorIdClienteIdProd(Long idCliente);
	

}
