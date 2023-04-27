package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeCondFinan;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;

/**
 * Interfaz para el DAO que lee las condiciones financieras
 * Mayo 2019
 * Sprint 1
 * @author Alexis Cedillo
 * 
 *
 */
public interface ISccMxMaeCondFinanDAO extends IAbstractDAO<SccMxMaeCondFinan>{
/**
 * Método abstracto para buscar condiciones financieras por id de sub producto
 * Mayo 2019
 * Sprint 1
 * @author Alexis Cedillo
 * @param id identificador unico del tipo de supproducto
 * @return lista con las condiciones financieras
 */
	List<SccMxMaeCondFinan> buscaCondicionPorIdSubProd(Long id);
	
	/**
	 * Método abstracto para buscar condiciones financieras por tasa, plazo, periodo
	 * Mayo 2019
	 * Sprint 1
	 * @author Alexis Cedillo
	 * @param id
	 * id del SubProducto, no enviar idProducto, sino idSubproducto
	 * Recueeeeerdalo
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * plazo
	 * @return lista con las condiciones financieras
	 */
	
	List<SccMxMaeCondFinan> buscaCondTPP(Long id, Double idTasa, Long idPlazo, Long idPeriod);
	
	/**
	 * Método abstracto para buscar condiciones financieras por tasa, plazo, periodo
	 * Mayo 2019
	 * Sprint 1
	 * @author Alexis Cedillo
	 * @param idProdPk
	 * idProdPk del producto
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * plazo
	 * @return lista con las condiciones financieras
	 */
	List<SccMxMaeCondFinanDTO> buscaCondTPPOfMax(Long idProdPk, Double idTasa, Long idPlazo, Long idPeriod);
	
	/**
	 * Método para buscar tasa base para productos linez
	 * 
	 * @author Christopher Espina
	 * @param idProd
	 * id producto
	 * @param idSubProd
	 * id sub producto
	 * @param lapa
	 * numero de lapa
	 * @param plazo
	 * plazo
	 * @return SccMxMaeCondFinan
	 */
	SccMxMaeCondFinan obtenTasa (Long idProd, Long idSubProd, Long lapa, Long plazo);
	
	
		/**
		 * Método abstracto para buscar condiciones financieras por tasa, plazo, periodo
		 * Mayo 2019
		 * Sprint 3.2
		 * @author Ivan Cruz Azuara
		 * @param idProd
		 * id del producto(no es el tipo de producto)
		 * @param idSubProd
		 * idSubproducto que corresponde al id de la tabla sccmxmaesubprod
		 * @param idCteBuc
		 * BUC  id del cliente del que se requiere buscar las condiciones financieras
		 * @return lista con las condiciones financieras
		 */
		
		List<SccMxMaeCondFinan> buscaCondTPPLinex(Long idProd,Long idSubProd, Long idCteBuc);
	
		/**
		 * Método abstracto para buscar condiciones financieras promocionales para Linex
		 * Mayo 2019
		 * Sprint 3.2
		 * @author Ivan Cruz Azuara
		 * @param idProd
		 * id del producto(no es el tipo de producto)
		 * @param idSubProd
		 * idSubproducto que corresponde al id de la tabla sccmxmaesubprod
		 * @param idBucCte
		 * BUC  id del cliente del que se requiere buscar las condiciones financieras
		 * @return lista con las condiciones financieras
		 */
		List<SccMxMaeCondFinan> buscaCondPromoLinex(Long idProd, Long idSubProd, Long idBucCte);
}
