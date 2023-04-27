package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzStmtRunningBalDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzStmtRunningBalDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad amt
	 */
	private String amt;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzStmtRunningBalDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param amt
	 * amt
	 * 
	 */
	public SccMxAmtzStmtRunningBalDTO(String amt) {
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
