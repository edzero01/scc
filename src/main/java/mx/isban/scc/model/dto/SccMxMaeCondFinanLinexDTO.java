package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para condiciones financieras
 * 
 * @author Ivan Cruz Azuara
 * Julio 2019
 * Sprint 3.2
 *
 */
public class SccMxMaeCondFinanLinexDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeCondFinanDTO
	 */
	private static final long serialVersionUID = -2149616196884409096L;
	/**
	 * Lista para almacenar los plazos de la oferta de campaña
	 */
	private List<Long> listaPlazosLinex;

	/**
	 * Lista para almacenar los montos de crédito de la oferta de campaña
	 */
	private List<Double> listaMontosLinex;

	/**
	 * Lista para almacenar los pagos correspondientes a la oferta de campaña
	 */
	private List<Double> listaPagosLinex;
	/**
	 * Lista para almacenar las tasas
	 */
	private List<Double> listaTasasLinex;

	/**
	 * Arreglo de lista para transportar los datos de la tabla ofertas maximas por
	 * plazo
	 */
	private List<List<Serializable>> matriz;
	/**
	 *  numero de tarjeta asociada linex 
	 **/
	private String numTarjetaLinex;
	/**
	 *  numero de LAPA Linex
	 **/
	private Long numLapaLinex;
	/**
	 *  Saldo Linex a Restituir
	 **/
	private Double saldoCreditoRestituir;
	/**
	 *  Saldo Linex a Restituir
	 **/
	private Double bonificionSegLinex;

	
	/**
	 * Lista de condiciones financieras promocionales para Linex
	 */
	private List<SccMxMaeCondFinanDTO> condFinPromoLinex;
	
	/**
	 * constructor vacio
	 */
	public SccMxMaeCondFinanLinexDTO() {
		super();
	}
	
	
	/**
	 * Método para solicitar el arreglo de datos
	 * 
	 * @return List(matriz) Arreglo de lista para transportar los datos de la tabla ofertas maximas por plazo
	 */
	public List<List<Serializable>> getMatriz() {
		return new ArrayList<>(matriz);
	}

	/**
	 * Método para setear el arreglo de datos
	 * 
	 * @param matriz List((List(Serializable)) Arreglo de lista para transportar los datos de la tabla ofertas maximas por plazo

	 */
	public void setMatriz(List<List<Serializable>> matriz) {
		this.matriz = new ArrayList<>(matriz);
	}

	/**
	 * Método para solicitar el arreglo de plazos
	 * 
	 * @return List(listaPlazosLinex) regresa lista de plazos
	 */

	public List<Long> getListaPlazosLinex() {
		return new ArrayList<>(listaPlazosLinex);
	}

	/**
	 * Método para setear el la lista de plazos
	 * 
	 * @param listaPlazos List(Long) listaPlazos lista de plazos para LINEX
	 */
	public void setListaPlazosLinex(List<Long> listaPlazos) {
		this.listaPlazosLinex = new ArrayList<>(listaPlazos);
	}

	/**
	 * Método para setear el la lista de plazos
	 * 
	 * @return List(Double) listaMontoLinex lista de montos para LINEX
	 */
	public List<Double> getListaMontosLinex() {
		return new ArrayList<>(listaMontosLinex);
	}

	/**
	 * Método para setear el arreglo de monto
	 * 
	 * @param listaMontos List(Double) Lista de montos LINEX
	 */
	public void setListaMontosLinex(List<Double> listaMontos) {
		this.listaMontosLinex = new ArrayList<>(listaMontos);
	}

	/**
	 * Método que devuel la lista de pagos
	 * 
	 * @return List(Double) lista de pagos
	 */
	public List<Double> getListaPagosLinex() {
		return new ArrayList<>(listaPagosLinex);
	}

	/**
	 * Método de inicializa la lista de pagos
	 * 
	 * @param listaPagos List(Double) Lista de pagos
	 */
	public void setListaPagosLinex(List<Double> listaPagos) {
		this.listaPagosLinex = new ArrayList<>(listaPagos);
	}

	
	/**
	 * Método que devuel la lista de Tasas
	 * 
	 * @return List(Double) Lista de Tasas
	 */
	public List<Double> getListaTasasLinex() {
		return new ArrayList<>(listaTasasLinex);
	}

	/**
	 * Método de inicializa la lista de tasas
	 * 
	 * @param listaTasas List(Double) Lista de Tasas
	 */
	public void setListaTasasLinex(List<Double> listaTasas) {
		this.listaTasasLinex = new ArrayList<>(listaTasas);
	}	

	/**
	 * Obtiene Numero de tarjeta linex
	 * @return numTarjetaLinex Número de tarjeta LINEX
	 */
	public String getNumTarjetaLinex() {
		return numTarjetaLinex;
	}

	
	/**
	 * Coloca Numero de tarjeta linex
	 * @param numTarjetaLinex  Número de tarjeta LINEX
	 */
	public void setNumTarjetaLinex(String numTarjetaLinex) {
		this.numTarjetaLinex = numTarjetaLinex;
	}
	
	/**
	 * Obtiene la LAPA
	 * @return numLapaLinex Número LAPA
	 * Improtante para relacionar con 
	 * conversion auto
	 */
	public Long getNumLapaLinex() {
		return this.numLapaLinex;
	}

	/**
	 * Setea la numLapa
	 * @param numLapaLinex  Número LAPA
	 * relacionada con convAuto
	 */
	public void setNumLapaLinex(Long numLapaLinex) {
		this.numLapaLinex = numLapaLinex;
	}


	/**
	 * Se regresa el saldo a restituir de Linex 
	 * obtenido de tabla variables PAMPA
	 * @return saldoCreditoRestituir Saldo del crédito a restituír
	 */
	public Double getSaldoCreditoRestituir() {
		return saldoCreditoRestituir;
	}


	/**
	 * Se coloca saldo a restituir de credito linex
	 * @param saldoCreditoRestituir Saldo del crédito a restituír
	 */
	public void setSaldoCreditoRestituir(Double saldoCreditoRestituir) {
		this.saldoCreditoRestituir = saldoCreditoRestituir;
	}


	/**
	 * Obtener bonificacion linex/prima devengada
	 * @return bonificionSegLinex Bonificación de seguro/Prima devengada LINEX
	 */
	public Double getBonificionSegLinex() {
		return bonificionSegLinex;
	}


	/**
	 * Colocar prima devengada linex
	 * @param bonificionSegLinex Bonificación de seguro/Prima devengada LINEX
	 */
	public void setBonificionSegLinex(Double bonificionSegLinex) {
		this.bonificionSegLinex = bonificionSegLinex;
	}


	/**
	 * Leer las condiciones financieras promocionales de Linex
	 * @return  List(SccMxMaeCondFinanDTO) Lista de condiciones financieras promocionales de Linex
	 */
	public List<SccMxMaeCondFinanDTO> getCondFinPromoLinex() {
		return new ArrayList<>(condFinPromoLinex);
	}


	/**
	 * Colocar la lista de promociones financieras Linex
	 * @param condFinPromoLinex List(SccMxMaeCondFinanDTO) Lista de condiciones financieras promocionales de Linex
	 */
	public void setCondFinPromoLinex(List<SccMxMaeCondFinanDTO> condFinPromoLinex) {
		this.condFinPromoLinex = new ArrayList<> (condFinPromoLinex);
	}

	
}
