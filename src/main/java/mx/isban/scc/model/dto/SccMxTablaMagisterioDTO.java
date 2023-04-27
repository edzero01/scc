package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de tablas de amortizacion magisterio
 * 
 * 
 * @author Jose Luis Garcia
 *
 */
public class SccMxTablaMagisterioDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxTablaMagisterioDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	/**
	 * propiedad rqUID
	 */
	private String rqUID;
	
	/**
	 * propiedad plan
	 */
	private Long plan;
	
	/**
	 * propiedad gracia
	 */
	private String gracia;
	
	/**
	 * propiedad recurrencia
	 */
	private String recurrencia;
	
	/**
	 * propiedad caucion
	 */
	private Long caucion;
	
	/**
	 * propiedad plantilla
	 */
	private String plantilla;
	/**
	 * propiedad tablaCat de la entidad SccMxAmtzRec
	 */
	private SccMxAmtzRecDTO amortizationRec;

	
	/**
	 * propiedad tablaCat
	 */
	private SccMxAmtzCatMagisterioDTO tablaCat;

	/**
	 * constructor super
	 */
	public SccMxTablaMagisterioDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * 
	 * @param rqUID           rqUID
	 * @param amortizationRec amortizationRec
	 * @param tablaCat tablaCat
	 * @param plan plan
	 * @param gracia gracia
	 * @param recurrencia recurrencia
	 * @param caucion caucion
	 * @param plantilla plantilla
	 * 
	 */

	public SccMxTablaMagisterioDTO(Long plan, String gracia, String recurrencia, Long caucion, String plantilla,String rqUID, SccMxAmtzRecDTO amortizationRec, SccMxAmtzCatMagisterioDTO tablaCat) {
		super();
		this.rqUID = rqUID;
		this.amortizationRec = amortizationRec;
		this.plan = plan;
		this.gracia = gracia;
		this.recurrencia = recurrencia;
		this.caucion = caucion;
		this.plantilla = plantilla;
		this.tablaCat = tablaCat;
	}

	public String getRqUID() {
		return rqUID;
	}

	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}

	public SccMxAmtzRecDTO getAmortizationRec() {
		return amortizationRec;
	}

	public void setAmortizationRec(SccMxAmtzRecDTO amortizationRec) {
		this.amortizationRec = amortizationRec;
	}

	public Long getPlan() {
		return plan;
	}

	public void setPlan(Long plan) {
		this.plan = plan;
	}

	public String getGracia() {
		return gracia;
	}

	public void setGracia(String gracia) {
		this.gracia = gracia;
	}

	public String getRecurrencia() {
		return recurrencia;
	}

	public void setRecurrencia(String recurrencia) {
		this.recurrencia = recurrencia;
	}

	public Long getCaucion() {
		return caucion;
	}

	public void setCaucion(Long caucion) {
		this.caucion = caucion;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public SccMxAmtzCatMagisterioDTO getTablaCat() {
		return tablaCat;
	}

	public void setTablaCat(SccMxAmtzCatMagisterioDTO tablaCat) {
		this.tablaCat = tablaCat;
	}

}
