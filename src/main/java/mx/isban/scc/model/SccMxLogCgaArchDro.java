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
 * En esta entidad se graba toda la informacion
 * relativa al resultado de haber ejecutado
 * un shell o realizado la carga de un catalogo
 * con la interfaz de archivos.
 * Es como el registro de logs visible en la interfaz
 * del simulador
 * @author GlobalHitss
 *
 */
@Entity
@Table(name = "SCC_MX_LOG_CGA_ARCH_DRO")
public class SccMxLogCgaArchDro implements java.io.Serializable {

	/**
	 * Identificador para serializar la clase
	 */
	private static final long serialVersionUID = -1287188221886558645L;

	/**
	 * propiedad idLogPk de la entidad SccMxLogCgaArchDro
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLogPk;
	
	/**
	 * Nombre del archivo usado para subir la informacion
	 * a la base de datos.
	 */
	private String dscNomArch;
	
	/**
	 * Nombre del archivo LOG generado alsubir la informacion.
	 * No siempre se cuenta con este dato
	 */
	private String dscNomLog;
	
	/**
	 * Fecha en la que se ejecuto el shell o se hizo la carga del archivo
	 */
	private Date fchLog;
	
	/**
	 * propiedad idTipoArchFk de la entidad SccMxLogCgaArchDro
	 */
	@OneToOne
	@JoinColumn(name = "ID_TIPO_ARCH_FK")
	private SccMxMaeTipoArch idTipoArchFk;

	/**
	 * Constructor sin argumentos
	 */
	public SccMxLogCgaArchDro() {
	}

	/**
	 * Constructor de ofertas promocionales de mercado abierto
	 * @param idLogPk
	 * Id primary key
	 * @param dscNomArch
	 * descripcion nombre de archivo
	 * @param dscNomLog
	 * descripcion nombre de log
	 * @param idTipoArchFk
	 * id llave foranea para descripcion
	 */
	public SccMxLogCgaArchDro(Long idLogPk, String dscNomArch, String dscNomLog, 
			SccMxMaeTipoArch idTipoArchFk) {
		this.idLogPk = idLogPk;
		this.dscNomArch = dscNomArch;
		this.dscNomLog = dscNomLog;
		this.idTipoArchFk = idTipoArchFk;
	}

	/**
	 * @return idLogPk Id de la Tabla SccMxLogCgaArchDro
	 */
	public Long getIdLogPk() {
		return idLogPk;
	}

	/**
	 * @param idLogPk Id de la Tabla SccMxLogCgaArchDro
	 */
	public void setIdLogPk(Long idLogPk) {
		this.idLogPk = idLogPk;
	}

	/**
	 * @return dscNomArch Descripción del nombre de archivo
	 */
	public String getDscNomArch() {
		return dscNomArch;
	}

	/**
	 * @param dscNomArch Descripción del nombre de archivo
	 */
	public void setDscNomArch(String dscNomArch) {
		this.dscNomArch = dscNomArch;
	}

	/**
	 * @return dscNomLog Descripción del nombre del log
	 */
	public String getDscNomLog() {
		return dscNomLog;
	}

	/**
	 * @param dscNomLog Descripción del nombre del log
	 */
	public void setDscNomLog(String dscNomLog) {
		this.dscNomLog = dscNomLog;
	}

	/**
	 * @return fchLog Fecha del log
	 */
	public Date getFchLog() {
		return new Date(fchLog.getTime());
	}

	/**
	 * @param fchLog Fecha del log
	 */
	public void setFchLog(Date fchLog) {
		this.fchLog = new Date(fchLog.getTime());
	}

	/**
	 * @return idTipoArchFk Id del tipo de archivo
	 */
	public SccMxMaeTipoArch getIdTipoArchFk() {
		return idTipoArchFk;
	}

	/**
	 * @param idTipoArchFk Id del tipo de archivo
	 */
	public void setIdTipoArchFk(SccMxMaeTipoArch idTipoArchFk) {
		this.idTipoArchFk = idTipoArchFk;
	}

}
