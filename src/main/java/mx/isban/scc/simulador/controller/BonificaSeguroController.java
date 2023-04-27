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

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.service.ITblOfMaxService;



/**
 * Este controlador nos mandará la 
 * información de la bonificación que aplica
 * cuando hay una restitución y hubo 
 * un pago de prima única de seguro
 * hay dos tipos de bonificaciones: por LINEX y por Consumo
 * La fácil es la de LINEX
 * Que se calcula en base a una tabla que ya indica
 * los porcentajes por año y por mes.
 * Ejemplo: Se compro un seguro en junio 2019 que vence en junio 2021.
 * Pero se hace restitucion en abril 2020. Entonces, hay un monto ya pagado
 * de junio 2019 a abril 2020, ese se descarta, pero el monto que estaba por cubrirse
 * de abril 2020 a junio 2021 debe descontarse del nuevo monto
 * del nuevo seguro del nuevo credito que va a restituir al que el usuario esta eligiendo
 * para mas detalles del negocio consultar con el usuario
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
public class BonificaSeguroController {
	
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TablaAmortizacionRestController.class);

	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias 
	 */
	@Autowired
	private ITblOfMaxService negocioService;
	
	/**
	 * Funcion para obtener la tasa con el id de la oferta promocional
	 * @param idOf
	 * Id de la oferta promocional
	 * @return SimpleResponse
	 * En el simpleresponse va el porcentaje de la tasa correspondiente a la oferta
	 */
	@GetMapping("/ofertas/{id}/tasas")
	public ResponseEntity<SimpleResponse> ofertaTasas(@PathVariable Long idOf) {
		SimpleResponse sr = new SimpleResponse();
		
		List<SccMxPrcOferMaxTasa> vSccMxPrcOferMaxTasa = null;

		
		try {
			vSccMxPrcOferMaxTasa = negocioService.getTasaporOferta(idOf);
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (vSccMxPrcOferMaxTasa == null) {
			sr.setError("No se localizó ese ID de Oferta");
			return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
		}

		sr.setResult( new ArrayList<>(vSccMxPrcOferMaxTasa));
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
	/**
	 * Funcion para obtener los plazos con el id de la tasa
	 * @param idTasa
	 * Id de la tasa que el usuario eligió en pantalla
	 * @return SimpleResponse
	 * En el simpleresponse va la lista de los plazos de acuerdo a la tasa elegida
	 */
	@GetMapping("/tasas/{id}/plazos")
	public ResponseEntity<SimpleResponse> tasaPlazos(@PathVariable Long idTasa) {
		SimpleResponse sr = new SimpleResponse();
		
		List<SccMxPrcOferMaxPlzo> vSccMxPrcOferMaxPlzo = null;

		
		try {
			vSccMxPrcOferMaxPlzo = negocioService.getPlazosporTasa(idTasa);
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
			sr.setError(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (vSccMxPrcOferMaxPlzo == null) {
			sr.setError("No se localizó ese ID de Tasa");
			return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
		}

		sr.setResult( new ArrayList<>(vSccMxPrcOferMaxPlzo));
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	
	
}
