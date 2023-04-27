package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzTotalCurAmtDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzTotalCurAmtDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad amt
	 */
	private String amt;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzTotalCurAmtDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param amt
	 * amt
	 * 
	 */
	public SccMxAmtzTotalCurAmtDTO(String amt) {
		super();
		this.amt = amt;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	

	
	

	
	
		
}
