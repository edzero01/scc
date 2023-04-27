package mx.isban.scc.model.pb53;

import java.io.Serializable;

public class PrestamoNominaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252148776962442804L;

	private String rqUID;
	
	private AmortizationRec amortizationRec;
	
	private Status status;

	public String getRqUID() {
		return rqUID;
	}

	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}

	public AmortizationRec getAmortizationRec() {
		return amortizationRec;
	}

	public void setAmortizationRec(AmortizationRec amortizationRec) {
		this.amortizationRec = amortizationRec;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
