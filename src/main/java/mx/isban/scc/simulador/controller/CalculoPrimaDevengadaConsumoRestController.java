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
import mx.isban.scc.model.dto.SccMxMaePampaDTO;
import mx.isban.scc.service.ICalculoPrimaDevengadaService;
/**
 * Controller para calculo de prima devengada
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class CalculoPrimaDevengadaConsumoRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CatalogosRestController.class);
	/**
	 * Variable para uso de interfaz
	 */
	@Autowired
	private ICalculoPrimaDevengadaService service;
	/**
	 * Cliente para servicio rest de calculo de 
	 * prima devengada consumo
	 * @author Christopher Espina Riveros
	 * @param idCliente
	 * id cliente 
	 * @param credito
	 * credito a sustituir
	 * @param idProducto
	 * id de producto
	 * @return
	 * prima devengada
	 */
	@GetMapping("/montos_devengados_{idCliente}_{credito}_{idProducto}")
	public ResponseEntity<SimpleResponse> consumoPrimas(@PathVariable long idCliente, @PathVariable long credito,
			@PathVariable Long idProducto){
		SimpleResponse sr = new SimpleResponse();
		Double montoDevengadoConsumo = null;
		try {
			montoDevengadoConsumo = service.primaDevengada(idCliente, credito, idProducto);
		}catch (DataAccessException | ObjectNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.OK);
		} 
		if(montoDevengadoConsumo == null) {
			sr.setError("No fue posible calcular la prima devengada consumo");
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		sr.setResult(montoDevengadoConsumo);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	/**
	 * Cliente para servicio rest de calculo de 
	 * prima devengada linex
	 * @author Christopher Espina Riveros
	 * @param idCliente
	 * id cliente 
	 * @param credito
	 * credito a sustituir
	 * @param sucursal
	 * Numero de la sucursal obtenido de campaña
	 * @return
	 * prima devengada
	 * Modificado por Lorena Baruch . Octubre 2019
	 */
	@GetMapping("/creditos_linex/{credito}_{sucursal}")
	public ResponseEntity<SimpleResponse> linexPrimas(@PathVariable long credito, @PathVariable long sucursal){
		SimpleResponse sr = new SimpleResponse();
		SccMxMaePampaDTO envioDatosPampa= new SccMxMaePampaDTO();
		try {
			envioDatosPampa= service.primaDevengadaLinex(credito, sucursal);
			
		}catch (DataAccessException | ObjectNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		if(envioDatosPampa == null) {
			sr.setError("No fue posible calcular la prima devengada linex");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		sr.setResult(envioDatosPampa);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
}
