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
public class SccMxAmtzIntRateDataDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzIntRateDataDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad de la entidad SccMxAmtzRateMatrixTierDTO
	 */
	private List<SccMxAmtzRateMatrixTierDTO> rateMatrixTier;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzIntRateDataDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param rateMatrixTier
	 * rateMatrixTier
	 * 
	 */
	
	  public SccMxAmtzIntRateDataDTO(List<SccMxAmtzRateMatrixTierDTO> rateMatrixTier) { 
		  super(); 
		  this.rateMatrixTier= new ArrayList<>(rateMatrixTier); 
		  }
	 


	public List<SccMxAmtzRateMatrixTierDTO> getRateMatrixTier() {
		return rateMatrixTier;
	}



	public void setRateMatrixTier(List<SccMxAmtzRateMatrixTierDTO> rateMatrixTier) {
		this.rateMatrixTier = rateMatrixTier;
	}

	

	
	

	
	
		
}
