package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO PADRE para producto y subproducto
 * debido a la extensa cantidad de campos utilizadas en estas
 * tablas unidas con DTO, se hizo la clase Padre
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 */
public class SccMxMaeProductoSubProductPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeProductoSubProductDTO
	 */
	private static final long serialVersionUID = 7688958035956517092L;
	/**
	 * Propiedad llave principal para la entidad producto
	 */
	protected Long idProdPk;
	/**
	 * Propiedad codigo del producto
	 */
	protected Long codProd;
	/**
	 *Propiedad llave principal para la entidad sub producto 
	 */
	protected Long idSubProdPk;
	/**
	 * Propiedad codigo del subproducto
	 */
	protected Long codSubProd;
	/**
	 *  Propiedad Descripcion comercial del producto
	 */
	protected String desProdComercial;
	/**
	 * Propiedad Descripcion del tipo de pago de seguro
	 */
	protected String dscPagSeg;
	/**
	 * Propiedad Descripcion de la cobertura del Seguro
	 */
	protected String dscCoberturaSeg;
	/**
	 * Propiedad ID para el pago de seguro
	 */
	protected long idPagoSeguro;
	/**
	 * Propiedad Descripcion del pago de Seguro
	 */
	protected String descPagoSeguro;
	/**
	 * Propiedad planTabla de la entidad producto indica la modalidad frances o aleman
	 */
	protected String planTabla;

	/**
	 * constructor vacio
	 */
	public SccMxMaeProductoSubProductPadreDTO() {
		super();
	}

	/**
	 * 
	 * @return idProdPk Id de producto
	 */
	public Long getIdProdPk() {
		return idProdPk;
	}

	/**
	 * 
	 * @param idProdPk Id de producto.
	 */
	public void setIdProdPk(Long idProdPk) {
		this.idProdPk = idProdPk;
	}

	/**
	 * 
	 * @return codProd Código de producto
	 */
	public Long getCodProd() {
		return codProd;
	}

	/**
	 * 
	 * @param codProd Código de producto
	 */
	public void setCodProd(Long codProd) {
		this.codProd = codProd;
	}

	/**
	 * 
	 * @return idSubProdPk Id de subproducto
	 */
	public Long getIdSubProdPk() {
		return idSubProdPk;
	}

	/**
	 * 
	 * @param idSubProdPk Id de subproducto
	 */
	public void setIdSubProdPk(Long idSubProdPk) {
		this.idSubProdPk = idSubProdPk;
	}

	/**
	 * 
	 * @return codSubProd Código de subproducto
	 */
	public Long getCodSubProd() {
		return codSubProd;
	}

	/**
	 * 
	 * @param codSubProd Código de subproducto
	 */
	public void setCodSubProd(Long codSubProd) {
		this.codSubProd = codSubProd;
	}

	/**
	 * 
	 * @return desProdComercial Descripción del producto comercial
	 */
	public String getDesProdComercial() {
		return desProdComercial;
	}

	/**
	 * 
	 * @param desProdComercial Descripción del producto comercial
	 */
	public void setDesProdComercial(String desProdComercial) {
		this.desProdComercial = desProdComercial;
	}

	/**
	 * 
	 * @return dscPagSeg Descripción del pago de seguro
	 */
	public String getDscPagSeg() {
		return dscPagSeg;
	}

	/**
	 * 
	 * @param dscPagSeg Descripción del pago de seguro
	 */
	public void setDscPagSeg(String dscPagSeg) {
		this.dscPagSeg = dscPagSeg;
	}

	/**
	 * 
	 * @return dscCoberturaSeg Descripción de la cobertura de seguro
	 */
	public String getDscCoberturaSeg() {
		return dscCoberturaSeg;
	}

	/**
	 * 
	 * @param dscCoberturaSeg Descripción de la cobertura de seguro
	 */
	public void setDscCoberturaSeg(String dscCoberturaSeg) {
		this.dscCoberturaSeg = dscCoberturaSeg;
	}

	/**
	 * 
	 * @return idPagoSeguro Id del pago de seguro
	 */
	public long getIdPagoSeguro() {
		return idPagoSeguro;
	}

	/**
	 * 
	 * @param idPagoSeguro Id del pago de seguro
	 */
	public void setIdPagoSeguro(long idPagoSeguro) {
		this.idPagoSeguro = idPagoSeguro;
	}

	/**
	 * 
	 * @return descPagoSeguro Descripción del pago de seguro
	 */
	public String getDescPagoSeguro() {
		return descPagoSeguro;
	}

	/**
	 * 
	 * @param descPagoSeguro Descripción del pago de seguro
	 */
	public void setDescPagoSeguro(String descPagoSeguro) {
		this.descPagoSeguro = descPagoSeguro;
	}

	/**
	 * @return planTabla Tabla del plan
	 */
	public String getPlanTabla() {
		return planTabla;
	}

	/**
	 * Se inicializa el plan tabla
	 * 
	 * @param planTabla Tabla del plan
	 */
	public void setPlanTabla(String planTabla) {
		this.planTabla = planTabla;
	}

}
