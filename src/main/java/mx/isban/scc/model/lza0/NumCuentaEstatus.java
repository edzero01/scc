package mx.isban.scc.model.lza0;

import java.io.Serializable;
import java.util.List;

public class NumCuentaEstatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666157026743037737L;

	private Long statusCode;
	
	private String serverStatusCode;
	
	private String severity;
	
	private String statusDesc;
	
	private List<EstatusAdicional> additionalStatus;

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}

	public String getServerStatusCode() {
		return serverStatusCode;
	}

	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public List<EstatusAdicional> getAdditionalStatus() {
		return additionalStatus;
	}

	public void setAdditionalStatus(List<EstatusAdicional> additionalStatus) {
		this.additionalStatus = additionalStatus;
	}
}
