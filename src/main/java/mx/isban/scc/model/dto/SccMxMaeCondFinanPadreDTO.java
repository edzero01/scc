package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para obtener la información de condiciones financieras OBJETO QUE
 * PERMITIRÁ CONOCER LA INFORMACION COMPLETA DE LAS CONDICIONES FINANCIERAS PARA
 * LA SIMULACION DE LINEX O CONSUMO UTILIZA LA TABLA scc_mx_mae-cond_finan
 * 
 * @author Alexis Cedillo Mayo 2019 Sprint 1
 *
 */
public class SccMxMaeCondFinanPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeCondFinanDTO
	 */
	private static final long serialVersionUID = -2149616196884409096L;
	/**
	 * Propiedad idSubProdPk de la entidad subproducto
	 */
	protected Long idSubProdPk;
	/**
	 * Propiedad porTasaIntBase de la entidad condiciones financieras pORCENTAJE DE
	 * LA TASA BASE DE INTERÉS
	 */
	protected Double porTasaIntBase;
	/**
	 * Lista de plazos de la entidad condiciones financieras
	 */
	private List<Long> plazo;
	/**
	 * Propiedad porComApertura de la entidad condiciones financieras PORCENTAJE QUE
	 * SE VA A COBRAR DE COMISION DE APERTURA
	 */
	protected Double porComApertura;
	/**
	 * Porcentaje que se va a cobrar para la comision por disposicion
	 */
	protected Double porComDisposicion;
	/**
	 * NumAnualidad indica numero de anualidades que puede aplicarse. No se ocupa en Simulador
	 */
	protected Long numAnualidad;
	/**
	 * Porcentaje que se cobrara como factor del Seguro
	 */
	protected Double porFactorSeg;
	/**
	 * Porcentaje de IVA al Factor de Seguro. 
	 */
	protected Double porFactorIvaSeg;
	/**
	 * Porcentaje de IVA que aplica a cualquier otro cálculo que no sea el Seguro
	 */
	protected Double porFactorIva;
	/**
	 * Porcentaje que se aplica al Monto, para calcular el valor del monto total
	 */
	protected Double porFacMontoTotal;

	/**
	 * 
	 * @return porComApertura porcentaje de comisión por apertura
	 */
	public Double getPorComApertura() {
		return porComApertura;
	}

	/**
	 * 
	 * @param porComApertura porcentaje de comisión por apertura
	 */
	public void setPorComApertura(Double porComApertura) {
		this.porComApertura = porComApertura;
	}

	/**
	 * 
	 * @return porComDisposicion porcentaje de comisión por disposición
	 */
	public Double getPorComDisposicion() {
		return porComDisposicion;
	}

	/**
	 * 
	 * @param porComDisposicion porcentaje de comisión por disposición
	 */
	public void setPorComDisposicion(Double porComDisposicion) {
		this.porComDisposicion = porComDisposicion;
	}

	/**
	 * 
	 * @return numAnualidad Número de anualidad
	 */
	public Long getNumAnualidad() {
		return numAnualidad;
	}

	/**
	 * 
	 * @param numAnualidad Número de anualidad
	 */
	public void setNumAnualidad(Long numAnualidad) {
		this.numAnualidad = numAnualidad;
	}

	/**
	 * 
	 * @return porFactorSeg porcentaje del factor de cobro de seguro
	 */
	public Double getPorFactorSeg() {
		return porFactorSeg;
	}

	/**
	 * 
	 * @param porFactorSeg porcentaje del factor de cobro de seguro
	 */
	public void setPorFactorSeg(Double porFactorSeg) {
		this.porFactorSeg = porFactorSeg;
	}

	/**
	 * 
	 * @return porFactorIvaSeg porcentaje del factor de iva para cobro de seguro
	 */
	public Double getPorFactorIvaSeg() {
		return porFactorIvaSeg;
	}

	/**
	 * 
	 * @param porFactorIvaSeg porcentaje del factor de iva para cobro de seguro
	 */
	public void setPorFactorIvaSeg(Double porFactorIvaSeg) {
		this.porFactorIvaSeg = porFactorIvaSeg;
	}

	/**
	 * 
	 * @return porFactorIva porcentaje de factor de iva
	 */
	public Double getPorFactorIva() {
		return porFactorIva;
	}

	/**
	 * 
	 * @param porFactorIva porcentaje del factor de iva
	 */
	public void setPorFactorIva(Double porFactorIva) {
		this.porFactorIva = porFactorIva;
	}

	/**
	 * 
	 * @return porFacMontoTotal porcentaje de monto total
	 */
	public Double getPorFacMontoTotal() {
		return porFacMontoTotal;
	}

	/**
	 * 
	 * @param porFacMontoTotal porcentaje del monto total
	 */
	public void setPorFacMontoTotal(Double porFacMontoTotal) {
		this.porFacMontoTotal = porFacMontoTotal;
	}

	/**
	 * 
	 * @return idSubProdPk Id de subproducto
	 */
	public Long getIdSubProdPk() {
		return idSubProdPk;
	}

	/**
	 * 
	 * @param idSubProdPk Id de subproducto
	 */
	public void setIdSubProdPk(Long idSubProdPk) {
		this.idSubProdPk = idSubProdPk;
	}

	/**
	 * 
	 * @return porTasaIntBase tasa de interes base
	 */
	public Double getPorTasaIntBase() {
		return porTasaIntBase;
	}

	/**
	 * 
	 * @param porTasaIntBase tasa de interes base
	 */
	public void setPorTasaIntBase(Double porTasaIntBase) {
		this.porTasaIntBase = porTasaIntBase;
	}

	/**
	 * Metodo para agregar un plazo al arreglo de plazos
	 * 
	 * @param lPlazo plazo a agregar al arreglo de plazos
	 */
	public void addPlazo(long lPlazo) {
		if (this.plazo == null) {
			this.plazo = new ArrayList<>();
		}
		this.plazo.add(lPlazo);
	}

	/**
	 * 
	 * @return plazo lista de plazos definidos
	 */
	public List<Long> getPlazo() {
		return new ArrayList<>(plazo);
	}

	/**
	 * 
	 * @param plazo lista de plazos definidos
	 */
	public void setPlazo(List<Long> plazo) {
		this.plazo = new ArrayList<>(plazo);
	}

}
