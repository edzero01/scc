package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * DTO para generar información para llenar plantillas de certificados de
 * descuento
 * 
 * Sprint 4 Julio 2019
 * 
 * @author Christopher Espina Riveros
 *
 */
public class SccMxPlantillaDescPadreDTO implements Serializable {
	/**
	 * identificador para serializar la clase SccMxPeriodoPorIdProdDTO
	 */
	private static final long serialVersionUID = 8891123910256078173L;
	/**
	 * propiedad plantilla de la entidad
	 */
	protected String plantilla;

	/**
	 * propiedad nombre prom de la entidad
	 */
	protected String nomProm;

	/**
	 * propiedad nomColect de la entidad
	 */
	protected String nomColect;

	/**
	 * propiedad nomCliente de la entidad
	 */
	protected String nomCliente;

	/**
	 * propiedad nomComProm de la entidad
	 */
	protected String nomComProm;

	/**
	 * propiedad comProm de la entidad
	 */
	protected String comProm;

	/**
	 * getter plantilla
	 * 
	 * @return plantilla plantilla
	 */
	public String getPlantilla() {
		return plantilla;
	}

	/**
	 * setter plantilla
	 * 
	 * @param plantilla plantilla
	 */
	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * getter nombre promocion
	 * 
	 * @return nomProm nomProm
	 */
	public String getNomProm() {
		return nomProm;
	}

	/**
	 * setter nombre promocion
	 * 
	 * @param nomProm nomProm
	 */
	public void setNomProm(String nomProm) {
		this.nomProm = nomProm;
	}

	/**
	 * getter nombre colectivo
	 * 
	 * @return nomColect nomColect
	 */
	public String getNomColect() {
		return nomColect;
	}

	/**
	 * setter nombre colectivo
	 * 
	 * @param nomColect nomColect
	 */
	public void setNomColect(String nomColect) {
		this.nomColect = nomColect;
	}

	/**
	 * getter nombre cliente prom
	 * 
	 * @return nomCliente nomCliente
	 */
	public String getNomCliente() {
		return nomCliente;
	}

	/**
	 * setter nombre cliente prom
	 * 
	 * @param nomCliente nomCliente
	 */
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	/**
	 * getter nombre com prom
	 * 
	 * @return nomComProm nomComProm
	 */
	public String getNomComProm() {
		return nomComProm;
	}

	/**
	 * setter nombre com prom
	 * 
	 * @param nomComProm nomComProm
	 */
	public void setNomComProm(String nomComProm) {
		this.nomComProm = nomComProm;
	}

	/**
	 * getter com prom
	 * 
	 * @return comProm comProm
	 */
	public String getComProm() {
		return comProm;
	}

	/**
	 * setter com prom
	 * 
	 * @param comProm comProm
	 */
	public void setComProm(String comProm) {
		this.comProm = comProm;
	}

}
