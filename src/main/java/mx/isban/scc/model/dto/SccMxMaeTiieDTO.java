package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Se crea DTO para guardar los datos
 *  de la tabla de tasas TIIE
 * @author Carlos ivan Cruz Azuara
 *
 */
public class SccMxMaeTiieDTO implements Serializable{

	/**
	 *  identificador para serializar la clase SccMxMaeFondoGarantiaDTO
	 */
	private static final long serialVersionUID = -5193001653310629268L;
	
	/**
	 * Propiedad idTasaTiiePk de la entidad SccMxMaeTiie 
	 */
	private Long idTasaTiiePk;
	/**
	 * Propiedad porcTasaTiie de la entidad SccMxMaeTiie 
	 */
	private Double porcTasaTiie;
	
	/**
	 * Constructor vacio del DTIO para tasa TIEE
	 * No se ocupa de momento
	 * **/
	public SccMxMaeTiieDTO() {
		super();
	}


	/**
	 * Obtiene el valor del ID de la tasa TIIE 
	 * @return idTasaTiiePk ID de la tasa TIIE 
	 */
	public Long getIdTasaTiiePk() {
		return idTasaTiiePk;
	}


	/**
	 * Coloca el valor del PK de la tasa Tiie
	 * @param idTasaTiiePk ID de la tasa TIIE 
	 */
	public void setIdTasaTiiePk(Long idTasaTiiePk) {
		this.idTasaTiiePk = idTasaTiiePk;
	}


	/**
	 * Metodo que devuelve el valor de la tasa
	 * @return porcTasaTiie porcentaje de la tasa TIIE 
	 */
	public Double getPorcTasaTiie() {
		return porcTasaTiie;
	}


	/**
	 * Metodo para colocar el valor de la tasa
	 * @param porcTasaTiie porcentaje de la tasa TIIE
	 */
	public void setPorcTasaTiie(Double porcTasaTiie) {
		this.porcTasaTiie = porcTasaTiie;
	}

}
