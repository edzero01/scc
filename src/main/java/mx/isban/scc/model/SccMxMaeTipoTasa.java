package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Catalogo del tipo de tasa
 * Es inmutable: 1 = fija, 2 = variable
  * Generado por GlobalHitss
 * Mayo 2019
 * Sprint 1
 * @author Hitss
 * SccMxMaeTipoTasa generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_TIPO_TASA")
public class SccMxMaeTipoTasa implements java.io.Serializable {

	
	/**
	 * Identificador para serializar la clase
	 */
	private static final long serialVersionUID = 3599191411359257987L;
	/**
	 * Llave primaria tipo de tasa: 1  o 2
	 */
	private Long idTipoTasaPk;
	/**
	 * Identificador de tipo de tasa: Fija o Variable
	 */
	private String dscTipoTasa;

	/**
	 * Constructor Vacio
	 */
	public SccMxMaeTipoTasa() {
	}

	/**
	 * Constructor tipo tasa
	 * @param idTipoTasaPk
	 * llave
	 * @param dscTipoTasa
	 * descripcion
	 */
	public SccMxMaeTipoTasa(Long idTipoTasaPk, String dscTipoTasa) {
		this.idTipoTasaPk = idTipoTasaPk;
		this.dscTipoTasa = dscTipoTasa;
	}


	/**
	 * @return Long idTipoTasaPk
	 */
	@Id
	@Column(name = "ID_TIPO_TASA_PK", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdTipoTasaPk() {
		return this.idTipoTasaPk;
	}

	/**
	 * @param idTipoTasaPk
	 */
	public void setIdTipoTasaPk(Long idTipoTasaPk) {
		this.idTipoTasaPk = idTipoTasaPk;
	}

	/**
	 * @return String dscTipoTasa
	 */
	@Column(name = "DSC_TIPO_TASA", nullable = false, length = 100)
	public String getDscTipoTasa() {
		return this.dscTipoTasa;
	}

	/**
	 * @param dscTipoTasa String
	 */
	public void setDscTipoTasa(String dscTipoTasa) {
		this.dscTipoTasa = dscTipoTasa;
	}

	
}
