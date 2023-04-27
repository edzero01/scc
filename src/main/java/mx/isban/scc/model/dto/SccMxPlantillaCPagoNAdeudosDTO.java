package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO para generar información para
 * llenar plantillas de 
 * Carta Compromiso o bien el 
 * Manifestacion de No Adeudos
 * 
 * Sprint 4
 * Julio 2019
 * 
 * @author Christopher Espina Riveros
 *
 */
public class SccMxPlantillaCPagoNAdeudosDTO implements Serializable{
	/**
	 * identificador para serializar la clase SccMxPeriodoPorIdProdDTO
	 */
	private static final long serialVersionUID = 8891123910256078173L;
	/**
	 * Para identificar la plantilla que se trata: CCP o NA
	 */
	private String plantilla;
	/**
	 * Para desplegar el dato del nombre del cliente que manda el front end
	 */
	private String nomCliente;
	/**
	 * Identificacion del Monto en caso de que la plantilla ocupe la variable
	 */
	private Double monto;

	/**
	 * Informacion del numero de tarjeta que se usara en la CCP o en el NA
	 */
	private String numtarjeta;

	/**
	 * @return String plantilla
	 */
	public String getPlantilla() {
		return plantilla;
	}

	/**
	 * setter plantilla
	 * @param plantilla
	 * plantilla
	 */
	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * getter nombre cliente prom
	 * @return nomCliente
	 * nomCliente
	 */
	public String getNomCliente() {
		return nomCliente;
	}
	
	/**
	 * setter nombre cliente prom
	 * @param nomCliente
	 * nomCliente
	 */
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	/** 
	 * getter numero tarjeta
	 * @return numtarjeta
	 * numtarjeta
	 */
	public String getNumtarjeta() {
		return numtarjeta;
	}
	
	/**
	 * setter numero tarjeta
	 * @param numtarjeta
	 * numtarjeta
	 */
	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}
	
	/**
	 * @return Double monto
	 */
	public Double getMonto() {
		return monto;
	}
	
	/**
	 * @param monto Double
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
