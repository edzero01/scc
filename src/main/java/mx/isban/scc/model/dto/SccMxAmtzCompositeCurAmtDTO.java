package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion magisterio
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxAmtzCompositeCurAmtDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxAmtzCompositeCurAmtDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	
	/**
	 * propiedad compositeCurAmtType
	 */
	private String compositeCurAmtType;
	/**
	 * propiedad de la entidad SccMxAmtzCurAmtDTO
	 */
	private SccMxAmtzCurAmtDTO curAmt;


	
	
	
	/**
	 * constructor super
	 */
	public SccMxAmtzCompositeCurAmtDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param compositeCurAmtType
	 * compositeCurAmtType
	 * @param curAmt
	 * curAmt
	 * 
	 */
	
	  public SccMxAmtzCompositeCurAmtDTO(String compositeCurAmtType, SccMxAmtzCurAmtDTO curAmt) { 
		  super();
	  this.compositeCurAmtType = compositeCurAmtType; 
	  this.curAmt = curAmt;  
	  }
	 




	public String getCompositeCurAmtType() {
		return compositeCurAmtType;
	}





	public void setCompositeCurAmtType(String compositeCurAmtType) {
		this.compositeCurAmtType = compositeCurAmtType;
	}





	public SccMxAmtzCurAmtDTO getCurAmt() {
		return curAmt;
	}





	public void setCurAmt(SccMxAmtzCurAmtDTO curAmt) {
		this.curAmt = curAmt;
	}

	


	
		
}
