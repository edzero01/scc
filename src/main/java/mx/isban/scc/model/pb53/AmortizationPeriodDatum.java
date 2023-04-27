package mx.isban.scc.model.pb53;

import java.util.List;

public class AmortizationPeriodDatum {

	private String dueDt;
	
    private InstalmentCurAmt instalmentCurAmt;
    
    private List<CompositeCurAmt> compositeCurAmt;
    
    private TotalCurAmt totalCurAmt;
    
    private StmtRunningBal stmtRunningBal;

	public String getDueDt() {
		return dueDt;
	}

	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	public InstalmentCurAmt getInstalmentCurAmt() {
		return instalmentCurAmt;
	}

	public void setInstalmentCurAmt(InstalmentCurAmt instalmentCurAmt) {
		this.instalmentCurAmt = instalmentCurAmt;
	}

	public List<CompositeCurAmt> getCompositeCurAmt() {
		return compositeCurAmt;
	}

	public void setCompositeCurAmt(List<CompositeCurAmt> compositeCurAmt) {
		this.compositeCurAmt = compositeCurAmt;
	}

	public TotalCurAmt getTotalCurAmt() {
		return totalCurAmt;
	}

	public void setTotalCurAmt(TotalCurAmt totalCurAmt) {
		this.totalCurAmt = totalCurAmt;
	}

	public StmtRunningBal getStmtRunningBal() {
		return stmtRunningBal;
	}

	public void setStmtRunningBal(StmtRunningBal stmtRunningBal) {
		this.stmtRunningBal = stmtRunningBal;
	}
}
