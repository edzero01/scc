package mx.isban.scc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de apoyo que consulta las ofertas de campaña, las ofertas de campaña
 * promocionales y las ofertas de campaña promocionales de mercado abierto
 * Sprint 2 Junio 2019
 * 
 * @author Hitss
 *
 */
public class BuscaOfertasCampaniaVO implements Serializable {

	/**
	 * Serializador de la clase
	 */
	private static final long serialVersionUID = -5511196228658929123L;

	/**
	 * Lista que almacena las ofertas de campaña
	 */
	private List<SccMxMaeOferCam> ltSccMxMaeOferCam;
	/**
	 * Lista que almacena las ofertas promocionales de campaña
	 */
	private List<SccMxMaeOferPromCam> ltSccMxMaeOferPromCam;
	/**
	 * Lista que almacena las ofertas de campaña de maercado abierto
	 */
	private List<SccMxMaeOferPromMa> ltSccMxMaeOferPromMa;

	/**
	 * Devuelve la lista de las ofertas de campaña
	 * 
	 * @return ltSccMxMaeOferCam lista de las ofertas de campaña
	 */
	public List<SccMxMaeOferCam> getLtSccMxMaeOferCam() {
		return new ArrayList<>(ltSccMxMaeOferCam);
	}

	/**
	 * Método que inicializa la lista de las ofertas de campaña
	 * 
	 * @param ltSccMxMaeOferCam lista de las ofertas de campaña
	 */
	public void setLtSccMxMaeOferCam(List<SccMxMaeOferCam> ltSccMxMaeOferCam) {
		this.ltSccMxMaeOferCam = new ArrayList<>(ltSccMxMaeOferCam);
	}

	/**
	 * Método que devuelve la lista de las ofertas promocionales de campaña
	 * 
	 * @return ltSccMxMaeOferPromCam lista de las ofertas promocionales de campaña
	 */
	public List<SccMxMaeOferPromCam> getLtSccMxMaeOferPromCam() {
		return new ArrayList<>(ltSccMxMaeOferPromCam);
	}

	/**
	 * Método que inicaliza la lista de las ofertas promocionales de campaña
	 * 
	 * @param ltSccMxMaeOferPromCam lista de las ofertas promocionales de campaña
	 */
	public void setLtSccMxMaeOferPromCam(List<SccMxMaeOferPromCam> ltSccMxMaeOferPromCam) {
		this.ltSccMxMaeOferPromCam = new ArrayList<>(ltSccMxMaeOferPromCam);
	}

	/**
	 * Método que devuelve la lista de las ofetas promocionales de campaña para
	 * mercado abierto
	 * 
	 * @return List of SccMxMaeOferPromMa lista de las ofetas promocionales de campaña para mercado abierto
	 */
	public List<SccMxMaeOferPromMa> getLtSccMxMaeOferPromMa() {
		return new ArrayList<>(ltSccMxMaeOferPromMa);
	}

	/**
	 * Método que inicializa la lista de las ofertas promocionales de campaña para
	 * mercado abierto
	 * 
	 * @param ltSccMxMaeOferPromMa lista de las ofetas promocionales de campaña para mercado abierto
	 */
	public void setLtSccMxMaeOferPromMa(List<SccMxMaeOferPromMa> ltSccMxMaeOferPromMa) {
		this.ltSccMxMaeOferPromMa = new ArrayList<>(ltSccMxMaeOferPromMa);
	}

}
