package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Se crea DTO para guardar los datos de la tabla
 * de fondos de garantia contiene los id y descripciones
 * para ser enviados por el servicio correpondiente
 * @author Carlos ivan Cruz Azuara
 *
 */
public class SccMxMaeFondoGarantiaDTO implements Serializable {

	/**
	 *  identificador para serializar la clase SccMxMaeFondoGarantiaDTO
	 */
	private static final long serialVersionUID = 5822701156232622287L;

	/**
	 * Propiedad idFondoGarantiaPk de la entidad SccMxMaeFondoGarId 
	 */
	private Long idFondoGarantiaPk;
	/**
	 * Propiedad dscFondoGarantia de la entidad SccMxMaeFondoGarId 
	 */
	private String dscFondoGarantia;
	/**
	 * Propiedad comFondoGarantia de la entidad SccMxMaeFondoGarId 
	 */
	private Double comFondoGarantia;
	/**
	 * Propiedad para mostrar la descripcion y la comision  de la entidad SccMxMaeFondoGarId en una sola leyenda 
	 */
	private String desCompleta;
	
	
	
	/**
	 * constructor vacio
	 */
	public SccMxMaeFondoGarantiaDTO() {
		super();
	}

	
	/**
	 * Constructor con parametros
	 * @param idFondoGarantiaPk
	 * llave de Fondo Garantia
	 * @param dscFondoGarantia
	 * deescripcion de fondo de garantia
	 * @param comFondoGarantia
	 * comision Fondo garantia
	 * @author Ivan Cruz Azuara
	 */
	public SccMxMaeFondoGarantiaDTO(Long idFondoGarantiaPk, String dscFondoGarantia, Double comFondoGarantia) {
		super();
		this.idFondoGarantiaPk = idFondoGarantiaPk;
		this.dscFondoGarantia = dscFondoGarantia;
		this.comFondoGarantia = comFondoGarantia;
		this.desCompleta = dscFondoGarantia.concat(String.valueOf(comFondoGarantia));
	}


	/**
	 * Obtiene el idpk del fondo de garantia
	 * @return idFondoGarantiaPk Id del fondo de garantía
	 */
	public Long getIdFondoGarantiaPk() {
		return idFondoGarantiaPk;
	}


	/**
	 * Colocar el idpk del fondo de garantia
	 * @param  idFondoGarantiaPk  Id del fondo de garantía
	 */
	public void setIdFondoGarantiaPk(Long idFondoGarantiaPk) {
		this.idFondoGarantiaPk = idFondoGarantiaPk;
	}


	/**
	 *  Obtiene la descripcion del fondo de garantia
	 * @return dscFondoGarantia descripcion del fondo de garantia
	 */
	public String getDscFondoGarantia() {
		return dscFondoGarantia;
	}


	/**
	 * Coloca la descripcion del fondo de garantia
	 * @param dscFondoGarantia descripcion del fondo de garantia
	 */
	public void setDscFondoGarantia(String dscFondoGarantia) {
		this.dscFondoGarantia = dscFondoGarantia;
	}


	/**
	 * Obtiene la comision del fondo de garantia
	 * @return comFondoGarantia comision del fondo de garantia
	 */
	public Double getComFondoGarantia() {
		return comFondoGarantia;
	}


	/**
	 * Coloca el valor de la comision del fondo de garantia
	 * @param comFondoGarantia comision del fondo de garantia
	 */
	public void setComFondoGarantia(Double comFondoGarantia) {
		this.comFondoGarantia = comFondoGarantia;
	}


	/**
	 * Regresa la descripcion completa del fondo de garantia (desc plus comision)
	 * @return desCompleta descripcion completa del fondo de garantia (desc plus comision)
	 */
	public String getDesCompleta() {
		return desCompleta;
	}


	/**
	 * Guarda la descripcion completa del fondo de garantia (desc plus comision)
	 * @param desCompleta descripcion completa del fondo de garantia (desc plus comision)
	 */
	public void setDesCompleta(String desCompleta) {
		this.desCompleta = desCompleta;
	}

	
}
