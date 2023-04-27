package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeOferPromCam;
/**
 * Interfaz publica con finalidad
 * de realizar consultas
 * de ofertas promocionales de 
 * campania
 * @author Hitss
 *
 */
public interface ISccMxMaeOferPromCamDAO extends IAbstractDAO<SccMxMaeOferPromCam> {
	/**
	 * Interfaz DAO busca ofertas promcionales de campaña por id del cleinte
	 * o por subproducto
	 * @param id
	 * Identificador del Buc Cliente
	 * @param idSubProducto
	 * Identificador ddel subproducto (key)
	 * @param tipoPerfilSeleccionado
	 * tipo del perfil seleccionado
	 * @return List(SccMxMaeOferPromCam)
	 * Lista de registros de oferta promocional campaña
	 */
	List<SccMxMaeOferPromCam>  buscaOferPromCamByBucClte(long id, String idSubProducto, Long tipoPerfilSeleccionado);

}
