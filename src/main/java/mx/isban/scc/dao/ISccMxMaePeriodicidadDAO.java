package mx.isban.scc.dao;

import java.util.HashMap;
import java.util.List;

import mx.isban.scc.model.SccMxMaePeriod;
import mx.isban.scc.model.SccMxMaeProducto;

/**
 * Interfaz de Dao para leer las periodicidades, convierte el código "M:0; Q:0, C:0, S:0"
 * Para mandar las periodicidades a front end así como la gracia, con el ID del subproducto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
public interface ISccMxMaePeriodicidadDAO extends IAbstractDAO<SccMxMaePeriod> {

	/**
	 * Método abstracto para buscar todos los períodos
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return lista todos los períodos encontrados.
	 */
	List<SccMxMaePeriod> buscaTodos();
	
	
	/**
	 * Método abstracto para buscar todos los períodos ordenados por hash
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return hash con  todos los períodos encontrados cuya llave es codPeriod
	 */
	HashMap<String, SccMxMaePeriod> buscaTodosHash();

	/**
	 * Método abstracto para buscar períodos por id
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param dscPeriod
	 * identificador único del período
	 * @return regresa el período encontrado en base al parámetro de entrada.
	 */
	SccMxMaePeriod buscaPeriodPorId(String dscPeriod);

	/**
	 * Método abstracto para buscar período por id de prdocuto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del producto
	 * @return lista de los períodos que corresponden al id de producto.
	 */
	List<SccMxMaeProducto> buscaPeriodPorIdProd(long id);

}
