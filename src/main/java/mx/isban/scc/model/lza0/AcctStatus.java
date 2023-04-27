package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class AcctStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807253142098376466L;

	private String acctStatusCode;
	
    private boolean blockedInd;

	public String getAcctStatusCode() {
		return acctStatusCode;
	}

	public void setAcctStatusCode(String acctStatusCode) {
		this.acctStatusCode = acctStatusCode;
	}

	public boolean isBlockedInd() {
		return blockedInd;
	}

	public void setBlockedInd(boolean blockedInd) {
		this.blockedInd = blockedInd;
	}
}
