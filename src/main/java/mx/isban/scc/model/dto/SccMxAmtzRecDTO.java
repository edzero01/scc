package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzRecDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzRecDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad de la entidad SccMxAmtzInfo
	 */
	private SccMxAmtzInfoDTO amortizationInfo;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzRecDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param amortizationInfo
	 * amortizationInfo
	 * 
	 */
	public SccMxAmtzRecDTO(SccMxAmtzInfoDTO amortizationInfo) {
		super();
		this.amortizationInfo= amortizationInfo;
	}

	/**
	 * @return SccMxAmtzInfoDTO amortizationInfo
	 */
	public SccMxAmtzInfoDTO getAmortizationInfo() {
		return amortizationInfo;
	}

	/**
	 * @param SccMxAmtzInfoDTO amortizationInfo
	 */
	public void setAmortizationInfo(SccMxAmtzInfoDTO amortizationInfo) {
		this.amortizationInfo = amortizationInfo;
	}

	
	

	
	
		
}
