package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para obtener datos necesarios para calculo
 * prima devengada linex
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
public class SccMxPrimaLinexDTO implements Serializable{
	
	/**
	 * Serializacion del DTO SccMxPrimaLinexDTO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * propiedad fechaI de la entidad PAMPA
	 * Indica la fecha de inicio del seguro
	 */
	private Date fechaI;
	/**
	 * propiedad fechaF de la entidad PAMPA
	 * Indica la fecha de fin del seguro
	 */
	private Date fechaF;
	/**
	 * propiedad fechaC de la entidad PAMPA
	 * Indica la fecha de cancelacion del seguro
	 */
	private Date fechaC;
	/**
	 * propiedad pc de la entidad SccMxPrimaLinex
	 * es el monto que se ha cobrado por la prima del seguro
	 */
	private Double pc;
	
	/**
	 * constructor vacio
	 */
	public SccMxPrimaLinexDTO() {
		super();
	}
	/**
	 * constructor lleno
	 * @param fechaI
	 * fecha inicia
	 * @param fechaF
	 * fecha fnal
	 * @param fechaC
	 * fecha cancelacion
	 * @param pc
	 * prima cobrada
	 */

	public SccMxPrimaLinexDTO(Date fechaI, Date fechaF, Date fechaC, Double pc) {
		super();
		this.fechaI = new Date(fechaI.getTime());
		this.fechaF = new Date(fechaF.getTime());
		this.fechaC = new Date(fechaC.getTime());
		this.pc = pc;
	}
	/**
	 * 
	 * @return fechaI
	 * retorna fecha inicio
	 */
	public Date getFechaI() {
		return new Date(fechaI.getTime());
	}
	/**
	 * 
	 * @param fechaI
	 * set fecha inicio
	 */
	public void setFechaI(Date fechaI) {
		this.fechaI = new Date(fechaI.getTime());
	}
	/**
	 * 
	 * @return fechaF
	 * retorna fecha fin
	 */
	public Date getFechaF() {
		return new Date(fechaF.getTime());
	}
	/**
	 * 
	 * @param fechaF
	 * set fecha fin
	 */
	public void setFechaF(Date fechaF) {
		this.fechaF = new Date(fechaF.getTime());
	}
	/**
	 * 
	 * @return fechaC
	 * retorna fecha cancelacion
	 */
	public Date getFechaC() {
		return new Date(fechaC.getTime());
	}
	/**
	 * 
	 * @param fechaC
	 * set fecha cancelacion
	 */
	public void setFechaC(Date fechaC) {
		this.fechaC = new Date(fechaC.getTime());
	}
	/**
	 * 
	 * @return pc
	 * retorna prima cobrada
	 */
	public Double getPc() {
		return pc;
	}
	/**
	 * 
	 * @param pc
	 * set prima cobrada
	 */
	public void setPc(Double pc) {
		this.pc = pc;
	}
	

}
