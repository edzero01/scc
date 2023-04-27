package mx.isban.scc.utilerias.plantillas.helper;

import mx.isban.scc.service.IPlantillaLoaderService;

/**
 * Interfaz útil para obtener la interfaz que buscará las plantillas
 * es encesario pasarle el número del tipo de plantilla que
 * se desea instanciar
 * @author Gabriel Dolores García
 *
 */
public interface IPlantillaLookupStrategy {

	/**
	 * Devuelve el objeto que se encargará de buscar las plantillas
	 * 
	 * @param idTipoPlantillaPk el id del tipo de plantilla
	 * @return IPlantillaLoaderService con la información de 
	 * las plantillas a buscar
	 */
	IPlantillaLoaderService lookup(int idTipoPlantillaPk);

}
