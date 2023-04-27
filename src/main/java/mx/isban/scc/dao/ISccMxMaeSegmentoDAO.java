package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeSegmento;

/**
 * Interfaz de DAO que trae la lista de segmentos para Front End de Simulador
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
public interface ISccMxMaeSegmentoDAO extends IAbstractDAO<SccMxMaeSegmento> {

	/**
	 * Método abstracto para buscar todos los segmentos
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return lista de todos los segmentos encontrados.
	 */
	List<SccMxMaeSegmento> buscaTodos();
	/**
	 * Método abstracto para buscar segmento por id
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del segmento.
	 * @return regresa el segmento encontrado.
	 */
	SccMxMaeSegmento buscaSegPorId(long id);

}
