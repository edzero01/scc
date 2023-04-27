package mx.isban.scc.dao;


/**
 * Interfaz DAO que define las consultas para validar la existencia de prdocutos y subproductos
 * 
 * Tambien valida la existencias de productos y subproductos por periodo
 * 
 * Junio 2019 Sprint 3
 * 
 * @author Hitss
 *
 */
public interface ISccMxProdSubProdDAO {

	/**
	 * Metodo para validar la existencia de prodductos
	 * Sprint 3
	 * Junio 2019
	 * @author Hitss
	 * @param idProd identificador del producto
	 * @param idSubProd identificador del subproducto
	 * @return Boolean Valor que nos devuelve un verdadero o falso
	 */
	Boolean existeProdSubProd (Long idProd, Long idSubProd);
	
	/**
	 * Metodo para validar la existencia de prodductos
	 * Sprint 3
	 * Junio 2019
	 * @param idProd identificador del producto
	 * @param idSubProd identificador del subproducto
	 * @return Boolean Valor que nos devuelve un ve
	 * @param idPeriodo identificador del periodo
	 * @return Boolean Valor que nos devuelve un verdadero o falso
	 */
	
	Boolean existeProdSubProdPeriodo (Long idProd, Long idSubProd, Long idPeriodo);
	
}
