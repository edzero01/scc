package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para las plazos maximos de las ofertas de campaña
 * 
 * DTO para las plazos maximos de las ofertas de campaña compuesto por listas de
 * plazos y listas de montos de ofertas maximas promocionales Sprint 2 Global
 * Hitss Mayo 2019
 * 
 * @author Octavio Cruz Rosas
 *
 */
public class SccMxPrcOferMaxPlazoDTO implements Serializable{

	/**
	 * Serial version id de la clase
	 */
	private static final long serialVersionUID = 1691237858051758498L;

	/**
	 * Lista para almacenar los plazos de la oferta de campaña
	 */
	private List<Long> listaPlazos;

	/**
	 * Lista para almacenar los montos de crédito de la oferta de campaña
	 */
	private List<Double> listaMontos;

	/**
	 * Lista para almacenar los pagos correspondientes a la oferta de campaña
	 */
	private List<Double> listaPagos;

	/**
	 * Arreglo de lista para transportar los datos de la tabla ofertas maximas por
	 * plazo
	 */
	private List<List<Serializable>> matriz;

	/**
	 * Objeto que transporta la primer condición financiera para la tasa de interes
	 * base, periodo mensual y el menor plazo
	 */
	private SccMxMaeCondFinanDTO condicionFinanc = null;

	/**
	 * Constructor para inicializar al clase. Sprint 2 Mayo 2019
	 * 
	 * @param listaPlzos  lista con los plazos maximos de la oferta de campaña
	 * @param listaMontos lista con los montos de credito correspondientes para la
	 *                    oferta de campaña
	 * @param listaPagos2 lista con los pagos corrrespondientes para los plazos y
	 *                    los montos.
	 */
	public SccMxPrcOferMaxPlazoDTO(List<Long> listaPlzos, List<Double> listaMontos, List<Double> listaPagos2) {

		this.listaPlazos = new ArrayList<>(listaPlzos);
		this.listaMontos = new ArrayList<>(listaMontos);
		this.listaPagos = new ArrayList<>(listaPagos2);
	}

	/**
	 * Metodo constructor
	 * 
	 * @param listaPlzos  List(Long) lista plazos
	 * @param listaMontos List(Long) lista montos
	 */
	public SccMxPrcOferMaxPlazoDTO(List<Long> listaPlzos, List<Double> listaMontos) {

		this.listaPlazos = new ArrayList<>(listaPlzos);
		this.listaMontos = new ArrayList<>(listaMontos);
	}

	/**
	 * Método para solicitar el arreglo de datos
	 * 
	 * @return List(Object) arreglo de datos con la matriz
	 */
	public List<List<Serializable>> getMatriz() {
		return new ArrayList<>(matriz);
	}

	/**
	 * Método para setear el arreglo de datos
	 * 
	 * @param matriz List(List(Object)) matriz de datos de cálculo
	 */
	public void setMatriz(List<List<Serializable>> matriz) {
		this.matriz = new ArrayList<>(matriz);
	}

	/**
	 * Método para solicitar el arreglo de plazos
	 * 
	 * @return List(Long) Lista de plazos
	 */

	public List<Long> getListaPlazos() {
		return new ArrayList<>(listaPlazos);
	}

	/**
	 * Método para setear el la lista de plazos
	 * 
	 * @param listaPlazos List(Long) Lista de plazos
	 */
	public void setListaPlazos(List<Long> listaPlazos) {
		this.listaPlazos = new ArrayList<>(listaPlazos);
	}

	/**
	 * Método para setear el la lista de montos
	 * 
	 * @return List(Double) Lista de montos
	 */
	public List<Double> getListaMontos() {
		return new ArrayList<>(listaMontos);
	}

	/**
	 * Método para setear el arreglo de monto
	 * 
	 * @param listaMontos List(Double) Lista de montos
	 */
	public void setListaMontos(List<Double> listaMontos) {
		this.listaMontos = new ArrayList<>(listaMontos);
	}

	/**
	 * Método que devuel la lista de pagos
	 * 
	 * @return List(Double) Lista de pagos
	 */
	public List<Double> getListaPagos() {
		return new ArrayList<>(listaPagos);
	}

	/**
	 * Método de inicializa la lista de pagos
	 * 
	 * @param listaPagos List(Double) Lista de pagos
	 */
	public void setListaPagos(List<Double> listaPagos) {
		this.listaPagos = new ArrayList<>(listaPagos);
	}

	/**
	 * Regresa el objeto de condiciones financiearas almacenado en la clase
	 * 
	 * @return condicionFinanc Regresa el objeto de condiciones financieras (SccMxMaeCondFinanDTO)
	 */
	public SccMxMaeCondFinanDTO getCondicionFinanc() {
		return condicionFinanc;
	}

	/**
	 * Inicializa en ésta clase el objeto de condiciones financieras para utilizarlo
	 * posteriormente
	 * 
	 * @param condicionFinanc objeto de clase SccMxMaeCondFinanDTO de condiciones financieras
    */
	public void setCondicionFinanc(SccMxMaeCondFinanDTO condicionFinanc) {
		this.condicionFinanc = condicionFinanc;
	}

}