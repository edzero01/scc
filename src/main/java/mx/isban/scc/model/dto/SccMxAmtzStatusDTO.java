package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion y a su vez
 * para obtener el CAT dado un tipo
 * de plan y el tir
 * 
 * Mayo 2019
 * Global Hitss
 * Sprint 2
 * 
 * @author Christopher Espina Riveros
 *
 */
public class SccMxAmtzStatusDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzStatusDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	/**
	 * propiedad status para statusCode
	 */
	private Long statusCode;
	/**
	 * propiedad status para statusDesc
	 */
	private String statusDesc;
	/**
	 * propiedad status para severity
	 */
	private String severity;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzStatusDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param statusCode
	 * statusCode
	 * @param StatusDesc
	 * StatusDesc
	 * @param severity
	 * severity
	 * 
	 */
	public SccMxAmtzStatusDTO(Long statusCode, String statusDesc, String severity) {
		super();
		this.statusCode =statusCode;
		this.statusDesc=statusDesc;
		this.severity=severity;
	}

	/**
	 * @return statusCode
	 */
	public Long getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 */
	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * @return severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	

		
}
