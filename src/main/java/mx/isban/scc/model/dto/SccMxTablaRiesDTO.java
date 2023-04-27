package mx.isban.scc.model.dto;

/**
 * DTO para plantilla Ries139
 * 
 * @author José Luis Garcia
 * 
 *
 */
public class SccMxTablaRiesDTO extends SccMxTablaRiesPadreDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaRiesDTO
	 */
	private static final long serialVersionUID = -5512818239352332452L;

	/**
	 * propiedad para el numero de pagos sin skip
	 */
	private Integer numeroPagosSinSkip;
	/**
	 * propiedad para el plazo meses sin skip
	 */
	private Integer plazoMesesSinSkip;
	/**
	 * propiedad para el factor de seguro
	 */
	private Double factorSeguro;
	/**
	 * propiedad para el costo de la Caucion
	 */
	private Double caucion;
	/**
	 * propiedad producto para el factor de seguro
	 */
	private String producto;
	/**
	 * propiedad puntos tiie, estos puntos pueden venir en factor de 100 por lo que en front end
	 * se aplica el calculo (puntos/100) para restarlos a la tasa base cuando aplica
	 */
	private Integer puntos;
	
	/**
	 * Tipo de tabla: normal, Oferta promocional o conversion auto 
	 */
	private Integer tipoOferta;
	
	
	/**
	 * Descripción de la periodicidad
	 */
	private String descPeriodo; 
	
	/**
	 * propiedad sucursal
	 */
	private Integer sucursal;
	
	/**
	 * propiedad numero de cuenta
	 */
	private Long noCuenta;
	
	/**
	 * Descripción modalidad
	 */
	private String modalidad; 
	
	/**
	 * Descripción forma de pago
	 */
	private String formaPago; 
	
	/**
	 * Descripción subproducto
	 */
	private String subproducto; 
	
	/**
	 * propiedad saldo a restituir
	 */
	private String saldoRes;
	
	/**
	 * propiedad cuota
	 */
	private Double cuota;
	
	/**
	 * Constructor vacio
	 */
	public SccMxTablaRiesDTO() {
		super();
	}

	/**
	 * 
	 * @return producto Nombre del producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * 
	 * @param producto Nombre del producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * 
	 * @return numeroPagosSinSkip Número de pagos sin gracia
	 */
	public Integer getNumeroPagosSinSkip() {
		return numeroPagosSinSkip;
	}

	/**
	 * 
	 * @param numeroPagosSinSkip Número de pagos sin gracia
	 */
	public void setNumeroPagosSinSkip(Integer numeroPagosSinSkip) {
		this.numeroPagosSinSkip = numeroPagosSinSkip;
	}

	/**
	 * 
	 * @return plazoMesesSinSkip Meses de Plazo sin gracia
	 */
	public Integer getPlazoMesesSinSkip() {
		return plazoMesesSinSkip;
	}

	/**
	 * 
	 * @param plazoMesesSinSkip Meses de Plazo sin gracia
	 */
	public void setPlazoMesesSinSkip(Integer plazoMesesSinSkip) {
		this.plazoMesesSinSkip = plazoMesesSinSkip;
	}

	/**
	 * 
	 * @return factorSeguro Factor de cobro de seguro
	 */
	public Double getFactorSeguro() {
		return factorSeguro;
	}

	/**
	 * 
	 * @param factorSeguro Factor de cobro de seguro
	 */
	public void setFactorSeguro(Double factorSeguro) {
		this.factorSeguro = factorSeguro;
	}

	/**
	 * @return caucion Monto de la caución valor de la caucion
	 */
	public Double getCaucion() {
		return caucion;
	}

	/**
	 * @param caucion Monto de la caución
	 */
	public void setCaucion(Double caucion) {
		this.caucion = caucion;
	}

	/**
	 * getter puntos
	 * 
	 * @return puntos puntos
	 */
	public Integer getPuntos() {
		return puntos;
	}

	/**
	 * setter puntos
	 * 
	 * @param puntos puntos
	 */
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	/**
	 * Obtiene el tipo de oferta de la tabla de amortización
	 * @return Integer con el tipo de oferta
	 */
	public Integer getTipoOferta() {
		return tipoOferta;
	}
	/**
	 * Inicializa  el tipo de oferta de la tabla de amortización
	 * @param tipoOferta Integer con el tipo de oferta
	 */
	public void setTipoOferta(Integer tipoOferta) {
		this.tipoOferta = tipoOferta;
	}
	
	/**
	 * Obtiene la descripcion de la periodicidad
	 * @return puede ser "Mensual", "quincenal" etc
	 */
	public String getDescPeriodo() {
		return descPeriodo;
	}
	
	/**
	 * La descripcion de periodicidad corresponde
	 * a lo que el usuario mando en el catalogo de periodiciades
	 * @param descPeriodo 
	 * "Mensual," quincenal, etc
	 */
	public void setDescPeriodo(String descPeriodo) {
		this.descPeriodo = descPeriodo;
	}
	
	/**
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	
	/**
	 * @return numero de cuenta
	 */
	public Long getNoCuenta() {
		return noCuenta;
	}

	/**
	 * @param numero de cuenta
	 */
	public void setNoCuenta(Long noCuenta) {
		this.noCuenta = noCuenta;
	}

	
	/**
	 * 
	 * @return modalidad
	 */
	public String getModalidad() {
		return modalidad;
	}

	/**
	 * 
	 * @param modalidad
	 */
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	
	/**
	 * 
	 * @return forma de pago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * 
	 * @param forma de pago
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	/**
	 * 
	 * @return subproducto
	 */
	public String getSubproducto() {
		return subproducto;
	}

	/**
	 * 
	 * @param subproducto
	 */
	public void setSubproducto(String subproducto) {
		this.subproducto = subproducto;
	}
	
	/**
	 * 
	 * @return saldo a restituir
	 */
	public String getSaldoRes() {
		return saldoRes;
	}

	/**
	 * 
	 * @param saldo a restituir
	 */
	public void setSaldoRes(String saldoRes) {
		this.saldoRes = saldoRes;
	}
	
	/**
	 * 
	 * @return cuota
	 */
	public Double getCuota() {
		return cuota;
	}

	/**
	 * 
	 * @param cuota
	 */
	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}
	
	
}
