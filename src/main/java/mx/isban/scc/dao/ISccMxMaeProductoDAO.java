package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeProducto;

/**
 * Interfaz de Dao que busca los tipos de productos por Id
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 * 
 */


public interface ISccMxMaeProductoDAO extends IAbstractDAO<SccMxMaeProducto> {
	
	/**
	 * Método abstracto para buscar todos los productos
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return lista todos los productos encontrados.
	 */
	List<SccMxMaeProducto> buscaTodos();

	/**
	 * Método abstracto para buscar producto por id
	 * Mayo 2019
     * Sprint 1 
	 * @param id identificador único  del producto
	 * @return regresa producto encontrado por el id.
	 */
	SccMxMaeProducto buscaProdPorId(long id);


}
