package mx.isban.scc.model.pb53;

public class PrestamoNominaRequest {
	
	private String rqUID;
	
	private AmortizationSel amortizationSel;

	public String getRqUID() {
		return rqUID;
	}

	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}

	public AmortizationSel getAmortizationSel() {
		return amortizationSel;
	}

	public void setAmortizationSel(AmortizationSel amortizationSel) {
		this.amortizationSel = amortizationSel;
	}
}
