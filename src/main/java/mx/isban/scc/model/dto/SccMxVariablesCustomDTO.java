package mx.isban.scc.model.dto;

import java.io.Serializable;
/**
 * DTO primario para la gestion 
 * y mantenimiento de variables
 * 
 * @author Chris Espina
 * 
 * Junio 2019
 * 
 * Sprint 3
 */
public class SccMxVariablesCustomDTO implements Serializable{
	/**
	 * identificador para serializar la clase SccMxVariablesCustomDTO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * identificador principal de la entidad gestion de variable
	 */
	private Long idGstVariablesPk;
	/**
	 * identificador de variable existente en el catalogo
	 * de variables scc mx mae variables
	 */
	private Long idMaeVariablesPk;
	/**
	 * codigo para identificar la variable
	 */
	private String codTipoVar;
	/**
	 * descripcion de variable
	 */
	private String dscVar;
	/**
	 * texto contenido de variable
	 */
	private String txtVar;
	/**
	 * bandera visibilidad de variable
	 */
	private Boolean flgVsbVar;
	/**
	 * bandera habilitar variable
	 */
	private Boolean flgHblVar;
	/**
	 * bandera existe tooltip
	 */
	private Boolean flgTtp;
	/**
	 * bandera existe nota informativa
	 */
	private Boolean flgNti;

	/**
	 * texto contenido de tooltip para la variable
	 */
	private String txtTooltip;
	/**
	 * Devuelve el id de gestion de variables
	 * @return idGstVariablesPk
	 */
	public Long getIdGstVariablesPk() {
		return idGstVariablesPk;
	}

	/**
	 * @param idGstVariablesPk Long
	 */
	public void setIdGstVariablesPk(Long idGstVariablesPk) {
		this.idGstVariablesPk = idGstVariablesPk;
	}

	/**
	 * Devuelve el id de la variable
	 * @return idMaeVariablesPk
	 */
	public Long getIdMaeVariablesPk() {
		return idMaeVariablesPk;
	}

	/**
	 * @param idMaeVariablesPk Long
	 */
	public void setIdMaeVariablesPk(Long idMaeVariablesPk) {
		this.idMaeVariablesPk = idMaeVariablesPk;
	}

	/**
	 * Devuelve el codigo del tipo de variable
	 * @return codTipoVar
	 */
	public String getCodTipoVar() {
		return codTipoVar;
	}

	/**
	 * @param codTipoVar String
	 */
	public void setCodTipoVar(String codTipoVar) {
		this.codTipoVar = codTipoVar;
	}

	/**
	 * Devuelve la descripcion de la variable
	 * @return dscVar
	 */
	public String getDscVar() {
		return dscVar;
	}

	/**
	 * @param dscVar String
	 */
	public void setDscVar(String dscVar) {
		this.dscVar = dscVar;
	}

	/**
	 * Devuelve el texto que si pintara para la variable
	 * @return txtVar
	 */
	public String getTxtVar() {
		return txtVar;
	}

	/**
	 * @param txtVar String
	 */
	public void setTxtVar(String txtVar) {
		this.txtVar = txtVar;
	}

	/**
	 * @return Boolean flgVsbVar
	 */
	public Boolean getFlgVsbVar() {
		return flgVsbVar;
	}

	/**
	 * @param flgVsbVar Boolean
	 */
	public void setFlgVsbVar(Boolean flgVsbVar) {
		this.flgVsbVar = flgVsbVar;
	}

	/**
	 * @return flgHblVar Boolean
	 */
	public Boolean getFlgHblVar() {
		return flgHblVar;
	}

	/**
	 * @param flgHblVar Boolean
	 */
	public void setFlgHblVar(Boolean flgHblVar) {
		this.flgHblVar = flgHblVar;
	}

	/**
	 * @return Boolean flgTtp 
	 */
	public Boolean getFlgTtp() {
		return flgTtp;
	}

	/**
	 * @param flgTtp Boolean
	 */
	public void setFlgTtp(Boolean flgTtp) {
		this.flgTtp = flgTtp;
	}

	/**
	 * @return Boolean flgNti 
	 */
	public Boolean getFlgNti() {
		return flgNti;
	}

	/**
	 * @param flgNti Boolean
	 */
	public void setFlgNti(Boolean flgNti) {
		this.flgNti = flgNti;
	}
	
	/**
	 * @return String txtTooltip
	 */
	public String getTxtTooltip() {
		return txtTooltip;
	}

	/**
	 * @param txtTooltip String
	 */
	public void setTxtTooltip(String txtTooltip) {
		this.txtTooltip = txtTooltip;
	}
	
}
