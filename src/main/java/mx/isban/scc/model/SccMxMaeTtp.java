package mx.isban.scc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Campos de entidad
 * Entidad usada para obtener
 * datos de tabla de 
 * Tooltips
 * SCC_MX_MAE_TTP
 * @author Hitss
 * 2019-2020
 */
@Entity
@Table(name="SCC_MX_MAE_TTP")
public class SccMxMaeTtp implements IAbstractEntity,java.io.Serializable {
	
	/**
	 * Identificador para serializar la clase 
	 */
	private static final long serialVersionUID = -1553977927328791975L;
	
	/**
	 * propiedad idTtpPk de la entidad SccMxMaeTtp
	 * Llave principal y unica
	 */
	@Id	
	@Column(name = "ID_TTP_PK", unique = true, nullable = false, precision = 22, scale = 0)
	@SequenceGenerator(name="SCC_MX_MAE_TOOLTIPS_GEN", sequenceName="SCC_MX_MAE_TTP_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCC_MX_MAE_TOOLTIPS_GEN")
	private Long idTtpPk;
	
	/**
	 * propiedad idVarFk de la entidad SccMxMaeTtp
	 * Foreign Key con la variable asignada al tooltip
	 */
	@Id	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_VAR_FK")
	private SccMxPrcGstVariables idVarFk;
	
	/**
	 * propiedad idTipoProdFk de la entidad SccMxMaeTtp
	 * Foreign Key con el tipo de producto 
	 */
	@OneToOne
	@JoinColumn(name="ID_TIPO_PROD_FK")
	private SccMxMaeTipoProd idTipoProdFk;

	/**
	 * propiedad idSubProdFk de la entidad SccMxMaeTtp
	 * Foreign Key con el subproducto asignado al tooltip
	 */
	@OneToOne
	@JoinColumn(name="ID_SUB_PROD_FK")
	private SccMxMaeSubProd idSubProdFk;
	
	/**
	 * propiedad idApartadoFk de la entidad SccMxMaeTtp
	 * Foreign Key al catalogo de apartados: 
	 * Oferta Actual, Promocional, Auto, Ahorro
	 */
	@OneToOne
	@JoinColumn(name="ID_APARTADO_FK")
	private SccMxMaeApartados idApartadoFk;
	
	/**
	 * propiedad txtTtp de la entidad SccMxMaeTtp
	 * Texto que es el contenido del tooltip
	 */
	private String txtTtp;
	
	/**
	 * constructor sin argumentos
	 */
	public SccMxMaeTtp() {
		
	}

	/**
	 * constructor con los argumentos
	 * de todas las propiedades
	 * por default
	 * @param idTtpPk
	 * propiedad idTtpPk
	 * @param idVarFk
	 * propiedad idVarFk
	 * @param idTipoProdFk
	 * propiedad idTipoProdFk
	 * @param idSubProdFk
	 * propiedad idSubProdFk
	 * @param idApartadoFk
	 * propiedad idApartadoFk
	 * @param txtTtp
	 * propiedad txtTtp
	 */
	public SccMxMaeTtp(Long idTtpPk, SccMxPrcGstVariables idVarFk, SccMxMaeTipoProd idTipoProdFk,
			SccMxMaeSubProd idSubProdFk, SccMxMaeApartados idApartadoFk, String txtTtp) {
		this.idTtpPk = idTtpPk;
		this.idVarFk = idVarFk;
		this.idTipoProdFk = idTipoProdFk;
		this.idSubProdFk = idSubProdFk;
		this.idApartadoFk = idApartadoFk;
		this.txtTtp = txtTtp;
	}

	/**
	 * @return Long idTtpPk
	 */
	public Long getIdTtpPk() {
		return idTtpPk;
	}

	/**
	 * @param idTtpPk Long
	 */
	public void setIdTtpPk(Long idTtpPk) {
		this.idTtpPk = idTtpPk;
	}

	/**
	 * @return SccMxPrcGstVariables idVarFk
	 */
	public SccMxPrcGstVariables getIdVarFk() {
		return idVarFk;
	}

	/**
	 * @param idVarFk SccMxPrcGstVariables
	 */
	public void setIdVarFk(SccMxPrcGstVariables idVarFk) {
		this.idVarFk = idVarFk;
	}


	/**
	 * @return SccMxMaeTipoProd idTipoProdFk
	 */ 
	public SccMxMaeTipoProd getIdTipoProdFk() {
		return idTipoProdFk;
	}

	/**
	 * @param idTipoProdFk SccMxMaeTipoProd
	 */
	public void setIdTipoProdFk(SccMxMaeTipoProd idTipoProdFk) {
		this.idTipoProdFk = idTipoProdFk;
	}

	/**
	 * @return SccMxMaeSubProd idSubProdFk
	 */
	public SccMxMaeSubProd getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * @param idSubProdFk SccMxMaeSubProd
	 */
	public void setIdSubProdFk(SccMxMaeSubProd idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

	/**
	 * @return SccMxMaeApartados idApartadoFk
	 */
	public SccMxMaeApartados getIdApartadoFk() {
		return idApartadoFk;
	}

	/**
	 * @param idApartadoFk SccMxMaeApartados
	 */
	public void setIdApartadoFk(SccMxMaeApartados idApartadoFk) {
		this.idApartadoFk = idApartadoFk;
	}

	/**
	 * @return String txtTtp
	 */
	public String getTxtTtp() {
		return txtTtp;
	}

	/**
	 * @param txtTtp String
	 */
	public void setTxtTtp(String txtTtp) {
		this.txtTtp = txtTtp;
	}
	
}