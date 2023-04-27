package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO Para el proceso de obtencion de 
 * tablas de amortizacion y a su vez
 * para obtener el CAT dado un tipo
 * de plan y el tir
 * 
 * Mayo 2019
 * Global Hitss
 * Sprint 2
 * 
 * @author Christopher Espina Riveros
 *
 */
public class SccMxTablaCatDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxTablaCatDTO
	 */
	private static final long serialVersionUID = 6856094285763813563L;
	/**
	 * propiedad plantilla para identificar eel tipo de calculo que aplicara
	 */
	private Long plantilla;
	/**
	 * propiedad plan que puede ser frances o aleman
	 */
	private Long plan;
	/**
	 * propiedad costo de la caucion aplica unicamente a PSG
	 */
	private Double caucion;
	/**
	 * propiedad gracia en caso de que aplique periodo de gracia
	 */
	private String gracia;
	/**
	 * propiedad que indica si es prima recurrente o unica en el seguro
	 */
	private String recurrencia;
	/**
	 * propiedad tablaCat de la entidad SccMxTablaCat
	 */
	private SccMxTablaAmtzInDTO tablaCat;
	
	/**
	 * propiedad tablaCat de la entidad SccMxTablaRies
	 */
	private SccMxTablaRiesDTO tablaRies;
	
	/**
	 * propiedad tablaCat de la entidad SccMxTablaCaratula
	 */
	private SccMxTablaCaratulaDTO tablaCaratula;
	
	
	
	/**
	 * constructor super
	 */
	public SccMxTablaCatDTO() {
		super();
	}

	/**
	 * constructor de clase
	 * @param plan
	 * plan
	 * @param gracia
	 * gracia
	 * @param recurrencia
	 * recurrencia
	 * @param tablaCat
	 * tabla de entrada
	 * @param tablaRies
	 * tabla Ries
	 * @param tablaCaratula
	 * tabla caratula
	 * 
	 */
	public SccMxTablaCatDTO(Long plan, String gracia, String recurrencia, SccMxTablaAmtzInDTO tablaCat, SccMxTablaRiesDTO tablaRies, SccMxTablaCaratulaDTO tablaCaratula) {
		super();
		this.plan = plan;
		this.gracia = gracia;
		this.recurrencia = recurrencia;
		this.tablaCat = tablaCat;
		this.tablaRies =tablaRies;
		this.tablaCaratula =tablaCaratula;
	}
	
	/**
	 * @return plan Long
	 */
	public Long getPlan() {
		return plan;
	}

	/**
	 * @param plan Long
	 */
	public void setPlan(Long plan) {
		this.plan = plan;
	}

	/**
	 * @return gracia String
	 */
	public String getGracia() {
		return gracia;
	}

	/**
	 * @param gracia String 
	 */
	public void setGracia(String gracia) {
		this.gracia = gracia;
	}

	/**
	 * @return String recurrencia
	 */
	public String getRecurrencia() {
		return recurrencia;
	}

	/**
	 * @param recurrencia String
	 */
	public void setRecurrencia(String recurrencia) {
		this.recurrencia = recurrencia;
	}

	/**
	 * @return SccMxTablaAmtzInDTO tablaCat
	 */
	public SccMxTablaAmtzInDTO getTablaCat() {
		return tablaCat;
	}

	/**
	 * @param tablaCat SccMxTablaAmtzInDTO
	 */
	public void setTablaCat(SccMxTablaAmtzInDTO tablaCat) {
		this.tablaCat = tablaCat;
	}

	
	/**
	 * @return SccMxTablaRiesDTO tablaRies
	 */
	public SccMxTablaRiesDTO getTablaRies() {
		return tablaRies;
	}

	/**
	 * @param tablaRies SccMxTablaRiesDTO
	 */
	public void setTablaRies(SccMxTablaRiesDTO tablaRies) {
		this.tablaRies = tablaRies;
		
	}
	
	/**
	 * @param tablaCaratula SccMxTablaCaratulaDTO
	 */
	public void setTablaCaratula(SccMxTablaCaratulaDTO tablaCaratula) {
		this.tablaCaratula = tablaCaratula;
	}
	
	/**
	 * @return SccMxTablaCaratulaDTO tablaCaratula
	 */
	public SccMxTablaCaratulaDTO getTablaCaratula() {
		return tablaCaratula;
	}
	/**
	 * @return Double caucion
	 */
	public Double getCaucion() {
		return caucion;
	}

	/**
	 * @param caucion Double
	 */
	public void setCaucion(Double caucion) {
		this.caucion = caucion;
	}

	/**
	 * @return plantilla Long
	 */
	public Long getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla Long
	 */
	public void setPlantilla(Long plantilla) {
		this.plantilla = plantilla;
	}
		
}
