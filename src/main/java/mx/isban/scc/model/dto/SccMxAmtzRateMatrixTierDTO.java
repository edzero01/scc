package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzRateMatrixTierDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzRateMatrixTierDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad intAPR
	 */
	private String intAPR;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzRateMatrixTierDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param intAPR
	 * intAPR
	 * 
	 */
	public SccMxAmtzRateMatrixTierDTO(String intAPR) {
		super();
		this.intAPR = intAPR;
	}

	public String getIntAPR() {
		return intAPR;
	}

	public void setIntAPR(String intAPR) {
		this.intAPR = intAPR;
	}



	

	
	

	
	
		
}
