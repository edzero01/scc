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

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.SccMxVariablesCustomDTO;
import mx.isban.scc.service.IGestionVariablesService;



/**
 * Este controlador nos mandará la 
 * información de la bonificación que aplica
 * cuando hay una restitución y hubo 
 * un pago de prima única de seguro
 * hay dos tipos de bonificaciones: por LINEX y por Consumo
 * La fácil es la de LINEX
 * 
 *
 * @author GlobalHitss
 * Mayo 2019
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class GestionVariablesController {
	
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TablaAmortizacionRestController.class);

	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias 
	 */
	@Autowired
	private IGestionVariablesService variablesService;
	
	/**
	 * Funcion para obtener la variables a gestionar
	 * @param idSubProd
	 * Id de la oferta promocional
	 * @return SimpleResponse
	 * En el simpleresponse van los datos de las variables a gestionar
	 */
	@GetMapping("/variables/{idSubProd}")
	public ResponseEntity<SimpleResponse> variables(@PathVariable Long idSubProd) {
		SimpleResponse sr = new SimpleResponse();
		
		List<SccMxVariablesCustomDTO> variables = new ArrayList<>();
	
		try {
			variables = variablesService.obtenInfoVariables(idSubProd);
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (variables == null) {
			sr.setError("No se localizó información de variables para este subproducto");
			return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
		}

		sr.setResult( new ArrayList<>(variables));
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

}
