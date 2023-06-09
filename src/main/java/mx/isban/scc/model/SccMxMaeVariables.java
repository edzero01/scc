package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Generado por GlobalHitss
 * Fabrica de Software
 * Simulador de credito al consumo
 * Catalogo de Variables, inmutable y definido de acuerdo
 * a los datos que se despliegan en la pantalla de simulacion
 * Mayo 2019
 * Sprint 1
 * SccMxMaeVariables generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_VARIABLES")
public class SccMxMaeVariables implements IAbstractEntity,java.io.Serializable {

	/**
	 * serializacion de la entidad SccMxMaeVariables
	 */
	private static final long serialVersionUID = -6771111343543339452L;
	/**
	 * Llave principal, secuencial y unica
	 */
	private Long idMaeVariablesPk;
	/**
	 * Codigo de la variable definido con el usuario para la pantalla de simulacion
	 */
	private String codTipoVar;
	/**
	 * Descripcion de la variable definida con el usuario para la pantalla de simulacion
	 */
	private String dscVar;
	/**
	 * Texto que coincide con el texto que se despliega en la pantalla de simulacion
	 */
	private String txtVar;
	
	/**
	 * Contructor de la entidad SccMxMaeVariables
	 */
	public SccMxMaeVariables() {
	}

	/**
	 * Constructor de varaibles
	 * @param idMaeVariablesPk
	 * llave
	 */
	public SccMxMaeVariables(Long idMaeVariablesPk) {
		this.idMaeVariablesPk = idMaeVariablesPk;
	}

	/**
	 * 
	 * Constructor completo de variables
	 * @param idMaeVariablesPk
	 * llave
	 * @param codTipoVar
	 * codigo
	 * @param dscVar
	 * descripcion
	 * @param txtVar
	 * texto
	 */
	public SccMxMaeVariables(Long idMaeVariablesPk, String codTipoVar, String dscVar, String txtVar) {
		this.idMaeVariablesPk = idMaeVariablesPk;
		this.codTipoVar = codTipoVar;
		this.dscVar = dscVar;
		this.txtVar = txtVar;
	}

	/**
	 * @return Long idMaeVariablesPk
	 */
	@Id
	@Column(name = "ID_MAE_VARIABLES_PK", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdMaeVariablesPk() {
		return this.idMaeVariablesPk;
	}

	/** 
	 * @param idMaeVariablesPk Long
	 */
	public void setIdMaeVariablesPk(Long idMaeVariablesPk) {
		this.idMaeVariablesPk = idMaeVariablesPk;
	}

	/**
	 * @return String codTipoVar
	 */
	@Column(name = "COD_TIPO_VAR", length = 100)
	public String getCodTipoVar() {
		return this.codTipoVar;
	}

	/**
	 * @param codTipoVar String
	 */
	public void setCodTipoVar(String codTipoVar) {
		this.codTipoVar = codTipoVar;
	}

	/**
	 * @return String dscVar
	 */
	@Column(name = "DSC_VAR", length = 100)
	public String getDscVar() {
		return this.dscVar;
	}

	/**
	 * @param dscVar String
	 */
	public void setDscVar(String dscVar) {
		this.dscVar = dscVar;
	}

	/**
	 * @return String txtVar
	 */
	@Column(name = "TXT_VAR", length = 100)
	public String getTxtVar() {
		return this.txtVar;
	}

	/**
	 * @param txtVar String
	 */
	public void setTxtVar(String txtVar) {
		this.txtVar = txtVar;
	}
}
