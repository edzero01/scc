package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaePeriodicidadDAO;
import mx.isban.scc.dao.ISccMxMaeProductoDAO;
import mx.isban.scc.dao.ISccMxMaeSegmentoDAO;
import mx.isban.scc.dao.ISccMxMaeSubProdByIdProdDAO;
import mx.isban.scc.model.SccMxMaePeriod;
import mx.isban.scc.model.SccMxMaeProducto;
import mx.isban.scc.model.SccMxMaeSegmento;
import mx.isban.scc.model.SccMxMaeSubProd;
import mx.isban.scc.model.dto.SccMxMaeProductoSubProductDTO;
import mx.isban.scc.model.dto.SccMxPeriodoPorIdProdDTO;

/**
 * Implementacion de las busquedas de los 
 * catalogos para el servicio de
 * catalogosRestController motivos rechazo 
 * tipo producto segmento periodicidad
 * subproducto por id prod condiciones 
 * financieras conversion auto
 * 
 * Dichas inyecciones de dependencia son 
 * unicamente para obtener valores de
 * catalogos para llenado de combos, text box y 
 * motivos informativos en front
 * end Mayo 2019 Sprint 1 Fabrica de software
 *  Proyecto Simulador Credito al
 * Consumo Santander
 * 
 * Actualizacion en Noviembre 2019 , se parte la
 *  clase en dos para poder
 * pasar el sonar  y mover las dependencias de
 *  catalogos que se usan en el
 * simulador al CatalogosSimService
 * @author GlobalHitss
 * Gabriel Dolores Garcia
 * Lorena Baruch A
 *
 *
 */
@Service
public class CatalogosService implements ICatalogosService {

	/**
	 * Dao para acceder a los segmentos
	 */
	@Autowired
	private ISccMxMaeSegmentoDAO daoSegmento;

	/**
	 * Dao para acceder a las periodicidades
	 */
	@Autowired
	private ISccMxMaePeriodicidadDAO daoPeriodicidad;

	/**
	 * Dao para acceder a subproductos por producto
	 */
	@Autowired
	private ISccMxMaeSubProdByIdProdDAO daoSubProdByProdId;

	
	/**
	 * Dao para acceder a productos
	 */
	@Autowired
	private ISccMxMaeProductoDAO daoProds;

	/**
	 * Se trae los subproductos por id Junio 2019 Sprint 3
	 * Actualizacion NOviembre 2019
	 * Producto Final
	 * @author GlobalHitss
	 * Gabriel Dolores Garcia
	 * Lorena Baruch
	 * @param id
	 * 
	 * identificador unico del producto
	 * @return lista de subproductos
	 */
	@Override
	@Cacheable(cacheNames = "SubprodsByProdsModalidad")
	public List<SccMxMaeProductoSubProductDTO> buscaSubProdByIdProd(long id, Long idModalidad) {
		List<SccMxMaeSubProd> ltProductSubProduct = daoSubProdByProdId.buscaSubProdPorIdProd(id, idModalidad);
		List<SccMxMaeProductoSubProductDTO> ltProductGen = new ArrayList<>();

		ltProductSubProduct.stream().forEach(objProSub -> {

			SccMxMaeProductoSubProductDTO dto = llenaObjeto(objProSub);
			ltProductGen.add(dto);
		});
		return ltProductGen;
	}

	/**
	 * Inicializa un objeto del tipo SccMxMaeProductoSubProductDTO con el parametro
	 * del tipo SccMxMaeSubProd
	 * 
	 * @param objProSub del tipo SccMxMaeSubProd
	 * @return del tipo SccMxMaeProductoSubProductDTO
	 */
	private SccMxMaeProductoSubProductDTO llenaObjeto(SccMxMaeSubProd objProSub) {
		SccMxMaeProductoSubProductDTO dto = new SccMxMaeProductoSubProductDTO();
		dto.setIdProdPk(objProSub.getSccMxMaeProducto().getIdProdPk());
		dto.setCodProd(objProSub.getSccMxMaeProducto().getCodProd());
		dto.setIdSubProdPk(objProSub.getIdSubProdPk());
		dto.setCodSubProd(objProSub.getCodSubProd());
		dto.setDesProdComercial(objProSub.getSccMxMaeProducto().getDesProdComercial());
		dto.setDscPagSeg(objProSub.getSccMxMaeProducto().getSccMxMaePagoSeguro().getDscPagSeg());
		dto.setDscCoberturaSeg(objProSub.getSccMxMaeProducto().getDscCoberturaSegCc());
		dto.setIdPagoSeguro(objProSub.getSccMxMaeProducto().getSccMxMaePagoSeguro().getIdPagSegPk());
		dto.setDescPagoSeguro(objProSub.getSccMxMaeProducto().getSccMxMaePagoSeguro().getDscPagSeg());
		dto.setPlanTabla(objProSub.getSccMxMaeProducto().getIdPlnTablaAmortiz().toString());
		dto.setIdModalidadFk(objProSub.getSccMxMaeProducto().getSccMxMaeModalidadByIdModalidadFk().getIdModalidadPk());
		dto.setDscModalidad(objProSub.getSccMxMaeProducto().getSccMxMaeModalidadByIdModalidadFk().getDscModalidad());
		dto.setFlgConvAuto(objProSub.getSccMxMaeProducto().getFlgConvAuto());
		dto.setIdAmortizFK(objProSub.getSccMxMaeProducto().getIdAmortiz());
		dto.setDscSeguro(objProSub.getSccMxMaeProducto().getDscCoberturaSeg());
		if (objProSub.getSccMxMaeProducto().getIdPlnMandatorio() != null) {
			dto.setPlanMandatorio(objProSub.getSccMxMaeProducto().getIdPlnMandatorio().toString());
		}
		if (objProSub.getSccMxMaeProducto().getDscExclusionSeg() != null) {
			dto.setDscExclusionSeg(objProSub.getSccMxMaeProducto().getDscExclusionSeg().toString());
		}
		if (objProSub.getSccMxMaeProducto().getIdPlnCartaComp() != null) {
			dto.setPlanPago(objProSub.getSccMxMaeProducto().getIdPlnCartaComp().toString());
		}
		if (objProSub.getSccMxMaeProducto().getIdPlnNoadeudo() != null) {
			dto.setPlanAdeudo(objProSub.getSccMxMaeProducto().getIdPlnNoadeudo().toString());
		}
		return dto;
	}

	/**
	 * Busca Periodicidad por id de producto Sprint 3
	 * 
	 * Junio 2019
	 * 
	 * @author GlobalHitss
	 * @param id identificador _nico del producto
	 * 
	 * @return lista de periodicidades del producto
	 */

	@Override
	@Cacheable(cacheNames = "PeriodicidadByProd")
	public List<SccMxPeriodoPorIdProdDTO> buscaPeriodicidadPorIdProd(Long id) {
		
		SccMxMaeProducto producto = daoProds.findById( id );
		List<SccMxPeriodoPorIdProdDTO> periodicidades = new ArrayList<>();
		String codigos = "";
		List<SccMxMaePeriod> codigosArreglo = new ArrayList<>();

		HashMap<String, SccMxMaePeriod> periodos = daoPeriodicidad.buscaTodosHash();
		
		//ORDENAR LOS PERIODOS 
		codigos = producto.getTxtPeriodicidad();
		if (codigos.contains("M")) {
			codigosArreglo.add(periodos.get("M"));
		}
		if (codigos.contains("Q")) {
			codigosArreglo.add(periodos.get("Q"));
		}
		if (codigos.contains("C")) {
			codigosArreglo.add(periodos.get("C"));
		}
		if (codigos.contains("S")) {
			codigosArreglo.add(periodos.get("S"));
		}
		
		for (SccMxMaePeriod periodoActual : codigosArreglo) {
			
			SccMxPeriodoPorIdProdDTO dto = new SccMxPeriodoPorIdProdDTO();

			// Datos del producto
			dto.setCodProd(producto.getCodProd());
			dto.setIdProdPk(producto.getIdProdPk());
			dto.setCodigoGracia(producto.getTxtPeriodicidad());
			
			//De la periodicidad
			dto.setDscPeriodicidad(periodoActual.getDscPeriod());
			dto.setIdPeriodicidadPk(periodoActual.getIdPeriodPk());
			dto.setIdPeriodicidad(periodoActual.getCodPeriod());
			
			periodicidades.add( dto);
		}

		return periodicidades;
	}

	/**
	 * Se trae los subproductos por id tipo producto
	 * 
	 * @author GlobalHitss
	 * @param idTipoProd
	 * 
	 *                   identificador único del tipo producto
	 * 
	 * @return lista de subproductos
	 */
	@Override
	public List<SccMxMaeProductoSubProductDTO> buscaSubProdByIdTipo(Long idTipoProd) {
		List<SccMxMaeSubProd> listaSubproductos = daoSubProdByProdId.buscaSubProdPorIdTipoProd(idTipoProd);
		List<SccMxMaeProductoSubProductDTO> listaSubproductosDto = new ArrayList<>();

		for (SccMxMaeSubProd sccMxMaeSubProd : listaSubproductos) {
			SccMxMaeProductoSubProductDTO dto = new SccMxMaeProductoSubProductDTO();

			dto.setIdProdPk(sccMxMaeSubProd.getSccMxMaeProducto().getIdProdPk());
			dto.setCodProd(sccMxMaeSubProd.getSccMxMaeProducto().getCodProd());
			dto.setIdSubProdPk(sccMxMaeSubProd.getIdSubProdPk());
			dto.setCodSubProd(sccMxMaeSubProd.getCodSubProd());
			dto.setDesProdComercial(sccMxMaeSubProd.getSccMxMaeProducto().getDesProdComercial());
			dto.setDscPagSeg(sccMxMaeSubProd.getSccMxMaeProducto().getSccMxMaePagoSeguro().getDscPagSeg());
			dto.setDscCoberturaSeg(sccMxMaeSubProd.getSccMxMaeProducto().getDscCoberturaSegCc());
			dto.setIdPagoSeguro(sccMxMaeSubProd.getSccMxMaeProducto().getSccMxMaePagoSeguro().getIdPagSegPk());
			dto.setDescPagoSeguro(sccMxMaeSubProd.getSccMxMaeProducto().getSccMxMaePagoSeguro().getDscPagSeg());
			dto.setPlanTabla(sccMxMaeSubProd.getSccMxMaeProducto().getIdPlnTablaAmortiz().toString());
			dto.setIdModalidadFk(
					sccMxMaeSubProd.getSccMxMaeProducto().getSccMxMaeModalidadByIdModalidadFk().getIdModalidadPk());
			dto.setDscModalidad(
					sccMxMaeSubProd.getSccMxMaeProducto().getSccMxMaeModalidadByIdModalidadFk().getDscModalidad());
			dto.setFlgConvAuto(sccMxMaeSubProd.getSccMxMaeProducto().getFlgConvAuto());
			dto.setIdAmortizFK(sccMxMaeSubProd.getSccMxMaeProducto().getIdAmortiz());
			listaSubproductosDto.add(dto);

		}

		return listaSubproductosDto;
	}

	/**
	 * Busca el id del segmento de conversión auto usando el id segmento del cliente
	 * que es el del catàlogo del segmento
	 * 
	 * @param idSegmentoSgto id del segmento del cliente
	 * @return el id del segmento de conversión auto
	 */
	@Override
	@Cacheable(cacheNames = "SegmentoConvAuto")
	public Long buscaIdSegmentoConvAuto(Long idSegmentoSgto) {
		SccMxMaeSegmento vo = daoSegmento.findById(idSegmentoSgto);
		return vo.getSccMxMaeConvauto().getIdConvautoPk();
	}

}
