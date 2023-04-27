package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeAppCartera;


/**
 * Interfaz para acceso de datos a SCC_MX_MAE_APP_CARTERA
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
public interface ISccMxMaeAppCarteraDAO {
	/**
	 * Metodo abstracto para obtener dto de prima devengada
	 * @author Christopher Espina Riveros
	 * @param idCliente
	 * id de cliente
	 * @param credito
	 * credito a sustituir
	 * @param idProducto
	 * id producto
	 * @return SccMxBonificacionConsumoDTO
	 * DTO de cartera
	 */
	SccMxMaeAppCartera obtenDtoCartera (long idCliente, long credito, long idProducto);
	
	
	/**
	 * Metodo abstracto para obtener dto cartera
	 * @author Octavio Cruz Rosas	
	 * @param idCliente
	 * id de cliente
	 * 
	 * @return List(SccMxMaeAppCartera)
	 *  lista de los creditos encontrados en cartera
	 */
	List<SccMxMaeAppCartera> obtenCreditosClientePorProducto (Long idCliente);

}
