package mx.isban.scc.model.pb53;

import java.util.List;

public class Status {
	
	private Long statusCode;
	
    private String serverStatusCode;
    
    private String severity;
    
    private String statusDesc;
    
    private List<AdditionalStatus> additionalStatus;

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

	public List<AdditionalStatus> getAdditionalStatus() {
		return additionalStatus;
	}

	public void setAdditionalStatus(List<AdditionalStatus> additionalStatus) {
		this.additionalStatus = additionalStatus;
	}
}
