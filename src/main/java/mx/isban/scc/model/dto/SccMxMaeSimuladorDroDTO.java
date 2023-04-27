package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase DTO Auxiliar para  las consultas
 * de historico de simulaciones 
 * Proporciona las listas que se despliegan en la pantalla
 * de front end para que el usuario elija los filtros
 * del reporte
 * 
 * Sprint 4.1
 * Fecha Septiembre 2019
 * 
 * @author Hitss
 *
 */
public class SccMxMaeSimuladorDroDTO implements Serializable {

	/**
	 * Serializacion de la clase
	 */
	private static final long serialVersionUID = -3676721269603264736L;
	/**
	 * propiedad fecha inicio de la consulta
	 */
	private String fechaIni;
	/**
	 * propiedad fecha Fin de la consulta
	 */
	private String fechaFin;
	/**
	 * propiedad lista de tipo de usuario elegido del filtro de usuarios
	 */
	private List<Long> listaIdTipoUsuario;
	/**
	 * propiedad lista de tipo de perfil elegido del filtro de perfiles
	 */
	private List<Long> listaIdTipoPerfil;
	/**
	 * propiedad lista de IDs de subproductos elegidos de la lista de sub productos
	 */
	private List<Long> listaIdSubProds;
	/**
	 * propiedad lista motivos de rechazo elegidos de la lista de motivos en pantalla
	 */
	private List<Long> listaMotivosRechazo;
	/**
	 * propiedad que indica si aplica simulacion de conversion auto o no
	 */
	private Long convAuto;

	/**
	 * Constructor vacio
	 */
	public SccMxMaeSimuladorDroDTO() {
	}

	/**
	 * Constructor del DTO que recibe todos los parametros
	 * de filtracion de consulta de historico de 
	 * simulaciones
	 * @param fechaIni 
	 * fecha inicial de la consulta
	 * @param fechaFin
	 * fecha fin de la consulta
	 * @param listaIdTipoUsuario
	 * contiene los tipos de usuario a filtrar
	 * @param listaIdTipoPerfil
	 * contiene la lista de tipo de perfil a filtrar
	 * @param listaIdSubProds
	 * la lista de subproductos seleccionados para el filtro, este campo se puede omitir
	 * @param listaMotivosRechazo
	 * Los motivos de rechazo a filtrar
	 * @param convAuto
	 * conversion auto contiene valores para filtrar o no el campo
	 */
	public SccMxMaeSimuladorDroDTO(String fechaIni, String fechaFin, List<Long> listaIdTipoUsuario,
			List<Long> listaIdTipoPerfil, List<Long> listaIdSubProds, List<Long> listaMotivosRechazo, Long convAuto) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.listaIdTipoUsuario = new ArrayList<Long> (listaIdTipoUsuario);
		this.listaIdTipoPerfil = new ArrayList<Long>(listaIdTipoPerfil);
		this.listaIdSubProds = new ArrayList<Long>(listaIdSubProds);
		this.listaMotivosRechazo = new ArrayList<Long>(listaMotivosRechazo);
		this.convAuto = convAuto;
	}

	/**
	 * @return fechaIni Fecha de inicio de la búsqueda
	 */
	public String getFechaIni() {
		return fechaIni;
	}

	/**
	 * @param fechaIni Fecha de inicio de la búsqueda
	 */
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @return fechaFin Fecha de fin de la búsqueda
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin Fecha de fin de la búsqueda
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return listaIdTipoUsuario List(Long) Lista de Id's de tipo de usuario
	 */
	public List<Long> getListaIdTipoUsuario() {
		return new ArrayList<Long>(this.listaIdTipoUsuario);
	}

	/**
	 * @param listaIdTipoUsuario List(Long) Lista de Id's de tipo de usuario
	 */
	public void setListaIdTipoUsuario(List<Long> listaIdTipoUsuario) {
		this.listaIdTipoUsuario = new ArrayList<Long>(listaIdTipoUsuario);
	}

	/**
	 * @return listaIdTipoPerfil List(Long) Lista de Id's de tipo de perfil
	 */
	public List<Long> getListaIdTipoPerfil() {
		return new ArrayList<Long>(this.listaIdTipoPerfil);
	}

	/**
	 * @param listaIdTipoPerfil List(Long) Lista de Id's de tipo de perfil
	 */
	public void setListaIdTipoPerfil(List<Long> listaIdTipoPerfil) {
		this.listaIdTipoPerfil = new ArrayList<Long>(listaIdTipoPerfil);
	}

	/**
	 * @return listaIdSubProds List(Long) Lista de Id's de tipo de subproductos
	 */
	public List<Long> getListaIdSubProds() {
		return new ArrayList<Long>(this.listaIdSubProds);
	}

	/**
	 * @param listaIdSubProds List(Long) Lista de Id's de tipo de subproductos
	 */
	public void setListaIdSubProds(List<Long> listaIdSubProds) {
		this.listaIdSubProds = new ArrayList<Long>(listaIdSubProds);
	}

	/**
	 * @return listaMotivosRechazo List(Long) Lista de Id's de motivos de rechazo
	 */
	public List<Long> getListaMotivosRechazo() {
		return new ArrayList<Long>(this.listaMotivosRechazo);
	}

	/**
	 * @param listaMotivosRechazo List(Long) Lista de Id's de motivos de rechazo
	 */
	public void setListaMotivosRechazo(List<Long> listaMotivosRechazo) {
		this.listaMotivosRechazo = new ArrayList<Long>(listaMotivosRechazo);
	}

	/**
	 * @return convAuto Indicador de conversión auto
	 */
	public Long getConvAuto() {
		return convAuto;
	}

	/**
	 * @param convAuto Indicador de conversión auto
	 */
	public void setConvAuto(Long convAuto) {
		this.convAuto = convAuto;
	}

}
