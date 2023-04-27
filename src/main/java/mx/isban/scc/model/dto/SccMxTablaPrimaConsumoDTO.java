package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO para el llenado y calculo de tabla para prima
 * devengada consumo
 * Ocupa la informacion de la tabla sccmxmaeappcartera
 * @author Christopher Espina Riveros
 *
 */
public class SccMxTablaPrimaConsumoDTO implements Serializable{
	/**
	 * serializacion del dto SccMxTablaPrimaConsumoDTO
	 */
	private static final long serialVersionUID = -5512818239352332450L;
	/**
	 * parametro fInicio del seguro
	 */
	private String fInicio;
	/**
	 * parametro fFin del seguro
	 */
	private String fFin;
	/**
	 * parametro pagoFijo indicado al contratar el credito
	 */
	private Double pagoFijo;
	/**
	 * parametro capital indicado al contratar el credito
	 */
	private Double capital;
	/**
	 * parametro intereses tasa perteneciente al contrato original del credito
	 */
	private Double intereses;
	/**
	 * parametro saldoMes Saldo mensual indicado en la tabla de cartera
	 */
	private Double saldoMes;
	/**
	 * parametro primaMensual calculada para el credito solicitado originalmente
	 */
	private Double primaMensual;
	/**
	 * parametro primaDevengar es el monto que se calcula al momento de
	 * realizar la restitucion del credito 
	 */
	private Double primaDevengar;
	
	/**
	 * Constructor vacio
	 */
	public SccMxTablaPrimaConsumoDTO() {
		super();
	}

	/**
	 * Constructor 
	 * @param fInicio
	 * fecha inicio
	 * @param fFin
	 * fecha fin
	 * @param pagoFijo
	 * pago fijo
	 * @param capital
	 * capital
	 * @param intereses
	 * intereses
	 * @param saldoMes
	 * saldo fin mes
	 * @param primaMensual
	 * prima seguro mensual
	 * @param primaDevengar
	 * prima por devengar
	 */
	public SccMxTablaPrimaConsumoDTO(String fInicio, String fFin, Double pagoFijo, Double capital, Double intereses,
			Double saldoMes, Double primaMensual, Double primaDevengar) {
		super();
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.pagoFijo = pagoFijo;
		this.capital = capital;
		this.intereses = intereses;
		this.saldoMes = saldoMes;
		this.primaMensual = primaMensual;
		this.primaDevengar = primaDevengar;
	}
	/**
	 * 
	 * @return fInici
	 * fInici
	 */
	public String getfInicio() {
		return fInicio;
	}
	/**
	 * fecha inicio
	 * @param fInicio
	 * fInici
	 */
	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}
	/**
	 * 
	 * @return fFin
	 * fFin
	 */
	public String getfFin() {
		return fFin;
	}
	/**
	 * fecha fin
	 * @param fFin
	 * fFin
	 */
	public void setfFin(String fFin) {
		this.fFin = fFin;
	}
	/**
	 * 
	 * @return pagoFijo
	 * pagoFijo
	 */
	public Double getPagoFijo() {
		return pagoFijo;
	}
	/**
	 * 
	 * @param pagoFijo
	 * pagoFijo
	 */
	public void setPagoFijo(Double pagoFijo) {
		this.pagoFijo = pagoFijo;
	}
	/**
	 * 
	 * @return capital
	 * capital
	 */
	public Double getCapital() {
		return capital;
	}
	/**
	 * 
	 * @param capital
	 * capital
	 */
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	/**
	 * 
	 * @return intereses
	 * intereses
	 */
	public Double getIntereses() {
		return intereses;
	}
	/**
	 * 
	 * @param intereses
	 * intereses
	 */
	public void setIntereses(Double intereses) {
		this.intereses = intereses;
	}
	/**
	 * 
	 * @return saldoMes
	 * saldoMes
	 */
	public Double getSaldoMes() {
		return saldoMes;
	}
	/**
	 * 
	 * @param saldoMes
	 * saldoMes
	 */
	public void setSaldoMes(Double saldoMes) {
		this.saldoMes = saldoMes;
	}
	/**
	 * 
	 * @return
	 * primaMensual
	 */
	public Double getPrimaMensual() {
		return primaMensual;
	}
	/**
	 * 
	 * @param primaMensual
	 * primaMensual
	 */
	public void setPrimaMensual(Double primaMensual) {
		this.primaMensual = primaMensual;
	}
	/**
	 * 
	 * @return
	 * primaDevengar
	 */
	public Double getPrimaDevengar() {
		return primaDevengar;
	}
	/**
	 * 
	 * @param primaDevengar
	 * primaDevengar
	 */
	public void setPrimaDevengar(Double primaDevengar) {
		this.primaDevengar = primaDevengar;
	}

}
