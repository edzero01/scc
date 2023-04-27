package mx.isban.scc.model.dto;

/**
 * DTO para la plantilla Carátula de crédito
 * 
 * @author José Luis Garcia
 * 
 */

public class SccMxTablaCaratulaValorDTO extends SccMxTablaCaratulaValorPadreDTO implements java.io.Serializable {

	/**
	 * identificador para serializar la clase SccMxTablaAmtzValorDTO
	 */
	private static final long serialVersionUID = -5363284277518597744L;

	/**
	 * propiedad para el saldo de capital
	 */
	private Double saldoDeCapital;
	/**
	 * propiedad para el pago anticipado
	 */
	private Double pagoAnticipado;
	/**
	 * propiedad para la cuota
	 */
	private Double cuota;
	/**
	 * propiedad para los flujos
	 */
	private Double flujos;
	/**
	 * propiedad para los seguros
	 */
	private Double seguros;

	/**
	 * 
	 * @return saldo de capital
	 */
	public Double getSaldoDeCapital() {
		return saldoDeCapital;
	}

	/**
	 * 
	 * @param saldoDeCapital valor del saldo de capital
	 */
	public void setSaldoDeCapital(Double saldoDeCapital) {
		this.saldoDeCapital = saldoDeCapital;
	}

	/**
	 * 
	 * @return pago anticipado
	 */
	public Double getPagoAnticipado() {
		return pagoAnticipado;
	}

	/**
	 * 
	 * @param pagoAnticipado valor del pago que se da como adelanto
	 */
	public void setPagoAnticipado(Double pagoAnticipado) {
		this.pagoAnticipado = pagoAnticipado;
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
	 * @param cuota valor de cuota
	 */
	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	/**
	 * 
	 * @return flujos
	 */
	public Double getFlujos() {
		return flujos;
	}

	/**
	 * 
	 * @param flujos valor de los flujos
	 */
	public void setFlujos(Double flujos) {
		this.flujos = flujos;
	}

	/**
	 * 
	 * @return seguros
	 */
	public Double getSeguros() {
		return seguros;
	}

	/**
	 * 
	 * @param seguros valor de los seguros
	 */
	public void setSeguros(Double seguros) {
		this.seguros = seguros;
	}

}
