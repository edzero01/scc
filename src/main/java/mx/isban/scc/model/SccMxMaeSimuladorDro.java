package mx.isban.scc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import mx.isban.scc.utilerias.ValidaNull;

/**
 * Clase de entidad de la tabla 
 * que guarda  
 * el historico de las simulaciones
 *  realizadas
 * en el sistema.
 * Las simulaciones solo se guardan cuando el operador
 * da clic en el boton "Guardar" de Front End.
 * @author Hitss
 * Sprints 4-6
 * Junio- Octubre 2019
 *
 */
@Entity
@Table(name = "SCC_MX_MAE_SIMULADOR_DRO")
public class SccMxMaeSimuladorDro implements IAbstractEntity, java.io.Serializable {
	@Transient
	/**
	 * Clase de utileria para validacion de nulos
	 */
	public static final ValidaNull oValidaNull = new ValidaNull();
	/**
	 * serializacion de la clase
	 */
	private static final long serialVersionUID = -8867174156895638655L;

	@Id
	@Column(name = "ID_SIMUL_PK")
	/**
	 * Llave primaria para identificar el reporte
	 */
	private Long idSimuladorPk;

	@ManyToOne
	@JoinColumn(name = "ID_PERFIL_FK")
	/**
	 * Llave secundaria para identificar el perfil con el que se grabo la simulacion
	 */
	private SccMxMaePerfiles idPerfilFk;

	@ManyToOne
	@JoinColumn(name = "ID_USR_FK")
	/**
	 * Llave foranea para identificar el usuario. NO se ocupa por no activarse la tokenizacion
	 */
	private SccMxMaeTipoUsr idUsrFk;

	@ManyToOne
	@JoinColumn(name = "ID_MVO_RECHAZO_FK")
	/**
	 * Llave foranea para el registro de motivo de rechazo elegido
	 */
	private SccMxMaeMvosRechazo idMvoRechazoFk;

	@ManyToOne
	@JoinColumn(name = "ID_SUB_PROD_FK")
	/**
	 * Llave foranea para la entidad de subproducto
	 */
	private SccMxMaeSubProd idSubProdFk;
	@Column(name = "ID_BUC_CLTE")
	/**
	 * Identificador del cliente
	 */
	private Long idBucClte;
	@Column(name = "DSC_NOM_CLTE")
	/**
	 * Nombre del Cliente
	 */
	private String dscNumClte;
	@Column(name = "IMP_CRED")
	/**
	 * Importe del credito, monto solicitado
	 */
	private Double impCred;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FCH_SIMUL")
	/**
	 * Fecha en la que se grabo la simulacion
	 */
	private Date fchSimul;
	@Column(name = "FLG_CONV_AUTO")
	/**
	 * Indicador si la simulacion se uso con conversion auto
	 */
	private Long flgConvAuto;
	@Column(name="POR_CAT_PROM_SIN_IVA")
	/**
	 * Informacion del CAT sin IVA
	 */
	private Double porCatPromSinIva;
	@Column(name="POR_TAS_ORD_ANUAL")
	/**
	 * Porcentaje de la tasa base anual
	 */
	private Double porTasOrdAnual;
	@Column(name="POR_TIIE")
	/**
	 * porcentaje para la TIIE
	 */
	private Double porTiie;
	@Column(name = "IMP_BONIF_SGROS")
	/**
	 * Importe de la bonificacion de seguros, aplica en restitucion
	 */
	private Double impBonifSgros;
	@Column (name = "IMP_SALDO_CRED_REST" )
	/**
	 * Importe del Saldo cuando es credito a restituir
	 */
	private Double impSaldoCredRest;
	
	@Column (name = "IMP_PAGO")
	/**
	 * Monto del pago a realizar
	 */
	private Double impPago;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERIOD_FK")
	/** 
	 * periodicidad elegida para la simulacion
	 */
	private SccMxMaePeriod idPeriodFk;
	@Column(name="TXT_FONDO_GARANTIA")
	/**
	 * Descripcion del fondo de garantia, aplica para PSG
	 */
	private String txtFondoGarantia;


	/**
	 * Getter para IdSimulador
	 * @return idSimuladorPk  
	 * Id de la simulación
	 */
	public Long getIdSimuladorPk() {
		return idSimuladorPk;
	}

	/**
	 * Setter para IdSimulador
	 * @param idSimuladorPk 
	 * Id de la simulación
	 */
	public void setIdSimuladorPk(Long idSimuladorPk) {
		this.idSimuladorPk = idSimuladorPk;
	}

	/**
	 * Getter para el objeto perfiles
	 * @return idPerfilFk 
	 * Id del perfil del usuario
	 */
	public SccMxMaePerfiles getIdPerfilFk() {
		return idPerfilFk;
	}

	/**
	 * Setter para el objeto perfiles
	 * @param idPerfilFk  
	 * Id del perfil del usuario
	 */
	public void setIdPerfilFk(SccMxMaePerfiles idPerfilFk) {
		this.idPerfilFk = idPerfilFk;
	}

	/**
	 * Getter para el objeto de tipousuario
	 * @return idUsrFk 
	 * Id del usuario
	 */
	public SccMxMaeTipoUsr getIdUsrFk() {
		return idUsrFk;
	}

	/**
	 * Setter para el objeto tipoUsuario
	 * @param idUsrFk 
	 * Id del usuario
	 */
	public void setIdUsrFk(SccMxMaeTipoUsr idUsrFk) {
		this.idUsrFk = idUsrFk;
	}

	/**
	 * Getter para el objeto de causas de rechazo
	 * @return idMvoRechazoFk 
	 * Id del motivo del rechazo
	 */
	public SccMxMaeMvosRechazo getIdMvoRechazoFk() {
		return idMvoRechazoFk;
	}

	/**
	 * setter para el objeto de causas de rechazo
	 * @param idMvoRechazoFk 
	 * Id del motivo del rechazo
	 */
	public void setIdMvoRechazoFk(SccMxMaeMvosRechazo idMvoRechazoFk) {
		this.idMvoRechazoFk = idMvoRechazoFk;
	}

	/**
	 * Getter para el objeto Subproducto
	 * @return idSubProdFk 
	 * Id del subproducto
	 */
	public SccMxMaeSubProd getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * Setter para el objeeto subproducto
	 * @param idSubProdFk 
	 * Id del subproducto
	 */
	public void setIdSubProdFk(SccMxMaeSubProd idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

	/**
	 * Getter para el ID del cliente
	 * @return idBucClte 
	 * Id del cliente (BUC)
	 */
	public Long getIdBucClte() {
		return idBucClte;
	}

	/**
	 * Setter para el id de cliente
	 * @param idBucClte 
	 * Id del cliente (BUC)
	 */
	public void setIdBucClte(Long idBucClte) {
		this.idBucClte = idBucClte;
	}

	/**
	 * Getter para el nombre del cliente
	 * @return dscNumClte Nombre del cliente
	 */
	public String getDscNumClte() {
		return dscNumClte;
	}

	/**
	 * setter para el Nombre del cliente
	 * @param dscNumClte Nombre del cliente
	 */
	public void setDscNumClte(String dscNumClte) {
		this.dscNumClte = dscNumClte;
	}

	/**
	 * Getter para el importe del credito
	 * @return impCred Importe del crédito
	 */
	public Double getImpCred() {
		return impCred;
	}

	/**
	 * Setter para importe de crédito
	 * @param impCred Importe del crédito
	 */
	public void setImpCred(Double impCred) {
		this.impCred = impCred;
	}

	/**
	 * Getter de la fecha en que se simuló
	 * @return fchSimul Fecha de la simulación
	 */
	public Date getFchSimul() {
		return new Date(this.fchSimul.getTime());
	}

	/**
	 * Setter de la fecha que simuló
	 * @param fchSimul Fecha de la simulación
	 */
	public void setFchSimul(Date fchSimul) {
		this.fchSimul = new Date(fchSimul.getTime());
	}

	/**
	 * Getter para la bandera de ConvAuto
	 * @return flgConvAuto Indicador de Conversión Auto
	 */
	public Long getFlgConvAuto() {
		return flgConvAuto;
	}

	/**
	 * Setter para la bandera de convauto
	 * @param flgConvAuto Indicador de Conversión Auto
	 */
	public void setFlgConvAuto(Long flgConvAuto) {
		this.flgConvAuto = flgConvAuto;
	}

	/**
	 * Getter del CAT 
	 * @return porCatPromSinIva Porcentaje de CAT promedio sin IVA
	 */
	public Double getPorCatPromSinIva() {
		return porCatPromSinIva;
	}

	/**
	 * Setter del CAT
	 * @param porCatPromSinIva Porcentaje de CAT promedio sin IVA
	 */
	public void setPorCatPromSinIva(Double porCatPromSinIva) {
		this.porCatPromSinIva = porCatPromSinIva;
	}

	/**
	 * Getter de la Tasa Anual
	 * @return porTasOrdAnual Porcentaje de tasa ordinaria anual
	 */
	public Double getPorTasOrdAnual() {
		return porTasOrdAnual;
	}

	/**
	 * Setter de la tasa anual
	 * @param porTasOrdAnual Porcentaje de tasa ordinaria anual
	 */
	public void setPorTasOrdAnual(Double porTasOrdAnual) {
		this.porTasOrdAnual = porTasOrdAnual;
	}

	/**
	 * Getter de TIIE, puede ser null
	 * solo aplica para PSG
	 * @return porTiie Porcentaje de TIIE
	 */
	public Double getPorTiie() {
		return porTiie;
	}

	/**
	 * Setter de TIIE para PSG
	 * @param porTiie Porcentaje de TIIE
	 */
	public void setPorTiie(Double porTiie) {
		this.porTiie = porTiie;
	}

	/**
	 * Getter de bonificacion en caso de Resti
	 * @return impBonifSgros Importe de bonificación de seguros
	 */
	public Double getImpBonifSgros() {
		return impBonifSgros;
	}

	/**
	 * Setter de bonificacion solo aplica en Resti
	 * @param impBonifSgros Importe de bonificación de seguros
	 */
	public void setImpBonifSgros(Double impBonifSgros) {
		this.impBonifSgros = oValidaNull.validaNullDouble(impBonifSgros);
	}

	/**
	 * Getter de saldo a restituir
	 * @return impSaldoCredRest Importe del saldo del crédito a restituír
	 */
	public Double getImpSaldoCredRest() {
		return impSaldoCredRest;
	}

	/**
	 * Setter de saldo a restituir
	 * @param impSaldoCredRest Importe del saldo del crédito a restituír
	 */
	public void setImpSaldoCredRest(Double impSaldoCredRest) {
		this.impSaldoCredRest =oValidaNull.validaNullDouble(impSaldoCredRest);
	}

	/**
	 * Getter del PAGO 
	 * @return impPago Importe del pago
	 */
	public Double getImpPago() {
		return impPago;
	}

	/**
	 * Setter del pago 
	 * @param impPago Importe del pago
	 */
	public void setImpPago(Double impPago) {
		this.impPago = impPago;
	}

	/**
	 * getter para el objeto periodicidad
	 * @return idPeriodFk Id del periodo
	 */
	public SccMxMaePeriod getIdPeriodFk() {
		return idPeriodFk;
	}

	/**
	 * Setter para objeto periodicidad
	 * @param idPeriodFk Id del periodo
	 */
	public void setIdPeriodFk(SccMxMaePeriod idPeriodFk) {
		this.idPeriodFk = idPeriodFk;
	}

	/**
	 * Solo aplica para pSG
	 * @return txtFondoGarantia Descripción del fondo de garantía
	 */
	public String getTxtFondoGarantia() {
		return txtFondoGarantia;
	}

	/**
	 * Solo aplica para PSG
	 * @param txtFondoGarantia Descripción del fondo de garantía
	 */
	public void setTxtFondoGarantia(String txtFondoGarantia) {
		this.txtFondoGarantia = oValidaNull.validaNullString(txtFondoGarantia);
	}

}
