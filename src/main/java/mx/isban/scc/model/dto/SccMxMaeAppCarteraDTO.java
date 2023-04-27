package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Clase para definici&oacute;n de datos de Cartera
 * Tabla con la que se llevan los registros de creditos
 * ya otorgados y que pueden
 * restituirse en el simulador
 * 
 * @author Hitss
 *
 *         Julio 2019
 */
public class SccMxMaeAppCarteraDTO extends SccMxMaeAppCarteraPadreDTO implements Serializable {

	/**
	 * Serializacion de la clase SccMxMaeAppCarteraDTO
	 */
	private static final long serialVersionUID = -809382242294719504L;

	/**
	 * propiedad idCdto correspondiente a un cr&eacute;dito
	 *
	 */
	private Long idCdto;
	/**
	 * propiedad codProd c&oacute;digo del producto
	 */
	private Long codProd;
	/**
	 * propiedad numClte asociado al credito
	 */
	private Long numClte;
	/**
	 * propiedad numCdto corresponde al número del credito
	 */
	private Long numCdto;
	/**
	 * propiedad txtNomClte indica el nombre del cliente
	 */
	private String txtNomClte;

	/**
	 * Regresa el id del credito
	 * 
	 * @return idCdto id del credito
	 */
	public Long getIdCdto() {
		return idCdto;
	}

	/**
	 * Inicializa el id del cr&eacute;dito
	 * 
	 * @param idCdto id del credito
	 */
	public void setIdCdto(Long idCdto) {
		this.idCdto = idCdto;
	}

	/**
	 * Regresa el numero de cliente
	 * 
	 * @return numClte numero de cliente
	 */
	public Long getNumClte() {
		return numClte;
	}

	/**
	 * Inicializa el numero del cliente
	 * 
	 * @param numClte numero de cliente
	 */
	public void setNumClte(Long numClte) {
		this.numClte = numClte;
	}

	/**
	 * Regresa el numero de credito
	 * 
	 * @return numCdto numero de credito
	 */
	public Long getNumCdto() {
		return numCdto;
	}

	/**
	 * Inicializa el numero de credito
	 * 
	 * @param numCdto numero de credito
	 */
	public void setNumCdto(Long numCdto) {
		this.numCdto = numCdto;
	}

	/**
	 * Regresa el nombre del cliente
	 * 
	 * @return txtNomClte nombre del cliente
	 */
	public String getTxtNomClte() {
		return txtNomClte;
	}

	/**
	 * Inicializa el nombre del cliente
	 * 
	 * @param txtNomClte nombre del cliente
	 */
	public void setTxtNomClte(String txtNomClte) {
		this.txtNomClte = txtNomClte;
	}

	/**
	 * getter para el c&oacute;digo del producto
	 * 
	 * @return codProd c&oacute;digo del producto
	 */
	public Long getCodProd() {
		return codProd;
	}

	/**
	 * setter para el c&oacute;digo del producto
	 * 
	 * @param codProd c&oacute;digo del producto solo aceptara los 13
	 */
	public void setCodProd(Long codProd) {
		this.codProd = codProd;
	}

}
