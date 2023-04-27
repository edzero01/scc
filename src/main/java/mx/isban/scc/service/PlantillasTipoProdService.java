package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxPlantTipoProdDAO;
import mx.isban.scc.model.SccMxMaePlantTipoProd;


/**
 * Clase Servicio para buscar los datos de las plantillas por tipo de producto,
 * para poder hacer referencia genérica a ls servicios de consulta de 
 * plantillas
 * 
 * @author Gabriel Dolores García
 *
 */
@Service
@Qualifier("plantillasTipoProd")
public class PlantillasTipoProdService implements IPlantillaLoaderService {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillasTipoProdService.class);
	/**
	 * Variable que sirve para acceder al dao de ISccMxPlantTipoProdDAO
	 */
	@Autowired
	private ISccMxPlantTipoProdDAO dao;
	
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
		SccMxMaePlantTipoProd vo = dao.buscaPlantilla(idTipoPlantillaPk, plantilla);
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
