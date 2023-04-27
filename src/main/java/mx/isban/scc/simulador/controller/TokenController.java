package mx.isban.scc.simulador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.service.ITokenService;
import mx.isban.scc.utilerias.TokenData;

/**
 * Controlador para los 3 servicios REST de funcionalidad de tokens:
 * 1) SAL (validación de Token)  
 * 2) Mantenimiento de Sesion
 * 3) ResolverServices GetLocationFromCorpID
 * 
 * *) appId = "INTRAMX-APPEB-SSO_SIMCREDCONS";
 * 
 * En una primera version esta clase se conectara a mock services
 * En la version definitiva se conectara a los servicios de la intranet de Santander
 * 
 * @author GlobalHitss Octubre 2019
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class TokenController {
	
	public static final String ERROR_FALTA_TOKEN = "Falta el token";

	/**
	 *Interfase para los servicios de token
	 */
	@Autowired
	private ITokenService tokenService;
	
	/**
	 * Método que valida si el token es valido
	 * 
	 * @param tokenData TokenData
	 * @return ResponseEntity(SimpleResponse) con los valores obtenidos de la validación
	 */
	@PostMapping("tokens/sal")
	public ResponseEntity<SimpleResponse> validarToken(@RequestBody TokenData tokenData) {
		SimpleResponse sr = new SimpleResponse();
		String token = tokenData.getToken();
		if ("".equals(token.trim())) {
			sr.setError(TokenController.ERROR_FALTA_TOKEN);
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		TokenData retVal = tokenService.isValid(tokenData);
		sr.setResult(retVal);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	/**
	 * Método que sirve para renovar la vida útil del token
	 * @param tokenData TokenData
	 * @return ResponseEntity(SimpleResponse) con los valores obtenidos de la renovación
	 */
	@PostMapping("tokens/renovaciones")
	public ResponseEntity<SimpleResponse> renovarToken(@RequestBody TokenData tokenData) {
		SimpleResponse sr = new SimpleResponse();
		String token = tokenData.getToken();
		if ("".equals(token.trim())) {
			sr.setError(TokenController.ERROR_FALTA_TOKEN);
			return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
		}
		TokenData retVal = tokenService.extendTokenLife(tokenData);
		sr.setResult(retVal);

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	/**
	 * Método que sirve para obtener el centro de costos
	 * @param tokenData TokenData
	 * Contiene el token en modo string
	 * @return ResponseEntity(SimpleResponse) 
	 * con los valores obtenidos de la renovación
	 */
	@PostMapping("tokens/centros_costos")
	public ResponseEntity<SimpleResponse> centroDeCostos(@RequestBody TokenData tokenData) {
		SimpleResponse sr = new SimpleResponse();
		String token = tokenData.getToken();
		if ("".equals(token.trim())) {
			sr.setError(TokenController.ERROR_FALTA_TOKEN);
			return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
		}
		
		TokenData retVal = tokenService.costCenter(tokenData);
		sr.setResult(retVal);
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

}
