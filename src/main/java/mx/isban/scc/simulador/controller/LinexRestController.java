package mx.isban.scc.simulador.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.SccMxLinexCondFinanAuxDTO;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;
import mx.isban.scc.model.dto.WrapperServiciosDTO;
import mx.isban.scc.service.ILinexService;

/**
 * Controlador para todas las consultas a catálogos de Sprint 1:
 * 
 * @author GlobalHitss Tipo de producto Lista de Subproductos Lista de Tasas de
 *         Condiciones Financieras Lista de Periodicidades por producto y
 *         subproducto Lista de Segmentos Lista de motivos de rechazo
 * 
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})

@RestController
@RequestMapping("/api/simulador")
public class LinexRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LinexRestController.class);
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ILinexService linexService;
	
	/**
	 * Método para buscar tasa base para productos linez
	 * 
	 * @author Christopher Espina
	 * @param idProd
	 * id producto
	 * @param idSubProd
	 * id sub producto
	 * @param lapa
	 * numero de lapa
	 * @param plazo
	 * plazo
	 * @return tasa interes base
	 */

	@GetMapping("/ofertas_prom_linex/{idProd}_{idSubProd}_{lapa}_{plazo}")
	public ResponseEntity<SimpleResponse> tasasBase(@PathVariable Long idProd, @PathVariable Long idSubProd
			,  @PathVariable Long lapa, @PathVariable Long plazo) {
		SimpleResponse sr = new SimpleResponse();
		try {
			
			SccMxMaeCondFinanDTO result = linexService.obtenCondicionesFinancieras(idProd, idSubProd, lapa, plazo);
			sr.setResult(result);
		} catch (DataAccessException e) {
			LOGGER.error("Ocurrio una incidencia al consultar cond financ:"+e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error("Ocurrio una incidencia al consultar condiciones financieras:"+ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
	/**
	 * Método para buscar las condiciones financieras
	 * de  LINEX por id de producto
	 * id del subproducto, id del cliente
	 * Con estos datos obtenemos la LAPA 
	 * correspondiente en ofertas promocionales
	 * y se busca la informacion en condiciones
	 * financieras
	 * 
	 * @author Ivan Cruz
	 * @param idProd   Recibe el id del Producto(no id de tipo de producto)
	 * @param idSubProd  Recibe el id del SubProducto
	 * @param idBucCte   Recibe el BUC Cte para buscar sus cond finac y lapa correspondiente
	 * @return Lista de condiciones financieras plus el monto para LinEx
	 * 
	 */
	@GetMapping("/condiciones_financieras_linex/{idProd}/{idSubProd}/{idBucCte}")
	public ResponseEntity<SimpleResponse> tppLinexCondiciones(@PathVariable Long idProd, @PathVariable Long idSubProd,
			@PathVariable Long idBucCte) {

		SimpleResponse sr = new SimpleResponse();
		WrapperServiciosDTO wrapper = new WrapperServiciosDTO();
		SccMxLinexCondFinanAuxDTO auxDto= null;
		
		try {
			auxDto = linexService.buscaCondTPPLinex(idProd, idSubProd, idBucCte);
			if(auxDto != null && !auxDto.getDtoCondFinLinex().isEmpty() ) {
				
				auxDto.getDtoCondFinLinex().get(0).setCondFinPromoLinex(linexService.buscaCondFinancierasLinexPromocional(idProd, idSubProd, idBucCte));				
				wrapper.setDatosCondFin(auxDto.getDtoCondFin());
				wrapper.setDatosCondFinLinex(auxDto.getDtoCondFinLinex());
						
			}
			
		} catch (DataAccessException e) {
			sr.setError(e.getMessage().concat(": ")
					.concat(e.getMostSpecificCause().getMessage()));
			LOGGER.error("Ocurrio una incidencia al consultar cond financ LINEX:"+e.getMessage(), e);
			return new 
					ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) {
			sr.setError(ex.getMessage());
			LOGGER.error("No se encontro informacion para LINEX: "+ex.getMessage(), ex);
			return new 
					ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		sr.setResult(wrapper);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	
	/**
	 * Método para buscar los datos de conversión auto de  LINEX
	 * Donde recibimos el id del segmento de la tabla de
	 * conversion auto, de la cual obtenemos 
	 * el numero de LAPA para poder buscar
	 * las condiciones financieras correspondientes
	 * a dicho numero
	 * @author Ivan Cruz Azuara
	 * @param idSegmento  Recibe el id del segmento 
	 * @param idPeriodicidad  Recibe el id de la periodicidad a filtrar
	 * @param plazo   Recibe el plazo en numero de dias
	 * @return Lista de condiciones financieras plus el monto para LinEx
	 * 
	 */
	@GetMapping("/creditos_linex_conv_auto/{idSegmento}/{idPeriodicidad}/{plazo}")
	public ResponseEntity<SimpleResponse> convAutoLinex(@PathVariable Long idSegmento, @PathVariable Long idPeriodicidad,
			@PathVariable Long plazo) {

		SimpleResponse srEx = new SimpleResponse();
		WrapperServiciosDTO wrapper = new WrapperServiciosDTO();
		
		try {
			
			wrapper.setConvAutoLinex(linexService.buscaConvAutoLinex(idSegmento, idPeriodicidad, plazo));
				
		} catch (DataAccessException e1) {
			srEx.setError(e1.getMessage().concat(": ")
					.concat(e1.getMostSpecificCause().getMessage()));
			LOGGER.error("Ocurrio una incidencia al consultar convAuto LINEX:"+e1.getMessage(), e1);
			return new 
					ResponseEntity<>(srEx, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex1) {
			srEx.setError(ex1.getMessage());
			LOGGER.error("No se encontro informacion para convAuto LINEX: "+ex1.getMessage(), ex1);
			return new 
					ResponseEntity<>(srEx, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		srEx.setResult(wrapper);

		return new ResponseEntity<>(srEx, HttpStatus.OK);
	}
	

	
}
