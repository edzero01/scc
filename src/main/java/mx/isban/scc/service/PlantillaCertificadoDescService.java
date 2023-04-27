package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.dto.SccMxPlantillaDescDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaCD;

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
public class PlantillaCertificadoDescService implements IPlantillaCertificadoDescService {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCertificadoDescService.class);
	/**
	 * constante de clase, con finalidad de calculos
	 */
	@Autowired
	private  PlantillaCD plantillaCD;
	
	/**
	 * Implementación de metodo abstracto de interfaz plantilla 1
	 * 
	 * @author Christopher Espina
	 * @param certDesc 
	 * dato de entrada desde front
	 * @param pathO
	 * path de entrada de plantilla
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return path 
	 * regresa path de descarga
	 */
	@Override
	public ByteArrayOutputStream obtenPlantillaCD1(SccMxPlantillaDescDTO certDesc, ByteArrayOutputStream pathO){
		ByteArrayOutputStream path = null;
		try {
			path = plantillaCD.docCD1(certDesc, pathO);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return path;
	}

	
}
