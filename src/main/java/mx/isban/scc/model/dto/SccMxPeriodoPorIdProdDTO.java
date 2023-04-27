package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Dto de periodos por producto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 * DTO de Periodicidad por Id de Producto
 */

public class SccMxPeriodoPorIdProdDTO implements Serializable{


	/**
	 * identificador para serializar la clase SccMxPeriodoPorIdProdDTO
	 */
	private static final long serialVersionUID = 8891123910256078173L;
	/**
	 * Propiedad idProdPk de la entidad producto 
	 */
	private Long idProdPk;
	/**
	 * Propiedad codProd de la entidad producto 
	 */
	private Long codProd;
	/**
	 * Propiedad dscPeriodicidad de la entidad periodicidad 
	 */
	private String dscPeriodicidad;
	/**
	 * Propiedad idPeriodicidad de la entidad periodicidad corresponde a codProd
	 */
	private String idPeriodicidad;
	/**
	 * Propiedad codigoGracia de la entidad periodicidad 
	 */
	private String codigoGracia;
	/**
	 * Propiedad idPeriodicidadPk de la entidad periodicidad 
	 */
	private Long idPeriodicidadPk;

	/**
	 * constructor vacio
	 */
	public SccMxPeriodoPorIdProdDTO() {
		super();
	}

	/**
	 * Constructor con par_metros
	 * @param idProdPk
	 * llave de producto
	 * @param codProd
	 * codigo de producto
	 * @param dscPeriodicidad
	 * descripcion de periodicidad
	 * @param idPeriodicidad
	 * id de periodicidad
	 * @param codigoGracia
	 * codigo de gracia
	 */
	public SccMxPeriodoPorIdProdDTO(Long idProdPk, Long codProd, String dscPeriodicidad, String idPeriodicidad, String codigoGracia) {
		super();
		this.idProdPk = idProdPk;
		this.codProd = codProd;
		this.dscPeriodicidad = dscPeriodicidad;
		this.idPeriodicidad = idPeriodicidad;
		this.codigoGracia = codigoGracia;
	}
	
	/**
	 * Obtiene el idpk de la periodicidad
	 * @return idPeriodicidadPk Id de la periodicidad 
	 */
	public Long getIdPeriodicidadPk() {
		return idPeriodicidadPk;
	}
	/**
	 * Setea el idpk de la periodicidad
	 * @param idPeriodicidadPk  Id de la periodicidad
	 */
	public void setIdPeriodicidadPk(Long idPeriodicidadPk) {
		this.idPeriodicidadPk = idPeriodicidadPk;
	}

	/**
	 * Obtiene el código de gracia
	 * @return codigoGracia Código de gracia
	 */
	public String getCodigoGracia() {
		return codigoGracia;
	}

	/**
	 * Inicializa el código de gracia
	 * @param codigoGracia Código de gracia
	 */
	public void setCodigoGracia(String codigoGracia) {
		this.codigoGracia = codigoGracia;
	}

	/**
	 * regresa el id del producto
	 * @return idProdPk Id de producto
	 */
	public Long getIdProdPk() {
		return idProdPk;
	}

	/**
	 * inicializa el id de producto
	 * @param idProdPk Id de producto
	 */
	public void setIdProdPk(Long idProdPk) {
		this.idProdPk = idProdPk;
	}

	/**
	 * Regresa el c_digo del producto
	 * @return codProd Código de producto
	 */
	public Long getCodProd() {
		return codProd;
	}

	/**
	 * Inicializa el c_digo del producto
	 * @param codProd Código de producto
	 */
	public void setCodProd(Long codProd) {
		this.codProd = codProd;
	}

	/**
	 * Regresa la descripción de la periodicidad
	 * @return periodicidad Descripción de la periodicidad
	 */
	public String getDscPeriodicidad() {
		return dscPeriodicidad;
	}

	/**
	 * Inicializa la descripción de la periodicidad
	 * @param dscPeriodicidad Descripción de la periodicidad
	 */
	public void setDscPeriodicidad(String dscPeriodicidad) {
		this.dscPeriodicidad = dscPeriodicidad;
	}

	/**
	 * Regresa el id de periodicidad
	 * @return idPeriodicidad Id de la periodicidad
	 */
	public String getIdPeriodicidad() {
		return idPeriodicidad;
	}

	/**
	 * Inicializa el id de la periodicidad
	 * @param idPeriodicidad Id de la periodicidad
	 */
	public void setIdPeriodicidad(String idPeriodicidad) {
		this.idPeriodicidad = idPeriodicidad;
	}

}
