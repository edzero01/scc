package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO para producto y subproducto
 * Extiende de PadreDTO por la cantidad de campos
 * que conforman ambas entidades unidas
 * 
 * @author GlobalHitss Mayo 2019 Sprint 1
 */
public class SccMxMaeProductoSubProductDTO extends SccMxMaeProductoSubProductPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeProductoSubProductDTO
	 */
	private static final long serialVersionUID = 7688958035956517092L;

	/**
	 * Llave foranea para identificar la modalidad del producto
	 */
	private Long idModalidadFk;
	/**
	 * Descripcion de la modalidad: Ninguna, Campaña, Mercado Abierto, Ambas 
	 */
	private String dscModalidad;
	/**
	 * Indica si el producto tiene o cuenta con promocion de conversion Auto
	 */
	private Long flgConvAuto;
	/**
	 * Llave foranea al tipo de amortizacion: plan frances o plan aleman
	 */
	private Long idAmortizFK;
	/**
	 * ID de Mandatorio que se despliega en el simulador
	 */
	private String planMandatorio;

	/**
	 * Descripcion de condiciones de exclusion del Seguro
	 */
	private String dscExclusionSeg;
	/**
	 *ID de la plantilla de manifestación de no adeudos para el producto
	 */
	private String planAdeudo;
	/**
	 * Id de la plantilla carta compromiso de pago, de la entidad producto
	 */
	private String planPago;
	/**
	 * Propiedad descripcion de seguro
	 */
	private String dscSeguro;

	/**
	 * constructor vacio
	 */
	public SccMxMaeProductoSubProductDTO() {
		super();
	}

	/**
	 * idModalidadFk de la tabla modalidad
	 * 
	 * @return idModalidadFk Id de la modalidad
	 */
	public Long getIdModalidadFk() {
		return idModalidadFk;
	}

	/**
	 * 
	 * @param idModalidadFk Id de la modalidad
	 */
	public void setIdModalidadFk(Long idModalidadFk) {
		this.idModalidadFk = idModalidadFk;
	}

	/**
	 * dscModalidad de la tabla modalidad
	 * 
	 * @return dscModalidad Descricpión de la modalidad
	 */
	public String getDscModalidad() {
		return dscModalidad;
	}

	/**
	 * 
	 * @param dscModalidad Descricpión de la modalidad
	 */
	public void setDscModalidad(String dscModalidad) {
		this.dscModalidad = dscModalidad;
	}

	/**
	 * Obtiene la bandera de conversion auto
	 * 
	 * @return flgConvAuto Bandera de conversón auto
	 */
	public Long getFlgConvAuto() {
		return flgConvAuto;
	}

	/**
	 * Se inicializa al bandera de conversion auto
	 * 
	 * @param flgConvAuto Bandera de conversón auto
	 */
	public void setFlgConvAuto(Long flgConvAuto) {
		this.flgConvAuto = flgConvAuto;
	}

	/**
	 * Se obtiene al id del plan de amortizacion
	 * 
	 * @return idAmortizFK Id del plan de amortización
	 */
	public Long getIdAmortizFK() {
		return idAmortizFK;
	}

	/**
	 * Se inicializa el id de amortizacion
	 * 
	 * @param idAmortizFK Id del plan de amortización
	 */
	public void setIdAmortizFK(Long idAmortizFK) {
		this.idAmortizFK = idAmortizFK;
	}

	/**
	 * @return planMandatorio Nombre del plan mandatorio
	 */
	public String getPlanMandatorio() {
		return planMandatorio;
	}

	/**
	 * @param planMandatorio Nombre del plan mandatorio
	 */
	public void setPlanMandatorio(String planMandatorio) {
		this.planMandatorio = planMandatorio;
	}

	/**
	 * @return dscExclusionSeg Descripción de exclusiones del seguro
	 */
	public String getDscExclusionSeg() {
		return dscExclusionSeg;
	}

	/**
	 * @param dscExclusionSeg Descripción de exclusiones del seguro
	 */
	public void setDscExclusionSeg(String dscExclusionSeg) {
		this.dscExclusionSeg = dscExclusionSeg;
	}

	/**
	 * @return planAdeudo Nombre del plan de adeudo
	 */
	public String getPlanAdeudo() {
		return planAdeudo;
	}

	/**
	 * @param planAdeudo Nombre del plan de adeudo
	 */
	public void setPlanAdeudo(String planAdeudo) {
		this.planAdeudo = planAdeudo;
	}

	/**
	 * @return planPago Nombre del plan de pago
	 */
	public String getPlanPago() {
		return planPago;
	}

	/**
	 * @param planPago Nombre del plan de pago
	 */
	public void setPlanPago(String planPago) {
		this.planPago = planPago;
	}

	/**
	 * @return dscSeguro Descripcion del seguro
	 */
	public String getDscSeguro() {
		return dscSeguro;
	}

	/**
	 * @param dscSeguro Descripcion del seguro
	 */
	public void setDscSeguro(String dscSeguro) {
		this.dscSeguro = dscSeguro;
	}

}
