package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Clase para transferir los datos de auditoria del sistema
 * 
 * @author Hitss Octavio Cruz Rosas
 *
 */
public class AuditoriaDTO extends AuditoriaPadreDTO implements Serializable {

	/**
	 * Serializar de la clase
	 */
	private static final long serialVersionUID = -2713741777777500609L;

	/**
	 * Variable tipo string para guardar el nombre de la aplicacion
	 */
	private String aplicacion;

	/**
	 * Variable tipo String para guardar el nombre del usuario
	 */
	private String usr;
	/**
	 * Variable tipo String para guardar el nombre de la operacion
	 */
	private String operacion;
	/**
	 * Variable tipo String para guardar el nombre de la session
	 */
	private String session;
	/**
	 * Variable tipo String para guardar el token utilizado
	 */
	private String token;

	/**
	 * Variable tipo String para almacenar el motivo que genero la pista
	 */
	private String motivo;
	/**
	 * Variable tipo String para almacenar el nombre de la tabla modificada
	 */
	private String tblAfectada;
	/**
	 * Variable tipo Long para gaurdar el tipo de proceso que genero la pista
	 */
	private Long idTipoProceso;

	/**
	 * Constructor vacia de la clase
	 */
	public AuditoriaDTO() {
		super();
	}

	/**
	 * Regresa el nombre de la aplicacion que genera la pista
	 * 
	 * @return aplicacion
	 */
	public String getAplicacion() {
		return aplicacion;
	}

	/**
	 * Regresa el nombre del usuario
	 * 
	 * @return usr el nombre del usuario
	 */
	public String getUsr() {
		return usr;
	}

	/**
	 * Regresa el nombre de la operacion
	 * 
	 * @return operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * Regresa el nombre de la session
	 * 
	 * @return session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * Regresa en token
	 * 
	 * @return token token de sesión
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Regresa el motivo de la pista
	 * 
	 * @return motivo motivo de la pista de auditoría
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Regresa el nombre de la tabla afectada
	 * 
	 * @return tblAfectada nombre de la tabla afectada
	 */
	public String getTblAfectada() {
		return tblAfectada;
	}

	/**
	 * Inicializa el nombre de la aplicaci_n
	 * 
	 * @param aplicacion nombre de la aplicación
	 */
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * Inicializa el nombre del usuario
	 * 
	 * @param usr el nombre del usuario
	 */
	public void setUsr(String usr) {
		this.usr = usr;
	}

	/**
	 * Inicializa el nombre de la operación
	 * 
	 * @param operacion nombre de la operación
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * Inicializa la session
	 * 
	 * @param session Id de sesión
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * Inicializa el token
	 * 
	 * @param token token de sesión
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Inicializa el motivo
	 * 
	 * @param motivo motivo
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * Inicializa el nombre de la tabla afectada
	 * 
	 * @param tblAfectada nombre de la tabla afectada
	 */
	public void setTblAfectada(String tblAfectada) {
		this.tblAfectada = tblAfectada;
	}

	/**
	 * Deluelve en id del tipo proceso
	 * 
	 * @return idTipoProceso Id del tipo de proceso
	 */
	public Long getIdTipoProceso() {
		return idTipoProceso;
	}

	/**
	 * Inicializa el id del tipo proceso
	 * 
	 * @param idTipoProceso Id del tipo de proceso
	 */
	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}

}
