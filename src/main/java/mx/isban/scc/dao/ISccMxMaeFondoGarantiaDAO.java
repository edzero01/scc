package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeFondoGarId;

/**
 * Se crea interface para los metodos 
 * de consulta sobre la entidad 
 * SccMxMaeFondoGarId  
 * Junio 2019 Sprint 2
 * @author Ivan Cruz Azuara
 */
public interface ISccMxMaeFondoGarantiaDAO extends IAbstractDAO<SccMxMaeFondoGarId> {

	
	/**
	 * Metodo para 	obtener la lista de fondos de Garantia
	 	 * @author Ivan Cruz Azuara
	 	 * @return Lista de fondos de garantia
	 */
	List<SccMxMaeFondoGarId> buscaFondosGarantia();
	
}
