package mx.isban.scc.model.dto;

/**
 * DTO para tabla de amortización Mayo 2019 Sprint 1
 * 
 * @author Christopher Espina
 * 
 *
 */
public class SccMxTablaAmtzInDTO extends SccMxTablaAmtzInPadreDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaAmtzInDTO
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
	 * Constructor vacio
	 */
	public SccMxTablaAmtzInDTO() {
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

}
