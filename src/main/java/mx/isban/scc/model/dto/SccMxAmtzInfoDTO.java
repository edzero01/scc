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
public class SccMxAmtzInfoDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzInfoDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad de la entidad instalmentCount
	 */
	private String instalmentCount;
	/**
	 * propiedad de la entidad SccMxAmtzInstalmentCurAmtDTO
	 */
	private SccMxAmtzInstalmentCurAmtDTO instalmentCurAmt;
	/**
	 * propiedad de la entidad SccMxAmtzTotalCurAmtDTO
	 */
	private SccMxAmtzTotalCurAmtDTO totalCurAmt;
	/**
	 * propiedad de la entidad SccMxAmtzIntRateDataDTO
	 */
	private SccMxAmtzIntRateDataDTO intRateData;
	/**
	 * propiedad de la entidad SccMxAmtzAmortizationPeriodDataDTO
	 */
	private List<SccMxAmtzAmortizationPeriodDataDTO> amortizationPeriodData;

	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzInfoDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param instalmentCount
	 * instalmentCount
	 * @param instalmentCurAmt
	 * instalmentCurAmt
	 * @param totalCurAmt
	 * totalCurAmt
	 * @param intRateData
	 * intRateData
	 * @param amortizationPeriodData
	 * amortizationPeriodData
	 * 
	 */
	
	  public SccMxAmtzInfoDTO(String instalmentCount, SccMxAmtzInstalmentCurAmtDTO instalmentCurAmt, SccMxAmtzTotalCurAmtDTO totalCurAmt, SccMxAmtzIntRateDataDTO intRateData, List<SccMxAmtzAmortizationPeriodDataDTO> amortizationPeriodData) { 
		  super(); 
		  this.instalmentCount = instalmentCount;
		  this.instalmentCurAmt = instalmentCurAmt; 
		  this.totalCurAmt = totalCurAmt;
		  this.intRateData = intRateData; 
		  this.amortizationPeriodData = new ArrayList<>(amortizationPeriodData); 
		  }
	 


	public String getInstalmentCount() {
		return instalmentCount;
	}




	public void setInstalmentCount(String instalmentCount) {
		this.instalmentCount = instalmentCount;
	}




	public SccMxAmtzInstalmentCurAmtDTO getInstalmentCurAmt() {
		return instalmentCurAmt;
	}




	public void setInstalmentCurAmt(SccMxAmtzInstalmentCurAmtDTO instalmentCurAmt) {
		this.instalmentCurAmt = instalmentCurAmt;
	}




	public SccMxAmtzTotalCurAmtDTO getTotalCurAmt() {
		return totalCurAmt;
	}




	public void setTotalCurAmt(SccMxAmtzTotalCurAmtDTO totalCurAmt) {
		this.totalCurAmt = totalCurAmt;
	}




	public SccMxAmtzIntRateDataDTO getIntRateData() {
		return intRateData;
	}




	public void setIntRateData(SccMxAmtzIntRateDataDTO intRateData) {
		this.intRateData = intRateData;
	}




	public List<SccMxAmtzAmortizationPeriodDataDTO> getAmortizationPeriodData() {
		return amortizationPeriodData;
	}




	public void setAmortizationPeriodData(List<SccMxAmtzAmortizationPeriodDataDTO> amortizationPeriodData) {
		this.amortizationPeriodData = amortizationPeriodData;
	}




		
}
