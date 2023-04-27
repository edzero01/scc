package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class FiData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288464315443279778L;

	private String branchIdent;
	
    private String fiIdent;

	public String getBranchIdent() {
		return branchIdent;
	}

	public void setBranchIdent(String branchIdent) {
		this.branchIdent = branchIdent;
	}

	public String getFiIdent() {
		return fiIdent;
	}

	public void setFiIdent(String fiIdent) {
		this.fiIdent = fiIdent;
	}
}
