package mx.isban.scc.dao;

import mx.isban.scc.model.SccMxMaeConvauto;
import mx.isban.scc.model.dto.SccMxConvAutoLinexDTO;
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
public interface ISccMxMaeConvAutoDAO extends IAbstractDAO<SccMxMaeConvauto> {
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
	SccMxMaeConvauto buscaTasaPorSegmento (long idSegmento);

	/**
	 * Metodo para obtener tasa conv auto
	 * por segmento 
	 * @param idSegmento
	 * segmento de conversion auto
	 * @param idPeriodicidad
	 * id de la periodicidad a filtrar
	 * @param plazo
	 * numero de plazo en dias
	 * @return 
	 * DTO Linex de datos para conversion auto
	 */
	SccMxConvAutoLinexDTO buscaConvAutoLinexData (Long idSegmento, Long idPeriodicidad, Long plazo);
	
}
