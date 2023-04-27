package mx.isban.scc.service;


import java.util.List;

import mx.isban.scc.model.dto.SccMxConvAutoLinexDTO;
import mx.isban.scc.model.dto.SccMxLinexCondFinanAuxDTO;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;

/**
 * Interfaz para la obtención de variables para 
 * calculo dado prdocuto linex
 *  
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Junio 2019
 * 
 *
 * 
 * 
 * @author Christopher Espina
 * 
 */


public interface ILinexService {

	/**
	 * Metodo para obtener tasa dado:
	 * @param idProd
	 * producto
	 * @param idSubProd
	 * subproducto
	 * @param lapa
	 * numero lapa
	 * @param plazo
	 * plazo
	 * @return tasa
	 * tasa de interes base
	 */
	SccMxMaeCondFinanDTO obtenCondicionesFinancieras(Long idProd, Long idSubProd, Long lapa, Long plazo);

	/**
	 * Metodo para buscar las condiciones financieras de Linex
	 * correspondiente al Num de Lapa obtenido con las 
	 * variables entrantes y obtener los plazos, montos y tasas
	 * a mostrar para la tabla de ofertas máximas
	 * @param idProd
	 * id del producto (no id del tipo de producto)
	 * @param idSubProd
	 * id del subproducto
	 * @param idCteBuc
	 * id del cliente para buscar el lapa
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	
	SccMxLinexCondFinanAuxDTO buscaCondTPPLinex(Long idProd, Long idSubProd, Long idCteBuc);
	

	/**
	 * Metodo para obtener las condiciones financieras 
	 * promocionales segun el numero de LAPA obtenido
	 * en la tabla de ofertas de campana promocionales
	 * Los datos de esta condicones financieras 
	 * se utilizaran en lugar de conversion auto 
	 * en caso de que aplique
	 * @param idProd
	 * id del producto (no id del tipo de producto)
	 * @param idSubProd
	 * id del subproducto
	 * @param idCteBuc
	 * id del cliente para buscar el lapa
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	
	List<SccMxMaeCondFinanDTO> buscaCondFinancierasLinexPromocional(Long idProd, Long idSubProd, Long idCteBuc);

	
	/**
	 * Metodo para obtener los datos variables 
	 * para la conversion auto de los productos
	 * Linex 
	 * @param idSegmento
	 * descripcion del Segmento para obtener  la LAPA de ConvAuto
	 * @param idPeriodicidad
	 * id de la periodicidad para filtro 
	 * @param plazo
	 * Plazo con numero de dias
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	
	SccMxConvAutoLinexDTO buscaConvAutoLinex(Long idSegmento, Long idPeriodicidad, Long plazo);
	
	
}
