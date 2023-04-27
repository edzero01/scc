package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.isban.scc.model.SccMxMaeMvosRechazo;
import mx.isban.scc.model.SccMxMaeSegmento;
import mx.isban.scc.model.SccMxMaeTipoProd;

/**
 * En esta class se definen todos los dto para catálogos: tipo de producto, Segmento y motivos de rechazo
 * 
 * @author GlobalHitss
 * Dado que no se ocupan todos los datos de todas las tablas se generan los DTO. 
 *
 */

public class SccMxMaeCatalogosDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeCatalogosDTO
	 */
	private static final long serialVersionUID = 8286883250926030205L;
	/**
	 * Lista de objetos SccMxMaeTipoProd para obtener el catalogo de productos
	 */
	private List<SccMxMaeTipoProd> sccMxMaeTipoProd;
	/**
	 * Lista de objetos SccMxMaeSegmento para obtener el catalogo de segmentos
	 */
	private List<SccMxMaeSegmento> sccMxMaeSegmento;
	/**
	 * Lista de objetos SccMxMaeMvosRechazo para obtener el catalogo de motivos de Rechazo
	 */
	private List<SccMxMaeMvosRechazo> sccMxMaeMvosRechazo;

	/**
	 * Constructor vacio
	 */
	public SccMxMaeCatalogosDTO() {
		super();
	}

	/**
	 * Setter para las listas de tipo de producto , segmento y motivos de rechazo
	 * @param sccMxMaeTipoProd
	 * tipo de producto 
	 * @param sccMxMaeSegmento
	 * segmento
	 * @param sccMxMaeMvosRechazo
	 * motivos de rechazo
	 */
	public SccMxMaeCatalogosDTO(List<SccMxMaeTipoProd> sccMxMaeTipoProd, List<SccMxMaeSegmento> sccMxMaeSegmento,
			List<SccMxMaeMvosRechazo> sccMxMaeMvosRechazo) {
		super();
		this.sccMxMaeTipoProd = new ArrayList<>(sccMxMaeTipoProd);
		this.sccMxMaeSegmento = new ArrayList<>(sccMxMaeSegmento);
		this.sccMxMaeMvosRechazo = new ArrayList<>(sccMxMaeMvosRechazo);
	}

	/**
	 * Obtiene los motivos de rechazo
	 * @return List(SccMxMaeMvosRechazo) lista de motivos de rechazo
	 */
	public List<SccMxMaeMvosRechazo> getSccMxMaeMvosRechazo() {
		return new ArrayList<>(sccMxMaeMvosRechazo);
	}

	/**
	 * Setea los motivos de rechazo
	 * @param sccMxMaeMvosRechazo List(SccMxMaeMvosRechazo) lista de motivos de rechazo
	 */
	public void setSccMxMaeMvosRechazo(List<SccMxMaeMvosRechazo> sccMxMaeMvosRechazo) {
		this.sccMxMaeMvosRechazo = new ArrayList<>(sccMxMaeMvosRechazo);
	}

	/**
	 * Obtiene el tipo de producto
	 * @return List(SccMxMaeTipoProd) lista de tipo de producto
	 */
	public List<SccMxMaeTipoProd> getSccMxMaeTipoProd() {
		return new ArrayList<>(sccMxMaeTipoProd);
	}

	/**
	 * Setea el tipo de producto 
	 * @param sccMxMaeTipoProd List(SccMxMaeTipoProd) lista de tipo de producto
	 */
	public void setSccMxMaeTipoProd(List<SccMxMaeTipoProd> sccMxMaeTipoProd) {
		this.sccMxMaeTipoProd = new ArrayList<>(sccMxMaeTipoProd);
	}

	/**
	 * Obtiene el segmento
	 * @return List(SccMxMaeSegmento) lista de segmento
	 */
	public List<SccMxMaeSegmento> getSccMxMaeSegmento() {
		return new ArrayList<>(sccMxMaeSegmento);
	}

	/**
	 * Setea lista de segmento
	 * @param sccMxMaeSegmento List(SccMxMaeSegmento) lista de segmento
	 */
	public void setSccMxMaeSegmento(List<SccMxMaeSegmento> sccMxMaeSegmento) {
		this.sccMxMaeSegmento = new ArrayList<>(sccMxMaeSegmento);
	}

}
