package mx.isban.scc.model.dto;

/**
 * DTO para tabla de amortización Mayo 2019 Sprint 1
 * Contiene la informacion de las columnas que se 
 * desplegaran en el documento de tabla de amortizacion
 * de la simulacion
 * 
 * @author Christopher Espina
 * 
 *
 */
public class SccMxTablaAmtzInBaseDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaAmtzInDTO
	 */
	private static final long serialVersionUID = -5512818239352332452L;
	/**
	 * propiedad para el nombre del cliente
	 */
	protected String nombreCliente;
	/**
	 * propiedad para el codigo del cliente
	 */
	protected Integer codigoCliente;
	/**
	 * propiedad para el valor del credito, monto solicitado
	 */
	protected Double valorCredito;
	/**
	 * propiedad para la periodicidad elegida por el usuario
	 */
	protected String periodicidad;
	/**
	 * propiedad para el codigo de la periodicidad
	 */
	protected String periodicidadCodigo;
	/**
	 * propiedad para el plazo al que se aplica el credito
	 */
	protected Integer plazo;
	/**
	 * propiedad para la tasa de interes anual
	 */
	protected Double tasaInteresAnual;
	/**
	 * propiedad para la tasa de interes por periodo
	 */
	protected Double tasaInteresPeriodo;
	/**
	 * propiedad para el numero de pagos calculado en base al plazo y periodicidad
	 */
	protected Integer numeroPagos;
	/**
	 * propiedad para el cat (costo anual total) del credito
	 */
	protected Double cat;

	/**
	 * Constructor vacio
	 */
	public SccMxTablaAmtzInBaseDTO() {
		super();
	}

	/**
	 * 
	 * @return nombreCliente Nombre de cliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * 
	 * @param nombreCliente Nombre de cliente
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * 
	 * @return codigoCliente Código de cliente
	 */
	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * 
	 * @param codigoCliente Código de cliente
	 */
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * 
	 * @return valorCredito Valor del credito
	 */
	public Double getValorCredito() {
		return valorCredito;
	}

	/**
	 * 
	 * @param valorCredito Valor del credito
	 */
	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	/**
	 * 
	 * @return periodicidad Descripción de la periodicidad
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * 
	 * @param periodicidad Descripción de la periodicidad
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	/**
	 * 
	 * @return periodicidadCodigo Código de la periodicidad
	 */
	public String getPeriodicidadCodigo() {
		return periodicidadCodigo;
	}

	/**
	 * 
	 * @param periodicidadCodigo Código de la periodicidad
	 */
	public void setPeriodicidadCodigo(String periodicidadCodigo) {
		this.periodicidadCodigo = periodicidadCodigo;
	}

	/**
	 * 
	 * @return plazo plazo del crédito
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * 
	 * @param plazo plazo del crédito
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * 
	 * @return tasaInteresAnual Tasa de interes anual
	 */
	public Double getTasaInteresAnual() {
		return tasaInteresAnual;
	}

	/**
	 * 
	 * @param tasaInteresAnual Tasa de interes anual
	 */
	public void setTasaInteresAnual(Double tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
	}

	/**
	 * 
	 * @return tasaInteresPeriodo Tasa de interes periodo
	 */
	public Double getTasaInteresPeriodo() {
		return tasaInteresPeriodo;
	}

	/**
	 * 
	 * @param tasaInteresPeriodo Tasa de interes periodo
	 */
	public void setTasaInteresPeriodo(Double tasaInteresPeriodo) {
		this.tasaInteresPeriodo = tasaInteresPeriodo;
	}

	/**
	 * 
	 * @return numeroPagos Número de pagos
	 */
	public Integer getNumeroPagos() {
		return numeroPagos;
	}

	/**
	 * 
	 * @param numeroPagos Número de pagos
	 */
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
	}

	/**
	 * 
	 * @return cat Costo Anual Total
	 */
	public Double getCat() {
		return cat;
	}

	/**
	 * 
	 * @param cat Costo Anual Total
	 */
	public void setCat(Double cat) {
		this.cat = cat;
	}

}
