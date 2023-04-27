package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.dto.SccMxMaeProductoSubProductDTO;
import mx.isban.scc.model.dto.SccMxPeriodoPorIdProdDTO;

/**
 * Interfaz para los servicios de consulta de cat_logos
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 * 
 *
 */
public interface ICatalogosService {

	/**
	 * Se trae los subproductos por id
	 * 
	 * @author GlobalHitss
	 * @param id          identificador _nico del producto
	 * @param idModalidad modalidad
	 * @return List(SccMxMaeProductoSubProductDTO) lista de subproductos
	 */
	List<SccMxMaeProductoSubProductDTO> buscaSubProdByIdProd(long id, Long idModalidad);

	/**
	 * Busca Periodicidad por id de producto
	 * 
	 * @author GlobalHitss
	 * @param id identificador _nico del producto
	 * @return List(SccMxPeriodoPorIdProdDTO) lista de periodicidades del producto
	 */
	List<SccMxPeriodoPorIdProdDTO> buscaPeriodicidadPorIdProd(Long id);

	/**
	 * Busca Periodicidad por id de producto
	 * 
	 * @author GlobalHitss
	 * @param idTipoProd identificador unico del tipo Producto
	 * @return List(SccMxMaeProductoSubProductDTO) lista de subproductos
	 */
	List<SccMxMaeProductoSubProductDTO> buscaSubProdByIdTipo(Long idTipoProd);

	/**
	 * Busca el id del segmento de conversión auto usando el id segmento del cliente
	 * que es el del catàlogo del segmento
	 * 
	 * @param idSegmentoSgto id del segmento del cliente
	 * @return Long Id del segmento de conversión auto
	 */
	Long buscaIdSegmentoConvAuto(Long idSegmentoSgto);
}
