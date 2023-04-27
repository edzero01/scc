package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Se crea DTO auxiliar para retornar los datos
 * de Pampa con la nueva busqueda por Sucursal
 * concatenada con el Contrato
 * @author Lorena Baruch
 *
 */
public class SccMxMaePampaDTO implements Serializable {

	/**
	 * Numero Serial autogenerado
	 */
	private static final long serialVersionUID = 2144001467927879998L;

	/**
	 * Saldo del Crédito a Restituir
	 */
	private Double saldoCredito = 0.0;
		
	/**
	 * Numero de la Tarjeta de Crédito
	 */
	private String numTDC = "";
		
	/**
	 * Valor de la prima Devengada
	 */
	private Double primaDevengada = 0.0;
	

	/**
	 * Constructor vacio
	 */
	public SccMxMaePampaDTO() {
		super();
	}

	/**
	 * Relacionado con la tabla de pampa
	 * @return saldo por pagar
	 * campo imp_saldo_linex
	 */
	public Double getSaldoCredito() {
		return saldoCredito;
	}

	/**
	 * Relacionado con la tabla de pampa
	 * @return saldo por pagar
	 * campo imp_saldo_linex
	 */
	public void setSaldoCredito(Double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	/**
	 * Relacionado con la tabla de pampa
	 * @return numero de tdc
	 * campo num_tdc
	 */
	public String getNumTDC() {
		return numTDC;
	}

	/**
	 * Relacionado con la tabla de pampa
	 * @return numero de tdc
	 * campo num_tdc
	 */
	public void setNumTDC(String numTDC) {
		this.numTDC = numTDC;
	}

	/**
	 * Calculada con las utilerias
	 * @return monto de la prima devengada
	 * Obtenida por una serie de calculos para linex
	 */
	public Double getPrimaDevengada() {
		return primaDevengada;
	}

	/**
	 * Calculada con las utilerias
	 * @return monto de la prima devengada
	 * Obtenida por una serie de calculos para linex
	 */
	public void setPrimaDevengada(Double primaDevengada) {
		this.primaDevengada = primaDevengada;
	}


	

	
}
