package mx.isban.scc.model.pb53;

import java.util.List;

public class AmortizationSel {
	
	private String requestDt;
	
	private AcctKeys acctKeys;
	
	private TotalCurAmt totalCurAmt;
	
	private Term term;
	
	private RecurRule recurRule;
	
	private ReviewFrequency reviewFrequency;
	
	private List<RateMatrixTier> rateMatrixTier;

	public String getRequestDt() {
		return requestDt;
	}

	public void setRequestDt(String requestDt) {
		this.requestDt = requestDt;
	}

	public AcctKeys getAcctKeys() {
		return acctKeys;
	}

	public void setAcctKeys(AcctKeys acctKeys) {
		this.acctKeys = acctKeys;
	}

	public TotalCurAmt getTotalCurAmt() {
		return totalCurAmt;
	}

	public void setTotalCurAmt(TotalCurAmt totalCurAmt) {
		this.totalCurAmt = totalCurAmt;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public RecurRule getRecurRule() {
		return recurRule;
	}

	public void setRecurRule(RecurRule recurRule) {
		this.recurRule = recurRule;
	}

	public ReviewFrequency getReviewFrequency() {
		return reviewFrequency;
	}

	public void setReviewFrequency(ReviewFrequency reviewFrequency) {
		this.reviewFrequency = reviewFrequency;
	}

	public List<RateMatrixTier> getRateMatrixTier() {
		return rateMatrixTier;
	}

	public void setRateMatrixTier(List<RateMatrixTier> rateMatrixTier) {
		this.rateMatrixTier = rateMatrixTier;
	}
}
