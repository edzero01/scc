package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import mx.isban.scc.model.dto.SccMxPlantillaCPagoNAdeudosDTO;
/**
 * Interfaz para la obtención de las plantillas
 * de Carta Compromiso o bien el documento para la
 * manifestacion de no adeudos y el llenado
 * de las mismas, que son 6
 *  
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Julio 2019
 * 
 *
 * 
 * 
 * @author Christopher Espina
 * 
 */


public interface IPlantillaCartaPagoService {

	/**
	 * Metodo abstracto para cartaCompromisoPago 1
	 * @param comPago
	 * recibe datos de entrada para documento
	 * @param pathO
	 * path origen
	 * @return localidad de documento a descargar
	 */
	ByteArrayOutputStream obtenPlantillaCP(SccMxPlantillaCPagoNAdeudosDTO comPago, ByteArrayOutputStream pathO);

	/**
	 * Metodo abstracto para cartaCompromisoPago 1
	 * @param noAdeud
	 * recibe datos de entrada para documento
	 * @param pathO
	 * path origen
	 * @return localidad de documento a descargar
	 */
	ByteArrayOutputStream obtenPlantillaNA(SccMxPlantillaCPagoNAdeudosDTO noAdeud, ByteArrayOutputStream pathO);
	
}
