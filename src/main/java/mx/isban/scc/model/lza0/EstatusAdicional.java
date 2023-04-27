package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class EstatusAdicional implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4147767962469978027L;

	private String addStatusCode;
	
	private String addServerStatusCode;
	
	private String addSeverity;
	
	private String addStatusDesc;

	public String getAddStatusCode() {
		return addStatusCode;
	}

	public void setAddStatusCode(String addStatusCode) {
		this.addStatusCode = addStatusCode;
	}

	public String getAddServerStatusCode() {
		return addServerStatusCode;
	}

	public void setAddServerStatusCode(String addServerStatusCode) {
		this.addServerStatusCode = addServerStatusCode;
	}

	public String getAddSeverity() {
		return addSeverity;
	}

	public void setAddSeverity(String addSeverity) {
		this.addSeverity = addSeverity;
	}

	public String getAddStatusDesc() {
		return addStatusDesc;
	}

	public void setAddStatusDesc(String addStatusDesc) {
		this.addStatusDesc = addStatusDesc;
	}
}
