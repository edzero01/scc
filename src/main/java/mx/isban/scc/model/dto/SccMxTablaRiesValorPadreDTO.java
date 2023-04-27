package mx.isban.scc.model.dto;

/**
 * DTO para los cálculos Ries139
 * 
 * @author José Luis Garcia
 * 
 */

public class SccMxTablaRiesValorPadreDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaAmtzValorDTO
	 */
	private static final long serialVersionUID = -5363284277518597744L;
	/**
	 * propiedad para el numero de pagos
	 */
	protected Integer numeroPagos;
	/**
	 * propiedad para el capital
	 */
	protected Double capital;
	/**
	 * propiedad para los intereses
	 */
	protected Double intereses;
	/**
	 * propiedad para el pago fijo
	 */
	protected Double pagoFijo;
	/**
	 * propiedad para el iva de interes
	 */
	protected Double ivaDeIntereses;
	/**
	 * propiedad para el pago total
	 */
	protected Double pagoTotal;

	/**
	 * 
	 * @return numero de pagos
	 */
	public Integer getNumeroPagos() {
		return numeroPagos;
	}

	/**
	 * 
	 * @param numeroPagos Pagos
	 */
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
	}

	/**
	 * 
	 * @return capital
	 */
	public Double getCapital() {
		return capital;
	}

	/**
	 * 
	 * @param capital dinero que se presta
	 */
	public void setCapital(Double capital) {
		this.capital = capital;
	}

	/**
	 * 
	 * @return intereses
	 */
	public Double getIntereses() {
		return intereses;
	}

	/**
	 * 
	 * @param intereses factor d eintereses
	 */
	public void setIntereses(Double intereses) {
		this.intereses = intereses;
	}

	/**
	 * 
	 * @return pago fijo
	 */
	public Double getPagoFijo() {
		return pagoFijo;
	}

	/**
	 * 
	 * @param pagoFijo pago a realizar fijio
	 */
	public void setPagoFijo(Double pagoFijo) {
		this.pagoFijo = pagoFijo;
	}

	/**
	 * 
	 * @return iva de intereses
	 */
	public Double getIvaDeIntereses() {
		return ivaDeIntereses;
	}

	/**
	 * 
	 * @param ivaDeIntereses Iva para los intereses
	 */
	public void setIvaDeIntereses(Double ivaDeIntereses) {
		this.ivaDeIntereses = ivaDeIntereses;
	}

	/**
	 * 
	 * @return pago total
	 */
	public Double getPagoTotal() {
		return pagoTotal;
	}

	/**
	 * 
	 * @param pagoTotal Pago total del credito
	 */
	public void setPagoTotal(Double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

}
