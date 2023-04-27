package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeOferPromMa;

/**
 * Interfaz para leer las Ofertas promocionales por subproducto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
public interface ISccMxMaeOferPromMaDAO extends IAbstractDAO<SccMxMaeOferPromMa> {
	
	/**
	 * Interfaz busca Ofertas promocionales de mercado abierto por id subprodcuto
	 * @param id
	 * id de subproducto
	 * @return List(SccMxMaeOferPromMa)
	 */
	List<SccMxMaeOferPromMa> buscaOferPromBySubProd(long id);
	/**
	 * Interfaz busca Ofertas promocionales de mercado abierto por id del cliente
	 * @param id
	 * buc de cliente
	 * @return List(SccMxMaeOferPromMa)
	 */
	List<SccMxMaeOferPromMa> buscaOferPromByBucClte(long id);
	/**
	 * Interfaz busca Ofertas promocionales de mercado abierto por id del cliente y idSubProducto
	 * @param id buc del cliente
	 * Buc del Cliente
	 * @param idSubProducto id del SubProducto
	 * Identificador del subproducto
	 * @param tipoPerfilSeleccionado tipo de perfil seleccionado
	 * @return List(SccMxMaeOferPromMa)
	 */
	List<SccMxMaeOferPromMa> buscaOferPromByBucClte(long id, String idSubProducto, Long tipoPerfilSeleccionado);
	

	

}
