package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Se crea DTO auxiliar para retornar los DTO
 * de condiciones financieras y el monto linex 
 * asimismo la tabla matriz para pintar 
 * ofertas maximas
 * @author Ivan Cruz Azuara
 *
 */
public class SccMxLinexCondFinanAuxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8999060312852992067L;
	/**
	 * Lista de objetos SccMxMaeSegmento para obtener el catalogo de segmentos
	 */
	private List<SccMxMaeCondFinanLinexDTO> dtoCondFinLinex;
	/**
	 * Lista de objetos SccMxMaeMvosRechazo para obtener el catalogo de motivos de Rechazo
	 */
	private List<SccMxMaeCondFinanDTO> dtoCondFin;
	/**
	 * Setter para las listas de tipo de producto , segmento y motivos de rechazo
	 * @param dtoCondFin
	 * tipo de producto 
	 * @param dtoCondFinLinex
	 * segmento
	 * motivos de rechazo
	 */
	public SccMxLinexCondFinanAuxDTO(List<SccMxMaeCondFinanDTO> dtoCondFin, List<SccMxMaeCondFinanLinexDTO> dtoCondFinLinex) {
		super();
		this.dtoCondFin = new ArrayList<>(dtoCondFin);
		this.dtoCondFinLinex = new ArrayList<>(dtoCondFinLinex);
	}
	
	
	/**
	 * Metodo para obtener la lista de condiciones linex
	 * @return dtoCondFinLinex lista de condiciones linex 
	 */
	public List<SccMxMaeCondFinanLinexDTO> getDtoCondFinLinex() {
		return new ArrayList<>(dtoCondFinLinex);
	}
	
	
	/**
	 *  Metodo para colocar la lista de condiciones linex
	 * @param dtoCondFinLinex lista de condiciones linex
	 */
	public void setDtoCondFinLinex(List<SccMxMaeCondFinanLinexDTO> dtoCondFinLinex) {
		this.dtoCondFinLinex = new ArrayList<>(dtoCondFinLinex);
	}
	
	
	/**
	 * Metodo para colocar las condiciones financieras
	 * @return dtoCondFin lista de condiciones financieras
	 */
	public List<SccMxMaeCondFinanDTO> getDtoCondFin() {
		return new ArrayList<>(dtoCondFin);
	}
	
	
	/**
	 * metodo para colocar condiciones financieras
	 * @param dtoCondFin lista de condiciones financieras
	 */
	public void setDtoCondFin(List<SccMxMaeCondFinanDTO> dtoCondFin) {
		this.dtoCondFin = new ArrayList<>(dtoCondFin);
	}

	
	
}
