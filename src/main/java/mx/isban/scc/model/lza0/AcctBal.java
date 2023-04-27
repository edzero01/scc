package mx.isban.scc.model.lza0;

import java.io.Serializable;
import java.util.Date;

public class AcctBal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3196706447420612013L;

	private CurAmt curAmt;
	
	private Date lastOcurranceDt;
	
	private BalType balType;

	public CurAmt getCurAmt() {
		return curAmt;
	}

	public void setCurAmt(CurAmt curAmt) {
		this.curAmt = curAmt;
	}

	public Date getLastOcurranceDt() {
		return lastOcurranceDt;
	}

	public void setLastOcurranceDt(Date lastOcurranceDt) {
		this.lastOcurranceDt = lastOcurranceDt;
	}

	public BalType getBalType() {
		return balType;
	}

	public void setBalType(BalType balType) {
		this.balType = balType;
	}
}
