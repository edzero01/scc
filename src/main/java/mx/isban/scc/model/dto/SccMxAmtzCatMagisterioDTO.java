package mx.isban.scc.model.dto;

/**
 * DTO para tabla de cat amortización 
 * 
 * @author Jose Luis Garcia
 * 
 *
 */
public class SccMxAmtzCatMagisterioDTO  implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxAmtzCatMagisterioDTO
	 */
	private static final long serialVersionUID = -5512818239352332452L;

	/**
	 * propiedad cat
	 */
	private Double cat;
	
	/**
	 * propiedad codigoCliente
	 */
	private Long codigoCliente;
	
	/**
	 * propiedad comisionPorApertura
	 */
	private Double comisionPorApertura;
	/**
	 * propiedad comisionPorDisposicion
	 */
	private Double comisionPorDisposicion;
	/**
	 * propiedad importeNetoCredito
	 */
	private Double importeNetoCredito;
	/**
	 * propiedad nombreCliente
	 */
	private String nombreCliente;
	/**
	 * propiedad numeroPagos
	 */
	private Long numeroPagos;
	/**
	 * propiedad periodicidad
	 */
	private String descPeriodo;
	/**
	 * propiedad plazo
	 */
	private Long plazo;
	/**
	 * propiedad seguros
	 */
	private String seguros;
	/**
	 * propiedad tasaInteresAnual
	 */
	private Double tasaInteresAnual;
	/**
	 * propiedad producto
	 */
	private String producto;

	/**
	 * Constructor vacio
	 */
	public SccMxAmtzCatMagisterioDTO() {
		super();
	}

	public Double getCat() {
		return cat;
	}

	public void setCat(Double cat) {
		this.cat = cat;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Double getComisionPorApertura() {
		return comisionPorApertura;
	}

	public void setComisionPorApertura(Double comisionPorApertura) {
		this.comisionPorApertura = comisionPorApertura;
	}

	public Double getComisionPorDisposicion() {
		return comisionPorDisposicion;
	}

	public void setComisionPorDisposicion(Double comisionPorDisposicion) {
		this.comisionPorDisposicion = comisionPorDisposicion;
	}

	public Double getImporteNetoCredito() {
		return importeNetoCredito;
	}

	public void setImporteNetoCredito(Double importeNetoCredito) {
		this.importeNetoCredito = importeNetoCredito;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Long getNumeroPagos() {
		return numeroPagos;
	}

	public void setNumeroPagos(Long numeroPagos) {
		this.numeroPagos = numeroPagos;
	}

	public Long getPlazo() {
		return plazo;
	}

	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}

	public String getSeguros() {
		return seguros;
	}

	public void setSeguros(String seguros) {
		this.seguros = seguros;
	}

	public Double getTasaInteresAnual() {
		return tasaInteresAnual;
	}

	public void setTasaInteresAnual(Double tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescPeriodo() {
		return descPeriodo;
	}

	public void setDescPeriodo(String descPeriodo) {
		this.descPeriodo = descPeriodo;
	}

	
}
