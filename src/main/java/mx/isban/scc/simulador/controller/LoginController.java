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
import mx.isban.scc.model.dto.LoginParamsDTO;
import mx.isban.scc.service.ILoginService;

/**
 * Controlador para todas las consultas a login 
 * valida si el login ingresado en
 * la pantalla temporal es correcto 
 * se pasan en params Valores con los datos de usaurio y
 * contraseña y regresa un objeto 
 * SimpleResponse con los valores obtenidos de la
 * validación, además tien valores de referencias cruzadas
 * 
 * CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
 * "https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp" })
 * 
 * Esta clase dejara de funcionar cuando se integre la verdadera seguridad
 * junto con los verdaderos perfiles
 * 
 * @author GlobalHitss Julio 2019
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp"})
@RestController
@RequestMapping("/api/simulador")
public class LoginController {

	/**
	 * Variable para acceder a los servicios de login
	 */
	@Autowired
	private ILoginService loginService;

	/**
	 * Método que valida si el login ingresado en la pantalla temporal es correcto
	 * 
	 * @param params Valores con los datos de usaurio y contraseña
	 * @return SImpleResponse con los valores obtenidos de la validación
	 */
	@PostMapping("/accesos_app")
	public ResponseEntity<SimpleResponse> validarLoginTemporal(@RequestBody LoginParamsDTO params) {
		SimpleResponse sr = new SimpleResponse();
		String userName = params.getUserName();
		String pwd = params.getPwd();
		if ("".equals(userName.trim())) {
			sr.setError("Falta el nombre de usaurio");
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		if ("".equals(userName.trim())) {
			sr.setError("Falta la contraseña del usuario");
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
		boolean isAdmin = loginService.isAdministrador(userName, pwd);
		if (isAdmin) {
			sr.setResult("1");
		} else {
			sr.setResult("0");
		}

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
}
