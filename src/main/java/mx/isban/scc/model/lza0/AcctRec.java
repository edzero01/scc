package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class AcctRec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6385127805243271033L;

	private String acctId;
	
	private AcctInfo acctInfo;
	
	private AcctStatus acctStatus;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public AcctInfo getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(AcctInfo acctInfo) {
		this.acctInfo = acctInfo;
	}

	public AcctStatus getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(AcctStatus acctStatus) {
		this.acctStatus = acctStatus;
	}
}
