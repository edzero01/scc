package mx.isban.scc.model.lza0;

import java.io.Serializable;
import java.util.List;

public class NumCuentaResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8840632774701281962L;

	private String rqUID;
	
	private NumCuentaEstatus status;
	
	private List<AcctRec> acctRec;
	
	private RecCtrlOut recCtrlOut;

	public String getRqUID() {
		return rqUID;
	}

	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}

	public NumCuentaEstatus getStatus() {
		return status;
	}

	public void setStatus(NumCuentaEstatus status) {
		this.status = status;
	}

	public List<AcctRec> getAcctRec() {
		return acctRec;
	}

	public void setAcctRec(List<AcctRec> acctRec) {
		this.acctRec = acctRec;
	}

	public RecCtrlOut getRecCtrlOut() {
		return recCtrlOut;
	}

	public void setRecCtrlOut(RecCtrlOut recCtrlOut) {
		this.recCtrlOut = recCtrlOut;
	}
}