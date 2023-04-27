package mx.isban.scc.simulador.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.lza0.NumCuentaResponse;
import mx.isban.scc.service.INumeroCuentaService;

/**
 * Controlador para ejecutar un consulta en el servicio LZA0 y obtiene los
 * numeros de cuenta de un cliente
 * 
 * @author Edgar Daniel Garcia Serrano
 * 
 *         NTT DATA Noviembre 2022
 * 
 */
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost",
		// DEV ORIGINAL
		"https://front-simulador-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		// DEV ACTUAL
		"https://simulador-front-mxsimuladorcredito-dev.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pre.appls.cto1.paas.gsnetcloud.corp",
		"https://front-simulador-mxsimuladorcredito-pro.appls.cto1.paas.gsnetcloud.corp" })
@RestController
@RequestMapping("/api/simulador")
public class NumeroCuentaController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(NumeroCuentaController.class);

	@Autowired
	private INumeroCuentaService numeroCuentaService;

	@GetMapping(value = "/cliente/{id}/cuentas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleResponse> getCurrentAccounts(@PathVariable Long id,
			@RequestParam(required = false) String ownerInd, @RequestParam(required = false) String activeInd,
			@RequestParam(required = false) String subseqRec, @RequestParam(required = false) String cursorValue) {

		SimpleResponse sr = new SimpleResponse();
		String padCuenta = String.format("%08d", id);
		try {
			boolean cursor = false;
			NumCuentaResponse serviceResponse = numeroCuentaService.obtenerNumerosCuenta(padCuenta, ownerInd, activeInd, subseqRec, cursorValue);
			NumCuentaResponse serviceResponseTemp = serviceResponse; 
			cursor = serviceResponse.getRecCtrlOut().isSubseqRec();
			while (cursor) {
				subseqRec = "S";
				cursorValue = serviceResponseTemp.getRecCtrlOut().getCursor().getCursorValue();
				serviceResponseTemp = numeroCuentaService.obtenerNumerosCuenta(padCuenta, ownerInd, activeInd, subseqRec, cursorValue);
				serviceResponse.getAcctRec().addAll(serviceResponseTemp.getAcctRec());
				cursor = serviceResponseTemp.getRecCtrlOut().isSubseqRec();
			}
			if (serviceResponse.getStatus().getSeverity().equals("ERROR")) {
				sr.setMessage(serviceResponse.getStatus().getStatusDesc());
				sr.setStatusCode(0);
				sr.setResult("");
				return new ResponseEntity<>(sr, HttpStatus.BAD_REQUEST);
			} else {
				sr.setResult(serviceResponse);
				return new ResponseEntity<>(sr, HttpStatus.OK);
			}
		} catch (ObjectNotFoundException | JsonProcessingException e) {
			sr.setMessage(e.getMessage());
		}
		return new ResponseEntity<>(sr, HttpStatus.BAD_REQUEST);
	}
}
