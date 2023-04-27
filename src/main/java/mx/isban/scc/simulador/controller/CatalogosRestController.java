package mx.isban.scc.simulador.controller;

import java.util.ArrayList;

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
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;
import mx.isban.scc.model.dto.SccMxMaeConvautoDTO;
import mx.isban.scc.model.dto.SccMxMaeProductoSubProductDTO;
import mx.isban.scc.model.dto.SccMxPeriodoPorIdProdDTO;
import mx.isban.scc.model.dto.WrapperServiciosDTO;
import mx.isban.scc.service.ICatalogosFondoGarantService;
import mx.isban.scc.service.ICatalogosService;
import mx.isban.scc.service.ICatalogosSimService;
import mx.isban.scc.service.ICondFinService;
import mx.isban.scc.service.IConvAutoService;
import mx.isban.scc.service.IOfertaPromocionalService;
import mx.isban.scc.service.ITasaTiieService;

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
public class CatalogosRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CatalogosRestController.class);
	
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ICatalogosSimService catSimService;
	
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ICatalogosService catsService;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private IConvAutoService catsServiceConvAuto;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ICondFinService catsServiceCondFin;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private IOfertaPromocionalService catsServiceOferProm;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ICatalogosFondoGarantService catsServiceFondGarant;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ITasaTiieService catsServiceTasaTiie;

	/**
	 * Método para buscar todos los catalogos individules: Tipo de producto Catalogo
	 * de segmento Catalogo de motivos de rechazo
	 * 
	 * @author GlobalHitss
	 * @return lista de catalogos como simple response: Lista de tipo de producto
	 *         Lista de Catalogo de Segmento Lista de Catalogo de motivos de rechazo
	 */

	@GetMapping("/catalogos")
	public ResponseEntity<SimpleResponse> catalogos() {

		SimpleResponse sr = new SimpleResponse();
		try {
			sr.setResult(catSimService.findAllCatalogos());
		} catch (DataAccessException dae) {
			LOGGER.error(dae.getMessage(), dae);
			sr.setError(dae.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException onfex) { // Excepcion creada para detectar cuando no se encuentra un objeto por
													// id
			LOGGER.error(onfex.getMessage(), onfex);
			sr.setError(onfex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Método para buscar todos los catalogos individules: Tipo de producto Catalogo
	 * de segmento Catalogo de motivos de rechazo
	 * 
	 * @param modalidad
	 * 1 si es Campaña, 2 si es Mercado Abierto. El query lo resuelve
	 * @return lista de catalogos como simple response: Lista de tipo de producto 
	 * 			considerando la modalidad
	 *         Lista de Catalogo de Segmento Lista de Catalogo de motivos de rechazo
	 */
	@GetMapping("/catalogos/{modalidad}")
	public ResponseEntity<SimpleResponse> catalogosSimulador(@PathVariable Integer modalidad) {

		SimpleResponse srM = new SimpleResponse();
		try {
			srM.setResult(catSimService.findAllCatalogos(modalidad));
		} catch (DataAccessException daeM) {
			LOGGER.error(daeM.getMessage(), daeM);
			srM.setError(daeM.getMessage());
			return new ResponseEntity<>(srM, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException onfexM) { 
		// Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(onfexM.getMessage(), onfexM);
			srM.setError(onfexM.getMessage());
			return new ResponseEntity<>(srM, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(srM, HttpStatus.OK);
	}
	
	
	/**
	 * Busca el id del segmento de conversión auto usando el id segmento del cliente
	 * que es el del catàlogo del segmento
	 * 
	 * @param idSegmentoSgto id del segmento del cliente
	 * @return SimpleResponse con el id del segmento de conversión auto
	 */
	@GetMapping("/segmentos_conv_auto/{idSegmentoSgto}")
	public ResponseEntity<SimpleResponse> convAutoSegmentos(@PathVariable Long idSegmentoSgto) {
		SimpleResponse sr = new SimpleResponse();
		Long elId = catsService.buscaIdSegmentoConvAuto(idSegmentoSgto);
		sr.setResult(elId);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Método para buscar los productos y subproductos por el tipo de producto
	 * Propiedades combinadas en un solo objeto SccMxMaeProductoSubProductDTO:
	 * Catalogos de producto Catalogos de subproducto
	 * 
	 * @author GlobalHitss
	 * @param id          id del tipo de producto
	 * @param idModalidad modalidad
	 * @return ResponseEntity como simpleresponse body de un objeto
	 *         SccMxMaeProductoSubProductDTO: propiedades de producto y subproducto
	 */
	@GetMapping("/subproductos/productos/{id}/{idModalidad}")
	public ResponseEntity<SimpleResponse> subProductos(@PathVariable Long id, @PathVariable Long idModalidad) {

		ArrayList<SccMxMaeProductoSubProductDTO> subProds = new ArrayList<>();
		ArrayList<SccMxPeriodoPorIdProdDTO> periodicidades = new ArrayList<>();
		SimpleResponse sr = new SimpleResponse();
		try {
			subProds = new ArrayList<>(catsService.buscaSubProdByIdProd(id, idModalidad));
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		WrapperServiciosDTO wrapper = new WrapperServiciosDTO();
		wrapper.setSubProds(subProds);
		wrapper.setPeriodicidades(periodicidades);

		sr.setResult(wrapper);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Método para buscar las condiciones financieras por clave de producto y las
	 * periodicidades por id del producto Se agregan propiedades al objeto
	 * WrapperServiciosDTO: Lista de catalogo de condiciones financieras Lista de
	 * Catalogo de periodicidades
	 * 
	 * @author GlobalHitss
	 * @param id     id del subproducto
	 * @param idProd id del producto
	 * @return Lista de codigo de producto-subproducto como simpleresponse body
	 *         retorna objeto WrapperServiciosDTO: List de condiciones financieras
	 *         List de periodicidades
	 */
	@GetMapping("/condiciones_financieras/{id}_{idProd}")
	public ResponseEntity<SimpleResponse> subProdCondiciones(@PathVariable Long id, @PathVariable Long idProd) {

		SimpleResponse sr = new SimpleResponse();

		ArrayList<SccMxMaeCondFinanDTO> datosCondFin = new ArrayList<>();

		ArrayList<SccMxPeriodoPorIdProdDTO> listaPeriodicidad = new ArrayList<>();

		try {
			datosCondFin = new ArrayList<>(catsServiceCondFin.buscaCondicionPorIdSubProd(id));
			listaPeriodicidad = new ArrayList<>(catsService.buscaPeriodicidadPorIdProd(idProd));
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		WrapperServiciosDTO wrapperConfFinan = new WrapperServiciosDTO();
		wrapperConfFinan.setPeriodicidades(listaPeriodicidad);
		wrapperConfFinan.setDatosCondFin(datosCondFin);
		sr.setResult(wrapperConfFinan);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Método para buscar las condiciones financieras por tasa, plazo y periodo
	 * 
	 * @author Alexis Cedillo
	 * @param idTasa   tasa
	 * @param idPlazo  plazo
	 * @param id       id
	 * @param idPeriod periodo Id del SubProducto.
	 * @return Lista de codigo de producto-subproducto como simpleresponse body
	 *         retorna objeto WrapperServiciosDTO: List de condiciones financieras
	 * 
	 */
	@GetMapping("/condiciones_financieras/{id}/{idTasa}/{idPlazo}/{idPeriod}")
	public ResponseEntity<SimpleResponse> tppCondiciones(@PathVariable Long id, @PathVariable Double idTasa,
			@PathVariable Long idPlazo, @PathVariable Long idPeriod) {

		SimpleResponse sr = new SimpleResponse();
		ArrayList<SccMxMaeCondFinanDTO> listaCondFin = new ArrayList<>();

		try {
			listaCondFin = new ArrayList<>(catsServiceCondFin.buscaCondTPP(id, idTasa, idPlazo, idPeriod));
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		WrapperServiciosDTO wrapper = new WrapperServiciosDTO();
		wrapper.setDatosCondFin(listaCondFin);
		sr.setResult(wrapper);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Metodo para consultar la tasa de conversión auto por ID de segmento
	 * 
	 * @param id Es el ID de segmento
	 * @return Double Debe regresar el porcentaje de la tasa
	 */
	@GetMapping("/tasas_conv_auto/{id}")
	public ResponseEntity<SimpleResponse> convAutoTasas(@PathVariable Long id) {
		SimpleResponse sr = new SimpleResponse();
		SccMxMaeConvautoDTO conversionDto = null;

		try {

			conversionDto = catsServiceConvAuto.buscaConvAutoPorSegmento(id);
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		sr.setResult(conversionDto);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}



	/**
	 * Metodo para obtener la tasa de oferta promocional
	 * 
	 * @param idModalidad Recibe como parametro ma o camp
	 * @param idSubProd   Id de subproducto
	 * @param buc         buc cliente
	 * @param tipoPerfilSeleccionado tipoPerfilSeleccionado
	 * @return Double Debe retornar el valor de la tasa
	 */
	@GetMapping("/ofertas_promocionales/{idModalidad}/{buc}/{idSubProd}/{tipoPerfilSeleccionado}")
	public ResponseEntity<SimpleResponse> ofertaPromocionalTasas(@PathVariable Long idModalidad, @PathVariable Long buc,
			@PathVariable String idSubProd, @PathVariable Long tipoPerfilSeleccionado) {
		SimpleResponse sr = new SimpleResponse();
		String objetoOferta = catsServiceOferProm.buscaOfertaPromocional(idModalidad, idSubProd, buc, tipoPerfilSeleccionado);
		if (objetoOferta == null) {
			sr.setError("No se encuentran ofertas promocionales");
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		sr.setResult(objetoOferta);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Metodo para consultar los fondos de garantia este no recibe parametros y se
	 * obtiene toda la informacion de la tabla correspondiente
	 * 
	 * @return lista de fondos de garantia
	 */
	@GetMapping("/fondos_garantia")
	public ResponseEntity<SimpleResponse> garantiaFondos() {
		SimpleResponse sr = new SimpleResponse();
		try {
			sr.setResult( new ArrayList<>(catsServiceFondGarant.buscaFondosGarantia()));
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) { // Excepcion creada para detectar cuando no se encuentra un objeto por id
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Metodo para obtener la ultima tasa tiie No recibe parametros y devuelve el
	 * dato en formato double de la ultima tasa tiie
	 * 
	 * @return Double Debe retornar el valor de la tasa TIIE
	 */
	@GetMapping("/tasas_tiie")
	public ResponseEntity<SimpleResponse> tiieTasas() {
		SimpleResponse sr = new SimpleResponse();
		Double porTasa = catsServiceTasaTiie.obtenTasaTiie();

		if (porTasa == null) {
			sr.setError("No se pudo obtener la ultima tasa TIIE");
			return new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		sr.setResult(porTasa);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

}
