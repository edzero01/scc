package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Se construye DTO que maneje unicamente
 * los datos que van a utilizarse para 
 * el calculo del CAT en el producto
 * Personal Select Garantia
 * 
 * Recibe la informacion de Front End.
 * Maneja utilerias para convertir el plazo, la tasa, el número de periodos al año
 * y calcular la sumatoria de los flujos
 * Julio 2019
 * Global Hitss
 * Sprint 3
 * 
 * @author Lorena Baruch
 *
 */
public class SccMxCatPSGDTO implements Serializable {

	/**
	 * serializacion del DTO SccMxTablaCatDTO
	 */
	private static final long serialVersionUID = -895123717921832135L;
	/**
	 * propiedad monto del Crédito
	 */
	private Double montoCred;

	/**
	 * propiedad Número de Pagos se calcula en Front End e indica el número de pagos de acuerdo 
	 * a la periodicidad y plazo
	 */
	private Long numPagos;
	/**
	 * propiedad Tasa de Interés TIIE + Puntos Porcentuales incluidos
	 */
	private Double tasaTIIE;
	/**
	 * propiedad Costo de la caucion, lo recibe de front end.
	 */
	private Double caucion;
	/** 
	 * propiedad Periodicidad. Es el periodo de pagos elegido desde front end
	 */
	private String periodicidad;
	/**
	 * propiedad Costo de la Comisión (ya está multiplicado el factor por monto)
	 */
	private Double comApertura;
	/**
	 * Propiedad Costo de la Comisión por Disposición (YA multiplicado el factor por monto)
	 */
	private Double comDisposicion;
	/**
	 * propiedad Costo del Seguro (ya multiplicado el factor por monto)
	 */
	private Double costoSeguro;
	/**
	 * constructor super
	 */
	public SccMxCatPSGDTO() {
		super();
	}

	/**
	 * El monto del credito es lo que se solicita en la 
	 * simulacion
	 * @return double
	 * valor del monto
	 */
	public Double getMontoCred() {
		return montoCred;
	}


	/**
	 * @param montoCred  monto del credito
	 */
	public void setMontoCred(Double montoCred) {
		this.montoCred = montoCred;
	}


	/**
	 * Metodo que devuelve el numero de pagos de un producto.
	 * @return numero de pagos
	 */
	public Long getNumPagos() {
		return numPagos;
	}


	/**
	 * Metodo que asigna el numero de pagos del producto
	 * @param numPagos numero de pagos
	 */
	public void setNumPagos(Long numPagos) {
		this.numPagos = numPagos;
	}


	/**
	 * Metodo que devuelve la tasa TIIE asignada a PSG
	 * @return tasaTIIE Tasa de la TIIE
	 */
	public Double getTasaTIIE() {
		return tasaTIIE;
	}


	/**
	 * Metodo que asigna la tasa TIIE AL PRODUCTO PSG
	 * @param tasaTIIE Tasa de la TIIE
	 */
	public void setTasaTIIE(Double tasaTIIE) {
		this.tasaTIIE = tasaTIIE;
	}


	/**
	 * Metodo que devuelve el monto de la caucion
	 * asignado desde la BD en la simulacion
	 * @return caucion 
	 */
	public Double getCaucion() {
		return caucion;
	}


	/**
	 * Metodo que asigna el monto de la caucion
	 * asignado desde BD en la simulacion
	 * @param caucion 
	 */
	public void setCaucion(Double caucion) {
		this.caucion = caucion;
	}

	/**
	 * Metodo que devuelve la periodicidad asignada
	 * al producto PSG
	 * @return periodicidad 
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * Metodo que asigna la periodicidad a PSG
	 * @param periodicidad 
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	/**
	 * Monto que devuelve el valor del factor de commisión por apertura
	 * multiplicado por el monto
	 * @return comApertura 
	 */
	public Double getComApertura() {
		return comApertura;
	}

	/**
	 * Monto que devuelve el valor del factor de commisión por apertura
	 * multiplicado por el monto
	 * @param comApertura  comision de apertura
	 */
	public void setComApertura(Double comApertura) {
		this.comApertura = comApertura;
	}

	/**
	 * Monto que devuelve el valor del factor de commisión por disposicion
	 * multiplicado por el monto
	 * @return comDisposicion comision por disposicion
	 */
	public Double getComDisposicion() {
		return comDisposicion;
	}

	/**
	 * Monto que devuelve el valor del factor de commisión por disposicion
	 * multiplicado por el monto
	 * @param comDisposicion comision por disposicion
	 */
	public void setComDisposicion(Double comDisposicion) {
		this.comDisposicion = comDisposicion;
	}

	/**
	 * @return costoSeguro costo del seguro
	 */
	public Double getCostoSeguro() {
		return costoSeguro;
	}

	/**
	 * @param costoSeguro costo del seguro
	 */
	public void setCostoSeguro(Double costoSeguro) {
		this.costoSeguro = costoSeguro;
	}

	
}
