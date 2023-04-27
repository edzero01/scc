package mx.isban.scc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Clase de entidad de la tabla que guarda el historico 
 * de las simulaciones realizadas en el sistema
 * Esta entidad es para usarse con el JPA Repository
 * por lo que no usa las llaves combinadas
 * ManyToOne y JoinColumn
 * El Jpa Repository se usa para 
 * el guardado de las simulaciones
 * Existe otra entidad en el sistema que mapea a la misma tabla
 * SccMxMaeSimuladorDro
 * Esa entidad se usa para consultas en el front-end por lo que 
 * Sí utiliza las llaves ManyToOne y JoinColumn
 * Generado por GlobalHitss
 * Proyecto Simulador Santander
 * Octubre 2019
 * Sprint 6
 * @author Global Hitss
 * Tabla: SCC_MX_MAE_SIMULADOR_DRO
 * Clase: SccMxMaeSimuladorDroJpa
 * Sequence: SCC_MX_MAE_SIMULADOR_DRO_SEQ
 */

@Entity
@Table(name="SCC_MX_MAE_SIMULADOR_DRO")
@NamedQuery(name="SccMxMaeSimuladorDroJpa.findAll", query="SELECT s FROM SccMxMaeSimuladorDroJpa s")
public class SccMxMaeSimuladorDroJpa implements IAbstractEntity, Serializable {

	/**
	 * serialVersionUID Auto-generado
	 */
	private static final long serialVersionUID = 8364430468763910466L;

	@Id
	@SequenceGenerator(name="SCC_MX_MAE_SIMULADOR_DRO_IDSIMULPK_GENERATOR", sequenceName="SCC_MX_MAE_SIMULADOR_DRO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCC_MX_MAE_SIMULADOR_DRO_IDSIMULPK_GENERATOR")
	@Column(name="ID_SIMUL_PK")
	/**
	 * lLAVE PRIMARIA PARA IDENTIFICAR EL REGISTRO
	 */
	private long idSimulPk;

	@Column(name="DSC_NOM_CLTE")
	/** 
	 * nombre del cliente
	 */
	private String dscNomClte;

	@Column(name="FCH_SIMUL")
	/**
	 * fecha de la simulacion
	 */
	private Timestamp fchSimul;

	@Column(name="FLG_CONV_AUTO")
	/** 
	 * indica si se simulo con conversion auto
	 */
	private BigDecimal flgConvAuto;

	@Column(name="ID_BUC_CLTE")
	/**
	 * id buc del cliente
	 */
	private BigDecimal idBucClte;

	@Column(name="ID_MVO_RECHAZO_FK")
	/**
	 * foreign key para el motivo de rechazo
	 */
	private BigDecimal idMvoRechazoFk;

	@Column(name="ID_PERFIL_FK")
	/**
	 * foreign key para el perfil
	 */
	private BigDecimal idPerfilFk;

	@Column(name="ID_PERIOD_FK")
	/**
	 * foreign key para la periodicidad simulada
	 */
	private BigDecimal idPeriodFk;

	@Column(name="ID_SUB_PROD_FK")
	/**
	 * foreign key para el sub producto
	 */
	private BigDecimal idSubProdFk;

	@Column(name="ID_USR_FK")
	/**
	 * foreign key para el usuario
	 */
	private BigDecimal idUsrFk;

	@Column(name="IMP_BONIF_SGROS")
	/**
	 * importe d ela bonificacion de seguros en resti
	 */
	private BigDecimal impBonifSgros;

	@Column(name="IMP_CRED")
	/**
	 * importe o monto del credito solicitado
	 */
	private BigDecimal impCred;

	@Column(name="IMP_PAGO")
	/**
	 * importe del pago o cuota a pagar
	 */
	private BigDecimal impPago;

	@Column(name="IMP_SALDO_CRED_REST")
	/**
	 * importe del saldo del credito que se va a restituir
	 */
	private BigDecimal impSaldoCredRest;

	@Column(name="POR_CAT_PROM_SIN_IVA")
	/**
	 * porcentaje del CAT promedio sin iva
	 */
	private BigDecimal porCatPromSinIva;

	@Column(name="POR_TAS_ORD_ANUAL")
	/**
	 * Porcentaje de la tasa base anual
	 */
	private BigDecimal porTasOrdAnual;

	@Column(name="POR_TIIE")
	/**
	 * Porcentaje de la TIIE
	 */
	private BigDecimal porTiie;

	@Column(name="TXT_FONDO_GARANTIA")
	/**
	 * descripcion del fondo de garantia, para PSG
	 */
	private String txtFondoGarantia;

	/**
	 * Constructor vacio
	 */
	public SccMxMaeSimuladorDroJpa() {
		//El constructor vacío es necesario 
		//para el uso de reflection
	}

	/**
	 * @return idSimulPk Id de la simulación
	 */
	public long getIdSimulPk() {
		return this.idSimulPk;
	}

	/**
	 * @param idSimulPk Id de la simulación
	 */
	public void setIdSimulPk(long idSimulPk) {
		this.idSimulPk = idSimulPk;
	}

	/**
	 * @return dscNomClte Nombre del cliente
	 */
	public String getDscNomClte() {
		return this.dscNomClte;
	}

	/**
	 * @param dscNomClte Nombre del cliente
	 */
	public void setDscNomClte(String dscNomClte) {
		this.dscNomClte = dscNomClte;
	}

	/**
	 * @return fchSimul Fecha de la simulación
	 */
	public Timestamp getFchSimul() {
		return new Timestamp (this.fchSimul.getTime());
	}

	/**
	 * @param fchSimul Fecha de la simulación
	 */
	public void setFchSimul(Timestamp fchSimul) {
		this.fchSimul = new Timestamp(fchSimul.getTime());
	}

	/**
	 * @return flgConvAuto Indicador de conversión auto
	 */
	public BigDecimal getFlgConvAuto() {
		return this.flgConvAuto;
	}

	/**
	 * @param flgConvAuto Indicador de conversión auto
	 */
	public void setFlgConvAuto(BigDecimal flgConvAuto) {
		this.flgConvAuto = flgConvAuto;
	}

	/**
	 * @return idBucClte Id del cliente (BUC)
	 */
	public BigDecimal getIdBucClte() {
		return this.idBucClte;
	}

	/**
	 * @param idBucClte Id del cliente (BUC)
	 */
	public void setIdBucClte(BigDecimal idBucClte) {
		this.idBucClte = idBucClte;
	}

	/**
	 * @return idMvoRechazoFk Id del motivo del rechazo del cliente
	 */
	public BigDecimal getIdMvoRechazoFk() {
		return this.idMvoRechazoFk;
	}

	/**
	 * @param idMvoRechazoFk Id del motivo del rechazo del cliente
	 */
	public void setIdMvoRechazoFk(BigDecimal idMvoRechazoFk) {
		this.idMvoRechazoFk = idMvoRechazoFk;
	}

	/**
	 * @return idPerfilFk Id del perfil del usuario del simulador
	 */
	public BigDecimal getIdPerfilFk() {
		return this.idPerfilFk;
	}

	/**
	 * @param idPerfilFk Id del perfil del usuario del simulador
	 */
	public void setIdPerfilFk(BigDecimal idPerfilFk) {
		this.idPerfilFk = idPerfilFk;
	}

	/**
	 * @return idPeriodFk Id del periodo
	 */
	public BigDecimal getIdPeriodFk() {
		return this.idPeriodFk;
	}

	/**
	 * @param idPeriodFk Id del periodo
	 */
	public void setIdPeriodFk(BigDecimal idPeriodFk) {
		this.idPeriodFk = idPeriodFk;
	}

	/**
	 * @return idSubProdFk Id del subproducto
	 */
	public BigDecimal getIdSubProdFk() {
		return this.idSubProdFk;
	}

	/**
	 * @param idSubProdFk Id del subproducto
	 */
	public void setIdSubProdFk(BigDecimal idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

	/**
	 * @return idUsrFk Id del usuario del simulador
	 */
	public BigDecimal getIdUsrFk() {
		return this.idUsrFk;
	}

	/**
	 * @param idUsrFk Id del usuario del simulador
	 */
	public void setIdUsrFk(BigDecimal idUsrFk) {
		this.idUsrFk = idUsrFk;
	}

	/**
	 * @return impBonifSgros Importe de la bonificación de seguros
	 */
	public BigDecimal getImpBonifSgros() {
		return this.impBonifSgros;
	}

	/**
	 * @param impBonifSgros Importe de la bonificación de seguros
	 */
	public void setImpBonifSgros(BigDecimal impBonifSgros) {
		this.impBonifSgros = impBonifSgros;
	}

	/**
	 * @return impCred Importe del crédito
	 */
	public BigDecimal getImpCred() {
		return this.impCred;
	}

	/**
	 * @param impCred Importe del crédito
	 */
	public void setImpCred(BigDecimal impCred) {
		this.impCred = impCred;
	}

	/**
	 * @return impPago  Importe del pago
	 */
	public BigDecimal getImpPago() {
		return this.impPago;
	}

	/**
	 * @param impPago Importe del pago
	 */
	public void setImpPago(BigDecimal impPago) {
		this.impPago = impPago;
	}

	/**
	 * @return impSaldoCredRest Importe del saldo del crédito a restituír
	 */
	public BigDecimal getImpSaldoCredRest() {
		return this.impSaldoCredRest;
	}

	/**
	 * @param impSaldoCredRest Importe del saldo del crédito a restituír
	 */
	public void setImpSaldoCredRest(BigDecimal impSaldoCredRest) {
		this.impSaldoCredRest = impSaldoCredRest;
	}

	/**
	 * @return porCatPromSinIva Porcentaje de CAT promedio sin IVA
	 */
	public BigDecimal getPorCatPromSinIva() {
		return this.porCatPromSinIva;
	}

	/**
	 * @param porCatPromSinIva Porcentaje de CAT promedio sin IVA
	 */
	public void setPorCatPromSinIva(BigDecimal porCatPromSinIva) {
		this.porCatPromSinIva = porCatPromSinIva;
	}

	/**
	 * @return porTasOrdAnual Porcentaje de tasa ordinaria anual
	 */
	public BigDecimal getPorTasOrdAnual() {
		return this.porTasOrdAnual;
	}

	/**
	 * @param porTasOrdAnual Porcentaje de tasa ordinaria anual
	 */
	public void setPorTasOrdAnual(BigDecimal porTasOrdAnual) {
		this.porTasOrdAnual = porTasOrdAnual;
	}

	/**
	 * @return porTiie Porcentaje de TIIE
	 */
	public BigDecimal getPorTiie() {
		return this.porTiie;
	}

	/**
	 * @param porTiie Porcentaje de TIIE
	 */
	public void setPorTiie(BigDecimal porTiie) {
		this.porTiie = porTiie;
	}

	/**
	 * @return txtFondoGarantia Descripción del fondo de garantía
	 */
	public String getTxtFondoGarantia() {
		return this.txtFondoGarantia;
	}

	/**
	 * @param txtFondoGarantia Descripción del fondo de garantía
	 */
	public void setTxtFondoGarantia(String txtFondoGarantia) {
		this.txtFondoGarantia = txtFondoGarantia;
	}

}