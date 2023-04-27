package mx.isban.scc.model.dto;

/**
 * DTO para la plantilla Carátula de crédito
 * 
 * @author CJosé Luis Garcia
 * 
 *
 */
public class SccMxTablaCaratulaPadreDTO extends SccMxTablaCaratulaBaseDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaCaratulaDTO
	 */
	private static final long serialVersionUID = -5512818239352332452L;

	/**
	 * propiedad para la comision de disposicion sin iva
	 */
	protected Double comisionDisposicionSinIva;
	/**
	 * propiedad para la comision de apertura sin iva
	 */
	protected Double comisionAperturaSinIva;
	/**
	 * propiedad para el monto de seguro
	 */
	protected Double seguros;
	/**
	 * propiedad para el importe neto del credito
	 */
	protected Double importeNetoCredito;
	/**
	 * propiedad para el monto a pagar
	 */
	protected Double montoPagar;
	/**
	 * propiedad para el numero de periodos por año
	 */
	protected Integer numeroPeriodosAnio;
	/**
	 * propiedad para la comision por disposicion
	 */
	protected Double comisionPorDisposicion;
	/**
	 * propiedad para la comision por apertura
	 */
	protected Double comisionPorApertura;
	/**
	 * propiedad para el procentaje de seguros
	 */
	protected Double segurosPorcentaje;

	/**
	 * Constructor vacio
	 */
	public SccMxTablaCaratulaPadreDTO() {
		super();
	}

	/**
	 * 
	 * @return comisionDisposicionSinIva Comisión por disposición sin IVA
	 */
	public Double getComisionDisposicionSinIva() {
		return comisionDisposicionSinIva;
	}

	/**
	 * 
	 * @param comisionDisposicionSinIva Comisión por disposición sin IVA
	 */
	public void setComisionDisposicionSinIva(Double comisionDisposicionSinIva) {
		this.comisionDisposicionSinIva = comisionDisposicionSinIva;
	}

	/**
	 * 
	 * @return comisionAperturaSinIva Comisión por apertura sin IVA
	 */
	public Double getComisionAperturaSinIva() {
		return comisionAperturaSinIva;
	}

	/**
	 * 
	 * @param comisionAperturaSinIva Comisión por apertura sin IVA
	 */
	public void setComisionAperturaSinIva(Double comisionAperturaSinIva) {
		this.comisionAperturaSinIva = comisionAperturaSinIva;
	}

	/**
	 * 
	 * @return seguros Monto de los seguros
	 */
	public Double getSeguros() {
		return seguros;
	}

	/**
	 * 
	 * @param seguros Monto de los seguros
	 */
	public void setSeguros(Double seguros) {
		this.seguros = seguros;
	}

	/**
	 * 
	 * @return importeNetoCredito Importe neto del credito
	 */
	public Double getImporteNetoCredito() {
		return importeNetoCredito;
	}

	/**
	 * 
	 * @param importeNetoCredito Importe neto del credito
	 */
	public void setImporteNetoCredito(Double importeNetoCredito) {
		this.importeNetoCredito = importeNetoCredito;
	}

	/**
	 * 
	 * @return montoPagar Monto a pagar
	 */
	public Double getMontoPagar() {
		return montoPagar;
	}

	/**
	 * 
	 * @param montoPagar Monto a pagar
	 */
	public void setMontoPagar(Double montoPagar) {
		this.montoPagar = montoPagar;
	}

	/**
	 * 
	 * @return numeroPeriodosAnio Número de periodos al año
	 */
	public Integer getNumeroPeriodosAnio() {
		return numeroPeriodosAnio;
	}

	/**
	 * 
	 * @param numeroPeriodosAnio Número de periodos al año
	 */
	public void setNumeroPeriodosAnio(Integer numeroPeriodosAnio) {
		this.numeroPeriodosAnio = numeroPeriodosAnio;
	}

	/**
	 * 
	 * @return comisionPorDisposicion Valor de la comisión por disposición
	 */
	public Double getComisionPorDisposicion() {
		return comisionPorDisposicion;
	}

	/**
	 * 
	 * @param comisionPorDisposicion Valor de la comisión por disposicion
	 */
	public void setComisionPorDisposicion(Double comisionPorDisposicion) {
		this.comisionPorDisposicion = comisionPorDisposicion;
	}

	/**
	 * 
	 * @return comisionPorApertura Valor de la comisión por apertura
	 */
	public Double getComisionPorApertura() {
		return comisionPorApertura;
	}

	/**
	 * 
	 * @param comisionPorApertura Valor de la comisión por apertura
	 */
	public void setComisionPorApertura(Double comisionPorApertura) {
		this.comisionPorApertura = comisionPorApertura;
	}

	/**
	 * 
	 * @return segurosPorcentaje Porcentaje de los seguros
	 */
	public Double getSegurosPorcentaje() {
		return segurosPorcentaje;
	}

	/**
	 * 
	 * @param segurosPorcentaje Porcentaje de los seguros
	 */
	public void setSegurosPorcentaje(Double segurosPorcentaje) {
		this.segurosPorcentaje = segurosPorcentaje;
	}

}
