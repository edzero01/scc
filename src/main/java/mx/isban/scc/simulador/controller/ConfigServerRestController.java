package mx.isban.scc.simulador.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controlador para consultar el config server de desarrollo y obtener las
 * direcciones del simulador y 
 * 
 * @author Gabriel Dolores García
 * Septiembre 15 de 2019
 * 
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class ConfigServerRestController {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ConfigServerRestController.class);
	
	
	/**
	 * Controlador rest para obtener las variables de URL para el simulador,
	 * calculadora, home y calculadora de ingreso
	 * 
	 * @return ResponseEntity(String) con la respuesta  del config server
	 */
	@GetMapping("/config.json")
	public ResponseEntity<String> busaConfig(){
		LOGGER.info("Invocando config server....");
		RestTemplate restCall = new RestTemplate();
		String resp = restCall.getForObject("http://localhost:8888/simulador_dev/default", String.class);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}	
}
