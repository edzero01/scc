package mx.isban.scc.service;

import mx.isban.scc.model.dto.SccMxMaeOferCampMaDTO;
/**
 * Interfaz publica para obtener
 * datos del cliente de existir
 * @author Hitss
 *
 */
public interface IClienteService {
	
	/**
	 * Interface service para obtener 
	 * ofertas promocionales
	 * 
	 * @param id
	 * identificador del cliente
	 * @param perfil
	 * ID del perfil para filtrar las campañas que pueden o no verse
	 * con las banderas del arachivo de campañas cod_vta_in, out, etc.
	 * @return SccMxMaeOferCampMaDTO
	 */
	SccMxMaeOferCampMaDTO obtenerOferCamMa(long id, long perfil);
	
	/**
	 * Interface service para obtener 
	 * las ofertas maximas por plazo
	 * 
	 * @param idCampania parametro id de la campaña
	 * @param idTasa parametros id de la tasa
	 * @param idPagoSeguro  id del pago seguro
	 * @param idPeriodicidad identificador unico de la periodicidad
	 * @param codPeriod codigo del periodo
	 * @param idProducto identificador unico del producto
	 * @return SccMxMaeOferCampMaDTO
	 */
	SccMxMaeOferCampMaDTO obtenerOferMaxPlazo(Long idCampania, Long idTasa, Long idProducto, String codPeriod, Long idPeriodicidad, Long idPagoSeguro);

}
