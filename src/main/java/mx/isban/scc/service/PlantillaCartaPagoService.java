package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.dto.SccMxPlantillaCPagoNAdeudosDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaCPNA;

/**
 * Implementacion de los metodos de interfaz para obtencion de plantilla cert desc
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
 */
@Service
public class PlantillaCartaPagoService implements IPlantillaCartaPagoService{

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCartaPagoService.class);
	/**
	 * constante de clase, con finalidad de calculos
	 */
	@Autowired
	private  PlantillaCPNA plantillaCPNA;
	
	/**
	 * Implementación de metodo abstracto de interfaz plantilla 1
	 * Carta Compromiso
	 * @author Christopher Espina
	 * @param comPago SccMxPlantillaCPagoNAdeudosDTO
	 * @param pathO ByteArrayOutputStream Contenido de la plantilla
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return ByteArrayOutputStream  Contenido del documento (plantilla + data)
	 */
	@Override
	public ByteArrayOutputStream obtenPlantillaCP(SccMxPlantillaCPagoNAdeudosDTO comPago, 
			                                      ByteArrayOutputStream pathO){
		ByteArrayOutputStream path = null;
		try {
			path = plantillaCPNA.docCP(comPago, pathO);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return path;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz plantilla 1
	 * 
	 * @author Christopher Espina
	 * @param noAdeud SccMxPlantillaCPagoNAdeudosDTO
	 * @param pathO ByteArrayOutputStream Contenido de la plantilla
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return ByteArrayOutputStream  Contenido del documento (plantilla + data)
	 */
	@Override
	public ByteArrayOutputStream obtenPlantillaNA(SccMxPlantillaCPagoNAdeudosDTO noAdeud, 
			                                      ByteArrayOutputStream pathO){
		ByteArrayOutputStream path = null;
		try {
			path = plantillaCPNA.docNA(noAdeud, pathO);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return path;
	}

}
