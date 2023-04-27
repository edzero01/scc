package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Se crea DTO auxiliar para retornar los datos
 * de condiciones financieras y el monto linex cuando
 * se utiliza la Conversión Auto
 * asimismo la tabla matriz para pintar la tabla de
 * ofertas maximas
 * @author Ivan Cruz Azuara
 *
 */
public class SccMxConvAutoLinexDTO implements Serializable {

	/**
	 * Serializacion de la clase
	 */
	private static final long serialVersionUID = -3116287416597224899L;
	
	
	/**
	 * Numero de lapa consultado para conversion auto
	 */
	private Long numLapa;
		
	/**
	 * Factor del monto total obtenido a multiplicar
	 */
	private Double factorMontoTotal;
		
	/**
	 * Tasa de interés base obtenida para este segmento
	 */
	private Double tasaInteresBase;
	
	
	/**
	 * Plazo consultado, numero de meses a los que aplica
	 */
	private Long plazo;

	/**
	 * Constructor vacio
	 */
	public SccMxConvAutoLinexDTO() {
		super();
	}


	/**
	 * @return numLapa numero de lapa
	 */
	public Long getNumLapa() {
		return numLapa;
	}


	/**
	 * @param numLapa numero de lapa
	 */
	public void setNumLapa(Long numLapa) {
		this.numLapa = numLapa;
	}


	/**
	 * @return factorMontoTotal factor monto total
	 */
	public Double getFactorMontoTotal() {
		return factorMontoTotal;
	}


	/**
	 * @param factorMontoTotal factor monto total
	 */
	public void setFactorMontoTotal(Double factorMontoTotal) {
		this.factorMontoTotal = factorMontoTotal;
	}


	/**
	 * @return tasaInteresBase tasa de interes base
	 */
	public Double getTasaInteresBase() {
		return tasaInteresBase;
	}


	/**
	 * @param tasaInteresBase tasa de interes base
	 */
	public void setTasaInteresBase(Double tasaInteresBase) {
		this.tasaInteresBase = tasaInteresBase;
	}


	/**
	 * Obtener el plazo obtenido
	 * @return plazo plazo obtenido
	 */
	public Long getPlazo() {
		return plazo;
	}


	/**
	 * Asignar el plazo consultado
	 * @param plazo plazo obtenido
	 */
	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}

	
}
