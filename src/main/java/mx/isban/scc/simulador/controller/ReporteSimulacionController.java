package mx.isban.scc.simulador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.ReportesDTO;
import mx.isban.scc.model.dto.SccMxMaeSimuladorDroDTO;
import mx.isban.scc.service.ISimuladorReportesService;
/**
 * Controlador para todas las consultas a reportes 
 * de Sprint 4:
 * 
 * @author GlobalHitss Tipo de reportes
 * 
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class ReporteSimulacionController {
	
	/**
	 * Constante de clase , con un solo espacio de memoria 
	 * e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReporteSimulacionController.class);
	
	//Interfaz del servicio
	//ISimuladorReportesService -> SimuladorReportesService
	@Autowired
	private ISimuladorReportesService reportesService;
	
	/**
	 * Método para buscar los reportes de simulación
	 * Filtrandolos por fecha
	 * 
	 * @author Carlos RB
	 * @param sccMxMaeSimuladorDroDTO SccMxMaeSimuladorDroDTO
	 * Estructura DTO con los datos de simulación
	 * @return Lista de reportes
	 * @throws IOException
	 * Error que podria obtenerse
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/simulaciones_reporte")
	public ResponseEntity<SimpleResponse> buscavariablesSubProdApartado(
			@RequestBody SccMxMaeSimuladorDroDTO sccMxMaeSimuladorDroDTO) throws IOException {
		SimpleResponse sr = new SimpleResponse();
		@SuppressWarnings("rawtypes")
		ResponseEntity re;
		
		List<ReportesDTO> ltsReportes = new ArrayList<>();
		
		try {
			//Ejecuta la consulta
			ltsReportes = reportesService.consultaReporte(sccMxMaeSimuladorDroDTO);
			
			if(!ltsReportes.isEmpty()) {
				//Si la consulta regresa elementos, 
				//construye la salida y los agrega a la respuesta
				sr.setResult(reportesService.obtieneCSV(ltsReportes));
				re = new ResponseEntity<>(sr, HttpStatus.OK);			
			}else {
				//Si la consulta no regresa datos, 
				//agrega el error a la respuesta
				sr.setError("No se encontraron registros con los filtros ingresados");
				re = new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (DataAccessException e) {
			//En caso de que falle el acceso a la BD
			//Registra el error en los logs
			LOGGER.error(e.getMessage(), e);
			//Agrega el error a la respuesta
			sr.setError(e.getMessage());
			re = new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ObjectNotFoundException ex) {
			//En caso de que no encuentre el Id buscado
			//Registra el error en los logs
			LOGGER.error(ex.getMessage(), ex);
			//Agrega el error a la respuesta
			sr.setError(ex.getMessage());
			re =  new ResponseEntity<>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Regresa el reporte o el error
		return re;
	}
	

}
