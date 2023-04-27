package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class AcctPackageData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9191468073969031081L;

	private String productIdent;
	
    private String subProductIdent;

	public String getProductIdent() {
		return productIdent;
	}

	public void setProductIdent(String productIdent) {
		this.productIdent = productIdent;
	}

	public String getSubProductIdent() {
		return subProductIdent;
	}

	public void setSubProductIdent(String subProductIdent) {
		this.subProductIdent = subProductIdent;
	}
}
