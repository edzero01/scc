package mx.isban.scc.dao;

import mx.isban.scc.model.SccMxMaeConvauto;
/**
 * Interfaz publica con la finalidad
 * de encontrar la tasa conv auto
 * por codigo de lapa o por segmento
 * de cliente
 * @author Hitss
 * 
 * Mayo2019
 *
 */
public interface ISccMxMaeOfertaPromocionalDAO extends IAbstractDAO<SccMxMaeConvauto> {
	/**
	 * Metodo para 	obttener tasa conv auto
	 * por numero de laoa
	 * @param numLapa
	 * numero de lapa
	 * @return
	 * Valor tasa
	 */
	Double buscaTasaPorNumLapa(long numLapa);
	/**
	 * Metodo para obtener tasa conv auto
	 * por segmento 
	 * @param idSegmento
	 * segmento de cliente
	 * @return 
	 * valor tasa
	 */
	Double buscaTasaPorSegmento (long idSegmento);

}
