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
public class SccMxPlantillaDescDTO extends SccMxPlantillaDescPadreDTO implements Serializable {
	/**
	 * identificador para serializar la clase SccMxPeriodoPorIdProdDTO
	 */
	private static final long serialVersionUID = 8891123910256078173L;

	/**
	 * propiedad cat de la entidad
	 */
	private String catProm;

	/**
	 * propiedad entCred de la entidad
	 */
	private String entCred;

	/**
	 * propiedad tasa de la entidad
	 */
	private String tasaIntProm;

	/**
	 * propiedad nombre tarjeta de la entidad
	 */
	private String nomTarjeta;

	/**
	 * propiedad numero tarjeta de la entidad
	 */
	private String numtarjeta;

	/**
	 * propiedad factor asegurameiento de la entidad
	 */
	private String facAsegProm;

	/**
	 * getter cat promocional
	 * 
	 * @return catProm catProm
	 */
	public String getCatProm() {
		return catProm;
	}

	/**
	 * setter cat promocional
	 * 
	 * @param catProm catProm
	 */
	public void setCatProm(String catProm) {
		this.catProm = catProm;
	}

	/**
	 * getter entidad credito
	 * 
	 * @return entCred entCred
	 */
	public String getEntCred() {
		return entCred;
	}

	/**
	 * setter entidad credito
	 * 
	 * @param entCred entCred
	 */
	public void setEntCred(String entCred) {
		this.entCred = entCred;
	}

	/**
	 * getter tasa interes promocional
	 * 
	 * @return tasaIntProm tasaIntProm
	 */
	public String getTasaIntProm() {
		return tasaIntProm;
	}

	/**
	 * setter tasa interes promocional
	 * 
	 * @param tasaIntProm tasaIntProm
	 */
	public void setTasaIntProm(String tasaIntProm) {
		this.tasaIntProm = tasaIntProm;
	}

	/**
	 * getter nombre tarjeta
	 * 
	 * @return nomTarjeta nomTarjeta
	 */
	public String getNomTarjeta() {
		return nomTarjeta;
	}

	/**
	 * setter nombre tarjeta
	 * 
	 * @param nomTarjeta nomTarjeta
	 */
	public void setNomTarjeta(String nomTarjeta) {
		this.nomTarjeta = nomTarjeta;
	}

	/**
	 * getter numero tarjeta
	 * 
	 * @return numtarjeta numtarjeta
	 */
	public String getNumtarjeta() {
		return numtarjeta;
	}

	/**
	 * setter numero tarjeta
	 * 
	 * @param numtarjeta numtarjeta
	 */
	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}

	/**
	 * getter factor aseguramiento promocional
	 * 
	 * @return facAsegProm facAsegProm
	 */
	public String getFacAsegProm() {
		return facAsegProm;
	}

	/**
	 * setter factor aseguramiento promocional
	 * 
	 * @param facAsegProm facAsegProm
	 */
	public void setFacAsegProm(String facAsegProm) {
		this.facAsegProm = facAsegProm;
	}

}
