package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

import mx.isban.scc.utilerias.ValidaNull;

/**
 * 
 * 
 * Se crea DTO para guardar los datos
 * 
 * que se necesitan para generar los archivos de los reportes
 * 
 * Agosto 2019
 * 
 * GlobalHitss
 * 
 * Clase DTO para los generar los reportes
 * 
 * la clase se ecarga de encapsular los datos
 * 
 * para generar los archivos de los reportes
 * 
 * se agregan comentarios para filtros de sonar
 * 
 * SprLong 4
 * 
 * @author Jesus Elygyo Reyes Hurtado
 */
public class ReportesPadreDTO implements Serializable {

	/**
	 * Serializar de la clase
	 */

	public static final ValidaNull oValidaNull = new ValidaNull();
	/**
	 * Serializar de la clase
	 */
	private static final long serialVersionUID = 3910255904173060999L;

	/**
	 * Variable tipo string para guardar el perfil comercial
	 */
	protected String descPerfilComercial;
	/**
	 * Variable tipo string para guardar la descricion del usuario comercial
	 */
	protected String descUsuarioComercial;
	/**
	 * Variable tipo Long para guardar el codigo del cliente
	 */
	protected Long codigoCliente;
	/**
	 * Variable tipo string para guardar el nombre del cliente
	 */
	protected String nombreCliente;
	/**
	 * Variable tipo Double para guardar el monto del credito
	 */
	protected Double montoCredito;
	/**
	 * Variable tipo string para guardar la causa del rechazo
	 */
	protected String causaRechazo;
	/**
	 * Variable tipo DateTime para guardar la fecha de la simulacion
	 */
	protected Date fechaSimulacion;
	/**
	 * Variable tipo string para guardar el sub producto
	 */
	protected String subProducto;

	/**
	 * Regresa el perfil comercial
	 * 
	 * @return descPerfilComercial perfil comercial
	 */
	public String getDescPerfilComercial() {
		return descPerfilComercial;
	}

	/**
	 * Inicializa el perfil comercial
	 * 
	 * @param descPerfilComercial perfil comercial
	 */
	public void setDescPerfilComercial(String descPerfilComercial) {
		this.descPerfilComercial = descPerfilComercial;
	}

	/**
	 * Regresa el usuario comercial
	 * 
	 * @return descUsuarioComercial usuario comercial
	 */
	public String getDescUsuarioComercial() {
		return descUsuarioComercial;
	}

	/**
	 * Inicializa el usuario comercial
	 * 
	 * @param descUsuarioComercial perfil comercial
	 */
	public void setDescUsuarioComercial(String descUsuarioComercial) {
		this.descUsuarioComercial = descUsuarioComercial;
	}

	/**
	 * Regresa el codigo del cliente
	 * 
	 * @return codigoCliente codigo del cliente
	 */
	public Long getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * Inicializa el codigo del cliente
	 * 
	 * @param codigoCliente codigo del cliente
	 */
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * Regresa el nombre del cliente
	 * 
	 * @return nombreCliente nombre del cliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Inicializa el nombre del cliente
	 * 
	 * @param nombreCliente nombre del cliente
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Regresa el monto del credito
	 * 
	 * @return montoCredito monto del credito
	 */
	public Double getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Inicializa el monto del credito
	 * 
	 * @param montoCredito monto del credito
	 */
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Regresa la causa del rechazo
	 * 
	 * @return causaRechazo causa del rechazo
	 */
	public String getCausaRechazo() {
		return causaRechazo;
	}

	/**
	 * Inicializa la causa del rechazo
	 * 
	 * @param causaRechazo causa del rechazo
	 */
	public void setCausaRechazo(String causaRechazo) {
		this.causaRechazo = causaRechazo;
	}

	/**
	 * Regresa la fecha de la simulacion
	 * 
	 * @return fechaSimulacion fecha de la simulacion
	 */
	public Date getFechaSimulacion() {
		return new Date(this.fechaSimulacion.getTime());
	}

	/**
	 * Inicializa la fecha de la simulacion
	 * 
	 * @param fechaSimulacion fecha de la simulacion
	 */
	public void setFechaSimulacion(Date fechaSimulacion) {
		this.fechaSimulacion = new Date(fechaSimulacion.getTime());
	}

	/**
	 * Regresa el nombre del subproducto
	 * 
	 * @return subProducto nombre del subproducto
	 */
	public String getSubProducto() {
		return subProducto;
	}

	/**
	 * Inicializa le subproducto
	 * 
	 * @param subProducto nombre del subproducto
	 */
	public void setSubProducto(String subProducto) {
		this.subProducto = subProducto;
	}

}
