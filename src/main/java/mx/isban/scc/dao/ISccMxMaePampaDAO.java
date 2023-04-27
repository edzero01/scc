package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaePampa;

/**
 * Interfaz para acceso de datos a SCC_MX_MAE_PAMPA
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
public interface ISccMxMaePampaDAO {
	/**
	 * Metodo abstracto para obtener la lista de los datos de PAMPA LINEX
	 * @author Christopher Espina Riveros
	 * Modificado por Lorena Baruch 21 de Octubre 2019

	 * @param credito
	 * Numero de Contrato obtenido de Campaña
	 * @param sucursal
	 * ID de la sucursal que viene en campaña
	 * @return List<SccMxMaePampa>
	 * Lista de los registros de pampa, ya que puede haber más de uno con el mismo crédito y sucursal y se debe considerar
	 * la info completa para el cálculo de la prima devengada
	 */
	List<SccMxMaePampa> obtenPampa( long credito, long sucursal);

}
