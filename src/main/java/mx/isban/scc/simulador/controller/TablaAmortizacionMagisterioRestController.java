package mx.isban.scc.simulador.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.service.ICalculoMagisterioService;
import mx.isban.scc.service.ICalculoTblAmtzService;
import mx.isban.scc.service.IPlantillasService;
import mx.isban.scc.utilerias.plantillas.ConPDF;

/**
 * 
 * Controlador para llenar la plantilla de tabla amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class TablaAmortizacionMagisterioRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TablaAmortizacionMagisterioRestController.class);
	/**
	 * Constante de clase, con u solo espacio de memoria e inmutable con finalidad
	 * de definicion
	 */
	private static final String EXITO = "Tabla y documento creados con exito";
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */

	@Autowired
	private ICalculoMagisterioService magisterioService;
	
	@Autowired
	private ConPDF convertPdf;

	/**
	 * Variable global que accede al componente que busca las plantillas por ftp
	 */
	@Autowired
	private IPlantillasService buscaPlatnilla;



	/**
	 * Operation: Operation: create, Method: POST Tabla Amortizacion Magisterio.
	 * 
	 * @param body Cuerpo de la peticion con la informacion del regsitro
	 * @return Ojeto con el cuerpo de respuesta
	 */
	@PostMapping(value = "/tabla_amortizacion_magisterio")
	public ResponseEntity<SimpleResponse> getTablaAmtzMagisterio(@RequestHeader Map<String, String> headers,
			@RequestBody SccMxTablaMagisterioDTO body) {

		SimpleResponse sr = new SimpleResponse();
		String plan = body.getPlan().toString();
		ByteArrayOutputStream plantillaStream = null;
		ByteArrayOutputStream documentoStream = null;

		try {
			
			plantillaStream = buscaPlatnilla.obtenerPlantillaTablaAmortiz(body.getPlantilla());
			// Invocar al servicio
			if (plan.equals("3")) {
				
				documentoStream = magisterioService.obtenTablaPlanMagisterio(body, plantillaStream);
			}


			documentoStream = convertPdf.convertToPDF(documentoStream);

			if (documentoStream == null) {
				sr.setError("No se logro generar la tabla");
			} else {
				sr.setResult(documentoStream.toByteArray());
				sr.setMessage(EXITO);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (documentoStream != null) {
					documentoStream.close();
				}
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);

	}



}
