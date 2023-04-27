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
import mx.isban.scc.model.dto.SccMxCatPSGDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaCatDTO;
import mx.isban.scc.service.ICalculoTblAmtzService;
import mx.isban.scc.service.IPlantillasService;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import mx.isban.scc.utilerias.plantillas.ConPDF;

/**
 * 
 * Controlador para ejecutar las consultas que traen la información de tabla de
 * amortizacion Solo ejecuta Plan Frances y Plan Aleman para Sprint 2
 * Controlador para ejecutar las consultas que traen la información de tabla de
 * amortizacion ejecuta Plan Frances
 * 
 * A continuación se presentan los Metodos para generar request para tablas de
 * amortizacion
 * 
 * Así mismo, se convierte la plantilla obtenida a formato pdf en arreglo de
 * bytes para no usar espacio físico en memoria.
 * 
 * /** Metodo para generar request para tablas de amortizacion
 * 
 * @param tablaCat datos recibidos de front
 * @return amortizacion datos de tabla en simpleresponse regresa datos de tabla
 * @exception DataAccessException error acceso de datos
 * @return tabla de amortizacion
 * @throws IOException
 * 
 *                     Metodo para generar request para obtener cat
 * 
 * @author Christopher Espina Riveros
 * @param tablaCat indica plan frances o aleman
 * @return Cat regresa valor de cat
 * @exception DataAccessException error en acceso de datos
 * @return cat
 * 
 *         Global Hitss Mayo 2019
 * 
 *         Sprint2
 * 
 * Actualizacion @author Gerardo Acosta
 * Se modifica para leer la información con JSON objects
 * y poder aprobar el examen de Veracode
 * Octubre 2019
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class TablaAmortizacionRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TablaAmortizacionRestController.class);
	/**
	 * Constante de clase, con u solo espacio de memoria e inmutable con finalidad
	 * de definicion
	 */
	private static final String EXITO = "Tabla y documento creados con exito";
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ICalculoTblAmtzService negocioService;

	/**
	 * Variable global que accede al componente que busca las plantillas por ftp
	 */
	@Autowired
	private IPlantillasService buscaPlatnilla;

	/**
	 * Metodo para generar request para tablas de amortizacion
	 * 
	 * @param jsonString datos recibidos de front Contienen la informacion requerida
	 *                   para calcular la amortizacion y la serie de pagos que el
	 *                   cliente debera realizar
	 * @return amortizacion datos de tabla en simpleresponse regresa datos de tabla
	 * @exception DataAccessException error acceso de datos Las exception ayudaran a
	 *                                detectar cual es el problema al calcular la
	 *                                tabla de amortizacion
	 * @return tabla de amortizacion Esta tabla de amortizacion es la que se
	 *         descargara en Front End considerando si es de Conversion Auto, oferta
	 *         Promocional u Oferta Actual
	 * @throws IOException
	 */
	@GetMapping("/tablas_amortizacion")
	public ResponseEntity<SimpleResponse> getTablaAmortizacion(@RequestParam String jsonString) {
		SimpleResponse sr = new SimpleResponse();

		SccMxTablaCatDTO tablaCat = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			tablaCat = mapper.readValue(jsonString, SccMxTablaCatDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		

		SccMxTablaAmtzInDTO tablaAmtzIn = tablaCat.getTablaCat();
		SccMxUtileriasAmortizacionComplemento utileriasAmortizacion = new SccMxUtileriasAmortizacionComplemento();
		tablaCat.setGracia(utileriasAmortizacion.determinaGracia(tablaCat.getTablaCat().getPeriodicidad(),
				tablaCat.getTablaCat().getPeriodicidadCodigo()));
		String casoPlantilla = tablaCat.getPlan().toString().concat(tablaCat.getRecurrencia())
				.concat(tablaCat.getGracia());

		ByteArrayOutputStream plantillaStream = null;
		ByteArrayOutputStream documentoStream = null;
		try {

			plantillaStream = buscaPlatnilla.obtenerPlantillaTablaAmortiz(tablaCat.getPlantilla().toString());

			switch (casoPlantilla) {
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PAPRCG:
				documentoStream = negocioService.obtenTablaPlanAlemanPRCG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PAPRSG:
				documentoStream = negocioService.obtenTablaPlanAlemanPRSG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PSGPAPUCG:
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PAPUCG:
				documentoStream = negocioService.obtenTablaPlanAlemanPUCG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PSGPAPUSG:
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PAPUSG:
				documentoStream = negocioService.obtenTablaPlanAlemanPUSG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFPRCG:
				documentoStream = negocioService.obtenTablaPlanFrancesPRCG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFPRSG:
				documentoStream = negocioService.obtenTablaPlanFrancesPRSG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFSSCG:
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFPUCG:
				documentoStream = negocioService.obtenTablaPlanFrancesPUCG(tablaAmtzIn, plantillaStream);
				break;
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFSSSG:
			case mx.isban.scc.utilerias.TablaAmortizacionCasosDef.PFPUSG:
				documentoStream = negocioService.obtenTablaPlanFrancesPUSG(tablaAmtzIn, plantillaStream);
				break;
			default:
				break;
			}

			ConPDF conPdf = new ConPDF();

			documentoStream = conPdf.convertToPDF(documentoStream);

			if (documentoStream == null) {
				sr.setError("No se logro generar la tabla");
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



	/**
	 * Metodo para obtener cat de personal select garantía
	 * CAT = Costo Anual total
	 * @author Lorena Baruch
	 * @param jsonString trae toda la información necesaria para calcularlo de
	 *                   acuerdo a lo que Front End está enviando
	 * @return Cat regresa valor de cat
	 */
	@GetMapping("/datos_cat_psg")
	public ResponseEntity<SimpleResponse> getCATPSG(@RequestParam String jsonString) {
		SimpleResponse sr = new SimpleResponse();

		SccMxCatPSGDTO datosCat = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			datosCat = mapper.readValue(jsonString, SccMxCatPSGDTO.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}

		Double cat;
		try {
			cat = negocioService.obtenCatPSG(datosCat);
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cat == null) {
			sr.setError("No se logro generar el CAT");
		} else {
			sr.setResult(cat);
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}



}
