package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO para manejar la información de Conversion Auto
 * relacionada por tasa, lapa y con el nuevo idSubProd
 * @author Hitss Fabrica de Software
 * Julio 2019
 * Sprint 4
 * El porcentaje de tasa de interes en conversion auto
 * depende del tipo de segmento utilizado, se busca el dato del
 * subproducto relacionado con el segmento y se toma la informacion
 * de condiciones financieras de dicho subproducto
 */
public class SccMxMaeConvautoDTO implements Serializable{
	
	/**
	 * Identificador del Static Final Serialize para cumplir los requerimientos
	 * minimos indicados en SONAR.
	 */
	private static final long serialVersionUID = 5782477213269844955L;
	/**
	 * propiedad idConvautoPk de la entidad SccMxMaeConvauto
	 */
	private Long idConvautoPk;
	/**
	 * Porcentaje de Tasa que aplica para promocion de conversión Auto
	 */
	private Double porTasa;
	/**
	 * El numero de Lapa se busca en condiciones financieras para obtener
	 * la tasa que aplica en conversion auto para linex
	 */
	private Long numLapa;
	/**
	 * ID para encontrar el Subproducto con el que se aplicará la promoción
	 * de conversión auto
	 */
	private Long idSubProdFk;
	

	/**
	 * constructor vacio
	 */
	public SccMxMaeConvautoDTO() {
		super();
	}

	/**
	 * @return Long idConvautoPk
	 */
	public Long getIdConvautoPk() {
		return idConvautoPk;
	}

	/**
	 * @param idConvautoPk Long
	 */
	public void setIdConvautoPk(Long idConvautoPk) {
		this.idConvautoPk = idConvautoPk;
	}

	/**
	 * @return Double porTasa
	 */
	public Double getPorTasa() {
		return porTasa;
	}


	/**
	 * @param porTasa Double
	 */
	public void setPorTasa(Double porTasa) {
		this.porTasa = porTasa;
	}


	/**
	 * @return Long numLapa
	 */
	public Long getNumLapa() {
		return numLapa;
	}


	/**
	 * @param numLapa Long
	 */
	public void setNumLapa(Long numLapa) {
		this.numLapa = numLapa;
	}


	/**
	 * @return Long idSubProdFk
	 */
	public Long getIdSubProdFk() {
		return idSubProdFk;
	}


	/**
	 * @param idSubProdFk Long
	 */
	public void setIdSubProdFk(Long idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}
}
