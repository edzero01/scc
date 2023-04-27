package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeSubProd;

/**
 * Interfaz para el Dao que trae los subproductos enviando el id de tipo de producto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
public interface ISccMxMaeSubProdByIdProdDAO extends IAbstractDAO<SccMxMaeSubProd> {
	/**
	 * Método abstracto para buscar sub producto por id de producto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id
	 * id producto
	 * @param idModalidad	
	 * identificador único  del tipo de producto
	 * @return lista los 
	 * subproducto encontrados por el tipo producto.
	 */
	List<SccMxMaeSubProd> buscaSubProdPorIdProd(long id,Long idModalidad);
	
	
	
	
	/**
	 * Método abstracto para buscar sub producto por id tipo producto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param idTipoProd
	 * identificador unico del tipo producto	
	 * @return lista los 
	 * subproducto encontrados por el tipo producto.
	 */
	List<SccMxMaeSubProd> buscaSubProdPorIdTipoProd(Long idTipoProd);

}
