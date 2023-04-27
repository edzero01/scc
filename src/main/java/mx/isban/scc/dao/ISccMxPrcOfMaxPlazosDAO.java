package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.dto.SccMxTablaOfMaxDTO;


/**
 * Interfaz para ofertas maximas
 * @author baruchlw
 *
 */
public interface ISccMxPrcOfMaxPlazosDAO extends IAbstractDAO<SccMxPrcOferMaxPlzo>{
	
	/** 
	 * declaracion del metodo buscaPlazos
	 * @param idTasa
	 * Recibe el id de la tasa elegida por el usuario
	 * @return Lista de plazos
	 * Esa lista se despliega en FE para q el usuario elija el plazo
	 */
	List<SccMxPrcOferMaxPlzo> buscaPlazos(long idTasa);
	
	/** 
	 * declaracion del metodo que trae la tabla de ofertas maximas
	 * @param idTasa
	 * Recibe el id de la tasa elegida por el usuario
	 * @param idOfMax
	 * id oferta maxima
	 * @return Lista de plazos
	 * Esa lista se despliega en FE para q el usuario elija el plazo
	 */
	List<SccMxTablaOfMaxDTO> getTablaOfMax(long idTasa, long idOfMax);
}
