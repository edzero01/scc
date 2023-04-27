package mx.isban.scc.model.pb53;

import java.util.List;

public class AmortizationInfo {

	private int instalmentCount;
	
	private InstalmentCurAmt instalmentCurAmt;
	
	private TotalCurAmt totalCurAmt;
	
	private List<AmortizationPeriodDatum> amortizationPeriodData;
	
	private IntRateData intRateData;

	public int getInstalmentCount() {
		return instalmentCount;
	}

	public void setInstalmentCount(int instalmentCount) {
		this.instalmentCount = instalmentCount;
	}

	public InstalmentCurAmt getInstalmentCurAmt() {
		return instalmentCurAmt;
	}

	public void setInstalmentCurAmt(InstalmentCurAmt instalmentCurAmt) {
		this.instalmentCurAmt = instalmentCurAmt;
	}

	public TotalCurAmt getTotalCurAmt() {
		return totalCurAmt;
	}

	public void setTotalCurAmt(TotalCurAmt totalCurAmt) {
		this.totalCurAmt = totalCurAmt;
	}

	public List<AmortizationPeriodDatum> getAmortizationPeriodData() {
		return amortizationPeriodData;
	}

	public void setAmortizationPeriodData(List<AmortizationPeriodDatum> amortizationPeriodData) {
		this.amortizationPeriodData = amortizationPeriodData;
	}

	public IntRateData getIntRateData() {
		return intRateData;
	}

	public void setIntRateData(IntRateData intRateData) {
		this.intRateData = intRateData;
	}
}
