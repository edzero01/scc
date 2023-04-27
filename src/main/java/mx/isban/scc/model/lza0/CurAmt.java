package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class CurAmt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -954487370255267715L;

	private int amt;
	
    private CurCode curCode;

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public CurCode getCurCode() {
		return curCode;
	}

	public void setCurCode(CurCode curCode) {
		this.curCode = curCode;
	}
}
