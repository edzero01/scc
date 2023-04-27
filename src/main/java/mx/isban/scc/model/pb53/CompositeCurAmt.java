package mx.isban.scc.model.pb53;

public class CompositeCurAmt {
	
	private String compositeCurAmtType;
	
	private CurrentAmt curAmt;
	
	public String getCompositeCurAmtType() {
		return compositeCurAmtType;
	}
	public void setCompositeCurAmtType(String compositeCurAmtType) {
		this.compositeCurAmtType = compositeCurAmtType;
	}
	public CurrentAmt getCurAmt() {
		return curAmt;
	}
	public void setCurAmt(CurrentAmt curAmt) {
		this.curAmt = curAmt;
	}
}
