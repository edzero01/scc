package mx.isban.scc.utilerias.plantillas.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.isban.scc.service.IPlantillaLoaderService;

/**
 * Clase útil para obtener la interfaz que buscará las plantillas
 * es encesario pasarle el número del tipo de plantilla que
 * se desea instanciar
 * @author Gabriel Dolores García
 *
 */
@Component
public class PlantillaLookupStrategy implements IPlantillaLookupStrategy{

	
	/**
	 * Variable para las plantillas del tipo Tablas de amortización
	 */
	@Autowired @Qualifier("plantillasTA") private IPlantillaLoaderService plantTA;
	
	/**
	 * Variable para las plantillas del tipo Plantillas Generales
	 */
	@Autowired @Qualifier("plantillasTipoProd") private IPlantillaLoaderService plantTipoProd;
	
	
	/**
	 * Devuelve el objeto que se encargará de buscar las plantillas
	 * 
	 * @param idTipoPlantillaPk el id del tipo de plantilla
	 * @return IPlantillaLoaderService con la información de 
	 * las plantillas a buscar
	 */
	@Override
	public IPlantillaLoaderService lookup(int idTipoPlantillaPk) {
		switch( idTipoPlantillaPk ) {
		case 1:
		case 2:
		case 3: 
		case 4:
			return plantTipoProd;
		case 5:
			return plantTA;
		case 6:
			return plantTipoProd;
		case 7:
			return plantTipoProd;
		default:
			return null;
		}
		
		
	}
}
