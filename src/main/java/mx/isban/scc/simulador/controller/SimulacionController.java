package mx.isban.scc.simulador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.isban.scc.model.SccMxMaeSimuladorDroJpa;
import mx.isban.scc.service.ISimulacionService;

/**
 * RestController de Simulaciones Se usa para guardar las simulaciones
 * 
 * @author Global Hitss Sprint 6 Noviembre 2019
 * 
 *         Servicio para guardar simulacion:
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class SimulacionController {
	/**
	 * Variable para acceder a los servicios guardar simulacion
	 */
	@Autowired
	private ISimulacionService simulacionService;

	/**
	 * Guarda simulación
	 * 
	 * @param sccMxMaeSimuladorDro Clase SccMxMaeSimuladorDroJpa Objeto de datos de
	 *                             la simulación como parámetro de entrada
	 * @param httpSession          La sesión HTTP inyectada por Spring para la
	 *                             obtención del id de sesión que se guardará en
	 *                             pistas de auditoría
	 * @param request HttpServletRequest Para obtener la ip y el nombre completo del host remoto                            
	 * @return SccMxMaeSimuladorDroJpa Objeto de datos de la simulación como
	 *         parámetro de salida
	 */
	@PostMapping("/simulaciones")
	public SccMxMaeSimuladorDroJpa newSimuladorDro(@RequestBody SccMxMaeSimuladorDroJpa sccMxMaeSimuladorDro,
			HttpSession httpSession, HttpServletRequest request) {
		return simulacionService.save(sccMxMaeSimuladorDro, httpSession.getId(), request.getRemoteAddr(),
				request.getRemoteHost());
	}

}
