package mx.isban.scc.simulador.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.SccMxPlantillaCPagoNAdeudosDTO;
import mx.isban.scc.model.dto.SccMxPlantillaDescDTO;
import mx.isban.scc.service.IPlantillaCartaPagoService;
import mx.isban.scc.service.IPlantillaCertificadoDescService;
import mx.isban.scc.service.IPlantillasService;
import mx.isban.scc.utilerias.JsonParserUtil;
import mx.isban.scc.utilerias.plantillas.ConPDF;

/**
 * Controlador para obtener 
 * todas las plantillas del Sprint 2:
 * 
 * NOMBRE DE PLANTILLA    CODIGO DE PLANTILLA (DOS LETRAS)
 * Carta compromiso  CC
 * Certificado de descuentos CD
 * Manifestacion de adeudo  NA O MF
 * Tabla de amortizacion TA
 * Mandatorio  MA
 * 
 * 
 * 
 * @author Octavio Cruz
 * Esa era la configuracion original para las plantillas. Por temas de SANTEC
 * se reestructuraron y ya no van por ftp, sino que se leen de la base de datos
 * El usuario las carga con la interfaz de plantillas e indica un ID
 * ese ID es la llave especifica para cada plantilla, pero el TIPO de plantilla
 * sirve para identificar de qué tipo de plantilla estamos hablando
 * Por ejemplo:
 * puede haber un Certificado de Descuento ID 1 , y una Carta Compromiso ID 1
 * Pero la llave combinada traee un 2 (cd) + 1 (id) para el Certificado y un 1-1 para la carta
 * compromiso
 * En esta clase se descargan las plantillas de acuerdo al tipo y ID de plantilla
 * indicados desde front end
 * @author Gabriel Dolores,  Lorena Baruch
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class PlantillasFileSystemRestController {
	
	/**
	 * Variable Global para obtener la implemantacion del service:
	 *  IPlantillasService
	 */
	@Autowired
	private IPlantillasService plantillasService;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private IPlantillaCertificadoDescService negocioService;
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private IPlantillaCartaPagoService cartaPago;
	
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias para parsear JSON
	 */
	@Autowired
	private JsonParserUtil parse;
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CatalogosRestController.class);


	/**
	 * Constante de clase, con u solo espacio de memoria e inmutable con finalidad
	 * de definicion del mensaje dne Exito
	 */
	private static final String EXITO = "Tabla y documento creados con exito";
	
	/**
	 * constante para definir mensaje de fallo
	 */
	private static final String FALLO = "No se logro generar la plantilla";
	
	
	/**
	 * Metodo para regresar las tablas de amortizacion
	 * Regresa un ByteArrayOutputStream
	 * 
	 * @param sCertDesc datos recibidos de front
	 * Contienen la informacion requerida para realizar 
	 * la busqueda y llenado del documento de plantilla 
	 * indicado de certificado de descuento
	 * @return ResponseEntity(SimpleResponse) path para plantilla descarga
	 * @exception DataAccessException error acceso de datos
	 */
	@GetMapping("/certificados_descuento/{sCertDesc}")
	public ResponseEntity<SimpleResponse> descuentoCertificados(@PathVariable String sCertDesc) {
		SimpleResponse sr2 = new SimpleResponse();

		SccMxPlantillaDescDTO certDesc = null;
		try {
			certDesc = parse.fromJSON(sCertDesc, SccMxPlantillaDescDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr2.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


		ByteArrayOutputStream path2 = null;

		try {
		
			ByteArrayOutputStream pathO2 = plantillasService.obtenerPlantillaCertDescSftp(certDesc.getPlantilla().toString());
			path2 = negocioService.obtenPlantillaCD1(certDesc, pathO2);
			
			ConPDF conPdf = new ConPDF();
			path2 = conPdf.convertToPDF(path2);
			if (path2 == null) {
				sr2.setError(FALLO);
			} else {
				sr2.setResult(path2.toByteArray());
				sr2.setMessage(EXITO);
			}
		} catch (DataAccessException e2) {
			LOGGER.error(e2.getMessage(), e2);
			sr2.setError(e2.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if( path2 != null) {
					path2.close();
				}
			} catch (IOException e21) {
				LOGGER.error(e21.getMessage(), e21);
			}
		}
		
		return new ResponseEntity<>(sr2, HttpStatus.OK);
	}
	
	/**
	 * Metodo para regresar las tablas de compromiso de pago
	 * Regresa un ByteArrayOutputStream	 * 
	 * 
	 * @param scompPago datos recibidos de front
	 * Contienen la informacion requerida para realizar 
	 * la busqueda y llenado del documento de plantilla 
	 * indicado de certificado de descuento
	 * @return ResponseEntity(SimpleResponse) path para plantilla descarga
	 * @exception DataAccessException error acceso de datos
	 */
	@GetMapping("/compromiso_pagos/{scompPago}")
	public ResponseEntity<SimpleResponse> pagoCompromisos(@PathVariable String scompPago) {
		SimpleResponse sr3 = new SimpleResponse();

		SccMxPlantillaCPagoNAdeudosDTO compPago;
		try {
			compPago = parse.fromJSON(scompPago, SccMxPlantillaCPagoNAdeudosDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr3.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		ByteArrayOutputStream path3 = null;

		try {
		
			ByteArrayOutputStream pathO3 = plantillasService.obtenerPlantillaComPagoSftp(Integer.parseInt(compPago.getPlantilla()));
			path3 = cartaPago.obtenPlantillaCP(compPago, pathO3);
			
			ConPDF conPdf = new ConPDF();
			path3 = conPdf.convertToPDF(path3);
			if (path3 == null) {
				sr3.setError(FALLO);
			} else {
				sr3.setResult(path3.toByteArray());
				sr3.setMessage(EXITO);
			}
		} catch (DataAccessException e3) {
			LOGGER.error(e3.getMessage(), e3);
			sr3.setError(e3.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if( path3 != null) {
					path3.close();
				}
			} catch (IOException e31) {
				LOGGER.error(e31.getMessage(), e31);
			}
		}
		
		return new ResponseEntity<>(sr3, HttpStatus.OK);
	}
	

	/**
	 * Metodo para regresar los certificados de no adeudo
	 * Regresa un ByteArrayOutputStream	
	 * 
	 * @param sNoAdeudo datos recibidos de front
	 * Contienen la informacion requerida para realizar 
	 * la busqueda y llenado del documento de plantilla 
	 * indicado de certificado de descuento
	 * @return ResponseEntity(SimpleResponse) path para plantilla descarga
	 * @exception DataAccessException error acceso de datos
	 */
	@GetMapping("/no_adeudos/{sNoAdeudo}")
	public ResponseEntity<SimpleResponse> noAdeudoCertificados(@PathVariable String sNoAdeudo) {
		SimpleResponse sr4 = new SimpleResponse();
		
		SccMxPlantillaCPagoNAdeudosDTO noAdeudo;
		try {
			noAdeudo = parse.fromJSON(sNoAdeudo, SccMxPlantillaCPagoNAdeudosDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr4.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


		ByteArrayOutputStream path4 = null;

		try {

			ByteArrayOutputStream pathO4 = plantillasService.obtenerPlantillaNoAdeudSftp(noAdeudo.getPlantilla().toString());
			path4 = cartaPago.obtenPlantillaNA(noAdeudo, pathO4);
			
			ConPDF conPdf = new ConPDF();
			path4 = conPdf.convertToPDF(path4);
			if (path4 == null) {
				sr4.setError(FALLO);
			} else {
			sr4.setResult(path4.toByteArray());
			sr4.setMessage(EXITO);
			}
		} catch (DataAccessException e4) {
			LOGGER.error(e4.getMessage(), e4);
			sr4.setError(e4.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if( path4 != null) {
					path4.close();
				}
			} catch (IOException e41) {
				LOGGER.error(e41.getMessage(), e41);
			}
		}
		
		return new ResponseEntity<>(sr4, HttpStatus.OK);
	}
	
}
