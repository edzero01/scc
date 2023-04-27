package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Clase para manejar la tabla de PAMPA
 * donde se guarda la inforamcion de los creditos
 * que se pueden restituir
 * Generado por GlobalHitss
 * Mayo 2019
 * Sprint 1
 * @author Hitss
 * SccMxMaePampa generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_PAMPA")
public class SccMxMaePampa implements IAbstractEntity,java.io.Serializable {


	/**
	 * serializacion de la entidad
	 */
	private static final long serialVersionUID = 7805381796351424203L;
	/**
	 * Llave principal para tabla pampa
	 */
	private Long idPampaPk;
	/**
	 * Numero de Contrato asignado al credito
	 */
	private String txtCntoTdc;
	/**
	 * Numero de tarjeta de credito relacionado con el contrato
	 */
	private String numTdc;
	/**
	 * Identificador del BUC de cliente
	 */
	private Long idBucClte;
	/**
	 * Saldo del credito en pampa
	 */
	private Double impSaldoLinex;
	/**
	 * Plazo asignado al seguro del credito
	 */
	private Long numPlazoDispn;
	/**
	 * Importe de la prima pagada
	 */
	private Double impPrimaSeg;
	/**
	 * Fecha de la disposicion del credito
	 */
	private Date fchIniDispn;
	/**
	 * Fecha de vencimiento del credito o del seguro
	 */
	private Date fchFinDispn;
	/**
	 * Fecha de cancelacion (al momento de restituir este credito)
	 */
	private Date fchCancl;
	/**
	 * Identifica el Centro de Alta del credito
	 */
	private Long idCntrAlta;
	/**
	 * Identifica el centro de alta para el contrato del cliente
	 */
	private Long idCntrCont;
	/**
	 * Numero de Operacion realizada
	 */
	private Long numOprcn;
	/**
	 * Importe de la operacion.
	 */
	private Double impOprcn;

	/**
	 * Constructor Vacio
	 */
	public SccMxMaePampa() {
	}

	/**
	 * Constructor de la tabla de pampa
	 * @param idPampaPk
	 * Primary key
	 */
	public SccMxMaePampa(Long idPampaPk) {
		this.idPampaPk = idPampaPk;
	}


	/**
	 * @return idPampaPk Id de PAMPA
	 */
	@Id

	@Column(name = "ID_PAMPA_PK", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdPampaPk() {
		return this.idPampaPk;
	}

	/**
	 * @param idPampaPk Id de PAMPA
	 */
	public void setIdPampaPk(Long idPampaPk) {
		this.idPampaPk = idPampaPk;
	}

	/**
	 * @return txtCntoTdc txtCntoTdc
	 */
	@Column(name = "TXT_CNTO_TDC", length = 100)
	public String getTxtCntoTdc() {
		return this.txtCntoTdc;
	}

	/**
	 * @param txtCntoTdc txtCntoTdc
	 */
	public void setTxtCntoTdc(String txtCntoTdc) {
		this.txtCntoTdc = txtCntoTdc;
	}

	/**
	 * @return numTdc Número de tarjeta de crédito
	 */
	@Column(name = "NUM_TDC", length = 100)
	public String getNumTdc() {
		return this.numTdc;
	}

	/**
	 * @param numTdc Número de tarjeta de crédito
	 */
	public void setNumTdc(String numTdc) {
		this.numTdc = numTdc;
	}

	/**
	 * @return idBucClte Id de Cliente (BUC)
	 */
	@Column(name = "ID_BUC_CLTE", precision = 22, scale = 0)
	public Long getIdBucClte() {
		return this.idBucClte;
	}

	/**
	 * @param idBucClte Id de Cliente (BUC)
	 */
	public void setIdBucClte(Long idBucClte) {
		this.idBucClte = idBucClte;
	}

	/**
	 * @return impSaldoLinex Importe de saldo LINEX
	 */
	@Column(name = "IMP_SALDO_LINEX", precision = 22, scale = 2)
	public Double getImpSaldoLinex() {
		return this.impSaldoLinex;
	}

	/**
	 * @param impSaldoLinex Importe de saldo LINEX
	 */
	public void setImpSaldoLinex(Double impSaldoLinex) {
		this.impSaldoLinex = impSaldoLinex;
	}

	/**
	 * @return numPlazoDispn Número de plazo disponible
	 */
	@Column(name = "NUM_PLAZO_DISPN", precision = 22, scale = 0)
	public Long getNumPlazoDispn() {
		return this.numPlazoDispn;
	}

	/**
	 * @param numPlazoDispn Número de plazo disponible
	 */
	public void setNumPlazoDispn(Long numPlazoDispn) {
		this.numPlazoDispn = numPlazoDispn;
	}

	/**
	 * @return impPrimaSeg Importe de prima de seguro
	 */
	@Column(name = "IMP_PRIMA_SEG", precision = 22, scale = 2)
	public Double getImpPrimaSeg() {
		return this.impPrimaSeg;
	}

	/**
	 * @param impPrimaSeg impPrimaSeg Importe de prima de seguro
	 */
	public void setImpPrimaSeg(Double impPrimaSeg) {
		this.impPrimaSeg = impPrimaSeg;
	}

	/**
	 * @return fchIniDispn Fecha de inicio disponible
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FCH_INI_DISPN", length = 11)
	public Date getFchIniDispn() {
		return new Date(this.fchIniDispn.getTime());
	}

	/**
	 * @param fchIniDispn Fecha de inicio disponible
	 */
	public void setFchIniDispn(Date fchIniDispn) {
		this.fchIniDispn = new Date(fchIniDispn.getTime());
	}

	/**
	 * @return fchFinDispn Fecha de fin disponible
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FCH_FIN_DISPN", length = 11)
	public Date getFchFinDispn() {
		return new Date(this.fchFinDispn.getTime());
	}

	/**
	 * @param fchFinDispn Fecha de fin disponible
	 */
	public void setFchFinDispn(Date fchFinDispn) {
		this.fchFinDispn = new Date(fchFinDispn.getTime());
	}

	/**
	 * @return fchCancl Fecha de cancelación
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FCH_CANCL", length = 11)
	public Date getFchCancl() {
		return new Date(this.fchCancl.getTime());
	}

	/**
	 * @param fchCancl Fecha de cancelación
	 */
	public void setFchCancl(Date fchCancl) {
		this.fchCancl = new Date(fchCancl.getTime());
	}
	
	/**
	 * @return idCntrAlta idCntrAlta
	 */
	@Column(name = "ID_CNTR_ALTA", precision = 22, scale = 0)
	public Long getIdCntrAlta() {
		return this.idCntrAlta;
	}

	/**
	 * @param idCntrAlta idCntrAlta
	 */
	public void setIdCntrAlta(Long idCntrAlta) {
		this.idCntrAlta = idCntrAlta;
	}
	
	/**
	 * @return idCntrCont idCntrCont
	 */
	@Column(name = "ID_CNTR_CONT", precision = 22, scale = 0)
	public Long getIdCntrCont() {
		return this.idCntrCont;
	}

	/**
	 * @param idCntrCont idCntrCont
	 */
	public void setIdCntrCont(Long idCntrCont) {
		this.idCntrCont = idCntrCont;
	}
	
	/**
	 * @return numOprcn Número de operación
	 */
	@Column(name = "NUM_OPRCN", precision = 22, scale = 0)
	public Long getNumOprcn() {
		return this.numOprcn;
	}

	/**
	 * @param numOprcn Número de operación
	 */
	public void setNumOprcn(Long numOprcn) {
		this.numOprcn = numOprcn;
	}

	/**
	 * @return impOprcn Importe de operación
	 */
	@Column(name = "IMP_OPRCN", precision = 22, scale = 2)
	public Double getImpOprcn() {
		return this.impOprcn;
	}

	/**
	 * @param impOprcn Importe de operación
	 */
	public void setImpOprcn(Double impOprcn) {
		this.impOprcn = impOprcn;
	}
}