package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzAmortizationPeriodDataDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzAmortizationPeriodDataDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad dueDt
	 */
	private String dueDt;
	/**
	 * propiedad de la entidad SccMxAmtzInstalmentCurAmtPDDTO
	 */
	private SccMxAmtzInstalmentCurAmtPDDTO instalmentCurAmt;
	/**
	 * propiedad de la entidad SccMxAmtzTotalCurAmtPDDTO
	 */
	private SccMxAmtzTotalCurAmtPDDTO totalCurAmt;
	/**
	 * propiedad de la entidad SccMxAmtzStmtRunningBalDTO
	 */
	private SccMxAmtzStmtRunningBalDTO stmtRunningBal;
	/**
	 * propiedad de la entidad SccMxAmtzCompositeCurAmtDTO
	 */
	private List<SccMxAmtzCompositeCurAmtDTO> compositeCurAmt;

	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzAmortizationPeriodDataDTO() {
		super();
	}


	/**
	 * constructor de clase
	 * @param dueDt
	 * dueDt
	 * @param instalmentCurAmtPD
	 * instalmentCurAmtPD
	 * @param totalCurAmtPD
	 * totalCurAmtPD
	 * @param stmtRunningBal
	 * stmtRunningBal
	 * @param compositeCurAmt
	 * compositeCurAmt
	 * 
	 */
	
	  public SccMxAmtzAmortizationPeriodDataDTO(String dueDt, SccMxAmtzInstalmentCurAmtPDDTO instalmentCurAmt, SccMxAmtzTotalCurAmtPDDTO totalCurAmt, SccMxAmtzStmtRunningBalDTO stmtRunningBal, List<SccMxAmtzCompositeCurAmtDTO> compositeCurAmt) { 
		  super();
	  this.dueDt = dueDt; 
	  this.instalmentCurAmt = instalmentCurAmt; 
	  this.totalCurAmt = totalCurAmt; 
	  this.stmtRunningBal = stmtRunningBal; 
	  this.compositeCurAmt = new ArrayList<>(compositeCurAmt); 
	  }
	 


	public String getDueDt() {
		return dueDt;
	}




	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}




	public SccMxAmtzStmtRunningBalDTO getStmtRunningBal() {
		return stmtRunningBal;
	}




	public void setStmtRunningBal(SccMxAmtzStmtRunningBalDTO stmtRunningBal) {
		this.stmtRunningBal = stmtRunningBal;
	}




	public List<SccMxAmtzCompositeCurAmtDTO> getCompositeCurAmt() {
		return compositeCurAmt;
	}




	public void setCompositeCurAmt(List<SccMxAmtzCompositeCurAmtDTO> compositeCurAmt) {
		this.compositeCurAmt = compositeCurAmt;
	}


	public SccMxAmtzInstalmentCurAmtPDDTO getInstalmentCurAmt() {
		return instalmentCurAmt;
	}


	public void setInstalmentCurAmt(SccMxAmtzInstalmentCurAmtPDDTO instalmentCurAmt) {
		this.instalmentCurAmt = instalmentCurAmt;
	}


	public SccMxAmtzTotalCurAmtPDDTO getTotalCurAmt() {
		return totalCurAmt;
	}


	public void setTotalCurAmt(SccMxAmtzTotalCurAmtPDDTO totalCurAmt) {
		this.totalCurAmt = totalCurAmt;
	}

	


	
		
}
