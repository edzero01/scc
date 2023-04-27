package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase para manejar la informacion de
 * condiciones financieras. Cargada por medio del shell
 * con la inforamcion de CRM
 * Generado por GlobalHitss
 * Fabrica de Software
 * Proyecto Simulador Santander
 * Mayo 2019
 * Sprint 1
 * 
 * SccMxMaeCondFinan 
 * generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_COND_FINAN")
public class SccMxMaeCondFinan implements IAbstractEntity, java.io.Serializable {


	/**
	 *  Identificador para serializar la clase
	 **/
	private static final long serialVersionUID = -6621835889560424157L;
	/**
	 *  Llave primaria de condiciones financieras 
	 **/
	private Long idCondFinanPk;
	/**
	 *  Instancia de registro de la tabla de Periodicidad 
	 **/
	private SccMxMaePeriod sccMxMaePeriod;
	/**
	 *  Instancia de registro de la tabla de productos  
	 **/
	private SccMxMaeProducto sccMxMaeProducto;
	/**
	 *  Instancia de registro de la tabla Subproductos 
	 *  se cambia por IdSubProdFk
	 */
	private Long idSubProdFk;
	/**
	 *  Porcentaje de la tasa interes Base 
	 */
	private Double porTasaIntBase;
	/**
	 * Porcentaje de la comisi_n por apertura 
	 */
	private Double porComApertura;
	/**
	 *  Porcentaje de la comisi_n por disposicion 
	 */
	private Double porComDisposicion;
	/**
	 *  anualidades 
	 **/
	private Long numAnualidad;
	/**
	 *  porcentaje del factor de seguro 
	 **/
	private Double porFactorSeg;
	/**
	 *   POrcentaje del facotr de iva para aplicar al seguro 
	 **/
	private Double porFactorIvaSeg;
	/**
	 *  porcentaje del facotr de iva 
	 **/
	private Double porFactorIva;
	/**
	 *  numero de plazos 
	 **/
	private Long numPlazo;
	/**
	 *  porccentaje del CAT 
	 **/
	private Double porCat;
	/**
	 *  descripcion comercial del producto 
	 **/
	private String dscComercial;
	/**
	 *  porcentaje del factor de monto total 
	 **/
	private Double porFacMontoTotal; 
	/** 
	 * porcentaje del factor de pago mensual 
	 */
	private Double porFacPagoMensual;
	/**
	 * costo de la caucion 
	 */
	private Long numCostoCaucion;
	/** 
	 * LImite inferior del monto base 
	 */
	private Double impLimInfMBase;
	/**
	 *  limite superior del monto base 
	 **/
	private Double impLimSupMBase; 
	/**
	 *  numero de LAPA 
	 **/
	private Long numLapa;
	/**
	 *  Indicador de comision por apertura 
	 **/
	private Long flgComAperMonto;
	/**
	 *  Indicador de comision por apertura en cashout 
	 **/
	private Long flgComAperCashout;
	/**
	 *  Indicador de comision por disposicion 
	 **/
	private Long flgComDispMonto;
	/**
	 *  indicador de comision por disposicion en cashout 
	 */
	private Long flgComDispCashout;
	/** 
	 * Monto Base para Condiciones Financieras de Linex 
	 */
	private Double montoLinex;
	/**
	 *  numero de tarjeta asociada linex 
	 **/
	private String numTarjetaLinex;

	/**
	 * Constructor vacio
	 */
	public SccMxMaeCondFinan() {
	}

	/**
	 * Constructor de Condiciones Financieras
	 * @param idCondFinanPk Id Condicion financiera
	 * @param idSubProdFk Id del Subproducto
	 * @param sccMxMaeProducto Id del producto
	 */
	public SccMxMaeCondFinan(Long idCondFinanPk, 
			                 SccMxMaeProducto sccMxMaeProducto, 
			                 Long idSubProdFk) {
		this.idCondFinanPk = idCondFinanPk;
		this.sccMxMaeProducto = sccMxMaeProducto;
		this.idSubProdFk = idSubProdFk;
	}



	@Id

	@Column(name = "ID_COND_FINAN_PK", unique = true, nullable = false, precision = 22, scale = 0)
	
	/**
	 * Inician setters y getters
	 * @return idCondFinanPk
	 * llave
	 */
	public Long getIdCondFinanPk() {
		return this.idCondFinanPk;
	}

	/**
	 * Setea la llave
	 * @param idCondFinanPk
	 * llave
	 */
	public void setIdCondFinanPk(Long idCondFinanPk) {
		this.idCondFinanPk = idCondFinanPk;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROD_FK", nullable = false)
	/**
	 * Obtiene el producto
	 * @return  sccMxMaeProducto
	 * 
	 */
	public SccMxMaeProducto getSccMxMaeProducto() {
		return this.sccMxMaeProducto;
	}

	/**
	 * Setea el objeto producto
	 * @param sccMxMaeProducto
	 * conexion con producto
	 */
	public void setSccMxMaeProducto(SccMxMaeProducto sccMxMaeProducto) {
		this.sccMxMaeProducto = sccMxMaeProducto;
	}

	@Column(name = "ID_SUB_PROD_FK", nullable = false)
	/**
	 * obtiene el subproducto
	 * @return idSubProdFk  Id del subproducto
	 */
	public Long getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * Conexion con subproducto
	 * @param idSubProdFk Id del subproducto
	 * 
	 */
	public void setIdSubProdFk(Long idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}
	@Column(name = "POR_TASA_INT_BASE", precision = 22, scale = 2)
	/**
	 * 
	 * @return porTasaIntBase
	 * 
	 */
	public Double getPorTasaIntBase() {
		return this.porTasaIntBase;
	}

	/**
	 * 
	 * @param porTasaIntBase
	 * Porcentaje de tasa interes base
	 */
	public void setPorTasaIntBase(Double porTasaIntBase) {
		this.porTasaIntBase = porTasaIntBase;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERIOD_FK")
	/**
	 * 
	 * @return sccMxMaePeriod
	 * conexion con la periodicidad
	 */
	public SccMxMaePeriod getSccMxMaePeriod() {
		return this.sccMxMaePeriod;
	}

	/**
	 * 
	 * @param sccMxMaePeriod
	 * conexion con periodicidad
	 */
	public void setSccMxMaePeriod(SccMxMaePeriod sccMxMaePeriod) {
		this.sccMxMaePeriod = sccMxMaePeriod;
	}

	@Column(name = "POR_COM_APERTURA", precision = 22, scale = 0)
	/**
	 * 
	 * @return porComApertura
	 */
	public Double getPorComApertura() {
		return this.porComApertura;
	}

	/**
	 * 
	 * @param porComApertura
	 * porcentaje de comision por apertura
	 */
	public void setPorComApertura(Double porComApertura) {
		this.porComApertura = porComApertura;
	}

	/**
	 * @return Double porComDisposicion
	 */
	@Column(name = "POR_COM_DISPOSICION", precision = 22, scale = 0)
	public Double getPorComDisposicion() {
		return this.porComDisposicion;
	}

	/**
	 *  
	 * @param porComDisposicion Double
	 * Porcentaje de comision por disposicion
	 */
	public void setPorComDisposicion(Double porComDisposicion) {
		this.porComDisposicion = porComDisposicion;
	}

	@Column(name = "NUM_ANUALIDAD", precision = 22, scale = 0)
	/**
	 * Obtiene la anualidad
	 * @return numAnualidad
	 */
	public Long getNumAnualidad() {
		return this.numAnualidad;
	}

	/**
	 * Setea la anualidad
	 * @param numAnualidad
	 * Es decir el numero de anualidad permitida
	 */
	public void setNumAnualidad(Long numAnualidad) {
		this.numAnualidad = numAnualidad;
	}

	@Column(name = "POR_FACTOR_SEG", precision = 22, scale = 0)
	/**
	 * Obtiene factor de porcentaje
	 * @return porFactorSeg
	 * Factor de porcentaje para el calculo de seguro
	 */
	public Double getPorFactorSeg() {
		return this.porFactorSeg;
	}

	/**
	 * Setea el factor de porcentaje
	 * @param porFactorSeg
	 * Factor de porcentaje para calculo de seguro
	 */
	public void setPorFactorSeg(Double porFactorSeg) {
		this.porFactorSeg = porFactorSeg;
	}

	@Column(name = "POR_FACTOR_IVA_SEG", precision = 22, scale = 0)
	/**
	 * Obtiene el factor de porcentaje de IVA para el calculo de seguro
	 * @return porFactorIvaSeg
	 * por requerimiento del seguro este factor puede cambiar y es istinto al IVA que se usa normalmente
	 */
	public Double getPorFactorIvaSeg() {
		return this.porFactorIvaSeg;
	}

	/**
	 * Setea el factor de porcentaje de iva para el calculo de seguro
	 * @param porFactorIvaSeg
	 * Este porcentaje puede ser distinto al IVA normal. al momento es cero.
	 */
	public void setPorFactorIvaSeg(Double porFactorIvaSeg) {
		this.porFactorIvaSeg = porFactorIvaSeg;
	}

	@Column(name = "POR_FACTOR_IVA", precision = 22, scale = 0)
	/**
	 * Obtiene el factor de Iva
	 * @return porFactorIva
	 * Este factor de IVA aplica para toda la app
	 */
	public Double getPorFactorIva() {
		return this.porFactorIva;
	}

	/**
	 * Obtiene el factor de iva
	 * @param porFactorIva
	 * Este factor de iva aplica para toda la app
	 */
	public void setPorFactorIva(Double porFactorIva) {
		this.porFactorIva = porFactorIva;
	}

	
	@Column(name = "NUM_PLAZO", precision = 22, scale = 0)
	/**
	 * Obtiene el plazo
	 * 
	 * @return numPlazo
	 * Entrega el numero de plazos
	 */
	public Long getNumPlazo() {
		return this.numPlazo;
	}

	/**
	 * Setea el numero de plazos
	 * @param numPlazo
	 * regresa el numero de plazos del prestamo
	 */
	public void setNumPlazo(Long numPlazo) {
		this.numPlazo = numPlazo;
	}

	/**
	 * @return Double porCat
	 */
	@Column(name = "POR_CAT", precision = 22, scale = 2)
	public Double getPorCat() {
		return this.porCat;
	}

	/**
	 * Setea el CAT
	 * @param porCat  Double
	 * el CAT aplica a el conjunto entero de el prod-subprod de este registro
	 */
	public void setPorCat(Double porCat) {
		this.porCat = porCat;
	}

	@Column(name = "DSC_COMERCIAL", length = 100)
	/**
	 * Obtiene descripcion comercial
	 * @return dscComercial
	 */
	public String getDscComercial() {
		return this.dscComercial;
	}
	
	
	/**
	 * Obtiene la descripcion comercial
	 * @param dscComercial
	 * es una descripcion del producto
	 */
	public void setDscComercial(String dscComercial) {
		this.dscComercial = dscComercial;
	}

	@Column(name = "POR_FAC_MONTO_TOTAL", precision = 22, scale = 0)
	/**
	 * Monto total
	 * @return  porFacMontoTotal
	 * Este procentaje al parecer no se ocupa
	 */
	public Double getPorFacMontoTotal() {
		return this.porFacMontoTotal;
	}

	/**
	 * Monto total
	 * @param porFacMontoTotal
	 * porcentaje para monto total que no se ocupa al momento 
	 */
	public void setPorFacMontoTotal(Double porFacMontoTotal) {
		this.porFacMontoTotal = porFacMontoTotal;
	}

	@Column(name = "POR_FAC_PAGO_MENSUAL", precision = 22, scale = 0)
	/**
	 * Porcentaje para el pago mensual
	 * @return porFacPagoMensual
	 * A la fecha tampoco se ocupa este dato
	 */
	public Double getPorFacPagoMensual() {
		return this.porFacPagoMensual;
	}
	
	
	/**
	 * A _la fecha este dato no se ocupa
	 * @param porFacPagoMensual
	 * tampoco
	 */
	public void setPorFacPagoMensual(Double porFacPagoMensual) {
		this.porFacPagoMensual = porFacPagoMensual;
	}

	@Column(name = "NUM_COSTO_CAUCION", precision = 22, scale = 0)
	/**
	 * Costo de la caucion
	 * @return numCostoCaucion
	 * Solo aplica para algunos productos/subproductos
	 */
	public Long getNumCostoCaucion() {
		return this.numCostoCaucion;
	}

	/**
	 * Solo aplica para algunos productos
	 * @param numCostoCaucion
	 * Costo de la caucion
	 */
	public void setNumCostoCaucion(Long numCostoCaucion) {
		this.numCostoCaucion = numCostoCaucion;
	}

	@Column(name = "IMP_LIM_INF_M_BASE", precision = 22, scale = 0)
	/**
	 * Indica el limite inferior
	 * @return impLimInfMBase
	 * Limite inferior para el prestamo
	 */
	public Double getImpLimInfMBase() {
		return this.impLimInfMBase;
	}

	/**
	 * Limite inferior para el prestamo
	 * @param impLimInfMBase
	 * Setea el limite inferior
	 */
	public void setImpLimInfMBase(Double impLimInfMBase) {
		this.impLimInfMBase = impLimInfMBase;
	}

	@Column(name = "IMP_LIM_SUP_M_BASE", precision = 22, scale = 0)
	/**
	 * Getter del limite superior
	 * @return impLimSupMBase
	 * Obtiene el limite superior del prestamo
	 */
	public Double getImpLimSupMBase() {
		return this.impLimSupMBase;
	}

	/**
	 * Setea el limite superior
	 * @param impLimSupMBase
	 * obtiene el limte superior del prestamo
	 */
	public void setImpLimSupMBase(Double impLimSupMBase) {
		this.impLimSupMBase = impLimSupMBase;
	}

	@Column(name = "NUM_LAPA", precision = 22, scale = 0)
	/**
	 * Obtiene la LAPA
	 * @return numLapa
	 * Improtante para relacionar con 
	 * conversion auto
	 */
	public Long getNumLapa() {
		return this.numLapa;
	}

	/**
	 * Setea la numLapa
	 * @param numLapa
	 * relacionada con convAuto
	 */
	public void setNumLapa(Long numLapa) {
		this.numLapa = numLapa;
	}

	@Column(name = "FLG_COM_APER_MONTO", precision = 22, scale = 0)
	/**
	 * Indica si hay un monto de comision por apertura
	 * @return flgComAperMonto
	 * getter
	 */
	public Long getFlgComAperMonto() {
		return this.flgComAperMonto;
	}

	/**
	 * Setter para la bandera
	 * @param flgComAperMonto
	 * que indica monto por apertura
	 */
	public void setFlgComAperMonto(Long flgComAperMonto) {
		this.flgComAperMonto = flgComAperMonto;
	}

	@Column(name = "FLG_COM_APER_CASHOUT", precision = 22, scale = 0)
	/**
	 * Al parecer este dato tampoco se ocupa
	 * @return flgComAperCashout
	 * Es una bandera por comision por apertura cashout
	 */
	public Long getFlgComAperCashout() {
		return this.flgComAperCashout;
	}

	/**
	 * al parecer este dato no se ocupa
	 * @param flgComAperCashout
	 * Es una bandera por comision por apertura cashout
	 */
	public void setFlgComAperCashout(Long flgComAperCashout) {
		this.flgComAperCashout = flgComAperCashout;
	}

	/**
	 * @return Long flgComDispMonto
	 */
	@Column(name = "FLG_COM_DISP_MONTO", precision = 22, scale = 0)
	public Long getFlgComDispMonto() {
		return this.flgComDispMonto;
	}

	/**
	 * @param flgComDispMonto Long
	 */
	public void setFlgComDispMonto(Long flgComDispMonto) {
		this.flgComDispMonto = flgComDispMonto;
	}

	/**
	 * @return Long flgComDispCashout
	 */
	@Column(name = "FLG_COM_DISP_CASHOUT", precision = 22, scale = 0)
	public Long getFlgComDispCashout() {
		return this.flgComDispCashout;
	}

	/**
	 * @param flgComDispCashout Long
	 */
	public void setFlgComDispCashout(Long flgComDispCashout) {
		this.flgComDispCashout = flgComDispCashout;
	}

	
	/**
	 * Obtener el valor del monto Linex
	 * @return montoLinex Monto LINEX
	 */
	@Transient
	public Double getMontoLinex() {
		return montoLinex;
	}

	/**
	 * Colocar el valor del monto Linex
	 * @param montoLinex Monto LINEX
	 */
	public void setMontoLinex(Double montoLinex) {
		this.montoLinex = montoLinex;
	}

	
	/**
	 * Obtiene Numero de tarjeta linex
	 * @return numTarjetaLinex Número de tarjeta LINEX
	 */
	@Transient
	public String getNumTarjetaLinex() {
		return numTarjetaLinex;
	}

	
	/**
	 * Coloca Numero de tarjeta linex
	 * @param numTarjetaLinex Número de tarjeta LINEX
	 */
	public void setNumTarjetaLinex(String numTarjetaLinex) {
		this.numTarjetaLinex = numTarjetaLinex;
	}
	
	

}