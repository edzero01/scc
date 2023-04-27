package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeTipoProd;

/**
 * Interfaz para el DAO que busca la lista todos los tipos de producto
 * Mayo 2019
 * Sprint 1
 * @author GLobalHitss
 *
 */
public interface ISccMxMaeTipoProdDAO extends IAbstractDAO<SccMxMaeTipoProd> {
	
	/**
	 * Método abstracto para buscar todos los tipos de producto
	 * por modalidad
	 * Noviembre 2019
     * Sprint 1
     *  @param modalidad recibe la modalidad a usar para el
	 *  filtrado de tipos de productos
	 * @return lista todos los tipos de productos.
	 */
	List<SccMxMaeTipoProd> buscaTodos(Integer ... modalidad);

}
