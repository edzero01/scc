package mx.isban.scc.model.lza0;

import java.io.Serializable;
import java.util.List;

public class AcctInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6138789850155350955L;

	private AcctPackageData acctPackageData;
	
	private String comments;
	
	private String ownership;
	
	private String acctType;
	
	private String bban;
	
	private String salesChannelCode;
	
	private FiData fiData;
	
	private List<RelationshipMgr> relationshipMgr;
	
	private CurCode curCode;
	
	private PartyKeys partyKeys;
	
	private List<Segmentation> segmentation;
	
	private String productIdent;
	
	private String subProductIdent;
	
	private String clabe;
	
	private List<AcctBal> acctBal;
	
	private List<PartyAcctRelDatum> partyAcctRelData;

	public AcctPackageData getAcctPackageData() {
		return acctPackageData;
	}

	public void setAcctPackageData(AcctPackageData acctPackageData) {
		this.acctPackageData = acctPackageData;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getBban() {
		return bban;
	}

	public void setBban(String bban) {
		this.bban = bban;
	}

	public String getSalesChannelCode() {
		return salesChannelCode;
	}

	public void setSalesChannelCode(String salesChannelCode) {
		this.salesChannelCode = salesChannelCode;
	}

	public FiData getFiData() {
		return fiData;
	}

	public void setFiData(FiData fiData) {
		this.fiData = fiData;
	}

	public List<RelationshipMgr> getRelationshipMgr() {
		return relationshipMgr;
	}

	public void setRelationshipMgr(List<RelationshipMgr> relationshipMgr) {
		this.relationshipMgr = relationshipMgr;
	}

	public CurCode getCurCode() {
		return curCode;
	}

	public void setCurCode(CurCode curCode) {
		this.curCode = curCode;
	}

	public PartyKeys getPartyKeys() {
		return partyKeys;
	}

	public void setPartyKeys(PartyKeys partyKeys) {
		this.partyKeys = partyKeys;
	}

	public List<Segmentation> getSegmentation() {
		return segmentation;
	}

	public void setSegmentation(List<Segmentation> segmentation) {
		this.segmentation = segmentation;
	}

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

	public String getClabe() {
		return clabe;
	}

	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	public List<AcctBal> getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(List<AcctBal> acctBal) {
		this.acctBal = acctBal;
	}

	public List<PartyAcctRelDatum> getPartyAcctRelData() {
		return partyAcctRelData;
	}

	public void setPartyAcctRelData(List<PartyAcctRelDatum> partyAcctRelData) {
		this.partyAcctRelData = partyAcctRelData;
	}
}
