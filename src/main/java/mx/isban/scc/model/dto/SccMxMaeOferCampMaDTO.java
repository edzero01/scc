package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Dto de todas las ofertas, permite al simulador conocer si el cliente
 * esta en una campaña y si a su vez tiene una promocion de campaña
 * Tambien permite traer las promociones que puedan eistir en Mercado Abierto 
 * @author Alexis Cedillo
 * Este dto contiene:
 * Lista de Ofertas promocionales por campana
 * Lista de Ofertas promocionales por mercado abierto
 * Lista de ofertas por campana
 */
public class SccMxMaeOferCampMaDTO implements Serializable{
	/**
	 * variable serializadora
	 */
	private static final long serialVersionUID = -727651606818975110L;
	/**
	 * Lista de Ofertas de Campana
	 */
	private List<SccMxMaeOferCamDTO> ltSccMxMaeOferCam;
	/**
	 * Lista de Ofertas promociones de campaña
	 */
	private List<SccMxMaeOferPromCamDTO> ltSccMxMaeOferPromCam;
	/**
	 * Lista de Ofertas promocionales por mercado abierto
	 */
	private List<SccMxMaeOferPromMaDTO> ltSccMxMaeOferPromMa;
	/**
	 * Lista de tasas maximas para las ofertas de campaña
	 */
	private List<SccMxPrcOferMaxTasaDTO> ltSccMxPrcOferMaxTasas;
	/**
	 * Lista de plazos maximos para loas ofertas de campaña
	 */
	private SccMxPrcOferMaxPlazoDTO ltSccMxPrcOferMaxPlazos;
	
	
	/**
	 * Constructor super
	 */
	public SccMxMaeOferCampMaDTO() {
		super();
		// Constructor Super
	}
	/**
	 * Contructor con propiedades del objeto
	 * @param ltSccMxMaeOferCam
	 * Lista de ofertas de campana
	 * @param ltSccMxMaeOferPromCam
	 * Lista de Ofertas promocionaes de campana
	 * @param ltSccMxMaeOferPromMa
	 * Lista de Ofertas promocionales de mercado abierto
	 * @param ltSccMxPrcOferMaxTasas
	 * lista ofertas maximas tasas
	 * @param ltSccMxPrcOferMaxPlazos
	 * lista plazos
	 * 
	 */
	public SccMxMaeOferCampMaDTO(List<SccMxMaeOferCamDTO> ltSccMxMaeOferCam, List<SccMxMaeOferPromCamDTO> ltSccMxMaeOferPromCam,
			List<SccMxMaeOferPromMaDTO> ltSccMxMaeOferPromMa, List<SccMxPrcOferMaxTasaDTO> ltSccMxPrcOferMaxTasas, SccMxPrcOferMaxPlazoDTO ltSccMxPrcOferMaxPlazos) {
		super();
		this.ltSccMxMaeOferCam = new ArrayList<>(ltSccMxMaeOferCam);
		this.ltSccMxMaeOferPromCam = new ArrayList<>(ltSccMxMaeOferPromCam);
		this.ltSccMxMaeOferPromMa = new ArrayList<>(ltSccMxMaeOferPromMa);
		this.ltSccMxPrcOferMaxTasas = new ArrayList<>(ltSccMxPrcOferMaxTasas);
		this.ltSccMxPrcOferMaxPlazos = ltSccMxPrcOferMaxPlazos;
	}
	
	/**
	 * Retorno de SccMxMaeOferCamDTO
	 * @return List(SccMxMaeOferCamDTO) Lista de objetos de oferta de campaña
	 */
	public List<SccMxMaeOferCamDTO> getLtSccMxMaeOferCam() {
		return new ArrayList<>(ltSccMxMaeOferCam);
	}
	/**
	 * Retorno de ltSccMxMaeOferCam
	 * @param ltSccMxMaeOferCam List(SccMxMaeOferCamDTO) Lista de objetos de oferta de campaña
	 */
	public void setLtSccMxMaeOferCam(List<SccMxMaeOferCamDTO> ltSccMxMaeOferCam) {
		this.ltSccMxMaeOferCam = new ArrayList<>(ltSccMxMaeOferCam);
	}
	/**
	 * Retorno de SccMxMaeOferPromCamDTO
	 * @return List(SccMxMaeOferCamDTO) Lista de objetos de Ofertas Promocionales por campaña
	 */
	public List<SccMxMaeOferPromCamDTO> getLtSccMxMaeOferPromCam() {
		return new ArrayList<>(ltSccMxMaeOferPromCam);
	}
	/**
	 * 
	 * @param ltSccMxMaeOferPromCam List(SccMxMaeOferPromCamDTO) Lista de objetos de Ofertas Promocionales por campaña
	 */
	public void setLtSccMxMaeOferPromCam(List<SccMxMaeOferPromCamDTO> ltSccMxMaeOferPromCam) {
		this.ltSccMxMaeOferPromCam = new ArrayList<>(ltSccMxMaeOferPromCam);
	}
	/**
	 *  Retorno de SccMxMaeOferPromMaDTO
	 * @return List(SccMxMaeOferPromCamDTO) Lista de objetos de Ofertas Promocionales por Mercado Abierto
	 */
	public List<SccMxMaeOferPromMaDTO> getLtSccMxMaeOferPromMa() {
		return new ArrayList<>(ltSccMxMaeOferPromMa);
	}
	/**
	 * Retorno de ltSccMxMaeOferPromMa
	 * @param ltSccMxMaeOferPromMa List(SccMxMaeOferPromCamDTO) Lista de objetos de Ofertas Promocionales por Mercado Abierto
	 */
	public void setLtSccMxMaeOferPromMa(List<SccMxMaeOferPromMaDTO> ltSccMxMaeOferPromMa) {
		this.ltSccMxMaeOferPromMa = new ArrayList<>(ltSccMxMaeOferPromMa);
	}
	
	/**
	 * @return ltSccMxPrcOferMaxPlazos  plazos maximos de las ofertas de campaña
	 */
	public SccMxPrcOferMaxPlazoDTO getLtSccMxPrcOferMaxPlazos() {
		return ltSccMxPrcOferMaxPlazos;
	}
	/**
	 * @param ltSccMxPrcOferMaxPlazos  plazos maximos de las ofertas de campaña
	 */
	public void setLtSccMxPrcOferMaxPlazos(SccMxPrcOferMaxPlazoDTO ltSccMxPrcOferMaxPlazos) {
		this.ltSccMxPrcOferMaxPlazos = ltSccMxPrcOferMaxPlazos;
	}
	/**
	 * @return ltSccMxPrcOferMaxTasas List(SccMxPrcOferMaxTasaDTO) lista de tasas maximas de las ofertas de campaña
	 */
	public List<SccMxPrcOferMaxTasaDTO> getLtSccMxPrcOferMaxTasas() {
		return new ArrayList<>(ltSccMxPrcOferMaxTasas);
	}
	/**
	 * @param ltSccMxPrcOferMaxTasas List(SccMxPrcOferMaxTasaDTO) lista de tasas maximas de las ofertas de campaña
	 */
	public void setLtSccMxPrcOferMaxTasas(List<SccMxPrcOferMaxTasaDTO> ltSccMxPrcOferMaxTasas) {
		this.ltSccMxPrcOferMaxTasas = new ArrayList<>(ltSccMxPrcOferMaxTasas);
	}
	
	
}
