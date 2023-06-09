package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase para relacionar con los motivos de rechazo
 * que es el catalogo para que el cliente pueda 
 * dar sus motivos para no aceptar el credito que simula
 * Generado por GlobalHitss
 * Mayo 2019
 * Sprint 1
 * 
 * 
 * SccMxMaeMvosRechazo generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_MVOS_RECHAZO")
public class SccMxMaeMvosRechazo implements IAbstractEntity, java.io.Serializable {

	/**
	 * Identificador para serializar la clase
	 */
	private static final long serialVersionUID = -472396714433872040L;
	/**
	 * Identificador de lalve primaria motivos de rechazo
	 */
	private Long idMvoRechazoPk;
	/**
	 * Descripcion de motivos de rechazo
	 */
	private String dscMvoRechazo;

	/**
	 * Constructor Vacio
	 */
	public SccMxMaeMvosRechazo() {
	}

	/**
	 * Constructor de MOtivos de Rechazo
	 * @param idMvoRechazoPk
	 * llave
	 */
	public SccMxMaeMvosRechazo(Long idMvoRechazoPk) {
		this.idMvoRechazoPk = idMvoRechazoPk;
	}

	/**
	 * Constructor de motivos de rechazo con id y con descripción
	 * @param idMvoRechazoPk
	 * Llave
	 * @param dscMvoRechazo
	 * descripcion
	 */
	public SccMxMaeMvosRechazo(Long idMvoRechazoPk, String dscMvoRechazo) {
		this.idMvoRechazoPk = idMvoRechazoPk;
		this.dscMvoRechazo = dscMvoRechazo;
	}

	@Id

	@Column(name = "ID_MVO_RECHAZO_PK", unique = true, nullable = false, precision = 22, scale = 0)
	/** 
	 * getters y setters 
	 * @return  idMvoRechazoPk
	 */
	public Long getIdMvoRechazoPk() {
		return this.idMvoRechazoPk;
	}

	/**
	 * 
	 * @param idMvoRechazoPk
	 * Llave
	 */
	public void setIdMvoRechazoPk(Long idMvoRechazoPk) {
		this.idMvoRechazoPk = idMvoRechazoPk;
	}

	@Column(name = "DSC_MVO_RECHAZO", length = 100)
	/**
	 * 
	 * @return dscMvoRechazo
	 */
	public String getDscMvoRechazo() {
		return this.dscMvoRechazo;
	}

	/**
	 * 
	 * @param dscMvoRechazo
	 * Motivo de rechazo
	 */
	public void setDscMvoRechazo(String dscMvoRechazo) {
		this.dscMvoRechazo = dscMvoRechazo;
	}


}
