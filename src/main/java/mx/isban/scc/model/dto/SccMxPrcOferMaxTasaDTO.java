package mx.isban.scc.model.dto;

import java.io.Serializable;


/**
 * Dto de todas las tasas maximas de las ofertas de campaña
 * Sprin 2
 * Mayo 2019
 * @author Octavio Cruz
 */
public class SccMxPrcOferMaxTasaDTO implements Serializable{
	
	/**
	 * identificador para serializar la clase SccMxPrcOferMaxTasaDTO
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * id de tasa maxima para la campaña
	 */
	private Long idOferMaxTasaPk;
	
	/**
	 * id de la campaña
	 */
	private Long idOferCam;
	
	/**
	 * Codigo de la tasa
	 */
	private String codTasa;
	
	/**
	 * porcentaje de la tasa
	 */
	private Double porTasa;
	
/**
 * Constructor de la clase para inicializar los  parametros 
 * @param idOferMaxTasaPk2
 * idOferMaxTasaPk2
 * @param idOferCamPk
 * idOferCamPk
 * @param codTasa2
 * codTasa2
 * @param porTasa2
 * porTasa2
 */
	public SccMxPrcOferMaxTasaDTO(Long idOferMaxTasaPk2, Long idOferCamPk, String codTasa2, Double porTasa2) {
		
		this.idOferMaxTasaPk = idOferMaxTasaPk2;
		this.idOferCam = idOferCamPk;
		this.codTasa = codTasa2;
		this.porTasa = porTasa2;
	}

	

	
	
	/**
	 * Devuelve el id de la tasa maxima para la campaña
	 * @return idOferMaxTasaPk Id de la tasa máxima de la oferta
	 */
	public Long getIdOferMaxTasaPk() {
		return idOferMaxTasaPk;
	}

	/**
	 * Inicializa el id de la tasa
	 * @param idOferMaxTasaPk Id de la tasa máxima de la oferta
	 */
	public void setIdOferMaxTasaPk(Long idOferMaxTasaPk) {
		this.idOferMaxTasaPk = idOferMaxTasaPk;
	}

	/**
	 * Devuelve el id de la oferta de campaña
	 * @return idOferCam Id de la oferta de campaña
	 */
	public Long getIdOferCam() {
		return idOferCam;
	}
	
	/**
	 * Inicializa el id de la oferta de campaña
	 * @param idOferCam Id de la oferta de campaña
	 */
	public void setIdOferCam(Long idOferCam) {
		this.idOferCam = idOferCam;
	}

	/**
	 * Devuelve el codigo asociado a la tasa
	 * @return codTasa Código de la tasa
	 */
	public String getCodTasa() {
		return codTasa;
	}

	/**
	 * Inicializa el codigo de la tasa
	 * @param codTasa Código de la tasa
	 */
	public void setCodTasa(String codTasa) {
		this.codTasa = codTasa;
	}

	/**
	 * Devuelve el porcentaja de la tasa de interes
	 * @return porTasa Porcentaje de la tasa
	 */
	public Double getPorTasa() {
		return porTasa;
	}

	/**
	 * Inicializa el porcentaje de la tasa.
	 * @param porTasa Porcentaje de la tasa
	 */
	public void setPorTasa(Double porTasa) {
		this.porTasa = porTasa;
	}

}
