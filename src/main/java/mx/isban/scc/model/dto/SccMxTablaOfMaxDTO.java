package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Dto de tabla de ofertas máximas
 * para tabla de ofertas maximas desplegada
 * en la simulacion de campañas
 * Mayo 2019
 * Sprint 1
 * @author baruchlw
 * 
 */

public class SccMxTablaOfMaxDTO implements Serializable{


	/**
	 * Serializacion para transportar la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Numero de meses utilizado como plazo para el pago
	 */
	private Long numPlazos;
	/**
	 * Monto del credito permitido para estos plazos
	 */
	private Double impMonto;
	/**
	 * Porcentaje de la tasa que aplica para este plazo y monto
	 */
	private Double porTasa;

	/**
	 * constructor vacio
	 */
	public SccMxTablaOfMaxDTO() {
		super();
	}

	/**
	 * @return Long impMonto
	 */
	public Long getNumPlazos() {
		return numPlazos;
	}

	/**
	 * @param numPlazos Long
	 */
	public void setNumPlazos(Long numPlazos) {
		this.numPlazos = numPlazos;
	}

	/**
	 * @return Double impMonto
	 */
	public Double getImpMonto() {
		return impMonto;
	}

	/**
	 * @param impMonto Double
	 */
	public void setImpMonto(Double impMonto) {
		this.impMonto = impMonto;
	}

	/**
	 * @return Double porTasa
	 */
	public Double getPorTasa() {
		return porTasa;
	}

	/**
	 * @param porTasa Double
	 */
	public void setPorTasa(Double porTasa) {
		this.porTasa = porTasa;
	}


}
