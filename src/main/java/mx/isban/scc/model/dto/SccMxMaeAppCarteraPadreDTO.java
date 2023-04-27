package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase para definici&oacute;n de datos de Cartera
 * 
 * @author Hitss
 *
 *         Julio 2019
 */
public class SccMxMaeAppCarteraPadreDTO implements Serializable {

	/**
	 * Serializacion de la clase SccMxMaeAppCarteraDTO
	 */
	private static final long serialVersionUID = 3336523569620347197L;
	/**
	 * propiedad numPlazo del plazo del cr&eacute;dito
	 */
	protected Long numPlazo;
	/**
	 * propiedad numPrdoPagos numero de pagos del cr&eacute;dito
	 */
	protected Long numPrdoPagos;
	/**
	 * propiedad numTasaInt corresponde a la tasa de interes del cr&eacute;dito
	 */
	protected Double numTasaInt;
	/**
	 * propiedad numDeudaTotal deuda total del cr&eacute;dito
	 */
	protected Double numDeudaTotal;
	/**
	 * propiedad numMontoSeg monto del seguro
	 */
	protected Double numMontoSeg;
	/**
	 * propiedad fchFormal de la entidad SccMxMaeAppCartera
	 */
	protected Date fchFormal;

	/**
	 * Regresa el plazo del credito
	 * 
	 * @return numPlazo plazo del credito
	 */
	public Long getNumPlazo() {
		return numPlazo;
	}

	/**
	 * Inicializa el plazo del credito
	 * 
	 * @param numPlazo plazo del credito
	 */
	public void setNumPlazo(Long numPlazo) {
		this.numPlazo = numPlazo;
	}

	/**
	 * Regresa en periodo de pago del credito
	 * 
	 * @return numPrdoPagos periodo de pago del credito
	 */
	public Long getNumPrdoPagos() {
		return numPrdoPagos;
	}

	/**
	 * Inicializa el periodo de pago del creito
	 * 
	 * @param numPrdoPagos periodo de pago del credito
	 */
	public void setNumPrdoPagos(Long numPrdoPagos) {
		this.numPrdoPagos = numPrdoPagos;
	}

	/**
	 * Regresa la tasa del credito
	 * 
	 * @return numTasaInt tasa del credito
	 */
	public Double getNumTasaInt() {
		return numTasaInt;
	}

	/**
	 * Inicializa la tasa del credito
	 * 
	 * @param numTasaInt tasa del credito
	 */
	public void setNumTasaInt(Double numTasaInt) {
		this.numTasaInt = numTasaInt;
	}

	/**
	 * Regresa el total de la deuda del credito
	 * 
	 * @return numDeudaTotal deuda total del credito
	 */
	public Double getNumDeudaTotal() {
		return numDeudaTotal;
	}

	/**
	 * Inicializa el total de deuda del credito
	 * 
	 * @param numDeudaTotal deuda total del credito
	 */
	public void setNumDeudaTotal(Double numDeudaTotal) {
		this.numDeudaTotal = numDeudaTotal;
	}

	/**
	 * Regresa en monto del seguro del cr&eacute;dito
	 * 
	 * @return numMontoSeg monto del seguro del cr&eacute;dito
	 */
	public Double getNumMontoSeg() {
		return numMontoSeg;
	}

	/**
	 * Inicializa el monto del seguro del cr&eacute;dito
	 * 
	 * @param numMontoSeg monto del seguro del cr&eacute;dito
	 */
	public void setNumMontoSeg(Double numMontoSeg) {
		this.numMontoSeg = numMontoSeg;
	}

	/**
	 * Devuelve la fecha de formalizacion del credito
	 * 
	 * @return fchFormal fecha de formalizacion del credito
	 */
	public Date getFchFormal() {
		return new Date(fchFormal.getTime());
	}

	/**
	 * Inicializa la fecha de formalizacion del seguro
	 * 
	 * @param fchFormal fecha de formalizacion del credito
	 */
	public void setFchFormal(Date fchFormal) {
		this.fchFormal = new Date(fchFormal.getTime());
	}

}
