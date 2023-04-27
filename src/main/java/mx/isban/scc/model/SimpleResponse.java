package mx.isban.scc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Armado de objeto de respuesta simple para el cliente web
 * @author Hitss
 */
public class SimpleResponse implements Serializable {

	/**
	 * Id de Serialización
	 */
	private static final long serialVersionUID = 852156789104132239L;

	/**
	 * Valor de exito de la petición
	 */
	public static final int OK = 1;
	
	/**
	 * Valor de error de la petición
	 */
	public static final int ERROR = 0;

	@JsonProperty("s")
	/**
	 * Indica si es exitosa o fallida la llamada al servicio
	 */
	private int statusCode = OK;

	@JsonProperty("m")
	/**
	 * Contiene el mensaje de falla 
	 */
	private String message = "";

	@JsonProperty("r")
	/**
	 * Contiene el resultado que se va a leer en front end
	 */
	private Serializable result;

	/**
	 * Regresa el estatus
	 * @return statusCode HTTP Status Code
	 */
	public int getStatusCode() {
		return statusCode;
	}
	
	/**
	 * Almacena el estatus
	 * @param statusCode HTTP Status Code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Regresa el mensaje
	 * @return message Mensaje explicativo del estatus
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Almacena el mensaje
	 * @param message Mensaje explicativo del estatus
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Regresa el resultado
	 * @return result Object para insertar entidades json de respuesta
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Almacena el resultado
	 * @param result para insertar entidades json de respuesta
	 */
	public void setResult(Serializable result) {
		this.result = result;
	}

	/**
	 * Inicializa el mensaje de error
	 * @param msg mensaje de error
	 */
	public void setError(String msg) {
		this.setMessage(msg);
		this.statusCode = ERROR;
	}

}
