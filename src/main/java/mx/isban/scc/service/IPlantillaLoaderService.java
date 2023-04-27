package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

/**
 * Interfazpara buscar los datos de las plantillas por tipo de producto 
 * para poder hacer referencia genérica a ls servicios de consulta de 
 * plantillas
 * 
 * @author Gabriel Dolores García
 *
 */
public interface IPlantillaLoaderService {

	
	/**
	 * Método que busca la información de las plantillas por tipo de plantilla 
	 * y tipo de producto
	 * 
	 * @param idTipoPlantillaPk id del tipo de plantilla
	 * @param plantilla dato de la plantilla a buscar, en éste caso es el 
	 * tipo de producto
	 * @return ByteArrayOutputStream con los datos de la plantilla
	 */
	ByteArrayOutputStream lookup(long idTipoPlantillaPk, long plantilla);
}
