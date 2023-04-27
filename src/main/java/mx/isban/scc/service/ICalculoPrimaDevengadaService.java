package mx.isban.scc.service;

import mx.isban.scc.model.dto.SccMxMaePampaDTO;

/**
 * Interfaz para consulta de catalogo cartera 
 * para proceso de calculo de prima devengada
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
public interface ICalculoPrimaDevengadaService {
	/**
	 * Metodo para obtener prima devengada
	 * @param idCliente
	 * id de cliente
	 * @param credito
	 * credito a sustituir
	 * @param idProducto
	 * producto relacionado
	 * @return primaDevengada
	 * primaDevengada
	 */
	Double primaDevengada(long idCliente, long credito, long idProducto);
	/**
	 * Metodo para obtener prima devengada linex
	 * @param credito
	 * credito linex
	 * @param suc
	 * numero de la sucursal obtenido en campaña
	 * @return Double
	 * valor de la prima devengada
	 */
	SccMxMaePampaDTO primaDevengadaLinex(long credito, long suc);

}
