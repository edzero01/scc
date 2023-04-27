package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import mx.isban.scc.model.dto.SccMxPlantillaDescDTO;
/**
 * Interfaz para la obtención de las plantillas
 * de certificado de descuentos y el llenado
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


public interface IPlantillaCertificadoDescService {

	/**
	 * Metodo abstracto para certificado descuento 1
	 * @param certDesc
	 * recibe datos de entrada para documento
	 * @param pathO
	 * path origen
	 * @return localidad de documento a descargar
	 */
	ByteArrayOutputStream obtenPlantillaCD1(SccMxPlantillaDescDTO certDesc, ByteArrayOutputStream pathO);
	
	
	
}
