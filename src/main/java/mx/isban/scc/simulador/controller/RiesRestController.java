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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.SccMxTablaCatDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.service.ICalculoMagisterioService;
import mx.isban.scc.service.IPlantillasService;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import mx.isban.scc.utilerias.plantillas.ConPDF;

/**
 * 
 * Controlador para ejecutar las consultas que traen la información de la plantilla Ries139
 * 
 * 
 * @author José Luis Garcia
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class RiesRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RiesRestController.class);
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

	/**
	 * Variable global que accede al componente que busca las plantillas por ftp
	 */
	@Autowired
	private IPlantillasService buscaPlatnilla;

	/**
	 * Metodo para generar request para plantilla Ries139
	 * 
	 * @param jsonString datos recibidos de front Contienen la informacion requerida
	 *                   para calcular llenar la plantilla
	 * @return amortizacion datos de tabla en simpleresponse regresa datos de tabla
	 * @exception DataAccessException error acceso de datos Las exception ayudaran a
	 *                                detectar cual es el problema llenar la plantilla
	 * @throws IOException
	 */
	@GetMapping("/RIES139")
	public ResponseEntity<SimpleResponse> getRIES139(@RequestParam String jsonString) {
		SimpleResponse sr = new SimpleResponse();

		SccMxTablaCatDTO tablaRies = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			tablaRies = mapper.readValue(jsonString, SccMxTablaCatDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		

		SccMxTablaRiesDTO tablaRies139 = tablaRies.getTablaRies();
		SccMxUtileriasAmortizacionComplemento utileriasAmortizacion = new SccMxUtileriasAmortizacionComplemento();
		tablaRies.setGracia(utileriasAmortizacion.determinaGracia(tablaRies.getTablaRies().getPeriodicidad(),
				tablaRies.getTablaRies().getPeriodicidadCodigo()));

		ByteArrayOutputStream plantillaStream = null;
		ByteArrayOutputStream documentoStream = null;
		try {

			plantillaStream = buscaPlatnilla.obtenerPlantillaRies139Sftp(tablaRies.getPlantilla().toString());

			documentoStream = magisterioService.obtenTablaRies(tablaRies139, plantillaStream);

			ConPDF conPdf = new ConPDF();

			documentoStream = conPdf.convertToPDF(documentoStream);

			if (documentoStream == null) {
				sr.setError("No se logro generar el formato");
			} else {
				sr.setResult(documentoStream.toByteArray());
				sr.setMessage(EXITO);
			}

		} catch (DataAccessException e) {
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
