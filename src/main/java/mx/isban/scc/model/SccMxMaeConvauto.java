package mx.isban.scc.model;
// Generated 26/04/2019 10:00:38 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Conversión Auto
 * Esta tabla relaciona el Segmento con el porcentaje para
 * la conversión Auto (apartado en front end)
 * Y también el porcentaje de Tasa por LAPA
 * SccMxMaeConvauto generated by hbm2java
 */
@Entity
@Table(name = "SCC_MX_MAE_CONVAUTO")
public class SccMxMaeConvauto implements IAbstractEntity, java.io.Serializable {

	/**
	 * Llave para identificar la serialización
	 */
	private static final long serialVersionUID = -8981468984693277409L;
	/**
	 * Llave principal, unica yd efinida por el usuario de la entidad SccMxMaeConvauto
	 */
	private Long idConvautoPk;
	/**
	 * Valor de la tasa que aplica como descuento
	 */
	private Double porTasa;
	/**
	 * Numero de LAPA que aplica si la conversion auto es para LINEX
	 */
	private Long numLapa;
	/**
	 * Descripcion del Segmento (Premier, Clasico, Select )
	 */
	private String dscSegmentoConsolidado;	
	/**
	 * Identificador del Subproducto para conocer las condiciones financieras de esta conversion auto
	 */
	private Long idSubProdFk;
	
	/**
	 * constructor super
	 */
	public SccMxMaeConvauto() {
	}

	/**
	 * Setea la informaci_n de convAuto
	 * @param idConvautoPk
	 * Primary key para identificar
	 * @param porTasa
	 * Porcentaje Tasa 
	 * @param numLapa
	 * Numero de Lapa
	 */
	public SccMxMaeConvauto(Long idConvautoPk, Double porTasa, Long numLapa) {
		this.idConvautoPk = idConvautoPk;
		this.porTasa = porTasa;
		this.numLapa = numLapa;
	}

	/**
	 * Setea la info considerando el segmento
	 * @param sccMxMaeSegmento
	 * Segmento amarrado a convauto
	 * @param idConvautoPk
	 * Primary key para identificar
	 * @param porTasa
	 * Porcentaje Tasa 
	 * @param numLapa
	 * Numero de Lapa
	 */
	public SccMxMaeConvauto(Long idConvautoPk, SccMxMaeSegmento sccMxMaeSegmento, Double porTasa, Long numLapa) {
		this.idConvautoPk = idConvautoPk;
		this.porTasa = porTasa;
		this.numLapa = numLapa;
	}

	/**
	 * @return Long idConvautoPk
	 */
	@Id
	@Column(name = "ID_CONVAUTO_PK", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdConvautoPk() {
		return this.idConvautoPk;
	}

	/**
	 * @param idConvautoPk Long
	 */
	public void setIdConvautoPk(Long idConvautoPk) {
		this.idConvautoPk = idConvautoPk;
	}

	/**
	 * @return porTasa Porcentaje de tasa de interés
	 */ 
	@Column(name = "POR_TASA", nullable = false, precision = 22, scale = 0)
	public Double getPorTasa() {
		return this.porTasa;
	}

	/**
	 * @param porTasa Porcentaje de tasa de interés
	 */
	public void setPorTasa(Double porTasa) {
		this.porTasa = porTasa;
	}

	/** 
	 * @return numLapa Número de LAPA
	 */
	@Column(name = "NUM_LAPA", nullable = false, precision = 22, scale = 0)
	public Long getNumLapa() {
		return this.numLapa;
	}
	
	/**
	 * Nada mas para ver si esto tambien se debe documentar
	 * @param numLapa Número de LAPA
	 * Lapa que relaciona al producto con ConvAuto
	 */
	public void setNumLapa(Long numLapa) {
		this.numLapa = numLapa;
	}
	
	
	/**
	 * @return dscSegmentoConsolidado Descripción del segmento consolidado
	 */
	@Column(name = "DSC_SEGMENTO_CONSOLIDADO", nullable = false, precision = 22, scale = 0)
	public String getDscSegmentoConsolidado() {
		return dscSegmentoConsolidado;
	}

	/**
	 * @param dscSegmentoConsolidado Descripción del segmento consolidado
	 */
	public void setDscSegmentoConsolidado(String dscSegmentoConsolidado) {
		this.dscSegmentoConsolidado = dscSegmentoConsolidado;
	}

	/**
	 * @return idSubProdFk Id de subproducto
	 */
	@Column(name = "ID_SUB_PROD_FK", nullable = false, precision = 22, scale = 0)
	public Long getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * @param idSubProdFk Id de subproducto
	 */
	public void setIdSubProdFk(Long idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

}
