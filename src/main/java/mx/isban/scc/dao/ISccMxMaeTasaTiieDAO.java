package mx.isban.scc.dao;

import mx.isban.scc.model.SccMxMaeTiie;

/**
 * Interfaz para los metodos de consulta 
 * a BD sobre la entidad SccMXMaeTIIE
 * Esta tasa debe obtenerse con un filtro de fecha
 * @author Ivan Cruz Azuara
 *
 */
public interface ISccMxMaeTasaTiieDAO extends IAbstractDAO<SccMxMaeTiie> {

	
	/**
	 * Metodo para 	obtener la ultima tasa TIIE
	 * @return Double Tasa TIIE -Lista de fondos de garantia
	 * @author Ivan Cruz Azuara
	 */
	Double buscaUltimaTasaTIIE();
	
}
