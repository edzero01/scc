package mx.isban.scc.exception;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.isban.scc.model.SimpleResponse;

/**
 * Clase que maneja los errores para la aplicación. Se encargarán de manejar las
 * excepciones que se hayan detallado en la propia anotación y únicamente para
 * los controladores definidos dentro del paquete mx.isban.scc.controller
 * 
 * Las excepciones se manejdan dentro de cada controlador y aqui únicamente las
 * excepciones no manejadas
 * 
 * @author Global Hitss Junio 2019
 *
 */
@ControllerAdvice
public class SantanderExceptionHandler {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SantanderExceptionHandler.class);

	/**
	 * * Método que maneja los errores para la aplicación. Se encargarán de manejar
	 * las excepciones que se hayan detallado en la propia anotación
	 * 
	 * @param t la excepción generada y no manejdad enel código
	 * @return Un objeto del tipo ResponseEntity(SimpleResponse)
	 */
	@ExceptionHandler({ Exception.class, RuntimeException.class, Error.class })
	public ResponseEntity<SimpleResponse> exceptionHandler(Throwable t) {

		String textoException = StringEscapeUtils.escapeJava(t.getMessage());
		textoException = StringEscapeUtils.escapeHtml4(textoException);
		textoException = StringEscapeUtils.escapeHtml3(textoException);
		textoException = StringEscapeUtils.escapeCsv(textoException);
		textoException = StringEscapeUtils.escapeJson(textoException);
		textoException = StringEscapeUtils.escapeXml10(textoException);
		textoException = StringEscapeUtils.escapeXml11(textoException);
		Exception ex = new Exception(textoException);
		LOGGER.error(textoException, ex);
		SimpleResponse sr = new SimpleResponse();
		sr.setError(
				"Ocurrió un evento inesperado, Intente nuevamente y/o contacte a soporte");
		return new ResponseEntity<SimpleResponse>(sr, HttpStatus.OK);
	}
}
