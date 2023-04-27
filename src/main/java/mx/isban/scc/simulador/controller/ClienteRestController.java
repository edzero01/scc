package mx.isban.scc.simulador.controller;

import java.util.ArrayList;
import java.util.List;

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
import mx.isban.scc.model.dto.SccMxMaeAppCarteraDTO;
import mx.isban.scc.model.dto.SccMxMaeOferCampMaDTO;
import mx.isban.scc.service.ICarteraService;
import mx.isban.scc.service.IClienteService;

/**
 * RestController de Clientes
 * @author Alexis Cedillo
 * Servicios para procesos relacionados con el cliente santander:
 * servicio para obtener ofertas promociones de campana y mercado abierto:
 * obtener_ofertas_promocionales()
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class ClienteRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CatalogosRestController.class);
	/**
	 * Variable Global para obtener la implementacion del service:
	 *  IClienteService
	 */
	@Autowired
	private IClienteService daoCliente;
	/**
	 * Variable global para manejar los metodos
	 * de cartera
	 */
	@Autowired
	private ICarteraService carteraService;
	
	
	/**
	 * Creación de servicio rest para ofertas promocionales por campaña y mercado abierto
	 * @param  id
	 * id id del bucCliente
	 * @param perfil
	 * Identifica al perfil del cliente para validar las banderas ccs_in, fve, asn, etc de 
	 * la campaña de acuerdo al usuario que consulta
	 * @return ResponseEntity(SimpleResponse) Compuesto de un objeto que recibe 3 listas
	 * Lista ltSccMxMaeOferCam ofertas de campaña
	 * Lista ltSccMxMaeOferPromCam ofertas promocionales de campaña
	 * Lista ltSccMxMaeOferPromMa ofertas promocionales de mercado abierto
	 */
	@GetMapping("/ofertas_promocionales/{id}_{perfil}")
	public ResponseEntity<SimpleResponse> ofertasPromocionales(@PathVariable Long id, @PathVariable Long perfil){
		SimpleResponse sr = new SimpleResponse();
		SccMxMaeOferCampMaDTO objSccMxMaeOferCampMaDTO = null;
		try {
			objSccMxMaeOferCampMaDTO = daoCliente.obtenerOferCamMa(id, perfil);
		}catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) {
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		sr.setResult(objSccMxMaeOferCampMaDTO);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
	/**
	 * Creación de servicio rest para ofertas promocionales por campaña y mercado abierto
	 * @param idCampania identificador unico de la campaña
	 * @param idTasa identificador de la tabla de Tasas para las Ofertas Maximas
	 * @param idProducto identificador unico del producto
	 * @param codPeriod codigo del periodo
	 * @param idPeriodicidad identificador unico de la periodicidad
	 * @param idPagoSeguro identificador unico del pago seguro
	 * @return ResponseEntity(SimpleResponse) comopuesto de un objeto que recibe 3 listas
	 * Lista ltSccMxMaeOferCam ofertas de campaña
	 * Lista ltSccMxMaeOferPromCam ofertas promocionales de campaña
	 * Lista ltSccMxMaeOferPromMa ofertas promocionales de mercado abierto
	 */
	@GetMapping("/ofertas_maximas/{idCampania}/{idTasa}/{idProducto}/{codPeriod}/{idPeriodicidad}/{idPagoSeguro}")
	public ResponseEntity<SimpleResponse> plazoOfertasMaximas(@PathVariable Long idCampania, @PathVariable Long idTasa, @PathVariable Long idProducto, @PathVariable String codPeriod, @PathVariable Long idPeriodicidad, @PathVariable Long idPagoSeguro){
		SimpleResponse sr = new SimpleResponse();
		SccMxMaeOferCampMaDTO objResult = null;
		try {
			objResult = daoCliente.obtenerOferMaxPlazo(idCampania, idTasa, idProducto, codPeriod, idPeriodicidad, idPagoSeguro);
		}catch (DataAccessException ex) {
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr,HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) {
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(sr,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		sr.setResult(objResult);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
	
	/**
	 * Creación de servicio rest para consultar creditos del cliente por id producto
	 * 
	 * @param  idCnte 
	 * identificador  del bucCliente
	 * 
	 * @return ResponseEntity(SimpleResponse) compuesto de un objeto que recibe 1 lista
	 * Lista listCarteraDTO ofertas de campaña
	 * 
	 */
	@GetMapping("/creditos_cartera/{idCnte}")
	public ResponseEntity<SimpleResponse> clienteCreditos(@PathVariable Long idCnte){
		SimpleResponse sr = new SimpleResponse();
		List<SccMxMaeAppCarteraDTO> listCarteraDTO = null;
		try {
			listCarteraDTO = carteraService.buscaCreditosCarteraPorIdClienteIdProd(idCnte);
		}catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) {
			LOGGER.error(ex.getMessage(), ex);
			sr.setError(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		sr.setResult( new ArrayList<>(listCarteraDTO));
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
	

}
