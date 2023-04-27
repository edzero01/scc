package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Clase para transferir los datos de auditoria del sistema
 * 
 * @author Hitss Octavio Cruz Rosas
 *
 */
public class AuditoriaPadreDTO implements Serializable {

	/**
	 * Serial version id para identificar la clase al momento de hacer el marshaling
	 * en los puntos extremos
	 */
	private static final long serialVersionUID = 827146362148517934L;

	/**
	 * Variable tipo String para almacener el nombre del hostname que invoa al
	 * servicio de auditoría
	 */
	private String hostName;

	/**
	 * Variable tipo String para guardar la ip de la terminal del cliente que invoca
	 * al servicio de auditoría
	 */
	protected String ipTermninal;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getIpTermninal() {
		return ipTermninal;
	}

	public void setIpTermninal(String ipTermninal) {
		this.ipTermninal = ipTermninal;
	}

}
