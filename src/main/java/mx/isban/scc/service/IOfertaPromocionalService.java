package mx.isban.scc.service;

/**
 * Interfaz para los servicios de consulta de cat_logos
 * 
 * @author GlobalHitss Mayo 2019 Sprint 2
 * 
 *
 */
public interface IOfertaPromocionalService {

	/**
	 * Método para buscar el valor de la tasa de oferta promocional considerando el
	 * valor de producto y subproducto
	 * 
	 * @param idModalidad            Valor de modalidad
	 * @param idSubProd              Valor de subprod
	 * @param buc                    buc cliente
	 * @param tipoPerfilSeleccionado buc cliente
	 * @return String valor de dto de oferta
	 */
	String buscaOfertaPromocional(Long idModalidad, String idSubProd, Long buc, Long tipoPerfilSeleccionado);

}
