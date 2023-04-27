package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxPlantTADAO;
import mx.isban.scc.model.SccMxMaePlantTA;


/**
 * Clase Servicio para buscar los datos de las plantillas por tipo de producto,
 * para poder hacer referencia genérica a ls servicios de consulta de 
 * plantillas
 * 
 * @author Gabriel Dolores García
 *
 */
@Service
@Qualifier("plantillasTA")
public class PlantillasTAService implements IPlantillaLoaderService{

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillasTAService.class);
	/**
	 * Variable que sirve para acceder al dao de SccMxPlantTADAO
	 */
	@Autowired
	private ISccMxPlantTADAO dao;
	
	/**
	 * Método que busca la información de las plantillas por tipo de producto
	 * 
	 * @param idTipoPlantillaPk id del tipo de plantilla
	 * @param plantilla dato de la plantilla a buscar, en éste caso es el 
	 * tipo de producto
	 * @return ByteArrayOutputStream con los datos de la plantilla
	 */
	@Override
	public ByteArrayOutputStream lookup(long idTipoPlantillaPk, long plantilla) {
		SccMxMaePlantTA vo = dao.findById(plantilla);
		ByteArrayOutputStream bous = new ByteArrayOutputStream();
		try {
			bous.write(vo.getPlantilla());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
			return null;
		}
		return bous;
	}

}
