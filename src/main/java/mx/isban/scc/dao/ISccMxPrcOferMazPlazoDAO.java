package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
/**
 * interfaz publica para los metodos 
 * de consulta
 * de ofertas maximas y plazos
 * @author Hitss
 *
 */
public interface ISccMxPrcOferMazPlazoDAO extends IAbstractDAO<SccMxPrcOferMaxPlzo> {

	/**
	 * Método abstracto para buscar todos las ofertas maximas por plazo Mayo 2019
	 * Sprint 1
	 * 
	 * @author Octavio Cruz Rosas
	 * @param id Identificador unico de las ofertas de campaña
	 * @return List(SccMxPrcOferMaxPlzo) lista las ofertas maximo por plazo encontradas para para la campaña
	 */
	List<SccMxPrcOferMaxPlzo> buscaOfertasMaximasPlazo(Long id);
	
	
	/**
	 * Método abstracto para buscar las tasas de interes asociadas a la campaña Mayo 2019
	 * Sprint 1
	 * 
	 * @author Octavio Cruz Rosas
	 * @param id Identificador unico de las ofertas de campaña
	 * @return List(SccMxPrcOferMaxTasa) lista las tasas de interes encontradas para para la campaña
	 */
	List<SccMxPrcOferMaxTasa> buscaTasas(Long id);
	
	
	/**
	 * Método abstracto para buscar todos las ofertas maximas por plazo Mayo 2019
	 * Sprint 1
	 * 
	 * @author Octavio Cruz Rosas
	 * @param id Identificador unico de las ofertas de campaña
	 * @param idTasa Tasa de interes asociado a la oferta maxima de campaña
	 * @return List(SccMxPrcOferMaxPlzo) lista las ofertas maximo por plazo encontradas para para la campaña
	 */
	List<SccMxPrcOferMaxPlzo> buscaOfertasMaximasPlazoTasa(Long id, Long idTasa);
	
	

}
