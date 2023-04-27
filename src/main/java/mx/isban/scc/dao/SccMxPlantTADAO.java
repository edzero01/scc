package mx.isban.scc.dao;

import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaePlantTA;

/**
 * Implementación de la interfaz para acceso de datos a SccMxMaePlantTA
 * 
 * @author Gabriel Dolores García
 * 
 *         Global Hitss Julio 2019
 *
 */
@Repository
public class SccMxPlantTADAO extends AbstractDAO<SccMxMaePlantTA> implements ISccMxPlantTADAO {

	/**
	 * Sobreescritura de metodo de clase abstracta
	 */
	@Override
	protected Class<SccMxMaePlantTA> getType() {
		return SccMxMaePlantTA.class;
	}

}
