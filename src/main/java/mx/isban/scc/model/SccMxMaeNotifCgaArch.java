package mx.isban.scc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Campos de entidad
 * Entidad usada para obtener
 * datos de tabla de 
 * notificaciones
 * de la tabla
 * SCC_MX_MAE_NOTIF_CGA_ARCH
 * Las notificaciones son un estilo de LOG, pero mas resumida
 * solamente indican el exito o falla en la carga
 * de un archivo, ya sea por shell o por interfaz
 * 
 * Junio 2019
 * @author Juan Carlos Romero Benitez
 * SccMxMaeNotifCgaArch
 */
@Entity
@Table(name =  "SCC_MX_MAE_NOTIF_CGA_ARCH")
public class SccMxMaeNotifCgaArch implements java.io.Serializable{

	/**
	 * Identificador para serializar la clase 
	 */
	private static final long serialVersionUID = 4249972049321975674L;

	/**
	 * Llave primaria para identificar la notificacion
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNotifCgaPk;
	/**
	 * Nombre del archivo utilizado para cargar la informacion en BD
	 */
	private String txtNomArc;
	/**
	 * Codigo con el resultado de la carga (EXITO o FALLO)
	 */
	private String codTpoCga;
	/**
	 * Llave foranea para identificar el tipo de archivo cargado
	 * se ocupa principalmente en el caso de catalogos cargados
	 * con la interfaz
	 */
	@OneToOne
	@JoinColumn(name="ID_TPO_ARCH_FK")
	private SccMxMaeTipoArch idTpoArchFk;
	/**
	 * Fecha en la que se ejecuto el shell o se utilizo la interfaz de carga
	 * para subir la informacion del archivo
	 */
	private Date fchArcCga;
	/**
	 * Codigo para identificar el resultado
	 */
	private String codEdoCga;
	/**
	 * Numero de registros que trae el archivo de carga
	 */
	private Long numReg;
	/**
	 * Numero de registros cargados exitosamente
	 */
	private Long numRegExt;
	/**
	 * Numero de registros fallidos 
	 */
	private Long numRegNok;
	
	
	/**
	 * Constructor de las notificaciones
	 * de las propiedades por default
	 * @param idNotifCgaPk
	 * Id primary key
	 * @param txtNomArc
	 * nombre de archivo
	 * @param codTpoCga
	 * cidogi tipo carga
	 * @param idTpoArchFk
	 * llave foranea
	 * @param codEdoCga
	 * codigo de estado de carga
	 * @param numReg
	 * numero de reg
	 * @param numRegExt
	 * numero de reg ext
	 * @param numRegNok
	 * numero de reg ext
	 */
	public SccMxMaeNotifCgaArch(Long idNotifCgaPk, String txtNomArc, String codTpoCga, SccMxMaeTipoArch idTpoArchFk,
			 String codEdoCga, Long numReg, Long numRegExt, Long numRegNok) {
		super();
		this.idNotifCgaPk = idNotifCgaPk;
		this.txtNomArc = txtNomArc;
		this.codTpoCga = codTpoCga;
		this.idTpoArchFk = idTpoArchFk;
		this.codEdoCga = codEdoCga;
		this.numReg = numReg;
		this.numRegExt = numRegExt;
		this.numRegNok = numRegNok;
	}

	/**
	 * Constructor de las notificaciones
	 * sin argumentos
	 */
	public SccMxMaeNotifCgaArch() {}

	/**
	 * @return Long idNotifCgaPk
	 */
	public Long getIdNotifCgaPk() {
		return idNotifCgaPk;
	}

	/**
	 * @param idNotifCgaPk Long
	 */
	public void setIdNotifCgaPk(Long idNotifCgaPk) {
		this.idNotifCgaPk = idNotifCgaPk;
	}

	/**
	 * @return String txtNomArc
	 */
	public String getTxtNomArc() {
		return txtNomArc;
	}

	/**
	 * @param txtNomArc String
	 */
	public void setTxtNomArc(String txtNomArc) {
		this.txtNomArc = txtNomArc;
	}

	/**
	 * @return String codTpoCga
	 */
	public String getCodTpoCga() {
		return codTpoCga;
	}

	/**
	 * @param codTpoCga String
	 */
	public void setCodTpoCga(String codTpoCga) {
		this.codTpoCga = codTpoCga;
	}

	/**
	 * @return SccMxMaeTipoArch idTpoArchFk
	 */
	public SccMxMaeTipoArch getIdTpoArchFk() {
		return idTpoArchFk;
	}

	/**
	 * @param idTpoArchFk SccMxMaeTipoArch
	 */
	public void setIdTpoArchFk(SccMxMaeTipoArch idTpoArchFk) {
		this.idTpoArchFk = idTpoArchFk;
	}

	/**
	 * @return Date fchArcCga
	 */
	public Date getFchArcCga() {
		return new Date(fchArcCga.getTime());
	}

	/**
	 * @param fchArcCga Date
	 */
	public void setFchArcCga(Date fchArcCga) {
		this.fchArcCga = new Date(fchArcCga.getTime());
	}

	/**
	 * @return String codEdoCga
	 */ 
	public String getCodEdoCga() {
		return codEdoCga;
	}

	/**
	 * @param codEdoCga String
	 */
	public void setCodEdoCga(String codEdoCga) {
		this.codEdoCga = codEdoCga;
	}

	/**
	 * @return Long numReg
	 */
	public Long getNumReg() {
		return numReg;
	}

	/**
	 * @param numReg Long
	 */
	public void setNumReg(Long numReg) {
		this.numReg = numReg;
	}

	/**
	 * @return Long numRegExt
	 */
	public Long getNumRegExt() {
		return numRegExt;
	}

	/**
	 * @param numRegExt Long
	 */
	public void setNumRegExt(Long numRegExt) {
		this.numRegExt = numRegExt;
	}

	/**
	 * @return Long numRegNok
	 */
	public Long getNumRegNok() {
		return numRegNok;
	}

	/**
	 * @param numRegNok Long
	 */
	public void setNumRegNok(Long numRegNok) {
		this.numRegNok = numRegNok;
	}
	
}
