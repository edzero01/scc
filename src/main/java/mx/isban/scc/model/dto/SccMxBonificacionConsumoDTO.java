package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase para definicion de datos de calculo de bonificacion de prima
 * en caso de restitución 
 * 
 * @author Christopher Espina Riveros
 * Dado que no se ocupan todos los datos de todas las tablas se generan los DTO. 
 *
 */
public class SccMxBonificacionConsumoDTO implements Serializable{
	
	/**
	 * serializacion de la clase dto SccMxBonificacionConsumoDTO
	 */
	private static final long serialVersionUID = 828688325092604L;
	/**
	 * numero de plazo de la bonificacion
	 */
	private Long numPlazo;
	/**
	 * numero de pagos de la bonificacion
	 */
	private Long numPrdoPagos;
	/**
	 * porcentaje de tasa int de la bonificacion
	 */
	private Double numTasaInt;
	/**
	 * valor  de deuda total de la bonificacion
	 */
	private Double numDeutaTotal;
	/**
	 * fecha formal de la bonificacion
	 */
	private Date fchFormal;
	/**
	 * fecha de cancelacion formal de la bonificacion
	 */
	private Date fchCancelacion;
	
	/**
	 * Monto del seguro
	 */
	private Double numMontoSeg;
	
	/**
	 * constructor vacio
	 */
	public SccMxBonificacionConsumoDTO() {
		super();
	}

	/**
	 * Metodo para realizaar llenado de DTO
	 * SccMxBonificacionConsumoDTO
	 * @author Hitss
	 * 
	 * @param numPlazo plazo de pagos
	 * @param numPrdoPagos numero de pagos
	 * @param numTasaInt tasa
	 * @param numDeutaTotal deuta total
	 * @param fchFormal fecha de formalizacion del credito
	 * @param fchCancelacion fecha de cancelacion del credito
	 * 
	 */
	public SccMxBonificacionConsumoDTO(Long numPlazo, Long numPrdoPagos, Double numTasaInt, Double numDeutaTotal,
			Date fchFormal, Date fchCancelacion) {
		super();
		this.numPlazo = numPlazo;
		this.numPrdoPagos = numPrdoPagos;
		this.numTasaInt = numTasaInt;
		this.numDeutaTotal = numDeutaTotal;
		this.fchFormal = new Date(fchFormal.getTime());
		this.fchCancelacion = new Date(fchCancelacion.getTime());
	}

	/**
	 * obtiene el numero de plazos
	 * 
	 * @return numPlazo numero de plazos
	 */
	public Long getNumPlazo() {
		return numPlazo;
	}
	/**
	 * setea el numero de plazos
	 * 
	 * @param numPlazo numero de plazos
	 */
	public void setNumPlazo(Long numPlazo) {
		this.numPlazo = numPlazo;
	}
	/**
	 * obtniene numero de pagos
	 * 
	 * @return numPrdoPagos  numero de pago
	 */
	public Long getNumPrdoPagos() {
		return numPrdoPagos;
	}

	/**
	 * setea numPrdoPagos
	 * 
	 * @param numPrdoPagos  numero de pago
	 */
	public void setNumPrdoPagos(Long numPrdoPagos) {
		this.numPrdoPagos = numPrdoPagos;
	}

	/**
	 * obtiene tasa
	 * 
	 * @return numTasaInt tasa de interes
	 */
	public Double getNumTasaInt() {
		return numTasaInt;
	}
	/**
	 * setea tasa
	 * 
	 * @param numTasaInt tasa de interes
	 */
	public void setNumTasaInt(Double numTasaInt) {
		this.numTasaInt = numTasaInt;
	}
	/**
	 * obtiene deuda total
	 * 
	 * @return numDeutaTotal deuda total
	 */
	public Double getNumDeutaTotal() {
		return numDeutaTotal;
	}
	/**
	 * setea deuda total
	 * 
	 * @param numDeutaTotal deuda total
	 */
	public void setNumDeutaTotal(Double numDeutaTotal) {
		this.numDeutaTotal = numDeutaTotal;
	}
	/**
	 * obtiene fecha formalizacion credito
	 * 
	 * @return fchFormal fecha formalizacion credito
	 */
	public Date getFchFormal() {
		return new Date(fchFormal.getTime());
	}
	/**
	 * setea fecha formalizacion credito
	 * 
	 * @param fchFormal fecha formalizacion credito
	 */
	public void setFchFormal(Date fchFormal) {
		this.fchFormal = new Date(fchFormal.getTime());
	}
	/**
	 * obtiene fecha cancelacion credito
	 * 
	 * @return fchCancelacion fecha cancelacion credito
	 */
	public Date getFchCancelacion() {
		return new Date(fchCancelacion.getTime());
	}
	/**
	 * setea fecha cancelacion credito
	 * 
	 * @param fchCancelacion fecha cancelacion credito
	 */
	public void setFchCancelacion(Date fchCancelacion) {
		this.fchCancelacion = new Date(fchCancelacion.getTime());
	}	
	/**
	 * Devuelve el monto del seguro
	 * 
	 * @return numMontoSeg monto del seguro
	 */
	public Double getNumMontoSeg() {
		return numMontoSeg;
	}
	/**
	 * Inicializa el monto del seguro
	 * 
	 * @param numMontoSeg monto del seguro
	 */
	public void setNumMontoSeg(Double numMontoSeg) {
		this.numMontoSeg = numMontoSeg;
	}
	
}
