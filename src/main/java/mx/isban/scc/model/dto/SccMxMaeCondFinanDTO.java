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
public class SccMxMaeCondFinanDTO extends SccMxMaeCondFinanPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeCondFinanDTO
	 */
	private static final long serialVersionUID = -2149616196884409096L;

	/**
	 * Propiedad porFacPagoMensual de la entidad condiciones financieras
	 */
	private Double porFacPagoMensual;
	/**
	 * Indica el Limite Inferior base para el monto a solicitar
	 */
	private Double impLimInfMBase;
	/**
	 * Indica el Limite Superior para el monto a solicitar
	 */
	private Double impLimSupMBase;
	/**
	 * Indica el valor del porcentaje de CAT para esta condición financiera
	 */
	private List<Double> porCat;

	/**
	 * Es el valor para el costo de la caucion en caso de que aplique para personal select garantia
	 */
	private Long numCostoCaucion;
	/**
	 * Indica si va a aplicar comision por apertura al monto solicitado
	 **/
	private Long flgComAperMonto;
	/**
	 * Indica si va a aplicar el método Cashout (Monto menos saldo * comision) para comision por apertura
	 **/
	private Long flgComAperCashout;
	/**
	 * Indica si va a aplicar comision por disposicion al monto solicitado
	 **/
	private Long flgComDispMonto;
	/**
	 * Indica si va a aplicar el método Cashout (Monto menos saldo * comision) para comision por disposicion
	 */
	private Long flgComDispCashout;

	/**
	 * @return flgComAperMonto Indicador de comision por apertura
	 */
	public Long getFlgComAperMonto() {
		return flgComAperMonto;
	}

	/**
	 * @param flgComAperMonto Indicador de comision por apertura
	 */
	public void setFlgComAperMonto(Long flgComAperMonto) {
		this.flgComAperMonto = flgComAperMonto;
	}

	/**
	 * @return flgComAperCashout Indicador de comision por apertura en cashout
	 */
	public Long getFlgComAperCashout() {
		return flgComAperCashout;
	}

	/**
	 * @param flgComAperCashout Indicador de comision por apertura en cashout
	 */
	public void setFlgComAperCashout(Long flgComAperCashout) {
		this.flgComAperCashout = flgComAperCashout;
	}

	/**
	 * @return flgComDispMonto Indicador de comision por disposicion
	 */
	public Long getFlgComDispMonto() {
		return flgComDispMonto;
	}

	/**
	 * @param flgComDispMonto Indicador de comision por disposicion
	 */
	public void setFlgComDispMonto(Long flgComDispMonto) {
		this.flgComDispMonto = flgComDispMonto;
	}

	/**
	 * @return flgComDispCashout indicador de comision por disposicion en cashout
	 */
	public Long getFlgComDispCashout() {
		return flgComDispCashout;
	}

	/**
	 * @param flgComDispCashout indicador de comision por disposicion en cashout
	 */
	public void setFlgComDispCashout(Long flgComDispCashout) {
		this.flgComDispCashout = flgComDispCashout;
	}

	/**
	 * Metodo que agrega un CAT al arreglo de CAT's
	 * 
	 * @param lCat Costo Anual Total
	 */
	public void addCat(Double lCat) {
		if (this.porCat == null) {
			this.porCat = new ArrayList<>();
		}
		this.porCat.add(lCat);
	}

	/**
	 * 
	 * @return porCat porcentaje de Costo Anual Total
	 */
	public List<Double> getPorCat() {
		return new ArrayList<>(porCat);
	}

	/**
	 * 
	 * @param porCat Arreglo de Lista de CAT's
	 */
	public void setPorCat(List<Double> porCat) {
		this.porCat = new ArrayList<>(porCat);
	}

	/**
	 * 
	 * @return porFacPagoMensual porcentaje de pago mensual
	 */
	public Double getPorFacPagoMensual() {
		return porFacPagoMensual;
	}

	/**
	 * 
	 * @param porFacPagoMensual porcentaje para el pago mensual
	 */
	public void setPorFacPagoMensual(Double porFacPagoMensual) {
		this.porFacPagoMensual = porFacPagoMensual;
	}

	/**
	 * 
	 * @return impLimInfMBase Importe del limite inferior para el calculo
	 */
	public Double getImpLimInfMBase() {
		return impLimInfMBase;
	}

	/**
	 * 
	 * @param impLimInfMBase Importe del limite inferior para el calculo
	 */
	public void setImpLimInfMBase(Double impLimInfMBase) {
		this.impLimInfMBase = impLimInfMBase;
	}

	/**
	 * 
	 * @return impLimSupMBase importe del limite superior para el calculo
	 */
	public Double getImpLimSupMBase() {
		return impLimSupMBase;
	}

	/**
	 * 
	 * @param impLimSupMBase importe del limite superior para el calculo
	 */
	public void setImpLimSupMBase(Double impLimSupMBase) {
		this.impLimSupMBase = impLimSupMBase;
	}

	/**
	 * Devuelve el valor del num costo caucion de la entidad condiciones financieras
	 * 
	 * @return Long numCostoCaucion costo de la caución
	 */
	public Long getNumCostoCaucion() {
		return numCostoCaucion;
	}

	/**
	 * Coloca el num costo caucion de la entidad condiciones financieras
	 * 
	 * @param numCostoCaucion costo de la caución
	 */
	public void setNumCostoCaucion(Long numCostoCaucion) {
		this.numCostoCaucion = numCostoCaucion;
	}

}
