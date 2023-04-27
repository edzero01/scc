package mx.isban.scc.simulador.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.pb53.PrestamoNominaRequest;
import mx.isban.scc.model.pb53.PrestamoNominaResponse;
import mx.isban.scc.service.IPrestamoNominaService;

/**
 * Controlador consumir el servicio PB53 
 * @author Edgar Daniel Garcia Serrano
 *
 * NTT DATA
 * Noviembre 2022
 */

@CrossOrigin(origins = { "http://localhost:4200", 
	     "http://localhost:8080",
	     "http://localhost",
		 //DEV ORIGINAL
		 "https://front-simulador-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		 //DEV ACTUAL
		 "https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
	     "https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		 "https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"
})
@RestController
@RequestMapping("/api/simulador")
public class PrestamoNominaController {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PrestamoNominaController.class);
	
	@Autowired
	private IPrestamoNominaService prestamoService;

	@PostMapping(value="/prestamo-nomina/offers/{idProducto}/{idSubproducto}/cuotas")
	public ResponseEntity<SimpleResponse> prestamoNomina(@PathVariable long idProducto,
			@PathVariable long idSubproducto, @RequestBody PrestamoNominaRequest request){
		
		SimpleResponse sr = new SimpleResponse();
		
		try {
			PrestamoNominaResponse serviceResponse = prestamoService.createPrestamoNomina(idProducto, idSubproducto, request);
			
			if(serviceResponse.getStatus().getSeverity().equals("ERROR")) {
				sr.setMessage(serviceResponse.getStatus().getStatusDesc());
				sr.setStatusCode(0);
				sr.setResult("");
				return new ResponseEntity<>(sr, HttpStatus.BAD_REQUEST);
			}else {
				sr.setResult(serviceResponse);
				return new ResponseEntity<>(sr, HttpStatus.OK);
			}
		}catch(ObjectNotFoundException e) {
			sr.setMessage(e.getMessage());
			return new ResponseEntity<>(sr, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
