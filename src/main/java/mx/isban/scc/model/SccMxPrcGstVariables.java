package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * En esta tabla se tiene la relacion del catalogo de variables
 * con los subproductos
 * para poder desplegar, ocultar y mostrar tooltips o notas 
 * correspondientes en la pantalla de simulacion
 * Generado por GlobalHitss
 * Mayo 2019
 * Sprint 1
 * SccMxPrcGstVariables generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_PRC_GST_VARIABLES")
public class SccMxPrcGstVariables implements IAbstractEntity, java.io.Serializable {

	/**
	 * serializacion de la entidad SccMxPrcGstVariables
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Llave principal, unica y secuencial de la entidad SccMxPrcGstVariables
	 */
	private Long idGstVariablesPk;
	/**
	 * Llave foranea a la tabla de subproducto
	 */
	private Long idSubProdFk;
	/**
	 * Registro de catalogo de variables al que corresponde la relacion
	 * de variables-subproducto
	 */
	private SccMxMaeVariables sccMxMaeVariables;
	/**
	 * Indica visibilidad de la variable relacionada
	 */
	private Integer flgVsbVar;
	/**
	 * Indica si esta habilitada la variable relacionada
	 */
	private Integer flgHblVar;
	/**
	 * Indica si la variable tiene un Tooltip Asignado
	 */
	private Integer flgTtp;
	/**
	 * Indica si la variable tiene una  nota Asignada
	 */
	private Integer flgNti;
	
	/**
	 * Indica el texto del tooltip asignado
	 */
	private String txtTtp;

	/**
	 * Constructor vacío
	 */
	public SccMxPrcGstVariables() {
	}

	/**
	 * Constructor mini
	 * @param idGstVariablesPk
	 * Para leer la llave
	 */
	public SccMxPrcGstVariables(Long idGstVariablesPk) {
		this.idGstVariablesPk = idGstVariablesPk;
	}

	/**
	 * constructor completo
	 * @param idGstVariablesPk 
	 * Id de Variable
	 * @param idSubProdFk
	 * Id de subproducto
	 * @param sccMxMaeVariables
	 * conexion con variable
	 * @param flgVsbVar
	 * bandera  de visibilidad
	 * @param flgHblVar
	 * bandera de habilitado
	 * @param flgTtp
	 * bandera de tooltip
	 * @param flgNti
	 * bandera de nota informativa
	 */
	public SccMxPrcGstVariables(Long idGstVariablesPk, Long idSubProdFk,
			SccMxMaeVariables sccMxMaeVariables, Integer flgVsbVar, Integer flgHblVar, Integer flgTtp, Integer flgNti) {
		this.idGstVariablesPk = idGstVariablesPk;
		this.idSubProdFk = idSubProdFk;
		this.sccMxMaeVariables = sccMxMaeVariables;
		this.flgVsbVar = flgVsbVar;
		this.flgHblVar = flgHblVar;
		this.flgTtp = flgTtp;
		this.flgNti = flgNti;
		
	}

	/**
	 * @return idGstVariablesPk Id de la variable
	 */
	@Id
	@Column(name = "ID_GST_VARIABLES_PK", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdGstVariablesPk() {
		return this.idGstVariablesPk;
	}

	/**
	 * Parametro primary key
	 * @param idGstVariablesPk Id de la variable
	 */
	public void setIdGstVariablesPk(Long idGstVariablesPk) {
		this.idGstVariablesPk = idGstVariablesPk;
	}


	/**
	 * @return idSubProdFk Id del subproducto
	 */
	@Column(name = "ID_SUB_PROD_FK")
	public Long getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * Conexion con subproducto
	 * @param idSubProdFk Id del subproducto
	 * registro de la tabla 
	 */
	public void setIdSubProdFk(Long idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

	/**
	 * @return sccMxMaeVariables Tabla de variables
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MAE_VARIABLES_FK")
	public SccMxMaeVariables getSccMxMaeVariables() {
		return this.sccMxMaeVariables;
	}

	/**
	 * Conexion con la tabla de variables
	 * @param sccMxMaeVariables Tabla de variables
	 * registro de la tabla
	 */
	public void setSccMxMaeVariables(SccMxMaeVariables sccMxMaeVariables) {
		this.sccMxMaeVariables = sccMxMaeVariables;
	}

	/**
	 * @return Integer flgHblVar
	 */
	@Column(name = "FLG_VSB_VAR", precision = 1, scale = 0)
	public Integer getFlgVsbVar() {
		return this.flgVsbVar;
	}

	/**
	 * bandera para indicar visibilidad
	 * @param flgVsbVar Integer
	 */
	public void setFlgVsbVar(Integer flgVsbVar) {
		this.flgVsbVar = flgVsbVar;
	}

	/**
	 * @return Integer flgHblVar
	 */
	@Column(name = "FLG_HBL_VAR", precision = 1, scale = 0)
	public Integer getFlgHblVar() {
		return this.flgHblVar;
	}

	/**
	 * @param flgHblVar Integer
	 */
	public void setFlgHblVar(Integer flgHblVar) {
		this.flgHblVar = flgHblVar;
	}

	/**
	 * @return Integer flgTtp
	 */
	@Column(name = "FLG_TTP", precision = 1, scale = 0)
	public Integer getFlgTtp() {
		return this.flgTtp;
	}

	/**
	 * @param flgTtp Integer
	 */
	public void setFlgTtp(Integer flgTtp) {
		this.flgTtp = flgTtp;
	}

	/**
	 * @return Integer flgNti
	 */
	@Column(name = "FLG_NTI", precision = 1, scale = 0)
	public Integer getFlgNti() {
		return this.flgNti;
	}

	/**
	 * @param flgNti Integer
	 */
	public void setFlgNti(Integer flgNti) {
		this.flgNti = flgNti;
	}
	
	/**
	 * @return String ttp
	 */
	@Transient
	public String getTtp() {
		return this.txtTtp;
	}

	/**
	 * @param ttp String
	 */
	public void setTtp(String ttp) {
		this.txtTtp = ttp;
	}
	
}
